
truncate table buses;
--insert buses
insert into buses(make, manufacturedOn) values('AutoSan', '1995-12-07');
insert into buses(make, manufacturedOn) values('Sun', '2000-07-21');

truncate table stations;
--insert stations
insert into stations(name) values('Trzcianka'); --1
insert into stations(name) values('Czarnków'); --2
insert into stations(name) values('Oborniki'); --3
insert into stations(name) values('Poznań'); --4
insert into stations(name) values('Piła'); --5

truncate table distances;
--insert distances
insert into distances(stationFrom, stationTo, distance) values (1, 2, 17);
insert into distances(stationFrom, stationTo, distance) values (2, 3, 55);
insert into distances(stationFrom, stationTo, distance) values (3, 4, 28);
insert into distances(stationFrom, stationTo, distance) values (1, 4, 24);
insert into distances(stationFrom, stationTo, distance) values (4, 5, 110);

truncate table lines
--insert lines
insert into lines(idBus, description) values(1, 'Trzcianka-Poznań');


truncate table routes;
--insert routes
insert into routes(idLine, idStation, arrivalTime, departureTime) values(1, 1, '05:48', '05:50');
insert into routes(idLine, idStation, arrivalTime, departureTime) values(1, 2, '06:20', '06:25');
insert into routes(idLine, idStation, arrivalTime, departureTime) values(1, 3, '06:55', '07:00');
insert into routes(idLine, idStation, arrivalTime, departureTime) values(1, 4, '07:50', null);
