package unam.diplomado.construsales.construsalesmanservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="vendedor")
public class Vendedor {
	@Id
	private String id;
	@Field(name="nombre")
	private String nombre;
	@Field(name="paterno")
	private String paterno;
	@Field(name="materno")
	private String materno;
	@Field(name="sucursal")
	private String sucursal;
	@Field(name="claveagente")
	private String claveagente;	
	@Field(name="objetivo")
	private Double objetivo;
	@Field(name="venta")
	private Double venta;
}
