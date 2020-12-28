package cn.sunyog.yaos.common.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @Author: MysteriousGT
 * @Date: 2020/12/28 2:26 下午
 * @Desc: 加密解密工具类
 */
public class EncodeUtil {
    public static String getSalt(){
        return "salt";
    }

    public static String getPassword(String sourcePWD,String salt){
        String pwdMD5 = new Md5Hash(sourcePWD, salt).toHex();
        return pwdMD5;
    }
}
