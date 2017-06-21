package by.itacademy.config;

import by.itacademy.util.DataImporterToH2;
import org.h2.jdbcx.JdbcDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@Import(ConfigDao.class)
public class ConfigDaoTest {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String user;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource(){
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public DataImporterToH2 importerToH2(){
        return new DataImporterToH2();
    }
}
