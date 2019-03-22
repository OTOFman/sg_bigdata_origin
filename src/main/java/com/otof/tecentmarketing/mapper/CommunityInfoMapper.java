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

    @Select("select sum(c.building_amount)  building_amount, avg(c.price) avg_price, sum(c.apartment_amount) apartment_amount from tempcommunitiesname t, communityinfo c where c.community_name like '%' || t.name ||'%'")
    @Results({
            @Result(property = "buildingAmount", column = "building_amount"),
            @Result(property = "apartmentAmount", column = "apartment_amount"),
            @Result(property = "avgPrice", column = "avg_price")
    })
    CommunityStatisticEntity getCommunityStatisticByNameList();

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
    }
}
