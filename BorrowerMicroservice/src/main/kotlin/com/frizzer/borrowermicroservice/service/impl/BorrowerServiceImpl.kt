package com.frizzer.borrowermicroservice.service.impl

import com.frizzer.borrowermicroservice.repository.BorrowerRepository
import com.frizzer.borrowermicroservice.service.BorrowerService
import com.frizzer.kafkaapi.entity.Borrower
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class BorrowerServiceImpl(val borrowerRepository: BorrowerRepository) : BorrowerService {
    override fun register(borrower: Borrower?): Mono<Boolean> {
        return borrowerRepository.save(borrower)
    }
}