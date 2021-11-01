-- Warning: You can generate script only for one table/view at a time in your Free plan 
-- 
-- *************** SqlDBM: PostgreSQL ****************;
-- ***************************************************;

CREATE SCHEMA IF NOT EXISTS "public";


-- ************************************** "Rating"

CREATE TABLE IF NOT EXISTS "Ratings"
(
 "location_id" int NOT NULL,
 "grade"       int NOT NULL,
 "Id"          int NOT NULL,
 CONSTRAINT "PK_26" PRIMARY KEY ( "Id" ),
 CONSTRAINT "FK_58" FOREIGN KEY ( "location_id" ) REFERENCES "Locations" ( "id" )
);

CREATE INDEX "fkIdx_60" ON "Ratings"
(
 "location_id"
);







