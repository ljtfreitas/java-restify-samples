package com.github.ljtfreitas.sample;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class Person {

	@XmlElement
	String name;

	@XmlElement(name = "last_name")
	String lastName;

	@XmlElement
	Integer age;

	@XmlElement
	Person wife;

	@XmlElementWrapper(name = "pets")
	@XmlElement(name = "pet")
	Collection<String> pets;
}
