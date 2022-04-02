package com.patriarch.ecommerce.prices.controller;

import static org.assertj.core.api.Assertions.assertThat;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.patriarch.ecommerce.prices.entity.Price;

@SpringBootTest
class PricesControllerTest {

	@Autowired
	PricesController pricesController;

	@Test
	void testFindPriceNotFound() throws ParseException {

		ResponseEntity<Price> response = pricesController.findPrice(1L, 1L, new Date());

		assertThat(response).isNotNull();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

	}

	@Test
	void testFindPriceNullArgs() throws ParseException {

		ResponseEntity<Price> response = pricesController.findPrice(null, null, null);

		assertThat(response).isNotNull();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

	}

	@Test
	void testFindPriceCase1() throws ParseException {

		ResponseEntity<Price> response = pricesController.findPrice(35455L, 1L,
				Date.from(Instant.parse("2020-06-14T10:00:00Z")));

		assertThat(response).isNotNull();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getPriceList()).isEqualTo(1L);

	}

	@Test
	void testFindPriceCase2() throws ParseException {

		ResponseEntity<Price> response = pricesController.findPrice(35455L, 1L,
				Date.from(Instant.parse("2020-06-14T16:00:00Z")));

		assertThat(response).isNotNull();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getPriceList()).isEqualTo(2L);

	}

	@Test
	void testFindPriceCase3() throws ParseException {

		ResponseEntity<Price> response = pricesController.findPrice(35455L, 1L,
				Date.from(Instant.parse("2020-06-14T21:00:00Z")));

		assertThat(response).isNotNull();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getPriceList()).isEqualTo(1L);

	}

	@Test
	void testFindPriceCase4() throws ParseException {

		ResponseEntity<Price> response = pricesController.findPrice(35455L, 1L,
				Date.from(Instant.parse("2020-06-15T10:00:00Z")));

		assertThat(response).isNotNull();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getPriceList()).isEqualTo(3L);

	}

	@Test
	void testFindPriceCase5() throws ParseException {

		ResponseEntity<Price> response = pricesController.findPrice(35455L, 1L,
				Date.from(Instant.parse("2020-06-16T21:00:00Z")));

		assertThat(response).isNotNull();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getPriceList()).isEqualTo(4L);

	}

}
