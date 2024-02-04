package com.example.MOERADTEACHER.common.transferservice;

import java.io.File;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Period;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.MOERADTEACHER.common.bean.PostingHistory;
import com.example.MOERADTEACHER.common.bean.Stationdurationb;
import com.example.MOERADTEACHER.common.bean.TransferSpouseBean;
import com.example.MOERADTEACHER.common.bean.WorkExperienceBean;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
import com.example.MOERADTEACHER.common.modal.TeacherTransferGround;
import com.example.MOERADTEACHER.common.repository.TeacherExperienceRepository;
import com.example.MOERADTEACHER.common.repository.TeacherProfileRepository;
//import com.example.MOERADTEACHER.common.repository.TeacherPromotionRepository;
import com.example.MOERADTEACHER.common.transferbean.DisplacementCountAward;
import com.example.MOERADTEACHER.common.transferbean.DocumentBean;
import com.example.MOERADTEACHER.common.transferbean.HardStationDetailModel;
import com.example.MOERADTEACHER.common.transferbean.SchoolTransferProfile;
import com.example.MOERADTEACHER.common.transferbean.TransferInititateBean;
import com.example.MOERADTEACHER.common.transfercontroller.TransferController;
import com.example.MOERADTEACHER.common.transfermodel.TeacherKVTransferGround;
import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferDeclaration;
import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferedDetails;
import com.example.MOERADTEACHER.common.transfermodel.TransferHistory;
import com.example.MOERADTEACHER.common.transfermodel.TransferKVTeacherDetails;
import com.example.MOERADTEACHER.common.transfermodel.TransferKVTeacherDetailsHistory;
import com.example.MOERADTEACHER.common.transferrepository.TeacherKVTransferGroundRepository;
import com.example.MOERADTEACHER.common.transferrepository.TeacherTransferDeclarationRepository;
import com.example.MOERADTEACHER.common.transferrepository.TeacherTransferedDetailsRepository;
import com.example.MOERADTEACHER.common.transferrepository.TransferHistoryRepository;
import com.example.MOERADTEACHER.common.transferrepository.TransferKVTeacherDetailsHistoryRepository;
import com.example.MOERADTEACHER.common.transferrepository.TransferKVTeacherDetailsRepository;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;
import com.example.MOERADTEACHER.common.util.ResponseEntityBeans;
import com.example.MOERADTEACHER.common.util.StaticReportBean;
import com.example.MOERADTEACHER.security.LoginNativeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class TransferImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransferImpl.class);

	@Autowired
	TransferKVTeacherDetailsRepository transferKVTeacherDetailsRepository;

	@Autowired
	NativeRepository nativeRepository;

	@Autowired
	private LoginNativeRepository loginNativeRepository;

	@Autowired
	TransferKVTeacherDetailsHistoryRepository transferKVTeacherDetailsHistoryRepository;

	@Autowired
	TransferHistoryRepository transferHistoryRepository;

	@Autowired
	TeacherProfileRepository teacherProfileRepository;

