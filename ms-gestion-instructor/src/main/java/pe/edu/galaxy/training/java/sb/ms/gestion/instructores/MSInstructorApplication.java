package pe.edu.galaxy.training.java.sb.ms.gestion.instructores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableEurekaClient // Anotacion de autodescubrimiento
@SpringBootApplication()
public class MSInstructorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MSInstructorApplication.class, args);
	}

}
