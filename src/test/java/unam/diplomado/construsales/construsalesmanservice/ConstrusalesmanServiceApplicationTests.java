package unam.diplomado.construsales.construsalesmanservice;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalManagementPort;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;



import org.springframework.boot.test.web.client.TestRestTemplate;

import unam.diplomado.construsales.construsalesmanservice.domain.Vendedor;
import unam.diplomado.construsales.construsalesmanservice.service.VendedorServiceImpl;
import unam.diplomado.construsales.construsalesmanservice.util.FileUtil;
import unam.diplomado.construsales.construsalesmanservice.util.MapperUtil;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ConstrusalesmanServiceApplicationTests {
	@LocalServerPort
	private static int serverPort = 8081;
	@LocalManagementPort
	private static int managementPort = 8084;
	private static String messageToPrint = "Some problem to load use cases for test: ";
	
	// MOCK VALUES
	private static String MOCK_FILE_VENDEDORES = "/vendedores.json";
	private static String MOCK_FILE_VENDEDOR = "/vendedor.json";
	private static String MOCK_FILE_VENDEDORES_EMPTY = "/vendedores_empty.json";
	private static String MOCK_LOOK_FOR_ID = "651e2892a76c343fff4e55b6";
	private static String MOCK_ID = "651e2892a76c343fff4e55b6";
	private static String MOCK_SOME_AGENT = "MIVI";
	
	// TEST FOR REAL
	@Autowired
	private VendedorServiceImpl vendedorService;
	private static String BASE_URL = "http://localhost:" + String.valueOf(serverPort) + "/api/vendedores";
	

	@Test
	void applicationContextLoads() {
	}
	
	/*@Test
	public void getVendedoresTest() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<Vendedor[]> response = testRestTemplate.getForEntity(BASE_URL, Vendedor[].class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}*/
	
	@Test
	public void getVendedorByIdMockSuccessTest() {
		try {
			String vendedorJson = FileUtil.readFromFileToString(MOCK_FILE_VENDEDORES);
			//System.out.println(vendedorJson);
			List<Vendedor> vendedores = MapperUtil.deserializeVendedores(vendedorJson);
			Vendedor vendedorResponse = vendedores.stream()
					.filter(vendedor -> vendedor.getId().equals(MOCK_LOOK_FOR_ID))
					.findAny()
					.orElse(null);
			//HttpEntity<Vendedor> httpEntity = new HttpEntity<>(vendedorResponse);
			Assert.assertTrue(vendedorResponse != null);
		} catch (IOException e) {
			System.out.println(messageToPrint + MOCK_FILE_VENDEDORES);
			e.printStackTrace();
		}
	}
	
	@Test
	public void getVendedorMockSuccessTest() {
		try {
			String vendedorJson = FileUtil.readFromFileToString(MOCK_FILE_VENDEDOR);
			Vendedor vendedor = MapperUtil.deserializeVendedor(vendedorJson);
			HttpEntity<Vendedor> httpEntity = new HttpEntity<>(vendedor);
			Assert.assertTrue(
					httpEntity.getBody().getId().equals(MOCK_ID) 
						&& httpEntity.getBody().getId().equals(MOCK_ID)
					);
		} catch (Exception e) {
			System.out.println(messageToPrint + MOCK_FILE_VENDEDOR);
			e.printStackTrace();
		}
	}
	
	@Test
	public void getVendedoresMockSuccessTest() {
		try {
			String vendedorJson = FileUtil.readFromFileToString(MOCK_FILE_VENDEDORES);
			List<Vendedor> vendedores = MapperUtil.deserializeVendedores(vendedorJson);
			Vendedor vendedorResponse = vendedores.stream()
					.filter(vendedor -> vendedor.getClaveagente().equals(MOCK_SOME_AGENT))
					.findAny()
					.orElse(null);
			Assert.assertTrue(vendedorResponse != null);
		} catch (Exception e) {
			System.out.println(messageToPrint + MOCK_FILE_VENDEDORES);
			e.printStackTrace();
		}
	}
	
	@Test
	public void getVendedoresNotEmptyList() {
		try {
			String vendedorJson = FileUtil.readFromFileToString(MOCK_FILE_VENDEDORES);
			List<Vendedor> vendedores = MapperUtil.deserializeVendedores(vendedorJson);
			Assert.assertFalse(vendedores.isEmpty());
		} catch (Exception e) {
			System.out.println(messageToPrint + MOCK_FILE_VENDEDORES);
			e.printStackTrace();
		}
	}
	
	@Test
	public void getVendedoresEmptyList() {
		try {
			String vendedorJson = FileUtil.readFromFileToString(MOCK_FILE_VENDEDORES_EMPTY);
			List<Vendedor> vendedores = MapperUtil.deserializeVendedores(vendedorJson);
			Assert.assertTrue(vendedores.isEmpty());
		} catch (Exception e) {
			System.out.println(messageToPrint + MOCK_FILE_VENDEDORES_EMPTY);
			e.printStackTrace();
		}
	}

}
