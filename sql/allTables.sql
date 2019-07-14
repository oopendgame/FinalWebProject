Drop DATABASE IF  EXISTS finalProject;
CREATE DATABASE IF NOT EXISTS finalProject;
USE finalProject;



CREATE TABLE IF NOT EXISTS userInfo (
    user_id int not null auto_increment,
    user_name varchar(15) unique not null,
    first_name varchar(15),
    last_name varchar(15),
    email varchar(50) not null,
    date_of_birth date,
    gender varchar(10) not null,
    img varchar(2000) default "https://wallpaperplay.com/walls/full/e/3/6/138503.jpg",
    
    primary key(user_id) 
);

INSERT INTO userInfo (user_name, first_name, last_name, email, date_of_birth, gender, img) VALUES
    ('achkh17', 'anamaria', 'chkhaidze', 'achkh17@freeuni.edu.ge', sysdate(), 'female', 'https://scontent.ftbs4-1.fna.fbcdn.net/v/t1.0-9/51785982_2118103464931868_3119750972641902592_n.jpg?_nc_cat=107&_nc_oc=AQl5w4dHlax4Lwo1ZKTtlUJxYD9tDOqX2DhzHF577f5P4OTqwjhmQXFBGdoVNEs60Tw&_nc_ht=scontent.ftbs4-1.fna&oh=2f6bed7bc491bf7bcc581b2ef5b20a73&oe=5DACCD36'),
    ('nchan17', 'nino', 'chanturia', 'nchan17@freeuni.edu.ge', sysdate(), 'female', 'https://scontent.ftbs4-1.fna.fbcdn.net/v/t1.0-9/19424401_784494171675882_8786767691181003760_n.jpg?_nc_cat=107&_nc_oc=AQmwxxmh6xwM5jgZmeAt5dgYgKgKVRQId03zDA4d5MzSqxK5fwxfa97IijidsCOuQac&_nc_ht=scontent.ftbs4-1.fna&oh=6f9a3ac188672e613f6f68903129aeeb&oe=5DAEEB25'),
    ('mchkh17', 'mariam', 'chkhaidze', 'mchkh17@freeuni.edu.ge', sysdate(), 'female', 'https://scontent.ftbs4-1.fna.fbcdn.net/v/t1.0-9/19366221_1510029115708562_394005548772054778_n.jpg?_nc_cat=109&_nc_oc=AQnFER6VlzGE7LMb-0c-VIUWOu0_fzdrvnkDWYWyfTXCpPmT87XnxWlzJdWupv3iNF8&_nc_ht=scontent.ftbs4-1.fna&oh=ea6ba3f13f3fe136196365c8a17597ba&oe=5DC1170D');
    

CREATE TABLE IF NOT EXISTS achievements (
	ach_id int not null auto_increment,
    user_id int not null,
    achievement varchar(50) not null,
    ach_time datetime,
    
    primary key (ach_id),
    FOREIGN KEY (user_id) REFERENCES userInfo(user_id)
);


CREATE TABLE IF NOT EXISTS admins (
    admin_id int not null auto_increment,
    user_id int,
    
    primary key(admin_id),
    FOREIGN KEY (user_id) REFERENCES userInfo(user_id)
);


INSERT INTO admins(user_id) VALUES
(1),
(2),
(3);


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

CREATE TABLE IF NOT EXISTS announcements (
	ann_id int not null auto_increment,
    title varchar(250),
    announcement varchar(2000) not null,
    announce_date datetime,
    admin_id int not null,
    
    primary key(ann_id),
    FOREIGN KEY (admin_id) REFERENCES admins(admin_id)
);

CREATE TABLE IF NOT EXISTS questions (
    question_id int not null auto_increment,
    quiz_id int not null,
    question_type varchar(20) not null default "fillBlank",
    question varchar(500) not null,
    
    primary key(question_id),
    FOREIGN KEY (quiz_id) REFERENCES quizzes(quiz_id)
);


CREATE TABLE IF NOT EXISTS answers (
    answer_id int not null auto_increment,
    question_id int not null,
    answer varchar(20) not null,
    correct_ans boolean not null default 0,
    
    primary key(answer_id),
    FOREIGN KEY (question_id) REFERENCES questions(question_id)
);


CREATE TABLE IF NOT EXISTS challenges (
	challenge_id int not null auto_increment,
    user1_id integer not null,
    user2_id integer not null,
    link varchar(500),
    sending_time datetime,
    seen boolean not null default false,
    
    primary key(challenge_id),
    FOREIGN KEY (user1_id) REFERENCES userInfo(user_id),
    FOREIGN KEY (user2_id) REFERENCES userInfo(user_id)
);
 

CREATE TABLE IF NOT EXISTS friends (
	friends_id int not null auto_increment,
    user1_id integer not null,
    user2_id integer not null,
    friends_status integer default 0, -- 0-request send, 1-friends, -1 rejected
    sending_date DateTime,
    
    primary key(friends_id),
    FOREIGN KEY (user1_id) REFERENCES userInfo(user_id),
    FOREIGN KEY (user2_id) REFERENCES userInfo(user_id)
);


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



CREATE TABLE IF NOT EXISTS sms (
	sms_id int not null auto_increment,
    user1_id integer not null,
    user2_id integer not null,
    sms varchar(500) not null,
    sms_condition varchar(10) not null default "sent",
    sent_time  DATETIME,
    
    primary key(sms_id),
    FOREIGN KEY (user1_id) REFERENCES userInfo(user_id),
    FOREIGN KEY (user2_id) REFERENCES userInfo(user_id)
);


CREATE TABLE IF NOT EXISTS popularity (
	pop_id int not null auto_increment,
    quiz_id integer not null unique,
    user_num integer default 0,
    
    primary key(pop_id),
    FOREIGN KEY (quiz_id) REFERENCES quizzes(quiz_id)
);
