CREATE TABLE `groups` (
  `groupid` char(2) NOT NULL default '',
  `groupname` varchar(100) default NULL,
  PRIMARY KEY  (`groupid`)
) TYPE=MyISAM;

CREATE TABLE `emailaddress` (
  `emailaddress` varchar(50) NOT NULL default '',
  `firstname` varchar(60) NOT NULL default '',
  `middlename` varchar(20) NOT NULL default '',
  `lastname` varchar(60) NOT NULL default '',
  `homephoneno` varchar(10) NOT NULL default '',
  `workphoneno` varchar(10) NOT NULL default '',
  `mobileno` varchar(10) NOT NULL default '',
  `groupid` char(3) NOT NULL default '',
  PRIMARY KEY  (`emailaddress`)
) TYPE=MyISAM;