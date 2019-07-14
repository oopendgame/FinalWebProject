USE finalProject;

DROP TABLE IF EXISTS friends;
 -- remove table if it already exists and start from scratch

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
    