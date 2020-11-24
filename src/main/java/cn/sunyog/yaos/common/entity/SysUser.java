package cn.sunyog.yaos.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: MysteriousGT
 * @Date: 2020/11/5 11:25 上午
 * @Desc: demo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SysUser implements Serializable {
    private static final long serialVersionUID = -3408278709212634056L;
    private Long userId;
    @NotNull(message = "参数不能为空")
    @Length(min = 1,max = 2,message = "长度超过限制")
    private String username;
    private String password;
    private String salt;
}
