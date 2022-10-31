package com.store.service;

import java.util.Date;
import java.util.List;

import com.store.dto.StoreDTO;

public interface StoreService {

	List<StoreDTO> getAllDetails();

	StoreDTO saveStoreDetail(StoreDTO storeDto);

	StoreDTO getDetail(Integer id);

	StoreDTO update(int id, StoreDTO update);

	int delete(int id);

	String getProfitValueByDates(Date startDate, Date endDate);

	List<String> getGroupValueByDate(Date startDate, Date endDate);

	

}
