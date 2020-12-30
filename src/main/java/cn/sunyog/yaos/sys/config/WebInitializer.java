package cn.sunyog.yaos.sys.config;

import javax.servlet.ServletContext;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;

/**
 * @Author: MysteriousGT
 * @Date: 2020/11/5 11:17 上午
 * @Desc: web初始化配置类
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * @Desc: 配置logback日志
     * @Author: MysteriousGT
     * @Date: 2020/12/29
     * @Param: [servletContext]
     * @Return: void
     */
    @Override
    protected void registerContextLoaderListener(ServletContext servletContext) {
        super.registerContextLoaderListener(servletContext);
        LogbackConfigListener logListener = new LogbackConfigListener();
        servletContext.addListener(logListener);
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {AppRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
