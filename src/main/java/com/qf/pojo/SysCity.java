package com.qf.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2020-08-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysCity extends Model<SysCity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("pid")
    private Integer pid;

//    private String cname;
//
//    private Integer ppid;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
