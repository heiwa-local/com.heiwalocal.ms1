package com.heiwalocal.models

import kotlinx.serialization.Serializable

val customerStorage = mutableListOf<Customer>(
    Customer("1","Vadim","Bukhtiyarov", "kunari0249@gmail.com")
)
val jwtStorage = mutableListOf<String>(
    "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJodHRwOi8vMC4wLjAuMDo4MDgwL2hlbGxvIiwiaXNzIjoiaHR0cDovLzAuMC4wLjA6ODA4MC8iLCJleHAiOjE2NzEwMTU5MTUsInVzZXJuYW1lIjoiVXNlciJ9.p-ETYCSNW551OTCW-FHAL2Vg_LxJxlQR2anuzOLHGCs"
)

@Serializable
data class Customer(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String
)
