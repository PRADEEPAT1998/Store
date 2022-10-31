package com.store.control;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.StoreDTO;
import com.store.dto.StoreDTOBuilder;
import com.store.model.Store;
import com.store.repository.StoreRepository;
import com.store.repository.StoreRepositoryCustom;
import com.store.service.StoreService;

@RestController
@RequestMapping("/store/api")
public class StoreController {

	@Autowired
	StoreService storeService;

	@Autowired
	StoreDTOBuilder storeDtoBuilder;

	@Autowired
	StoreRepository storeRepository;

	@Autowired
	StoreRepositoryCustom storeRepositoryCustom;

	@GetMapping(path = "/getallstoredetails")
	public List<StoreDTO> getAllStoreDetails() {

		return storeService.getAllDetails();

	}

	@PostMapping(path = "/addstoredetail")
	public StoreDTO addStoreDetail(@RequestBody StoreDTO storeDto) {
		return storeService.saveStoreDetail(storeDto);

	}

	@GetMapping(path = "/getstoredetailbyid/{id}")
	public StoreDTO getStoreDetailById(@PathVariable Integer id) {
		return storeService.getDetail(id);

	}

	@PutMapping("/updatestoredetail/{id}")
	public StoreDTO updateStoreDetail(@PathVariable int id, @RequestBody StoreDTO storeDto) {
		return storeService.update(id, storeDto);

	}

	@DeleteMapping("/deletestoredetail/{id}")
	public int deleteStoreDetail(@PathVariable int id) {
		return storeService.delete(id);
	}

	@GetMapping(path = "/getprofitvalue/{startdate}/{enddate}")
	public String getStoreDateValueByDate(
			@PathVariable("startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@PathVariable("enddate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
		return storeService.getProfitValueByDates(startDate, endDate);
	}

	@PostMapping(value = "/getlistofgroupofvalue")
	public List<String> getProfitValueByQuery(
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
		return storeService.getGroupValueByDate(startDate, endDate);

	}

	@PostMapping("/listofstoreprofit")
	public List<Integer> findStoreProfitByDate(
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
		
		List<Integer> listOfProfits = storeRepositoryCustom.findByStoreDateAndStoreDate(startDate, endDate);
		return listOfProfits;
	}

	@GetMapping("/findstorevaluebyday/{storeday}")
	public List<Store> getValuesByDay(@PathVariable(value = "storeday") String storeDay) {
		
		List<Store> listOfstoreDayValue = storeRepository.findByStoreDay(storeDay);
		return listOfstoreDayValue;

	}

}
