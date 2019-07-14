USE finalProject;

DROP TABLE IF EXISTS sms;
 -- remove table if it already exists and start from scratch

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
    