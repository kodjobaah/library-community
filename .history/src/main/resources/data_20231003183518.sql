INSERT INTO person (email,role) VALUES ('kodjo@email.com','OWNER');
INSERT INTO person (email,role) VALUES ('owner@email.com','USER');

INSERT INTO book (isbn,author,title,bookType) VALUES ('isbn1','kodjo','REFERENCE');
INSERT INTO book (isbn,author,title,bookType) VALUES ('isbn2','mark','normal');
INSERT INTO book (isbn,author,title,bookType) VALUES ('isbn3','chris', 'normal');
INSERT INTO book (isbn,author,title,bookType) VALUES ('isbn4','mathew', 'nomal');


REFERENCE, NORMAL
       @Column
        val author: String,

        @Column
        val title: String,

        @Column
        val bookType: String,