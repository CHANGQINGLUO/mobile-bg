  
  --------------------------------------------------------
--  DDL for Table SYS_AUDIT_TYPE
--------------------------------------------------------

  CREATE TABLE SYS_AUDIT_TYPE 
   (AUDIT_TYPE_UUID VARCHAR(100) NOT NULL, 
	CHANNEL_UUID VARCHAR(100), 
	COMPONENT_KEY VARCHAR(13),
	FUNCTION_KEY VARCHAR(13),
	IS_DELETED VARCHAR(1) DEFAULT '0', 	
	DATE_CREATE TIMESTAMP NOT NULL,
	CREATE_BY VARCHAR(50), 
	DATE_UPDATE TIMESTAMP,
	UPDATE_BY VARCHAR(50)
   ); 
  
--------------------------------------------------------
--  DDL for Primary Key Constraint SYS_AUDIT_TYPE_PK
--------------------------------------------------------

  ALTER TABLE SYS_AUDIT_TYPE ADD CONSTRAINT SYS_AUDIT_TYPE_PK PRIMARY KEY (AUDIT_TYPE_UUID);   
  
  
  ALTER TABLE SYS_AUDIT_TYPE ADD CONSTRAINT SYS_AUDIT_TYPE_SYS_CHANNEL_FK FOREIGN KEY (CHANNEL_UUID)
	  REFERENCES SYS_CHANNEL (CHANNEL_UUID);
  
	  
	  
	  
--------------------------------------------------------
--  DDL for Table SYS_AUDIT
--------------------------------------------------------

  CREATE TABLE SYS_AUDIT 
   (AUDIT_UUID VARCHAR(100) NOT NULL, 
	AUDIT_TYPE_UUID VARCHAR(100) NOT NULL, 
	USER_UUID VARCHAR(100) NOT NULL,
	SESSION_ID VARCHAR(100),
	CUST_CIN  VARCHAR(25),
	CUST_NAME VARCHAR(100),
	XMLAUDITDATA VARCHAR(2000),
	IS_DELETED VARCHAR(1) DEFAULT '0',
	DATE_CREATE TIMESTAMP NOT NULL,
	CREATE_BY VARCHAR(50), 
	DATE_UPDATE TIMESTAMP,
	UPDATE_BY VARCHAR(50)
   );  
  

  
  ALTER TABLE SYS_AUDIT ADD CONSTRAINT SYS_AUDIT_PK PRIMARY KEY (AUDIT_UUID);    
  
--------------------------------------------------------
--  Ref Constraints for Table SYS_AUDIT_TYPE
--------------------------------------------------------

  ALTER TABLE SYS_AUDIT ADD CONSTRAINT SYS_AUDIT_FK FOREIGN KEY (AUDIT_TYPE_UUID)
	  REFERENCES SYS_AUDIT_TYPE (AUDIT_TYPE_UUID);
	  
  commit;
 