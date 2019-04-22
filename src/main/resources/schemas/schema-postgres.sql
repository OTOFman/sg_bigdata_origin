-- DROP TABLE IF EXISTS CommunityInfo;
CREATE TABLE IF NOT EXISTS CommunityInfo(id serial PRIMARY KEY,
                        community_name VARCHAR(100),
                        build_year VARCHAR(100),
                        building_amount INTEGER ,
                        apartment_amount INTEGER ,
                        price INTEGER);
create table IF NOT EXISTS TempCommunitiesName (id serial PRIMARY KEY, name varchar(100))