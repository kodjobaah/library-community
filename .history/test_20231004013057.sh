#!/bin/bash

echo "----- Finding books using the author kodjo ---"
author=$(curl -s http://localhost:8080/findByAuthor/kodjo)
echo "$author"
echo ""
echo "----- Finding books using the author kodjo ---"
author=$(curl -s http://localhost:8080/findByAuthor/mathew)
echo "$author"
echo ""
echo "----- Finding books using isbn1  ---"
isbn=$(curl -s http://localhost:8080/findByIsbn/isbn1)
echo "$isbn"
echo ""
echo "----- Finding books using isbn2  ---"
isbn=$(curl -s http://localhost:8080/findByIsbn/isbn2)
echo "$isbn"
echo ""
echo "----- Finding books using title1  ---"
title=$(curl -s http://localhost:8080/findByTitle/title1)
echo "$title"
echo ""
echo "----- Finding books using title2  ---"
title=$(curl -s http://localhost:8080/findByTitle/title2)
echo "$title"

echo ""
echo "----- Trying to borrow a reference book  ---"
borrow=$(curl -s -X POST http://localhost:8080/borrowBook -H "Content-Type: application/json" -d '{"email": "kodjo@email.com", "isbn": "isbn1"}')
echo "$borrow"
echo ""
echo "----- Borrowing book with isbn2  ---"
borrow=$(curl -s -X POST http://localhost:8080/borrowBook -H "Content-Type: application/json" -d '{"email": "kodjo@email.com", "isbn": "isbn2"}')
echo "$borrow"
echo ""
echo "----- Trying to borrow the same book again. ---"
borrow=$(curl -s -X POST http://localhost:8080/borrowBook -H "Content-Type: application/json" -d '{"email": "kodjo@email.com", "isbn": "isbn2"}')
echo "$borrow"
echo ""
echo "----- Borrowing another book with isbn3  ---"
borrow=$(curl -s -X POST http://localhost:8080/borrowBook -H "Content-Type: application/json" -d '{"email": "kodjo@email.com", "isbn": "isbn3"}')
echo "$borrow"

echo ""
echo "----- Getting list of all borrowed books. ---"
borrow=$(curl  -s http://localhost:8080/borrowedBooks)
echo "$borrow"


