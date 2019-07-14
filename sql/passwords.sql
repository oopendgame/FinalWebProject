USE finalProject;

DROP TABLE IF EXISTS passwords;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS passwords (
	pass_id int not null auto_increment,
    user_id integer not null,
    pass VARCHAR(2000) not null,
    
    primary key(pass_id),
    FOREIGN KEY (user_id) REFERENCES userInfo(user_id)
);


INSERT INTO passwords(user_id, pass) VALUES
(1, '40bd001563085fc35165329ea1ff5c5ecbdbbeef'), 
(2, '40bd001563085fc35165329ea1ff5c5ecbdbbeef'),
(3, '40bd001563085fc35165329ea1ff5c5ecbdbbeef');