package com.example.MOERADTEACHER.common.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.MOERADTEACHER.common.bean.ExperienceBean;
import com.example.MOERADTEACHER.common.interfaces.ExperienceInterface;
import com.example.MOERADTEACHER.common.modal.TeacherExperience;
import com.example.MOERADTEACHER.common.modal.TeacherTransferGround;
import com.example.MOERADTEACHER.common.repository.TeacherExperienceRepository;
import com.example.MOERADTEACHER.common.repository.TeacherTransferGroundRepository;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ExperienceImpl implements ExperienceInterface{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExperienceImpl.class);

	@Autowired
	TeacherExperienceRepository  teacherExperienceRepository;
	
	@Autowired
	TeacherImpl  teacherImpl;
	
	@Autowired
	NativeRepository nativeRepository;
	
	@Autowired
	TeacherTransferGroundRepository   teacherTransferGroundRepository;
	
	
	
	@Override
	public List<TeacherExperience> saveExperience(List<TeacherExperience> data) {
		System.out.println("groundTransfer--->");
		List<TeacherExperience> lt=new ArrayList<TeacherExperience>();
		if(data.size()>0) {
		teacherTransferGroundRepository.deleteAllByTeacherId(Integer.parseInt(String.valueOf(data.get(0).getTeacherId())));
		}
		for(int i=0;i<data.size();i++) {
			try {
			if(data.get(i).getCurrentlyActiveYn() !=null && data.get(i).getCurrentlyActiveYn().equalsIgnoreCase("1")) {
				
				try {
			
					nativeRepository.updateQueries("update teacher_profile set  work_experience_work_start_date_present_kv='"+new SimpleDateFormat("yyyy-MM-dd").format(data.get(i).getWorkStartDate())+"',last_promotion_position_type='"+data.get(i).getPositionType()+"',work_experience_appointed_for_subject='"+data.get(i).getAppointedForSubject()+"',nature_of_appointment='"+data.get(i).getNatureOfAppointment()+"' where teacher_id="+data.get(i).getTeacherId());
					}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			Integer workExperienceId=0;
			System.out.println("work exprience id--->"+data.get(i).getWorkExperienceId());
			if(data.get(i).getWorkExperienceId()==null  || !(data.get(i).getWorkExperienceId()>0)) {
				System.out.println("work exprience id in if");
				
				QueryResult qrObj=nativeRepository.executeQueries("select nextval('teacher_work_experience_id3_seq')");
//				QueryResult qrObj=nativeRepository.executeQueries("select  max(work_experience_id)  from public.teacher_work_experience");
				
				if(qrObj.getRowValue().size()>0) {
//				workExperienceId=Integer.parseInt(String.valueOf(qrObj.getRowValue().get(0).get("max")));
				workExperienceId=Integer.parseInt(String.valueOf(qrObj.getRowValue().get(0).get("nextval")));
					
				}
				workExperienceId  =workExperienceId;
				data.get(i).setWorkExperienceId(workExperienceId);
			}
			

//				
//			}catch(Exception ex) {
//				ex.printStackTrace();
//			}
			
			
			TeacherExperience tObject =teacherExperienceRepository.save(data.get(i));
//			tObject.setGroundForTransfer(groundTransfer);
			
			lt.add(tObject);
			
		}
		
		return lt;
	}
	
	@Override
	public TeacherExperience saveExperience(TeacherExperience data) {
		Integer workExperienceId=0;
		if(data.getWorkExperienceId()==null  || !(data.getWorkExperienceId()>0)) {
			QueryResult qrObj=nativeRepository.executeQueries("select  max(work_experience_id)  from public.teacher_work_experience");
			// System.out.println(qrObj);
			if(qrObj.getRowValue().size()>0 && qrObj.getRowValue().get(0).get("max") !=null) {
				//System.out.println(String.valueOf(qrObj.getRowValue().get(0).get("max")));
			workExperienceId=Integer.parseInt(String.valueOf(qrObj.getRowValue().get(0).get("max")));
			}else if(qrObj.getRowValue().get(0).get("max")==null) {
				workExperienceId=1;
			}
			workExperienceId  =workExperienceId+1;
			data.setWorkExperienceId(workExperienceId);
		}
//		List groundTransfer=data.getGroundForTransfer();
//		try {
//			if(groundTransfer !=null) {
//			for(int i=0;i<groundTransfer.size();i++) {
//				TeacherTransferGround  tObj=new TeacherTransferGround();
//				tObj.setTeacherId(data.getTeacherId());
//				tObj.setTransferGroundId(Integer.parseInt(String.valueOf(groundTransfer.get(i))));
//				tObj.setWorkExperienceId(data.getWorkExperienceId());
//				teacherTransferGroundRepository.save(tObj);	
//			}
//			}
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}
		
		TeacherExperience tObject =teacherExperienceRepository.save(data);
		
//		tObject.setGroundForTransfer(groundTransfer);
		return tObject;
	}
	
	
	@Override
	public List<ExperienceBean> getExperienceByTeacherId(Integer data) {
		
		List<ExperienceBean> lt= new LinkedList<ExperienceBean>();
		
		String query="				 select \r\n"
				+ "				 twe.work_experience_id,\r\n"
				+ "twe.teacher_id,\r\n"
				+ "twe.udise_sch_code,\r\n"
				+ "twe.school_id,\r\n"
				+ "twe.work_start_date,\r\n"
				+ "twe.work_end_date,\r\n"
				+ "twe.position_type,\r\n"
				+ "twe.nature_of_appointment,\r\n"
				+ "twe.appointed_for_subject,\r\n"
				+ "twe.shift_type,\r\n"
				+ "twe.shift_yn,\r\n"
				+" twe.kv_code, "
				+ "twe.verify_flag,\r\n"
				+ "twe.verified_type,\r\n"
				+ "twe.created_by,\r\n"
				+ "twe.created_time,\r\n"
				+ "twe.modified_by,\r\n"
				+ "twe.modified_time,\r\n"
				+ "twe.experience_type,\r\n"
				+ "twe.ground_for_transfer,\r\n"
				+ "twe.currently_active_yn,\r\n"
				+ "k.kv_name as udise_school_name\r\n"
				+ "				 from public.teacher_work_experience twe , kv.kv_school_master k \r\n"
				+ "				 where twe.udise_sch_code = k.kv_code \r\n"
				+ "				 and twe.teacher_id = "+data +" order by work_start_date desc";
//System.out.println(query);
		QueryResult qrObj=nativeRepository.executeQueries(query);
//		return teacherExperienceRepository.findAllByTeacherId(data);
		ObjectMapper mapperObj = new ObjectMapper();
//		List<TeacherExperience> expObj=new ArrayList<TeacherExperience>();
		
//		if(qrObj !=null) {
		final ObjectMapper mapper = new ObjectMapper();
//			System.out.println("Experience Size--->"+qrObj.getRowValue().size());
		for(int i=0;i<qrObj.getRowValue().size();i++) {
			final ExperienceBean pojo = mapper.convertValue(qrObj.getRowValue().get(i), ExperienceBean.class);
			lt.add(pojo);
		}
//			final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
//			
//			
//			// System.out.println(qrObj.getRowValue().get(i).get("work_experience_id"));
//			
//			QueryResult qrObj1=nativeRepository.executeQueries("select transfer_ground_id from public.teacher_transfer_ground where work_experienceid="+qrObj.getRowValue().get(i).get("work_experience_id"));
//			ArrayList groundArray=new ArrayList<Integer>();
//			List<ArrayList> lts=new ArrayList<ArrayList>();
//			// System.out.println("size--->"+qrObj1.getRowValue().size());
//			for(int j=0;j<qrObj1.getRowValue().size();j++) {
//				
//				// System.out.println(qrObj1.getRowValue().get(j).get("transfer_ground_id"));
//				
//				groundArray.add(Integer.parseInt(String.valueOf(qrObj1.getRowValue().get(j).get("transfer_ground_id"))));
//			}
//			
//			final ExperienceBean pojo = mapper.convertValue(qrObj.getRowValue().get(i), ExperienceBean.class);
//			lts.add(groundArray);
//			pojo.setGround_for_transfer(lts);
//			lt.add(pojo);
//		}
//		}
		
//		return teacherExperienceRepository.findByTeacherIdOrderByWorkStartDateDesc(data);
		return lt;
		
	}
	
	
	@Override
	public Map<String,Object> deleteByWorkExperienceId(Integer id) {
		Map<String,Object> mp=new HashMap<String,Object>();
		if(id !=null) {
		 teacherExperienceRepository.deleteById(id);
		mp.put("status", 1);
		}
		return mp;
	}
	
	
	
	
	
}
