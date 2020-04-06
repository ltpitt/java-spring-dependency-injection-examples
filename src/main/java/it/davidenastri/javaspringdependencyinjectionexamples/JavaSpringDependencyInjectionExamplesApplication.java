package it.davidenastri.javaspringdependencyinjectionexamples;

import it.davidenastri.javaspringdependencyinjectionexamples.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavaSpringDependencyInjectionExamplesApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(JavaSpringDependencyInjectionExamplesApplication.class, args);

		System.out.println("\n----- Active profile");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");
		System.out.println("\n----- Primary bean");
		System.out.println(myController.sayHello());

		System.out.println("\n----- Property injected dependency");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("\n----- Setter injected dependency");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("\n----- Constructor injected dependency");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

	}

}
