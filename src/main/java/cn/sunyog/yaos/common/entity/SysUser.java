package cn.sunyog.yaos.common.entity;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
    @NotEmpty(message = "【用户名】不能为空")
    @Length(min = 1,max = 20,message = "【用户名】长度超过限制")
    private String username;
    @Length(min = 1,max = 20,message = "【昵称】长度超过限制")
    private String nickname;
    @NotEmpty(message = "【密码】不能为空")
    @Length(min = 1,max = 36,message = "【密码】长度超过限制")
    private String password;
    private String salt;
    private String phone;
    @Email(message = "【电子邮箱】格式错误")
    private String email;
    private String isDel;
}
