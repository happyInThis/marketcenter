package com.zhao.marketcenter.dao.DAO;

import com.zhao.marketcenter.dao.entity.DO.UserDO;
import com.zhao.marketcenter.dao.entity.QTO.UserQTO;

import java.util.List;

public interface UserDAO {
    /**
     * 新增一条记录信息
     *
     * @param userDO
     * @return int 新增成功的记录条数
     */
    int add(UserDO userDO);

    /**
     * 基于id进行删除
     *
     * @param id
     * @return int 删除成功的记录条数
     */
    int deleteById(long id);

    /**
     * 根据id列表批量删除
     *
     * @param idList 待删除id列表
     * @return int 删除成功的记录条数
     */
    int delete(List<Long> idList);

    /**
     * 根据id更新记录
     *
     * @param userDO
     * @return int 更新成功的记录条数
     */
    int updateById(UserDO userDO);

    /**
     * 根据id获取单条记录
     *
     * @param id 查询的记录id
     * @return UserDO 对应的记录信息
     */
    UserDO get(long id);

    /**
     * 复合查询多条记录
     *
     * @param userQTO 复合查询条件封装对象
     * @return List<UserDO> 查询到的记录信息列表
     */
    List<UserDO> query(UserQTO userQTO);

    /**
     * 获取复合查询结果的总记录数
     *
     * @param userQTO 复合查询条件封装对象
     * @return long 复合查询结果的总记录数
     */
    long getTotalCount(UserQTO userQTO);
}
