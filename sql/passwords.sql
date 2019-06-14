USE finalProject;

DROP TABLE IF EXISTS passwords;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS passwords (
	pass_id int not null auto_increment,
    user_id integer not null,
    pass VARCHAR(15) not null,
    primary key(pass_id)
);


INSERT INTO passwords(user_id, pass) VALUES
   /* ("anamaria", "bla"),
    ("mariami", "blu"),
    ("nino", "blura"); */
    
	(1, "bla"),
    (2, "blu"),
    (3, "blura");