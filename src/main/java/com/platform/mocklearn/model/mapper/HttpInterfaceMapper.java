package com.platform.mocklearn.model.mapper;

import com.platform.mocklearn.model.entity.HttpInterface;
import com.platform.mocklearn.model.entity.HttpInterfaceExample;
import com.platform.mocklearn.model.entity.HttpInterfaceWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Repository
public interface HttpInterfaceMapper {
    long countByExample(HttpInterfaceExample example);

    int deleteByExample(HttpInterfaceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HttpInterfaceWithBLOBs record);

    int insertSelective(HttpInterfaceWithBLOBs record);

    List<HttpInterfaceWithBLOBs> selectByExampleWithBLOBs(HttpInterfaceExample example);

    List<HttpInterface> selectByExample(HttpInterfaceExample example);

    HttpInterfaceWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HttpInterfaceWithBLOBs record, @Param("example") HttpInterfaceExample example);

    int updateByExampleWithBLOBs(@Param("record") HttpInterfaceWithBLOBs record, @Param("example") HttpInterfaceExample example);

    int updateByExample(@Param("record") HttpInterface record, @Param("example") HttpInterfaceExample example);

    int updateByPrimaryKeySelective(HttpInterfaceWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(HttpInterfaceWithBLOBs record);

    int updateByPrimaryKey(HttpInterface record);

    List<HttpInterface> selectByExampleWithRowBounds(HttpInterfaceExample example, RowBounds rowBounds);
}