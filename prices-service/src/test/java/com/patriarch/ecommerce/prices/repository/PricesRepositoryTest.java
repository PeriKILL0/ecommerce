package com.patriarch.ecommerce.prices.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.patriarch.ecommerce.prices.entity.Price;

@DataJpaTest
class PricesRepositoryTest {

	@Autowired
	PricesRepository repository;

	@Test
	void testFindPriceDateFilterFound() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Price expected = new Price();
		expected.setPriceList(1L);
		expected.setBrandId(1L);
		expected.setProductId(1L);
		expected.setStartDate(sdf.parse("2022-04-01 00:00"));
		expected.setEndDate(sdf.parse("2022-05-01 00:00"));
		expected.setPriority(0);
		expected.setValue(35.99);
		expected.setCurrency("EUR");
		repository.save(expected);

		List<Price> prices = repository.findPrice(1L, 1L, sdf.parse("2022-04-04 00:00"));

		assertThat(prices).isNotEmpty();
		assertThat(prices.get(0)).usingRecursiveComparison().isEqualTo(expected);
	}

	@Test
	void testFindPriceDateFilterNotFound() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Price expected = new Price();
		expected.setPriceList(1L);
		expected.setBrandId(1L);
		expected.setProductId(1L);
		expected.setStartDate(sdf.parse("2022-04-01 00:00"));
		expected.setEndDate(sdf.parse("2022-05-01 00:00"));
		expected.setPriority(0);
		expected.setValue(35.99);
		expected.setCurrency("EUR");
		repository.save(expected);

		List<Price> prices = repository.findPrice(1L, 1L, sdf.parse("2022-05-04 00:00"));

		assertThat(prices).isEmpty();
	}

}
