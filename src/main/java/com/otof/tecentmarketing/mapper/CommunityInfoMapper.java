package com.otof.tecentmarketing.mapper;

import com.otof.tecentmarketing.entity.CommunityInfoEntity;
import com.otof.tecentmarketing.entity.CommunityStatisticEntity;
import org.apache.ibatis.annotations.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper
public interface CommunityInfoMapper {

    @InsertProvider(type = Provider.class, method = "batchInsert")
    int batchInsertCommunityInfo(List<CommunityInfoEntity> communities);

    @SelectProvider(type = Provider.class, method = "selectStatistic")
    @Results({
            @Result(property = "avgBuildingAmount", column = "avg_building_amount"),
            @Result(property = "avgApartmentAmount", column = "avg_apartment_amount"),
            @Result(property = "avgPrice", column = "avg_price")
    })
    CommunityStatisticEntity getCommunityStatisticByNameList(List<String> communityNameList);

    @Select("select c.* from tempcommunitiesname t, communityinfo c where c.community_name like '%' || t.name ||'%'")
    @Results({
            @Result(property = "communityName", column = "community_name"),
            @Result(property = "buildYear", column = "build_year"),
            @Result(property = "buildingAmount", column = "building_amount"),
            @Result(property = "apartmentAmount", column = "apartment_amount"),
            @Result(property = "price", column = "price")
    })
    Set<CommunityInfoEntity> getCommunitiesInfoByNameList();


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

        public String selectStatistic(Map map) {
            List<String> communityNameList = (List<String>)map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("select avg(building_amount)  avg_building_amount, avg(price) avg_price, avg(apartment_amount) avg_apartment_amount from CommunityInfo where ");
            for (int i = 0; i < communityNameList.size(); i++) {
                sb.append("('" + communityNameList.get(i) + "' ~ community_name AND community_name != '')");
                if (i < communityNameList.size() - 1)
                    sb.append(" or ");
            }
            return sb.toString();
        }
    }
}
