package es.mde.rest;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.mde.entidades.Producto;
import es.mde.repositorios.ClienteDAO;

@RepositoryRestController
@Configuration
public class ClienteController {

	private ClienteDAO clienteDAO;

	public ClienteController(ClienteDAO clienteDAO) {

		this.clienteDAO = clienteDAO;
	}

	@GetMapping("/clientes/{id}/productos-pagados")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> getProductosPagadosDeCliente(@PathVariable Long id,
			PersistentEntityResourceAssembler assembler) {
		System.err.println("prueba");
		List<Producto> productos = clienteDAO.getProductosPagadosDeCliente(id);

		return assembler.toCollectionModel(productos);
	}

}
