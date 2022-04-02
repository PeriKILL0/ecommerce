package com.patriarch.ecommerce.prices.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.patriarch.ecommerce.prices.entity.Price;

@DataJpaTest
class PricesRepositoryTest {

	@Autowired
	PricesRepository repository;

	private Price createPrice() {
		Price expected = new Price();
		expected.setPriceList(1L);
		expected.setBrandId(10L);
		expected.setProductId(100L);
		expected.setStartDate(Date.from(Instant.parse("2022-04-01T00:00:00Z")));
		expected.setEndDate(Date.from(Instant.parse("2022-05-01T00:00:00Z")));
		expected.setPriority(0);
		expected.setValue(35.99);
		expected.setCurrency("EUR");
		return expected;
	}

	@Test
	void testFindPriceFound() {

		Price expected = createPrice();
		repository.save(expected);

		List<Price> prices = repository.findPrice(100L, 10L, Date.from(Instant.parse("2022-04-04T00:00:00Z")));

		assertThat(prices).isNotEmpty();
		assertThat(prices.get(0)).usingRecursiveComparison().isEqualTo(expected);

	}

	@Test
	void testFindPriceProductNotFound() {

		Price expected = createPrice();
		repository.save(expected);

		List<Price> prices = repository.findPrice(99L, 10L, Date.from(Instant.parse("2022-05-04T00:00:00Z")));

		assertThat(prices).isEmpty();

	}

	@Test
	void testFindPriceBrandNotFound() {

		Price expected = createPrice();
		repository.save(expected);

		List<Price> prices = repository.findPrice(100L, 9L, Date.from(Instant.parse("2022-05-04T00:00:00Z")));

		assertThat(prices).isEmpty();

	}

	@Test
	void testFindPriceDateNotFound() {

		Price expected = createPrice();
		repository.save(expected);

		List<Price> prices = repository.findPrice(100L, 10L, Date.from(Instant.parse("2022-05-04T00:00:00Z")));

		assertThat(prices).isEmpty();

	}

	@Test
	void testFindPriceNullArgs() {

		Price expected = createPrice();
		repository.save(expected);

		List<Price> prices = repository.findPrice(null, null, null);

		assertThat(prices).isEmpty();

	}

}
