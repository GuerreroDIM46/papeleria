package es.mde.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import es.mde.entidades.Cliente;

@RepositoryRestResource(path="clientes",itemResourceRel="cliente",collectionResourceRel="clientes")
public interface ClienteDAO extends JpaRepository<Cliente, Long>, ClienteDAOCustom {

	@RestResource(path="nombre")
	List<Cliente> findByNombreIgnoreCaseContaining(String txt);
	@RestResource(path="correo")
	List<Cliente> findByCorreoIgnoreCaseContaining(String txt);
	
	@RestResource(exported = false)
	void deleteById(Long id);
	
	@RestResource(exported = false)
	void delete(Cliente cliente);

}
