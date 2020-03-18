package com.coffee.backend.Routes

import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.io.File

@RestController
class ImageController(@Autowired val resources:ResourceLoader){

    @GetMapping("/data/test")
    fun getTestImage(){

    }

    @GetMapping("/data/{img}")
    fun getOneImage(@PathVariable("img") img:String): Resource {
        val filePath = "classpath:images/$img"
        if (File(filePath).isFile || filePath.isEmpty())
            throw NotFoundException("Image $img not found or null")
        return resources.getResource(filePath)
    }
}