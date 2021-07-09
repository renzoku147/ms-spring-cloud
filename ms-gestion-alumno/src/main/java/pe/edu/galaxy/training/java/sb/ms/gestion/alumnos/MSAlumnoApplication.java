package pe.edu.galaxy.training.java.sb.ms.gestion.alumnos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(/*exclude = {DataSourceAutoConfiguration.class}*/)
public class MSAlumnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MSAlumnoApplication.class, args);
	}

}
