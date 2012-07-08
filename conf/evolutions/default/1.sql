# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table album (
  id                        bigint not null,
  band_id                   bigint,
  name                      varchar(255),
  style_name                varchar(255),
  constraint pk_album primary key (id))
;

create table announce (
  id                        bigint not null,
  name                      varchar(255),
  text_brief                clob,
  text_full                 clob,
  post_date                 timestamp,
  action_date               timestamp,
  action_end_date           timestamp,
  user_id                   bigint,
  published                 boolean,
  last_updated              timestamp,
  first_comment_id          bigint,
  constraint pk_announce primary key (id))
;

create table article (
  id                        bigint not null,
  name                      varchar(255),
  text                      clob,
  post_date                 timestamp,
  user_id                   bigint,
  author                    varchar(255),
  published                 boolean,
  last_updated              timestamp,
  first_comment_id          bigint,
  constraint pk_article primary key (id))
;

create table band (
  id                        bigint not null,
  name                      varchar(255),
  origin                    varchar(255),
  constraint pk_band primary key (id))
;

create table banner (
  id                        bigint not null,
  text                      varchar(255),
  constraint pk_banner primary key (id))
;

create table comment (
  id                        bigint not null,
  parent_id                 bigint,
  login                     varchar(255),
  member                    boolean,
  text                      clob,
  post_date                 timestamp,
  constraint pk_comment primary key (id))
;

create table contact (
  id                        bigint not null,
  name                      varchar(255),
  phone                     varchar(255),
  mobile_phone              varchar(255),
  email                     varchar(255),
  icq                       integer,
  jabber                    varchar(255),
  address                   varchar(255),
  site_url                  varchar(255),
  group_id                  bigint,
  hidden                    boolean,
  description               varchar(255),
  constraint pk_contact primary key (id))
;

create table contact_group (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_contact_group primary key (id))
;

create table file (
  id                        bigint not null,
  name                      varchar(255),
  extension                 varchar(255),
  mime_type                 varchar(255),
  content                   blob,
  constraint pk_file primary key (id))
;

create table interview (
  id                        bigint not null,
  name                      varchar(255),
  text                      clob,
  post_date                 timestamp,
  user_id                   bigint,
  author                    varchar(255),
  published                 boolean,
  last_updated              timestamp,
  first_comment_id          bigint,
  constraint pk_interview primary key (id))
;

create table label (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_label primary key (id))
;

create table magazine (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_magazine primary key (id))
;

create table news (
  id                        bigint not null,
  name                      varchar(255),
  text_brief                clob,
  text_full                 clob,
  post_date                 timestamp,
  user_id                   bigint,
  published                 boolean,
  last_updated              timestamp,
  first_comment_id          bigint,
  constraint pk_news primary key (id))
;

create table review (
  id                        bigint not null,
  split_id                  bigint,
  text                      clob,
  post_date                 timestamp,
  user_id                   bigint,
  author                    varchar(255),
  published                 boolean,
  last_updated              timestamp,
  first_comment_id          bigint,
  constraint pk_review primary key (id))
;

create table split (
  id                        bigint not null,
  name                      varchar(255),
  year                      integer,
  duration                  integer,
  cover_id                  bigint,
  track_list                clob,
  track_list_normal         boolean,
  constraint pk_split primary key (id))
;

create table split_album (
  id                        bigint not null,
  album_id                  bigint,
  split_id                  bigint,
  num                       integer,
  constraint uq_split_album_1 unique (album_id,split_id),
  constraint uq_split_album_2 unique (split_id,num),
  constraint pk_split_album primary key (id))
;

create table split_label (
  id                        bigint not null,
  label_id                  bigint,
  split_id                  bigint,
  num                       integer,
  constraint uq_split_label_1 unique (label_id,split_id),
  constraint uq_split_label_2 unique (split_id,num),
  constraint pk_split_label primary key (id))
;

create table user (
  id                        bigint not null,
  login                     varchar(255),
  password_hash             varchar(255),
  first_name                varchar(255),
  second_name               varchar(255),
  last_name                 varchar(255),
  icq                       integer,
  jabber                    varchar(255),
  email                     varchar(255),
  photo_id                  bigint,
  role                      integer,
  constraint ck_user_role check (role in (0,1,2)),
  constraint uq_user_1 unique (login),
  constraint pk_user primary key (id))
;

create sequence album_seq;

create sequence announce_seq;

create sequence article_seq;

create sequence band_seq;

create sequence banner_seq;

create sequence comment_seq;

create sequence contact_seq;

