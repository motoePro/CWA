# articles
# --- !Ups
create table articles (
	id	bigint not null,
	title	varchar(255) not null,
	body	text not null,
	release	date not null,
	primary key(id),
);
create sequence articles_seq;
# --- !Downs
drop table articles
