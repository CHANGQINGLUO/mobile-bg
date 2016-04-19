/*==============================================================*/
/* Table: SYS_AUDIT_DETAIL                                      */
/*==============================================================*/
create table SYS_AUDIT_DETAIL 
(
   AUDIT_DETAIL_UUID    VARCHAR(100)        not null,
   FIELD_DEF_UUID       VARCHAR(100),
   AUDIT_UUID           VARCHAR(100),
   AUDIT_VALUE          VARCHAR(2000),
   DESCRIPTION          CHAR(10),
   RANK                 INT,
   CREATE_BY            VARCHAR(50),
   DATE_CREATE          DATE                 not null,
   UPDATE_BY            VARCHAR(50),
   DATE_UPDATE          DATE,
   IS_DELETED           CHAR(1),
   constraint PK_SYS_AUDIT_DETAIL primary key (AUDIT_DETAIL_UUID)
);

/*==============================================================*/
/* Index: AUDIT_DETAIL_IND_FK                                   */
/*==============================================================*/
create index AUDIT_DETAIL_IND_FK on SYS_AUDIT_DETAIL (
   AUDIT_UUID ASC
);

/*==============================================================*/
/* Index: AUDIT_FIELD_FK                                        */
/*==============================================================*/
create index AUDIT_FIELD_FK on SYS_AUDIT_DETAIL (
   FIELD_DEF_UUID ASC
);


alter table SYS_AUDIT_DETAIL
   add constraint FK_SYS_AUDI_AUDIT_DET_SYS_AUDI foreign key (AUDIT_UUID)
      references SYS_AUDIT (AUDIT_UUID);

alter table SYS_AUDIT_DETAIL
   add constraint FK_SYS_AUDI_AUDIT_FIE_APP_FIEL foreign key (FIELD_DEF_UUID)
      references APP_FIELD_DEF (FIELD_DEF_UUID);
      
  commit;
