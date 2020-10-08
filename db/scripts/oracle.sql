CREATE TABLE GROUPS ( 
  GROUPID    VARCHAR2 (2)  NOT NULL, 
  GROUPNAME  VARCHAR2 (100), 
  PRIMARY KEY ( GROUPID ) ) ; 
  
CREATE TABLE emailaddress (
  emailaddress VARCHAR2(50) NOT NULL ,
  firstname VARCHAR2(60) NOT NULL,
  middlename VARCHAR2(20) NOT NULL,
  lastname VARCHAR2(60) NOT NULL,
  homephoneno VARCHAR2(10) NOT NULL,
  workphoneno VARCHAR2(10) NOT NULL,
  mobileno VARCHAR2(10) NOT NULL,
  groupid CHAR(3) NOT NULL,
  PRIMARY KEY  (emailaddress)
) ;

