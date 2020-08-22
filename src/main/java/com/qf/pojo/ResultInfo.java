package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * @Auther: Lcs
 * @Date: 2020/8/19 22:19
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfo {

    private Integer id;

    private String tel;

    private SysUser user;

    private String name;

    private Integer code;

    private String info;

    private Set mcs;

    private Set citys;

}
