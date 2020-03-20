package com.coffee.backend

import com.coffee.backend.Models.ItemType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File


class BackendApplicationTests {

    @Test
    fun contextLoads() {
    }

    @Test
    fun getPathByFile() {
        println("File path: " + File("./").absolutePath)
    }

    @Test
    fun enumCheck(){
        assertEquals(ItemType.valueOf("COFFEE").toString(), "COFFEE")
    }

    @Test
    fun enumPrint(){
        println(ItemType.valueOf("COFFEE"))
    }
}
