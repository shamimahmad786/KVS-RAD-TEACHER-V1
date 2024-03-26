package com.example.MOERADTEACHER.common.report.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.MOERADTEACHER.common.modal.KvsReport;
import com.example.MOERADTEACHER.common.modal.Teacher;
import com.example.MOERADTEACHER.common.repository.KvsReportRepository;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.security.LoginNativeRepository;

@Service
public class ReportImpl {
	@Autowired
	NativeRepository nativeRepository;

	@Autowired
	private LoginNativeRepository loginNativeRepository;

	@Autowired
	KvsReportRepository kvsReportRepository;

	public Object getSchoolListByRegion(Map<String, Object> data) throws Exception {
		String query = null;
		if (String.valueOf(data.get("reportType")).equalsIgnoreCase("N")) {
			query = "select ms.school_name,ms.kv_code,ms.schooladdress ,ms2.station_code,ms2.station_name,mr.region_address ,mr.region_name,mr.region_code  from uneecops.m_schools ms left join uneecops.school_station_mapping ssm on ms.kv_code =ssm.kv_code left join uneecops.m_station ms2 on ssm.station_code =ms2.station_code left join uneecops.region_station_mapping rsm on ms2.station_code =rsm.station_code left join uneecops.m_region mr on rsm.region_code =mr.region_code where ms.school_type ='1' and ms.shift in ('0','1') and ms.school_status =true and ssm.is_active =true  and rsm.is_active =true and mr.region_type =3 and ms2.is_active =true  order by mr.region_name,ms2.station_name,ms.school_name ";
		} else if (String.valueOf(data.get("reportType")).equalsIgnoreCase("R")) {
			query = "\r\n"
					+ "select ms.school_name,ms.kv_code,ms.schooladdress ,ms2.station_code,ms2.station_name,mr.region_address ,mr.region_name,mr.region_code  from uneecops.m_schools ms left join uneecops.school_station_mapping ssm on ms.kv_code =ssm.kv_code left join uneecops.m_station ms2 on ssm.station_code =ms2.station_code left join uneecops.region_station_mapping rsm on ms2.station_code =rsm.station_code left join uneecops.m_region mr on rsm.region_code =mr.region_code where ms.school_type ='1' and ms.shift in ('0','1') and ms.school_status =true and ssm.is_active =true  and rsm.is_active =true and mr.region_type =3 and ms2.is_active =true and rsm.region_code ='"
					+ String.valueOf(data.get("regionCode"))
					+ "' order by mr.region_name,ms2.station_name,ms.school_name ;\r\n" + "";
		}
		return nativeRepository.executeQueries(query);
	}

	public Object getStationSchoolCountByRegion() throws Exception {
//		String query="select mr.region_name ,mr.region_code,mr.region_address,count(distinct d.station_code) as station_count,count(distinct m.kv_code) as school_count from uneecops.school_station_mapping m\r\n"
//				+ "left join uneecops.region_station_mapping d on m.station_code =d.station_code\r\n"
//				+ "left join uneecops.m_region mr on d.region_code =mr.region_code \r\n"
//				+ "where m.is_active=true and m.is_active=true \r\n"
//				+ "group by mr.region_name,mr.region_code,mr.region_address  order by mr.region_name";

		String query = "select mr.region_name,mr.region_code,mr.region_address, count(distinct d.station_code) as station_count,count( m.kv_code) as school_count,tp2.teacher_name as controller_name,tp2.teacher_email as controller_email,tp2.teacher_mobile as controller_mobile from uneecops.school_station_mapping m\r\n"
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
		String query = "select mr.region_name,ms.station_name ,count(distinct m.kv_code) from uneecops.school_station_mapping m \r\n"
				+ "left join uneecops.m_station ms on ms.station_code =m.station_code\r\n"
				+ "left join uneecops.region_station_mapping d on m.station_code =d.station_code\r\n"
				+ "left join uneecops.m_region mr on d.region_code =mr.region_code\r\n"
				+ "where m.is_active=true and ms.is_active =true and m.is_active=true   and mr.region_type ='3'\r\n"
				+ "group by mr.region_name,ms.station_name order by region_name";

		return nativeRepository.executeQueries(query);
	}

