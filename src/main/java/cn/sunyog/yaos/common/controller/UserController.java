package cn.sunyog.yaos.common.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.sunyog.yaos.common.entity.SysUser;
import cn.sunyog.yaos.common.entity.vo.LoginUser;
import cn.sunyog.yaos.common.service.SysUserService;
import cn.sunyog.yaos.sys.rest.ResultHelper;
import cn.sunyog.yaos.sys.rest.SysResult;

/**
 * @Author: MysteriousGT
 * @Date: 2020/12/28 11:43 上午
 * @Desc: 用户模块
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/register")
    public SysResult userRegister(@RequestBody @Valid SysUser user) {
        return ResultHelper.ok(sysUserService.userRegister(user));
    }

    @PostMapping("/login")
    public SysResult userLogin(@RequestBody @Valid LoginUser user){
        return ResultHelper.ok(sysUserService.login(user));
    }
}
