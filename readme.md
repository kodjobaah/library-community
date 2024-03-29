# Book-Lending Library


Stories:
- As a library user, I would like to be able to find books by my favourite author, so that I know if they are available in the library.
- As a library user, I would like to be able to find books by title, so that I know if they are available in the library.
- As a library user, I would like to be able to find books by ISBN, so that I know if they are available in the library.
- As a library user, I would like to be able to borrow a book, so I can read it at home.
- As the library owner, I would like to know how many books are being borrowed, so I can see how many are outstanding.
- As a library user, I should be to prevented from borrowing reference books, so that they are always available.

## Installation
When the application starts up the h2 database is initialized with the following data:
[data.sql](./src/main/resources/data.sql )

## Setup
To run the application 
```sh
mvn spring-boot:run
```

## Test
To run the unit test:
```sh
mvn test
```

The follwing file contains the test [test.sh](./test.sh) 
Below are the contents:

```sh
INSERT INTO person (email,role) VALUES ('kodjo@email.com','USER');
INSERT INTO person (email,role) VALUES ('owner@email.com','OWNER');

INSERT INTO book (isbn,author,title,book_type) VALUES ('isbn1','kodjo','title1','REFERENCE');
INSERT INTO book (isbn,author,title,book_type) VALUES ('isbn5','kodjo','title2','NORMAL');
INSERT INTO book (isbn,author,title,book_type) VALUES ('isbn2','mark','title2','NORMAL');
INSERT INTO book (isbn,author,title,book_type) VALUES ('isbn3','chris','title3', 'NORMAL');
INSERT INTO book (isbn,author,title,book_type) VALUES ('isbn4','mathew','title4', 'NORMAL');

```

Output from running the tests
```sh
  library ./test.sh          
----- Finding books using the author kodjo ---
[{"isbn":"isbn1","author":"kodjo","title":"title1","availability":"AVAILABLE"},{"isbn":"isbn5","author":"kodjo","title":"title2","availability":"AVAILABLE"}]

----- Finding books using the author kodjo ---
[{"isbn":"isbn4","author":"mathew","title":"title4","availability":"AVAILABLE"}]

----- Finding books using isbn1  ---
[{"isbn":"isbn1","author":"kodjo","title":"title1","availability":"AVAILABLE"}]

----- Finding books using isbn2  ---
[{"isbn":"isbn2","author":"mark","title":"title2","availability":"AVAILABLE"}]

----- Finding books using title1  ---
[{"isbn":"isbn1","author":"kodjo","title":"title1","availability":"AVAILABLE"}]

----- Finding books using title2  ---
[{"isbn":"isbn5","author":"kodjo","title":"title2","availability":"AVAILABLE"},{"isbn":"isbn2","author":"mark","title":"title2","availability":"AVAILABLE"}]

----- Trying to borrow a reference book  ---
{"status":401,"message":"The book can not be borrowed it is only for reference purposes BorrowBook(email=kodjo@email.com, isbn=isbn1)"}

----- Borrowing book with isbn2 for kodjo@email.com ---
{"email":"kodjo@email.com","books":[{"isbn":"isbn2","author":"mark","title":"title2","bookType":"NORMAL","borrower":{"email":"kodjo@email.com","role":"USER"}}]}

----- Trying to borrow the same book again. ---
{"status":401,"message":"Some one has already borrowed this book BorrowBook(email=kodjo@email.com, isbn=isbn2)"}

----- Borrowing another book with isbn3 for kodjo@email.com ---
{"email":"kodjo@email.com","books":[{"isbn":"isbn2","author":"mark","title":"title2","bookType":"NORMAL","borrower":{"email":"kodjo@email.com","role":"USER"}},{"isbn":"isbn3","author":"chris","title":"title3","bookType":"NORMAL","borrower":{"email":"kodjo@email.com","role":"USER"}}]}

----- Getting list books borrowed by the user kodjo@email.com  ---
{"email":"kodjo@email.com","books":[{"isbn":"isbn2","author":"mark","title":"title2","bookType":"NORMAL","borrower":{"email":"kodjo@email.com","role":"USER"}},{"isbn":"isbn3","author":"chris","title":"title3","bookType":"NORMAL","borrower":{"email":"kodjo@email.com","role":"USER"}}]}

----- Borrowing another book with isbn4 for user owner@email.com  ---
{"email":"owner@email.com","books":[{"isbn":"isbn4","author":"mathew","title":"title4","bookType":"NORMAL","borrower":{"email":"owner@email.com","role":"OWNER"}}]}

----- Getting list books borrowed by the user kodjo@email.com  ---
{"email":"owner@email.com","books":[{"isbn":"isbn4","author":"mathew","title":"title4","bookType":"NORMAL","borrower":{"email":"owner@email.com","role":"OWNER"}}]}

----- Getting list of all borrowed books. ---
[{"isbn":"isbn2","author":"mark","title":"title2","availability":"UNAVAILABLE"},{"isbn":"isbn3","author":"chris","title":"title3","availability":"UNAVAILABLE"},{"isbn":"isbn4","author":"mathew","title":"title4","availability":"UNAVAILABLE"}]
➜  library 


```
