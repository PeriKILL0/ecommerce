package com.patriarch.ecommerce.prices.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.patriarch.ecommerce.prices.entity.Price;
import com.patriarch.ecommerce.prices.repository.PricesRepository;

@Service
public class PricesServiceImpl implements PricesService {

	@Autowired
	private PricesRepository repository;

	@Override
	public Price findPrice(Long productId, Long brandId, Date date) {

		List<Price> prices = repository.findPrice(productId, brandId, date);
		if (CollectionUtils.isEmpty(prices)) {
			return null;

		} else {
			return prices.get(0);
		}

	}

}
