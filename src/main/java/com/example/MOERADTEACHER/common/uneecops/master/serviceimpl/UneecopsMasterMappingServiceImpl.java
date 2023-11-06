package com.example.MOERADTEACHER.common.uneecops.master.serviceimpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.MOERADTEACHER.common.uneecops.exception.customException.ValidateDateIsInDateRangeException;
import com.example.MOERADTEACHER.common.uneecops.master.dto.CheckDateBetweenDateRangeDTO;
import com.example.MOERADTEACHER.common.uneecops.master.dto.CheckTwoDateRangeOverlapsDTO;
import com.example.MOERADTEACHER.common.uneecops.master.eo.CategoryEo;
import com.example.MOERADTEACHER.common.uneecops.master.eo.RegionEo;
import com.example.MOERADTEACHER.common.uneecops.master.eo.RegionStationMappingEo;
import com.example.MOERADTEACHER.common.uneecops.master.eo.SchoolMasterEO;
import com.example.MOERADTEACHER.common.uneecops.master.eo.SchoolStationMappingEo;
import com.example.MOERADTEACHER.common.uneecops.master.eo.StaffTypePostMappingEO;
import com.example.MOERADTEACHER.common.uneecops.master.eo.StationCategoryMappingEO;
import com.example.MOERADTEACHER.common.uneecops.master.eo.StationEo;
import com.example.MOERADTEACHER.common.uneecops.master.repo.CategoryMasterRepository;
import com.example.MOERADTEACHER.common.uneecops.master.repo.RegionMasterRepo;
import com.example.MOERADTEACHER.common.uneecops.master.repo.RegionStationMappingRepository;
import com.example.MOERADTEACHER.common.uneecops.master.repo.SchoolMasterRepo;
import com.example.MOERADTEACHER.common.uneecops.master.repo.SchoolStationMappingRepository;
import com.example.MOERADTEACHER.common.uneecops.master.repo.StaffTypePostMappingRepository;
import com.example.MOERADTEACHER.common.uneecops.master.repo.StationCategoryMappingRepository;
import com.example.MOERADTEACHER.common.uneecops.master.repo.StationMasterRepo;
import com.example.MOERADTEACHER.common.uneecops.master.service.UneecopsMasterMappingService;
import com.example.MOERADTEACHER.common.uneecops.master.utils.UneecopsDateUtils;
import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionStationsMappingReqVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolMasterReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolStationMappingReqVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypePostMappingReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StationCategoryMappingReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StationMasterVo;

//import com.example.MOERADTEACHER.common.masterrepository.RegionMasterRepository;
//import com.example.MOERADTEACHER.common.masterrepository.StationMasterRepository;
//import com.example.MOERADTEACHER.common.uneecops.exception.customException.ValidateDateIsInDateRangeException;
//import com.example.MOERADTEACHER.common.uneecops.master.dto.CheckDateBetweenDateRangeDTO;
//import com.example.MOERADTEACHER.common.uneecops.master.dto.CheckTwoDateRangeOverlapsDTO;
//import com.example.MOERADTEACHER.common.uneecops.master.eo.CategoryEo;
//import com.example.MOERADTEACHER.common.uneecops.master.eo.RegionEo;
//import com.example.MOERADTEACHER.common.uneecops.master.eo.RegionStationMappingEo;
//import com.example.MOERADTEACHER.common.uneecops.master.eo.SchoolMasterEO;
//import com.example.MOERADTEACHER.common.uneecops.master.eo.SchoolStationMappingEo;
//import com.example.MOERADTEACHER.common.uneecops.master.eo.StaffTypePostMappingEO;
//import com.example.MOERADTEACHER.common.uneecops.master.eo.StationCategoryMappingEO;
//import com.example.MOERADTEACHER.common.uneecops.master.eo.StationEo;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.CategoryMasterRepository;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.RegionMasterRepo;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.RegionStationMappingRepository;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.SchoolMasterRepo;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.SchoolStationMappingRepository;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.StaffTypePostMappingRepository;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.StationCategoryMappingRepository;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.StationMasterRepo;
//import com.example.MOERADTEACHER.common.uneecops.master.service.UneecopsMasterMappingService;
//import com.example.MOERADTEACHER.common.uneecops.master.utils.UneecopsDateUtils;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.CategoryMasterVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionStationsMappingReqVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolMasterReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolStationMappingReqVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypePostMappingReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StationCategoryMappingReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StationMasterVo;

