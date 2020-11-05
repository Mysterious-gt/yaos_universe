package cn.sunyog.yaos.common.dao;

import cn.sunyog.yaos.common.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: MysteriousGT
 * @Date: 2020/11/5 3:41 下午
 * @Desc: 用户dao
 */
@Mapper
public interface SysUserDao {
    List<SysUser> getSysUsers();
}
