package com.anirudhbhatnagar.orderService.restClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.anirudhbhatnagar.orderService.dto.product.Product;

@Service
public class ProductServiceProxy {

	final String URI = "http://localhost:8001/api/products";

	@Autowired
	private RestTemplate restTemplate;

	public Product getProduct(Long id) {
		/*
		 * ResponseEntity<Product> response = restTemplate.getForEntity(URI +
		 * "/"+Long.toString(id), Product.class); return response.getBody();
		 */

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-", "application/json;Charset-UTF-8");
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		ResponseEntity<Product> response = restTemplate.exchange(URI + "/" + id, HttpMethod.GET,
				new HttpEntity<>(null, headers), new ParameterizedTypeReference<Product>() {
				});
		return response.getBody();
	}

}
