package com.atech.plugins

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Welcome to Dictionary API")
        }
        get("word/{word}") {
            try {
                val word = call.parameters["word"]
                val client = HttpClient(CIO) {
                    install(HttpTimeout) {
                        requestTimeoutMillis = 30000 // 10 seconds
                        connectTimeoutMillis = 30000 // 10 seconds
                    }
                }
                println("https://api.dictionaryapi.dev/api/v2/entries/en/$word")
                val response = client.get("https://api.dictionaryapi.dev/api/v2/entries/en/$word")
                val responseBody = response.bodyAsText()
                call.respondText(responseBody, contentType = ContentType.Application.Json)

            } catch (e: Exception) {
                call.respondText(
                    "{\"error\": \"An error occurred\"}",
                    status = HttpStatusCode.InternalServerError,
                    contentType = ContentType.Application.Json
                )
            }
        }
    }
}
