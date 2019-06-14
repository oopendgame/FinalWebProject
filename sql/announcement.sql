USE finalProject;

DROP TABLE IF EXISTS announcement;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS announcement (
	ann_id int not null auto_increment,
    title varchar(250),
    announcement varchar(500) not null,
    announce_date datetime,
    admin_id int not null,
    primary key(ann_id)
);




INSERT INTO announcement(title, announcement, announce_date, admin_id) VALUES
("sfjgkfsj", "sdkjghshfudhsgibdskgbdkghkdregbkdf", sysdate(), 5);
    