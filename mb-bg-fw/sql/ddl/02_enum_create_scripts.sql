

--------------------------------------------------------
--  DDL for Table SYS_ENUM
--------------------------------------------------------

  CREATE TABLE SYS_ENUM 
   (	ENUM_UUID VARCHAR(100) NOT NULL,
        MESSAGE_KEY VARCHAR(13) NOT NULL,
	CATEGORY VARCHAR(18),
	RANKING INT,
	IS_DELETED VARCHAR(1) DEFAULT '0', 	
	DATE_CREATE TIMESTAMP,
	CREATE_BY VARCHAR(50), 
	DATE_UPDATE TIMESTAMP,
	UPDATE_BY VARCHAR(50)
   );    
  
  ALTER TABLE SYS_ENUM ADD CONSTRAINT SYS_ENUM_PK PRIMARY KEY (ENUM_UUID);
  
    commit;

    