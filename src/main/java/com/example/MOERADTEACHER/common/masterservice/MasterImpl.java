package com.example.MOERADTEACHER.common.masterservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.MOERADTEACHER.common.bean.MasterBean;
import com.example.MOERADTEACHER.common.masterbean.PositionType;
import com.example.MOERADTEACHER.common.masterbean.RegionMaster;
import com.example.MOERADTEACHER.common.masterbean.SchoolMaster;
import com.example.MOERADTEACHER.common.masterbean.StationBean;
import com.example.MOERADTEACHER.common.masterbean.StationMaster;
import com.example.MOERADTEACHER.common.masterbean.SubjectMaster;
import com.example.MOERADTEACHER.common.masterbean.TeacherAwardsMaster;
import com.example.MOERADTEACHER.common.masterbean.TeacherQualification;
import com.example.MOERADTEACHER.common.masterbean.TransferGround;
import com.example.MOERADTEACHER.common.masterrepository.PositionTypeRepository;
import com.example.MOERADTEACHER.common.masterrepository.RegionMasterRepository;
import com.example.MOERADTEACHER.common.masterrepository.SchoolMasterRepository;
import com.example.MOERADTEACHER.common.masterrepository.StationMasterRepository;
import com.example.MOERADTEACHER.common.masterrepository.SubjectMastersRepository;
import com.example.MOERADTEACHER.common.masterrepository.TeacherAwardsMasterRepository;
import com.example.MOERADTEACHER.common.masterrepository.TeacherQualificationRepository;
import com.example.MOERADTEACHER.common.masterrepository.TransferGroundRepository;
import com.example.MOERADTEACHER.common.modal.Master;
import com.example.MOERADTEACHER.common.modal.Teacher;
import com.example.MOERADTEACHER.common.repository.MasterRepository;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;
import com.example.MOERADTEACHER.common.util.StaticReportBean;
//import com.me.user.UserService.db.QueryResult;
//import com.me.user.UserService.db.NativeRepository;

@Service
public class MasterImpl {

	@Autowired
	NativeRepository nativeRepository;
	@Autowired
	MasterRepository masterRepository;
	@Autowired
	PositionTypeRepository  positionTypeRepository;
	@Autowired
	TeacherQualificationRepository teacherQualificationRepository;
	
	@Autowired
	TeacherAwardsMasterRepository teacherAwardsMasterRepository;
	
	@Autowired
	RegionMasterRepository regionMasterRepository;
	
	@Autowired
	StationMasterRepository stationMasterRepository;
	
	@Autowired
	SchoolMasterRepository schoolMasterRepository;
	
	@Autowired
	SubjectMastersRepository  subjectMastersRepository;
	
	@Autowired
	TransferGroundRepository transferGroundRepository;
	
	public StaticReportBean getMaster(MasterBean data) throws Exception {
		String query="";
		Master mobj=	masterRepository.findAllByExtcall(data.getExtcall());
		
	if(data.getConditionvalue().size()>0) {
		
		 query="select "+mobj.getColumnname() +" from "+ mobj.getTablename() +" where "+mobj.getConditions();
		
		 for(int i=0;i<data.getConditionvalue().size();i++) {
//   		  if(otpBeansData.getDynamicData().get(i).equalsIgnoreCase("OTP")) {
//   			  otps=getOpt().toString();
			 // System.out.println(data.getConditionvalue().get(i));
			 
			 query=query.replace("<V"+(i+1)+">", data.getConditionvalue().get(i).toString());
//   		  }else {
//   			  message=message.replace("<V"+(i+1)+">", otpBeansData.getDynamicData().get(i));  
//   		  }
   	  }
		 
	}else {
		 query="select "+mobj.getColumnname() +" from "+ mobj.getTablename();
	}
		  System.out.println("final Query---->"+query);
		
		StaticReportBean sObj=new StaticReportBean();
		// System.out.println("In get District");
		QueryResult qrObj = nativeRepository.executeQueries(query);
		sObj.setColumnName(qrObj.getColumnName());
		sObj.setRowValue(qrObj.getRowValue());
		sObj.setColumnDataType(qrObj.getColumnDataType());
		sObj.setStatus("1");
		return sObj;
	}
	
	
	public StaticReportBean getMaster1(MasterBean data) throws Exception {
		String query="";
		Master mobj=	masterRepository.findAllByExtcall(data.getExtcall());
		
	if(data.getConditionvalue().size()>0) {
		
		 query="select "+mobj.getColumnname() +" from "+ mobj.getTablename() +" where "+mobj.getConditions();
		
		 for(int i=0;i<data.getConditionvalue().size();i++) {
//   		  if(otpBeansData.getDynamicData().get(i).equalsIgnoreCase("OTP")) {
//   			  otps=getOpt().toString();
			 // System.out.println(data.getConditionvalue().get(i));
			 
			 query=query.replace("<V"+(i+1)+">", data.getConditionvalue().get(i).toString());
//   		  }else {
//   			  message=message.replace("<V"+(i+1)+">", otpBeansData.getDynamicData().get(i));  
//   		  }
   	  }
		 
	}else {
		 query="select "+mobj.getColumnname() +" from "+ mobj.getTablename();
	}
		  System.out.println("final Query---->"+query);
		
		StaticReportBean sObj=new StaticReportBean();
		// System.out.println("In get District");
		QueryResult qrObj = nativeRepository.executeQueries(query);
		sObj.setColumnName(qrObj.getColumnName());
		sObj.setRowValue(qrObj.getRowValue());
		sObj.setColumnDataType(qrObj.getColumnDataType());
		sObj.setStatus("1");
		return sObj;
	}
	
	
	
