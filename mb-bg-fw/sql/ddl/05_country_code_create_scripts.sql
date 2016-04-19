/*==============================================================*/
/* Table: SYS_COUNTRY_CODE                                      */
/*==============================================================*/
create table SYS_COUNTRY_CODE 
(
   COUNTRY_CODE_UUID    VARCHAR(100)        not null,
   DESCRIPTION          VARCHAR(255),
   ISO_ALPHA_2CD        CHAR(2),
   ISO_ALPHA_3CD        CHAR(3),
   ISO_NUMERIC_CODE     INTEGER,
   SHORT_NAME_MSG_KEY   VARCHAR(13),
   LONG_NAME_MSG_KEY    VARCHAR(13),
   IS_ACTIVED           CHAR(1),
   CREATE_BY            VARCHAR(50),
   DATE_CREATE          DATE                 not null,
   UPDATE_BY            VARCHAR(50),
   DATE_UPDATE          DATE,
   IS_DELETED           CHAR(1),
   constraint PK_SYS_COUNTRY_CODE primary key (COUNTRY_CODE_UUID)
);

commit;

