CREATE TABLE users (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(50)
);

CREATE TABLE currency  (
	curid  	varchar(5) NOT NULL,
	curname	varchar(50) NOT NULL,
	PRIMARY KEY(curid)
)