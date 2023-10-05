package unam.diplomado.construsales.construsalesmanservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.diplomado.construsales.construsalesmanservice.domain.Vendedor;
import unam.diplomado.construsales.construsalesmanservice.repository.VendedorRepository;

@Service
public class VendedorServiceImpl implements VendedorService{
	
	@Autowired
	private VendedorRepository vendedorRepository;

	@Override
	public Vendedor actualizarVendedor(String id, Vendedor vendedor) throws RuntimeException {
		Optional<Vendedor> vendedorExistente = vendedorRepository.findById(id);
		if(vendedorExistente.isPresent()) {
			Vendedor vendedorActualizar = vendedorExistente.get();
			vendedorActualizar.setNombre(vendedor.getNombre());
			vendedorActualizar.setPaterno(vendedor.getPaterno());
			vendedorActualizar.setMaterno(vendedor.getMaterno());
			vendedorActualizar.setSucursal(vendedor.getSucursal());
			vendedorActualizar.setClaveagente(vendedor.getClaveagente());
			vendedorActualizar.setObjetivo(vendedor.getObjetivo());
			vendedorActualizar.setVenta(vendedor.getVenta());
			vendedorRepository.save(vendedorActualizar);
			return vendedorActualizar;
		}
		return null;
	}

}
