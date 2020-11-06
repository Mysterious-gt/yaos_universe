package cn.sunyog.yaos.sys.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: MysteriousGT
 * @Date: 2020/11/6 11:33 上午
 * @Desc: 系统返回值
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysResult implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code=200;
    private String msg;
    private Object data;
}
