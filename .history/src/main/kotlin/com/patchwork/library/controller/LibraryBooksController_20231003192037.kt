package com.patchwork.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import com.patchwork.library.service.BookService

@RestController
class LibraryBookController {

    @Autowired
	lateinit var bookService: BookService

    @RequestMapping("/findbyAuthor/{author}")
	fun findById(@PathVariable author: String) =
			"hello"

    @GetMapping("/")
    fun index(@RequestParam("name") name: String) = "Hello, $name!"
}