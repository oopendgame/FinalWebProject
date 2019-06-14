USE finalProject;

DROP TABLE IF EXISTS friends;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS friends (
    user1_id integer not null,
    user2_id integer not null,
    status varchar(15) default "requested"
);




INSERT INTO friends VALUES
(1, 2, "requested"),
(2, 3, "friends");
    