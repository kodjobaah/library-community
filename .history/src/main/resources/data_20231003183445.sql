INSERT INTO person (email,role) VALUES ('kodjo@email.com','OWNER');
INSERT INTO person (email,role) VALUES ('owner@email.com','user');

INSERT INTO book (isbn,author,title,bookType) VALUES ('isbn1','kodjo','reference');
INSERT INTO book (isbn,author,title,bookType) VALUES ('isbn2','mark','normal');
INSERT INTO book (isbn,author,title,bookType) VALUES ('isbn3','chris', 'normal');
INSERT INTO book (isbn,author,title,bookType) VALUES ('isbn4','mathew', 'nomal');



       @Column
        val author: String,

        @Column
        val title: String,

        @Column
        val bookType: String,