//	@Autowired
//	TeacherPromotionRepository teacherPromotionRepository;

	@Autowired
	TeacherExperienceRepository teacherExperienceRepository;

	@Autowired
	TeacherTransferedDetailsRepository teacherTransferedDetailsRepository;

	@Value("${userBucket.path}")
	private String UPLOADED_FOLDER;

	@Value("${userBucket.url}")
	private String UPLOADED_URL;

	@Autowired
	TeacherKVTransferGroundRepository teacherKVTransferGroundRepository;

	@Autowired
	TeacherTransferDeclarationRepository teacherTransferDeclarationRepository;

	final ObjectMapper mapper = new ObjectMapper();

	public TransferKVTeacherDetails saveTeacherTransfer(TransferKVTeacherDetails data) throws Exception {

		// This is Wrong
		System.out.println("Appointed for subject--->" + data.getWorkExperienceAppointedForSubject());

		return transferKVTeacherDetailsRepository.save(data);
	}

	public TransferKVTeacherDetails getTeacherTransferByTeacherId(Integer data) throws Exception {
		return transferKVTeacherDetailsRepository.findAllByTeacherId(data);
	}

	public TransferKVTeacherDetails getInitiateTeacherTransfer(Integer teacherId) throws Exception {
		return transferKVTeacherDetailsRepository.findAllByTeacherId(teacherId);
	}

	public TransferKVTeacherDetails reInitiateTeacherTransfer(Integer teacherId) throws Exception {
//		TransferKVTeacherDetailsHistory transObj=transferKVTeacherDetailsRepository.findAllByTeacherId(String.valueOf(teacherId));

		QueryResult qrObj = nativeRepository.executeQueries(
				"insert into transfer.transfer_kvteacher_detail_history select * from transfer.transfer_kvteacher_detail where teacher_id='"
						+ teacherId + "'");
		transferKVTeacherDetailsRepository.deleteByTeacherId(String.valueOf(teacherId));
		transferHistoryRepository.deleteByTeacherId(teacherId);
//		transferKVTeacherDetailsRepository.deleteAllByTeacherId(teacherId);	
//		return initiateTeacherTransfer(teacherId);
		return null;
	}

	public TransferKVTeacherDetails initiateTeacherTransfer(ArrayList<TransferHistory> data) throws Exception {
		DateTimeFormatter formatter1 = DateTimeFormat.forPattern("dd/MM/yyyy");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			TransferKVTeacherDetails tsDetails = transferKVTeacherDetailsRepository
					.findAllByTeacherId(Integer.parseInt(String.valueOf((data.get(0).getTeacherId()))));
			if (tsDetails != null) {
				return tsDetails;
			}
		} catch (Exception ex) {
			LOGGER.warn("message", ex);
		}

		try {
			try {
				teacherKVTransferGroundRepository.deleteByTeacherId(data.get(0).getTeacherId());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			for (int i = 0; i < data.size(); i++) {
				List groundTransfer = data.get(i).getGroundForTransfer();
				try {
					if (groundTransfer != null) {
						for (int j = 0; j < groundTransfer.size(); j++) {
							TeacherKVTransferGround tObj = new TeacherKVTransferGround();
							tObj.setTeacherId(data.get(i).getTeacherId());
							tObj.setTransferGroundId(Integer.parseInt(String.valueOf(groundTransfer.get(j))));
							tObj.setWorkExperienceId(data.get(i).getWorkExperienceId());

							System.out.println("for save ground---->" + tObj.getTeacherId());

							teacherKVTransferGroundRepository.save(tObj);
						}
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}

			transferHistoryRepository.saveAll(data);
		} catch (Exception ex) {
			LOGGER.warn("message", ex);
		}

		// System.out.println("Get Index--->" + data.size());

		Integer teacherId = data.get(0).getTeacherId();

		TransferKVTeacherDetails transObj = null;
		// System.out.println("teacherId--->" + teacherId);

		transObj = transferKVTeacherDetailsRepository.findAllByTeacherId(teacherId);
		// System.out.println("transObj---->" + transObj);
		if (transObj != null) {
			// System.out.println("in if");

			return transObj;
		}

		String SQL_TEACHER = "select teacher_id	,teaching_nonteaching,marital_status, spouse_status ,spouse_emp_code,spouse_name,spouse_post,spouse_station_name,spouse_station_code,  "
				+ "teacher_name	, " + "teacher_gender	," + "teacher_dob	," + "teacher_employee_code	,"
				+ "teacher_mobile	," + "teacher_email	," + "teacher_permanent_address	,"
				+ "teacher_parmanent_state	," + "teacher_permanent_district	," + "teacher_permanent_pin	,"
				+ "teacher_correspondence_address	," + "teacher_correspondence_state	,"
				+ "teacher_correspondence_district	," + "teacher_correspondence_pin	," + "teacher_disability_yn	,"
				+ "work_experience_position_type_present_kv	," + "work_experience_work_start_date_present_kv	,"
				+ "work_experience_id_present_kv	," + "work_experience_position_type_present_station_start_date	,"
				+ "work_experience_appointed_for_subject	,\r\n" + "last_promotion_id	,\r\n"
				+ "last_promotion_position_type	,\r\n" + "last_promotion_position_date	,\r\n"
				+ "current_udise_sch_code	,\r\n" + "ksm.station_code as present_station_code ,\r\n"
				+ "ksm.station_type as present_station_type ,\r\n" + "ksm.station_name as present_station_name , \r\n"
				+ "ksm.kv_code as current_kv_code ,\r\n" + "ksm.kv_name as current_school_name\r\n"
				+ "from teacher_profile tp , kv.kv_school_master ksm \r\n"
				+ "where tp.current_udise_sch_code = ksm.udise_sch_code " + "and  teacher_id = '" + teacherId + "' ";

		System.out.println("SQL_TEACHER INITIATE---->" + SQL_TEACHER);

		StaticReportBean sObj = new StaticReportBean();

		QueryResult qrObj = nativeRepository.executeQueries(SQL_TEACHER);
		sObj.setColumnName(qrObj.getColumnName());
		sObj.setRowValue(qrObj.getRowValue());
		sObj.setColumnDataType(qrObj.getColumnDataType());
		sObj.setStatus("1");

		TransferKVTeacherDetails model = new TransferKVTeacherDetails();
		model.setCreatedTime(date);
		model.setTeacherId(Integer.parseInt(String.valueOf(qrObj.getRowValue().get(0).get("teacher_id"))));
		model.setTeacherName(String.valueOf(qrObj.getRowValue().get(0).get("teacher_name")));
		model.setTeacherGender(String.valueOf(qrObj.getRowValue().get(0).get("teacher_gender")));
		model.setTeacherDob(String.valueOf(qrObj.getRowValue().get(0).get("teacher_dob")));
		model.setTeacherEmployeeCode(String.valueOf(qrObj.getRowValue().get(0).get("teacher_employee_code")));
		model.setTeacherMobile(String.valueOf(qrObj.getRowValue().get(0).get("teacher_mobile")));
		model.setTeacherEmail(String.valueOf(qrObj.getRowValue().get(0).get("teacher_email")));
		model.setTeacherPermanentAddress(String.valueOf(qrObj.getRowValue().get(0).get("teacher_permanent_address")));
		model.setTeacherParmanentState(String.valueOf(qrObj.getRowValue().get(0).get("teacher_parmanent_state")));
		model.setTeacherPermanentDistrict(String.valueOf(qrObj.getRowValue().get(0).get("teacher_permanent_district")));
		model.setTeacherPermanentPin(String.valueOf(qrObj.getRowValue().get(0).get("teacher_permanent_pin")));
		model.setTeacherCorrespondenceAddress(
				String.valueOf(qrObj.getRowValue().get(0).get("teacher_correspondence_address")));
		model.setTeacherCorrespondenceState(
				String.valueOf(qrObj.getRowValue().get(0).get("teacher_correspondence_state")));
		model.setTeacherCorrespondenceDistrict(
				String.valueOf(qrObj.getRowValue().get(0).get("teacher_correspondence_district")));
		model.setTeacherCorrespondencePin(String.valueOf(qrObj.getRowValue().get(0).get("teacher_correspondence_pin")));

		String workexperiencepositiontypepresentstationstartdate = String
				.valueOf(qrObj.getRowValue().get(0).get("work_experience_position_type_present_station_start_date"));

		// System.out.println("model--->" + model.getTeacherId());
//		 System.out.println("workexperiencepositiontypepresentstationstartdate----->"
//				+ workexperiencepositiontypepresentstationstartdate);

		model.setTeacherDisabilityYn(String.valueOf(qrObj.getRowValue().get(0).get("teacher_disability_yn")));
		model.setWorkExperiencePositionTypePresentKv(
				String.valueOf(qrObj.getRowValue().get(0).get("work_experience_position_type_present_kv")));
		model.setWorkExperienceWorkStartDatePresentKv(
				String.valueOf(qrObj.getRowValue().get(0).get("work_experience_work_start_date_present_kv")));
		model.setWorkExperienceIdPresentKv(
				String.valueOf(qrObj.getRowValue().get(0).get("work_experience_id_present_kv")));
		model.setWorkExperiencePositionTypePresentStationStartDate(String
				.valueOf(qrObj.getRowValue().get(0).get("work_experience_position_type_present_station_start_date")));
		model.setWorkExperienceAppointedForSubject(
				String.valueOf(qrObj.getRowValue().get(0).get("work_experience_appointed_for_subject")));
		model.setLastPromotionId(String.valueOf(qrObj.getRowValue().get(0).get("last_promotion_id")));
		model.setLastPromotionPositionType(
				String.valueOf(qrObj.getRowValue().get(0).get("last_promotion_position_type")));
		model.setLastPromotionPositionDate(
				String.valueOf(qrObj.getRowValue().get(0).get("last_promotion_position_date")));
		model.setCurrentUdiseSchCode(String.valueOf(qrObj.getRowValue().get(0).get("current_udise_sch_code")));
		model.setPresentStationCode(String.valueOf(qrObj.getRowValue().get(0).get("present_station_code")));
		model.setPresentStationName(String.valueOf(qrObj.getRowValue().get(0).get("present_station_name")));
		model.setPresentStationType(String.valueOf(qrObj.getRowValue().get(0).get("present_station_type")));
		model.setCurrentKvCode(String.valueOf(qrObj.getRowValue().get(0).get("current_kv_code")));
		model.setCurrentSchoolName(String.valueOf(qrObj.getRowValue().get(0).get("current_school_name")));
		model.setTransferApplicationNumber(String.valueOf(qrObj.getRowValue().get(0).get("teacher_id"))
				+ Calendar.getInstance().get(Calendar.YEAR));

		if (String.valueOf(qrObj.getRowValue().get(0).get("spouse_status")) == ""
				|| String.valueOf(qrObj.getRowValue().get(0).get("spouse_status")) == null) {
			if (qrObj.getRowValue().get(0).get("teacher_gender") != null
					&& qrObj.getRowValue().get(0).get("marital_status") != null) {
				if (String.valueOf(qrObj.getRowValue().get(0).get("teacher_gender")).equalsIgnoreCase("2")
						&& String.valueOf(qrObj.getRowValue().get(0).get("marital_status")).equalsIgnoreCase("4")) {
					model.setSpouseStatus("4");
				}
			}
		} else if (String.valueOf(qrObj.getRowValue().get(0).get("teacher_gender")).equalsIgnoreCase("1")
				&& String.valueOf(qrObj.getRowValue().get(0).get("marital_status")).equalsIgnoreCase("4")) {
			model.setSpouseStatus("5");
		} else {
			model.setSpouseStatus(String.valueOf(qrObj.getRowValue().get(0).get("spouse_status")));
		}

		model.setSpouseEmpCode(String.valueOf(qrObj.getRowValue().get(0).get("spouse_emp_code")));
		model.setSpouseName(String.valueOf(qrObj.getRowValue().get(0).get("spouse_name")));
		model.setSpousePost(String.valueOf(qrObj.getRowValue().get(0).get("spouse_post")));
		model.setSpouseStationName(String.valueOf(qrObj.getRowValue().get(0).get("spouse_station_name")));
		model.setSpouseStationCode(String.valueOf(qrObj.getRowValue().get(0).get("spouse_station_code")));
		model.setTransferStatus("TRI");
		model.setTeachingNonTeachingStaff(String.valueOf(qrObj.getRowValue().get(0).get("teaching_nonteaching")));

		try {
			System.out.println(qrObj.getRowValue().get(0).get("last_promotion_position_type"));
//			updateTransfer(teacherId);
		} catch (Exception ex) {
			LOGGER.warn("message", ex);
		}

//		HardStationDetailModel modelhard = DisplacementCountHardNew(String.valueOf(teacherId));
//
//		model.setHardStationCode(modelhard.getHardStationCode());
//		model.setHardStationName(modelhard.getHardStationName());
//		model.setHardStationWorkStartDate(modelhard.getHardStationStartDate());
//		model.setHardStationWorkEndDate(modelhard.getHardStationEndDate());

		DisplacementCountAward modelaward = DisplaceCount9Awards(String.valueOf(teacherId));

		// System.out.println("modelaward.getPresidentAward()--->"+modelaward.getPresidentAward());

		model.setPresidentAward(modelaward.getPresidentAward());
		model.setNationalAward(modelaward.getNationalKVS());
		model.setRegionalAward(modelaward.getRegionalKVS());

		// System.out.println("Regional awards--->"+modelaward.getRegionalKVS());

		DateTime Configuredt = formatter1.parseDateTime("30/06/2022");
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");

//			DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");

		// Calculate Displacement Count Question Number 1-
		DateTime stationPositionDate = formatter.parseDateTime(workexperiencepositiontypepresentstationstartdate);
		Years yearinPresentPostatCurrentStation = Years.yearsBetween(Configuredt, stationPositionDate);
		// Initialize with Point Zero
		String q1_d_pt = "0";
		// q1_d_pt = String.valueOf( yearinPresentPostatCurrentStation.getYears()*2 );

		int days = Days.daysBetween(stationPositionDate, Configuredt).getDays();
		model.setNumberOfWorkingDays(String.valueOf(days));

		model.setQ1DYn("1"); // Not Required
		model.setQ1DPt(String.valueOf((days / 365) * 2)); // + 2 for each year

		// Calculate Displacement Count Question Number - 2
		// Calculation will be done from the Transfer Detail Table only. APAR Grades

		// Calculate Displacement Count Question Number - 3

		// Age is above 40 and once in a hard station
		DateTime DateOfBirth = formatter.parseDateTime(String.valueOf(qrObj.getRowValue().get(0).get("teacher_dob")));
		Years teacherAge = Years.yearsBetween(DateOfBirth, Configuredt);
		// System.out.println("teacherAge---->"+teacherAge.getYears());
//		if (teacherAge.getYears() < 40) {
//			// System.out.println("hard--->"+modelhard.getHardStationYN());
//			if (modelhard.getHardStationYN().equals("1")) {
//				model.setQ3DYn("1");
//				model.setQ3DPt("0");
//			} else {
//				model.setQ3DYn("0");
//			}
//		} else {
//			model.setQ3DYn("0");
//		}
		model.setSpouseKvsYnd("0");
		model.setSpouseStatusTransfer(model.getSpouseStatus());
		model.setSpouseStatusDisplacement(model.getSpouseStatus());
		if (model.getSpouseStatus().equalsIgnoreCase("1")) {
			model.setSpouseKvsYn("1");
			model.setQ5DPt("-50");
			model.setSpouseKvsYnd("1");

		} else if (model.getSpouseStatus().equalsIgnoreCase("2")) {
			model.setSpouseCentralGvotYn("2");
			model.setQ5DPt("-40");
			model.setSpouseKvsYnd("1");
		} else if (model.getSpouseStatus().equalsIgnoreCase("3")) {
			model.setSpouseStateGvotYn("3");
			model.setQ5DPt("-30");
			model.setSpouseKvsYnd("1");
		} else if (model.getSpouseStatus().equalsIgnoreCase("4")) {
			model.setUnmarriedWomanYn("4");
			model.setQ5DPt("-20");
			model.setQ9TPt("20");
		} else if (model.getSpouseStatus().equalsIgnoreCase("5") && model.teacherGender.equalsIgnoreCase("2")) {
			model.setUnmarriedWomanYn("4");
			model.setSpouseStatusTransfer("4");
			model.setSpouseStatusDisplacement("4");
			model.setSpouseStatus("4");
			model.setQ5DPt("-20");
			model.setQ9TPt("20");
		} else {
			model.setSpouseNa("5");
			model.setQ5DPt("0");
		}

		if (model.getQ5DPt() != "-20") {
			model.setQ4TPt(String.valueOf(Integer.parseInt(model.getQ5DPt()) * -1));
		} else {
			model.setQ4TPt("0");
		}

		// Calculate Displacement Count Question Number - 4
		// Calculation will be done from the Transfer Detail Table only. Single Child ,
		// Widower etc

		// Calculate Displacement Count Question Number - 5 to 8 .
		// Calculation will be done from the Transfer Detail Table only. spouse detail.

		// Calculate Displacement Count Question Number - 9

		if (model.getTeacherDisabilityYn().equals("1")) {
			model.setQ9DYn("1");
			model.setQ9DPt("-60");
			model.setQ8TPt(String.valueOf(Integer.parseInt(model.getQ9DPt()) * -1));

		} else {
			model.setQ9DYn("0");
			model.setQ9DPt("0");
			model.setQ8TPt("0");
		}

		// Calculate Displacement Count Question Number - 10
		// Calculation will be done from the Transfer Detail Table only. Association
		// Member.

		// Calculate Displacement Count Question Number - 11
		int awardval = 0;
		if (model.getPresidentAward().equalsIgnoreCase("1"))
			awardval = awardval - 6;
		if (model.getNationalAward().equalsIgnoreCase("1"))
			awardval = awardval - 4;
		if (model.getRegionalAward().equalsIgnoreCase("1"))
			awardval = awardval - 2;
		if (awardval < -6)
			awardval = -6;

		// System.out.println("awardval---->"+awardval);

		model.setQ11DYn("1");
		model.setQ11DPt(String.valueOf(awardval));

//		// System.out.println("Award Value---->"+model.getQ3TPt());

		// Calculate Displacement Count Question Number - 12
		// Calculation will be done from the Transfer Detail Table only. Child at Class
		// 10-12

		// Calculate Displacement Count Question Number - 13
		// Calculation will be done from the Transfer Detail Table only. Care Giver

		// ****** Transfer Count Calculations**************** \\

		// Transfer Count Question 1 Current Station Stay.
		model.setQ10TYyn("1");
		model.setQ1TPt(q1_d_pt);
		model.setAbsenceDaysTwo(hardStationDisplacementB(model.getTeacherId()));

		// Transfer Count Question 2 APAR Value calculation will done from Transfer
		// Detail

		// Transfer Count Question 3 Award value.

		model.setQ3TYyn("1");
		model.setQ3TPt(String.valueOf(Integer.parseInt(String.valueOf(awardval)) * -1));
//		model.setQ3TPt(String.valueOf(awardval));

		// Transfer Count Question 4 to 6 calculation will done from Transfer Detail

		// Transfer count Question 7 Was in Hard Station
		HardStationDetailModel tch = TransferCountHard(String.valueOf(teacherId));
		if (tch.getHardStationYN().equals("1")) {
			model.setQ7TYyn("1");
			model.setQ7TPt("55");
		} else {
			model.setQ7TYyn("0");
			model.setQ7TPt("0");
		}

		// System.out.println("spouse status--->"+model.getSpouseStation());

		TransferKVTeacherDetails transTeacherObj = transferKVTeacherDetailsRepository.save(model);

		//// System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::");
		// System.out.println(transTeacherObj.getPersonalStatusLtr());
		// System.out.println(transTeacherObj.getPersonalStatusMdg());
		// System.out.println(transTeacherObj.getIsLastTransferGroundTeacherDisabilityYn());

		System.out.println("Work Experience appointed for subject--->" + model.getWorkExperienceAppointedForSubject());

		TransferKVTeacherDetails finalTeacherObj = transferGround(transTeacherObj);
		try {
			if (finalTeacherObj.getIsLastTransferGroundTeacherDisabilityYn().equalsIgnoreCase("1")) {
				finalTeacherObj.setQ8TPt("0");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return transferGround(finalTeacherObj);
	}

//	  public static modelTransferGround transferGround(String TeacherID) {
	public TransferKVTeacherDetails transferGround(TransferKVTeacherDetails model) {

		String QUERY = "select " + "count(*) filter (where transfer_ground_id =2) as personalStatusLtr,"
				+ "count(*) filter (where transfer_ground_id =4) as personalStatusDfp,"
				+ "count(*) filter (where transfer_ground_id =3) as personalStatusMdg,"
				+ "count(*) filter (where transfer_ground_id =14) as personalStatusWid,"
				+ "count(*) filter (where transfer_ground_id =13) as personalStatusSp,"
				+ "count(*) filter (where transfer_ground_id =5) as isLastTransferGroundTeacherDisabilityYn "
				+ "from public.teacher_transfer_ground ttg where ttg.teacher_id = '" + model.getTeacherId() + "'";

		try {

			QueryResult qrObj = nativeRepository.executeQueries(QUERY);

//		 // // System.out.println("2"+QUERY);
//		  Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//		        Statement stmt = conn.createStatement();
//		       
//		        ResultSet rs = stmt.executeQuery(QUERY);
//		       
//		     int i = 0;
			// Extract data from result set
//		        while (rs.next()) {
			// System.out.println("3");
			// Retrieve by column name
//		        modelTransferGround modelTransferGroundDTO = new modelTransferGround();

			model.setIsLastTransferGroundTeacherDisabilityYn(
					String.valueOf(qrObj.getRowValue().get(0).get("isLastTransferGroundTeacherDisabilityYn")));
			model.setPersonalStatusDfp(String.valueOf(qrObj.getRowValue().get(0).get("personalStatusDfp")));
			model.setPersonalStatusLtr(String.valueOf(qrObj.getRowValue().get(0).get("personalStatusLtr")));
			model.setPersonalStatusMdg(String.valueOf(qrObj.getRowValue().get(0).get("personalStatusMdg")));
			model.setPersonalStatusSp(String.valueOf(qrObj.getRowValue().get(0).get("personalStatusSp")));
			model.setPersonalStatusWid(String.valueOf(qrObj.getRowValue().get(0).get("personalStatusWid")));

			if (model.getIsLastTransferGroundTeacherDisabilityYn().equalsIgnoreCase("0")) {
				model.setIsLastTransferGroundTeacherDisabilityYn("0");
			} else {
				model.setIsLastTransferGroundTeacherDisabilityYn("1");
			}

			if (model.getPersonalStatusDfp().equalsIgnoreCase("0")) {
				model.setPersonalStatusDfp(null);
			} else {
				model.setPersonalStatusDfp("9");
			}
			if (model.getPersonalStatusLtr().equalsIgnoreCase("0")) {
				model.setPersonalStatusLtr(null);
			} else {
				model.setPersonalStatusLtr("9");
			}

			if (model.getPersonalStatusMdg().equalsIgnoreCase("0")) {
				model.setPersonalStatusMdg(null);
			} else {
				model.setPersonalStatusMdg("9");
			}

			if (model.getPersonalStatusSp().equalsIgnoreCase("0")) {
				model.setPersonalStatusSp(null);
			} else {
				model.setPersonalStatusSp("9");
			}

			if (model.getPersonalStatusWid().equalsIgnoreCase("0")) {
				model.setPersonalStatusWid(null);
			} else {
				model.setPersonalStatusWid("9");
			}

			return model;

//		       }

//		        // System.out.println("4");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}

	public String hardStationDisplacementB(Integer teacherId) {

		List<Stationdurationb> stationDTOAR = new ArrayList<Stationdurationb>();

//		  String QUERY = "select  row_number() over (order by teacher_id) as serial_number, station_code , station_name, station_type , work_start_date , work_end_date from ("
//			   		+ "select "
//			   		+ "k.station_code , k.station_name , k.station_type  , twe.work_start_date , twe.work_end_date  , teacher_id  "
//			   		+ "from public.teacher_work_experience twe, kv.kv_school_master k "
//			   		+ "where twe.udise_sch_code = k.udise_sch_code "
//			   		+ "and twe.teacher_id = "+teacherId+"  order by work_start_date desc "
//			   		+ ") aa " ;

		String QUERY = " select fin.* , DATE_PART('day', work_end_date::timestamp - work_start_date::timestamp) as no_of_days, "
				+ "	ksm.station_type, ksm.ever_been_hard , ksm.very_hard_flag  , ksm.very_hard_start_date , ksm.very_hard_end_date , ksm.hard_start_date , ksm.hard_end_date "
				+ "	from ( " + "		  "
				+ "	select grp, station_code,station_name, min(work_start_date) as work_start_date, max(work_end_date) as work_end_date, count(*) as cnt"
				+ "	from (select t.*,"
				+ "	 (row_number() over (order by teacher_id) - row_number() over (partition by station_code order by teacher_id)"
				+ "	 ) as grp"
				+ "	 from (select k.station_code , k.station_name , k.station_type  , twe.work_start_date , "
				+ "	 case " + "	when work_end_date is null then '06/30/2022'" + "	else work_end_date"
				+ "	end as work_end_date,      " + "	teacher_id  "
				+ "	from public.teacher_work_experience twe, kv.kv_school_master k where twe.udise_sch_code = k.udise_sch_code "
				+ "	and twe.teacher_id = '" + teacherId + "' "
				// + " and twe.position_type = '23'"
				+ "	order by work_start_date desc ) t " + "	order by work_end_date desc ) k"
				+ "	group by grp, station_code,station_name" + " order by work_end_date desc "
				+ "	) fin , kv.kv_station_master ksm" + "	where fin.station_code = ksm.statin_code"
				+ " order by work_end_date desc  ";

		System.out.println("QUERY--->" + QUERY);

		QueryResult qrObj = nativeRepository.executeQueries(QUERY);

//	    	  int i = 0;
		// Extract data from result set
		for (int i = 0; i < qrObj.getRowValue().size(); i++) {
			// Retrieve by column name
			Stationdurationb StationDetail = new Stationdurationb();

			StationDetail.setGrp(String.valueOf(qrObj.getRowValue().get(i).get("grp")));
			StationDetail.setStation_code(String.valueOf(qrObj.getRowValue().get(i).get("station_code")));
			StationDetail.setStation_name(String.valueOf(qrObj.getRowValue().get(i).get("station_name")));
			StationDetail.setWork_start_date(String.valueOf(qrObj.getRowValue().get(i).get("work_start_date")));
			StationDetail.setWork_end_date(String.valueOf(qrObj.getRowValue().get(i).get("work_end_date")));
			StationDetail.setNo_of_days(String.valueOf(qrObj.getRowValue().get(i).get("no_of_days")));
			StationDetail.setStation_type(String.valueOf(qrObj.getRowValue().get(i).get("station_type")));
			StationDetail.setEver_been_hard(String.valueOf(qrObj.getRowValue().get(i).get("ever_been_hard")));
			StationDetail.setVery_hard_flag(String.valueOf(qrObj.getRowValue().get(i).get("very_hard_flag")));
			StationDetail
					.setVery_hard_start_date(String.valueOf(qrObj.getRowValue().get(i).get("very_hard_start_date")));
			StationDetail.setVery_hard_end_date(String.valueOf(qrObj.getRowValue().get(i).get("very_hard_end_date")));
			StationDetail.setHard_start_date(String.valueOf(qrObj.getRowValue().get(i).get("hard_start_date")));
			StationDetail.setHard_end_date(String.valueOf(qrObj.getRowValue().get(i).get("hard_end_date")));

			stationDTOAR.add(StationDetail);

		}
		String s = "0";
		try {
			s = CheckNumberOfDaysB(stationDTOAR, String.valueOf(teacherId));
			// s = CheckNumberOfDaysB(stationDTOAR);
			// System.out.println("B Valiu of Displacement Count : "+s.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	public static String CheckNumberOfDaysB(List<Stationdurationb> stationDTOAR, String TeacherID) {

		// String NoOfDaysB = "0";
		int noOfDays = 0;
		int noOfDaysToReturn = 0;
		try {
			// System.out.println(stationDTOAR.size());

			int noOfRecords = stationDTOAR.size();

			// Number of Record Must Be Greater Than 2
			if (noOfRecords > 2) {
				// X(CurrentStationData)---A(PreviousStationData)---X(PenaltyStationData)----B(LastStationData)

				Stationdurationb CurrentStationData = stationDTOAR.get(0);
				Stationdurationb PreviousStationData = stationDTOAR.get(1);
				Stationdurationb PenaltyStationData = stationDTOAR.get(2);
				// stationdetail LastStationData = stationDTOAR.get(3);

				// System.out.println(" Previous Station Code
				// "+PreviousStationData.getStation_code() );
				if (CurrentStationData.getStation_code().equalsIgnoreCase(PenaltyStationData.getStation_code())) {
					// System.out.println(" Teacher "+TeacherID +" Previous Station Code
					// "+PreviousStationData.getStation_code()+" No Of Days
					// "+PreviousStationData.getNo_of_days());

					int stationType = Integer.parseInt(PreviousStationData.getStation_type());
					// int noOfDays = Integer.parseInt(PreviousStationData.getNo_of_days());
					noOfDays = (int) Float.parseFloat((PreviousStationData.getNo_of_days()));
					int veryhardflag = Integer.parseInt(PreviousStationData.getVery_hard_flag());
					// int NoOfDaysTobeadded=Integer.parseInt(PenaltyStationData.getNo_of_days());
					String VeryHardFlag = PreviousStationData.getVery_hard_flag();
					noOfDaysToReturn = (int) Float.parseFloat((PenaltyStationData.getNo_of_days()));

					if (noOfDays >= 1093) { // The Person did stay 3 years ie tenure in previous Station
						// NoOfDaysB = "0";
						return "0";

					} else if (noOfDays >= 728 && noOfDays < 1093) { // The Person did not stay 3 years ie tenure in
																		// previous Station but stayed 2 years
						// System.out.println(" Teacher "+TeacherID +" Previous Station Code
						// "+PreviousStationData.getStation_code()+" No Of Days
						// "+PreviousStationData.getNo_of_days()+" Very Hard"+VeryHardFlag);
						if (VeryHardFlag.equalsIgnoreCase("1")) { // Station Was Very Hard

							DateTime start = new DateTime(PreviousStationData.getWork_start_date()); // Work Start Date
																										// Very Hard
							DateTime end = new DateTime("01/01/2017");

							DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
							DateTime work_start_date_very_hard = formatter
									.parseDateTime(PreviousStationData.getWork_start_date());
							DateTime veryhardtilldate = formatter.parseDateTime("01/01/2017");
							int days = Days.daysBetween(work_start_date_very_hard, veryhardtilldate).getDays(); // Employee
																												// Joined
																												// the
																												// very
																												// hard
																												// station
																												// tag
																												// removed
							if (days > 0) { // Joined when the station was very hard
								// System.out.println(" Teacher "+TeacherID +" Previous Station Code
								// "+PreviousStationData.getStation_code()+" No Of Days
								// "+PreviousStationData.getNo_of_days());
								// NoOfDaysB = "0";
								return "0";
							}
						}
					} else {
						return String.valueOf(noOfDaysToReturn);
					}
				} else {
					// NoOfDaysB = "0";
					return String.valueOf(noOfDaysToReturn);
				}
			} else {// Number of Record Less Than 3
				// NoOfDaysB = "0";
				return String.valueOf(noOfDaysToReturn);
			}
			// System.out.println(element.getSerial_number());
		} catch (Exception e) {

		}

		return String.valueOf(noOfDaysToReturn);

	}

	/*
	 * Comment By Bibek public HardStationDetailModel DisplacementCountHard(String
	 * TeacherID) {
	 * 
	 * HardStationDetailModel model = new HardStationDetailModel();
	 * 
	 * // String strHardStation =
	 * " select k.station_type , k.station_name , twe.work_start_date , k.station_code , twe.work_end_date  "
	 * // + " from kv.kv_school_master k , teacher_work_experience twe " // +
	 * " where k.udise_sch_code = twe.udise_sch_code  and twe.teacher_id = '" +
	 * TeacherID + "'" // + " and k.station_type in ('3', '1', '2')  limit 1 "; //
	 * VIKARAM CHAUHAN
	 * 
	 * String strHardStation="select * from (\r\n" + "\r\n" +
	 * "select k.station_type , k.station_name , twe.work_start_date , k.station_code , twe.work_end_date ,\r\n"
	 * +
	 * "				 to_date(work_end_date, 'YYYY-MM-DD')  - to_date(work_start_date, 'YYYY-MM-DD') AS employment_interval\r\n"
	 * +
	 * "				from kv.kv_school_master k , teacher_work_experience twe \r\n"
	 * + "				 where k.udise_sch_code = twe.udise_sch_code  \r\n" +
	 * "				 and twe.teacher_id = '"+TeacherID+"'\r\n" +
	 * "				 and k.station_type in ('3', '1', '2')  \r\n" +
	 * "				 and twe.work_end_date is not null\r\n" +
	 * "				 ) aa \r\n" +
	 * "				 order by employment_interval desc limit 1";
	 * 
	 * 
	 * try { QueryResult qrObj = nativeRepository.executeQueries(strHardStation);
	 * 
	 * model.setHardStationYN("0"); if(qrObj.getRowValue().size()>0) {
	 * if(Integer.parseInt(String.valueOf(qrObj.getRowValue().get(0).get(
	 * "employment_interval")))/365 >= 3) { model.setHardStationYN("1"); }
	 * 
	 * model.setHardStationCode(String.valueOf(qrObj.getRowValue().get(0).get(
	 * "station_code")));
	 * model.setHardStationType(String.valueOf(qrObj.getRowValue().get(0).get(
	 * "station_type")));
	 * model.setHardStationName(String.valueOf(qrObj.getRowValue().get(0).get(
	 * "station_name")));
	 * model.setHardStationStartDate(String.valueOf(qrObj.getRowValue().get(0).get(
	 * "work_start_date")));
	 * model.setHardStationEndDate(String.valueOf(qrObj.getRowValue().get(0).get(
	 * "work_end_date"))); } } catch (Exception ex) { LOGGER.warn("message",ex); }
	 * 
	 * return model;
	 * 
	 * }
	 */

	public HardStationDetailModel DisplacementCountHardNew(String TeacherID) {
		HardStationDetailModel model = new HardStationDetailModel();
		String CurrentStationCode;
		String PreviousStationCode = "0";
		Integer employment_interval = 0;

		String QUERY = " select fin.* , DATE_PART('day', work_end_date::timestamp - work_start_date::timestamp) as no_of_days, "
				+ "	ksm.station_type, ksm.ever_been_hard , ksm.very_hard_flag  , ksm.very_hard_start_date , ksm.very_hard_end_date , ksm.hard_start_date , ksm.hard_end_date "
				+ "	from ( " + "		  "
				+ "	select grp, station_code,station_name, min(work_start_date) as work_start_date, max(work_end_date) as work_end_date, count(*) as cnt"
				+ "	from (select t.*,"
				+ "	 (row_number() over (order by teacher_id) - row_number() over (partition by station_code order by teacher_id)"
				+ "	 ) as grp"
				+ "	 from (select k.station_code , k.station_name , k.station_type  , twe.work_start_date , "
				+ "	 case " + "	when work_end_date is null then '06/30/2022'" + "	else work_end_date"
				+ "	end as work_end_date,      " + "	teacher_id  "
				+ "	from public.teacher_work_experience twe, kv.kv_school_master k where twe.udise_sch_code = k.udise_sch_code "
				+ "	and twe.teacher_id = '" + TeacherID + "' "
				// + " and twe.position_type = '23'"
				+ "	order by work_start_date desc ) t " + "	order by work_end_date desc ) k"
				+ "	group by grp, station_code,station_name" + " order by work_end_date desc "
				+ "	) fin , kv.kv_station_master ksm"
				+ " where fin.station_code = ksm.statin_code and ksm.ever_been_hard ='1' "
				+ " order by work_end_date desc  ";

		System.out.println("hard query--->" + QUERY);

		QueryResult qrObj = nativeRepository.executeQueries(QUERY);
		model.setHardStationYN("0");
		List<Stationdurationb> stationDTOAR = new ArrayList<Stationdurationb>();
		for (int i = 0; i < qrObj.getRowValue().size(); i++) {

			String noOfDaysat1C = "0";
			// Retrieve by column name
			// stationdurationb stationDTO = new stationdurationb();
			Stationdurationb StationDetail = new Stationdurationb();
			StationDetail.setGrp(String.valueOf(qrObj.getRowValue().get(i).get("grp")));
			StationDetail.setStation_code(String.valueOf(qrObj.getRowValue().get(i).get("station_code")));
			StationDetail.setStation_name(String.valueOf(qrObj.getRowValue().get(i).get("station_name")));
			StationDetail.setWork_start_date(String.valueOf(qrObj.getRowValue().get(i).get("work_start_date")));
			StationDetail.setWork_end_date(String.valueOf(qrObj.getRowValue().get(i).get("work_end_date")));
			StationDetail.setNo_of_days(String.valueOf(qrObj.getRowValue().get(i).get("no_of_days")));
			StationDetail.setStation_type(String.valueOf(qrObj.getRowValue().get(i).get("station_type")));
			StationDetail.setEver_been_hard(String.valueOf(qrObj.getRowValue().get(i).get("ever_been_hard")));
			StationDetail.setVery_hard_flag(String.valueOf(qrObj.getRowValue().get(i).get("very_hard_flag")));
			StationDetail
					.setVery_hard_start_date(String.valueOf(qrObj.getRowValue().get(i).get("very_hard_start_date")));
			StationDetail.setVery_hard_end_date(String.valueOf(qrObj.getRowValue().get(i).get("very_hard_end_date")));
			StationDetail.setHard_start_date(String.valueOf(qrObj.getRowValue().get(i).get("hard_start_date")));
			StationDetail.setHard_end_date(String.valueOf(qrObj.getRowValue().get(i).get("hard_end_date")));

			// stationDTOAR.add(i, StationDetail);
			stationDTOAR.add(StationDetail);

		}

		try {
			String s = CheckNumberOfDaysB1(stationDTOAR, TeacherID);
			// System.out.println(" "+s.toString());
			int k = Integer.parseInt(s);
			if (k > 0) {
				model.setHardStationYN("1");

//					for(int j=0;j<stationDTOAR.size();j++) {
				model.setHardStationCode(String.valueOf(stationDTOAR.get(0).getStation_code()));
				model.setHardStationType(String.valueOf(stationDTOAR.get(0).getStation_type()));
				model.setHardStationName(String.valueOf(stationDTOAR.get(0).getStation_name()));
				model.setHardStationStartDate(String.valueOf(stationDTOAR.get(0).getWork_start_date()));
				model.setHardStationEndDate(String.valueOf(stationDTOAR.get(0).getWork_end_date()));
//					}
				// System.out.println(QUERY);
				// System.out.println(TeacherID + " of Displacement Count : " + s.toString());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("hard query-->"+model.getHardStationYN());

		return model;
	}

	public static String CheckNumberOfDaysB1(List<Stationdurationb> stationDTOAR, String TeacherID) {

		// String NoOfDaysB = "0";
		int noOfDays = 0;
		try {

			// System.out.println(stationDTOAR.size());

			int noOfRecords = stationDTOAR.size();

			// System.out.println("noOfRecords"+ noOfRecords);

			if (noOfRecords > 0) {

				Stationdurationb CurrentStationData = stationDTOAR.get(0);

				String VeryHardFlag = CurrentStationData.getVery_hard_flag();

				noOfDays = (int) Float.parseFloat(CurrentStationData.getNo_of_days());

				if (VeryHardFlag.equalsIgnoreCase("1")) { // Station Was Very Hard

					DateTime start = new DateTime(CurrentStationData.getWork_start_date()); // Work Start Date Very Hard
					DateTime end = new DateTime("01/01/2017");

					DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
					DateTime work_start_date_very_hard = formatter
							.parseDateTime(CurrentStationData.getWork_start_date());
					DateTime veryhardtilldate = formatter.parseDateTime("01/01/2017");
					int days = Days.daysBetween(work_start_date_very_hard, veryhardtilldate).getDays(); // Employee
																										// Joined the
																										// very hard
																										// station tag
																										// removed
					if (days > 0) { // Joined when the station was very hard
						// System.out.println(" Teacher "+TeacherID +" Previous Station Code
						// "+CurrentStationData.getStation_code()+" No Of Days
						// "+CurrentStationData.getNo_of_days());
						if (noOfDays >= 728) {
							return "1";
						}
					}
				} else if (noOfDays >= 1093) { // # year Tenure
					return "1";
				} else {
					return "0";
				}

			}
		} catch (Exception e) {

		}

		return String.valueOf(noOfDays);

	}

	public HardStationDetailModel TransferCountHard(String TeacherID) {
		HardStationDetailModel model = new HardStationDetailModel();
		/*
		 * String strHardStation=
		 * "select k.station_type , k.station_name , twe.work_start_date , k.station_code , '2022-06-30'::date as work_end_date ,\r\n"
		 * +"  '2022-06-30'::Date - work_start_date::Date  AS employment_interval  " //+
		 * "				 to_date('2022-06-30', 'YYYY-MM-DD')  - to_date(work_start_date, 'YYYY-MM-DD') AS employment_interval\r\n"
		 * +
		 * "				from kv.kv_school_master k , teacher_work_experience twe \r\n"
		 * + "				 where k.udise_sch_code = twe.udise_sch_code  \r\n" +
		 * "				 and twe.teacher_id = '"+TeacherID+"'\r\n" +
		 * "				 and k.station_type in ('3', '1', '2')  \r\n" +
		 * "				 and twe.work_end_date is  null ";
		 */
//		String strHardStation= "select k.station_type , k.station_name , tp.work_experience_position_type_present_station_start_date as work_start_date , k.station_code , '2022-06-30'::date as  work_end_date ,\r\n"
//		+ "				 '2022-06-30'::date -  tp.work_experience_position_type_present_station_start_date::Date  AS employment_interval  				 \r\n"
//		+ "							from kv.kv_school_master k , public.teacher_profile tp \r\n"
//		+ "								 where k.udise_sch_code = tp.current_udise_sch_code \r\n"
//		+ "							 and tp.teacher_id = '"+TeacherID+"'"
//		+ "							 and k.station_type in ('3', '1', '2') ";

		String strHardStation = "select k.station_type , k.station_name , tp.work_experience_position_type_present_station_start_date as work_start_date , k.station_code , '2022-06-30'::date as  work_end_date ,\r\n"
				+ "				 '2022-06-30'::date -  tp.work_experience_position_type_present_station_start_date::Date  AS employment_interval  				 \r\n"
				+ "							from kv.kv_school_master k , public.teacher_profile tp \r\n"
				+ "								 where k.udise_sch_code = tp.current_udise_sch_code \r\n"
				+ "							 and tp.teacher_id = '" + TeacherID + "'"
				+ "							 and (k.station_type in ('3', '1', '2') or (work_experience_position_type_present_station_start_date::date >= k.hard_start_date \r\n"
				+ "							 and  work_experience_position_type_present_station_start_date::date <= k.hard_end_date and k.station_type in ('0') and k.ever_been_hard =1))";

		System.out.println("strHardStation--->" + strHardStation);

		try {
			QueryResult qrObj = nativeRepository.executeQueries(strHardStation);

			model.setHardStationYN("0");
			if (qrObj.getRowValue().size() > 0) {

				System.out.println(String.valueOf(qrObj.getRowValue().get(0).get("employment_interval")));

				if (Integer.parseInt(String.valueOf(qrObj.getRowValue().get(0).get("employment_interval")))
						/ 365 >= 3) {
					model.setHardStationYN("1");
				}
//			else if(Integer.parseInt(String.valueOf(qrObj.getRowValue().get(0).get("ever_been_hard")))==1) {
//				System.out.println("in else condition");
//			}
				model.setHardStationCode(String.valueOf(qrObj.getRowValue().get(0).get("station_code")));
				model.setHardStationType(String.valueOf(qrObj.getRowValue().get(0).get("station_type")));
				model.setHardStationName(String.valueOf(qrObj.getRowValue().get(0).get("station_name")));
				model.setHardStationStartDate(String.valueOf(qrObj.getRowValue().get(0).get("work_start_date")));
				model.setHardStationEndDate(String.valueOf(qrObj.getRowValue().get(0).get("work_end_date")));
			}
		} catch (Exception ex) {
			LOGGER.warn("message", ex);
		}

		return model;

	}

	public DisplacementCountAward DisplaceCount9Awards(String Teacherid) {

		String SQL_ANCESTOR_OF_SELECTED_LEVEL_WITH_USER_VALUES = "select count(*) filter (where award_id = 1) as p ,count(*) filter (where award_id = 2) as n,\r\n"
				+ "				count(*) filter (where award_id = 3) as r from \r\n"
				+ "				(select distinct award_id from 	public.teacher_awards ta where teacher_id =" + Teacherid
				+ ") aa"; // VIKARAM CHAUHAN
		DisplacementCountAward model = new DisplacementCountAward();
		try {

			// System.out.println("SQL_ANCESTOR_OF_SELECTED_LEVEL_WITH_USER_VALUES--->"+SQL_ANCESTOR_OF_SELECTED_LEVEL_WITH_USER_VALUES);

			QueryResult qrObj = nativeRepository.executeQueries(SQL_ANCESTOR_OF_SELECTED_LEVEL_WITH_USER_VALUES);

			model.setPresidentAward(String.valueOf(qrObj.getRowValue().get(0).get("p")));
			model.setNationalKVS(String.valueOf(qrObj.getRowValue().get(0).get("n")));
			model.setRegionalKVS(String.valueOf(qrObj.getRowValue().get(0).get("r")));
		} catch (Exception ex) {
			LOGGER.warn("message", ex);
		}
		return model;
	}

	public void updateTransfer(Integer teacherId) {

//		"insert into"
		String query = "insert into transfer.transfer_work_experience (work_experience_id , teacher_id , udise_sch_code ,\r\n"
				+ "           work_start_date ,work_end_date , udise_school_name ,kv_code ,hard_yn)\r\n" + "\r\n"
				+ "select th.work_experience_id ,th.teacher_id , ksm.udise_sch_code ,\r\n"
				+ "th.work_start_date , th.work_end_date , ksm.kv_name , ksm.kv_code , ksm.station_type as hard_yn\r\n"
				+ "from transfer.transfer_history th , kv.kv_school_master ksm\r\n"
				+ "where th.udise_sch_code = ksm.udise_sch_code\r\n" + "and teacher_id = " + teacherId;

		// System.out.println(" query "+ query.toString());

		QueryResult qrObj = nativeRepository.executeQueries(query);
	}

	public List<TransferHistory> getTransferByTeacherId(Integer teacherId) {
		return transferHistoryRepository.findAllByTeacherId(teacherId);
	}

	public List<TransferHistory> saveTransferHistory(List<TransferHistory> data) throws Exception {
		return transferHistoryRepository.saveAll(data);

	}

//   getTransferBasicProfileByTeacherId This function is called on click of individual teacher transfer
	public Map<String, Object> getTransferBasicProfileByTeacherId(Integer teacherId) throws Exception {
		Map<String, Object> mp = new HashMap<String, Object>();

		TransferKVTeacherDetails tsDetails = transferKVTeacherDetailsRepository.findAllByTeacherId(teacherId);

		System.out.println(" getTransferBasicProfileByTeacherId called");

		if (tsDetails != null) {
			// System.out.println("--------Initiated Transfer----------");
			mp.put("profileDetails", tsDetails);

			List<TransferHistory> transObj = transferHistoryRepository
					.findAllByTeacherIdOrderByWorkStartDateDesc(teacherId);
			List<PostingHistory> ltObj = new LinkedList<PostingHistory>();
			for (int i = 0; i < transObj.size(); i++) {

				PostingHistory tsObj = new PostingHistory();
//				tsObj.setRegionCode(String.valueOf(transObj.get(i).get("region_code")));
//				tsObj.setRegionName(String.valueOf(transObj.get(i).get("region_name")));
				tsObj.setKvCode(String.valueOf(transObj.get(i).getKvCode()));
				tsObj.setUdiseSchoolName(String.valueOf(transObj.get(i).getUdiseSchoolName()));
//				tsObj.setStationCode(String.valueOf(transObj.get(i).get("station_code")));
				tsObj.setStationName(String.valueOf(transObj.get(i).getStationName()));
				tsObj.setStationType(String.valueOf(transObj.get(i).getStationType()));
				tsObj.setTeacherId(String.valueOf(transObj.get(i).getTeacherId()));
				tsObj.setUdiseSchCode(String.valueOf(transObj.get(i).getUdiseSchCode()));

//				System.out.println("Start Date--->"+transObj.get(i).getWorkEndDate());

//				tsObj.setWorkEndDate(String.valueOf(transObj.get(i).getWorkEndDate()));
				tsObj.setWorkExperienceId(String.valueOf(transObj.get(i).getWorkExperienceId()));
//				tsObj.setWorkStartDate(String.valueOf(transObj.get(i).getWorkStartDate()));
				tsObj.setShiftType(String.valueOf(transObj.get(i).getShiftType()));
//				 tsObj.setGroundForTransfer(String.valueOf(qrObj.getRowValue().get(i).get("ground_for_transfer")));
				tsObj.setNatureOfAppointment(String.valueOf(transObj.get(i).getNatureOfAppointment()));
				tsObj.setPositionType(String.valueOf(transObj.get(i).getPositionType()));

				QueryResult qrObj1 = nativeRepository.executeQueries(
						"select transfer_ground_id from transfer.teacher_kvtransfer_ground where work_experienceid="
								+ transObj.get(i).getWorkExperienceId());

				List<ArrayList> lts = new ArrayList<ArrayList>();
				ArrayList groundArray = new ArrayList<Integer>();
				lts.clear();
				groundArray.clear();
				// System.out.println("1size--->"+qrObj1.getRowValue().size());

				if (qrObj1.getRowValue() != null) {

					for (int j = 0; j < qrObj1.getRowValue().size(); j++) {

						// System.out.println(qrObj1.getRowValue().get(j).get("transfer_ground_id"));

						groundArray.add(Integer
								.parseInt(String.valueOf(qrObj1.getRowValue().get(j).get("transfer_ground_id"))));

					}
				}
//				lts.add(groundArray);
				tsObj.setGroundForTransfer(groundArray);
//				transObj.get(i).setGroundForTransfer(groundArray);
//				String myDate = "2014/10/29 18:10:45";
//				Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(myDate);
//				
//				System.out.println(date.getTime());
//				

//				System.out.println("2nd");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date1 = sdf.parse(String.valueOf(transObj.get(i).getWorkStartDate()));
				if (transObj.get(i).getWorkEndDate() != null) {
					Date date2 = sdf.parse(String.valueOf(transObj.get(i).getWorkEndDate()));
					tsObj.setWorkEndDate(String.valueOf(date2.getTime()));
//				tsObj.setWorkEndDate("");
				}
				tsObj.setWorkStartDate(String.valueOf(date1.getTime()));
//				tsObj.setWorkStartDate("");

//				System.out.println("work-->"+tsObj.getWorkStartDate());

//				System.out.println(date1.getTime());
				ltObj.add(tsObj);
			}

			mp.put("teacherExperience", ltObj);
		} else {
			System.out.println("--------Not Initiated Transfer----------");
			mp.put("profileDetails", teacherProfileRepository.findAllByTeacherId(teacherId));

			String query = "select k.region_code , k.region_name , k.station_code , k.station_name , k.kv_code ,k.kv_name ,k.udise_sch_code ,k.station_type , twe.shift_type , \r\n"
					+ "      twe.work_experience_id ,twe.ground_for_transfer, twe.teacher_id ,twe.work_start_date , twe.work_end_date,twe.nature_of_appointment ,twe.position_type   \r\n"
					+ "from public.teacher_work_experience twe , kv.kv_school_master k\r\n" + "where twe.teacher_id ='"
					+ teacherId + "'\r\n" + "and twe.udise_sch_code = k.udise_sch_code order by work_start_date desc";

			// System.out.println(query);

			QueryResult qrObj = nativeRepository.executeQueries(query);
			List<PostingHistory> ltObj = new LinkedList<PostingHistory>();
			for (int i = 0; i < qrObj.getRowValue().size(); i++) {

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				// System.out.println(String.valueOf(qrObj.getRowValue().get(i).get("udise_sch_code")));
				PostingHistory tsObj = new PostingHistory();
				tsObj.setRegionCode(String.valueOf(qrObj.getRowValue().get(i).get("region_code")));
				tsObj.setRegionName(String.valueOf(qrObj.getRowValue().get(i).get("region_name")));
				tsObj.setKvCode(String.valueOf(qrObj.getRowValue().get(i).get("kv_code")));
				tsObj.setUdiseSchoolName(String.valueOf(qrObj.getRowValue().get(i).get("kv_name")));
				tsObj.setStationCode(String.valueOf(qrObj.getRowValue().get(i).get("station_code")));
				tsObj.setStationName(String.valueOf(qrObj.getRowValue().get(i).get("station_name")));
				tsObj.setStationType(String.valueOf(qrObj.getRowValue().get(i).get("station_type")));
				tsObj.setTeacherId(String.valueOf(qrObj.getRowValue().get(i).get("teacher_id")));
				tsObj.setUdiseSchCode(String.valueOf(qrObj.getRowValue().get(i).get("udise_sch_code")));

//				System.out.println("Start Date--->"+qrObj.getRowValue().get(i).get("work_end_date"));
				if (qrObj.getRowValue().get(i).get("work_end_date") != null) {
					Date date1 = sdf.parse(String.valueOf(qrObj.getRowValue().get(i).get("work_end_date")));
					tsObj.setWorkEndDate(String.valueOf(date1.getTime()));
				}
				tsObj.setWorkExperienceId(String.valueOf(qrObj.getRowValue().get(i).get("work_experience_id")));

				Date date2 = sdf.parse(String.valueOf(qrObj.getRowValue().get(i).get("work_start_date")));
				tsObj.setWorkStartDate(String.valueOf(date2.getTime()));

				tsObj.setShiftType(String.valueOf(qrObj.getRowValue().get(i).get("shift_type")));
//				 tsObj.setGroundForTransfer(String.valueOf(qrObj.getRowValue().get(i).get("ground_for_transfer")));
				tsObj.setNatureOfAppointment(String.valueOf(qrObj.getRowValue().get(i).get("nature_of_appointment")));
				tsObj.setPositionType(String.valueOf(qrObj.getRowValue().get(i).get("position_type")));
//				 tsObj.setShiftType("");

				QueryResult qrObj1 = nativeRepository.executeQueries(
						"select transfer_ground_id from public.teacher_transfer_ground where work_experienceid="
								+ tsObj.getWorkExperienceId());
				ArrayList groundArray = new ArrayList<Integer>();
				List<ArrayList> lts = new ArrayList<ArrayList>();
				System.out.println("size--->" + qrObj1.getRowValue().size());
				for (int j = 0; j < qrObj1.getRowValue().size(); j++) {
					lts.clear();
					// System.out.println(qrObj1.getRowValue().get(j).get("transfer_ground_id"));

					groundArray.add(
							Integer.parseInt(String.valueOf(qrObj1.getRowValue().get(j).get("transfer_ground_id"))));

					lts.add(groundArray);

					tsObj.setGroundForTransfer(groundArray);

				}

				ltObj.add(tsObj);
			}
			mp.put("teacherExperience", ltObj);
		}

		return mp;

	}

	public Map<String, Object> getSpouseByEmpCode(String data) throws Exception {
		return teacherProfileRepository.getSpouseByEmpCode(data);
	}

	public List<Map<String, Object>> getDocumentByTeacherId(String data) throws Exception {
		List<Map<String, Object>> lt = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> lt1 = new LinkedList<Map<String, Object>>();

//		String folderPath="E:\\uploadDoc";
		File folder = new File(UPLOADED_FOLDER + File.separator + data);
		if (folder.exists()) {
			for (final File fileEntry : folder.listFiles()) {
				Map<String, Object> mp = new HashMap<String, Object>();
				mp.put("docName", fileEntry.getName());
				String[] filename = fileEntry.getName().split("\\.");
				mp.put("url", UPLOADED_URL + data + "&filename=" + filename[0]);
				lt.add(mp);
			}
		}

		for (int i = 0; i < 9; i++) {
			Map<String, Object> mp = new HashMap<String, Object>();
			lt1.add(mp);
		}
		for (int i = 0; i < lt.size(); i++) {
			// System.out.println(lt.get(i).get("docName"));

			if (String.valueOf(lt.get(i).get("docName")).equalsIgnoreCase("Medical_Certificate.pdf")) {
				lt1.remove(0);
				lt1.add(0, lt.get(i));
			} else if (String.valueOf(lt.get(i).get("docName")).equalsIgnoreCase("Board_examination_Proof.pdf")) {
				lt1.remove(1);
				lt1.add(1, lt.get(i));
			} else if (String.valueOf(lt.get(i).get("docName")).equalsIgnoreCase("Disability_Certificate.pdf")) {
				lt1.remove(2);
				lt1.add(2, lt.get(i));
			} else if (String.valueOf(lt.get(i).get("docName"))
					.equalsIgnoreCase("Differentially_Abled_Certificate.pdf")) {
				lt1.remove(3);
				lt1.add(3, lt.get(i));
			} else if (String.valueOf(lt.get(i).get("docName"))
					.equalsIgnoreCase("Physically_Handicap_Certificate.pdf")) {
				lt1.remove(4);
				lt1.add(4, lt.get(i));
			} else if (String.valueOf(lt.get(i).get("docName")).equalsIgnoreCase("Spouse_Declaration.pdf")) {
				lt1.remove(5);
				lt1.add(5, lt.get(i));
			} else if (String.valueOf(lt.get(i).get("docName")).equalsIgnoreCase("Single_Parent_Declaration.pdf")) {
				lt1.remove(6);
				lt1.add(6, lt.get(i));
			} else if (String.valueOf(lt.get(i).get("docName")).equalsIgnoreCase("DFP_Declaration.pdf")) {
				lt1.remove(7);
				lt1.add(7, lt.get(i));
			} else if (String.valueOf(lt.get(i).get("docName")).equalsIgnoreCase("NJCM_RJCM_Declaration.pdf")) {
				lt1.remove(8);
				lt1.add(8, lt.get(i));
			}
		}

		return lt1;
	}

	public Map<String, Object> deleteDocumentByTeacherIdAndName(DocumentBean db) {
		Map<String, Object> mp = new HashMap<String, Object>();
		try {
			File file = new File(
					UPLOADED_FOLDER + File.separator + db.getTeacherId() + File.separator + db.getDocName());
			if (file.exists()) {
				file.delete();
				mp.put("status", 1);
			} else {
				mp.put("status", 0);
			}
		} catch (Exception ex) {
			mp.put("status", 0);
			LOGGER.warn("message", ex);
		}
		return mp;

	}

	public List<TransferInititateBean> getInitiatedTransferByUdisecode(String udisecode) {
		return mapper.convertValue(transferKVTeacherDetailsRepository.getInitiatedTransferByUdisecode(udisecode),
				new TypeReference<List<TransferInititateBean>>() {
				});
	}

	public Map<String, Object> resetTransfer(String teacherId) {

		Map<String, Object> mp = new HashMap<String, Object>();
		try {
			nativeRepository.updateQueries(
					"delete from transfer.transfer_kvteacher_detail tkd where tkd.teacher_id ='" + teacherId + "'");
			nativeRepository.updateQueries(
					"delete from transfer.transfer_work_experience twe where twe.teacher_id ='" + teacherId + "'");
			nativeRepository
					.updateQueries("delete from transfer.teacher_traning where teacher_id ='" + teacherId + "'");
			nativeRepository.updateQueries(
					"delete from transfer.teacher_kvtransfer_ground where teacher_id ='" + teacherId + "'");

			mp.put("status", 1);

		} catch (Exception ex) {
			mp.put("status", 1);
			ex.printStackTrace();
		}
		return mp;
//		return mapper.convertValue(transferKVTeacherDetailsRepository.getInitiatedTransferByUdisecode(udisecode), new TypeReference<List<TransferInititateBean>>() {});
	}

	public QueryResult getInitiatedTransferByKvCode(String kvcode) {
		QueryResult qrObj = null;
		try {
			qrObj = nativeRepository.executeQueries(
					"select tp.kv_code ,tp.teacher_id,tp.teacher_employee_code,tp.teacher_name,tp.teacher_gender,tp.teacher_dob,tp.teacher_employee_code,tp.teacher_email,tp.teacher_mobile,  \r\n"
							+ "ttd.tc_save_yn,ttd.dc_save_yn\r\n"
							+ "from public.teacher_profile tp left join transfer.teacher_transfer_details ttd  \r\n"
							+ "on tp.teacher_id =ttd.teacher_id\r\n" + " where tp.kv_code = '" + kvcode + "'");
			System.out.println(qrObj.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return qrObj;
	}

	public Map<String, Object> schoolTransferVerify(Integer data) throws Exception {
		Map<String, Object> mp = new HashMap<String, Object>();
		try {
			System.out.println(data);
			nativeRepository.updateQueries(
					"update public.teacher_transfer_profile set transfer_status=2 where teacher_id=" + data);
			mp.put("status", 1);
		} catch (Exception ex) {
			mp.put("status", 0);
			ex.printStackTrace();
		}
		return mp;
	}

	public TeacherTransferDeclaration saveTransferDeclaration(TeacherTransferDeclaration data) {
		return teacherTransferDeclarationRepository.saveAndFlush(data);
	}

	public Map<String, Object> getTransferDeclaration(Integer teacherId) {
		Map<String, Object> mObj = new HashMap<String, Object>();

		TeacherTransferDeclaration obj = teacherTransferDeclarationRepository.findByTeacherId(teacherId);

		try {
			if (obj != null && obj.getId() > 0) {
				mObj.put("status", 1);
				mObj.put("response", obj);
			} else {
				mObj.put("status", 0);
			}
		} catch (Exception ex) {
			mObj.put("status", 0);
			ex.printStackTrace();
		}

		return mObj;
	}

	public QueryResult getTransferRegionByEmployee(Integer teacherId) {
		QueryResult finalrs = null;
		QueryResult rs = null;
		rs = nativeRepository.executeQueries(
				"select tp.special_recruitment_yn, tp.teaching_nonteaching  ,  ttp.personal_status_dfpd , ttp.personal_status_mdgd ,ttp.absence_days_one , tp.teacher_id \r\n"
						+ "from public.teacher_profile tp , public.teacher_transfer_profile ttp \r\n"
						+ "where tp.teacher_id = ttp.teacher_id \r\n" + "and tp.teacher_id = '" + teacherId + "'");
		System.out.println("1---?" + rs.getRowValue().get(0).get("teaching_nonteaching"));

		if (String.valueOf(rs.getRowValue().get(0).get("teaching_nonteaching")).equalsIgnoreCase("1")) {
			System.out.println("2");
			if (String.valueOf(rs.getRowValue().get(0).get("special_recruitment_yn")).equalsIgnoreCase("13")
					&& String.valueOf(rs.getRowValue().get(0).get("personal_status_dfpd")).equalsIgnoreCase("0")
					&& String.valueOf(rs.getRowValue().get(0).get("personal_status_mdgd")).equalsIgnoreCase("0")) {
				System.out.println("3");
				finalrs = nativeRepository.executeQueries(
						"select distinct ksm.region_code ,ksm.region_name from kv.kv_school_master ksm where ksm.is_ner ='1' and ksm.school_type in ('1') ");
			} else if (String.valueOf(rs.getRowValue().get(0).get("special_recruitment_yn")).equalsIgnoreCase("13")
					&& (String.valueOf(rs.getRowValue().get(0).get("personal_status_dfpd")).equalsIgnoreCase("1")
							|| String.valueOf(rs.getRowValue().get(0).get("personal_status_mdgd"))
									.equalsIgnoreCase("1"))) {
				System.out.println("4");
				finalrs = nativeRepository.executeQueries(
						"select distinct ksm.region_code ,ksm.region_name from kv.kv_school_master ksm where  ksm.school_type in ('1') ");
			} else {
				System.out.println("5");
				finalrs = nativeRepository.executeQueries(
						"select distinct ksm.region_code ,ksm.region_name from kv.kv_school_master ksm where  ksm.school_type in ('1') ");
			}
		} else if (String.valueOf(rs.getRowValue().get(0).get("teaching_nonteaching")).equalsIgnoreCase("2")) {
			if (String.valueOf(rs.getRowValue().get(0).get("special_recruitment_yn")).equalsIgnoreCase("13")
					&& String.valueOf(rs.getRowValue().get(0).get("personal_status_dfpd")).equalsIgnoreCase("0")
					&& String.valueOf(rs.getRowValue().get(0).get("personal_status_mdgd")).equalsIgnoreCase("0")) {
				System.out.println("6");
				finalrs = nativeRepository.executeQueries(
						"select distinct ksm.region_code ,ksm.region_name from kv.kv_school_master ksm where ksm.is_ner ='1' and ksm.school_type in ('1','2','3') ");
			} else if (String.valueOf(rs.getRowValue().get(0).get("special_recruitment_yn")).equalsIgnoreCase("13")
					&& (String.valueOf(rs.getRowValue().get(0).get("personal_status_dfpd")).equalsIgnoreCase("1")
							|| String.valueOf(rs.getRowValue().get(0).get("personal_status_mdgd"))
									.equalsIgnoreCase("1"))) {
				System.out.println("7");
				finalrs = nativeRepository.executeQueries(
						"select distinct ksm.region_code ,ksm.region_name from kv.kv_school_master ksm where  ksm.school_type in ('1','2','3') ");
			} else {
				System.out.println("8");
				finalrs = nativeRepository.executeQueries(
						"select distinct ksm.region_code ,ksm.region_name from kv.kv_school_master ksm where  ksm.school_type in ('1','2','3') ");
			}
		}

		return finalrs;

//		QueryResult finalrs=null;
//		QueryResult rs=null;
//	rs	=nativeRepository.executeQueries("select tp.special_recruitment_yn,ksm.school_type, tp.teaching_nonteaching  ,  ttp.personal_status_dfpd , ttp.personal_status_mdgd ,ttp.absence_days_one , tp.teacher_id \r\n"
//				+ "from public.teacher_profile tp , public.teacher_transfer_profile ttp , kv.kv_school_master ksm  \r\n"
//				+ " where tp.teacher_id = ttp.teacher_id \r\n"
//				+" and tp.kv_code = ksm.kv_code  "
//				+ "and tp.teacher_id = '"+teacherId+"'");
//	
//	if(String.valueOf(chckNull(rs.getRowValue().get(0).get("special_recruitment_yn"))).equalsIgnoreCase("13") && String.valueOf(chckNull(rs.getRowValue().get(0).get("personal_status_dfpd"))).equalsIgnoreCase("0") && String.valueOf(chckNull(rs.getRowValue().get(0).get("personal_status_mdgd"))).equalsIgnoreCase("0")) {
//		
//		finalrs=nativeRepository.executeQueries("select distinct ksm.region_code ,ksm.region_name from kv.kv_school_master ksm where ksm.is_ner ='1'");
//	}else {
//		finalrs=nativeRepository.executeQueries("select distinct ksm.region_code ,ksm.region_name from kv.kv_school_master ksm");
//	}
//		
//		return  finalrs;
	}

	public QueryResult getTransferStationByEmployee(Integer teacherId, String regionCode) {

		QueryResult finalrs = null;
		QueryResult rs = null;
		rs = nativeRepository.executeQueries(
				"select tp.special_recruitment_yn,ksm.school_type, tp.teaching_nonteaching  ,  ttp.personal_status_dfpd , ttp.personal_status_mdgd ,ttp.absence_days_one , tp.teacher_id \r\n"
						+ " from public.teacher_profile tp , public.teacher_transfer_profile ttp , kv.kv_school_master ksm  \r\n"
						+ " where tp.teacher_id = ttp.teacher_id \r\n" + " and tp.kv_code = ksm.kv_code  "
						+ "and tp.teacher_id = '" + teacherId + "'");

		if (rs.getRowValue().size() > 0) {
			if (String.valueOf(chckNull(rs.getRowValue().get(0).get("school_type"))).equalsIgnoreCase("3")) { // if RO
																												// EMPLOYEE
				if (String.valueOf(rs.getRowValue().get(0).get("teaching_nonteaching")).equalsIgnoreCase("1")) {
					finalrs = nativeRepository.executeQueries("select distinct station_code  ,station_name  \r\n"
							+ "		from kv.kv_school_master  ksm where ksm.region_code  = '" + regionCode
							+ "'  and school_type ='3' and school_status ='1'"
							+ "		and station_code not in (select ksm2.station_code  from public.teacher_profile tp ,kv.kv_school_master ksm2 \r\n"
							+ "		where ksm2.kv_code = tp.kv_code and  tp.teacher_id= " + teacherId
							+ ")   and station_code not in ('548','544','543','550','480') order by station_name ");
				} else if (String.valueOf(rs.getRowValue().get(0).get("teaching_nonteaching")).equalsIgnoreCase("2")) {
					finalrs = nativeRepository.executeQueries("select distinct station_code  ,station_name  \r\n"
							+ "		from kv.kv_school_master  ksm where ksm.region_code  = '" + regionCode
							+ "'  and ksm.school_type in ('1','2','3') and school_status ='1'"
							+ "		and station_code not in (select ksm2.station_code  from public.teacher_profile tp ,kv.kv_school_master ksm2 \r\n"
							+ "		where ksm2.kv_code = tp.kv_code and  tp.teacher_id= " + teacherId
							+ ")   and station_code not in ('548','544','543','550','480') order by station_name ");
				}
			} else {
				if (String.valueOf(chckNull(rs.getRowValue().get(0).get("special_recruitment_yn")))
						.equalsIgnoreCase("13")
						&& String.valueOf(chckNull(rs.getRowValue().get(0).get("personal_status_dfpd")))
								.equalsIgnoreCase("0")
						&& String.valueOf(chckNull(rs.getRowValue().get(0).get("personal_status_mdgd")))
								.equalsIgnoreCase("0")) { // For NER
					finalrs = nativeRepository.executeQueries("select distinct station_code  ,station_name  \r\n"
							+ "		from kv.kv_school_master  ksm where ksm.region_code  = '" + regionCode
							+ "' and ksm.is_ner='1' and school_status ='1'  \r\n"
							+ "		and station_code not in (select ksm2.station_code  from public.teacher_profile tp ,kv.kv_school_master ksm2 \r\n"
							+ "		where ksm2.kv_code = tp.kv_code and  tp.teacher_id= " + teacherId
							+ ")  and station_code not in ('548','544','543','550','480') order by station_name");
				} else if (String.valueOf(chckNull(rs.getRowValue().get(0).get("personal_status_dfpd")))
						.equalsIgnoreCase("1")
						|| String.valueOf(chckNull(rs.getRowValue().get(0).get("personal_status_mdgd")))
								.equalsIgnoreCase("1")) {
					finalrs = nativeRepository.executeQueries("select distinct station_code  ,station_name  \r\n"
							+ "		from kv.kv_school_master  ksm where ksm.region_code  = '" + regionCode
							+ "'  and school_status ='1'  and station_code not in ('548','544','543','550','480') order by station_name ");

				} else {
					finalrs = nativeRepository.executeQueries("select distinct station_code  ,station_name  \r\n"
							+ "		from kv.kv_school_master  ksm where ksm.region_code  = '" + regionCode
							+ "'  and school_status ='1' "
							+ "		and station_code not in (select ksm2.station_code  from public.teacher_profile tp ,kv.kv_school_master ksm2 \r\n"
							+ "		where ksm2.kv_code = tp.kv_code and  tp.teacher_id= " + teacherId
							+ ")   and station_code not in ('548','544','543','550','480') order by station_name ");
				}
			}
		}

		return finalrs;

	}

	public Object chckNull(Object value) {
		if (value == null) {
			return "";
		} else {
			return value;
		}
	}

	public QueryResult getTransferINByKvCode(String KvCode) {
		QueryResult qrObj = null;
		try {

			String strGetResult = " select zed.teacher_id,zed.transfer_type, zed.emp_code  as teacher_employee_code , zed.emp_name as teacher_name, zed.post_name ,\r\n"
					+ "zed.subject_name , zed.allot_kv_code, zed.kv_name_alloted ,zed.kv_name_present as from_kv_name,zed.present_kv_code as from_kv,emp_transfer_status , apply_transfer_yn ,ground_level ,\r\n"
					+ "tp.kv_code  as from_kvs, ksm.kv_name as from_kv_names , '1' as trans_type, join_date, relieve_date ,join_relieve_flag, zed.is_automated_transfer, zed.is_admin_transfer,zed.transfer_type,zed.transferred_under_cat_id \r\n"
					+ "from public.z_emp_details_3107 zed , public.teacher_profile tp , kv.kv_school_master ksm \r\n"
					+ "where allot_kv_code = '" + KvCode.toString() + "' \r\n"
					+ "and zed.teacher_id =  tp.teacher_id \r\n" + "and tp.kv_code = ksm.kv_code \r\n"
					+ " and (zed.is_joined_allocated_school =true or zed.is_joined_allocated_school is null) \r\n"
					+ "union\r\n"
					+ "select zed.teacher_id,zed.transfer_type, zed.emp_code  as teacher_employee_code , zed.emp_name as teacher_name, zed.post_name ,\r\n"
					+ "zed.subject_name , zed.allot_kv_code, zed.kv_name_alloted ,zed.kv_name_present as from_kv_name,zed.present_kv_code as from_kv,emp_transfer_status , apply_transfer_yn ,ground_level ,\r\n"
					+ "tp.kv_code  as from_kvs, ksm.kv_name as from_kv_names, '2' as trans_type, join_date, relieve_date , join_relieve_flag, zed.is_automated_transfer, zed.is_admin_transfer,zed.transfer_type,zed.transferred_under_cat_id \r\n"
					+ "from public.z_emp_details_3107 zed , public.teacher_profile tp , kv.kv_school_master ksm \r\n"
					+ "where allot_kv_code <> '-1'\r\n" + "and zed.present_kv_code = '" + KvCode.toString() + "'\r\n"
					+ "and zed.teacher_id =  tp.teacher_id \r\n" + "and tp.kv_code = ksm.kv_code"
					+ " and (zed.is_joined_allocated_school =true or zed.is_joined_allocated_school is null) \r\n";
			System.out.println("Query for transfer out--->" + strGetResult);

			qrObj = nativeRepository.executeQueries(strGetResult.toString());

			// System.out.println(qrObj.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return qrObj;
	}

	public Object updateTransferINByKvCode(String teacherId, String doj, String KvCode, String emp_code,
			String transfer_type, Map<String, Object> data) {

		QueryResult qrObj = null;
		Map<String, Object> mp = new HashMap<String, Object>();
		String automatedTransferedSchool = null;
		Date reliveDate = null;
		Integer transferGround = null;
		List<TeacherTransferedDetails> tObj = teacherTransferedDetailsRepository.getByEmpCode(emp_code);

		System.out.println(tObj.size());

		if (tObj.size() == 1) {
			reliveDate = tObj.get(0).getRelieveDate();
			transferGround = tObj.get(0).getTransferredUnderCatId();
//		if(transferGround)
		}

		System.out.println("reliveDate---->" + reliveDate);

		if (tObj.size() > 1) {
			Integer newIndex = null;
			for (int i = 0; i < tObj.size(); i++) {
				if (tObj.get(i).getAllotKvCode().equalsIgnoreCase(String.valueOf(data.get("allot_kv_code")))
						&& (tObj.get(i).getPresentKvCode() == null || tObj.get(i).getPresentKvCode().isEmpty())) {
					if (i == 0) {
						newIndex = 1;
					} else if (i == 1) {
						newIndex = 0;
					}

					mp.put("status", 0);
					mp.put("message", "Please Contact with " + tObj.get(newIndex).getKvNameAlloted() + " ("
							+ tObj.get(newIndex).getAllotKvCode() + ") to complete transfer process");
					return mp;
				}
			}

		}

		System.out.println("is joined allocated school--->" + data.get("is_joined_allocated_school"));

		if (String.valueOf(data.get("is_joined_allocated_school")).equalsIgnoreCase("false")) {
			System.out.println("is_joined_allocated_school--->");
			reliveDate = null;
			Integer updatedIndex;
			if (tObj.size() == 2) {
				for (int i = 0; i < tObj.size(); i++) {
					if (tObj.get(i).getAllotKvCode() != null && tObj.get(i).getAllotKvCode()
							.equalsIgnoreCase(String.valueOf(data.get("allot_kv_code")))) {
						reliveDate = tObj.get(i).getRelieveDate();

						System.out.println("reliveDate---->" + reliveDate);
						System.out.println("tObj.get(i).getRelieveDate()--->" + tObj.get(i).getRelieveDate());

						if (i == 0) {
							updatedIndex = 1;
						} else {
							updatedIndex = 0;
						}
						nativeRepository.updateQueriesString(
								"update public.z_emp_details_3107   set  is_joined_allocated_school=false where  emp_code='"
										+ tObj.get(i).getEmpCode() + "' and allot_kv_code='"
										+ tObj.get(i).getAllotKvCode() + "'");
//        	  nativeRepository.updateQueriesString("update public.z_emp_details_3107   set present_kv_code='"+tObj.get(updatedIndex).getPresentKvCode()+"', region_name_present='"+tObj.get(updatedIndex).getRegionNamePresent()+"' , kv_name_present='"+tObj.get(updatedIndex).getKvNamePresent()+"' , present_kv_master_code='"+tObj.get(updatedIndex).getPresentKvCode()+"', relieve_date='"+tObj.get(i).getRelieveDate() +"' where emp_code='"+tObj.get(i).getEmpCode()+"' and allot_kv_code='"+tObj.get(i).getAllotKvCode()+"'");  

//        	  if(String.valueOf(tObj.get(i).getAllotStnCode()).equalsIgnoreCase(String.valueOf(data.get("present_station_code")))) {
						nativeRepository.updateQueriesString(
								"update public.z_emp_details_3107   set   doj_in_present_stn_irrespective_of_cadre='"
										+ tObj.get(i).getDojInPresentStnIrrespectiveOfCadre() + "', present_kv_code='"
										+ tObj.get(i).getPresentKvCode() + "',  region_code='"
										+ tObj.get(i).getRegionCode() + "', shift='" + tObj.get(i).getShift()
										+ "', station_name_present='" + tObj.get(i).getStationNamePresent()
										+ "' , region_name_present='" + tObj.get(i).getRegionNamePresent()
										+ "' , kv_name_present='" + tObj.get(i).getKvNamePresent()
										+ "' , present_kv_master_code='" + tObj.get(i).getPresentKvCode()
										+ "', relieve_date='" + tObj.get(i).getRelieveDate() + "'  where emp_code='"
										+ tObj.get(updatedIndex).getEmpCode() + "' and allot_kv_code='"
										+ tObj.get(updatedIndex).getAllotKvCode() + "'");
//         	 }

					}

				}
//        updateExtTransfer(Integer.parseInt(String.valueOf(data.get("allot_kv_code"))),emp_code);
				updateTransferHistory(Integer.parseInt(String.valueOf(data.get("allot_kv_code"))), emp_code);
//		teacherTransferedDetailsRepository.deleteByAllotKvCodeAndTeacherId(String.valueOf(data.get("allot_kv_code")), Integer.parseInt(teacherId));	
			}

			mp.put("status", 0);
			mp.put("message", "Employee not Joined");
			return mp;
		} else {

			Integer updatedIndex;
			if (tObj.size() == 2) {
				System.out.println("allocated--->" + data.get("allot_kv_code"));
				for (int i = 0; i < tObj.size(); i++) {
					if (tObj.get(i).getAllotKvCode().equalsIgnoreCase(String.valueOf(data.get("allot_kv_code")))) {

						reliveDate = tObj.get(i).getRelieveDate();
						transferGround = tObj.get(i).getTransferredUnderCatId();
						if (i == 0) {
							updatedIndex = 1;
						} else {
							updatedIndex = 0;
						}

						System.out.println("Ready for update--->");
						System.out.println("i----->" + i);
						System.out.println("updatedIndex----->" + updatedIndex);

						System.out.println("Present kv code--->" + tObj.get(i).getAllotKvCode());
						System.out.println("region code-->" + tObj.get(i).getRegionNameAlloted());
						System.out.println("kv name present--->" + tObj.get(i).getKvNameAlloted());

						System.out.println("Present kv code--->" + tObj.get(updatedIndex).getPresentKvCode());
						System.out.println("region code-->" + tObj.get(updatedIndex).getRegionNamePresent());
						System.out.println("kv name present--->" + tObj.get(updatedIndex).getKvNamePresent());

						if (String.valueOf(tObj.get(i).getAllotStnCode())
								.equalsIgnoreCase(String.valueOf(data.get("present_station_code")))) {
							nativeRepository.updateQueriesString(
									"update public.z_emp_details_3107   set  doj_in_present_stn_irrespective_of_cadre='"
											+ tObj.get(i).getDojInPresentStnIrrespectiveOfCadre()
											+ "', present_kv_code='" + tObj.get(i).getAllotKvCode()
											+ "',  region_code='" + tObj.get(i).getRegionCodeAlloted() + "', shift='"
											+ tObj.get(i).getAllotShift() + "', station_name_present='"
											+ tObj.get(i).getStationNameAlloted() + "' , region_name_present='"
											+ tObj.get(i).getRegionNameAlloted() + "' , kv_name_present='"
											+ tObj.get(i).getKvNameAlloted() + "' , present_kv_master_code='"
											+ tObj.get(i).getAllotKvCode() + "'  where emp_code='"
											+ tObj.get(updatedIndex).getEmpCode() + "' and allot_kv_code='"
											+ tObj.get(updatedIndex).getAllotKvCode() + "'");
						} else {
							nativeRepository.updateQueriesString(
									"update public.z_emp_details_3107   set  doj_in_present_stn_irrespective_of_cadre='"
											+ doj + "', present_kv_code='" + tObj.get(i).getAllotKvCode()
											+ "',  region_code='" + tObj.get(i).getRegionCodeAlloted() + "', shift='"
											+ tObj.get(i).getAllotShift() + "', station_name_present='"
											+ tObj.get(i).getStationNameAlloted() + "' , region_name_present='"
											+ tObj.get(i).getRegionNameAlloted() + "' , kv_name_present='"
											+ tObj.get(i).getKvNameAlloted() + "' , present_kv_master_code='"
											+ tObj.get(i).getAllotKvCode() + "'  where emp_code='"
											+ tObj.get(updatedIndex).getEmpCode() + "' and allot_kv_code='"
											+ tObj.get(updatedIndex).getAllotKvCode() + "'");
						}

//        	  String upQuery="update public.z_emp_details_3107  set  present_kv_code='"+tObj.get(updatedIndex).getAllotKvCode()+"', present_kv_master_code='"+tObj.get(updatedIndex).getPresentKvCode()+"'  where emp_code='"+tObj.get(updatedIndex).getEmpCode()+"' and allot_kv_code='"+tObj.get(updatedIndex).getAllotKvCode()+"'";
//        	  nativeRepository.updateQueriesString(upQuery);  

					}

				}
//        updateTransferHistory(Integer.parseInt(String.valueOf(data.get("allot_kv_code"))),emp_code);
//		teacherTransferedDetailsRepository.deleteByAllotKvCodeAndTeacherId(String.valueOf(data.get("allot_kv_code")), Integer.parseInt(teacherId));

			}

		}

		if (tObj.size() == 1) {
			if (tObj.get(0).getRelieveDate() == null || tObj.get(0).getRelieveDate() == null) {
				mp.put("status", 0);
				mp.put("message", "Please Relieve the Employee From Present School");
				return mp;
			}
		} else if (tObj.size() == 2) {
			for (int i = 0; i < tObj.size(); i++) {
				if (String.valueOf(tObj.get(i).getAllotKvCode())
						.equalsIgnoreCase(String.valueOf(data.get("allot_kv_code")))) {
					if (tObj.get(i).getRelieveDate() == null || tObj.get(i).getRelieveDate() == null) {
						Integer index;
						if (i == 0) {
							index = 1;
						} else {
							index = 0;
						}

						mp.put("status", 0);
						if ((tObj.get(i).getPresentKvCode() != null || tObj.get(i).getKvNamePresent() != null)) {
							mp.put("message", "Please Relieve the Employee or Take Action on Employee From "
									+ tObj.get(i).getKvNamePresent() + "(" + tObj.get(i).getPresentKvCode() + ")");
						}

						return mp;
					}
				}
			}
		}

		if (transfer_type.equalsIgnoreCase("AM")) {
//		List<TeacherTransferedDetails> tObj = teacherTransferedDetailsRepository.findAllByEmpCode(emp_code);
			for (int i = 0; i < tObj.size(); i++) {
				if (tObj.get(i).getTransferType().equalsIgnoreCase("S")
						|| tObj.get(i).getTransferType().equalsIgnoreCase("A")) {
					if ((tObj.get(i).getJoinDate() == null || tObj.get(i).getJoinDate() == null)
							&& String.valueOf(data.get("is_joined_allocated_school")).equalsIgnoreCase("false")) {
						mp.put("status", 0);
						mp.put("message", "Please Contact with " + tObj.get(i).getKvNameAlloted() + " ("
								+ tObj.get(i).getAllotKvCode() + ") to complete transfer process");
						return mp;
					}
				}
			}
		}

		try {

			String insertQueriesStringteacher_work_experience = "insert into public.teacher_work_experience "
					+ "(work_experience_id , teacher_id, udise_sch_code, work_start_date,position_type, appointed_for_subject,udise_school_name,ground_for_transfer, "
					+ "	currently_active_yn,kv_code) "
					+ "select nextval('public.teacher_work_experience_id3_seq'::regclass)+ 1,  zed.teacher_id, zed.allot_kv_code as udise_sch_code,"
					+ "'" + doj + "' as work_start_date,position_type, appointed_for_subject, "
					+ "zed.kv_name_alloted as udise_school_name,zed.transferred_under_cat_id as ground_for_transfer,'2', zed.allot_kv_code as kv_code "
					+ "from public.teacher_work_experience twe , public.z_emp_details_3107 zed "
					+ "where twe.teacher_id ='" + teacherId.toString()
					+ "' and (currently_active_yn ='1' or currently_active_yn is null) "
					+ "and zed.teacher_id = twe.teacher_id  and zed.allot_kv_code='"
					+ String.valueOf(data.get("allot_kv_code")) + "'";

			System.out.println("insertQueriesStringteacher_work_experience.toString()"
					+ insertQueriesStringteacher_work_experience.toString());

			nativeRepository.insertQueriesString(insertQueriesStringteacher_work_experience.toString());

			System.out.println("Transfer ground before update--->" + transferGround);

			String updateQueriesStringteacher_work_experience = " update public.teacher_work_experience set work_end_date = '"
					+ reliveDate + "' , " + "    currently_active_yn ='0', ground_for_transfer='" + transferGround
					+ "' " + " where teacher_id ='" + teacherId.toString()
					+ "'  and (currently_active_yn ='1' or currently_active_yn is null)  ";
			System.out.println(
					"updateQueriesStringteacher_work_experience---->" + updateQueriesStringteacher_work_experience);

			int k = nativeRepository.updateQueriesString(updateQueriesStringteacher_work_experience.toString());

			String strUpdate = " update public.teacher_work_experience  set currently_active_yn ='1' ,  ground_for_transfer = null where teacher_id ='"
					+ teacherId.toString() + "' and currently_active_yn ='2' ";

			int j = nativeRepository.updateQueriesString(strUpdate.toString());

			String strupdateQueriesStringteacher_profile = "update public.teacher_profile tp "
					+ "set work_experience_work_start_date_present_kv = '" + doj + "',"
					+ "    work_experience_id_present_kv =  twe.work_experience_id ,"
					+ "    current_udise_sch_code = zed.allot_kv_code ," + "    verify_flag = 'SI',\r\n"
					+ "    kv_code = zed.allot_kv_code\r\n"
					+ "from public.teacher_work_experience twe , public.z_emp_details_3107 zed \r\n"
					+ "where tp.teacher_id ='" + teacherId.toString() + "' and currently_active_yn ='1'\r\n"
					+ "and zed.teacher_id = twe.teacher_id and twe.teacher_id = tp.teacher_id  and zed.allot_kv_code='"
					+ String.valueOf(data.get("allot_kv_code")) + "'";

			int i = nativeRepository.updateQueriesString(strupdateQueriesStringteacher_profile.toString());

			String updateFlag = "update public.z_emp_details_3107 set join_date =  '" + doj
					+ "' , join_relieve_flag = '1'  where emp_code ='" + emp_code + "'  and allot_kv_code='"
					+ String.valueOf(data.get("allot_kv_code")) + "'";

			int n = nativeRepository.updateQueriesString(updateFlag);

			System.out.println("business unit type code-->" + String.valueOf(data.get("allot_kv_code")));

			String userroleupdate = " update public.role_user  set    business_unit_type_code = '"
					+ String.valueOf(data.get("allot_kv_code")) + "' where user_name ='" + emp_code.toString() + "' ";
			int u = loginNativeRepository.updateQueriesString(userroleupdate);

			try {
				updateTransferHistory(Integer.parseInt(String.valueOf(data.get("allot_kv_code"))), emp_code);
				if (tObj.size() == 2 && (transfer_type.equalsIgnoreCase("S") || transfer_type.equalsIgnoreCase("A"))) {
					if (tObj.size() > 1) {
						String regionCodeAlloted = null;
						String regionNameAlloted = null;
						Integer oldAllotStnCode = null;
						String stationNameAlloted = null;
						String oldAllotKvCode = null;
						String oldPresentKvMasterCode = null;
						String oldAllotedKvName = null;
						Integer allotShift = null;
						Date joinDate = null;

						for (int j1 = 0; j1 < tObj.size(); j1++) {
							if (tObj.get(j1).getTransferType().equalsIgnoreCase("S")
									|| tObj.get(j1).getTransferType().equalsIgnoreCase("A")) {
								oldAllotStnCode = tObj.get(j1).getAllotStnCode();
								stationNameAlloted = tObj.get(j1).getStationNameAlloted();
								regionCodeAlloted = tObj.get(j1).getRegionCodeAlloted();
								regionNameAlloted = tObj.get(j1).getRegionNameAlloted();
								oldAllotKvCode = tObj.get(j1).getAllotKvCode();
								oldAllotedKvName = tObj.get(j1).getKvNameAlloted();
								oldPresentKvMasterCode = String.valueOf(tObj.get(j1).getAllotKvCode());
								allotShift = tObj.get(j1).getAllotShift();
								joinDate = tObj.get(j1).getJoinDate();
							}
						}

						for (int k1 = 0; k1 < tObj.size(); k1++) {
							if (tObj.get(k1).getTransferType().equalsIgnoreCase("AM")) {
								String updateOldSchoolOuttransfer = "update z_emp_details_3107 set present_station_code='"
										+ oldAllotStnCode + "',station_name_present='" + stationNameAlloted
										+ "', region_name_present='" + regionNameAlloted + "', present_kv_code='"
										+ oldAllotKvCode + "', kv_name_present='" + oldAllotedKvName
										+ "', present_kv_master_code='" + oldAllotKvCode + "',shift=" + allotShift
										+ ",doj_in_present_stn_irrespective_of_cadre=" + joinDate
										+ " where allot_kv_code='" + tObj.get(k1).getAllotKvCode() + "' "
										+ " and teacher_id=" + tObj.get(k1).getTeacherId() + " and id="
										+ tObj.get(k1).getId();
//					nativeRepository.updateQueriesString(updateOldSchoolOuttransfer);
							}
						}
					}
//    updateExtTransfer(Integer.parseInt(String.valueOf(data.get("allot_kv_code"))),emp_code);
//	teacherTransferedDetailsRepository.deleteByAllotKvCodeAndTeacherId(String.valueOf(data.get("allot_kv_code")), Integer.parseInt(teacherId));	
				} else {
//		updateExtTransfer(Integer.parseInt(String.valueOf(data.get("allot_kv_code"))),emp_code);
//		teacherTransferedDetailsRepository.deleteByAllotKvCodeAndTeacherId(String.valueOf(data.get("allot_kv_code")), Integer.parseInt(teacherId));
				}
				mp.put("status", 1);
				mp.put("message", "Employee Joined Successfully");
			} catch (Exception ex) {
				mp.put("status", 1);
				mp.put("message", "Employee not Joined");
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mp;
	}

	public Object updateTransferOutByKvCode(String doj, String emp_code, String allocatedKvCode) {
		QueryResult qrObj = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			QueryResult maxReleving = nativeRepository.executeQueries(
					"select max(work_start_date) as work_start_date from teacher_work_experience twe where twe.teacher_id in (select teacher_id from teacher_profile tp where tp.teacher_employee_code='"
							+ emp_code + "')");

			Date lastJoiningDate = dateFormat
					.parse(String.valueOf((maxReleving.getRowValue().get(0).get("work_start_date"))));
			Date dateOfJoining = dateFormat.parse(doj);

			System.out.println("dateOfJoining--->" + dateOfJoining);
			System.out.println("lastJoiningDate--->" + lastJoiningDate);
			if (dateOfJoining.before(lastJoiningDate)) {
				System.out.println("Condition fail--->" + dateOfJoining);
				Map<String, Object> hs = new HashMap<String, Object>();
				hs.put("status", 0);
				hs.put("message", "Invalid date of joining");
				return hs;
			}

			List<TeacherTransferedDetails> tObj = teacherTransferedDetailsRepository.findByEmpCode(emp_code);
			String updateFlag = "update public.z_emp_details_3107 set relieve_date =  '" + doj
					+ "' , join_relieve_flag = '2'  where emp_code ='" + emp_code + "' and allot_kv_code='"
					+ allocatedKvCode + "'";
//		String updateFlag= "update public.z_emp_details_3107 set relieve_date =  '"+doj+"' , join_relieve_flag = '2'  where emp_code ='"+emp_code+"'";
			System.out.println("update--->" + updateFlag);
			int n = nativeRepository.updateQueriesString(updateFlag);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return qrObj;
	}

	public void updateTransferHistory(Integer allot_kv_code, String empCode) {
		String query = "insert into z_emp_details_history (id,teacher_id,emp_code,emp_name,gender,dob,post_id,subject_id,region_code,present_station_code,present_kv_code,present_kv_master_code\r\n"
				+ ",shift,doj_in_present_stn_irrespective_of_cadre,is_ner_recruited,isjcm_rjcm,is_pwd,is_hard_served,is_currently_in_hard,station_code_1,station_code_2,station_code_3,station_code_4,station_code_5,tot_tc\r\n"
				+ ",tot_tc2,tot_dc,transfer_applied_for,dc_applied_for,is_trasnfer_applied,allot_stn_code,allot_kv_code,allot_shift,transferred_under_cat,emp_transfer_status,is_displaced\r\n"
				+ ",elgible_yn,is_ner,apply_transfer_yn,ground_level,print_order,kv_name_present,kv_name_alloted,station_name1,station_name2,station_name3,station_name4,station_name5\r\n"
				+ ",region_name_present,region_code_alloted,region_name_alloted,station_name_present,station_name_alloted,post_name,subject_name,join_date,relieve_date,join_relieve_flag,transfer_type,modified_date_time,transfer_year)\r\n"
				+ "select id,teacher_id,emp_code,emp_name,gender,dob,post_id,subject_id,region_code,present_station_code,present_kv_code,present_kv_master_code\r\n"
				+ ",shift,doj_in_present_stn_irrespective_of_cadre,is_ner_recruited,isjcm_rjcm,is_pwd,is_hard_served,is_currently_in_hard,station_code_1,station_code_2,station_code_3,station_code_4,station_code_5,tot_tc\r\n"
				+ ",tot_tc2,tot_dc,transfer_applied_for,dc_applied_for,is_trasnfer_applied,allot_stn_code,allot_kv_code,allot_shift,transferred_under_cat,emp_transfer_status,is_displaced\r\n"
				+ ",elgible_yn,is_ner,apply_transfer_yn,ground_level,print_order,kv_name_present,kv_name_alloted,station_name1,station_name2,station_name3,station_name4,station_name5\r\n"
				+ ",region_name_present,region_code_alloted,region_name_alloted,station_name_present,station_name_alloted,post_name,subject_name,join_date,relieve_date,join_relieve_flag,transfer_type,modified_date_time,transfer_year  from  z_emp_details_3107 ze\r\n"
				+ "where ze.emp_code='" + empCode + "' and  ze.allot_kv_code='" + allot_kv_code + "'";

		nativeRepository.insertQueries(query);
	}

	public void updateExtTransfer(Integer allot_kv_code, String empCode) {
		String query = "insert into z_ext_emp_details (id,teacher_id,emp_code,emp_name,gender,dob,post_id,subject_id,region_code,present_station_code,present_kv_code,present_kv_master_code\r\n"
				+ ",shift,doj_in_present_stn_irrespective_of_cadre,is_ner_recruited,isjcm_rjcm,is_pwd,is_hard_served,is_currently_in_hard,station_code_1,station_code_2,station_code_3,station_code_4,station_code_5,tot_tc\r\n"
				+ ",tot_tc2,tot_dc,transfer_applied_for,dc_applied_for,is_trasnfer_applied,allot_stn_code,allot_kv_code,allot_shift,transferred_under_cat,emp_transfer_status,is_displaced\r\n"
				+ ",elgible_yn,is_ner,apply_transfer_yn,ground_level,print_order,kv_name_present,kv_name_alloted,station_name1,station_name2,station_name3,station_name4,station_name5\r\n"
				+ ",region_name_present,region_code_alloted,region_name_alloted,station_name_present,station_name_alloted,post_name,subject_name,join_date,relieve_date,join_relieve_flag,transfer_type,modified_date_time,transfer_year,is_automated_transfer,is_admin_transfer )\r\n"
				+ "select id,teacher_id,emp_code,emp_name,gender,dob,post_id,subject_id,region_code,present_station_code,present_kv_code,present_kv_master_code\r\n"
				+ ",shift,doj_in_present_stn_irrespective_of_cadre,is_ner_recruited,isjcm_rjcm,is_pwd,is_hard_served,is_currently_in_hard,station_code_1,station_code_2,station_code_3,station_code_4,station_code_5,tot_tc\r\n"
				+ ",tot_tc2,tot_dc,transfer_applied_for,dc_applied_for,is_trasnfer_applied,allot_stn_code,allot_kv_code,allot_shift,transferred_under_cat,emp_transfer_status,is_displaced\r\n"
				+ ",elgible_yn,is_ner,apply_transfer_yn,ground_level,print_order,kv_name_present,kv_name_alloted,station_name1,station_name2,station_name3,station_name4,station_name5\r\n"
				+ ",region_name_present,region_code_alloted,region_name_alloted,station_name_present,station_name_alloted,post_name,subject_name,join_date,relieve_date,join_relieve_flag,transfer_type,modified_date_time,transfer_year,is_automated_transfer,is_admin_transfer   from  z_emp_details_3107 ze\r\n"
				+ "where ze.emp_code='" + empCode + "' and  ze.allot_kv_code='" + allot_kv_code + "'";

		nativeRepository.insertQueries(query);
	}

	public Object getTransferProfileBySchool(String kvCode,String inityear) {
		List<SchoolTransferProfile> sltf = new ArrayList<SchoolTransferProfile>();
		QueryResult qs = nativeRepository.executeQueries(
				"select tp.teacher_id , tp.teacher_employee_code , tp.teacher_name,ttd.tc_save_yn,ttd.dc_save_yn, ttd.tc_total_point ,ttd.dc_total_point,tfs.transfer_final_status from public.teacher_profile tp left join transfer.teacher_transfer_details ttd on tp.teacher_id =ttd.teacher_id and ttd.inityear='"+inityear+"' left join teacher_form_status tfs on ttd.teacher_id =tfs.teacher_id  where tp.kv_code ='"
						+ kvCode + "'");

		for (Map<String, Object> mp : qs.getRowValue()) {
			SchoolTransferProfile stf = new SchoolTransferProfile();
			stf.setTeacherId(mp.get("teacher_id"));
			stf.setTeacherEmployeeCode(mp.get("teacher_employee_code"));
			stf.setTeacherName(mp.get("teacher_name"));
			stf.setTcTotalPoint(mp.get("tc_total_point"));
			stf.setDcTotalPoint(mp.get("dc_total_point"));
			stf.setTransferFinalStatus(mp.get("transfer_final_status"));
			stf.setTcSaveYn(mp.get("tc_save_yn"));
			stf.setDcSaveYn(mp.get("dc_save_yn"));
			sltf.add(stf);
		}
		return sltf;
	}

}
