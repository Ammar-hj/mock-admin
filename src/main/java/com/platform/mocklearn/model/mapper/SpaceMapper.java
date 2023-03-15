package com.platform.mocklearn.model.mapper;

import com.platform.mocklearn.model.entity.Space;
import com.platform.mocklearn.model.entity.SpaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceMapper {
    long countByExample(SpaceExample example);

    int deleteByExample(SpaceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Space record);

    int insertSelective(Space record);

    List<Space> selectByExample(SpaceExample example);

    Space selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Space record, @Param("example") SpaceExample example);

    int updateByExample(@Param("record") Space record, @Param("example") SpaceExample example);

    int updateByPrimaryKeySelective(Space record);

    int updateByPrimaryKey(Space record);
}