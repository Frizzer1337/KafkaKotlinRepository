package com.frizzer.borrowermicroservice.service.impl

import com.frizzer.borrowermicroservice.repository.CreditRepository
import com.frizzer.borrowermicroservice.service.CreditService
import com.frizzer.kafkaapi.entity.Credit
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono


@Service
class CreditServiceImpl(
    private val creditRepository: CreditRepository,
    private val kafkaTemplate: ReactiveKafkaProducerTemplate<String, Credit>
) : CreditService {
    private val log = LoggerFactory.getLogger(CreditServiceImpl::class.java)

    override fun takeCredit(credit: Credit): Mono<Credit> {
        return creditRepository
            .save(credit)
            .flatMap {
                kafkaTemplate
                    .send("CREDIT_APPROVE", it)
                    .doOnSuccess { result ->
                        log.info("sent {} offset: {}", credit, result.recordMetadata().offset())
                    }
                    .thenReturn(it)
            }
    }


}
