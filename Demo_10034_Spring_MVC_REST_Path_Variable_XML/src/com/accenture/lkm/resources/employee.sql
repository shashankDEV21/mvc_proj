
-- Dumping database structure for hibernatedemos
DROP DATABASE IF EXISTS springmvcdemos;
CREATE DATABASE springmvcdemos; 
USE springmvcdemos;


-- Dumping structure for table hibernatedemos.employee
DROP TABLE IF EXISTS employee_Spring;
CREATE TABLE IF NOT EXISTS employee_spring (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(20) DEFAULT NULL,
  role varchar(20) DEFAULT NULL,
  inserttime datetime DEFAULT NULL,
  salary double DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

INSERT INTO employee_Spring (id, name, role, inserttime, salary) VALUES
	(1001, 'MSD',   'Sr.Analyst', '2016-01-28 00:00:00', 1000),
	(1002, 'James', 'Sr.Analyst', '2016-01-28 00:00:00', 2345),
	(1003, 'Rocky', 'Sr.Analyst', '2016-01-28 00:00:00', 30000),
	(1004, 'Jack',  'Sr.Analyst', '2016-01-28 00:00:00', 1345),
	(1005, 'Dim',   'Sr.Analyst', '2016-01-28 00:00:00', 34567),
	(1006, 'Tim',   'Sr.Analyst', '2016-01-28 00:00:00', 2345),
	(1007, 'Dan',   'Sr.Analyst', '2016-01-28 00:00:00', 989898);
commit;
