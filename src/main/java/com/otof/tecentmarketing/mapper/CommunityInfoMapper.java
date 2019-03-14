package com.otof.tecentmarketing.mapper;

import com.otof.tecentmarketing.entity.CommunityInfoEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CommunityInfoMapper {

    @Select("select * from CommunityInfo")
    @Results({
            @Result(property = "communityName", column = "community_name"),
            @Result(property = "buildYear", column = "build_year"),
            @Result(property = "buildingAmount", column = "building_amount"),
            @Result(property = "apartmentAmount", column = "apartment_amount"),
            @Result(property = "price", column = "price")
    })
    List<CommunityInfoEntity> getAllContents();


    @Insert("insert into CommunityInfo(community_name, build_year, building_amount, apartment_amount, price) values (#{communityName}, #{buildYear}, #{buildingAmount}, #{apartmentAmount}, #{price})")
    void insertCommunityInfo(CommunityInfoEntity entity);
}
