package unam.diplomado.construsales.construsalesmanservice.service;

import unam.diplomado.construsales.construsalesmanservice.domain.Vendedor;

public interface VendedorService {
	Vendedor actualizarVendedor(String id, Vendedor vendedor) throws RuntimeException;

}
