create table employee(
    employee_id serial,
    name varchar(255),
    email varchar(255),

    constraint pk_employee_employee_id primary key(employee_id)
);

create table project(
    project_id serial,
    project_date date,
    name varchar(255),
    location varchar(255 ),

    constraint pk_project_project_id primary key(project_id)
);

create table project_employee(
    projemp_id serial not null,
    employee_id int not null,
    project_id int not null,

    constraint pk_project_employee_projemp_id primary key(projemp_id),
    constraint fk_project_employee_employee_id foreign key (employee_id) references employee(employee_id),
    constraint fk_project_employee_project_id foreign key (project_id) references project(project_id)
);