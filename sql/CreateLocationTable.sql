-- *************** SqlDBM: PostgreSQL ****************;
-- ***************************************************;

CREATE SCHEMA IF NOT EXISTS "public";


-- ************************************** "Locations"

CREATE TABLE IF NOT EXISTS "Locations"
(
 "name"              varchar(50) NOT NULL,
 "country_id"        int NOT NULL,
 "description"       varchar(50) NOT NULL,
 "longitude"         decimal NOT NULL,
 "created at"        timestamp NOT NULL,
 "status"            varchar(50) NOT NULL,
 "importance_status" varchar(50) NOT NULL,
 "city_id"           int NOT NULL,
 "id"                int NOT NULL,
 CONSTRAINT "PK_5" PRIMARY KEY ( "id" ),
 CONSTRAINT "FK_61" FOREIGN KEY ( "country_id" ) REFERENCES "Countrys" ( "id" ),
 CONSTRAINT "FK_64" FOREIGN KEY ( "city_id" ) REFERENCES "Towns" ( "id" )
);

CREATE INDEX "fkIdx_63" ON "Locations"
(
 "country_id"
);

CREATE INDEX "fkIdx_66" ON "Locations"
(
 "city_id"
);








