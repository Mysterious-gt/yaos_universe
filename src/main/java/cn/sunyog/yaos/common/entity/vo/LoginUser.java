package cn.sunyog.yaos.common.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: MysteriousGT
 * @Date: 2020/12/28 2:16 下午
 * @Desc: 用户登陆信息
 */
@Data
@Accessors(chain = true)
public class LoginUser {
    @NotEmpty(message = "【用户名】不能为空")
    @Length(min = 1,max = 20,message = "【用户名】长度不能超过 20 ")
    private String username;
    @NotEmpty(message = "【密码】不能为空")
    @Length(min = 1,max = 36,message = "【密码】长度不能超过 36 ")
    private String password;
}
