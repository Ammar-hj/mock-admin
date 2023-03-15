package com.platform.mocklearn.model.mapper;

import com.platform.mocklearn.model.entity.HttpInterfaceHeader;
import com.platform.mocklearn.model.entity.HttpInterfaceHeaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HttpInterfaceHeaderMapper {
    long countByExample(HttpInterfaceHeaderExample example);

    int deleteByExample(HttpInterfaceHeaderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HttpInterfaceHeader record);

    int insertSelective(HttpInterfaceHeader record);

    List<HttpInterfaceHeader> selectByExample(HttpInterfaceHeaderExample example);

    HttpInterfaceHeader selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HttpInterfaceHeader record, @Param("example") HttpInterfaceHeaderExample example);

    int updateByExample(@Param("record") HttpInterfaceHeader record, @Param("example") HttpInterfaceHeaderExample example);

    int updateByPrimaryKeySelective(HttpInterfaceHeader record);

    int updateByPrimaryKey(HttpInterfaceHeader record);
}