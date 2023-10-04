package unam.diplomado.construsales.construsalesmanservice.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import unam.diplomado.construsales.construsalesmanservice.domain.Vendedor;

@RequestMapping(path="api/vendedores", produces="application/json")
@Tag(name="vendedor", description="API del Recurso Vendedor")
@CrossOrigin(origins="*")
public interface VendedorApi {
	@Operation(summary = "Obtener todos los Vendedores")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "Listado de Vendedores",
					content = {							
							@Content(
									mediaType="application/json",
									array = @ArraySchema(schema = @Schema(implementation=Vendedor.class))									
							)
					}
			)			
	})
	@GetMapping
	public List<Vendedor> obtenerVendedores();
	
	@Operation(summary = "Crear Vendedor")
	@ApiResponses(value= {
			@ApiResponse(
					responseCode = "201",
					description = "Vendedor Creado Exitosamente",
					content = { 
							@Content(
									mediaType="application/json",
									schema = @Schema(implementation=Vendedor.class)
							)
					}
			)
	})
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Vendedor crearVendedor(@RequestBody Vendedor vendedor);
	
	@Operation(summary = "Obtener Vendedor por Id")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "Vendedor",
					content = {
							@Content(
									mediaType="application/json",
									schema = @Schema(implementation=Vendedor.class)
							)
					}
			),
			@ApiResponse(
					responseCode = "404",
					description = "No encontrado",
					content = @Content
			)
	})
	@GetMapping("{id}")
	public ResponseEntity<Vendedor> obtenerVendedorPorId(@PathVariable("id") String id);
	
	@Operation(summary = "Actualizar Vendedor")
	@ApiResponses(value = {			
			@ApiResponse(
					responseCode = "200",
					description = "Vendedor actualizado",
					content = {
							@Content(
									mediaType="application/json",
									schema = @Schema(implementation=Vendedor.class)
							)
					}
			),
			@ApiResponse(
					responseCode = "404",
					description = "No encontrado",
					content = @Content
			)			
	})
	@PutMapping(path="{id}", consumes="application/json")
	public ResponseEntity<Vendedor> actualizarVendedor(@PathVariable("id") String id, @RequestBody Vendedor vendedor);
	
	@Operation(summary="Eliminar Vendedor")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "204",
					description="void"
			)
	})
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarVendedor(@PathVariable("id") String id);
}
