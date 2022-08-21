create table role
(
    idrole int auto_increment
        primary key,
    role   varchar(45) not null,
    constraint UK_bjxn5ii7v7ygwx39et0wawu0q
        unique (role)
);

create table if not exists user
(
    id_user           int auto_increment
        primary key,
    surname           varchar(25)   not null,
    email             varchar(50)   not null,
    country           varchar(56)   not null,
    city              varchar(45)   not null,
    address           varchar(45)   not null,
    role_idrole       int default 1 not null,
    password          varchar(255)  not null,
    login             varchar(45)   not null,
    document_id       varchar(255)  not null,
    phone_number      varchar(255)  not null,
    zip_code          varchar(255)  not null,
    username          varchar(25)   not null,
    active            bit           not null,
    photos_image_path varchar(64)   null,
    constraint fk_user_role
        foreign key (role_idrole) references role (idrole)
);

create index fk_user_role_idx
    on user (role_idrole);

--insert user
INSERT INTO user(id_user,surname, email,country, city,address,role_idrole,password,login,document_id,
phone_number,zip_code,username,active,photos_image_path) values (1,"Mateusz", "Krzak", "blabla@gmai.com",
                "432321423213", "Polska","Krakow",
                "Trapackiego", "123123", "123123123",
                "sfafsafas","matikrzak");