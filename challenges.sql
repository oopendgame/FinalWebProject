USE finalProject;

DROP TABLE IF EXISTS challenges;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS challenges (
    user1_id integer not null,
    user2_id integer not null,
    status varchar(15) default "sent"
);




INSERT INTO challenges VALUES
(1, 2, "sent"),
(1, 3, "accepted");
    