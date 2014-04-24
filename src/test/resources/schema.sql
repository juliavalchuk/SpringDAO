CREATE TABLE Book(
    id IDENTITY not null ,
    title varchar(30),
    information varchar(30),
    mortgage double  not null,
    rent double  not null
);

CREATE TABLE Genre(
    id IDENTITY not null,
    name varchar(30) not null
);

CREATE TABLE Writer(
    id IDENTITY not null,
    name varchar(30) not null
);

CREATE TABLE GenresPool(
  id IDENTITY not null,
  book_id int not null,
  genre_id int not null
 -- CONSTRAINT student_cat_pk PRIMARY KEY (student_id, group_id)
);

CREATE TABLE WritersPool(
  id IDENTITY not null,
  book_id int not null,
  writer_id int not null
 -- CONSTRAINT student_cat_pk PRIMARY KEY (student_id, group_id)
);