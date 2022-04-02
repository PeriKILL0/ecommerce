package com.patriarch.ecommerce.prices.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.patriarch.ecommerce.prices.entity.Price;

@SpringBootTest
class PricesServiceTest {

	@Autowired
	PricesService pricesService;

	@Test
	void testFindPriceFound() throws ParseException {

		Price price = pricesService.findPrice(35455L, 1L, Date.from(Instant.parse("2020-06-14T01:00:00Z")));

		assertThat(price).isNotNull();
		assertThat(price.getPriceList()).isEqualTo(1L);
		assertThat(price.getProductId()).isEqualTo(35455L);
		assertThat(price.getBrandId()).isEqualTo(1L);
		assertThat(price.getStartDate().toInstant()).isEqualTo(Instant.parse("2020-06-14T00:00:00.000Z"));
		assertThat(price.getEndDate().toInstant()).isEqualTo(Instant.parse("2020-12-31T23:59:59.000Z"));
		assertThat(price.getPriority()).isZero();
		assertThat(price.getValue()).isEqualTo(35.50);
		assertThat(price.getCurrency()).isEqualTo("EUR");

	}

	@Test
	void testFindPriceNotFound() throws ParseException {

		Price price = pricesService.findPrice(1L, 1L, new Date());

		assertThat(price).isNull();

	}

	@Test
	void testFindPriceNullArgs() throws ParseException {

		Price price = pricesService.findPrice(null, null, null);

		assertThat(price).isNull();

	}

}
