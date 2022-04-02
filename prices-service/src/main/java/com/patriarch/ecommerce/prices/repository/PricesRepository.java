package com.patriarch.ecommerce.prices.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.patriarch.ecommerce.prices.entity.Price;

/**
 * Prices repository interface.
 * 
 * @author PeriKILL0
 */
public interface PricesRepository extends JpaRepository<Price, Long> {

	/**
	 * Find the price of a product.
	 * 
	 * @param productId Product id.
	 * @param brandId   Brand id.
	 * @param date      Date.
	 * @return Price of the product.
	 */
	@Query(value = "SELECT p FROM Price p " + "WHERE p.productId=:productId " + "AND p.brandId=:brandId "
			+ "AND :date BETWEEN p.startDate AND p.endDate " + "ORDER BY p.priority DESC")
	public List<Price> findPrice(Long productId, Long brandId, Date date);

}
