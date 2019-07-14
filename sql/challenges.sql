USE finalProject;

DROP TABLE IF EXISTS challenges;
 -- remove table if it already exists and start from scratch

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
 