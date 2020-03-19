package com.coffee.backend.Routes

import com.coffee.backend.Models.OkResponse
import javassist.NotFoundException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.util.*

@RestController
class ImageController(@Autowired val resources:ResourceLoader){

    val log = LoggerFactory.getLogger("ImageController")
    @GetMapping("/api/image/all")
    fun getTestImage(): MutableSet<Resource> {
        val set: MutableSet<Resource> = mutableSetOf<Resource>()
        //TODO find the right path
        println(File("classpath:images/").list())
        File("images/").walk().forEach {
            println(it.path)
            set.add(resources.getResource("classpath:images/$it.name"))
        }
     return set
    }

    @GetMapping("/api/image/{img}")
    fun getOneImage(@PathVariable("img") img:String): Resource {
        val filePath = "classpath:images/$img"
        log.info("Get file: " + File(filePath).isFile.toString())
        if (!resources.getResource(filePath).isFile || filePath.isEmpty())
            throw NotFoundException("Image $img not found or null")
        return resources.getResource(filePath)
    }


    //TODO path????????
    @PostMapping("/api/image")
    fun uploadPics(@RequestParam image: MultipartFile): OkResponse {
        if(image.isEmpty)
            return OkResponse("File is empty")
        val uuid = UUID.randomUUID()
        val path = File("")
        log.debug(path.path)
        val file = image.transferTo(path)
        return OkResponse(uuid.toString())
    }
}