drop database filmes;
create database filmes;

use filmes;


create table film(
id int NOT NULL auto_increment,
name varchar(50) NOT NULL,
year int NOT NULL,
genre varchar(50) NOT NULL,
primary key (id)
)ENGINE=InnoDB;


create table actor(
actor_id int NOT NULL auto_increment,
actor_name varchar(50) NOT NULL,
actor_surname varchar(50),
primary key (actor_id)
)ENGINE=InnoDB;

create table actor_film(
id int not null,
actor_id int NOT NULL auto_increment,
role varchar(50),
FOREIGN KEY (id) REFERENCES film(id) ON DELETE CASCADE,
FOREIGN KEY (actor_id) REFERENCES actor(actor_id) ON DELETE CASCADE
)ENGINE=InnoDB;

create table crew(
film_id int not null auto_increment,
film_director varchar(50),
film_doph varchar(50),
film_composer varchar(50),
FOREIGN KEY (film_id) REFERENCES film(id) ON DELETE CASCADE
)ENGINE=InnoDB;


INSERT INTO film VALUES(1,'Red',2010,'Action Comedy');
INSERT INTO film VALUES(2,'The Devil`s Advocate',1997,'Drama Detective');
INSERT INTO film VALUES(3,'The Shawshank Redemption',1994,'Drama');
INSERT INTO film VALUES(4,'The Lord of the Rings: The Return of the King',2003,'Fantasy Adventure');
INSERT INTO film VALUES(5,'Inception',2010,'Drama Sci-fi');
INSERT INTO film VALUES(6,'The Silence of the Lambs',1991,'Drama Thriller Detective');
INSERT INTO film VALUES(7,'Léon',1994,'Drama Action');
INSERT INTO film VALUES(8,'Interstellar',2014,'Sci-fi Drama');
INSERT INTO film VALUES(9,'The Departed',2006,'Detective Drama');
INSERT INTO film VALUES(10,'Back to the Future',1985,'Sci-fi Adventure');


insert into actor values(1,'Bruce','Willis');
insert into actor values(2,'Morgan','Freeman');
insert into actor values(3,'John','Malkovich');

insert into actor values(4,'Keanu','Reeves');
insert into actor values(5,'Al','Pacino');
insert into actor values(6,'Charlize','Theron');

insert into actor values(7,'Tim','Robbins');
insert into actor values(8,'Morgan','Freeman');
insert into actor values(9,'Bob','Gunton');

insert into actor values(10,'Elijah','Wood');
insert into actor values(11,'Ian','McKellen');
insert into actor values(12,'Viggo','Mortensen');

insert into actor values(13,'Leonardo','DiCaprio');
insert into actor values(14,'Joseph','Gordon-Levitt');
insert into actor values(15,'Ellen','Page');

insert into actor values(16,'Jodie','Foster');
insert into actor values(17,'Anthony','Hopkins');
insert into actor values(18,'Scott','Glenn');

insert into actor values(19,'Jean','Reno');
insert into actor values(20,'Natalie','Portman');
insert into actor values(21,'Gary','Oldman');

insert into actor values(22,'Matthew','McConaughey');
insert into actor values(23,'Anne','Hathaway');
insert into actor values(24,'Jessica','Chastain');

insert into actor values(25,'Leonardo','DiCaprio');
insert into actor values(26,'Matt','Damon');
insert into actor values(27,'Jack','Nicholson');

insert into actor values(28,'Michael','J.Fox');
insert into actor values(29,'Christopher','Lloyd');
insert into actor values(30,'Lea','Thompson');

insert into actor_film values(1,1,'Frank Moses');
insert into actor_film values(1,2,'Joe Matheson');
insert into actor_film values(1,3,'Marvin Boggs');

insert into actor_film values(2,4,'Kevin Lomax');
insert into actor_film values(2,5,'John Milton/Satan');
insert into actor_film values(2,6,'Mary Ann Lomax');

insert into actor_film values(3,7,'Andy Dufresne');
insert into actor_film values(3,8,'Ellis Boyd "Red" Redding');
insert into actor_film values(3,9,'Samuel Norton');

insert into actor_film values(4,10,'Frodo Baggins');
insert into actor_film values(4,11,'Gandalf the White');
insert into actor_film values(4,12,'Aragorn Elessar');

insert into actor_film values(5,13,'Dom Cobb');
insert into actor_film values(5,14,'Arthur');
insert into actor_film values(5,15,'Ariadne');

insert into actor_film values(6,16,'Clarice Starling');
insert into actor_film values(6,17,'Dr. Hannibal Lecter');
insert into actor_film values(6,18,'Jack Crawford');

insert into actor_film values(7,19,'Léon Montana');
insert into actor_film values(7,20,'Mathilda Lando');
insert into actor_film values(7,21,'Norman Stansfield');

insert into actor_film values(8,22,'Joseph Cooper');
insert into actor_film values(8,23,'Amelia Brand');
insert into actor_film values(8,24,'Murphy Cooper');

insert into actor_film values(9,25,'William "Billy" Costigan');
insert into actor_film values(9,26,'Colin Sullivan');
insert into actor_film values(9,27,'Franklin "Frank" Costello');

insert into actor_film values(10,28,'Marty McFly');
insert into actor_film values(10,29,'Dr.Emmett "Doc" Brown');
insert into actor_film values(10,30,'Lorraine Baines-McFly');

insert into crew values(1,'Robert Schwentke','Florian Ballhaus','Christophe Beck');

insert into crew values(2,'Taylor Hackford','Andrzej Bartkowiak','James Newton Howard');

insert into crew values(3,'Frank Darabont','Roger Deakins','Thomas Newman');

insert into crew values(4,'Peter Jackson','Andrew Lesnie','Howard Shore');

insert into crew values(5,'Christopher Nolan','Wally Pfister','Hans Zimmer');

insert into crew values(6,'Jonathan Demme','Tak Fujimoto','Howard Shore');

insert into crew values(7,'Luc Besson','Thierry Arbogast','Éric Serra');

insert into crew values(8,'Christopher Nolan','Hoyte van Hoytema','Hans Zimmer');

insert into crew values(9,'Martin Scorsese','Michael Ballhaus','Howard Shore');

insert into crew values(10,'Robert Zemeckis','Dean Cundey','Alan Silvestri');

insert into crew values(11,'Taylor Hackford','Andrzej Bartkowiak','James Newton Howard');