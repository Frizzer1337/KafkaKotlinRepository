package com.frizzer.borrowerapi.controller


import com.frizzer.borrowerapi.service.BorrowerService
import com.frizzer.borrowerapi.service.CreditService
import com.frizzer.contractapi.entity.borrower.Borrower
import com.frizzer.contractapi.entity.credit.Credit
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/borrower")
class BorrowerController(
    private val borrowerService: BorrowerService,
    private val creditService: CreditService
) {

    @PostMapping("/register")
    fun register(@RequestBody borrower: Borrower): ResponseEntity<Mono<Borrower>> {
        return ResponseEntity.ok(borrowerService.register(borrower))
    }

    @PostMapping("/takeCredit")
    fun takeCredit(@RequestBody credit: Credit): ResponseEntity<Mono<Credit>> {
        return ResponseEntity.ok(creditService.takeCredit(credit))
    }
}