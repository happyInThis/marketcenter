package com.zhao.marketcenter.dao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseDO implements Serializable {
    /**
     * 记录id
     */
    private Long id;
    /**
     * 逻辑删除标志，0代表正常，1代表已删除
     */
    private Integer deleteMark = 0;
    /**
     * 删除时间戳，当记录状态为正常时，该字段的值为0；如果记录被删除，则该字段代表删除时间，单位为毫秒
     */
    private Long deleteTimestamp = 0L;
    /**
     * 记录创建时间
     */
    private Date gmtCreated;
    /**
     * 记录最后一次修改时间
     */
    private Date gmtModified;
}
