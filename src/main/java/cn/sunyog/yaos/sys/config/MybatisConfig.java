package cn.sunyog.yaos.sys.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Author: MysteriousGT
 * @Date: 2020/11/5 3:28 下午
 * @Desc: mybatis配置类
 */
//设置dao接口路径
@MapperScan("cn.sunyog.yaos.**.dao")
//引入外部资源文件
@PropertySource("classpath:/config/mybatis.properties")
//Spring配置类说明
@Configuration
public class MybatisConfig {
    /**
     * 配置数据源
     * @param env
     * @return
     */
    @Bean(value = "dataSource", initMethod = "init", destroyMethod = "close")
    public DataSource newDruidDataSource(Environment env) {
        DruidDataSource res = new DruidDataSource();
        res.setDriverClassName(env.getProperty("datasource.jdbcDriver"));
        res.setUrl(env.getProperty("datasource.jdbcUrl"));
        res.setUsername(env.getProperty("datasource.jdbcUser"));
        res.setPassword(env.getProperty("datasource.jdbcPassword"));
        res.setMaxActive(Integer.parseInt(env.getProperty("datasource.jdbcMaxActive")));
        return res;
    }

    /**
     * mybatis详细配置
     * @param dataSource
     * @return
     * @throws IOException
     */
    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean newSqlSesionFactoryBean(DataSource dataSource) throws IOException {
        //1.构建bean对象
        SqlSessionFactoryBean res = new SqlSessionFactoryBean();
        //2.配置数据源
        res.setDataSource(dataSource);
        //3.设置映射文件
        Resource[] mapperLocations = new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*/*Mapper.xml");
        res.setMapperLocations(mapperLocations);

        //设置下划线转驼峰
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        config.setMapUnderscoreToCamelCase(true);
        res.setConfiguration(config);
        return res;
    }

    /**
     * 配置事务支持
     * @param dataSource
     * @return
     */
    @Bean("txManager")
    public DataSourceTransactionManager newTransactionManager(@Autowired DataSource dataSource){
        DataSourceTransactionManager tManager= new DataSourceTransactionManager();
        tManager.setDataSource(dataSource);
        return tManager;
    }
}
