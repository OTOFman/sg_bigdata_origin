package com.otof.tecentmarketing.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TempTableMapper {

    @Delete("truncate table TempCommunitiesName")
    void deleteTempCommunitiesName();

    @InsertProvider(type = Provider.class, method = "batchInsertNames")
    void insertTempCommunitiesName(List<String> communityList);

    class Provider {
        public String batchInsertNames(Map map) {
            List<String> nameList = (List<String>)map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("insert into TempCommunitiesName (name) values ");
            nameList.forEach(v -> sb.append("('" + v + "'),"));
            sb.deleteCharAt(sb.lastIndexOf(","));

            return sb.toString();
        }
    }
}
