package com.mayikt.mapper;

import com.mayikt.entity.FligtEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FlightMapper {
    /**
     * mybatis 实现查询
     * 1. 查询所有
     * 2. 根据条件查询
     * 3. 动态查询
     */
    List<FligtEntity> getByAllFlight();
    List<FligtEntity> getByAllFlight2();
    FligtEntity getByIdFlight(Integer id);
    int insertFlight(FligtEntity fligtEntity);
    int deleteByIDFlight(Integer id);
    int updateFlight(FligtEntity fligtEntity);
    /**
     * mybatis动态条件查询
     * 1. 传递map 型
     * 2. 多个参数的时候要使用 @Param 给指定参数，否则会出现找不到参数的错误
     * 3. 传递pojo   非常多参数  sql语句中获取参数值名称 与对象成员属性名称需要保持一致
     */
    // 1. 传递map 型  key value
    List<FligtEntity> selectFlightMap(Map<String,String> map);
    // 2. 使用 @Param 给指定参数
    List<FligtEntity> selectFlight(@Param("company") String company,
                                   @Param("model") String model,
                                   @Param("arriveAirport") String arriveAirport);
    // 3. 传递pojo   非常多参数
    List<FligtEntity> selectFlightPoJo(FligtEntity fligtEntity);
}
