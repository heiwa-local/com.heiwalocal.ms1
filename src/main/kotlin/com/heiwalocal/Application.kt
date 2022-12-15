package com.heiwalocal

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.heiwalocal.models.Customer
import com.heiwalocal.models.User
import com.heiwalocal.models.jwtStorage
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.heiwalocal.plugins.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import mjs.ktor.features.zipkin.ZipkinIds
import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module() {
    configureRouting()
    configureSerialization()
    configureMicrometerMetrics()

    val myRealm = environment.config.property("jwt.realm").getString()
    install(Authentication) {
        jwt("auth-jwt") {
            realm = myRealm
        }
    }

    val secret = environment.config.property("jwt.secret").getString()
    val issuer = environment.config.property("jwt.issuer").getString()
    val audience = environment.config.property("jwt.audience").getString()

    routing {
        get("/token") {
            val header = hashMapOf("k" to "and0X3NlY3JldGU")
            val token = JWT.create()
                .withAudience(audience)
                .withIssuer(issuer)
                .withClaim("username", "User")
                .withHeader(header as Map<String, Any>?)
                .withKeyId("sim2")
                .withExpiresAt(Date(System.currentTimeMillis() + 60000))
                .sign(Algorithm.HMAC256(secret))

            jwtStorage.add(token)
            println(token)
            call.respond(hashMapOf("token" to token))
        }
    }
}
