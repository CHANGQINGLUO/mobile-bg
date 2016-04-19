/*==============================================================*/
/* Table: SYS_LANGUAGE_CODE                                     */
/*==============================================================*/
create table SYS_LANGUAGE_CODE 
(
   LANGUAGE_CODE_UUID   VARCHAR(100)        not null,
   DESCRIPTION          VARCHAR(255)        not null,
   ISO_ALPHA_2CD        CHAR(2)              not null,
   ISO_ALPHA_3BCD       CHAR(3)              not null,
   ISO_ALPHA_3TCD       CHAR(3),
   NAME_MSG_KEY         VARCHAR(13),
   CREATE_BY            VARCHAR(50),
   DATE_CREATE          DATE                 not null,
   UPDATE_BY            VARCHAR(50),
   DATE_UPDATE          DATE,
   IS_DELETED           CHAR(1),
   constraint PK_SYS_LANGUAGE_CODE primary key (LANGUAGE_CODE_UUID)
);
commit;

