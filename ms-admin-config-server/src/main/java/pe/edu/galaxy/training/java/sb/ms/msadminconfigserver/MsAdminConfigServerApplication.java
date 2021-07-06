package pe.edu.galaxy.training.java.sb.ms.msadminconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

//ConfigServer

@EnableConfigServer
@SpringBootApplication
public class MsAdminConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAdminConfigServerApplication.class, args);
	}

}
