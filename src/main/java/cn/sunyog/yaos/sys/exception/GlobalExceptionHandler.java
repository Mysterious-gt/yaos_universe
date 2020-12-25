package cn.sunyog.yaos.sys.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunyog.yaos.sys.rest.ResultHelper;
import cn.sunyog.yaos.sys.rest.SysResult;

/**
 * @Author: MysteriousGT
 * @Date: 2020/11/9 3:02 下午
 * @Desc: 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger log= LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public SysResult handle(Exception exception) {
        StringBuffer sb=new StringBuffer();
        if(exception instanceof MethodArgumentNotValidException){
            BindingResult bindRes = ((MethodArgumentNotValidException) exception).getBindingResult();
            for (ObjectError item : bindRes.getAllErrors()) {
                String msg = item.getDefaultMessage();
                sb.append(msg);
                log.info(msg);
            }
        }
        return ResultHelper.fail(sb.toString());
    }
}
