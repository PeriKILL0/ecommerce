package com.patriarch.ecommerce.prices.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patriarch.ecommerce.prices.entity.Price;
import com.patriarch.ecommerce.prices.service.PricesService;

/**
 * Prices controller.
 * 
 * @author PeriKILL0
 */
@RestController
@RequestMapping(path = "/prices")
public class PricesController {

	@Autowired
	PricesService pricesService;

	/**
	 * Find the actual price of a product.
	 * 
	 * @param productId Product id.
	 * @param brandId   Brand id.
	 * @param date      Date
	 * @return Price of the product.
	 */
	@GetMapping
	public ResponseEntity<Price> findPrice(@RequestParam(name = "productId", required = true) Long productId,
			@RequestParam(name = "brandId", required = true) Long brandId,
			@RequestParam(name = "date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date date) {

		Price price = pricesService.findPrice(productId, brandId, date);
		if (null == price) {
			return ResponseEntity.noContent().build();

		} else {
			return ResponseEntity.ok(price);
		}
	}

}
