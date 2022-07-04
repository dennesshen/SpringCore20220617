package com.spring.core.session05.aop.job;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class Introductor {
	
	@DeclareParents(value = "com.spring.core.session05.aop.job.Performance+",
					defaultImpl = BackSinger.class)
	Singer singer;
}
