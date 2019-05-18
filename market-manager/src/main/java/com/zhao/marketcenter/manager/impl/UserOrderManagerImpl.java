package com.zhao.marketcenter.manager.impl;

import com.zhao.marketcenter.common.util.JsonUtil;
import com.zhao.marketcenter.dao.BaseQTO;
import com.zhao.marketcenter.dao.UserDAO;
import com.zhao.marketcenter.dao.entity.UserDO;
import com.zhao.marketcenter.dao.entity.UserQTO;
import com.zhao.marketcenter.manager.UserOrderManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.rmi.ServerException;
import java.util.List;


@Service
public class UserOrderManagerImpl implements UserOrderManager {
    private static Logger logger = LoggerFactory.getLogger(UserOrderManagerImpl.class);

    @Resource
    private UserDAO userDAO;


    @Override
    public long add(UserDO userDO) throws ServerException {
        //入参校验
        if(userDO == null) {
            logger.error("invalid param, param:{}", JsonUtil.toJson(userDO));
            throw new IllegalArgumentException("param is null");
        }

        //访问数据库
        try {
            userDAO.add(userDO);
            return userDO.getId();
        } catch(Exception e) {
            logger.error("error to add, param:{}", JsonUtil.toJson(userDO), e);
            throw new ServerException("error to add");
        }
    }

    @Override
    public int deleteById(long id) throws ServerException {
        //入参校验
        if(id <= 0) {
            logger.error("invalid param, param:{}", id);
            throw new IllegalArgumentException("param is invalid");
        }

        //访问数据库
        try {
            return userDAO.deleteById(id);
        } catch(Exception e) {
            logger.error("error to deleteById, param:{}", id, e);
            throw new ServerException("error to deleteById");
        }
    }

    @Override
    public int delete(List<Long> idList) throws ServerException {
        //入参校验
        if(idList == null || idList.isEmpty()) {
            logger.error("invalid param, param:{}", JsonUtil.toJson(idList));
            throw new IllegalArgumentException("param is invalid");
        }

        //访问数据库
        try {
            return userDAO.delete(idList);
        } catch(Exception e) {
            logger.error("error to deleteById, param:{}", JsonUtil.toJson(idList), e);
            throw new ServerException("error to delete");
        }
    }

    @Override
    public int updateById(UserDO userDO) throws ServerException {
        //入参校验
        if(userDO == null) {
            logger.error("invalid param, param:{}", JsonUtil.toJson(userDO));
            throw new IllegalArgumentException("param is null");
        }
        if(userDO.getId() == null || userDO.getId().longValue() <= 0) {
            logger.error("invalid param, param:{}", JsonUtil.toJson(userDO));
            throw new IllegalArgumentException("param is invalid");
        }

        //访问数据库
        try {
            return userDAO.updateById(userDO);
        } catch(Exception e) {
            logger.error("error to updateById, param:{}", JsonUtil.toJson(userDO), e);
            throw new ServerException("error to updateById");
        }
    }

    @Override
    public UserDO get(long id) throws ServerException {
        //入参校验
        if(id <= 0) {
            logger.error("invalid param, param:{}", id);
            throw new IllegalArgumentException("param is invalid");
        }

        //访问数据库
        try {
            return userDAO.get(id);
        } catch(Exception e) {
            logger.error("error to get, param:{}", id, e);
            throw new ServerException("error to get");
        }
    }

    @Override
    public List<UserDO> query(UserQTO userQTO) throws ServerException {
        //入参校验
        if(userQTO == null) {
            logger.error("invalid param, param:{}", JsonUtil.toJson(userQTO));
            throw new IllegalArgumentException("param is null");
        }

        //设置查询记录上限，保护数据库
        if(userQTO.getCount() >= BaseQTO.MAX_COUNT) {
            userQTO.setCount(BaseQTO.MAX_COUNT);
        }

        //访问数据库
        try {
            return userDAO.query(userQTO);
        } catch(Exception e) {
            logger.error("error to query, param:{}", JsonUtil.toJson(userQTO), e);
            throw new ServerException("error to query");
        }
    }

    @Override
    public long getTotalCount(UserQTO userQTO) throws ServerException {
        //入参校验
        if(userQTO == null) {
            logger.error("invalid param, param:{}", JsonUtil.toJson(userQTO));
            throw new IllegalArgumentException("param is null");
        }

        //设置查询记录上限，保护数据库
        if(userQTO.getCount() >= BaseQTO.MAX_COUNT) {
            userQTO.setCount(BaseQTO.MAX_COUNT);
        }

        //访问数据库
        try {
            return userDAO.getTotalCount(userQTO);
        } catch(Exception e) {
            logger.error("error to getTotalCount, param:{}", JsonUtil.toJson(userQTO), e);
            throw new ServerException("error to getTotalCount");
        }
    }
}

