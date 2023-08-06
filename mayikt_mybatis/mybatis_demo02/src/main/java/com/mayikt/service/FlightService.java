package com.mayikt.service;

import com.mayikt.entity.FligtEntity;
import com.mayikt.mapper.FlightMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class FlightService {
    private FlightMapper flightMapper;
    private SqlSession sqlSession;

    public FlightService() throws IOException {
        // 通过无参构造方法 初始化mybatis 得到flightMapper
        // mybatis-config.xml 目录位置
        String resource = "mybatis-config.xml";
        // 1.解析mybatis-config.xml 得到数据库相关的配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.创建得到一个sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.获取到sqlSession
        sqlSession = sqlSessionFactory.openSession();
        flightMapper = sqlSession.getMapper(FlightMapper.class);
//        sqlSession.close();
    }

    public List<FligtEntity> getByAllFlight() {
        return flightMapper.getByAllFlight();
    }

    public List<FligtEntity> getByAllFlight2() {
        return flightMapper.getByAllFlight2();
    }

    public FligtEntity getByIdFligh(Integer id) {
        return flightMapper.getByIdFlight(id);
    }

    public int insertFligh(FligtEntity fligtEntity) {
        int result = flightMapper.insertFlight(fligtEntity);
        // 需要提交事务事务的
        sqlSession.commit();
        return result;
    }

    public int deleteByIDFlight(Integer id) {
        int result = flightMapper.deleteByIDFlight(id);
        sqlSession.commit();
        return result;
    }

    public int updateFlight(FligtEntity fligtEntity) {
        int result = flightMapper.updateFlight(fligtEntity);
        sqlSession.commit();
        return result;
    }

    public List<FligtEntity> selectFlightMap(Map<String, String> map) {
        return flightMapper.selectFlightMap(map);
    }

    public List<FligtEntity> selectFlight(String company, String model, String arriveAirport) {
        return flightMapper.selectFlight(company, model, arriveAirport);
    }

    public List<FligtEntity> selectFlightPoJo(FligtEntity fligtEntity) {
        return flightMapper.selectFlightPoJo(fligtEntity);
    }
}