@Service
public class UneecopsMasterMappingServiceImpl implements UneecopsMasterMappingService {
	@Autowired
	private RegionStationMappingRepository regionStationMappingRepository;
	@Autowired
	private StationCategoryMappingRepository stationCategoryMappingRepository;
	@Autowired
	private SchoolStationMappingRepository schoolStationMappingRepository;
	@Autowired
	private StaffTypePostMappingRepository staffTypePostMappingRepository;
	
	@Autowired
	private StationMasterRepo stationMasterRepo;
	@Autowired
	private RegionMasterRepo regionMasterRepo;
	@Autowired
	private CategoryMasterRepository categoryMasterRepository;
	@Autowired
	private SchoolMasterRepo schoolMasterRepo;
	

	@Transactional
	@Override
	public void saveRegionStationsMapping(RegionStationsMappingReqVo regionStationsMappingReqVo) {
		List<StationMasterVo> stationListReq = regionStationsMappingReqVo.getStation();

		for (StationMasterVo stationMasterVo : stationListReq) {
			validateRegionStationInRange(stationMasterVo.getStationCode(), regionStationsMappingReqVo.getFromDate(),
					regionStationsMappingReqVo.getToDate());
			RegionStationMappingEo regionStationEo = new RegionStationMappingEo();
			regionStationEo.setStationCode(stationMasterVo.getStationCode());
			regionStationEo.setRegionCode(regionStationsMappingReqVo.getRegionCode());
			regionStationEo.setFromDate(regionStationsMappingReqVo.getFromDate());
			regionStationEo.setToDate(regionStationsMappingReqVo.getToDate());

			if (regionStationsMappingReqVo.getToDate() != null) {
				regionStationEo.setActive(Boolean.FALSE);
				System.out.println("Boolean.FALSE" + Boolean.FALSE);
			} else {
				regionStationEo.setActive(Boolean.TRUE);
				System.out.println("Boolean.true" + Boolean.TRUE);
			}
			regionStationEo.setCreatedDate(UneecopsDateUtils.getCurrentTimeStamp());

			regionStationMappingRepository.save(regionStationEo);
		}

	}

