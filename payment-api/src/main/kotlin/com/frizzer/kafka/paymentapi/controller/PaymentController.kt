package com.frizzer.kafka.paymentapi.controller

import com.frizzer.kafka.paymentapi.service.impl.CreditServiceImpl
import com.frizzer.contractapi.entity.Credit
import com.frizzer.contractapi.entity.Payment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/payment")
class PaymentController(private val creditService: CreditServiceImpl) {

    @PostMapping("/pay")
    fun register(@RequestBody payment: Payment): ResponseEntity<Mono<Credit>> {
        return ResponseEntity.ok(creditService.payAndSavePayment(payment))
    }
}