//package com.mall.parking.schedule.job.config;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//
//import io.seata.rm.datasource.DataSourceProxy;
//
//@Configuration
//public class DataSourceProxyConfig {
//
//    @Value("${mybatis.mapper-locations}")
//    private String mapperLocations;
//    
//    @Value("${spring.datasource.driverClassName}")
//    private String driverClassName;
//    
//    @Value("${spring.datasource.url}")
//    private String dataSourceUrl;
//    
//    @Value("${spring.datasource.username}")
//    private String user;
//    
//    @Value("${spring.datasource.password}")
//    private String password;
//    
//    /**
//     * @param sqlSessionFactory SqlSessionFactory
//     * @return SqlSessionTemplate
//     */
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//    @Bean
//    //@ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource hikariDataSource(){
//    	HikariConfig config = new HikariConfig();
//    	config.setDriverClassName(driverClassName);
//        config.setJdbcUrl(dataSourceUrl); //数据源
//        config.setUsername(user); //用户名
//        config.setPassword(password); //密码
//    	HikariDataSource ds = new HikariDataSource(config);
//        return ds;
//    }
//
//    @Primary
//    @Bean("dataSource")
//    public DataSourceProxy dataSourceProxy(DataSource dataSource) {
//        return new DataSourceProxy(hikariDataSource());
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSourceProxy);
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources(mapperLocations));
//        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
//        return sqlSessionFactoryBean.getObject();
//    }
//
//}
