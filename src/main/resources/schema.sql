create table actor
(
    actor_id number auto_increment
        primary key,
    first_name varchar(45) not null,
    last_name varchar(45) not null,
    last_update timestamp default current_timestamp() on update current_timestamp() not null
);


create index idx_actor_last_name
	on actor (last_name);
