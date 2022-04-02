package com.patriarch.ecommerce.prices.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Prices entity
 * 
 * @author PeriKILL0
 */
@Entity
@Table(name = "PRICES")
public class Price {
	/**
	 * Price list.
	 */
	@Id
	@Column(name = "PRICE_LIST", nullable = false)
	private Long priceList;

	/**
	 * Brand id.
	 */
	@Column(name = "BRAND_ID", nullable = false)
	private Long brandId;

	/**
	 * Product id.
	 */
	@Column(name = "PRODUCT_ID", nullable = false)
	private Long productId;

	/**
	 * Start date.
	 */
	@Column(name = "START_DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	/**
	 * End date.
	 */
	@Column(name = "END_DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	/**
	 * Priority.
	 */
	@Column(name = "PRIORITY", nullable = false)
	private Integer priority;

	/**
	 * Price.
	 */
	@Column(name = "PRICE", nullable = false)
	private Double value;

	/**
	 * Currency.
	 */
	@Column(name = "CURR", nullable = false)
	private String currency;

	/**
	 * Constructor.
	 */
	public Price() {
		this.priceList = null;
		this.brandId = null;
		this.productId = null;
		this.startDate = null;
		this.endDate = null;
		this.priority = null;
		this.value = null;
		this.currency = null;
	}

	/**
	 * Gets the price list.
	 * 
	 * @return Price list.
	 */
	public Long getPriceList() {
		return priceList;
	}

	/**
	 * Sets the price list.
	 * 
	 * @param priceList New price list.
	 */
	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	/**
	 * Gets the brand id.
	 * 
	 * @return Brand id.
	 */
	public Long getBrandId() {
		return brandId;
	}

	/**
	 * Sets the brand id.
	 * 
	 * @param brandId New brand id.
	 */
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	/**
	 * Gets the product id.
	 * 
	 * @return Product id.
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * Sets the product id.
	 * 
	 * @param productId New product id.
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * Gets the start date.
	 * 
	 * @return Start date.
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 * 
	 * @param startDate New start date.
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 * 
	 * @return End date.
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 * 
	 * @param endDate New end date.
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the priority.
	 * 
	 * @return Priority.
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * Sets the priority.
	 * 
	 * @param priority New priority.
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * Gets the value.
	 * 
	 * @return Value.
	 */
	public Double getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value New value.
	 */
	public void setValue(Double value) {
		this.value = value;
	}

	/**
	 * Gets the currency.
	 * 
	 * @return Currency.
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 * 
	 * @param currency New currency.
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