create sequence contact_group_seq;

create sequence file_seq;

create sequence interview_seq;

create sequence label_seq;

create sequence magazine_seq;

create sequence news_seq;

create sequence review_seq;

create sequence split_seq;

create sequence split_album_seq;

create sequence split_label_seq;

create sequence user_seq;

alter table album add constraint fk_album_band_1 foreign key (band_id) references band (id) on delete restrict on update restrict;
create index ix_album_band_1 on album (band_id);
alter table announce add constraint fk_announce_user_2 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_announce_user_2 on announce (user_id);
alter table announce add constraint fk_announce_firstComment_3 foreign key (first_comment_id) references comment (id) on delete restrict on update restrict;
create index ix_announce_firstComment_3 on announce (first_comment_id);
alter table article add constraint fk_article_user_4 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_article_user_4 on article (user_id);
alter table article add constraint fk_article_firstComment_5 foreign key (first_comment_id) references comment (id) on delete restrict on update restrict;
create index ix_article_firstComment_5 on article (first_comment_id);
alter table comment add constraint fk_comment_parent_6 foreign key (parent_id) references comment (id) on delete restrict on update restrict;
create index ix_comment_parent_6 on comment (parent_id);
alter table contact add constraint fk_contact_group_7 foreign key (group_id) references contact_group (id) on delete restrict on update restrict;
create index ix_contact_group_7 on contact (group_id);
alter table interview add constraint fk_interview_user_8 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_interview_user_8 on interview (user_id);
alter table interview add constraint fk_interview_firstComment_9 foreign key (first_comment_id) references comment (id) on delete restrict on update restrict;
create index ix_interview_firstComment_9 on interview (first_comment_id);
alter table news add constraint fk_news_user_10 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_news_user_10 on news (user_id);
alter table news add constraint fk_news_firstComment_11 foreign key (first_comment_id) references comment (id) on delete restrict on update restrict;
create index ix_news_firstComment_11 on news (first_comment_id);
alter table review add constraint fk_review_split_12 foreign key (split_id) references split (id) on delete restrict on update restrict;
create index ix_review_split_12 on review (split_id);
alter table review add constraint fk_review_user_13 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_review_user_13 on review (user_id);
alter table review add constraint fk_review_firstComment_14 foreign key (first_comment_id) references comment (id) on delete restrict on update restrict;
create index ix_review_firstComment_14 on review (first_comment_id);
alter table split add constraint fk_split_cover_15 foreign key (cover_id) references file (id) on delete restrict on update restrict;
create index ix_split_cover_15 on split (cover_id);
alter table split_album add constraint fk_split_album_album_16 foreign key (album_id) references album (id) on delete restrict on update restrict;
create index ix_split_album_album_16 on split_album (album_id);
alter table split_album add constraint fk_split_album_split_17 foreign key (split_id) references split (id) on delete restrict on update restrict;
create index ix_split_album_split_17 on split_album (split_id);
alter table split_label add constraint fk_split_label_label_18 foreign key (label_id) references label (id) on delete restrict on update restrict;
create index ix_split_label_label_18 on split_label (label_id);
alter table split_label add constraint fk_split_label_split_19 foreign key (split_id) references split (id) on delete restrict on update restrict;
create index ix_split_label_split_19 on split_label (split_id);
alter table user add constraint fk_user_photo_20 foreign key (photo_id) references file (id) on delete restrict on update restrict;
create index ix_user_photo_20 on user (photo_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists album;

drop table if exists announce;

drop table if exists article;

drop table if exists band;

drop table if exists banner;

drop table if exists comment;

drop table if exists contact;

drop table if exists contact_group;

drop table if exists file;

drop table if exists interview;

drop table if exists label;

drop table if exists magazine;

drop table if exists news;

drop table if exists review;

drop table if exists split;

drop table if exists split_album;

drop table if exists split_label;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists album_seq;

drop sequence if exists announce_seq;

drop sequence if exists article_seq;

drop sequence if exists band_seq;

drop sequence if exists banner_seq;

drop sequence if exists comment_seq;

drop sequence if exists contact_seq;

drop sequence if exists contact_group_seq;

drop sequence if exists file_seq;

drop sequence if exists interview_seq;

drop sequence if exists label_seq;

drop sequence if exists magazine_seq;

drop sequence if exists news_seq;

drop sequence if exists review_seq;

drop sequence if exists split_seq;

drop sequence if exists split_album_seq;

drop sequence if exists split_label_seq;

drop sequence if exists user_seq;

