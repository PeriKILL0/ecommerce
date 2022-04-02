package com.patriarch.ecommerce.prices.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.patriarch.ecommerce.prices.entity.Price;
import com.patriarch.ecommerce.prices.repository.PricesRepository;

/**
 * Pricer service implementation.
 * 
 * @author PeriKILL0
 */
@Service
public class PricesServiceImpl implements PricesService {

	/**
	 * Prices repository.
	 */
	@Autowired
	private PricesRepository pricesRepository;

	@Override
	public Price findPrice(Long productId, Long brandId, Date date) {

		List<Price> prices = pricesRepository.findPrice(productId, brandId, date);
		if (CollectionUtils.isEmpty(prices)) {
			return null;

		} else {
			return prices.get(0);
		}

	}

}
