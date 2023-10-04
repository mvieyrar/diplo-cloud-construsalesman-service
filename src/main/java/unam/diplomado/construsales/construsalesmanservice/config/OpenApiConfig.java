package unam.diplomado.construsales.construsalesmanservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
			version = "v1",
			title = "Construsales Construsalesman Microservice Endpoints",
			description = "Definición de los Endpoints de "
					+ "Construsalesman Service para el sistema Construsales",
			contact = @Contact(
				name = "UNAM",
				url = "https://www.unam.mx",
				email = "mvieyrar@gmail.com"
			)			
		)
)
public class OpenApiConfig {

}
