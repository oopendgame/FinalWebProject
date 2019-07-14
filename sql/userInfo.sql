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
    img varchar(2000) default "https://wallpaperplay.com/walls/full/e/3/6/138503.jpg",
    
    primary key(user_id) 
);




INSERT INTO userInfo (user_name, first_name, last_name, email, date_of_birth, gender, img) VALUES
    ('achkh17', 'anamaria', 'chkhaidze', 'achkh17@freeuni.edu.ge', sysdate(), 'female', 'https://scontent.ftbs4-1.fna.fbcdn.net/v/t1.0-9/51785982_2118103464931868_3119750972641902592_n.jpg?_nc_cat=107&_nc_oc=AQl5w4dHlax4Lwo1ZKTtlUJxYD9tDOqX2DhzHF577f5P4OTqwjhmQXFBGdoVNEs60Tw&_nc_ht=scontent.ftbs4-1.fna&oh=2f6bed7bc491bf7bcc581b2ef5b20a73&oe=5DACCD36'),
    ('nchan17', 'nino', 'chanturia', 'nchan17@freeuni.edu.ge', sysdate(), 'female', 'https://scontent.ftbs4-1.fna.fbcdn.net/v/t1.0-9/19424401_784494171675882_8786767691181003760_n.jpg?_nc_cat=107&_nc_oc=AQmwxxmh6xwM5jgZmeAt5dgYgKgKVRQId03zDA4d5MzSqxK5fwxfa97IijidsCOuQac&_nc_ht=scontent.ftbs4-1.fna&oh=6f9a3ac188672e613f6f68903129aeeb&oe=5DAEEB25'),
    ('mchkh17', 'mariam', 'chkhaidze', 'mchkh17@freeuni.edu.ge', sysdate(), 'female', 'https://scontent.ftbs4-1.fna.fbcdn.net/v/t1.0-9/19366221_1510029115708562_394005548772054778_n.jpg?_nc_cat=109&_nc_oc=AQnFER6VlzGE7LMb-0c-VIUWOu0_fzdrvnkDWYWyfTXCpPmT87XnxWlzJdWupv3iNF8&_nc_ht=scontent.ftbs4-1.fna&oh=ea6ba3f13f3fe136196365c8a17597ba&oe=5DC1170D');