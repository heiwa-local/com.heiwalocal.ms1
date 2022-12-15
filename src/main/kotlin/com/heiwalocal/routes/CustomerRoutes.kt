package com.heiwalocal.routes

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.heiwalocal.models.customerStorage
import com.heiwalocal.models.jwtStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

fun Route.customerRouting() {

    route("/customer{token?}") {
        get {
            if (customerStorage.isNotEmpty()) {
                call.respond(customerStorage)
            } else {
                call.respondText("No customers found", status = HttpStatusCode.OK)
            }
        }
    }
}