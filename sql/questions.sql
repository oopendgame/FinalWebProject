USE finalProject;

DROP TABLE IF EXISTS questions;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS questions (
    question_id int not null auto_increment,
    quiz_id int not null,
    question_type varchar(20) not null default "fillBlank",
    question varchar(500) not null,
    
    primary key(question_id),
    FOREIGN KEY (quiz_id) REFERENCES quizzes(quiz_id)
);