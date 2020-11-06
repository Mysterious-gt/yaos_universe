package cn.sunyog.yaos.sys.exception;

/**
 * @Author: MysteriousGT
 * @Date: 2020/11/6 11:30 上午
 * @Desc: 系统异常
 */
public class SysException extends RuntimeException {
    public SysException(String msg) {
        super(msg);
    }

    public SysException() {
        super();
    }

    public SysException(Throwable cause) {
        super(cause);
    }
}
