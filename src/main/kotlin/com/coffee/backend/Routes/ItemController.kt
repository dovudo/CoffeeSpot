package com.coffee.backend.Routes

import com.coffee.backend.Models.ItemType
import com.coffee.backend.Models.Items
import com.coffee.backend.Models.OkResponse
import com.coffee.backend.Repository.ItemsRepository
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.core.io.ResourceLoader
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.util.*


/*
/api/items GET - get all items
- application/json
Response:
200
{ id, name, description, price, pic }
{ok:true}

/api/items - POST - add one item
- application/json
Request:
{ ok:true, result:{id, name, description, price, pic} }
Response:
200
{ok:true}

*/
@RestController
class ItemController(@Autowired val itemRepo: ItemsRepository,
                     @Autowired val resource:ResourceLoader,
                     @Autowired val context:ApplicationContext ) {

    @GetMapping("/api/items")
    fun getItems(): List<Items> {
        return itemRepo.findAll()
    }

    @PostMapping("/api/items")
    fun saveItem(@RequestBody jsonItem: String): OkResponse {
        val ss = Gson().fromJson<JsonObject>(jsonItem, JsonObject::class.java)
            val item = Items(-1,
                    ss.get("name").asString,
                    ss.get("description").asString,
                    ItemType.valueOf(ss.get("type").asString),
                    ss.get("price").asInt,
                    ss.get("pic").asString)
        itemRepo.save(item)
        return OkResponse("Item was successfully added")
    }

    @GetMapping("/test/base64")
    fun testDownload(): String? {
        val base = Base64.getEncoder()
        return  base.encodeToString(File("images/pic.jpg").readBytes())
    }
}