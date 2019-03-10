package com.example.manager.wxmanager.dao;

import com.example.manager.wxmanager.model.TestModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TestDAO extends Mapper<TestModel> {


//    @Select("select * from test")
    List<TestModel> selectTest();

    @Insert("insert into test (ago,name) values(#{ago},#{name})")
    int insertTest(TestModel testModel);
}
