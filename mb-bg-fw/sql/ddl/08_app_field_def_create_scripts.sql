
/*==============================================================*/
/* Table: APP_FIELD_DEF                                         */
/*==============================================================*/
create table APP_FIELD_DEF 
(
   FIELD_DEF_UUID       VARCHAR(100)        not null,
   FIELD_TYPE           VARCHAR(256)        not null,
   FIELD_NAME           VARCHAR(80)         not null,
   DESCRIPTION          VARCHAR(255),
   STORED_DATA_TYPE     VARCHAR(5),
   DISPLAY_DATA_TYPE    VARCHAR(5),
   DATE_CREATE          DATE,
   CREATE_BY            VARCHAR(50),
   DATE_UPDATE          DATE,
   UPDATE_BY            VARCHAR(50),
   IS_DELETED           CHAR(1),
   constraint PK_APP_FIELD_DEF primary key (FIELD_DEF_UUID)
);

create unique index UQ_FIELD on APP_FIELD_DEF(FIELD_TYPE, FIELD_NAME);

  commit;
