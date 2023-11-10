package com.example.MOERADTEACHER.common.report.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.MOERADTEACHER.common.modal.Teacher;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.security.LoginNativeRepository;

@Service
public class ReportImpl {
	@Autowired
	NativeRepository nativeRepository;

	@Autowired
	private LoginNativeRepository loginNativeRepository;
	

	public Object getSchoolListByRegion(Map<String,Object> data) throws Exception {
		String query=null;
		if(String.valueOf(data.get("reportType")).equalsIgnoreCase("N")) {
			query="select ms.school_name,ms.kv_code,ms.schooladdress ,ms2.station_code,ms2.station_name,mr.region_address ,mr.region_name,mr.region_code  from uneecops.m_schools ms left join uneecops.school_station_mapping ssm on ms.kv_code =ssm.kv_code left join uneecops.m_station ms2 on ssm.station_code =ms2.station_code left join uneecops.region_station_mapping rsm on ms2.station_code =rsm.station_code left join uneecops.m_region mr on rsm.region_code =mr.region_code where ms.school_type ='1' and ms.shift in ('0','1') and ms.school_status =true and ssm.is_active =true  and rsm.is_active =true and mr.region_type =3 and ms2.is_active =true  order by mr.region_name,ms2.station_name,ms.school_name ";
		}else if(String.valueOf(data.get("reportType")).equalsIgnoreCase("R")) {
			query="\r\n"
					+ "select ms.school_name,ms.kv_code,ms.schooladdress ,ms2.station_code,ms2.station_name,mr.region_address ,mr.region_name,mr.region_code  from uneecops.m_schools ms left join uneecops.school_station_mapping ssm on ms.kv_code =ssm.kv_code left join uneecops.m_station ms2 on ssm.station_code =ms2.station_code left join uneecops.region_station_mapping rsm on ms2.station_code =rsm.station_code left join uneecops.m_region mr on rsm.region_code =mr.region_code where ms.school_type ='1' and ms.shift in ('0','1') and ms.school_status =true and ssm.is_active =true  and rsm.is_active =true and mr.region_type =3 and ms2.is_active =true and rsm.region_code ='"+String.valueOf(data.get("regionCode"))+"' order by mr.region_name,ms2.station_name,ms.school_name ;\r\n"
					+ "";
		}
		return nativeRepository.executeQueries(query);
	}
	

	public Object getStationSchoolCountByRegion() throws Exception {
//		String query="select mr.region_name ,mr.region_code,mr.region_address,count(distinct d.station_code) as station_count,count(distinct m.kv_code) as school_count from uneecops.school_station_mapping m\r\n"
//				+ "left join uneecops.region_station_mapping d on m.station_code =d.station_code\r\n"
//				+ "left join uneecops.m_region mr on d.region_code =mr.region_code \r\n"
//				+ "where m.is_active=true and m.is_active=true \r\n"
//				+ "group by mr.region_name,mr.region_code,mr.region_address  order by mr.region_name";
		
		String query="select mr.region_name,mr.region_code,mr.region_address, count(distinct d.station_code) as station_count,count( m.kv_code) as school_count,tp2.teacher_name as controller_name,tp2.teacher_email as controller_email,tp2.teacher_mobile as controller_mobile from uneecops.school_station_mapping m\r\n"
				+ "left join uneecops.region_station_mapping d on m.station_code =d.station_code\r\n"
				+ "left join uneecops.m_region mr on d.region_code =mr.region_code \r\n"
				+ "left join public.kv_controller_officer kco on mr.region_code =kco.region_code::int and kco.is_active ='1' and kco.controller_type ='R'\r\n"
				+ "left join public.teacher_profile tp2 on tp2.teacher_employee_code =kco.employee_code \r\n"
				+ "where m.is_active=true and m.is_active=true   and mr.region_type ='3'\r\n"
				+ "group by mr.region_name,mr.region_code,mr.region_address,controller_name,controller_email,controller_mobile  order by mr.region_name ";
		
		System.out.println(query);
		
		return nativeRepository.executeQueries(query);
	}
	
	
	public Object getStationWiseSchoolCount() {
		String query="select mr.region_name,ms.station_name ,count(distinct m.kv_code) from uneecops.school_station_mapping m \r\n"
				+ "left join uneecops.m_station ms on ms.station_code =m.station_code\r\n"
				+ "left join uneecops.region_station_mapping d on m.station_code =d.station_code\r\n"
				+ "left join uneecops.m_region mr on d.region_code =mr.region_code\r\n"
				+ "where m.is_active=true and ms.is_active =true and m.is_active=true   and mr.region_type ='3'\r\n"
				+ "group by mr.region_name,ms.station_name order by region_name";
		
		return nativeRepository.executeQueries(query);
	}
	
	
}
