USE finalProject;

DROP TABLE IF EXISTS score;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS score (
	score_id int not null auto_increment,
    quiz_id int not null,
    user_id int not null,
    score int default 0,
    written_time DATETIME,
	primary key(score_id)
);




INSERT INTO score(quiz_id, user_id, score, written_time) VALUES
    (1, 1, 15, sysdate()),
    (3, 2, 50, sysdate());