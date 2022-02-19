create table if not exists account(
    id serial primary key,
    username varchar(255),
    password varchar(255)
);

create table if not exists posts(
    id serial primary key ,
    account_id integer,
    description text,
    constraint ac_fk foreign key (account_id)references account(id)
);

create table if not exists comment(
    id serial primary key ,
    account_id integer,
    post_id integer,
    description varchar(255),
    constraint ac_cm_fk foreign key (account_id) references account(id),
    constraint po_cm_fk foreign key (post_id) references posts(id)
);
