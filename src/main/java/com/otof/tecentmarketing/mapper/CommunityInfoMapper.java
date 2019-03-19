package com.otof.tecentmarketing.mapper;

import com.otof.tecentmarketing.entity.CommunityInfoEntity;
import org.apache.ibatis.annotations.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

@Mapper
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

    @InsertProvider(type = Provider.class, method = "batchInsert")
    int batchInsertCommunityInfo(List<CommunityInfoEntity> communities);

    @SelectProvider(type = Provider.class, method = "likeInList")
    @Results({
            @Result(property = "communityName", column = "community_name"),
            @Result(property = "buildYear", column = "build_year"),
            @Result(property = "buildingAmount", column = "building_amount"),
            @Result(property = "apartmentAmount", column = "apartment_amount"),
            @Result(property = "price", column = "price")
    })
    List<CommunityInfoEntity> getCommunityInfoByNameList(List<String> communityNameList);

    class Provider {
        /* 批量插入 */
        public String batchInsert(Map map ) {
            List<CommunityInfoEntity> communities = (List<CommunityInfoEntity>)map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO CommunityInfo (community_name, build_year, building_amount, apartment_amount, price) VALUES ");
            MessageFormat mf = new MessageFormat(
                    "(#'{'list[{0}].communityName}, #'{'list[{0}].buildYear}, #'{'list[{0}].buildingAmount}, #'{'list[{0}].apartmentAmount}, #'{'list[{0}].price})"
            );

            for (int i = 0; i < communities.size(); i++) {
                sb.append(mf.format(new Object[] {i}));
                if (i < communities.size() - 1)
                    sb.append(",");
            }
            return sb.toString();
        }

        public String likeInList(Map map) {
            List<String> communityNameList = (List<String>)map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("select * from CommunityInfo where ");
            for (int i = 0; i < communityNameList.size(); i++) {
                sb.append("('" + communityNameList.get(i) + "' ~ community_name AND community_name != '')");
                if (i < communityNameList.size() - 1)
                    sb.append(" or ");
            }
            return sb.toString();
        }
    }
}
