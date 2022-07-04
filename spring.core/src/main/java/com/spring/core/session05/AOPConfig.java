package com.spring.core.session05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.spring.core.session05.aop.job.Audience;
import com.spring.core.session05.aop.job.BackSinger;
import com.spring.core.session05.aop.job.Dancer;
import com.spring.core.session05.aop.job.Introductor;
import com.spring.core.session05.aop.job.Performance;
import com.spring.core.session05.aop.job.Singer;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AOPConfig {
	
	@Bean(name = "dancer")
	public Performance getDancer() {
		return new Dancer();
	}
	
	@Bean
	public Audience audience() {
		return new Audience();
	}
	
	@Bean
	public Introductor getIntroductor() {
		return new Introductor();
	}
	
	

}
