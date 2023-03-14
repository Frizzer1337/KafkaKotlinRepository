package com.frizzer.kafka.paymentapi.repository

import com.frizzer.contractapi.entity.CollectorCredit
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface CollectorRepository : ReactiveMongoRepository<CollectorCredit, String>