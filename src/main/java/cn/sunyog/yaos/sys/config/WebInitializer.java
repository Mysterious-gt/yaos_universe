package cn.sunyog.yaos.sys.config;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;

/**
 * @Author: MysteriousGT
 * @Date: 2020/11/5 11:17 上午
 * @Desc: web初始化配置类
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 配置logback日志
     * @param servletContext
     */
    @Override
    protected void registerContextLoaderListener(ServletContext servletContext) {
        super.registerContextLoaderListener(servletContext);
        LogbackConfigListener logListener = new LogbackConfigListener();
        servletContext.addListener(logListener);
    }

    /**
     * 设定Spring配置类
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppRootConfig.class};
    }

    /**
     * 设定SpringMVC配置类
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }

    /**
     * 设置servlet映射
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
