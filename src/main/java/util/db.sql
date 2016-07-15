create database toko;
use toko;
create table barang(kode varchar(25)primary key,nm varchar(20)not null,satuan varchar(15)not null,hrg bigint not null,stok float not null,deleted boolean not null);