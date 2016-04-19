/*==============================================================*/
/* Table: SYS_LOCALE_CODE                                       */
/*==============================================================*/
create table SYS_LOCALE_CODE 
(
   LOCALE_CODE_UUID     VARCHAR2(100)        not null,
   LANGUAGE_CODE_UUID   VARCHAR2(100),
   COUNTRY_CODE_UUID    VARCHAR2(100),
   NAME                 VARCHAR2(64),
   IS_DEFAULT            CHAR(1),
   DISPLAY_SEQUENCE     SMALLINT,
   IMAGE_FILE_NAME      VARCHAR2(255),
   CREATE_BY            VARCHAR2(50),
   DATE_CREATE          DATE                 not null,
   UPDATE_BY            VARCHAR2(50),
   DATE_UPDATE          DATE,
   IS_DELETED           CHAR(1),
   constraint PK_SYS_LOCALE_CODE primary key (LOCALE_CODE_UUID)
);

/*==============================================================*/
/* Index: LANGUAGE_LOCALE_FK                                    */
/*==============================================================*/
create index LANGUAGE_LOCALE_FK on SYS_LOCALE_CODE (
   LANGUAGE_CODE_UUID ASC
);

/*==============================================================*/
/* Index: COUNTRY_LOCALE_FK                                     */
/*==============================================================*/
create index COUNTRY_LOCALE_FK on SYS_LOCALE_CODE (
   COUNTRY_CODE_UUID ASC
);

alter table SYS_LOCALE_CODE
   add constraint FK_SYS_LOCA_COUNTRY_L_SYS_COUN foreign key (COUNTRY_CODE_UUID)
      references SYS_COUNTRY_CODE (COUNTRY_CODE_UUID);

alter table SYS_LOCALE_CODE
   add constraint FK_SYS_LOCA_LANGUAGE__SYS_LANG foreign key (LANGUAGE_CODE_UUID)
      references SYS_LANGUAGE_CODE (LANGUAGE_CODE_UUID);

      
