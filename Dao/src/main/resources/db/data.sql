INSERT INTO currency (curid,curname) VALUES('UAH','Hryvnia');
INSERT INTO currency(curid,curname) VALUES('USD','Dollar');
INSERT INTO currency (curid,curname) VALUES('RUB','Ruble');

INSERT INTO interbank(id, curid, pointDate, date, bid, ask, deleted, trendBid, trendAsk)
	VALUES('1', 'UAH', '2016-9-4 23:30:16', '2016-9-4 23:30:16', 12, 23, null, 1, 2);