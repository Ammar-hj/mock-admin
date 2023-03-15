package com.platform.mocklearn.model.dao.impl;

import com.platform.mocklearn.enums.RespCodeEnum;
import com.platform.mocklearn.exception.MockException;
import com.platform.mocklearn.model.dao.InterfaceBranchDao;
import com.platform.mocklearn.model.entity.InterfaceBranch;
import com.platform.mocklearn.model.entity.InterfaceBranchExample;
import com.platform.mocklearn.model.entity.InterfaceBranchWithBLOBs;
import com.platform.mocklearn.model.mapper.InterfaceBranchMapper;
import com.platform.mocklearn.model.request.HttpInterfaceBranchReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class InterfaceBranchDaoImpl implements InterfaceBranchDao {

    @Autowired
    InterfaceBranchMapper interfaceBranchMapper;

    @Override
    public void batchCreate(List<HttpInterfaceBranchReq> interfaceBranchList, Long httpInterfaceId) {
        interfaceBranchList.forEach(httpInterfaceBranch -> {
            InterfaceBranchWithBLOBs interfaceBranch = convertToDO(httpInterfaceBranch, httpInterfaceId);

            int count;
            try {
                count = interfaceBranchMapper.insert(interfaceBranch);
            } catch (DuplicateKeyException e) {
                throw new MockException(RespCodeEnum.INTERFACE_BRANCH_EXISTS);
            }

            if (count != 1) {
                throw new MockException(RespCodeEnum.INSERT_ERROR);
            }
        });
    }

    @Override
    public List<HttpInterfaceBranchReq> batchQuery(Long httpInterfaceId) {
        InterfaceBranchExample example = new InterfaceBranchExample();
        example.createCriteria()
                .andHttpInterfaceIdEqualTo(httpInterfaceId);
        return convertToBOList(interfaceBranchMapper.selectByExample(example));
    }

    @Override
    public void batchDelete(Long id){
        InterfaceBranchExample example = new InterfaceBranchExample();
        example.createCriteria().andHttpInterfaceIdEqualTo(id);
        interfaceBranchMapper.deleteByExample(example);
    }

    private InterfaceBranchWithBLOBs convertToDO(HttpInterfaceBranchReq interfaceBranch, Long httpInterfaceId) {
        InterfaceBranchWithBLOBs interfaceBranchWithBLOBs = new InterfaceBranchWithBLOBs();
        BeanUtils.copyProperties(interfaceBranch, interfaceBranchWithBLOBs);
        interfaceBranchWithBLOBs.setHttpInterfaceId(httpInterfaceId);
        return interfaceBranchWithBLOBs;
    }

    private HttpInterfaceBranchReq convertToReq(InterfaceBranch interfaceBranch) {
        HttpInterfaceBranchReq httpInterfaceBranchReq = new HttpInterfaceBranchReq();
        BeanUtils.copyProperties(interfaceBranch, httpInterfaceBranchReq);
        return httpInterfaceBranchReq;
    }

    private List<HttpInterfaceBranchReq> convertToBOList(List<InterfaceBranch> interfaceBranchList) {
        List<HttpInterfaceBranchReq> httpInterfaceBranchReqs = new LinkedList<>();
        interfaceBranchList.forEach(httpInterfaceBranch
                -> httpInterfaceBranchReqs.add(convertToReq(httpInterfaceBranch)));
        return httpInterfaceBranchReqs;
    }
}
