package unam.diplomado.construsales.construsalesmanservice.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import unam.diplomado.construsales.construsalesmanservice.domain.Vendedor;

public class MapperUtil {
	//ObjectMapper objectMapper = new ObjectMapper();
	private static final ObjectMapper objectMapper = JsonMapper.builder()
			.addModule(new JavaTimeModule())
			.build();
	
	public static Vendedor deserializeVendedor(String json) throws JsonProcessingException{
		return objectMapper.readValue(json, Vendedor.class);
	}
	
	public static List<Vendedor> deserializeVendedores(String json) throws JsonProcessingException{
		Vendedor[] vendedores = objectMapper.readValue(json, Vendedor[].class);
		//return Arrays.stream(vendedores)).toList();
		//Fills array list with array object.
		List<Vendedor> vendedorList = new ArrayList<Vendedor>();
		for(Vendedor vendedor:vendedores) {
			vendedorList.add(vendedor);
		}
		return vendedorList;
	}
}
