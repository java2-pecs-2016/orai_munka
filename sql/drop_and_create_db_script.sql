
    drop table JAVA_A_GYAKORLATBAN.book cascade constraints;

    drop sequence JAVA_A_GYAKORLATBAN.book_seq;

    create table JAVA_A_GYAKORLATBAN.book (
        id number(19,0) not null,
        author varchar2(200 char),
        description varchar2(2000 char),
        pub_year number(10,0),
        title varchar2(200 char),
        primary key (id)
    );

    create sequence JAVA_A_GYAKORLATBAN.book_seq;