	 @Cacheable(value="master")
	public List<PositionType> getPsitionType(Integer configuredBusinessUnitTypeId) throws Exception {
		return positionTypeRepository.findAllByConfiguredBusinessUnitTypeId(configuredBusinessUnitTypeId);
	}
	 
	 
	 @Cacheable(value="master")
		public HashMap<String, Object> getAllMaster(Integer configuredBusinessUnitTypeId) throws Exception {
		 HashMap<String,Object> mp=new HashMap<String,Object>();
		 if(configuredBusinessUnitTypeId.equals(6)) {
		 mp.put("postionType", positionTypeRepository.findByConfiguredBusinessUnitTypeIdAndActiveStatusOrderByOrganizationTeacherTypeNameAsc(configuredBusinessUnitTypeId,"A"));
		 }else if(configuredBusinessUnitTypeId.equals(1)) {
			 mp.put("postionType", positionTypeRepository.findByConfiguredBusinessUnitTypeIdOrderByOrganizationTeacherTypeNameAsc(6));	 
		 }
		 System.out.println(mp);
		 return mp;
		} 
	 
	 
	 public StaticReportBean getSubjectByTeacherTypeId(String applicationId,String teacherTypeId) throws Exception {
		 
		 StaticReportBean sObj=new StaticReportBean();
		 if(teacherTypeId !=null) {
		 
			    String query="select *\r\n"
			    		+ "from master.configured_position_subject_map cpsm , master.mst_teacher_position_type mtpt , master.mst_teacher_subject mts\r\n"
			    		+ "where mtpt.teacher_type_id = cpsm.teacher_type_id\r\n"
			    		+ "and cpsm.subject_id = mts.subject_id\r\n"
			    		+ "and mtpt.application_id = '"+applicationId+"'\r\n"
			    		+ "and mtpt.teacher_type_id = '"+Integer.parseInt(teacherTypeId) +"' order by subject_name";
			    
			    System.out.println("getSubjectByTeacherTypeId--->"+query);
				QueryResult qrObj = nativeRepository.executeQueries(query);
				sObj.setColumnName(qrObj.getColumnName());
				sObj.setRowValue(qrObj.getRowValue());
				sObj.setColumnDataType(qrObj.getColumnDataType());
				sObj.setStatus("1");
		 }
				return sObj;

		 
	 }
	 
	 
	 public StaticReportBean getSchoolDetailsByKVCode(String data) throws Exception {
		 StaticReportBean sObj=new StaticReportBean();
		String query="select * from kv.kv_school_master where kv_code='"+data+"'";
		
		// System.out.println("Query--->"+query);
		
			QueryResult qrObj = nativeRepository.executeQueries(query);
			sObj.setColumnName(qrObj.getColumnName());
			sObj.setRowValue(qrObj.getRowValue());
			sObj.setColumnDataType(qrObj.getColumnDataType());
			sObj.setStatus("1");
			return sObj;			 
		 }
	 
	 
	 public List<TeacherQualification> getQualificationByType(String data) throws Exception {
		 return teacherQualificationRepository.findAllByQualificationType(data);		 
		 }
	 
	 
	 
public StaticReportBean getSubjectByQualification(String degressId) throws Exception {
		 
		 StaticReportBean sObj=new StaticReportBean();
			    String query="select tqs.* from master.teacher_qual_subject tqs , master.teacher_qual_subject_map tqsm where tqsm.qualification_degree_id ="+Integer.parseInt(degressId)+" and tqs.teacher_qual_subject_id =tqsm.teacher_qual_subject_id";
				QueryResult qrObj = nativeRepository.executeQueries(query);
				sObj.setColumnName(qrObj.getColumnName());
				sObj.setRowValue(qrObj.getRowValue());
				sObj.setColumnDataType(qrObj.getColumnDataType());
				sObj.setStatus("1");
				return sObj;

		 
	 }

public List<TeacherAwardsMaster> getAwards() throws Exception {
	 return teacherAwardsMasterRepository.findAll();		 
	 }

public StaticReportBean getState() throws Exception {
	 StaticReportBean sObj=new StaticReportBean();
	    String query="select * from master.mst_state_live order by state_name";
		QueryResult qrObj = nativeRepository.executeQueries(query);
		sObj.setColumnName(qrObj.getColumnName());
		sObj.setRowValue(qrObj.getRowValue());
		sObj.setColumnDataType(qrObj.getColumnDataType());
		sObj.setStatus("1");
		return sObj;	
}

public StaticReportBean getDistrictByStateId(Integer stateId) throws Exception {
	 StaticReportBean sObj=new StaticReportBean();
	    String query="select * from master.mst_district_live where state_id="+stateId+" order by district_name";
		QueryResult qrObj = nativeRepository.executeQueries(query);
		sObj.setColumnName(qrObj.getColumnName());
		sObj.setRowValue(qrObj.getRowValue());
		sObj.setColumnDataType(qrObj.getColumnDataType());
		sObj.setStatus("1");
		return sObj;	
}

//@Cacheable(value="master")
public QueryResult getKVRegion() throws Exception {
	QueryResult qrObj =null;
	try {
	String query="select distinct region_name,region_code from kv.kv_school_master ksm order by region_name";
	qrObj = nativeRepository.executeQueries(query);
	}catch(Exception ex) {
		ex.printStackTrace();
	}
//	return regionMasterRepository.findByOrderByRegionNameAsc();
	return qrObj;
}

public QueryResult getKVRegions(String schoolType) throws Exception {
	QueryResult qrObj =null;
	List<Map<String, Object>> lMapObj=new ArrayList<Map<String, Object>>();
	try {
		System.out.println("schoolType--->"+schoolType);
	String query="select distinct on (region_name) region_name,region_code,kv_code from kv.kv_school_master ksm where ksm.school_type='"+schoolType+"' and school_status='1' order by region_name";
	qrObj = nativeRepository.executeQueries(query);
	
	for(int i=0;i<qrObj.getRowValue().size();i++) {
		Map<String,Object> mp=new HashMap<String,Object>();
		mp.put("regionCode", qrObj.getRowValue().get(i).get("region_code"));
		mp.put("regionName", qrObj.getRowValue().get(i).get("region_name"));
		mp.put("kvCode", qrObj.getRowValue().get(i).get("kv_code"));
		mp.put("kvName", qrObj.getRowValue().get(i).get("kv_name"));
		lMapObj.add(mp);
	}
	qrObj.setRowValue(lMapObj);
	
	}catch(Exception ex) {
		ex.printStackTrace();
	}
//	return regionMasterRepository.findByOrderByRegionNameAsc();
	return qrObj;
}


public StaticReportBean getOnlyKVRegion() throws Exception {
	 StaticReportBean sObj=new StaticReportBean();
String	 Query="select region_code,region_name,count(*) as no_of_school from kv.kv_school_master ksm where ksm.status ='0'  and ksm.school_type ='1'  group by region_code,region_name order by region_name  ";
		QueryResult qrObj = nativeRepository.executeQueries(Query);
		sObj.setColumnName(qrObj.getColumnName());
		sObj.setRowValue(qrObj.getRowValue());
		sObj.setColumnDataType(qrObj.getColumnDataType());
		sObj.setStatus("1");
		return sObj;	
	//return regionMasterRepository.findByOrderByRegionNameAsc();
}



//@Cacheable(value="master")
public List<StationMaster> getStationByRegion(String resionCode) throws Exception {
//	return null;
	 System.out.println("resionCode--->"+resionCode);
	return stationMasterRepository.findByRegionCodeOrderByStationNameAsc(resionCode);
}

//@Cacheable(value="master")
public List<SchoolMaster> getSchoolByStation(String stationCode) throws Exception {
	return schoolMasterRepository.findByStationCodeOrderByKvNameAsc(stationCode);
}


public List<Map<Object,Object>> getSchoolByMultipleStation(StationBean data) throws Exception {
	List<Map<Object,Object>> ltObj=new LinkedList<Map<Object,Object>>();
	
	for(int i=0;i<data.getStationList().size();i++) {
		HashMap<Object,Object> mp=new HashMap<Object,Object>(); 
		mp.put("key", data.getStationList().get(i));
		mp.put("value", schoolMasterRepository.findAllByStationCode(String.valueOf(data.getStationList().get(i))));
		ltObj.add(mp);
	}
	
	return ltObj;
}


public Map<Integer,String> getPostNameAndTeacherTypeId(){
	List<PositionType> pObj=positionTypeRepository.findAll();
	Map<Integer,String> postionMap= new HashMap<Integer,String>();
	pObj.stream().forEach(x -> {
		postionMap.put(Integer.parseInt(String.valueOf(x.getTeacherTypeId())), x.getOrganizationTeacherTypeName());
		
	});
	return postionMap;
}


public Map<Integer,String> getSubjectName() {
	List<SubjectMaster> sObj=subjectMastersRepository.findAll();
	
	System.out.println("sObj--->"+sObj);
	
	Map<Integer,String> subjectMap= new HashMap<Integer,String>();
	sObj.stream().forEach(x -> {
		subjectMap.put(Integer.parseInt(String.valueOf(x.getSubjectId())), x.getSubjectName());
		
	});
	return subjectMap;
}


public List<TransferGround> getTransferGround(){
	return transferGroundRepository.findAll();
}






	 
	 
	
	
}
