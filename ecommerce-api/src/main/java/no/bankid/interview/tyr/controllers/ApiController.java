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

/**
 * ApiController
 */
@RestController
@RequestMapping("/api/v1")
public class ApiController {
	Logger logger = LoggerFactory.getLogger(ApiController.class);

	@PostMapping("/checkout")
	public Map<String, Integer> checkout(@RequestBody List<String> productIds) {
		logger.info("Checkout request received with productIds: {}", productIds);

		/*
		 * TODO: Implement this method
		 */

		return Collections.singletonMap("price", 0);
	}
}