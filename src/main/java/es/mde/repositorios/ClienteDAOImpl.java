package es.mde.repositorios;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.mde.entidades.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Transactional(readOnly = true)
public class ClienteDAOImpl implements ClienteDAOCustom {

	@Autowired
	ClienteDAO clienteDAO;
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Producto> getProductosPagadosDeCliente(Long id) {
		List<Producto> productos = clienteDAO.findById(id).get().getProductos().stream()
				.filter(p -> p.isPagado() == true).collect(Collectors.toList());
		return productos;
	}

	

}
