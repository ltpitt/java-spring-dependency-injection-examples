package it.davidenastri.javaspringdependencyinjectionexamples;

import it.davidenastri.javaspringdependencyinjectionexamples.controllers.ConstructorInjectedController;
import it.davidenastri.javaspringdependencyinjectionexamples.controllers.MyController;
import it.davidenastri.javaspringdependencyinjectionexamples.controllers.PropertyInjectedController;
import it.davidenastri.javaspringdependencyinjectionexamples.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavaSpringDependencyInjectionExamplesApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(JavaSpringDependencyInjectionExamplesApplication.class, args);
		MyController myController = (MyController) ctx.getBean("myController");
		String greeting = myController.sayHello();
		System.out.println("From main: " + greeting);

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
