package com.coffee.backend

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAdminServer
class BackendApplication

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}
