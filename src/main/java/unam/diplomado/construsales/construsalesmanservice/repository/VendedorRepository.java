package unam.diplomado.construsales.construsalesmanservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.construsales.construsalesmanservice.domain.Vendedor;

public interface VendedorRepository extends MongoRepository<Vendedor, String> {

}
