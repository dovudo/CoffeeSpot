package com.coffee.backend.Routes

import com.coffee.backend.Models.Items
import com.coffee.backend.Repository.ItemsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


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
class ItemController(@Autowired
                     val itemRepo: ItemsRepository) {

    @GetMapping
    fun getItems(): List<Items> {
        return itemRepo.findAll()
    }

    @PostMapping
    fun saveItem(@RequestBody data: String) {

    }
}