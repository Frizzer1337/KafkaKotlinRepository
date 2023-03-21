package com.frizzer.contractapi.entity.client

data class Client(
    var id: String,
    var name: String,
    var surname: String,
    var phone: String,
    var salary: Int,
    var socialCredit: Double
)

fun Client.toDto() = ClientDto(
    id = id,
    name = name,
    surname = surname,
    phone = phone,
    salary = salary,
    socialCredit = socialCredit
)
