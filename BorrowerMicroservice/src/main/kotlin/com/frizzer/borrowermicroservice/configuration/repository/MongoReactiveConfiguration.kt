package com.frizzer.borrowermicroservice.configuration.repository

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration


@Configuration
open class MongoReactiveConfiguration : AbstractReactiveMongoConfiguration() {

    @Value(value = "\${spring.data.mongodb.database}")
    private val databaseName: String = ""

    override fun getDatabaseName(): String {
        return databaseName
    }

    override fun reactiveMongoClient(): MongoClient {
        return MongoClients.create()
    }

}
