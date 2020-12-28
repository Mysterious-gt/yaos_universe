package cn.sunyog.yaos.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import cn.sunyog.yaos.common.dao.SysUserDao;
import cn.sunyog.yaos.common.entity.SysUser;
import cn.sunyog.yaos.common.entity.vo.LoginUser;
import cn.sunyog.yaos.common.utils.EncodeUtil;
import cn.sunyog.yaos.sys.exception.ServerException;
import cn.sunyog.yaos.sys.exception.SysException;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: MysteriousGT
 * @Date: 2020/12/28 1:28 下午
 * @Desc:
 */
@Service
@PropertySource("classpath:/config/application.properties")
public class SysUserService {
    @Value("${sys.user.register.username.exist.message}")
    private String usernameExistMSG;
    @Value("${sys.user.login.username.none.message}")
    private String usernameNoneMSG;
    @Value("${sys.user.login.password.error.message}")
    private String passwordErrorMSG;
    @Value("${sys.user.register.nickname.default}")
    private String defaultNickname;

    @Autowired
    private SysUserDao sysUserDao;

    public int userRegister(SysUser user) {
        // 重复校验
        Map<String, Object> map = new HashMap<String, Object>(4);
        String userName = user.getUsername();
        map.put("username", userName);
        int count = sysUserDao.getUserCount(map);
        if (count > 0) {
            throw new SysException(this.usernameExistMSG);
        }
        String salt = EncodeUtil.getSalt();
        String pwdMD5 = EncodeUtil.getPassword(user.getPassword(), salt);
        user.setSalt(salt).setPassword(pwdMD5);
        if(StringUtils.isEmpty(user.getNickname())){
            user.setNickname(this.defaultNickname);
        }
        return sysUserDao.insert(user);
    }

    public long login(LoginUser user) {
        HashMap<String, Object> map = new HashMap<String, Object>(4);
        map.put("username", user.getUsername());
        List<SysUser> userDBs = sysUserDao.getUserCondition(map);
        if (userDBs == null || userDBs.size() < 1) {
            throw new ServerException(this.usernameNoneMSG);
        }

        String pwdDB = userDBs.get(0).getPassword();
        String pwd = EncodeUtil.getPassword(user.getPassword(), EncodeUtil.getSalt());
        if (!pwdDB.equals(pwd)) {
            throw new ServerException(this.passwordErrorMSG);
        }
        return 1;
    }
}
