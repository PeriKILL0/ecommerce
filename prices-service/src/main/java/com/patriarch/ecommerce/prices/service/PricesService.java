package com.patriarch.ecommerce.prices.service;

import java.util.Date;

import com.patriarch.ecommerce.prices.entity.Price;

/**
 * Prices services interface
 * 
 * @author PeriKILL0
 */
public interface PricesService {

	/**
	 * Find the actual price of a product.
	 * 
	 * @param productId Product id.
	 * @param brandId   Brand id.
	 * @param date      Date
	 * @return Price of the product.
	 */
	Price findPrice(Long productId, Long brandId, Date date);

}
