package no.bankid.interview.tyr.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 * ApiController
 */
@RestController
@RequestMapping("/api/v1")
public class ApiController {
	Logger logger = LoggerFactory.getLogger(ApiController.class);

	@PostMapping("/checkout")
	public Map<String, Integer> checkout(@RequestBody List<String> productIds) throws IOException {
		int totalPrice = calculateTotalPrice(productIds);

		return Collections.singletonMap("price", totalPrice);
	}

	private int calculateTotalPrice(List<String> productIds) throws IOException {
		JSONArray productsArray = fetchProducts();

		int totalPrice = 0;
		for (String productId : productIds) {
			for (int i = 0; i < productsArray.length(); i++) {
				JSONObject productObj = productsArray.getJSONObject(i);
				if (productObj.getString("id").equals(productId)) {
					totalPrice += productObj.getInt("price");
				}
			}
		}

		return totalPrice;
	}

	private JSONArray fetchProducts() throws IOException {
		Path filePath = Paths.get("ecommerce-api/src/localDB/products.json").toAbsolutePath();
		String productsJson = new String(Files.readAllBytes(filePath));
		JSONObject json = new JSONObject(productsJson);

		JSONArray productsArray = json.getJSONArray("products");
		return productsArray;
	}
}