USE finalProject;

DROP TABLE IF EXISTS announcement;
 -- remove table if it already exists and start from scratch

CREATE TABLE IF NOT EXISTS announcements (
	ann_id int not null auto_increment,
    title varchar(250),
    announcement varchar(2000) not null,
    announce_date datetime,
    admin_id int not null,
    
    primary key(ann_id),
    FOREIGN KEY (admin_id) REFERENCES admins(admin_id)
);