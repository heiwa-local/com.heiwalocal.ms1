package com.heiwalocal

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import kotlin.test.*
import io.ktor.server.testing.*
import com.heiwalocal.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class ApplicationTest {
    @Test
    fun testToken() = testApplication {
        val response = client.get("/token")
        assertEquals(HttpStatusCode.OK, response.status)
    }
    @Test
    fun testCustomer() = testApplication {
        val response = client.get("/customer")
        assertEquals(HttpStatusCode.BadGateway, response.status)
    }
}