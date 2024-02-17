package com.example.MOERADTEACHER.common.transfercontroller;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.bean.TransferDcBeans;
import com.example.MOERADTEACHER.common.transferbean.Transfer;
import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferDetails;
import com.example.MOERADTEACHER.common.transfermodel.TransferKVTeacherDetails;
import com.example.MOERADTEACHER.common.transferrepository.TeacherTransferRepository;
import com.example.MOERADTEACHER.common.transferservice.TeacherTransferImpl;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.common.util.CustomObjectMapper;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;
import com.example.MOERADTEACHER.common.util.UtilCalculation;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(ApiPaths.TeacherTransferCtrl.CTRL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TeacherTransferController {

	@Autowired
	NativeRepository nativeRepository;
	
	@Autowired
	TeacherTransferImpl teacherTransferImpl;
	@Autowired
	TeacherTransferRepository teacherTransferRepository;
	
	@Autowired
	CustomObjectMapper customObjectMapper;
	
	@RequestMapping(value = "/saveTransferDCTCPoints", method = RequestMethod.POST)
	public ResponseEntity<TeacherTransferDetails> saveTransferDCTCPoints(@RequestBody String data) throws Exception {
		
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherTransferDetails trsBean = new TeacherTransferDetails();
		try {
		 trsBean = mapperObj.readValue(data, new TypeReference<TeacherTransferDetails>() {
			});
		 
		 if(trsBean.getTcSaveYn() !=null && (trsBean.getTcSaveYn()==1 || trsBean.getDcSaveYn()==1)) {
		 String transfer_id="KVS"+(100000+trsBean.getTeacherId());
		 trsBean.setTransferId(transfer_id);
		 }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return ResponseEntity.ok(teacherTransferImpl.saveTransferDCTCPoints(trsBean));
	}
	
	
	@RequestMapping(value = "/getTeacherTransferDetails", method = RequestMethod.POST)
	public ResponseEntity<?> saveTeacherTransfer(@RequestBody String data,
			@RequestHeader("username") String username) throws Exception {
System.out.println("Teacher Trafser details called");
		String kvCode = "";
		String teacherId = "";
		Integer teacherTransferSaveYn=0;
		int dcNoofYears=0;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(data);
			// {"kvCode":"9999","teacherId":1385}
			kvCode = jsonNode.get("kvCode").asText();
			teacherId = jsonNode.get("teacherId").asText();

			//System.out.println("kv_code: " + kvCode);
			//System.out.println("teacherId: " + teacherId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		TeacherTransferDetails savedTeacherTransObj = teacherTransferImpl
				.getTcDcPointByTeacherId(Integer.parseInt(teacherId));

		//System.out.println("Teacher Id--->"+savedTeacherTransObj.getTeacherId());
		
		// Commented by shamim 04/02/2024
//		if (savedTeacherTransObj != null) {
////			System.out.println("in if condition");// IE TC and DC Point is Saved.
//			teacherTransferSaveYn=1;
//			return ResponseEntity.ok(savedTeacherTransObj);
//		} 
		
//		else {
//			System.out.println("in else condition");

//			System.out.println("data: " + data); // Inityear added by shamim 01022024 below query for get transfer profile data 
			 String QUERY =  "select tp.teacher_id ,ksm.school_type,ksm.current_hard_flag_yn ,"
			+ "public.datediff(tp.work_experience_position_type_present_station_start_date::date,'2023-06-30'::date ) as continuous_stay, "
			+ "tp.work_experience_position_type_present_station_start_date , ttp.choice_kv1_station_code ,tp.teacher_employee_code,tp.teacher_id ,tp.teacher_dob, ttp.absence_days_one, teacher_disability_yn,ksm.station_code ,tp.spouse_station_code  , ttp.personal_status_mdgd , ttp.personal_status_dfpd , tp.marital_status ,tp.spouse_status , ttp.personal_status_spd ,   tp.teacher_gender , ttp.memberjcm , ttp.surve_hard_yn from public.teacher_transfer_profile ttp , public.teacher_profile tp , kv.kv_school_master ksm \r\n"
			+ "where ttp.teacher_id = tp.teacher_id  and  ttp.teacher_id = '"+ teacherId.toString() +"' "
			+ "and ksm.kv_code = tp.kv_code and ttp.inityear='2024' and ksm.kv_code = '"+kvCode.toString() +"'";

			
			System.out.println("first query--->"+QUERY.toString());
//			System.out.println("getTeacherTransferDetails data  " + data);
// Below query is for no of day in station
			String QUERYstation = " select *, DATE_PART('day', work_end_date::timestamp - work_start_date::timestamp) as no_of_days from (\r\n"
					+ "				 	select ksm.station_code , work_start_date , coalesce(work_end_date,'2023-06-30') as work_end_date, \r\n"
					+ "				 	teacher_id   \r\n"
					+ "				 	from 	public.teacher_work_experience twe , kv.kv_school_master ksm \r\n"
					+ "				 	where teacher_id = '" + teacherId.toString() + "'"
					+ "				 	and ksm.kv_code = twe.udise_sch_code \r\n"
					+ "				 	order by work_start_date \r\n"
					+ "				 	) aa order by work_start_date desc ";

			System.out.println("second query--->"+QUERYstation);
			
			List<Transfer> transfers = new ArrayList<>();
			TransferDcBeans dcObj = new TransferDcBeans();
			// Open a connection
			try {
				DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
				// System.out.println(QUERY);
				QueryResult rs = nativeRepository.executeQueries(QUERY);

				int i = 0;
				int teacherAge = 0;
				int surve_hard_yn = 0;
				int tc_current_station_hard_yn = 0;
				int teacher_disability_yn = 0;
				int personal_status_mdgd = 0;
				int personal_status_dfpd = 0;
				int lessThanThreeYearRetire = 0;
				int continuousStay = 0;

				int gender = 0;
				int marital_status = 4;
				int spouseEmployementStatus = 5;

				int personal_status_spd = 0; // Single Parent
				int teacher_gender = 0; // Woman Employee
				int memberjcm = 0;
				String idsStartWith = "(0";
				String idsEndsWith = ")";
				

				// Current Station Staying Period

				try {
					//System.out.println(QUERYstation);

					QueryResult qr = nativeRepository.executeQueries(QUERYstation);
//					System.out.println("size--->" + qr.getRowValue().size());

//					for (int j = 0; j < qr.getRowValue().size(); j++) {
//
//						SimpleDateFormat sObj = new SimpleDateFormat("yyyy-MM-dd");
//
//						Date date1 = sObj
//								.parse(String.valueOf(qr.getRowValue().get(j).get("work_start_date").toString()));
//
//						try {
//							transfers.add(new Transfer(String.valueOf(qr.getRowValue().get(j).get("station_code")),
//									sObj.parse(
//											String.valueOf(qr.getRowValue().get(j).get("work_start_date").toString())),
//									sObj.parse(String.valueOf(qr.getRowValue().get(j).get("work_end_date").toString())),
//									(int) Double
//											.parseDouble((String.valueOf(qr.getRowValue().get(j).get("no_of_days"))))));
//
//						} catch (Exception ex) {
//							ex.printStackTrace();
//						}
//					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				/*
				 * Continuous Stay At Current Station Continuous Stay will be Counted in
				 * Displacement count Here no Leave is Considered
				 * 
				 * After That Return Stay will also be counted
				 */

				//int continuousStay = calculateContinuousStay(transfers);
				
//				List<Transfer> highestThreeRows = getHighestThreeRows(transfers);
				
               QueryResult retObj=nativeRepository.executeQueries("select * from transfer.transfer_teacher_check  where teacher_id="+teacherId);
				
               
//               System.out.println("return stay from db---->"+retObj.getRowValue().get(0).get("returnstay"));
               int returnStay=0;
               
               if(retObj.getRowValue().size()>0 && retObj.getRowValue().get(0).get("returnstay") !=null) {
            	  returnStay =Integer.parseInt(String.valueOf(retObj.getRowValue().get(0).get("returnstay")));   
               }
				
				
				System.out.println("after set return stay--"+returnStay);			

				for (int k = 0; k < rs.getRowValue().size(); k++) {
					++i;
					String inString = "";

					
					DateTime DateOfBirth = formatter
							.parseDateTime(String.valueOf(rs.getRowValue().get(k).get("teacher_dob")));
					teacherAge = calculateAge(DateOfBirth);
					// Continuous Stay At Current
					
					if (rs.getRowValue().get(k).get("continuous_stay") == null) {
						continuousStay = 0;
					} else {
						continuousStay = Integer.parseInt(String.valueOf(rs.getRowValue().get(k).get("continuous_stay")));
					}
					
					System.out.println("continuousStay--->"+continuousStay);

					
					// Hard Station Served
					if (rs.getRowValue().get(k).get("surve_hard_yn") == null) {
						surve_hard_yn = 0;
					} else {
						surve_hard_yn = Integer.parseInt(String.valueOf(rs.getRowValue().get(k).get("surve_hard_yn")));
					}

					if (rs.getRowValue().get(k).get("current_hard_flag_yn") == null) {
						tc_current_station_hard_yn = 0;
					} else {
						tc_current_station_hard_yn = Integer
								.parseInt(String.valueOf(rs.getRowValue().get(k).get("current_hard_flag_yn")));
					}

					// Disability ID = 3

					if (rs.getRowValue().get(k).get("teacher_disability_yn") == null) {
						teacher_disability_yn = 0;
					} else {
						teacher_disability_yn = Integer
								.parseInt(String.valueOf(rs.getRowValue().get(k).get("teacher_disability_yn")));
					}
					// Medical Ground
					if (rs.getRowValue().get(k).get("personal_status_mdgd") == null) {
						personal_status_mdgd = 0;
					} else {
						personal_status_mdgd = Integer
								.parseInt(String.valueOf(rs.getRowValue().get(k).get("personal_status_mdgd")));
					}
					// Death in Family
					if (rs.getRowValue().get(k).get("personal_status_dfpd") == null) {
						personal_status_dfpd = 0;
					} else {
						personal_status_dfpd = Integer
								.parseInt(String.valueOf(rs.getRowValue().get(k).get("personal_status_dfpd")));
					}

					// Less Than 3 Years to retire
					if (teacherAge >= 57) {
						lessThanThreeYearRetire = 1;
					}
					// Maritial Status
					if (rs.getRowValue().get(k).get("marital_status") == null) { // 1 Married , 4 Single 7 Widow
						marital_status = 4;
					} else {
						marital_status = Integer
								.parseInt(String.valueOf(rs.getRowValue().get(k).get("marital_status")));
					}
					// Spouse Employment Status
					if (marital_status == 1) { // ie Person is married

						if (rs.getRowValue().get(k).get("spouse_status") == null) { // 1 KVS 2 Central 3 State 5 None
							spouseEmployementStatus = 5;
						} else {
							spouseEmployementStatus = Integer
									.parseInt(String.valueOf(rs.getRowValue().get(k).get("spouse_status")));
						}

					} // Single Parent
					if (rs.getRowValue().get(k).get("personal_status_spd") == null) {
						personal_status_spd = 0;
					} else {
						personal_status_spd = Integer
								.parseInt(String.valueOf(rs.getRowValue().get(k).get("personal_status_spd")));
					}
					// Woman Employee
					if (rs.getRowValue().get(k).get("teacher_gender") == null) {
						teacher_gender = 0;
					} else {
						teacher_gender = Integer
								.parseInt(String.valueOf(rs.getRowValue().get(k).get("teacher_gender")));
					}
					// Member of JCM
					if (rs.getRowValue().get(k).get("memberjcm") == null) { // RJCM = 1 , NJCM = 2 , for other 0
						teacher_gender = 0;
					} else {
						teacher_gender = Integer.parseInt(String.valueOf(rs.getRowValue().get(k).get("memberjcm")));
					}

				}

				
//				int dcNoofDays = continuousStay + returnStay; // Commented by shamim 
				UtilCalculation uc=new UtilCalculation();
				int dcNoofDays =uc.calDcStayAtStation(Integer.parseInt(teacherId),nativeRepository);
				
				System.out.println("dcNoofDays-->"+dcNoofDays);
				
				double result = dcNoofDays / 365;
				 dcNoofYears = (int) result;
				System.out.print("dcNoofYears  "+dcNoofYears);
				// Absence Stay at Station

				dcObj.setDcStayAtStation(dcNoofYears);
				int tcStayAtStationYears = isNullOrEmptyString(
						rs.getRowValue().get(0).get("absence_days_one").toString());
				dcObj.setDcStayStationPoint(dcNoofYears * 2);
				dcObj.setTcStayAtStation(tcStayAtStationYears);
				dcObj.setTcStayStationPoint(tcStayAtStationYears * 2);
				System.out.println(" DC Station Point  " + dcObj.getDcStayStationPoint().toString()
						+ " TC Station Point " + dcObj.getTcStayStationPoint());

				// For DC it is Yes or No , No Point is given for that
				dcObj.setDcTenureHardPoint("N");

				if (teacherAge < 40) {
					if (surve_hard_yn == 1) {
						dcObj.setDcTenureHardPoint("Y");
					}
				}
				
				System.out.println(rs.getRowValue().get(0));
				String dc_spouse_station_code =null;
				String tc_spouse_station_code=null;
				if(rs.getRowValue().get(0).get("spouse_station_code") !=null) {
				 dc_spouse_station_code = String
						.valueOf(isNullOrEmptyString(rs.getRowValue().get(0).get("spouse_station_code").toString()));
				 tc_spouse_station_code = String
						.valueOf(isNullOrEmptyString(rs.getRowValue().get(0).get("spouse_station_code").toString()));
				}
				String employee_own_station_code = String
						.valueOf(isNullOrEmptyString(rs.getRowValue().get(0).get("station_code").toString()));
				
				// TC Hard Point
				
				
				String querytc="select tp.work_experience_position_type_present_station_start_date, scm.from_date , scm.todate , scm.is_active \r\n"
						+ ",ksm.station_code , tp.teacher_id , scm.category_id \r\n"
						+ "from public.teacher_profile tp , kv.kv_school_master ksm , master.station_category_mapping scm\r\n"
						+ "where tp.kv_code = ksm.kv_code --and ksm.station_code = '"+employee_own_station_code+"'\r\n"
						+ "and scm.station_code::varchar = ksm.station_code::varchar \r\n"
						+ "and tp.teacher_id = '"+teacherId.toString()+"'\r\n"
						+ "and tp.work_experience_position_type_present_station_start_date::date between scm.from_date and scm.todate";
				
				
				System.out.println("querytc---->"+querytc);
				
				QueryResult tchard = nativeRepository.executeQueries(querytc);
				String categoryId=null;
				System.out.println("tcStayAtStationYears---->"+tcStayAtStationYears);
				System.out.println(tchard.getRowValue().size());
				if(tchard.getRowValue().size()>0) {
					categoryId=String.valueOf(tchard.getRowValue().get(0).get("category_id"));
					System.out.println(categoryId);
					if((categoryId.equalsIgnoreCase("3") || categoryId.equalsIgnoreCase("1")) && (tcStayAtStationYears >=3)) {
						dcObj.setTcTenureHardPoint(30);	
					}else if((categoryId.equalsIgnoreCase("4")) && (tcStayAtStationYears >=2)) {
						dcObj.setTcTenureHardPoint(30);	
					}
				}else {
					dcObj.setTcTenureHardPoint(0);
				}
				

				// Initilize with 0
				
				

//				if (tc_current_station_hard_yn == 1) {// Employee Present Station Is Hard
//					if (tcStayAtStationYears >= 3) { // He is Completed More Than 3 Year
//						dcObj.setTcTenureHardPoint(30);
//					}
//				}

				// Disability
				if (teacher_disability_yn == 1) {
					dcObj.setDcPhysicalChallengedPoint(-20);
					dcObj.setTcPhysicalChallengedPoint(40);
//  	set point from master
				} else {
					dcObj.setDcPhysicalChallengedPoint(0);
					dcObj.setTcPhysicalChallengedPoint(0);
//  		dcObj.setDcPhysicalChallengedPoint();	
				}
				// Medical Ground or Death of Family
				if (personal_status_mdgd == 1 || personal_status_dfpd == 1) {
					dcObj.setDcMdDfGroungPoint(-14);
					dcObj.setTcMdDfGroungPoint(35);
//  	set point from master
				} else {
					dcObj.setDcMdDfGroungPoint(0);
					dcObj.setTcMdDfGroungPoint(0);
				}
				// LTR - Less than 3 years to retire
				if (lessThanThreeYearRetire == 1) {
					dcObj.setDcLtrPoint(-6);
					dcObj.setTcLtrPoint(25);
//  	set point from master
				} else {
					dcObj.setDcLtrPoint(0);
					dcObj.setTcLtrPoint(0);
				}

				Map<Integer, Object> spousePointObj = new HashMap<Integer, Object>();

				List<Integer> applicatblePoint = new ArrayList<Integer>();
//  List<Integer> tcApplicatblePoint=new ArrayList<Integer>();

				spousePointObj.put(1, -10); // same station spouse at kv
				spousePointObj.put(2, -8); // same station central Govt
				spousePointObj.put(3, -6); // same station state govt 
				spousePointObj.put(4, -4); // Gender Female
				spousePointObj.put(6, -12); // Single Parent

				Map<Integer, Object> tcSpousePointObj = new HashMap<Integer, Object>();
				List<Integer> tcApplicatblePoint = new ArrayList<Integer>();

				tcSpousePointObj.put(1, 15); // Spouse KVS Employee at choice
				tcSpousePointObj.put(2, 12); // Central at choice
				tcSpousePointObj.put(3, 10); // State Govt choice
				tcSpousePointObj.put(4, 8); // Gender Female
				tcSpousePointObj.put(6, 20); // Single Parent

				Integer spouseJobType = null;
				Boolean spouseAtSameStation = false;
				Boolean spouseChoiceSameStation = false;

//			System.out.println("Called");

				
//				System.out.println(rs.getRowValue().get(0).get("choice_kv1_station_code"));
				String tc_spouse_station_choice1_code =null;
				if(rs.getRowValue().get(0).get("choice_kv1_station_code") !=null) {
				 tc_spouse_station_choice1_code = String.valueOf(
						isNullOrEmptyString(rs.getRowValue().get(0).get("choice_kv1_station_code").toString()));
				}
				// System.out.println("Marirtal--->"+rs.getRowValue().get(0).get("marital_status"));

				if (rs.getRowValue().get(0).get("marital_status") != null
						&& String.valueOf(rs.getRowValue().get(0).get("marital_status")).equalsIgnoreCase("1")) {// Person  is  married

					spouseJobType = Integer.parseInt(String.valueOf(rs.getRowValue().get(0).get("spouse_status"))); // 1  KV  2  Central  3  State  5  None

//					System.out.println("spouseJobType--->"+spouseJobType);
					
					if (spouseJobType != null && spouseJobType != 5) {
						// KV , Central , State Employee
						if (employee_own_station_code !=null && dc_spouse_station_code !=null && employee_own_station_code.equalsIgnoreCase(dc_spouse_station_code.toString())) { // Same  For DC
							spouseAtSameStation = true;
						}
						
//						System.out.println("tc_spouse_station_code--->"+tc_spouse_station_code);
//						System.out.println("tc_spouse_station_choice1_code--->"+tc_spouse_station_choice1_code);
						
						if (tc_spouse_station_code !=null && tc_spouse_station_choice1_code !=null && tc_spouse_station_code.equalsIgnoreCase(tc_spouse_station_choice1_code.toString())) { // Choice Station  For  TC
							spouseChoiceSameStation = true;
						}
					}

					if (spouseAtSameStation) {
						applicatblePoint.add(spouseJobType);
					}

					if (spouseChoiceSameStation) {
						tcApplicatblePoint.add(spouseJobType);
					}

				}

				Integer teacherGender = Integer.parseInt(String.valueOf(rs.getRowValue().get(0).get("teacher_gender")));

				if (teacherGender == 2) {// Female Employee
					applicatblePoint.add(4);
					tcApplicatblePoint.add(4);
				}

				if (personal_status_spd == 1) { // Single Parent
					applicatblePoint.add(6);
					tcApplicatblePoint.add(6);
				}

				Integer minValue = 0;
				System.out.println("applicatblePoint" + applicatblePoint);
				if (applicatblePoint.size() > 0) {
					for (int l = 0; l < applicatblePoint.size(); l++) {
						Integer dyValue = Integer.parseInt(String.valueOf(spousePointObj.get(applicatblePoint.get(l))));
						if (minValue > dyValue) {
							minValue = dyValue;
						}
					}
				}

				Integer maxValue = 0;
				System.out.println("applicatblePoint" + applicatblePoint);
				if (tcApplicatblePoint.size() > 0) {
					for (int l = 0; l < tcApplicatblePoint.size(); l++) {
						Integer dyValue = Integer
								.parseInt(String.valueOf(tcSpousePointObj.get(tcApplicatblePoint.get(l))));
						if (maxValue < dyValue) {
							maxValue = dyValue;
						}
					}
				}

				// System.out.println("min Value---->"+minValue);
				if (minValue == -4) {
					dcObj.setDcNonSopouseSinglePoint(minValue);
				} else if (minValue == -12) {
					dcObj.setDcSinglePoint(minValue);
				}
				dcObj.setDcSpousePoint(minValue);

				
				if (maxValue == 8) {
					dcObj.setTcNonSopouseSinglePoint(maxValue);
				} else if (maxValue == 20) {
					dcObj.setTcSinglePoint(maxValue);
				}
				dcObj.setTcSpousePoint(maxValue);

//				System.out.println("min Value---->" + minValue);

				Integer schoolType = Integer.parseInt(String.valueOf(rs.getRowValue().get(0).get("school_type")));

//				System.out.println("schoolType---->" + schoolType);
				
			String	queryToCkeckSameROandZIET=" select distinct ksm.station_code  from kv.kv_school_master ksm where ksm.region_code in (\r\n"
					+ "	 select region_code  from kv.kv_school_master ksm , public.teacher_profile tp \r\n"
					+ "	 where tp.kv_code = ksm.kv_code and tp.teacher_id = '"+teacherId+"') and ksm.school_type ='3'\r\n"
					+ "	 ";
			
			
		QueryResult	rjcmnjcmRs=nativeRepository.executeQueries(queryToCkeckSameROandZIET);
		String rjcmChoiceStationCode="";
		if(rjcmnjcmRs.getRowValue().size()>0 && rjcmnjcmRs.getRowValue().get(0).get("station_code") !=null) {
			rjcmChoiceStationCode=String.valueOf(rjcmnjcmRs.getRowValue().get(0).get("station_code"));
		}
		
		
			

				try {
					memberjcm = Integer.parseInt(String.valueOf(rs.getRowValue().get(0).get("memberjcm")));
//					System.out.println("memberjcm---->" + memberjcm);
				} catch (Exception e) {
					memberjcm = 0;
				}

				if (memberjcm == 2 &&  employee_own_station_code.equalsIgnoreCase("239")) {   // 239 for delhi station
					dcObj.setDcRjcmNjcmPoint(-6);
					//dcObj.setTcRjcmNjcmPoint(6);
				} else if(memberjcm == 1  &&  employee_own_station_code.equalsIgnoreCase(rjcmChoiceStationCode)){
					dcObj.setDcRjcmNjcmPoint(-6);
				}else {
					dcObj.setDcRjcmNjcmPoint(0);
//					dcObj.setTcRjcmNjcmPoint(0);
				}
				
				
				
				QueryResult tcRjcm = nativeRepository.executeQueries("select choice_kv1_station_code , ksm.school_type , ttp.teacher_id from public.teacher_transfer_profile ttp ,kv.kv_school_master ksm where  ttp.choice_kv1_station_code = ksm.station_code and ttp.teacher_id ="+teacherId);
				Integer tcRjcmSchoolType=0;
				
				if(tcRjcm.getRowValue().size()>0) {
					tcRjcmSchoolType=Integer.parseInt(String.valueOf(tcRjcm.getRowValue().get(0).get("school_type")));
				}
				
				if (memberjcm == 2 &&  tc_spouse_station_choice1_code.equalsIgnoreCase("239")) {
					dcObj.setTcRjcmNjcmPoint(6);
				} else if(memberjcm == 1 && tc_spouse_station_choice1_code.equalsIgnoreCase(rjcmChoiceStationCode)){
					dcObj.setTcRjcmNjcmPoint(6);
				}else {
					dcObj.setTcRjcmNjcmPoint(0);
//					dcObj.setTcRjcmNjcmPoint(0);
				}
				
				dcObj.setKvCode(String.valueOf(rs.getRowValue().get(0).get("kv_code")));
				dcObj.setTeacherId(Integer.parseInt(String.valueOf(rs.getRowValue().get(0).get("teacher_id"))));
				dcObj.setTeacherEmployeeCode(String.valueOf(rs.getRowValue().get(0).get("teacher_employee_code")));
				dcObj.setCreatedDateTime(new Date());
				dcObj.setUpdateDateTime(new Date());

				Integer maxAmoungFive = 0;
				List<Integer> findMax = new ArrayList<Integer>();
				findMax.add(checkIntegerNull(dcObj.getDcPhysicalChallengedPoint()));  // pwd
				findMax.add(checkIntegerNull(dcObj.getDcMdDfGroungPoint()));  // MDG DFP
				findMax.add(checkIntegerNull(dcObj.getDcLtrPoint()));        // LTR
				findMax.add(checkIntegerNull(dcObj.getDcSpousePoint()));    // Spouse
				findMax.add(checkIntegerNull(dcObj.getDcRjcmNjcmPoint()));
				maxAmoungFive = findMax.stream().min(Comparator.naturalOrder()).get();

				Integer tcMaxAmoungFive = 0;
				List<Integer> tcFindMax = new ArrayList<Integer>();
				tcFindMax.add(checkIntegerNull(dcObj.getTcPhysicalChallengedPoint()));
				tcFindMax.add(checkIntegerNull(dcObj.getTcMdDfGroungPoint()));
				tcFindMax.add(checkIntegerNull(dcObj.getTcLtrPoint()));
				tcFindMax.add(checkIntegerNull(dcObj.getTcSpousePoint()));
				tcFindMax.add(checkIntegerNull(dcObj.getTcRjcmNjcmPoint()));
				tcFindMax.add(checkIntegerNull(dcObj.getTcTenureHardPoint()));
				tcMaxAmoungFive = tcFindMax.stream().max(Comparator.naturalOrder()).get();


//				System.out.println("maxAmoungFive--->" + maxAmoungFive);
				Integer dc_total = dcObj.getDcStayStationPoint() + maxAmoungFive;
				Integer tc_total = dcObj.getTcStayStationPoint() + tcMaxAmoungFive;

				dcObj.setDcTotalPoint(dc_total);
				dcObj.setTcTotalPoint(tc_total);



			} catch (Exception ex) {
				System.out.println("Exception------>"+teacherId);
				ex.printStackTrace();
			}
			
			
//			if(teacherTransferSaveYn==1) {
//				savedTeacherTransObj.setDcLtrPoint(dcObj.getDcLtrPoint());
//				savedTeacherTransObj.setDcMdDfGroungPoint(dcObj.getDcMdDfGroungPoint());
//				savedTeacherTransObj.setDcNonSopouseSinglePoint(dcObj.getDcNonSopouseSinglePoint());
//				savedTeacherTransObj.setDcPeriodAbsence(dcObj.getDcPeriodAbsence());
//				savedTeacherTransObj.setDcPhysicalChallengedPoint(dcObj.getDcPhysicalChallengedPoint());
//				savedTeacherTransObj.setDcReturnStation(dcObj.getDcReturnStation());
//				savedTeacherTransObj.setDcRjcmNjcmPoint(dcObj.getDcRjcmNjcmPoint());
//				savedTeacherTransObj.setDcSinglePoint(dcObj.getDcSinglePoint());
//				savedTeacherTransObj.setDcSpousePoint(dcObj.getDcSpousePoint());	
//				savedTeacherTransObj.setDcStayAtStation(dcObj.getDcStayAtStation());
//				savedTeacherTransObj.setDcTenureHardPoint(dcObj.getDcTenureHardPoint());
//				savedTeacherTransObj.setDcTotalPoint(dcObj.getDcTotalPoint());
//				savedTeacherTransObj.setDcStayStationPoint(dcObj.getDcStayStationPoint());				
//				savedTeacherTransObj.setTcLtrPoint(dcObj.getTcLtrPoint());
//				savedTeacherTransObj.setTcMdDfGroungPoint(dcObj.getTcMdDfGroungPoint());
//				savedTeacherTransObj.setTcNonSopouseSinglePoint(dcObj.getTcNonSopouseSinglePoint());
//				savedTeacherTransObj.setTcPeriodAbsence(dcObj.getTcPeriodAbsence());
//				savedTeacherTransObj.setTcPhysicalChallengedPoint(dcObj.getTcPhysicalChallengedPoint());
//				savedTeacherTransObj.setTcRjcmNjcmPoint(dcObj.getTcRjcmNjcmPoint());
//				savedTeacherTransObj.setTcSinglePoint(dcObj.getTcSinglePoint());
//				savedTeacherTransObj.setTcSpousePoint(dcObj.getTcSpousePoint());
//				savedTeacherTransObj.setTcStayAtStation(dcObj.getTcStayAtStation());
//				savedTeacherTransObj.setTcTenureHardPoint(dcObj.getTcTenureHardPoint());
//				savedTeacherTransObj.setTcStayStationPoint(dcObj.getTcStayStationPoint());
//				savedTeacherTransObj.setTcTotalPoint(dcObj.getTcTotalPoint());
//				teacherTransferRepository.saveAndFlush(savedTeacherTransObj);				
//				return ResponseEntity.ok(savedTeacherTransObj);
//			}else {
				return ResponseEntity.ok(dcObj);				
//			}
			

	
//		}
	}
	
	
	@RequestMapping(value = "/getTcDcPointByTeacherIdAndInityear", method = RequestMethod.POST)
	public ResponseEntity<?> getTcDcPointByTeacherIdAndInityear(@RequestBody String data,
			@RequestHeader("username") String username) throws Exception {
		Map<String,Object> obj=customObjectMapper.getMapObject(data);
		TeacherTransferDetails savedTeacherTransObj = teacherTransferImpl.getTcDcPointByTeacherIdAndInitYear(Integer.parseInt(String.valueOf(obj.get("teacherId"))),String.valueOf(obj.get("inityear")));
	return ResponseEntity.ok(savedTeacherTransObj);
	}
	
	
	
	   public static int calculateAge(DateTime birthDate) {
		   
		    DateTimeFormatter formatter1 = DateTimeFormat.forPattern("dd/MM/yyyy");
		   // DateTime Configuredt = formatter1.parseDateTime("30/06/2023");
		    DateTime Configuredt = formatter1.parseDateTime("01/07/2023");
			Years teacherAge = Years.yearsBetween(birthDate,Configuredt);
	        return teacherAge.getYears();
	    }
	   
	   // Check null for teacher disability
	   public static boolean isNullOrEmpty(String str) {
		   return str== null || str.isEmpty();
	   }
	   
	   public static Integer  isNullOrEmptyString(String str) {
		   Integer result=0 ;
		   System.out.println("str-->"+str);
	   if (str == null || str.isEmpty()) {
		    result = 0;
		} else {
		    result = Integer.parseInt(str);
		}
	   return result;
	   }
	  public static int calculateContinuousStay(List<Transfer> transfers) {
	        int totalStay = 0;
	        String currentStation = null;
	        int noOfDays= 0;
	        
	        System.out.println("transfers--->"+transfers.size());
	        for (Transfer transfer : transfers) {
	            if (currentStation == null) {
	                // First transfer for the person
	            	System.out.println(transfer.getStation());
	            	currentStation = transfer.getStation();
	            	noOfDays =  transfer.getNoOfDays(); 

	            } else if (transfer.getStation().equals(currentStation)) {
	            	noOfDays= noOfDays + transfer.getNoOfDays();
	            	
	            } else {
	                // Person moved to another station, reset the current stay variables
	                currentStation = transfer.getStation();
	                noOfDays =  transfer.getNoOfDays(); 
	            }
	        }
	        totalStay = noOfDays + 1;
	        System.out.println("totalStay---->"+totalStay);
	        return totalStay;
	    } 
	  
	  public  int calculateReturnStay(List<Transfer> transfers) {
	        int totalStay = 0;
	        int key=0;
       	
	        
	        if (transfers.size() >= 3) {
	            Transfer firstRow = transfers.get(0);
	            Transfer secondRow = transfers.get(1);
	            Transfer thirdRow = transfers.get(2);

	            if (firstRow.getStation().equals(thirdRow.getStation()) && !secondRow.getStation().equals(firstRow.getStation())) {
	            	System.out.println("First and third rows have the same station, and second row has a different station.");
	            	
	            	String strcalculateTenure= calculateReturnStayTenure(secondRow.getStation(),secondRow.getNoOfDays(), secondRow.getStartDate(),1);
	            	String[] TenurseDescript= strcalculateTenure.split(":");
	            	key = Integer.parseInt(TenurseDescript[0]);
	            	totalStay = Integer.parseInt(TenurseDescript[3]);
	            	if (key==1)
	            	 return totalStay;
	                
	                  
	            } else {
	                System.out.println("District pattern doesn't match.");
	            }
	        } else {
	            System.out.println("Not enough transfers to check the district pattern.");
	        }
	        
	        	      
	        return totalStay;
	    } 
	  
	  public  String calculateReturnStayTenure(String StatinCode, int noOfDays, Date startDate, int typeToCalculate) {
	       
	        String returnString ="0:O:0:0";// 0 Means False , O Other Station , 0 No of Year , 0 No of days
	        try {
	        	int category_id = -1;
	        	
	        	String TenureCalculateQry = "select count(*) as no_of_record, category_id  from uneecops.station_category_mapping scm where scm.station_code ='"+StatinCode+"'   "
	        			 +" and '"+startDate +"' between from_date and to_date "
	        			+ "group by category_id ";
//	        	  Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//		          Statement stmt = conn.createStatement();
//		          ResultSet rs = stmt.executeQuery(TenureCalculateQry);
		          
	          	QueryResult	rs=nativeRepository.executeQueries(TenureCalculateQry);  
		          if (typeToCalculate == 1) {
	        		
		        	  
		        	  for(int i=0;i<rs.getRowValue().size();i++) {
		        	  
//		        		while(rs.next()) {		        			
		        			category_id =Integer.parseInt(String.valueOf(rs.getRowValue().get(i).get("category_id")));
		        					if(category_id==4) {// For Very Very Hard
					        			double noOf_Year = Double.parseDouble(String.valueOf(noOfDays))/ 364;
					        			if (noOf_Year < 2.0 ) { // Did not Complete 2 Year 
					        				returnString = "1:VH:"+noOf_Year+":"+noOfDays;// 1 = True , VH Very Hard ,  
					        				return returnString;
					        			}
					        			
					        		}else { // For all other category it must be 3
					        			double noOf_Year = Double.parseDouble(String.valueOf(noOfDays))/ 364;
					        			if (noOf_Year < 3.0 ) { 
					        				returnString = "1:O:"+noOf_Year+":"+noOfDays;
					        				return returnString;
					        			}
					        		}
		        					return returnString;		
//		        		}
		        		
		        	  }
		        		
		        		  return returnString;
	        		
	        	}
	        	
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }
	        finally {
	        
	        }
	      
	        return returnString;	
	     
	    } 
	  
	    public static List<Transfer> getHighestThreeRows(List<Transfer> transfers) {
	        return transfers.stream()
	                .sorted(Comparator.comparingInt(Transfer::getRowNumber).reversed())
	                .limit(3)
	                .collect(Collectors.toList());
	    }
	    
	    
	    public boolean checkSpouseAtSameStation(Integer teacherId) {
	    	
	    return true;
	    }  	
	    
	    
	    public Integer checkIntegerNull(Integer val) {
	    if(val ==null) {
	    	return 0;
	    }else {
	    	return val;
	    }	
	    }
	    
	
}
