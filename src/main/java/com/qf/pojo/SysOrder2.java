package com.qf.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lcs
 * @since 2020-08-20
 */
@Data
public class SysOrder2 {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer oid;

    private Double oprice;

    private String cname;

    private String getcity;

    private String backcity;

    private String ostatus;



}
