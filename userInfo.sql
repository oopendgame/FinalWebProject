USE finalProject;

DROP TABLE IF EXISTS passwords;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS userInfo (
    user_id int not null,
    pass VARCHAR(15) not null
);


INSERT INTO passwords VALUES
    ("anamaria", "bla"),
    ("mariami", "blu"),
    ("nino", "blura");