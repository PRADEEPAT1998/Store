package com.store.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.store.dto.StoreDTO;
import com.store.dto.StoreDTOBuilder;
import com.store.model.Store;
import com.store.repository.StoreRepository;

@Component
public class StoreServiceImpliments implements StoreService {

	@Autowired
	public StoreRepository storeRepository;

	@Autowired
	StoreDTOBuilder storeDtoBuilder;

	@Override
	public List<StoreDTO> getAllDetails() {

		List<Store> stores = new ArrayList<>();

		List<Store> listOfStores = (List<Store>) storeRepository.findAll();
		listOfStores.forEach(store -> {
			stores.add(store);
		});
		return storeDtoBuilder.toStoreDto(listOfStores);

	}

	@Override
	public StoreDTO saveStoreDetail(StoreDTO storeDto) {

		Store store = storeDtoBuilder.toStore(storeDto);

		Store save = storeRepository.save(store);

		return storeDtoBuilder.toStoreDto(save);
	}

	@Override
	public StoreDTO getDetail(Integer id) {

		Store stores = storeRepository.findById(id).orElse(null);

		return storeDtoBuilder.toStoreDto(stores);

	}

	@Override
	public StoreDTO update(int id, StoreDTO update) {

		storeDtoBuilder.toStore(update);

		Store storeDetail = storeRepository.findById(id).get();
		storeDetail.setStore_name(update.getStore_name());
		storeDetail.setStoreDate(update.getStoreDate());
		storeDetail.setStore_income(update.getStore_income());
		storeDetail.setStore_expense(update.getStore_expense());
		storeDetail.setStoreDay(update.getStoreDay());

		Store save = storeRepository.save(storeDetail);

		return storeDtoBuilder.toStoreDto(save);

	}

	@Override
	public int delete(int id) {

		storeRepository.deleteById(id);

		return id;
	}

	@Override
	public String getProfitValueByDates(Date startDate, Date endDate) {

		String date = storeRepository.getOrderValueByDate(startDate, endDate);

		return date;
	}

	@Override
	public List<String> getGroupValueByDate(Date startDate, Date endDate) {

		List<String> groupByDate = storeRepository.getGroupValueByDate(startDate, endDate);
		return groupByDate;
	}

}
