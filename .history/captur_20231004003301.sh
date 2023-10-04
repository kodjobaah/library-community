#!/bin/bash

echo "----- Finding books using the author kodjo ---"
author=$(curl -s http://localhost:8080/findByAuthor/kodjo)

echo "$author"
isbn=$(curl -s http://localhost:8080/findByIsbn/isbn1)
echo "$isbn"

title=$(curl -s http://localhost:8080/findByTitle/title1)
echo "$title"


borrow=$(curl -X POST http://localhost:8080/borrowBook -H "Content-Type: application/json" -d '{"email": "kodjo@email.com", "isbn": "isbn1"')

