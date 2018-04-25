  create table member (
  id    char(15) not null,
  pass  char(15) not null,
  name  char(10) not null,
  st_num  char(13) not null,
  hp    char(20)  not null,
  email char(80),
  regist_day char(20),
  level char(10),
  primary key(id)
  );
