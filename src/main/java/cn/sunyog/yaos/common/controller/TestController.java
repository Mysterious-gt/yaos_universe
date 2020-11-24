package cn.sunyog.yaos.common.controller;

import cn.sunyog.yaos.common.dao.SysUserDao;
import cn.sunyog.yaos.common.entity.SysUser;
import cn.sunyog.yaos.sys.rest.ResultHelper;
import cn.sunyog.yaos.sys.rest.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * @Author: MysteriousGT
 * @Date: 2020/11/5 11:25 上午
 * @Desc: 测试controller
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    private SysUserDao sysUserDao;

    @GetMapping("/json")
    @ResponseBody
    public SysResult getJSON() {
        SysUser res = new SysUser(10001L, "tony gaga wang", UUID.randomUUID().toString(), UUID.randomUUID().toString());
        return ResultHelper.ok(res);
    }

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/users")
    @ResponseBody
    public SysResult getUsers() {
        List<SysUser> res = sysUserDao.getSysUsers();
        return ResultHelper.ok(res);
    }

    @PostMapping("/valid")
    @ResponseBody
    public SysResult toValid(@RequestBody @Valid SysUser user) {
        return ResultHelper.ok();
    }
}