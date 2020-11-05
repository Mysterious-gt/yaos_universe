package cn.sunyog.yaos.sys.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @Author: MysteriousGT
 * @Date: 2020/11/5 11:06 上午
 * @Desc: Spring配置类
 */
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan(value = "cn.sunyog.yaos", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = {Controller.class, ControllerAdvice.class})})
public class AppRootConfig {
}
