use `carbook`

drop table if exists `project`;
drop table if exists `image`;

create table project(
    id int not null auto_increment,
    name varchar(255) not null,
    createdDate Date,
    foreign key (car_profile_id) references carprofile(id)
);

create table image(
    id int not null auto_increment,
    path varchar(255) not null,
    foreign key (project_id) references project(id)
);