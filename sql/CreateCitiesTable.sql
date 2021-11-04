-- *************** SqlDBM: PostgreSQL ****************;
-- ***************************************************;

CREATE SCHEMA IF NOT EXISTS "public";


-- ************************************** "Towns"

CREATE TABLE IF NOT EXISTS "Cities"
(
 "name"       varchar(50) NOT NULL,
 "country_id" int NOT NULL,
 "id"         int NOT NULL,
 CONSTRAINT "PK_35" PRIMARY KEY ( "id" ),
 CONSTRAINT "FK_55" FOREIGN KEY ( "country_id" ) REFERENCES "Countries" ( "id" )
);

CREATE INDEX "fkIdx_57" ON "Cities"
(
 "country_id"
);










