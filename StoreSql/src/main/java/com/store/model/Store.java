package com.store.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "store_detail")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "store_name")
	private String store_name;

	@Column(name = "store_date")
	private LocalDate storeDate;

	@Column(name = "store_income")
	private int store_income;

	@Column(name = "store_expense")
	private int store_expense;

	@Column(name = "store_day")
	private String storeDay;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public LocalDate getStoreDate() {
		return storeDate;
	}

	public void setStoreDate(LocalDate storeDate) {
		this.storeDate = storeDate;
	}

	public String getStoreDay() {
		return storeDay;
	}

	public void setStoreDay(String storeDay) {
		this.storeDay = storeDay;
	}

	public int getStore_income() {
		return store_income;
	}

	public void setStore_income(int store_income) {
		this.store_income = store_income;
	}

	public int getStore_expense() {
		return store_expense;
	}

	public void setStore_expense(int store_expense) {
		this.store_expense = store_expense;
	}

}
