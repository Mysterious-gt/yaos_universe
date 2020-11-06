package cn.sunyog.yaos.sys.rest;

/**
 * @Author: MysteriousGT
 * @Date: 2020/11/6 11:35 上午
 * @Desc: 系统返回值生成类
 */
public class ResultHelper {
    public static SysResult ok() {
        return ok("");
    }

    public static SysResult ok(String msg) {
        return ok(msg, null);
    }

    public static SysResult ok(Object data) {
        return ok("", data);
    }

    public static SysResult ok(String msg, Object data) {
        return new SysResult(200, msg, data);
    }

    public static SysResult fail(Integer code, String msg, Object data) {
        return new SysResult(code, msg, data);
    }

    public static SysResult fail(String msg, Object data) {
        return fail(500, msg, data);
    }

    public static SysResult fail(String msg) {
        return fail(msg, null);
    }

    public static SysResult fail(Object data) {
        return fail("", data);
    }

    public static SysResult fail(){
        return fail("");
    }
}
