package com.platform.mocklearn.model.mapper;

import com.platform.mocklearn.model.entity.HttpInterfaceSnapshot;
import com.platform.mocklearn.model.entity.HttpInterfaceSnapshotExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HttpInterfaceSnapshotMapper {
    long countByExample(HttpInterfaceSnapshotExample example);

    int deleteByExample(HttpInterfaceSnapshotExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HttpInterfaceSnapshot record);

    int insertSelective(HttpInterfaceSnapshot record);

    List<HttpInterfaceSnapshot> selectByExampleWithBLOBs(HttpInterfaceSnapshotExample example);

    List<HttpInterfaceSnapshot> selectByExample(HttpInterfaceSnapshotExample example);

    HttpInterfaceSnapshot selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HttpInterfaceSnapshot record, @Param("example") HttpInterfaceSnapshotExample example);

    int updateByExampleWithBLOBs(@Param("record") HttpInterfaceSnapshot record, @Param("example") HttpInterfaceSnapshotExample example);

    int updateByExample(@Param("record") HttpInterfaceSnapshot record, @Param("example") HttpInterfaceSnapshotExample example);

    int updateByPrimaryKeySelective(HttpInterfaceSnapshot record);

    int updateByPrimaryKeyWithBLOBs(HttpInterfaceSnapshot record);

    int updateByPrimaryKey(HttpInterfaceSnapshot record);
}