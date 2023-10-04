INSERT INTO person (email,role) VALUES ('kodjo@email.com','owner');
INSERT INTO person (email,role) VALUES ('owner@email.com','user');

INSERT INTO book (isbn,author,title,bookType) VALUES ('isbn1','kodjo','reference');
INSERT INTO book (isbn,author,title,bookType) VALUES ('isbn2','mark','normal');
INSERT INTO book (isbn,author,title,bookType) VALUES ('isbn3','chris',);
INSERT INTO book (isbn,author,title,bookType) VALUES ('isbn4','mathew');



       @Column
        val author: String,

        @Column
        val title: String,

        @Column
        val bookType: String,