drop table if exists user;
create table user(
    id bigint(20) not null comment '主键ID',
    name varchar(30) null default null comment '姓名',
    age int(11) null default null comment '年龄',
    email varchar(50) null default null comment '邮箱',
    primary key (id)
);

insert into user(id, name, age, email) values
(1,'Jone', 18, 'test1@baomidou,com'),
(2,'Jack', 20, 'test2@baomidou,com'),
(3,'Tom', 28, 'test3@baomidou,com'),
(4,'Sandy', 21, 'test4@baomidou,com'),
(5,'Billie', 24, 'test5@baomidou,com');



alter table user add column create_time timestamp NULL DEFAULT NULL COMMENT '创建时间';
alter table user add column update_time timestamp NULL DEFAULT NULL COMMENT '最后修改时间';
