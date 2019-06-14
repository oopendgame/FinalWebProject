USE finalProject;

DROP TABLE IF EXISTS popularity;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS popularity (
	pop_id int not null auto_increment,
    quiz_id integer not null,
    user_num integer default 0,
    primary key(pop_id)
);




INSERT INTO popularity(quiz_id, user_num) VALUES
(2, 15),
(8, 4);
    