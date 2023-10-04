#!/bin/bash

echo "----- Finding books using the author kodjo ---"
author=$(curl -s http://localhost:8080/findByAuthor/kodjo)
echo "$author"
echo ""
echo ""
echo "----- Finding books using the author kodjo ---"
author=$(curl -s http://localhost:8080/findByAuthor/mathew)
echo "$author"

echo "----- Finding books using isbn1  ---"
isbn=$(curl -s http://localhost:8080/findByIsbn/isbn1)
echo "$isbn"

echo "----- Finding books using isbn2  ---"
isbn=$(curl -s http://localhost:8080/findByIsbn/isbn2)
echo "$isbn"

echo "----- Finding books using title1  ---"
title=$(curl -s http://localhost:8080/findByTitle/title1)
echo "$title"

echo "----- Finding books using title2  ---"
title=$(curl -s http://localhost:8080/findByTitle/title2)
echo "$title"


borrow=$(curl -X POST http://localhost:8080/borrowBook -H "Content-Type: application/json" -d '{"email": "kodjo@email.com", "isbn": "isbn1"')