	public List<KvsReport> getListOfReport() {
		return kvsReportRepository.findAllByStatusOrderByReportIdAsc(1);
	}

	public Object getUniversalReportById(Map<String, Object> mp) {

		String query = "";
		if (String.valueOf(mp.get("reportId")).equalsIgnoreCase("1000")) {
			query = "select * from z_emp_details_3107 zed left join z_ext_emp_details zeed on zed.emp_code =zeed.emp_code  where (zed.is_automated_transfer =true or zeed.is_automated_transfer =true) and zed.transfer_year='2023'  order by zed.emp_name";
		} else if (String.valueOf(mp.get("reportId")).equalsIgnoreCase("1001")) {
			query = "select * from z_emp_details_3107 zed where zed.is_admin_transfer=true and transfer_type='A' and transfer_year='2023' order by zed.emp_name";
		} else if (String.valueOf(mp.get("reportId")).equalsIgnoreCase("1002")) {
			query = "select * from z_ext_emp_details zed where transfer_type='AC' and transfer_year='2023' order by zed.emp_name";
		} else if (String.valueOf(mp.get("reportId")).equalsIgnoreCase("1003")) {
			query = "select * from z_ext_emp_details zed where transfer_type='AM' and transfer_year='2023' order by zed.emp_name";
		} else if (String.valueOf(mp.get("reportId")).equalsIgnoreCase("1004")) {
			if (String.valueOf(mp.get("region")).equals("All")) {
				query = "select tp.teaching_nonteaching,tp.teacher_gender,count(*) from\r\n" + "(\r\n"
						+ "select teaching_nonteaching,teacher_gender,kv_code from public.teacher_profile  \r\n"
						+ "where kv_code !='9999' and (drop_box_flag !='1' or drop_box_flag ='0' or drop_box_flag is null)\r\n"
						+ ")tp\r\n" + "group by teaching_nonteaching,teacher_gender";
			} else if (String.valueOf(mp.get("region")).equals("99")) {
				query = "select  mr.region_code,mr.region_name,tp.teaching_nonteaching,tp.teacher_gender,count(*) from\r\n"
						+ "(\r\n"
						+ "select teaching_nonteaching,teacher_gender,kv_code from public.teacher_profile  \r\n"
						+ "where kv_code !='9999' and (drop_box_flag !='1' or drop_box_flag ='0' or drop_box_flag is null)\r\n"
						+ ")tp\r\n"
						+ "left join (select distinct kv_code,station_code from uneecops.school_station_mapping where is_active =true) \r\n"
						+ "ssm  on tp.kv_code =ssm.kv_code\r\n"
						+ "left join (select distinct station_code,region_code from uneecops.region_station_mapping where is_active =true and mapping_type=1) rsm \r\n"
						+ " on rsm.station_code=ssm.station_code\r\n"
						+ "left join  uneecops.m_region mr on mr.region_code = rsm.region_code \r\n"
						+ "group by mr.region_code,mr.region_name ,teaching_nonteaching,teacher_gender, mr.region_type  ";
			} else {
				if (String.valueOf(mp.get("station")).equals("All")) {
					query = "select  mr.region_code,mr.region_name,tp.teaching_nonteaching,tp.teacher_gender,count(*) from\r\n"
							+ "(\r\n"
							+ "select teaching_nonteaching,teacher_gender,kv_code from public.teacher_profile  \r\n"
							+ "where kv_code !='9999' and (drop_box_flag !='1' or drop_box_flag ='0' or drop_box_flag is null)\r\n"
							+ ")tp\r\n"
							+ "left join (select distinct kv_code,station_code from uneecops.school_station_mapping where is_active =true) \r\n"
							+ "ssm  on tp.kv_code =ssm.kv_code\r\n"
							+ "left join (select distinct station_code,region_code from uneecops.region_station_mapping where is_active =true and mapping_type=1) rsm \r\n"
							+ " on rsm.station_code=ssm.station_code\r\n"
							+ "left join  uneecops.m_region mr on mr.region_code = rsm.region_code  \r\n"
							+ "group by mr.region_code,mr.region_name ,teaching_nonteaching,teacher_gender, mr.region_type  having mr.region_code = '"
							+ mp.get("region") + "'";
				} else if (String.valueOf(mp.get("station")).equals("99999")) {

					query = "select  ms.station_code ,ms.station_name ,tp.teaching_nonteaching,tp.teacher_gender,count(*) from\r\n"
							+ "(\r\n"
							+ "select teaching_nonteaching,teacher_gender,kv_code from public.teacher_profile  \r\n"
							+ "where kv_code !='9999' and (drop_box_flag !='1' or drop_box_flag ='0' or drop_box_flag is null)\r\n"
							+ ")tp\r\n"
							+ "left join (select distinct kv_code,station_code from uneecops.school_station_mapping where is_active =true) \r\n"
							+ "ssm  on tp.kv_code =ssm.kv_code\r\n"
							+ "left join (select distinct station_code,region_code from uneecops.region_station_mapping where is_active =true and mapping_type=1) rsm \r\n"
							+ " on rsm.station_code=ssm.station_code\r\n"
							+ "left join  uneecops.m_station ms on ms.station_code = rsm.station_code  \r\n"
							+ "group by ms.station_code ,ms.station_name  ,teaching_nonteaching,teacher_gender,rsm.region_code  having rsm.region_code = '"
							+ mp.get("region") + "'";
				} else {
					if (String.valueOf(mp.get("school")).equals("All")) {
						query = "select tp.teaching_nonteaching,tp.teacher_gender,count(*) from\r\n" + "(\r\n"
								+ "select teaching_nonteaching,teacher_gender,kv_code from public.teacher_profile  \r\n"
								+ "where kv_code !='9999' and (drop_box_flag !='1' or drop_box_flag ='0' or drop_box_flag is null)\r\n"
								+ ")tp\r\n"
								+ "left join (select distinct kv_code,station_code from uneecops.school_station_mapping where is_active =true) \r\n"
								+ "ssm  on tp.kv_code =ssm.kv_code\r\n"
								+ "left join (select distinct station_code,region_code from uneecops.region_station_mapping where is_active =true and mapping_type=1 ) rsm \r\n"
								+ " on rsm.station_code=ssm.station_code \r\n"
								+ "left join  uneecops.m_region mr on mr.region_code = rsm.region_code  \r\n"
								+ "group by mr.region_code,mr.region_name ,teaching_nonteaching,teacher_gender, mr.region_type,rsm.station_code  having mr.region_code = '"
								+ mp.get("region") + "' and rsm.station_code='" + mp.get("station") + "'";
					} else if (String.valueOf(mp.get("school")).equals("99999")) {
						query = "select ms.station_code,ms.station_name ,tp.teaching_nonteaching,tp.teacher_gender,count(*) from\r\n"
								+ "(\r\n"
								+ "select teaching_nonteaching,teacher_gender,kv_code from public.teacher_profile  \r\n"
								+ "where kv_code !='9999' and (drop_box_flag !='1' or drop_box_flag ='0' or drop_box_flag is null)\r\n"
								+ ")tp\r\n"
								+ "left join (select distinct kv_code,station_code from uneecops.school_station_mapping where is_active =true) \r\n"
								+ "ssm  on tp.kv_code =ssm.kv_code\r\n"
								+ "left join (select distinct station_code,region_code from uneecops.region_station_mapping where is_active =true and mapping_type=1 ) rsm \r\n"
								+ " on rsm.station_code=ssm.station_code \r\n"
								+ "left join  uneecops.m_station ms  on ms.station_code = rsm.station_code  \r\n"
								+ "group by ms.station_code,ms.station_name ,teaching_nonteaching,teacher_gender,rsm.station_code,rsm.region_code  having rsm.region_code = '"
								+ mp.get("region") + "' and rsm.station_code='" + mp.get("station") + "'";

					} else {
						query = "select teaching_nonteaching,teacher_gender,count(*) from public.teacher_profile  \r\n"
								+ "where kv_code ='" + mp.get("school")
								+ "' and (drop_box_flag !='1' or drop_box_flag ='0' or drop_box_flag is null) group by teaching_nonteaching,teacher_gender";
					}
				}
			}
		}else if(String.valueOf(mp.get("reportId")).equalsIgnoreCase("1005")) {
			if (String.valueOf(mp.get("region")).equals("All")) {
			query="select employeedropid, count(*) from public.teacher_dropbox td group by employeedropid";
			}else if(String.valueOf(mp.get("region")).equals("99")){
			query="\r\n"
					+ "  select employeedropid, mr.region_name,count(*) from public.teacher_dropbox td \r\n"
					+ " left join (select distinct kv_code,station_code from uneecops.school_station_mapping where is_active =true) \r\n"
					+ "						ssm  on td.kv_code =ssm.kv_code\r\n"
					+ "						left join (select distinct station_code,region_code from uneecops.region_station_mapping where is_active =true and mapping_type=1) rsm \r\n"
					+ "						 on rsm.station_code=ssm.station_code\r\n"
					+ "						left join  uneecops.m_region mr on mr.region_code = rsm.region_code\r\n"
					+ "						group by mr.region_name ,employeedropid";	
			}else {
				if (String.valueOf(mp.get("station")).equals("All")) {
					query="\r\n"
							+ "  select employeedropid, mr.region_name,mr.region_code,count(*) from public.teacher_dropbox td \r\n"
							+ " left join (select distinct kv_code,station_code from uneecops.school_station_mapping where is_active =true) \r\n"
							+ "						ssm  on td.kv_code =ssm.kv_code\r\n"
							+ "						left join (select distinct station_code,region_code from uneecops.region_station_mapping where is_active =true and mapping_type=1) rsm \r\n"
							+ "						 on rsm.station_code=ssm.station_code\r\n"
							+ "						left join  uneecops.m_region mr on mr.region_code = rsm.region_code\r\n"
							+ "						group by mr.region_name ,employeedropid,mr.region_code  having mr.region_code ='"+mp.get("region")+"'";	
				}else if(String.valueOf(mp.get("station")).equals("99999")) {
					query="  select ms.station_name ,employeedropid,count(*) from public.teacher_dropbox td \r\n"
							+ " left join (select distinct kv_code,station_code from uneecops.school_station_mapping where is_active =true) \r\n"
							+ "						ssm  on td.kv_code =ssm.kv_code\r\n"
							+ "						left join (select distinct station_code,region_code from uneecops.region_station_mapping where is_active =true and mapping_type=1) rsm \r\n"
							+ "						 on rsm.station_code=ssm.station_code\r\n"
							+ "						left join  uneecops.m_station ms  on ms.station_code = rsm.station_code\r\n"
							+ "						group by ms.station_name ,employeedropid,rsm.region_code having rsm.region_code='"+mp.get("region")+"'";
				}else {
					if(String.valueOf(mp.get("school")).equals("All")) {
						query=" select employeedropid,count(*) from public.teacher_dropbox td \r\n"
								+ " left join (select distinct kv_code,station_code from uneecops.school_station_mapping where is_active =true) \r\n"
								+ "						ssm  on td.kv_code =ssm.kv_code\r\n"
								+ "						left join (select distinct station_code,region_code from uneecops.region_station_mapping where is_active =true and mapping_type=1) rsm \r\n"
								+ "						 on rsm.station_code=ssm.station_code\r\n"
								+ "						left join  uneecops.m_region mr on mr.region_code = rsm.region_code\r\n"
								+ "						group by mr.region_name ,employeedropid,rsm.region_code,rsm.station_code having rsm.region_code='"+mp.get("region")+"' and rsm.station_code='"+mp.get("station")+"'";
					}else {
						query="select employeedropid,count(*) from public.teacher_dropbox td  group by employeedropid,kv_code having td.kv_code ='"+mp.get("school")+"'";
					}
				}
			}
		}

	

		return nativeRepository.executeQueries(query);

	}

}
