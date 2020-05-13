package com.coffee.backend

import com.coffee.backend.Models.ItemType
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class BackendApplicationTests {

   @Test
    fun getPathByFile() {
        println("File path: " + File("./").absolutePath)
    }

    @Test
    fun enumCheck(){
        assertEquals(ItemType.valueOf("COFFEE").toString(), "COFFEE")
    }

    @Test
    fun gsonSetTest(){
        val items: MutableSet<Int> = mutableSetOf(2,3,13,123,44,221)
        val json = Gson().toJson(items)
        println("Before: $json")
        val intType = object:TypeToken<Set<Int>>(){}.type
        val ss = Gson().fromJson<Set<Int>>(json, intType)
        println("After: $ss")
        assertEquals(items, ss)
    }
}
