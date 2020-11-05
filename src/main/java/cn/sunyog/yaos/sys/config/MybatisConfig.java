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
@MapperScan("cn.sunyog.yaos.**.dao")
@PropertySource("classpath:/config/mybatis.properties")
@Configuration
public class MybatisConfig {
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
        return res;
    }

    @Bean("txManager")
    public DataSourceTransactionManager
    newTransactionManager(@Autowired DataSource dataSource){
        DataSourceTransactionManager tManager= new DataSourceTransactionManager();
        tManager.setDataSource(dataSource);
        return tManager;
    }
}
