CREATE TABLE currency  (
	curid  	varchar(5) NOT NULL,
	curname	varchar(50) NOT NULL,
	PRIMARY KEY(curid)
);

create table interbank
(
   id                   varchar(12) not null,
   curid                varchar(5),
   pointDate            datetime not null,
   dayDate                 datetime not null,
   bid                  decimal(5,2),
   ask                  decimal(5,2),
   deleted              varchar(1),
   trendBid             decimal(5,2),
   trendAsk             decimal(5,2),
   primary key (id)
);