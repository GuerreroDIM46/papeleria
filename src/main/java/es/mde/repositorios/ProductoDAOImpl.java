package es.mde.repositorios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.mde.entidades.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Transactional(readOnly = true)
public class ProductoDAOImpl implements ProductoDAOCustom {

	@Autowired
	ClienteDAO clienteDAO;

	@PersistenceContext
	EntityManager entityManager;

	
	@Override
	public List<Producto> getProductosDeClientesEmpresa(String tipoCorreo) {
		
		List<Producto> productos = new ArrayList<Producto>();
		clienteDAO.findByCorreoIgnoreCaseContaining(tipoCorreo).forEach(c -> productos.addAll(c.getProductos()));

		return productos;

	}

}
