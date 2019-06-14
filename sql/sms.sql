USE finalProject;

DROP TABLE IF EXISTS sms;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS sms (
    user1_id integer not null,
    user2_id integer not null,
    sms varchar(500) not null,
    sent_time  DATETIME
);




INSERT INTO sms VALUES
(1, 2, "bla", sysdate()),
(1, 3, "blu", sysdate());
    