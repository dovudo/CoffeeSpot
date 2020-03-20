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
    fun getTestImage(): OkResponse {
        val set = mutableListOf<Resource>()
        //TODO find the right path
        File("./src/main/resources/images/").walk().forEach {
            println(it.canonicalPath)
            if(it.isFile)
                set.add(resources.getResource("file:${it.absolutePath}"))
        }
     return OkResponse("Ok")
    }

    @GetMapping("/api/image/{img}")
    fun getOneImage(@PathVariable("img") img:String): Resource {
        val filePath = File("./src/main/resources/images/$img")
        if (!filePath.isFile || filePath.isDirectory)
            throw NotFoundException("Image $img not found or null")
        return resources.getResource("file:" + filePath.absolutePath)
    }

    //TODO path????????
    @PostMapping("/api/image")
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