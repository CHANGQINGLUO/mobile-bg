CREATE TABLE USERS 
   (	USER_UUID VARCHAR(100) NOT NULL ,
        NAME VARCHAR(100) NOT NULL,
		CONTACT_HM VARCHAR(20),
		CONTACT_OFF VARCHAR(20),
		EMAIL VARCHAR(100), 
		IS_DELETED VARCHAR(1) DEFAULT '0',
		DATE_CREATE timestamp NOT NULL,
		CREATE_BY VARCHAR(50), 
		DATE_UPDATE timestamp,
		UPDATE_BY VARCHAR(50)	  )  ;
  
  CREATE UNIQUE INDEX USER_UUID_PK ON USERS (USER_UUID); 
  
ALTER TABLE USERS ADD CONSTRAINT USER_UUID_PK PRIMARY KEY (USER_UUID);