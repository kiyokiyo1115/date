drop table if exists date;

create table if not exists date (
  id varchar(32) not null,
  name varchar(32) ,
  year int(4) ,
  month int(4) ,
  day int(4) ,
  primary key (id)
);