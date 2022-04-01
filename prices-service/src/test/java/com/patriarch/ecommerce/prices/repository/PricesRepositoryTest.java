package com.patriarch.ecommerce.prices.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.patriarch.ecommerce.prices.entity.Price;

@DataJpaTest
class PricesRepositoryTest {
	
	@Autowired
	PricesRepository repository;

	@Test
	void test() {
		
		Price price = repository.findPriceByProductoAndBrandAndDate(1L, 1L, new Date());
		
	}

}
