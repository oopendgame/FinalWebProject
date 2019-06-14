USE finalProject;

DROP TABLE IF EXISTS score;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS score (
    quiz_id int not null auto_increment,
    user_id int not null,
    score int default 0,
    written_time DATETIME,
    primary key(quiz_id)
);




INSERT INTO score (user_id, score, written_time) VALUES
    (1, 15, sysdate()),
    (2, 50, sysdate());