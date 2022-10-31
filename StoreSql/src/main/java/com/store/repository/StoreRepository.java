package com.store.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.store.model.Store;

public interface StoreRepository extends CrudRepository<Store, Integer>, StoreRepositoryCustom {

	public List<Store> findByStoreDay(String storeDay);

	@Query(value = "SELECT store_name ,sum(store_income-store_expense) as profit FROM store_detail "
			+ " WHERE store_date  between ? and ?  order by Store_name", nativeQuery = true)

	public String getOrderValueByDate(Date startDate, Date endDate);

	@Query(value = "SELECT store_date ,store_income,store_expense,sum(store_income-store_expense)  FROM store_detail "
			+ "WHERE store_date  between ? and ? group by Store_date ", nativeQuery = true)

	public List<String> getGroupValueByDate(Date startDate, Date endDate);

}
