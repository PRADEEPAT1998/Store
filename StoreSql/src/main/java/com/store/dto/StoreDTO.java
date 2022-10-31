package com.store.dto;

import java.time.LocalDate;

public class StoreDTO {

	private String store_name;
	private LocalDate storeDate;
	private int store_income;
	private int store_expense;
	private String storeDay;

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
