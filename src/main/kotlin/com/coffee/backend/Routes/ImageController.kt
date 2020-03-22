package com.coffee.backend.Routes

import com.coffee.backend.Models.OkResponse
import javassist.NotFoundException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.util.*

@RestController
class ImageController(@Autowired val resources:ResourceLoader){

    val log = LoggerFactory.getLogger("ImageController")


    @GetMapping("/storage/images")
    fun getTestImage(): OkResponse {
        val set = mutableListOf<Resource>()
        File("./src/main/resources/images/").walk().forEach {
            log.debug(it.canonicalPath)
            if(it.isFile)
            set.add(resources.getResource("file:${it.absolutePath}"))
    }
        //TODO Find way for send all images
     return OkResponse("Ok")
    }

    //TODO create ext checker and switch content-type of pictures
    @GetMapping("/storage/image/{img}")
    @ResponseBody
    fun getOneImageHeader(@PathVariable("img") img:String): ResponseEntity<Resource> {
        val filePath = File("./src/main/resources/images/$img")
        val header = HttpHeaders()
        if (!filePath.isFile || filePath.isDirectory)
            throw NotFoundException("Image $img not found or null")
        header.add("Content-Type", "image/jpg")
        val res = resources.getResource("file:${filePath.absolutePath}")
        return ResponseEntity(res, header, HttpStatus.OK)
    }

    @PostMapping("/storage/image")
    fun uploadPics(@RequestParam image: MultipartFile): OkResponse {
        if(image.isEmpty)
            throw IllegalArgumentException("Image is empty")
        val uuid = UUID.randomUUID()
        val path = File("./src/main/resources/images/$uuid${image.originalFilename}" )
        log.info("Added new file " + path.name)
        image.transferTo(path.absoluteFile)
        return OkResponse(uuid.toString())
    }
}