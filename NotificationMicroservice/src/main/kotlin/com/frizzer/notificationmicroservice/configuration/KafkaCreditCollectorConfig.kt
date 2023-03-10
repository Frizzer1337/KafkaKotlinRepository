package com.frizzer.notificationmicroservice.configuration

import com.frizzer.kafkaapi.entity.CollectorEvent
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.support.serializer.JsonDeserializer
import reactor.kafka.receiver.KafkaReceiver
import reactor.kafka.receiver.ReceiverOptions

@Configuration
class KafkaCreditCollectorConfig {
    private lateinit var receiverOptions: ReceiverOptions<String, CollectorEvent>

    @Value(value = "\${kafka.bootstrapAddress}")
    private val bootstrapAddress: String? = null

    @Value(value = "\${group.id}")
    private val groupId: String? = null

    @Value(value = "\${topic.approve}")
    private val topic: String? = null

    @Bean
    fun kafkaCreditCollectorConsumerFactoryTemplate(): KafkaReceiver<String, CollectorEvent> {
        val props: MutableMap<String, Any?> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddress
        props[ConsumerConfig.GROUP_ID_CONFIG] = groupId
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class.java
        receiverOptions = ReceiverOptions.create(props)
        receiverOptions = receiverOptions.withValueDeserializer(JsonDeserializer(CollectorEvent::class.java))
        receiverOptions = receiverOptions.subscription(setOf(topic))
        return KafkaReceiver.create(receiverOptions)
    }
}