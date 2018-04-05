package org.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
//		Triangle triangle = new Triangle();
//		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle =(Triangle) context.getBean("triangle");
		((AbstractApplicationContext) context).close();
		triangle.draw();
	}

}
