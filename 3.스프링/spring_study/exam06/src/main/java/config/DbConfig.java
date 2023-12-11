package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DbConfig {
    @Bean(destroyMethod = "close") // 자동 연결해제
    public DataSource dataSource(){
        DataSource ds = new DataSource(); // 연결객체를 만들수 있는 데이터 소스
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        ds.setUsername("SPRING6");
        ds.setPassword("_aA123456");

        // 커넥션 풀 설정
        ds.setInitialSize(2);
        ds.setTestWhileIdle(true); // 유휴 상태 커넥션 객체를 체크 여부
        ds.setTimeBetweenEvictionRunsMillis(3000); // 3초마다 커넥션 상태 체크
        ds.setMinEvictableIdleTimeMillis(30 * 1000); // 30초가 최대 유휴 시간 -> 경과시 소멸

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager transactionManager() { // 프록시 형태로 setAutocommit이 자동으로 들어간다.
        DataSourceTransactionManager tm = new DataSourceTransactionManager(dataSource());
        return tm;
    }
}
