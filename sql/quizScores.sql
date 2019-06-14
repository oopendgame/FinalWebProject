USE finalProject;

DROP TABLE IF EXISTS quizScores;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS quizScores (
	score_id int not null auto_increment,
    quiz_id int not null,
    user_id int not null,
    score int default 0,
    start_time DATETIME,
    duration int,
    
	primary key(score_id),
    FOREIGN KEY (user_id) REFERENCES userInfo(user_id),
    FOREIGN KEY (quiz_id) REFERENCES quizzes(quiz_id)
);




INSERT INTO quizScores(quiz_id, user_id, score, start_time, duration) VALUES
    (1, 1, 15, sysdate(), 10),
    (2, 2, 50, sysdate(), 40);