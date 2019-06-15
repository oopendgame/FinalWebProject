USE finalProject;

DROP TABLE IF EXISTS answers;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS answers (
    answer_id int not null auto_increment,
    question_id int not null,
    answer varchar(20) not null,
    correct_ans int not null default 0,
    
    primary key(answer_id),
    FOREIGN KEY (question_id) REFERENCES questions(question_id)
);




INSERT INTO answers(question_id, answer, correct_ans) VALUES
(1, "kgihndrk", 0),
(2, "glsgnsl", 1);