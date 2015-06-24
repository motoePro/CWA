# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table accounts (
  id                        bigint not null,
  username                  varchar(255),
  password                  varchar(255),
  constraint pk_accounts primary key (id))
;

create sequence accounts_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists accounts;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists accounts_seq;

