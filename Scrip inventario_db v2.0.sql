Create database inventario_db;
use inventario_db;

create table usuario(
id_usu int primary key not null,
username varchar (25) not null,
password varchar (25) not null
);

Create table cargo(
id_carg int primary key not null,
nombre varchar (25) not null
);

Create table empleado(
id_empl int primary key not null,
nombre_compl varchar (50) not null,
cedula varchar (30) unique not null,
telefono int not null,
email varchar (50) not null,
salario bigint not null,
usuario int not null,
cargo int not null,
constraint usuario_empleado_fk foreign key (usuario) references usuario (id_usu),
constraint cargo_empleado_fk foreign key (cargo) references cargo (id_carg)
);

create table bitacora(
id_bitac int primary key not null,
año varchar (50) not null,
area varchar (50) not null,
empleado int not null,
constraint empleado_bitacora_fk foreign key (empleado) references empleado (id_empl)
);

create table producto(
id_prod int primary key not null,
descripcion varchar (200) not null,
numero_serie bigint not null,
precio bigint not null
);

Create table inventario(
id_invt int primary key not null,
bitacora int not null,
producto int not null,
cantidad bigint not null,
constraint bitacora_inventario_fk foreign key (bitacora) references bitacora (id_bitac),
constraint producto_inventario_fk foreign key (producto) references producto (id_prod)
);