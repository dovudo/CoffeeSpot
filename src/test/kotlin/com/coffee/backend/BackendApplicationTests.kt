package com.coffee.backend

import org.junit.jupiter.api.Test
import java.io.File


class BackendApplicationTests {

    @Test
    fun contextLoads() {
    }

    @Test
    fun getPathByFile() {
        println("File size: " + File("/"))
    }
}
