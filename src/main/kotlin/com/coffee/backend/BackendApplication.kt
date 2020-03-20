package com.coffee.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackendApplication

fun main(args: Array<String>) {
    val OS = System.getProperty("os.name").toLowerCase()
    runApplication<BackendApplication>(*args)
}
