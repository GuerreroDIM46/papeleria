package es.mde.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class MixIns {

	@JsonPropertyOrder({ "nombre", "correo" })
	//@JsonIgnoreProperties({"correo"})//si quiero que en el GET no me incluya una propiedad...
	public static interface Clientes {
	}
	
	@JsonPropertyOrder({ "nombre", "autor" })
	public static interface Libros {
	}
	
	@JsonPropertyOrder({ "nombre", "hojas" })
	public static interface Cuadernos {
	}

}
