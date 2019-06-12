USE finalProject;

DROP TABLE IF EXISTS passwords;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS passwords (
    user_id VARCHAR(20) not null,
    pass VARCHAR(15) not null
);


INSERT INTO passwords VALUES
    ("anamaria", "bla"),
    ("mariami", "blu"),
    ("nino", "blura");