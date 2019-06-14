USE finalProject;

DROP TABLE IF EXISTS friends;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS friends (
	friends_id int not null auto_increment,
    user1_id integer not null,
    user2_id integer not null,
    friends_satus varchar(15) default "requested",
    primary key(friends_id)
);




INSERT INTO friends(user1_id, user2_id, friends_satus) VALUES
(1, 2, "requested"),
(2, 3, "friends");
    