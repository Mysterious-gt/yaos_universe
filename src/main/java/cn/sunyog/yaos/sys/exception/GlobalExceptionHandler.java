package cn.sunyog.yaos.sys.exception;

import cn.sunyog.yaos.sys.rest.ResultHelper;
import cn.sunyog.yaos.sys.rest.SysResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;

/**
 * @Author: MysteriousGT
 * @Date: 2020/11/9 3:02 下午
 * @Desc: 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger log= LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public SysResult handle(ValidationException exception) {
        if(exception instanceof ValidationException){
            String message = exception.getMessage();
            log.info(message);
        }
        return ResultHelper.fail();
    }
}
