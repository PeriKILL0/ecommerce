package com.patriarch.ecommerce.prices.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.patriarch.ecommerce.prices.entity.Price;

@SpringBootTest
class PricesServiceTest {

	@Autowired
	PricesService pricesService;

	@Test
	void testFindPriceCase1() throws ParseException {

		Price price = pricesService.findPrice(35455L, 1L, Date.from(Instant.parse("2020-06-14T10:00:00Z")));

		assertThat(price).isNotNull();
		assertThat(price.getPriceList()).isEqualTo(1L);

	}

	@Test
	void testFindPriceCase2() throws ParseException {

		Price price = pricesService.findPrice(35455L, 1L, Date.from(Instant.parse("2020-06-14T16:00:00Z")));

		assertThat(price).isNotNull();
		assertThat(price.getPriceList()).isEqualTo(2L);

	}

	@Test
	void testFindPriceCase3() throws ParseException {

		Price price = pricesService.findPrice(35455L, 1L, Date.from(Instant.parse("2020-06-14T21:00:00Z")));

		assertThat(price).isNotNull();
		assertThat(price.getPriceList()).isEqualTo(1L);

	}

	@Test
	void testFindPriceCase4() throws ParseException {

		Price price = pricesService.findPrice(35455L, 1L, Date.from(Instant.parse("2020-06-15T10:00:00Z")));

		assertThat(price).isNotNull();
		assertThat(price.getPriceList()).isEqualTo(3L);

	}

	@Test
	void testFindPriceCase5() throws ParseException {

		Price price = pricesService.findPrice(35455L, 1L, Date.from(Instant.parse("2020-06-16T21:00:00Z")));

		assertThat(price).isNotNull();
		assertThat(price.getPriceList()).isEqualTo(4L);

	}

}
