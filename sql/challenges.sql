USE finalProject;

DROP TABLE IF EXISTS challenges;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS challenges (
    user1_id integer not null,
    user2_id integer not null,
    link varchar(500)
);




INSERT INTO challenges VALUES
(1, 2, "bla.com"),
(1, 3, "blu.com");
    