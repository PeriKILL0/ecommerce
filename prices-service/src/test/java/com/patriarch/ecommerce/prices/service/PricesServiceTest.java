package com.patriarch.ecommerce.prices.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.patriarch.ecommerce.prices.entity.Price;

@SpringBootTest
class PricesServiceTest {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	@Autowired
	PricesService pricesService;
	
	@ParameterizedTest
	@ValueSource(strings = {"2020-06-14 10:00","2020-06-14 18:00","2020-06-14 16:00","2020-06-15 10:00","2020-06-16 21:00"}, 
	longs = {1,2,1,3,4})
	void testFindPrice(String date, long priceList) throws ParseException {
		
		Price price = pricesService.findPrice(35455L, 1L, sdf.parse(date));
		
		assertThat(price).isNotNull();
		assertThat(price.getPriceList()).isEqualTo(date);
		
	}
	
	@Test
	void testFindPriceCase1() throws ParseException {
		
		Price price = pricesService.findPrice(35455L, 1L, sdf.parse("2020-06-14 10:00"));
		
		assertThat(price).isNotNull();
		assertThat(price.getPriceList()).isEqualTo(1L);
		
	}
	
	@Test
	void testFindPriceCase2() throws ParseException {
		
		Price price = pricesService.findPrice(35455L, 1L, sdf.parse("2020-06-14 18:00"));
		
		assertThat(price).isNotNull();
		assertThat(price.getPriceList()).isEqualTo(2L);
		
	}
	
	@Test
	void testFindPriceCase3() throws ParseException {
		
		Price price = pricesService.findPrice(35455L, 1L, sdf.parse("2020-06-14 16:00"));
		
		assertThat(price).isNotNull();
		assertThat(price.getPriceList()).isEqualTo(1L);
		
	}
	
	@Test
	void testFindPriceCase4() throws ParseException {
		
		Price price = pricesService.findPrice(35455L, 1L, sdf.parse("2020-06-15 10:00"));
		
		assertThat(price).isNotNull();
		assertThat(price.getPriceList()).isEqualTo(3L);
		
	}
	
	@Test
	void testFindPriceCase5() throws ParseException {
		
		Price price = pricesService.findPrice(35455L, 1L, sdf.parse("2020-06-16 21:00"));
		
		assertThat(price).isNotNull();
		assertThat(price.getPriceList()).isEqualTo(4L);
		
	}

}
