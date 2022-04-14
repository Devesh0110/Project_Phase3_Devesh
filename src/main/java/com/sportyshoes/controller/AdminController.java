package com.sportyshoes.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.sportyshoes.model.Product;
import com.sportyshoes.model.PurchaseReport;
import com.sportyshoes.model.User;
import com.sportyshoes.repository.PurchaseReportRepository;
import com.sportyshoes.service.ProductService;
import com.sportyshoes.service.PurchaseReportService;
import com.sportyshoes.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProductService productService;

	@Autowired
	UserService userService;

	@Autowired
	private PurchaseReportService purchaseReportService;
	
	final String PRODUCT_URI = "http://localhost:8080/admin/product";
	final String PRODUCTS_URI = PRODUCT_URI+"s";
	final String SEARCH_URI="http://localhost:8080/admin/login?name=";
	int f=0;
	
//	@GetMapping("/login")
//	public String getLogin(@RequestParam("name") String name,@RequestParam("password") String password){
//		// create a rest client
//		RestTemplate restTemplate = new RestTemplate();
//		
//		// trigger get one product http request
//		ResponseEntity<List> response = restTemplate.getForEntity(SEARCH_URI+name+"&password"+password, List.class);
//		// collect and return response
//		//return response.getBody();
//		if(response.hasBody()) {
//			return "Admin Login sucessfull";
//		}
//		return "Admin Login Unsuccessful";
//	}
//	
//	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> allProducts = productService.getAllProducts();
		if (allProducts.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		ResponseEntity<List<Product>> responseEntity = new ResponseEntity<List<Product>>(allProducts, HttpStatus.OK);
		return responseEntity;
	}
	
//	@PostMapping("/products")
//	public String addOneProduct(@RequestBody Product order){
//		// create a rest client
//		RestTemplate restTemplate = new RestTemplate();
//		
//		// trigger add one product http request
//		restTemplate.postForEntity(PRODUCTS_URI, order, Product.class);
//		
//		// collect and return response
//		return "Product is added successflly ";
//	}

	@GetMapping("/products/categorize/{category}")
	public ResponseEntity<List<Product>> getAllProductsBasedOnCategory(@PathVariable("category") String category) {
		System.out.println("Category which is being searched is: " + category);
		List<Product> allProductsBasedOnCategory = productService.getAllProductBasedOnCatogary(category);
		if (allProductsBasedOnCategory.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		ResponseEntity<List<Product>> responseEntity = new ResponseEntity<List<Product>>(allProductsBasedOnCategory,
				HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product temp = productService.addProduct(product);
		if (temp == null) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Product>(temp, HttpStatus.OK);

	}

	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") int id) {
		Optional<Product> product = productService.getProductById(id);
		if (!product.isPresent()) {
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
	}

	@DeleteMapping("/products/{productId}")
	public String deleteById(@PathVariable("productId") int id) {
		productService.deleteProductById(id);
		return "Product with id="+id+" Deleted";
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllSignedUpUsers() {
		List<User> allSignedUpUsers = userService.allSignedUpUsers();
		if (allSignedUpUsers.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(allSignedUpUsers, HttpStatus.OK);

	}

	@GetMapping("/users/{userName}")
	public ResponseEntity<User> getSignedUpUser(@PathVariable String userName) {
		Optional<User> signedUpUser = userService.getSignedUpUserByName(userName);
		if (!signedUpUser.isPresent()) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(signedUpUser.get(), HttpStatus.OK);
	}

	@GetMapping("/purchasereport")
	public ResponseEntity<List<PurchaseReport>> getPurchaseReport() {
		List<PurchaseReport> purchaseReport = purchaseReportService.getAllPurchaseReport();
		if (purchaseReport.isEmpty()) {
			return new ResponseEntity<List<PurchaseReport>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PurchaseReport>>(purchaseReport, HttpStatus.OK);

	}

	
	@GetMapping("/purchasereport/category/{category}")
	public ResponseEntity<List<PurchaseReport>> getPurchaseReportBasedOnCategory(@PathVariable String category) {
		List<PurchaseReport> purchaseReportBasedOnCategory = purchaseReportService.getPurchaseReportBasedOnCategory(category);
		if (purchaseReportBasedOnCategory.isEmpty()) {
			return new ResponseEntity<List<PurchaseReport>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PurchaseReport>>(purchaseReportBasedOnCategory, HttpStatus.OK);

	}
	
	@GetMapping("/purchasereport/date/{date}")
	public ResponseEntity<List<PurchaseReport>> getPurchaseReportBasedOnDate(@PathVariable String date) throws ParseException {
		System.out.println("Date from url is : " + date);
		List<PurchaseReport> purchaseReportBasedOnCategory = purchaseReportService.getPurchaseReportBasedOnDate(date);
		if (purchaseReportBasedOnCategory.isEmpty()) {
			return new ResponseEntity<List<PurchaseReport>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PurchaseReport>>(purchaseReportBasedOnCategory, HttpStatus.OK);

	}
}
