# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table leitura (
  id                        bigint not null,
  pressao_at                float,
  temperatura               float,
  umidade                   float,
  distancia                 float,
  constraint pk_leitura primary key (id))
;

create sequence leitura_seq;




# --- !Downs

drop table if exists leitura cascade;

drop sequence if exists leitura_seq;

