INSERT INTO currency (curid,curname) VALUES('UAH','Hryvnia');
INSERT INTO currency(curid,curname) VALUES('USD','Dollar');
INSERT INTO currency (curid,curname) VALUES('RUB','Ruble');

  INSERT INTO interbank(id, curid, pointDate, date, bid, ask, deleted, trendBid, trendAsk)
	VALUES('1', 'usd', '2016-09-11 17:31:01', '2016-09-12 16:01:01', 26.6600, 26.7000, null, 1, 2);

	INSERT INTO interbank(id, curid, pointDate, date, bid, ask, deleted, trendBid, trendAsk)
	VALUES('2', 'eur', '2016-09-11 17:32:01', '2016-09-12 16:01:01', 29.9740, 30.0160, null, 1, 2);

	INSERT INTO interbank(id, curid, pointDate, date, bid, ask, deleted, trendBid, trendAsk)
	VALUES('3', 'eur', '2016-09-11 17:33:01', '2016-09-09 16:01:01', 29.9840, 30.2160, null, 1, 2);

	INSERT INTO interbank(id, curid, pointDate, date, bid, ask, deleted, trendBid, trendAsk)
	VALUES('4', 'rub', '2016-09-11 17:34:01', '2016-09-09 16:01:01', 0.4130, 0.4150, null, 1, 2);

	INSERT INTO interbank(id, curid, pointDate, date, bid, ask, deleted, trendBid, trendAsk)
	VALUES('5', 'usd', '2016-09-11 17:35:01', '2016-09-09 16:01:01', 26.2000, 26.9000, null, 1, 2);

	INSERT INTO interbank(id, curid, pointDate, date, bid, ask, deleted, trendBid, trendAsk)
	VALUES('6', 'usd', '2016-09-11 17:36:01', '2016-09-09 16:01:01', 26.2100, 26.8300, null, 1, 2);

	INSERT INTO interbank(id, curid, pointDate, date, bid, ask, deleted, trendBid, trendAsk)
	VALUES('7', 'usd', '2016-09-09 17:37:01', '2016-09-09 16:01:01', 12, 23, null, 1, 2);

	INSERT INTO interbank(id, curid, pointDate, date, bid, ask, deleted, trendBid, trendAsk)
	VALUES('8', 'UAH', '2016-09-09 17:38:01', '2016-09-09 16:01:01', 12, 23, null, 1, 2);