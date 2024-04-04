package es.mde.repositorios;

import java.util.List;

import es.mde.entidades.Producto;

public interface ClienteDAOCustom {
	List<Producto> getProductosPagadosDeCliente(Long id);

}
