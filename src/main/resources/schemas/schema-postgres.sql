DROP TABLE IF EXISTS CommunityInfo;
CREATE TABLE CommunityInfo(id serial PRIMARY KEY,
                        community_name VARCHAR(100),
                        build_year VARCHAR(100),
                        building_amount VARCHAR(100),
                        apartment_amount VARCHAR(100),
                        price VARCHAR(100));