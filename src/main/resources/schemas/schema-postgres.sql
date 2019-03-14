DROP TABLE IF EXISTS webcontent;
CREATE TABLE CommunityInfo(id serial PRIMARY KEY,
                        community_name VARCHAR(100),
                        build_year VARCHAR(100),
                        building_amount INTEGER,
                        apartment_amount INTEGER,
                        price INTEGER );