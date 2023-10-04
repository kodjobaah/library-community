INSERT INTO person (email,role) VALUES ('kodjo@email.com','owner');
INSERT INTO person (email,role) VALUES ('owner@email.com','user');

INSERT INTO book (isbn,author,title,bookType) VALUES ('isbn1','kodjo');
INSERT INTO book (isbn,author,title,bookType) VALUES ('isbn2','user');
INSERT INTO book (isbn,author,title,bookType) VALUES ('isbn3','owner');
INSERT INTO book (isbn,author,title,bookType) VALUES ('isbn4','user');



       @Column
        val author: String,

        @Column
        val title: String,

        @Column
        val bookType: String,