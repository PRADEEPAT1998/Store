package com.store.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.store.model.Store;
import com.store.repository.StoreRepositoryCustom;

@Primary
@Component
public class StoreRepositoryCustomImpli implements StoreRepositoryCustom {

	@Autowired
	public EntityManager entityManager;

	@Override
	public List<Integer> findByStoreDateAndStoreDate(LocalDate startDate, LocalDate endDate) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Integer> createQuery = criteriaBuilder.createQuery(int.class);
		Root<Store> store = createQuery.from(Store.class);
		Predicate datePredicate = criteriaBuilder.between(store.get("storeDate"), startDate, endDate);
		createQuery.where(datePredicate);
		createQuery.select(criteriaBuilder.diff(store.get("store_income"), store.get("store_expense")));

		TypedQuery<Integer> typedQuery = entityManager.createQuery(createQuery);

		return typedQuery.getResultList();

	}

}
