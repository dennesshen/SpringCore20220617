package com.spring.core.session06;
//https://us02web.zoom.us/j/83616356640?pwd=dG96d25idkkyTzhTODFBY1oySWw5UT09

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource(ignoreResourceNotFound = true, value = {"classpath:db.properties"})
@ComponentScan
@EnableTransactionManagement
public class SpringJDBCConfig {
	
	@Autowired
	protected Environment environment;
	
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		try {
			ds.setDriverClass(environment.getProperty("jdbc.driver"));
			ds.setJdbcUrl(environment.getProperty("jdbc.url"));
			ds.setUser(environment.getProperty("jdbc.username"));
			ds.setPassword(environment.getProperty("jdbc.password"));
			
			ds.setMinPoolSize(10);
			ds.setMaxPoolSize(100);
			ds.setInitialPoolSize(10);
			ds.setMaxIdleTime(1800);
			ds.setMaxStatements(100);
			
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource());	
	}

}
