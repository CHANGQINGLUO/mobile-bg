
--------------------------------------------------------
--  File created - Monday-June-23-2014   
--------------------------------------------------------

INSERT INTO SYS_MESSAGE (MESSAGE_UUID,MESSAGE_KEY,MESSAGE_VALUE,LANGUAGE,IS_DELETED,DATE_CREATE,CREATE_BY) SELECT UUID(),'SYSCHLIntel','internal','en','0',CURRENT_TIMESTAMP,'System' FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM SYS_MESSAGE m WHERE  m.MESSAGE_KEY = 'SYSCHLIntel' AND m.LANGUAGE = 'en');
INSERT INTO SYS_MESSAGE (MESSAGE_UUID,MESSAGE_KEY,MESSAGE_VALUE,LANGUAGE,IS_DELETED,DATE_CREATE,CREATE_BY) SELECT UUID(),'SYSCHLIpad','ipad','en','0',CURRENT_TIMESTAMP,'System' FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM SYS_MESSAGE m WHERE  m.MESSAGE_KEY = 'SYSCHLIpad' AND m.LANGUAGE = 'en');
  commit;
