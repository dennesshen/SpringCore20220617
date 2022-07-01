package com.spring.core.session04.sta;


public class PersonProxy implements Person {
	
	private Person person;
	public PersonProxy(Person person) {
		this.person = person;
	}
	
	@Override
	public void work() {
		System.out.println("戴口罩");
		person.work();
		System.out.println("脫口罩");
	}

}
