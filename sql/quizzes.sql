USE finalProject;

DROP TABLE IF EXISTS quizzes;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS quizzes (
    quiz_id int not null auto_increment,
    author_id int not null,
    page_num boolean default 1,
    random boolean default 0,
    quiz_name varchar(100) not null,
    correction_type boolean default 0,
    creation_date datetime,
    subj varchar(100) not null,
    description varchar(500),
    
    primary key(quiz_id),
	FOREIGN KEY (author_id) REFERENCES userInfo(user_id)
);