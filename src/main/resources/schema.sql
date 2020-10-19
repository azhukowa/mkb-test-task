create table CAR (
  id IDENTITY primary key,
  brand VARCHAR2(150),
  model VARCHAR2(200),
  power DOUBLE,
  year_of_issue YEAR
  --,assessed_value DEC(20)
);

create table AIRPLANE (
  id IDENTITY primary key,
  brand VARCHAR2(150),
  model VARCHAR2(200),
  manufacturer VARCHAR2(500),
  year_of_issue YEAR,
  fuel_сapacity INT,
  seats INT
);


create table ASSESSED_VALUE (
  id IDENTITY primary key,
  collateral_type VARCHAR2(30),
  assessed_value DEC(20),
  year_of_issue TIMESTAMP
);