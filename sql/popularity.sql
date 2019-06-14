USE finalProject;

DROP TABLE IF EXISTS popularity;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS popularity (
    quiz_id integer not null,
    user_num integer default 0
);




INSERT INTO popularity VALUES
(2, 15),
(8, 4);
    