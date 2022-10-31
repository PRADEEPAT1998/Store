package com.store.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.store.model.Store;

@Component
public class StoreDTOBuilder {

	public StoreDTO toStoreDto(Store store) {

		StoreDTO storeDto = new StoreDTO();
		storeDto.setStore_name(store.getStore_name());
		storeDto.setStoreDate(store.getStoreDate());
		storeDto.setStore_income(store.getStore_income());
		storeDto.setStore_expense(store.getStore_expense());
		storeDto.setStoreDay(store.getStoreDay());
		return storeDto;
	}

	public List<StoreDTO> toStoreDto(List<Store> stores) {

		return stores.stream().map(store -> toStoreDto(store)).collect(Collectors.toList());

	}

	public Store toStore(StoreDTO storeDto) {

		Store store = new Store();

		store.setStore_name(storeDto.getStore_name());
		store.setStoreDate(storeDto.getStoreDate());
		store.setStore_income(storeDto.getStore_income());
		store.setStore_expense(storeDto.getStore_expense());
		store.setStoreDay(storeDto.getStoreDay());
		return store;

	}

	public List<Store> toStore(List<StoreDTO> storeDtos) {

		return storeDtos.stream().map(store -> toStore(store)).collect(Collectors.toList());

	}

}
