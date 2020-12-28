package cn.sunyog.yaos.sys.exception;

/**
 * @Author: MysteriousGT
 * @Date: 2020/12/28 2:23 下午
 * @Desc: 服务异常
 */
public class ServerException extends RuntimeException{
    public ServerException(String message) {
        super(message);
    }
}
