# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table leitura (
  id                        bigint not null,
  pressao_at                double,
  temperatura               double,
  umidade                   double,
  distancia                 double,
  constraint pk_leitura primary key (id))
;

create sequence leitura_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists leitura;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists leitura_seq;

