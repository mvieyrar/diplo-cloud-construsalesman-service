package unam.diplomado.construsales.construsalesmanservice.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.construsales.construsalesmanservice.domain.Vendedor;
import unam.diplomado.construsales.construsalesmanservice.repository.VendedorRepository;
import unam.diplomado.construsales.construsalesmanservice.service.VendedorService;

@RestController
public class VendedorController implements VendedorApi {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private VendedorService vendedorService;

	@Override
	public List<Vendedor> obtenerVendedores() {
		return vendedorRepository.findAll();
	}

	@Override
	public Vendedor crearVendedor(Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}

	@Override
	public ResponseEntity<Vendedor> obtenerVendedorPorId(String id) {
		Optional<Vendedor> vendedor = vendedorRepository.findById(id);
		if(vendedor.isPresent()) {
			return new ResponseEntity<>(vendedor.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Vendedor> actualizarVendedor(String id, Vendedor vendedor) {
		Vendedor vendedorActualizado = vendedorService.actualizarVendedor(id, vendedor);
		if(vendedorActualizado !=  null) {
			return new ResponseEntity<>(vendedorActualizado, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Override
	public void eliminarVendedor(String id) {
		vendedorRepository.deleteById(id);		
	}
}
