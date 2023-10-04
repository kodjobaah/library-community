package com.patchwork.library.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import com.patchwork.library.service.BookService

@RestController
class LibraryBookController {

    @Autowired
	lateinit var bookService: BookService

    @GetMapping("/findByAuthor/{author}")
	fun findByAuthor(@PathVariable author: String) = 
        bookService.findByAuthor(author)

    @GetMapping("/findByTitle/{title}")
    fun findByTitle(@PathVariable title: String) = 
        bookService.findByTitle(title)    

    @GetMapping("/findByIsbn/{isbn}")
    fun findByIsbn(@PathVariable isbn: String) = 
        bookService.findByIsbn(isbn)    

    @PostMapping(“/borrowBook”)
    fun borrowBook(@RequestBody student:Student): List<Student>{

    return studentsRepo.addStudent(student)
}
    
}