package com.frizzer.contractapi.entity.credit

data class Credit(
    var id: String,
    var lastPaymentDate: String,
    var creditBalance: Int,
    var penalty: Int,
    var clientId: String,
    var creditStatus: CreditStatus
)

fun Credit.toDto() = CreditDto(
    id = id,
    lastPaymentDate = lastPaymentDate,
    creditBalance = creditBalance,
    penalty = penalty,
    clientId = clientId,
    creditStatus = creditStatus
)
