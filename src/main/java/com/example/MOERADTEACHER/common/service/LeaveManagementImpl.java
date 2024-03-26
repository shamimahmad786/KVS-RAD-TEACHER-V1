package com.example.MOERADTEACHER.common.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//import org.joda.time.DateTime;
//import org.joda.time.format.DateTimeFormat;
//import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.bean.LeaveMaster;
import com.example.MOERADTEACHER.common.bean.ListLeaveMaster;
import com.example.MOERADTEACHER.common.dropboxbean.DropboxMaster;
import com.example.MOERADTEACHER.common.modal.TeacherExperience;
import com.example.MOERADTEACHER.common.modal.TeacherLeave;
import com.example.MOERADTEACHER.common.repository.TeacherExperienceRepository;
import com.example.MOERADTEACHER.common.repository.TeacherLeaveRepository;
import com.example.MOERADTEACHER.common.uneecops.master.eo.StationCategoryMappingEO;
import com.example.MOERADTEACHER.common.uneecops.master.repo.StationCategoryMappingRepository;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LeaveManagementImpl {

	@Autowired
	NativeRepository nativeRepository;

	@Autowired
	TeacherExperienceRepository teacherExperienceRepository;

	@Autowired
	TeacherLeaveRepository teacherLeaveRepository;
	@Autowired
	StationCategoryMappingRepository stationCategoryMappingRepository;

	public Object getTeacherLeaveMaster(Integer teacherId) {
		String stationCode = null;
		Integer stationIndex = null;
		Map<String, Object> result = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		List<LeaveMaster> lm = new ArrayList<LeaveMaster>();
		try {
			QueryResult qr = new QueryResult();
			LinkedList<TeacherExperience> workExperienceObj = teacherExperienceRepository.findWorkStartDate(teacherId);

			// find work start date in same station
			for (int i = 0; i < workExperienceObj.size(); i++) {
				QueryResult qs = nativeRepository
						.executeQueries("select station_code from kv.kv_school_master where kv_code='"
								+ workExperienceObj.get(i).getKvCode() + "'");
				if (i == 0) {
					stationCode = String.valueOf(qs.getRowValue().get(0).get("station_code"));
					stationIndex = i;
				} else {
					if (!stationCode.equalsIgnoreCase(String.valueOf(qs.getRowValue().get(0).get("station_code")))) {
						break;
					} else {
						stationIndex = i;
					}
				}

			}

			qr = nativeRepository.executeQueries("SELECT * FROM get_financial_year_dates('"
					+ workExperienceObj.get(stationIndex).getWorkStartDate() + "')  order by  1 desc");
			lm = mapper.convertValue(qr.getRowValue(), new TypeReference<List<LeaveMaster>>() {
			});

			result.put("status", 1);
			result.put("response", lm);

		} catch (Exception ex) {
			result.put("status", 0);
			ex.printStackTrace();
		}
		return result;

	}

	public Object saveTeacherLeave(List<TeacherLeave> tdata) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("status", 1);
			result.put("response", teacherLeaveRepository.saveAll(tdata));
		} catch (Exception ex) {
			result.put("status", 0);
			ex.printStackTrace();
		}
		return result;

	}

	public Map<String, Object> getTeacherLeave(Integer teacherId) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("status", 1);
			List<TeacherLeave> tl = teacherLeaveRepository.findAllByTeacherIdOrderByStartDateDesc(teacherId);
			if (tl.size() > 0) {
				result.put("response", tl);
			} else {
				result.put("response", null);
			}
		} catch (Exception ex) {
			result.put("status", 0);
			ex.printStackTrace();
		}
		return result;
	}

	public Object deleteTeacherLeave(Integer teacherId) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			nativeRepository.insertQueries(
					"insert into audit_tray.kvs_teacher_leave_history (id,created_date_time,end_date,is_continious_leave,no_of_leave,start_date,teacher_id) \r\n"
							+ "select id,created_date_time,end_date,is_continious_leave,no_of_leave,start_date,teacher_id from public.kvs_teacher_leave where teacher_id="
							+ teacherId);
			teacherLeaveRepository.deleteAllByTeacherId(teacherId);
			result.put("status", 1);
		} catch (Exception ex) {
			result.put("status", 0);
			ex.printStackTrace();
		}
		return result;
	}

	public Object checkStationType(String startDate, String endDate, String stateCode, String category) {
		HashMap<String, Object> res = new HashMap<String, Object>();
		if(true) {
			res.put("status", 1);
			return res;
		}
		
		
		
		List<StationCategoryMappingEO> stObj = stationCategoryMappingRepository
				.findByStationCodeOrderByFromDate(Integer.parseInt(stateCode));
		System.out.println("Category size--->" + stObj.size());
try {
		if (stObj.size() > 0) {
			Integer matchCondition=0;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate inputStartDate = LocalDate.parse(startDate, formatter);
			LocalDate inputEndDate = LocalDate.parse(endDate, formatter);
			
			for(int i=0;i<stObj.size();i++) {
				if(category.equalsIgnoreCase("0")) {
					res.put("status", 1);
					return res;
				}
				java.time.LocalDate  fromDate=stObj.get(i).getFromDate();
				java.time.LocalDate  toDate=stObj.get(i).getToDate();
				if(fromDate !=null &&  toDate==null  ) {
					 if(inputStartDate.compareTo(fromDate) >=0) {
						System.out.println("1");
						if(!String.valueOf(stObj.get(i).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("1")){
							res.put("status", 1);
							return res;
						}else if(String.valueOf(stObj.get(i).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("1")) {
							res.put("status", 0);
							res.put("message", "Wrong mapping of station category. We are considering normal station in given financial year. Please contact to headquarter");
							return res;
						}
						matchCondition=1;
					} else if(inputStartDate.compareTo(fromDate) <= 0 && inputEndDate.compareTo(fromDate) >= 0) {
						System.out.println("2");
						String currentCategories=String.valueOf(stObj.get(i).getCategoryId());
						if(Integer.parseInt(currentCategories) >0) {
							res.put("status", 1);
							return res;
						}else if(currentCategories.equalsIgnoreCase("0") && category.equalsIgnoreCase("1")) {
							res.put("status", 0);
							res.put("message", "Wrong mapping of station category. We are considering normal station in given financial year. Please contact to headquarter");
							return res;
						}
						matchCondition=1;
					}
		
				}else if(fromDate !=null && toDate !=null) {
					if(inputStartDate.compareTo(toDate) >=0) {
						if(String.valueOf(stObj.get(i).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("1")) {
								res.put("status", 0);
								res.put("message", "Wrong mapping of station category. We are considering normal station in given financial year. Please contact to headquarter");
								return res;
							}
						}else
					if(inputStartDate.compareTo(fromDate) >=0 && inputEndDate.compareTo(toDate) <= 0) {
						System.out.println("3");
						if(!String.valueOf(stObj.get(i).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("1")) {
							res.put("status", 1);
							return res;
						}else if(String.valueOf(stObj.get(i).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("1")) {
							res.put("status", 0);
							res.put("message", "Wrong mapping of station category. We are considering normal station in given financial year. Please contact to headquarter");
							return res;
						}
						matchCondition=1;
					}else if(inputStartDate.compareTo(fromDate) >=0 && inputEndDate.compareTo(toDate) >= 0) {
						System.out.println("4");
						matchCondition=1;
						String currentCategories=String.valueOf(stObj.get(i).getCategoryId());
						String nextCategories=null;
						String previousCategories=null;
						if(i !=0 &&  stObj.get(i-1) !=null) {
							nextCategories=String.valueOf(stObj.get(i+1).getCategoryId());
						}
						boolean isNormal=false;
						boolean isHardNer=false;
//						
							if(currentCategories !=null && nextCategories !=null && (currentCategories.equalsIgnoreCase("0") || nextCategories.equalsIgnoreCase("0"))) {
								isNormal=true;
							}else if(currentCategories !=null && nextCategories ==null && currentCategories.equalsIgnoreCase("0")) {
								isNormal=true;
							}
							
							if(currentCategories !=null && nextCategories !=null && (Integer.parseInt(currentCategories)>0 || Integer.parseInt(nextCategories)>0)) {
								isHardNer=true;
							}else if(currentCategories !=null && nextCategories ==null && Integer.parseInt(currentCategories)>0) {
								isHardNer=true;
							}
					
							if(isNormal && isHardNer) {
								res.put("status", 1);
								return res;
							}
						
							if(category.equalsIgnoreCase("1") &  isHardNer) {
								res.put("status", 1);
								return res;
							}else {
								res.put("status", 0);
								res.put("message", "Wrong mapping of station category. We are considering normal station in given financial year. Please contact to headquarter");
								return res;	
							}
						
						
						
					}else if(inputStartDate.compareTo(fromDate) <=0 && inputEndDate.compareTo(fromDate) >= 0) {
						
						System.out.println("5");
						System.out.println(inputStartDate+"-------"+fromDate);
						
						String currentCategories=String.valueOf(stObj.get(i).getCategoryId());
					
						String previousCategories=null;
						
						if((stObj.size()>i+1) && stObj.get(i+1) !=null) {
							previousCategories=String.valueOf(stObj.get(i+1).getCategoryId());
						}
						boolean isNormal=false;
						boolean isHardNer=false;
//						
							if(currentCategories !=null && previousCategories !=null && (currentCategories.equalsIgnoreCase("0") || previousCategories.equalsIgnoreCase("0"))) {
								isNormal=true;
							}else if(currentCategories !=null && previousCategories ==null && currentCategories.equalsIgnoreCase("0")) {
								isNormal=true;
							}
							
							if(currentCategories !=null && previousCategories !=null && (Integer.parseInt(currentCategories)>0 || Integer.parseInt(previousCategories)>0)) {
								isHardNer=true;
							}else if(currentCategories !=null && previousCategories ==null && Integer.parseInt(currentCategories)>0) {
								isHardNer=true;
							}
					System.out.println(isNormal+"---"+isHardNer);
							if(isNormal && isHardNer) {
								matchCondition=1;
								res.put("status", 1);
								return res;
							}
						System.out.println("isHardNer--->"+isHardNer);
							if(category.equalsIgnoreCase("1") &  isHardNer) {
								matchCondition=1;
								res.put("status", 1);
								return res;
							}else {
								matchCondition=1;
								res.put("status", 0);
								res.put("message", "Wrong mapping of station category. We are considering normal station in given financial year. Please contact to headquarter");
								return res;	
							}
						
					}else if(inputStartDate.compareTo(fromDate) <=0 && inputEndDate.compareTo(toDate) >= 0) {
						System.out.println("6");
						matchCondition=1;
						if(!String.valueOf(stObj.get(i).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("1")) {
							res.put("status", 1);
							return res;
						}else if(String.valueOf(stObj.get(i).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("1")) {
							res.put("status", 0);
							res.put("message", "Wrong mapping of station category. We are considering normal station in given financial year. Please contact to headquarter");
							return res;
						}
					}
				}
				
			}
			
			System.out.println("matchCondition--->"+matchCondition);
		
			if(matchCondition==0) {
				if(category.equalsIgnoreCase("0")) {
					res.put("status", 1);
					return res;	
				}else if(category.equalsIgnoreCase("1")) {
					res.put("status", 0);
					res.put("message", "Wrong mapping of station category. We are considering normal station in given financial year. Please contact to headquarter");
				}
			}
			
			
			

		} else if (stObj.size() == 0) {
			if (!category.equalsIgnoreCase("0")) {
				res.put("status", 0);
				res.put("message", "Station did not map as Hard/Very Hard/Ner. Please contact to headquarter");
				return res;
			} else {
				res.put("status", 1);
				return res;
			}
		}

//		if(category.equalsIgnoreCase("0")) {
//			res.put("status", 1);
//			return res;
//		}

//		if(stObj.size()>1) {
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//	
//			LocalDate inputStartDate = LocalDate.parse(startDate, formatter);
//			LocalDate inputEndDate = LocalDate.parse(endDate, formatter);
//			Integer matchCondition=0;
//			for(int i=0;i<stObj.size();i++) {
//			java.time.LocalDate  fromDate=stObj.get(i).getFromDate();
//			java.time.LocalDate  toDate=stObj.get(i).getToDate();
//			
//			System.out.println(fromDate+"----------"+toDate+"--------"+inputStartDate);
//			
//			if(fromDate !=null && inputStartDate.compareTo(fromDate) >=0 && toDate==null) {
//				System.out.println("1");
//				if(String.valueOf(stObj.get(i).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("0")) {
//					res.put("status", 1);
//					return res;
//				}else if(fromDate !=null && !String.valueOf(stObj.get(i).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("1")){
//					res.put("status", 1);
//					return res;
//				}else if(fromDate !=null && String.valueOf(stObj.get(i).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("1")) {
//					res.put("status", 0);
//					res.put("message", "Wrong mapping of station category. We are considering normal station in given financial year. Please contact to headquarter");
//					return res;
//				}else if(!String.valueOf(stObj.get(0).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("0")) {
//					String stationType=null;
//					if(stObj.get(i).getCategoryId()==1) {
//						stationType ="NER";
//					}else if(stObj.get(i).getCategoryId()==2) {
//						stationType ="Priority";
//					}else if(stObj.get(i).getCategoryId()==3) {
//						stationType ="Hard";
//					}else if(stObj.get(i).getCategoryId()==4) {
//						stationType ="Very Hard";
//					}
//					res.put("status", 0);
//					res.put("message", "Wrong mapping of station category. We are considering "+stationType+" station in given financial year. Please contact to headquarter");
//					return res;
//				}
//				matchCondition=1;
//			}else if (fromDate !=null && toDate !=null && inputStartDate.compareTo(fromDate) >=0 && inputStartDate.compareTo(toDate) <= 0 && inputEndDate.compareTo(toDate) <=0) {
//				System.out.println("2");
//				System.out.println(stObj.get(i).getCategoryId());
//				System.out.println("category---->"+String.valueOf(stObj.get(i).getCategoryId()).equalsIgnoreCase("0"));
//				if(String.valueOf(stObj.get(i).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("0")) {
//					res.put("status", 1);
//					return res;
//				}else if(!String.valueOf(stObj.get(i).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("1")){
//					res.put("status", 1);
//					return res;
//				}else if(String.valueOf(stObj.get(i).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("1")) {
//					res.put("status", 0);
//					res.put("message", "Wrong mapping of station category. We are considering normal station in given financial year. Please contact to headquarter");
//					return res;
//				}else if(!String.valueOf(stObj.get(0).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("0")) {
//					String stationType=null;
//					if(stObj.get(i).getCategoryId()==1) {
//						stationType ="NER";
//					}else if(stObj.get(i).getCategoryId()==2) {
//						stationType ="Priority";
//					}else if(stObj.get(i).getCategoryId()==3) {
//						stationType ="Hard";
//					}else if(stObj.get(i).getCategoryId()==4) {
//						stationType ="Very Hard";
//					}
//					res.put("status", 0);
//					res.put("message", "Wrong mapping of station category. We are considering "+stationType+" station in given financial year. Please contact to headquarter");
//					return res;
//				}
//				matchCondition=1;
//			}else if(fromDate !=null && toDate !=null && inputStartDate.compareTo(fromDate) >=0 && inputStartDate.compareTo(toDate) <= 0 && inputEndDate.compareTo(toDate) >=0){
//				System.out.println("3");
//				matchCondition=1;
//				String currentCategories=String.valueOf(stObj.get(i).getCategoryId());
//				String nextCategories=null;
//				String previousCategories=null;
//				if(stObj.get(i+1) !=null) {
//					nextCategories=String.valueOf(stObj.get(i+1).getCategoryId());
//				}
//			boolean isNormal=false;
//			boolean isHardNer=false;
//			
//				if(currentCategories !=null && nextCategories !=null && (currentCategories.equalsIgnoreCase("0") || nextCategories.equalsIgnoreCase("0"))) {
//					isNormal=true;
//				}else if(currentCategories !=null && nextCategories ==null && currentCategories.equalsIgnoreCase("0")) {
//					isNormal=true;
//				}
//				
//				if(currentCategories !=null && nextCategories !=null && (Integer.parseInt(currentCategories)>0 || Integer.parseInt(nextCategories)>0)) {
//					isHardNer=true;
//				}else if(currentCategories !=null && nextCategories ==null && Integer.parseInt(currentCategories)>0) {
//					isHardNer=true;
//				}
//				System.out.println("Current and next categories---->"+currentCategories+"-----"+nextCategories);
//		
//				if(isNormal && isHardNer) {
//					res.put("status", 1);
//					return res;
//				}
//				
//				if(category.equalsIgnoreCase("0") && isNormal) {
//					res.put("status", 1);
//					return res;
//				}else if(Integer.parseInt(category)>0 && isHardNer) {
//					res.put("status", 1);
//					return res;
//				}else {
//					
//					String stationType=null;
//					if(stObj.get(i).getCategoryId()==1) {
//						stationType ="NER";
//					}else if(stObj.get(i).getCategoryId()==2) {
//						stationType ="Priority";
//					}else if(stObj.get(i).getCategoryId()==3) {
//						stationType ="Hard";
//					}else if(stObj.get(i).getCategoryId()==4) {
//						stationType ="Very Hard";
//					}
//					res.put("status", 0);
//					res.put("message", "Wrong mapping of station category. We are considering "+stationType+" station in given financial year. Please contact to headquarter");
//					return res;
//					
//				}
//
//				
//			}else {
//				System.out.println("4");
//				System.out.println("last part");
//
//			}
//			}
//			
//			System.out.println("matchCondition--->"+matchCondition);
//			
//			if(matchCondition==0) {
//				if(category.equalsIgnoreCase("0")) {
//					res.put("status", 1);
//					return res;	
//				}else if(category.equalsIgnoreCase("1")) {
//					res.put("status", 0);
//					res.put("message", "Wrong mapping of station category. We are considering normal station in given financial year. Please contact to headquarter");
//				}
//			}
//		}else if(stObj.size()==0){
//			if(!category.equalsIgnoreCase("0")) {
//				res.put("status", 0);
//				res.put("message", "Station did not map as Hard/Very Hard/Ner. Please contact to headquarter");
//				return res;
//			}else {
//				res.put("status", 1);
//				return res;
//			}
//		}else if(stObj.size()==1) {
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//			LocalDate inputStartDate = LocalDate.parse(startDate, formatter);
//			LocalDate inputEndDate = LocalDate.parse(endDate, formatter);
//			Integer matchCondition=0;
//			java.time.LocalDate  fromDate=stObj.get(0).getFromDate();
//			java.time.LocalDate  toDate=stObj.get(0).getToDate();
//			
//			
//			if(fromDate !=null && inputStartDate.compareTo(fromDate) >=0 && inputEndDate.compareTo(fromDate) >=0 && toDate==null) {
//				if(String.valueOf(stObj.get(0).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("0")) {
//					res.put("status", 1);
//					return res;
//				}else if(fromDate !=null && !String.valueOf(stObj.get(0).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("1")){
//					res.put("status", 1);
//					return res;
//				}else if(fromDate !=null && String.valueOf(stObj.get(0).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("1")) {
//					res.put("status", 0);
//					res.put("message", "Wrong mapping of station category. We are considering normal station in given financial year. Please contact to headquarter");
//					return res;
//				}else if(!String.valueOf(stObj.get(0).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("0")) {
//					String stationType=null;
//					if(stObj.get(0).getCategoryId()==1) {
//						stationType ="NER";
//					}else if(stObj.get(0).getCategoryId()==2) {
//						stationType ="Priority";
//					}else if(stObj.get(0).getCategoryId()==3) {
//						stationType ="Hard";
//					}else if(stObj.get(0).getCategoryId()==4) {
//						stationType ="Very Hard";
//					}
//					res.put("status", 0);
//					res.put("message", "Wrong mapping of station category. We are considering "+stationType+" station in given financial year. Please contact to headquarter");
//					return res;
//				}
//			}else if(fromDate !=null && inputStartDate.compareTo(fromDate) <= 0 && inputEndDate.compareTo(fromDate) >=0 && toDate==null) {
//				String currentCategories=String.valueOf(stObj.get(0).getCategoryId());
//				
//				if(Integer.parseInt(currentCategories)>0) {
//					res.put("status", 1);
//					return res;
//				}else if(Integer.parseInt(currentCategories)==0 &&  category.equalsIgnoreCase("0")) {
//					res.put("status", 1);
//					return res;
//				}else if(Integer.parseInt(currentCategories)==0 &&  category.equalsIgnoreCase("1")) {
//					res.put("status", 0);
//					res.put("message", "Wrong mapping of station category. We are considering normal station in given financial year. Please contact to headquarter");
//				}
//				
//			}else if(fromDate !=null && toDate !=null && inputStartDate.compareTo(fromDate) >=0 && inputEndDate.compareTo(fromDate) >=0 ) {
//				if(String.valueOf(stObj.get(0).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("0")) {
//					res.put("status", 1);
//					return res;
//				}else if(fromDate !=null && !String.valueOf(stObj.get(0).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("1")){
//					res.put("status", 1);
//					return res;
//				}else if(fromDate !=null && String.valueOf(stObj.get(0).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("1")) {
//					res.put("status", 0);
//					res.put("message", "Wrong mapping of station category. We are considering normal station in given financial year. Please contact to headquarter");
//					return res;
//				}else if(!String.valueOf(stObj.get(0).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("0")) {
//					String stationType=null;
//					if(stObj.get(0).getCategoryId()==1) {
//						stationType ="NER";
//					}else if(stObj.get(0).getCategoryId()==2) {
//						stationType ="Priority";
//					}else if(stObj.get(0).getCategoryId()==3) {
//						stationType ="Hard";
//					}else if(stObj.get(0).getCategoryId()==4) {
//						stationType ="Very Hard";
//					}
//					res.put("status", 0);
//					res.put("message", "Wrong mapping of station category. We are considering "+stationType+" station in given financial year. Please contact to headquarter");
//					return res;
//				}
//			}else if(fromDate !=null && toDate !=null && inputStartDate.compareTo(fromDate) >=0 && inputEndDate.compareTo(toDate) <= 0) {
//				
//			}
//			
//			
////			if(String.valueOf(stObj.get(0).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("0")) {
////				res.put("status", 1);
////				return res;
////			}else if(!String.valueOf(stObj.get(0).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("1")){
////				res.put("status", 1);
////				return res;
////			}else if(String.valueOf(stObj.get(0).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("1")) {
////				res.put("status", 0);
////				res.put("message", "Wrong mapping of station category. We are considering normal station in given financial year. Please contact to headquarter");
////				return res;
////			}else if(!String.valueOf(stObj.get(0).getCategoryId()).equalsIgnoreCase("0") && category.equalsIgnoreCase("0")) {
////				String stationType=null;
////				if(stObj.get(0).getCategoryId()==1) {
////					stationType ="NER";
////				}else if(stObj.get(0).getCategoryId()==2) {
////					stationType ="Priority";
////				}else if(stObj.get(0).getCategoryId()==3) {
////					stationType ="Hard";
////				}else if(stObj.get(0).getCategoryId()==4) {
////					stationType ="Very Hard";
////				}
////				res.put("status", 0);
////				res.put("message", "Wrong mapping of station category. We are considering "+stationType+" station in given financial year. Please contact to headquarter");
////				return res;
////			}
//		}
//		
		
}catch(Exception ex) {
	ex.printStackTrace();
}
return res;
	}

}
