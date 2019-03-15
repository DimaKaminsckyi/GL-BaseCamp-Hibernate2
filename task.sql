DROP DATABASE task;

CREATE DATABASE IF NOT EXISTS  task;
USE task;


CREATE TABLE IF NOT EXISTS  department(    
    id INT NOT NULL AUTO_INCREMENT,
    department_name VARCHAR(30) NOT NULL,
    status BIT(1) NOT NULL,
	  PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS  workers (
    id INT NOT NULL AUTO_INCREMENT,
    age INT(10) NOT NULL,
    availability  ENUM('FullTime' , 'PartTime') NOT NULL,
    full_name VARCHAR(30) NOT NULL,
    department_id INT ,
    FOREIGN KEY(department_id) REFERENCES department(id),
	  PRIMARY KEY (id)
);






