package com.qf.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lcs
 * @since 2020-08-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysOrder extends Model<SysOrder> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer cid;

    private Integer uid;

    private Integer getid;

    private Integer backid;

    private Double oprice;

    private String status;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
