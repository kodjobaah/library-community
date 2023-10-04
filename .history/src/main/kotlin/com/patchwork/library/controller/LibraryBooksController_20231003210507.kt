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
    fun findbyTitle(@PathVariable title: String) = 
        bookService.findbyTitle(title)    

    @GetMapping("/findbyIsbn/{isbn}")
    fun findByAuthor(@PathVariable isbn: String) = 
        bookService.findbyIsbn(isbn)    
    
}