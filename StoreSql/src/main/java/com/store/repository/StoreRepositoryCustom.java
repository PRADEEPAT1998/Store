package com.store.repository;

import java.time.LocalDate;
import java.util.List;

public interface StoreRepositoryCustom {

	List<Integer> findByStoreDateAndStoreDate(LocalDate startDate, LocalDate endDate);

	
}
