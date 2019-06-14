USE finalProject;

DROP TABLE IF EXISTS userInfo;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS userInfo (
    user_id int not null auto_increment,
    user_name varchar(15) unique not null,
    first_name varchar(15),
    last_name varchar(15),
    email varchar(50) not null,
    date_of_birth date,
    gender varchar(10) not null,
    img varchar(50),
    rank varchar(20) default 'begginer',
    primary key(user_id)
);




INSERT INTO userInfo (user_name, first_name, last_name, email, date_of_birth, gender, img, rank) VALUES
    ('achkh17', 'anamaria', 'chkhaidze', 'achkh17@freeuni.edu.ge', sysdate(), 'female', 'bla.jpg', 'beginner'),
    ('nchan17', 'nino', 'chanturia', 'nchan17@freeuni.edu.ge', sysdate(), 'female', 'blura.jpg', 'beginner');