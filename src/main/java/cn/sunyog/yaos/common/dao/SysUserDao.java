package cn.sunyog.yaos.common.dao;

import cn.sunyog.yaos.common.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: MysteriousGT
 * @Date: 2020/11/5 3:41 下午
 * @Desc: 用户dao
 */
@Mapper
public interface SysUserDao {
    List<SysUser> getSysUsers();

    int getUserCount(Map<String,Object> map);

    int insert(SysUser user);
    int update (SysUser user);

    List<SysUser> getUserCondition(Map<String, Object> map);
}
