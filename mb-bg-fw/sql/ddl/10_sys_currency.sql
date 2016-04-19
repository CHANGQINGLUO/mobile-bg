/*==============================================================*/
/* Table: CURRENCY                                              */
/*==============================================================*/
create table SYS_CURRENCY 
(
   CURRENCY_UUID        VARCHAR(100)        not null,
   NUMBERIC_CUR_CODE    INTEGER              not null,
   TEXT_CUR_CODE        VARCHAR(16)         not null,
   SCALE                SMALLINT,
   NAME_MSG_KEY         VARCHAR(13),
   SYMBOL_MSG_KEY       VARCHAR(13),
   MARKUP_TEXT          VARCHAR(255),
   IS_ACTIVE            CHAR(1)              not null,
   CREATE_BY            VARCHAR(50),
   DATE_CREATE          TIMESTAMP                 not null,
   UPDATE_BY            VARCHAR(50),
   IS_DELETED           CHAR(1),
   DATE_UPDATE          TIMESTAMP,
   constraint PK_CURRENCY primary key (CURRENCY_UUID)
);

commit;	  

