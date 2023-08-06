package com.mayikt.test;

import com.mayikt.entity.FligtEntity;
import com.mayikt.service.FlightService;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class test01 {
    public static void main(String[] args) throws IOException {
        FlightService flightService = new FlightService();
        List<FligtEntity> allFlight = flightService.getByAllFlight2();
        System.out.println(allFlight);
        FligtEntity idFligh = flightService.getByIdFligh(2);
        System.out.println(idFligh);
        FligtEntity fligtEntity = new FligtEntity();
//        fligtEntity.setFlightId("3");
//        fligtEntity.setCompany("北京航空公司");
//        fligtEntity.setArriveAirport("深圳");
//        fligtEntity.setDepartureAirport("北京");
//        fligtEntity.setModel("999");
//        fligtEntity.setIsDelete(1);
//        fligtEntity.setArriveTime(new Date());
//        fligtEntity.setDepartureTime(new Date());
//        int result = flightService.insertFligh(fligtEntity);
//        System.out.println(result);
//        int result2 = flightService.deleteByIDFlight(3);
//        System.out.println(result2);
//        fligtEntity.setId(3);
//        fligtEntity.setFlightId("3");
//        fligtEntity.setCompany("北京航空公司");
//        fligtEntity.setArriveAirport("深圳");
//        fligtEntity.setDepartureAirport("北京");
//        fligtEntity.setModel("222");
//        fligtEntity.setIsDelete(1);
//        fligtEntity.setArriveTime(new Date());
//        fligtEntity.setDepartureTime(new Date());
//        int result3 = flightService.updateFlight(fligtEntity);
//        System.out.println(result3);
        // 1. hashMap 实现多条件查询
//        HashMap<String, String> stringStringHashMap = new HashMap<>();
//        stringStringHashMap.put("company","山东航空公司");
//        stringStringHashMap.put("model","725");
//        stringStringHashMap.put("arriveAirport","北京");
//        List<FligtEntity> fligtEntities = flightService.selectFlightMap(stringStringHashMap);
//        System.out.println(fligtEntities);
        // 2. @para 实现多条件查询
//        List<FligtEntity> fligtEntities = flightService.selectFlight("山东航空公司", "725", "北京");
//        System.out.println(fligtEntities);
        // 3. pojo
        fligtEntity.setModel("725");
//        fligtEntity.setCompany("山东航空公司");
        fligtEntity.setArriveAirport("北京");
        List<FligtEntity> fligtEntities = flightService.selectFlightPoJo(fligtEntity);
        System.out.println(fligtEntities);
    }
}