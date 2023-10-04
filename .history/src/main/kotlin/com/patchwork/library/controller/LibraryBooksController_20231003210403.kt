package com.patchwork.library.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import com.patchwork.library.service.BookService

@RestController
class LibraryBookController {

    @Autowired
	lateinit var bookService: BookService

    @GetMapping("/findbyAuthor/{author}")
	fun findByAuthor(@PathVariable author: String) = 
        bookService.findByAuthor(author)

    
    @GetMapping("/findbyTitle/{title}")
    fun findByAuthor(@PathVariable title: String) = 
        bookService.findByAuthor(author)    

    @GetMapping("/findbyAuthor/{author}")
    fun findByAuthor(@PathVariable author: String) = 
        bookService.findByAuthor(author)    
    
    @GetMapping("/")
    fun index() = "Hello, name!"
}