	private void validateRegionStationInRange(Integer stationCode, LocalDate fromdate, LocalDate todate) {
		try {
		List<RegionStationMappingEo> data = regionStationMappingRepository.findByStationCode(stationCode);
		RegionStationMappingEo regionStationMappingEo2 = null;
		if (data.size() > 0) {
			Collections.sort(data, Comparator.comparing(RegionStationMappingEo::getId));
			System.out.println("DB list size is 11111--> " + data.size());
			System.out.println("DB list size is 11111--> " + data.toString());

			regionStationMappingEo2 = data.get(data.size() - 1);
			LocalDate toDate2 = regionStationMappingEo2.getToDate();
			if (null == toDate2) {
				LocalDate toDateForOldEntry = fromdate.minusDays(1);
				regionStationMappingEo2.setToDate(toDateForOldEntry);
				regionStationMappingEo2.setActive(Boolean.FALSE);
				regionStationMappingRepository.save(regionStationMappingEo2);
			}

		}
		data = regionStationMappingRepository.findByStationCode(stationCode);
		System.out.println("DB list size is222222 --> " + data.size());
		System.out.println("DB list size is 2222222--> " + data.toString());
		for (RegionStationMappingEo eo : data) {
			boolean result = false;
			StationEo stationEo=stationMasterRepo.findStationNameByStationCode(stationCode);
			RegionEo regionEo=regionMasterRepo.findRegionNameByRegionCode(eo.getRegionCode());
			LocalDate fromDate=eo.getFromDate();
			System.out.println("fromDate---->"+fromDate);
			LocalDate toDate=eo.getToDate();
			DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String Formatteddate1=fromDate.format(dateTimeFormatter);
			String Formatteddate2=toDate.format(dateTimeFormatter);
			if (null == todate) {

				if (fromdate.equals(eo.getFromDate()) && null == eo.getToDate()) {
					throw new ValidateDateIsInDateRangeException("Station " +stationEo.getStationName()+ "("+stationCode+")"
							+ " is already mapped with Region "+regionEo.getRegionName()+ "("+regionEo.getRegionCode()+") for date range " + Formatteddate1 + " and end date null ");
				}
				CheckDateBetweenDateRangeDTO betweenDateRangeDTO = new CheckDateBetweenDateRangeDTO(fromdate,
						eo.getFromDate(), eo.getToDate());
				result = UneecopsDateUtils.verifyDateBetweenDateRange(betweenDateRangeDTO);
			} else {
				CheckTwoDateRangeOverlapsDTO checkTwoDateRangeOverlapsDTO = new CheckTwoDateRangeOverlapsDTO(fromdate,
						todate, eo.getFromDate(), eo.getToDate());
				result = UneecopsDateUtils.validateTwoDateRangeOverlapping(checkTwoDateRangeOverlapsDTO);

			}
			System.out.println("RegionStationMappingEo found in DB-------");
			System.out.println("RegionStationMappingEo found in DB--result -----" + result);
			if (result) {
				throw new ValidateDateIsInDateRangeException("Station " +stationEo.getStationName()+ "("+stationCode+")"
						+ " is already mapped with Region "+regionEo.getRegionName()+ "("+regionEo.getRegionCode()+") for date range " +Formatteddate1 + " to " + Formatteddate2);
			}

		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void saveStationCategoryMapping(StationCategoryMappingReqVO stationCategoryMappingReqVO) {
	System.out.println("station category save");
//		validateStationCategoryInRange(stationCategoryMappingReqVO.getStationCode(),
//		stationCategoryMappingReqVO.getFromDate(), stationCategoryMappingReqVO.getToDate());
		System.out.println("Afetr validation check");
		StationCategoryMappingEO stationCategoryMappingEO = new StationCategoryMappingEO();
		stationCategoryMappingEO.setStationCode(stationCategoryMappingReqVO.getStationCode());
		stationCategoryMappingEO.setCategoryId(stationCategoryMappingReqVO.getCategoryId());
		stationCategoryMappingEO.setFromDate(stationCategoryMappingReqVO.getFromDate());
		stationCategoryMappingEO.setToDate(stationCategoryMappingReqVO.getToDate());
		
		if(stationCategoryMappingReqVO.getId() !=null) {
			System.out.println("stationCategoryMappingReqVO.getId()--->"+stationCategoryMappingReqVO.getId());
			stationCategoryMappingEO.setId(stationCategoryMappingReqVO.getId());
		}
		
		System.out.println("ToDate--->"+stationCategoryMappingReqVO.getToDate());
		
		if (stationCategoryMappingReqVO.getToDate() != null) {
			stationCategoryMappingEO.setStatus(Boolean.FALSE);
			System.out.println("Boolean.FALSE" +Boolean.FALSE );
		} else {
			stationCategoryMappingEO.setStatus(Boolean.TRUE);
			System.out.println("Boolean.true" + Boolean.TRUE);
		}
		
		stationCategoryMappingEO.setCreatedDate(UneecopsDateUtils.getCurrentTimeStamp());

		System.out.println("Before save update call--->"+stationCategoryMappingEO.getId());
		
		stationCategoryMappingRepository.save(stationCategoryMappingEO);

	}

	private void validateStationCategoryInRange(Integer stationCode, LocalDate fromdate, LocalDate todate) {
		List<StationCategoryMappingEO> data = stationCategoryMappingRepository.findByStationCode(stationCode);
		StationCategoryMappingEO stationCategoryMappingEO = null;
		if (data.size() > 0) {
			Collections.sort(data, Comparator.comparing(StationCategoryMappingEO::getCreatedDate));
			System.out.println("DB list size is --> " + data.size());

			stationCategoryMappingEO = data.get(data.size() - 1);
			LocalDate toDate2 = stationCategoryMappingEO.getToDate();
			if (null == toDate2) {
				LocalDate toDateForOldEntry = fromdate.minusDays(1);
				stationCategoryMappingEO.setToDate(toDateForOldEntry);
				stationCategoryMappingEO.setStatus(Boolean.FALSE);
				stationCategoryMappingRepository.save(stationCategoryMappingEO);
			}
		}
		data = stationCategoryMappingRepository.findByStationCode(stationCode);

		for (StationCategoryMappingEO eo : data) {
			boolean result = false;
			StationEo stationEo=stationMasterRepo.findStationNameByStationCode(stationCode);
			System.out.println("eo.getCategoryId()"+eo.getCategoryId());
			CategoryEo categoryEo=categoryMasterRepository.findCategoryNameById(eo.getCategoryId());
			LocalDate fromDate=eo.getFromDate();
			LocalDate toDate=eo.getToDate();
			DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String Formatteddate1=fromDate.format(dateTimeFormatter);
			String Formatteddate2=toDate.format(dateTimeFormatter);
			System.out.println(categoryEo.getCategoryName()+" <-categoryEo.getCategoryName()");
			if (null == todate) {
				if (fromdate.equals(eo.getFromDate()) && null == eo.getToDate()) {
					throw new ValidateDateIsInDateRangeException("Station " +stationEo.getStationName()+ "("+stationCode+")"
							+ " is already mapped with Category "+categoryEo.getCategoryName()+ "("+categoryEo.getId()+") "+"for date range " + Formatteddate1 + " and end date null ");
				}

				CheckDateBetweenDateRangeDTO betweenDateRangeDTO = new CheckDateBetweenDateRangeDTO(fromdate,
						eo.getFromDate(), eo.getToDate());
				result = UneecopsDateUtils.verifyDateBetweenDateRange(betweenDateRangeDTO);
			} else {
				CheckTwoDateRangeOverlapsDTO checkTwoDateRangeOverlapsDTO = new CheckTwoDateRangeOverlapsDTO(fromdate,
						todate, eo.getFromDate(), eo.getToDate());
				result = UneecopsDateUtils.validateTwoDateRangeOverlapping(checkTwoDateRangeOverlapsDTO);

			}
			System.out.println("StationCategoryMappingEo found in DB-------");
			System.out.println("StationCategoryMappingEo found in DB--result -----" + result);
			if (result) {
				throw new ValidateDateIsInDateRangeException("Station " +stationEo.getStationName()+ "("+stationCode+")"
						+ " is already mapped with Category "+categoryEo.getCategoryName()+ "("+categoryEo.getId()+") "+"for date range " + Formatteddate1 + " to " + Formatteddate2);
			}

		}

	}

	public void validateSchoolStationInRange(Integer scCode, LocalDate fromdate, LocalDate todate) {

		List<SchoolStationMappingEo> data = schoolStationMappingRepository.findBySchoolCode(scCode);
		System.out.println("hi");
		SchoolStationMappingEo schoolStationMappingEo = null;
		if (data.size() > 0) {
			Collections.sort(data, Comparator.comparing(SchoolStationMappingEo::getCreatedDate));
			System.out.println("DB list size is --> " + data.size());
			schoolStationMappingEo = data.get(data.size() - 1);
			LocalDate toDate2 = schoolStationMappingEo.getToDate();
			if (null == toDate2) {
				LocalDate toDateForOldEntry = fromdate.minusDays(1);
				schoolStationMappingEo.setToDate(toDateForOldEntry);
				schoolStationMappingEo.setActive(Boolean.FALSE);
				schoolStationMappingRepository.save(schoolStationMappingEo);
			}
		}
		data = schoolStationMappingRepository.findBySchoolCode(scCode);
		System.out.println("data -> " + data);

		for (SchoolStationMappingEo eo : data) {
			boolean result = false;
			LocalDate fromDate=eo.getFromDate();
			LocalDate toDate=eo.getToDate();
			DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String Formatteddate1=fromDate.format(dateTimeFormatter);
			String Formatteddate2=toDate.format(dateTimeFormatter);
			
			System.out.println("stationCode ->"+eo.getStationCode());
			StationEo stationEo=stationMasterRepo.findStationNameByStationCode(eo.getStationCode());
			System.out.println("hi");
			System.out.println("stationEo ->"+stationEo.getStationCode());
			SchoolMasterEO schoolMasterEO = schoolMasterRepo.findSchoolNameBySchoolCode(scCode);
			System.out.println(schoolMasterEO.getSchoolName());
			if (null == todate) {
				if (fromdate.equals(eo.getFromDate()) && null == eo.getToDate()) {
					throw new ValidateDateIsInDateRangeException("School " +schoolMasterEO.getSchoolName()+ "("+scCode+")"
							+ " is already mapped with Region "+stationEo.getStationName()+ "("+stationEo.getStationCode()+") for date range " +Formatteddate1+ " and end date null ");
				}
				CheckDateBetweenDateRangeDTO betweenDateRangeDTO = new CheckDateBetweenDateRangeDTO(fromdate,
						eo.getFromDate(), eo.getToDate());
				result = UneecopsDateUtils.verifyDateBetweenDateRange(betweenDateRangeDTO);
			} else {
				CheckTwoDateRangeOverlapsDTO checkTwoDateRangeOverlapsDTO = new CheckTwoDateRangeOverlapsDTO(fromdate,
						todate, eo.getFromDate(), eo.getToDate());
				result = UneecopsDateUtils.validateTwoDateRangeOverlapping(checkTwoDateRangeOverlapsDTO);

			}
			System.out.println("schoolStationMappingEo found in DB-------");
			System.out.println("schoolStationMappingEo found in DB--result -----" + result);
			if (result) {
				throw new ValidateDateIsInDateRangeException("School " +schoolMasterEO.getSchoolName()+ "("+scCode+")"
						+ " is already mapped with Region "+stationEo.getStationName()+ "("+stationEo.getStationCode()+") for date range " + Formatteddate1 + " to " + Formatteddate2);
			}
		}

	}

	@Override
	public void saveStationSchoolsMapping(SchoolStationMappingReqVo schoolStationMappingReqVo) {
		System.out.println("schoolStationMappingReqVo--->"+schoolStationMappingReqVo);
		List<SchoolMasterReqVO> schoolMasterReqVoList = schoolStationMappingReqVo.getSchoolMasterReqVoList();
		for (SchoolMasterReqVO schoolMasterReqVO : schoolMasterReqVoList) {
			

//			validateSchoolStationInRange(schoolMasterReqVO.getSchoolCode(), schoolStationMappingReqVo.getFromDate(),
//					schoolStationMappingReqVo.getToDate());

			SchoolStationMappingEo schoolStationMappingEo = new SchoolStationMappingEo();

			schoolStationMappingEo.setStationCode(schoolStationMappingReqVo.getStationCode());
			schoolStationMappingEo.setSchoolCode(schoolMasterReqVO.getSchoolCode());
			schoolStationMappingEo.setFromDate(schoolStationMappingReqVo.getFromDate());
			schoolStationMappingEo.setToDate(schoolStationMappingReqVo.getToDate());
			schoolStationMappingEo.setCreatedDate(UneecopsDateUtils.getCurrentTimeStamp());
			schoolStationMappingEo.setActive(schoolStationMappingReqVo.isStatus());
			if (schoolStationMappingReqVo.getToDate() != null) {
				schoolStationMappingEo.setActive(Boolean.FALSE);
			} else {
				schoolStationMappingEo.setActive(Boolean.TRUE);
			}
			
			if(schoolStationMappingReqVo.getId() !=null) {
				schoolStationMappingEo.setId(schoolStationMappingReqVo.getId());
			}
			System.out.println("Mapping school Station");
			System.out.println("Is status--->"+schoolStationMappingReqVo.isStatus());
			
			schoolStationMappingRepository.save(schoolStationMappingEo);

		}
	}

	@Override
	public void saveStaffTypePostMapping(@Valid StaffTypePostMappingReqVO reqVo) {
	StaffTypePostMappingEO staffTypePostMappingEO = new StaffTypePostMappingEO();
		staffTypePostMappingEO.setStaffTypeId(reqVo.getStaffTypeId());
		staffTypePostMappingEO.setDesignationId(reqVo.getDesignationId());
		staffTypePostMappingEO.setStatus(reqVo.isStatus());
		staffTypePostMappingEO.setCreatedDate(UneecopsDateUtils.getCurrentTimeStamp());
		staffTypePostMappingRepository.save(staffTypePostMappingEO);

	}
		
	
}
