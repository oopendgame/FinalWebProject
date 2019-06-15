USE finalProject;

DROP TABLE IF EXISTS quizzes;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS quizzes (
    quiz_id int not null auto_increment,
    author_id int not null,
    page_num int default 1,
    correction_type varchar(50) default "later",
    creation_date datetime,
    subj varchar(100) not null,
    description varchar(500),
    practice_mode varchar(10) default "yes",
    
    primary key(quiz_id),
	FOREIGN KEY (author_id) REFERENCES userInfo(user_id)
);




INSERT INTO quizzes (author_id, page_num, correction_type, creation_date, subj, description, practice_mode) VALUES
    (1, 2, "imm", sysdate(), "Math", "dkjsgks", "no"),
    (2, 1, "later", sysdate(), "History", "djksnksjbgvshdgbsig", "yes");