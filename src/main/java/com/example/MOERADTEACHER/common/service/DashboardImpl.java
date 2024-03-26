package com.example.MOERADTEACHER.common.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.bean.DashboardBean;
import com.example.MOERADTEACHER.common.bean.DashboardEmployeeProfileBean;
import com.example.MOERADTEACHER.common.bean.KvsDashboardBean;
import com.example.MOERADTEACHER.common.interfaces.DashboardInterface;
import com.example.MOERADTEACHER.common.modal.KvsReport;
import com.example.MOERADTEACHER.common.modal.TeacherExperience;
import com.example.MOERADTEACHER.common.repository.KvsReportRepository;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;
import com.example.MOERADTEACHER.security.LoginNativeRepository;

@Service
public class DashboardImpl implements DashboardInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(DashboardImpl.class);

	@Autowired
	NativeRepository nativeRepository;
	
	@Autowired
	KvsReportRepository kvsReportRepository;
	
	@Autowired
	LoginNativeRepository  loginNativeRepository;

	@Override
	public Map<Object, Object> getDashboard(DashboardBean data) {

		List<TeacherExperience> lt = new ArrayList<TeacherExperience>();

		Map<Object, Object> mp = new HashMap<Object, Object>();
		try {
			String str1 = null;
			String str2 = null;

			if (data.getBusinessUnitTypeId().equalsIgnoreCase("2")) {
				str1 = "1";
				str2 = "1";
			} else if (data.getBusinessUnitTypeId().equalsIgnoreCase("3")) {
				str1 = "region_code";
				str2 = data.getBusinessUnitTypeCode();
			} else if (data.getBusinessUnitTypeId().equalsIgnoreCase("4")) {
				str1 = "station_code";
				str2 = data.getBusinessUnitTypeCode();
			} else if (data.getBusinessUnitTypeId().equalsIgnoreCase("5")) {
				str1 = "udise_sch_code";
				str2 = data.getBusinessUnitTypeCode();
			}

//					if(data.getBusinessUnitTypeId().equalsIgnoreCase("2")) {
			String query = "select\r\n" + "sum(no_of_region) filter (where rgid = 1) as no_of_region,\r\n"
					+ "sum(no_of_region) filter (where rgid = 2) as no_of_station,\r\n"
					+ "sum(no_of_region) filter (where rgid = 3) as no_of_school\r\n" + "from (\r\n" + "\r\n"
					+ "select count(* ) as no_of_region , 1 as rgid from (\r\n"
					+ "select distinct region_code  from kv.kv_school_master k  where " + str1 + "='" + str2 + "'\r\n"
					+ ") rg\r\n" + "union\r\n" + "select count(*) as no_of_region , 2 as rgid from\r\n"
					+ "(select distinct k.station_code  from kv.kv_school_master k  where " + str1 + "='" + str2
					+ "'\r\n" + ") stn\r\n" + "union\r\n" + "\r\n"
					+ "select count(*) as no_of_region ,3 as rgid from\r\n"
					+ "(select distinct k.kv_code  from kv.kv_school_master k   where " + str1 + "='" + str2 + "'\r\n"
					+ ") sch\r\n" + ") dashcount";
			QueryResult qrObj = nativeRepository.executeQueries(query);

			mp.put("noOfRegion", qrObj.getRowValue().get(0).get("no_of_region"));
			mp.put("noOfStation", qrObj.getRowValue().get(0).get("no_of_station"));
			mp.put("noOfSchool", qrObj.getRowValue().get(0).get("no_of_school"));

			String query1 = "select count(*) as total_teacher,\r\n"
					+ "  count(*) filter ( where  tp.nature_of_appointment  = '1' and tp.teaching_nonteaching= '1'  ) as teaching_regular,\r\n"
					+ "  count(*) filter ( where  tp.nature_of_appointment  = '2' and tp.teaching_nonteaching  = '1') as teaching_contractual,\r\n"
					+ "  count(*) filter ( where  tp.nature_of_appointment  = '1' and tp.teaching_nonteaching= '2'  ) as nonteaching_regular,\r\n"
					+ "  count(*) filter ( where  tp.nature_of_appointment  = '2' and tp.teaching_nonteaching  = '2') as nonteaching_contractual,\r\n"
					+ "\r\n"
					+ "  count(*) filter ( where  tp.teaching_nonteaching  = '1' and tfs.final_status= 'TI') as teaching_ti ,\r\n"
					+ "  count(*) filter ( where  tp.teaching_nonteaching  = '1' and tfs.final_status= 'TA') as teaching_ta,\r\n"
					+ "  count(*) filter ( where  tp.teaching_nonteaching  = '1' and tfs.final_status= 'SI') as teaching_si,\r\n"
					+ "  count(*) filter ( where  tp.teaching_nonteaching  = '1' and tfs.final_status= 'SA') as teaching_sa,\r\n"
					+ "  count(*) filter ( where  tp.teaching_nonteaching  = '1' and tfs.final_status is null) as teaching_ni,\r\n"
					+ " \r\n" + " \r\n"
					+ "  count(*) filter ( where  tp.teaching_nonteaching  = '2' and tfs.final_status= 'TI') as nonteaching_ti ,\r\n"
					+ "  count(*) filter ( where  tp.teaching_nonteaching  = '2' and tfs.final_status= 'TA') as nonteaching_ta,\r\n"
					+ "  count(*) filter ( where  tp.teaching_nonteaching  = '2' and tfs.final_status= 'SI') as nonteaching_si,\r\n"
					+ "  count(*) filter ( where  tp.teaching_nonteaching  = '2' and tfs.final_status= 'SA') as nonteaching_sa,\r\n"
					+ "  count(*) filter ( where  tp.teaching_nonteaching  = '2' and tfs.final_status is null) as nonteaching_ni\r\n"
					+ " \r\n"
					+ "from public.teacher_profile tp , kv.kv_school_master k , public.teacher_form_status tfs\r\n"
					+ "where " + str1 + "='" + str2 + "'\r\n" + "and tp.current_udise_sch_code = k.udise_sch_code\r\n"
					+ "and tfs.teacher_id = tp.teacher_id";
			QueryResult qrObj1 = nativeRepository.executeQueries(query1);

			mp.put("totalTeacher", qrObj1.getRowValue().get(0).get("total_teacher"));
			mp.put("teachingRegular", qrObj1.getRowValue().get(0).get("teaching_regular"));
			mp.put("teachingContractual", qrObj1.getRowValue().get(0).get("teaching_contractual"));
			mp.put("nonteachingRegular", qrObj1.getRowValue().get(0).get("nonteaching_regular"));
			mp.put("nonteachingContractual", qrObj1.getRowValue().get(0).get("nonteaching_contractual"));
			mp.put("teachingTi", qrObj1.getRowValue().get(0).get("teaching_ti"));
			mp.put("teachingTa", qrObj1.getRowValue().get(0).get("teaching_ta"));
			mp.put("teachingSi", qrObj1.getRowValue().get(0).get("teaching_si"));
			mp.put("teachingSa", qrObj1.getRowValue().get(0).get("teaching_sa"));
			mp.put("teachingNi", qrObj1.getRowValue().get(0).get("teaching_ni"));
			mp.put("nonteachingTi", qrObj1.getRowValue().get(0).get("nonteaching_ti"));
			mp.put("nonteachingTa", qrObj1.getRowValue().get(0).get("nonteaching_ta"));
			mp.put("nonteachingSi", qrObj1.getRowValue().get(0).get("nonteaching_si"));
			mp.put("nonteachingSa", qrObj1.getRowValue().get(0).get("nonteaching_sa"));
			mp.put("nonteachingNi", qrObj1.getRowValue().get(0).get("nonteaching_ni"));

//					}
		} catch (Exception ex) {
			LOGGER.warn("message", ex);
		}

		return mp;
	}

	@Override
	public List<Map<String, Object>> getDashboardBasicCountDetails(Map<Object, Object> mp) {
		System.out.println(mp.get("reportflag") + "---" + mp.get("reportvalue"));
		String query = null;
		if (mp.get("reportflag").equals("A")) {
			query = " select * from\r\n"
					+ "(select count(*) as no_of_region from (select region_code from transfer.dashboardviewone v group by v.region_code ) no_regn) aa,\r\n"
					+ "(select count(*) as no_of_station from ( select station_code from transfer.dashboardviewone v group by v.station_code ) no_station) bb ,\r\n"
					+ "(select count(*) as no_of_school from ( select kv_code  from transfer.dashboardviewone v group by v.kv_code ) no_of_kv) cc ,\r\n"
					+ "(select\r\n" + "total_staff_all ,\r\n" + "total_staff_all_m ,\r\n" + "total_staff_all_f ,\r\n"
					+ "total_teacher_all ,\r\n" + "total_teacher_m ,\r\n" + "total_teacher_f ,\r\n"
					+ "total_teacher_initiated_m ,\r\n" + "total_teacher_initiated_f ,\r\n"
					+ "total_teacher_approved_m ,\r\n" + "total_teacher_approved_f ,\r\n"
					+ "total_teacher_school_initiated_m ,\r\n" + "total_teacher_school_initiated_f ,\r\n"
					+ "total_teacher_school_edited_m ,\r\n" + "total_teacher_school_edited_f ,\r\n"
					+ "total_teacher_school_approved_m ,\r\n" + "total_teacher_school_approved_f ,\r\n"
					+ "total_non_teacher_all ,\r\n" + "total_non_teacher_m ,\r\n" + "total_non_teacher_f ,\r\n"
					+ "total_non_teacher_initiated_m ,\r\n" + "total_non_teacher_initiated_f ,\r\n"
					+ "total_non_teacher_approved_m ,\r\n" + "total_non_teacher_approved_f ,\r\n"
					+ "total_non_teacher_school_initiated_m ,\r\n" + "total_non_teacher_school_initiated_f ,\r\n"
					+ "total_non_teacher_school_edited_m ,\r\n" + "total_non_teacher_school_edited_f ,\r\n"
					+ "total_non_teacher_school_approved_m ,\r\n" + "total_non_teacher_school_approved_f ,\r\n"
					+ "not_initiatedat_any_level ,\r\n" + "total_teacher_not_initiatedat_any_level_m ,\r\n"
					+ "total_teacher_not_initiatedat_any_level_f ,\r\n" + "total_teacher_dropbox_teacher_m ,\r\n"
					+ "total_teacher_dropbox_teacher_f ,\r\n" + "total_non_teacher_not_initiatedat_any_level_m ,\r\n"
					+ "total_non_teacher_not_initiatedat_any_level_f ,\r\n"
					+ "total_non_teacher_dropbox_teacher_m ,\r\n" + "total_non_teacher_dropbox_teacher_f ,\r\n"
					+ "dropbox\r\n" + "\r\n" + "  from ( select\r\n" + " sum(total_staff_all)  as  total_staff_all,\r\n"
					+ " sum(total_staff_all_m)  as  total_staff_all_m   ,\r\n"
					+ " sum(total_staff_all_f)  as  total_staff_all_f   ,\r\n"
					+ "sum(total_teacher_all)  as  total_teacher_all,\r\n"
					+ "sum(total_teacher_m)  as  total_teacher_m,\r\n"
					+ "sum(total_teacher_f)  as  total_teacher_f,\r\n"
					+ "sum(total_teacher_initiated_m)  as  total_teacher_initiated_m,\r\n"
					+ "sum(total_teacher_initiated_f)  as  total_teacher_initiated_f,\r\n"
					+ "sum(total_teacher_approved_m)  as  total_teacher_approved_m,\r\n"
					+ "sum(total_teacher_approved_f)  as  total_teacher_approved_f,\r\n"
					+ "sum(total_teacher_school_initiated_m)  as  total_teacher_school_initiated_m,\r\n"
					+ "sum(total_teacher_school_initiated_f)  as  total_teacher_school_initiated_f,\r\n"
					+ "sum(total_teacher_school_edited_m)  as  total_teacher_school_edited_m,\r\n"
					+ "sum(total_teacher_school_edited_f)  as  total_teacher_school_edited_f,\r\n"
					+ "sum(total_teacher_school_approved_m)  as  total_teacher_school_approved_m,\r\n"
					+ "sum(total_teacher_school_approved_f)  as  total_teacher_school_approved_f,\r\n"
					+ "sum(total_non_teacher_all)  as  total_non_teacher_all,\r\n"
					+ "sum(total_non_teacher_m)  as  total_non_teacher_m,\r\n"
					+ "sum(total_non_teacher_f)  as  total_non_teacher_f,\r\n"
					+ "sum(total_non_teacher_initiated_m)  as  total_non_teacher_initiated_m,\r\n"
					+ "sum(total_non_teacher_initiated_f)  as  total_non_teacher_initiated_f,\r\n"
					+ "sum(total_non_teacher_approved_m)  as  total_non_teacher_approved_m,\r\n"
					+ "sum(total_non_teacher_approved_f)  as  total_non_teacher_approved_f,\r\n"
					+ "sum(total_non_teacher_school_initiated_m)  as  total_non_teacher_school_initiated_m,\r\n"
					+ "sum(total_non_teacher_school_initiated_f)  as  total_non_teacher_school_initiated_f,\r\n"
					+ "sum(total_non_teacher_school_edited_m)  as  total_non_teacher_school_edited_m,\r\n"
					+ "sum(total_non_teacher_school_edited_f)  as  total_non_teacher_school_edited_f,\r\n"
					+ "sum(total_non_teacher_school_approved_m)  as  total_non_teacher_school_approved_m,\r\n"
					+ "sum(total_non_teacher_school_approved_f)  as  total_non_teacher_school_approved_f,\r\n"
					+ "sum(not_initiatedat_any_level)  as  not_initiatedat_any_level,\r\n"
					+ "sum(total_teacher_not_initiatedat_any_level_m)  as total_teacher_not_initiatedat_any_level_m,\r\n"
					+ "sum(total_teacher_not_initiatedat_any_level_f)  as total_teacher_not_initiatedat_any_level_f,\r\n"
					+ "sum(total_teacher_dropbox_teacher_m)  as total_teacher_dropbox_teacher_m,\r\n"
					+ "sum(total_teacher_dropbox_teacher_f)  as total_teacher_dropbox_teacher_f,\r\n"
					+ "sum(total_non_teacher_not_initiatedat_any_level_m)  as total_non_teacher_not_initiatedat_any_level_m,\r\n"
					+ "sum(total_non_teacher_not_initiatedat_any_level_f)  as total_non_teacher_not_initiatedat_any_level_f,\r\n"
					+ "sum(total_non_teacher_dropbox_teacher_m)  as total_non_teacher_dropbox_teacher_m,\r\n"
					+ "sum(total_non_teacher_dropbox_teacher_f)  as total_non_teacher_dropbox_teacher_f,\r\n"
					+ "sum(dropbox)  as  dropbox\r\n" + "from transfer.dashboardviewone v ) no_of_techer) dd";
		} else if (mp.get("reportflag").equals("R")) {
			query = " select * from\r\n"
					+ "(select region_name as no_of_region from (select region_name from transfer.dashboardviewone v where v.region_code = '"
					+ mp.get("reportvalue") + "' group by v.region_name ) no_regn) aa,\r\n"
					+ "(select count(*) as no_of_station from ( select station_code from transfer.dashboardviewone v where v.region_code = '"
					+ mp.get("reportvalue") + "' group by v.station_code ) no_station) bb ,\r\n"
					+ "(select count(*) as no_of_school from ( select kv_code  from transfer.dashboardviewone v where v.region_code = '"
					+ mp.get("reportvalue") + "' group by v.kv_code ) no_of_kv) cc ,\r\n" + "\r\n" + "(select\r\n"
					+ "total_staff_all ,\r\n" + "total_staff_all_m ,\r\n" + "total_staff_all_f ,\r\n"
					+ "total_teacher_all ,\r\n" + "total_teacher_m ,\r\n" + "total_teacher_f ,\r\n"
					+ "total_teacher_initiated_m ,\r\n" + "total_teacher_initiated_f ,\r\n"
					+ "total_teacher_approved_m ,\r\n" + "total_teacher_approved_f ,\r\n"
					+ "total_teacher_school_initiated_m ,\r\n" + "total_teacher_school_initiated_f ,\r\n"
					+ "total_teacher_school_edited_m ,\r\n" + "total_teacher_school_edited_f ,\r\n"
					+ "total_teacher_school_approved_m ,\r\n" + "total_teacher_school_approved_f ,\r\n"
					+ "total_non_teacher_all ,\r\n" + "total_non_teacher_m ,\r\n" + "total_non_teacher_f ,\r\n"
					+ "total_non_teacher_initiated_m ,\r\n" + "total_non_teacher_initiated_f ,\r\n"
					+ "total_non_teacher_approved_m ,\r\n" + "total_non_teacher_approved_f ,\r\n"
					+ "total_non_teacher_school_initiated_m ,\r\n" + "total_non_teacher_school_initiated_f ,\r\n"
					+ "total_non_teacher_school_edited_m ,\r\n" + "total_non_teacher_school_edited_f ,\r\n"
					+ "total_non_teacher_school_approved_m ,\r\n" + "total_non_teacher_school_approved_f ,\r\n"
					+ "not_initiatedat_any_level ,\r\n" + "total_teacher_not_initiatedat_any_level_m ,\r\n"
					+ "total_teacher_not_initiatedat_any_level_f ,\r\n" + "total_teacher_dropbox_teacher_m ,\r\n"
					+ "total_teacher_dropbox_teacher_f ,\r\n" + "total_non_teacher_not_initiatedat_any_level_m ,\r\n"
					+ "total_non_teacher_not_initiatedat_any_level_f ,\r\n"
					+ "total_non_teacher_dropbox_teacher_m ,\r\n" + "total_non_teacher_dropbox_teacher_f ,\r\n" + "\r\n"
					+ "dropbox\r\n" + "\r\n" + "  from ( select\r\n" + " sum(total_staff_all)  as  total_staff_all,\r\n"
					+ " sum(total_staff_all_m)  as  total_staff_all_m   ,\r\n"
					+ " sum(total_staff_all_f)  as  total_staff_all_f   ,\r\n"
					+ "sum(total_teacher_all)  as  total_teacher_all,\r\n"
					+ "sum(total_teacher_m)  as  total_teacher_m,\r\n"
					+ "sum(total_teacher_f)  as  total_teacher_f,\r\n"
					+ "sum(total_teacher_initiated_m)  as  total_teacher_initiated_m,\r\n"
					+ "sum(total_teacher_initiated_f)  as  total_teacher_initiated_f,\r\n"
					+ "sum(total_teacher_approved_m)  as  total_teacher_approved_m,\r\n"
					+ "sum(total_teacher_approved_f)  as  total_teacher_approved_f,\r\n"
					+ "sum(total_teacher_school_initiated_m)  as  total_teacher_school_initiated_m,\r\n"
					+ "sum(total_teacher_school_initiated_f)  as  total_teacher_school_initiated_f,\r\n"
					+ "sum(total_teacher_school_edited_m)  as  total_teacher_school_edited_m,\r\n"
					+ "sum(total_teacher_school_edited_f)  as  total_teacher_school_edited_f,\r\n"
					+ "sum(total_teacher_school_approved_m)  as  total_teacher_school_approved_m,\r\n"
					+ "sum(total_teacher_school_approved_f)  as  total_teacher_school_approved_f,\r\n"
					+ "sum(total_non_teacher_all)  as  total_non_teacher_all,\r\n"
					+ "sum(total_non_teacher_m)  as  total_non_teacher_m,\r\n"
					+ "sum(total_non_teacher_f)  as  total_non_teacher_f,\r\n"
					+ "sum(total_non_teacher_initiated_m)  as  total_non_teacher_initiated_m,\r\n"
					+ "sum(total_non_teacher_initiated_f)  as  total_non_teacher_initiated_f,\r\n"
					+ "sum(total_non_teacher_approved_m)  as  total_non_teacher_approved_m,\r\n"
					+ "sum(total_non_teacher_approved_f)  as  total_non_teacher_approved_f,\r\n"
					+ "sum(total_non_teacher_school_initiated_m)  as  total_non_teacher_school_initiated_m,\r\n"
					+ "sum(total_non_teacher_school_initiated_f)  as  total_non_teacher_school_initiated_f,\r\n"
					+ "sum(total_non_teacher_school_edited_m)  as  total_non_teacher_school_edited_m,\r\n"
					+ "sum(total_non_teacher_school_edited_f)  as  total_non_teacher_school_edited_f,\r\n"
					+ "sum(total_non_teacher_school_approved_m)  as  total_non_teacher_school_approved_m,\r\n"
					+ "sum(total_non_teacher_school_approved_f)  as  total_non_teacher_school_approved_f,\r\n"
					+ "sum(not_initiatedat_any_level)  as  not_initiatedat_any_level,\r\n"
					+ "sum(total_teacher_not_initiatedat_any_level_m)  as total_teacher_not_initiatedat_any_level_m,\r\n"
					+ "sum(total_teacher_not_initiatedat_any_level_f)  as total_teacher_not_initiatedat_any_level_f,\r\n"
					+ "sum(total_teacher_dropbox_teacher_m)  as total_teacher_dropbox_teacher_m,\r\n"
					+ "sum(total_teacher_dropbox_teacher_f)  as total_teacher_dropbox_teacher_f,\r\n"
					+ "sum(total_non_teacher_not_initiatedat_any_level_m)  as total_non_teacher_not_initiatedat_any_level_m,\r\n"
					+ "sum(total_non_teacher_not_initiatedat_any_level_f)  as total_non_teacher_not_initiatedat_any_level_f,\r\n"
					+ "sum(total_non_teacher_dropbox_teacher_m)  as total_non_teacher_dropbox_teacher_m,\r\n"
					+ "sum(total_non_teacher_dropbox_teacher_f)  as total_non_teacher_dropbox_teacher_f,\r\n" + "\r\n"
					+ "\r\n" + "sum(dropbox)  as  dropbox\r\n"
					+ "from transfer.dashboardviewone v where v.region_code = '" + mp.get("reportvalue")
					+ "' ) no_of_techer) dd";
		} else if (mp.get("reportflag").equals("S")) {
			query = "select * from\r\n"
					+ "(select region_name as no_of_region from (select region_name from transfer.dashboardviewone v where v.station_code = '"
					+ mp.get("reportvalue") + "' group by v.region_name ) no_regn) aa,\r\n"
					+ "(select station_name as no_of_station from ( select station_name from transfer.dashboardviewone v where v.station_code = '"
					+ mp.get("reportvalue") + "' group by v.station_name  ) no_station) bb ,\r\n"
					+ "(select count(*) as no_of_school from ( select kv_code  from transfer.dashboardviewone v where v.station_code = '"
					+ mp.get("reportvalue") + "' group by v.kv_code ) no_of_kv) cc ,\r\n" + "(select\r\n"
					+ "total_staff_all ,\r\n" + "total_staff_all_m ,\r\n" + "total_staff_all_f ,\r\n"
					+ "total_teacher_all ,\r\n" + "total_teacher_m ,\r\n" + "total_teacher_f ,\r\n"
					+ "total_teacher_initiated_m ,\r\n" + "total_teacher_initiated_f ,\r\n"
					+ "total_teacher_approved_m ,\r\n" + "total_teacher_approved_f ,\r\n"
					+ "total_teacher_school_initiated_m ,\r\n" + "total_teacher_school_initiated_f ,\r\n"
					+ "total_teacher_school_edited_m ,\r\n" + "total_teacher_school_edited_f ,\r\n"
					+ "total_teacher_school_approved_m ,\r\n" + "total_teacher_school_approved_f ,\r\n"
					+ "total_non_teacher_all ,\r\n" + "total_non_teacher_m ,\r\n" + "total_non_teacher_f ,\r\n"
					+ "total_non_teacher_initiated_m ,\r\n" + "total_non_teacher_initiated_f ,\r\n"
					+ "total_non_teacher_approved_m ,\r\n" + "total_non_teacher_approved_f ,\r\n"
					+ "total_non_teacher_school_initiated_m ,\r\n" + "total_non_teacher_school_initiated_f ,\r\n"
					+ "total_non_teacher_school_edited_m ,\r\n" + "total_non_teacher_school_edited_f ,\r\n"
					+ "total_non_teacher_school_approved_m ,\r\n" + "total_non_teacher_school_approved_f ,\r\n"
					+ "not_initiatedat_any_level ,\r\n" + "total_teacher_not_initiatedat_any_level_m ,\r\n"
					+ "total_teacher_not_initiatedat_any_level_f ,\r\n" + "total_teacher_dropbox_teacher_m ,\r\n"
					+ "total_teacher_dropbox_teacher_f ,\r\n" + "total_non_teacher_not_initiatedat_any_level_m ,\r\n"
					+ "total_non_teacher_not_initiatedat_any_level_f ,\r\n"
					+ "total_non_teacher_dropbox_teacher_m ,\r\n" + "total_non_teacher_dropbox_teacher_f ,\r\n" + "\r\n"
					+ "dropbox\r\n" + "\r\n" + "  from ( select\r\n" + " sum(total_staff_all)  as  total_staff_all,\r\n"
					+ " sum(total_staff_all_m)  as  total_staff_all_m   ,\r\n"
					+ " sum(total_staff_all_f)  as  total_staff_all_f   ,\r\n"
					+ "sum(total_teacher_all)  as  total_teacher_all,\r\n"
					+ "sum(total_teacher_m)  as  total_teacher_m,\r\n"
					+ "sum(total_teacher_f)  as  total_teacher_f,\r\n"
					+ "sum(total_teacher_initiated_m)  as  total_teacher_initiated_m,\r\n"
					+ "sum(total_teacher_initiated_f)  as  total_teacher_initiated_f,\r\n"
					+ "sum(total_teacher_approved_m)  as  total_teacher_approved_m,\r\n"
					+ "sum(total_teacher_approved_f)  as  total_teacher_approved_f,\r\n"
					+ "sum(total_teacher_school_initiated_m)  as  total_teacher_school_initiated_m,\r\n"
					+ "sum(total_teacher_school_initiated_f)  as  total_teacher_school_initiated_f,\r\n"
					+ "sum(total_teacher_school_edited_m)  as  total_teacher_school_edited_m,\r\n"
					+ "sum(total_teacher_school_edited_f)  as  total_teacher_school_edited_f,\r\n"
					+ "sum(total_teacher_school_approved_m)  as  total_teacher_school_approved_m,\r\n"
					+ "sum(total_teacher_school_approved_f)  as  total_teacher_school_approved_f,\r\n"
					+ "sum(total_non_teacher_all)  as  total_non_teacher_all,\r\n"
					+ "sum(total_non_teacher_m)  as  total_non_teacher_m,\r\n"
					+ "sum(total_non_teacher_f)  as  total_non_teacher_f,\r\n"
					+ "sum(total_non_teacher_initiated_m)  as  total_non_teacher_initiated_m,\r\n"
					+ "sum(total_non_teacher_initiated_f)  as  total_non_teacher_initiated_f,\r\n"
					+ "sum(total_non_teacher_approved_m)  as  total_non_teacher_approved_m,\r\n"
					+ "sum(total_non_teacher_approved_f)  as  total_non_teacher_approved_f,\r\n"
					+ "sum(total_non_teacher_school_initiated_m)  as  total_non_teacher_school_initiated_m,\r\n"
					+ "sum(total_non_teacher_school_initiated_f)  as  total_non_teacher_school_initiated_f,\r\n"
					+ "sum(total_non_teacher_school_edited_m)  as  total_non_teacher_school_edited_m,\r\n"
					+ "sum(total_non_teacher_school_edited_f)  as  total_non_teacher_school_edited_f,\r\n"
					+ "sum(total_non_teacher_school_approved_m)  as  total_non_teacher_school_approved_m,\r\n"
					+ "sum(total_non_teacher_school_approved_f)  as  total_non_teacher_school_approved_f,\r\n"
					+ "sum(not_initiatedat_any_level)  as  not_initiatedat_any_level,\r\n"
					+ "sum(total_teacher_not_initiatedat_any_level_m)  as total_teacher_not_initiatedat_any_level_m,\r\n"
					+ "sum(total_teacher_not_initiatedat_any_level_f)  as total_teacher_not_initiatedat_any_level_f,\r\n"
					+ "sum(total_teacher_dropbox_teacher_m)  as total_teacher_dropbox_teacher_m,\r\n"
					+ "sum(total_teacher_dropbox_teacher_f)  as total_teacher_dropbox_teacher_f,\r\n"
					+ "sum(total_non_teacher_not_initiatedat_any_level_m)  as total_non_teacher_not_initiatedat_any_level_m,\r\n"
					+ "sum(total_non_teacher_not_initiatedat_any_level_f)  as total_non_teacher_not_initiatedat_any_level_f,\r\n"
					+ "sum(total_non_teacher_dropbox_teacher_m)  as total_non_teacher_dropbox_teacher_m,\r\n"
					+ "sum(total_non_teacher_dropbox_teacher_f)  as total_non_teacher_dropbox_teacher_f,\r\n" + "\r\n"
					+ "\r\n" + "sum(dropbox)  as  dropbox\r\n"
					+ "from transfer.dashboardviewone v where v.station_code  = '" + mp.get("reportvalue")
					+ "' ) no_of_techer) dd   ";
		} else if (mp.get("reportflag").equals("SCH")) {
			query = "     \r\n" + "  select * from\r\n"
					+ "(select region_name as no_of_region from (select region_name from transfer.dashboardviewone v where v.udise_sch_code = '"
					+ mp.get("reportvalue") + "' group by v.region_name ) no_regn) aa,\r\n"
					+ "(select station_name as no_of_station from ( select station_name from transfer.dashboardviewone v where v.udise_sch_code = '"
					+ mp.get("reportvalue") + "' group by v.station_name  ) no_station) bb ,\r\n"
					+ "(select kv_name as no_of_school from ( select kv_name  from transfer.dashboardviewone v where v.udise_sch_code = '"
					+ mp.get("reportvalue") + "' group by v.kv_name ) no_of_kv) cc ,\r\n" + "(select\r\n"
					+ "total_staff_all ,\r\n" + "total_staff_all_m ,\r\n" + "total_staff_all_f ,\r\n"
					+ "total_teacher_all ,\r\n" + "total_teacher_m ,\r\n" + "total_teacher_f ,\r\n"
					+ "total_teacher_initiated_m ,\r\n" + "total_teacher_initiated_f ,\r\n"
					+ "total_teacher_approved_m ,\r\n" + "total_teacher_approved_f ,\r\n"
					+ "total_teacher_school_initiated_m ,\r\n" + "total_teacher_school_initiated_f ,\r\n"
					+ "total_teacher_school_edited_m ,\r\n" + "total_teacher_school_edited_f ,\r\n"
					+ "total_teacher_school_approved_m ,\r\n" + "total_teacher_school_approved_f ,\r\n"
					+ "total_non_teacher_all ,\r\n" + "total_non_teacher_m ,\r\n" + "total_non_teacher_f ,\r\n"
					+ "total_non_teacher_initiated_m ,\r\n" + "total_non_teacher_initiated_f ,\r\n"
					+ "total_non_teacher_approved_m ,\r\n" + "total_non_teacher_approved_f ,\r\n"
					+ "total_non_teacher_school_initiated_m ,\r\n" + "total_non_teacher_school_initiated_f ,\r\n"
					+ "total_non_teacher_school_edited_m ,\r\n" + "total_non_teacher_school_edited_f ,\r\n"
					+ "total_non_teacher_school_approved_m ,\r\n" + "total_non_teacher_school_approved_f ,\r\n"
					+ "not_initiatedat_any_level ,\r\n" + "total_teacher_not_initiatedat_any_level_m ,\r\n"
					+ "total_teacher_not_initiatedat_any_level_f ,\r\n" + "total_teacher_dropbox_teacher_m ,\r\n"
					+ "total_teacher_dropbox_teacher_f ,\r\n" + "total_non_teacher_not_initiatedat_any_level_m ,\r\n"
					+ "total_non_teacher_not_initiatedat_any_level_f ,\r\n"
					+ "total_non_teacher_dropbox_teacher_m ,\r\n" + "total_non_teacher_dropbox_teacher_f ,\r\n" + "\r\n"
					+ "dropbox\r\n" + "\r\n" + "  from ( select\r\n" + " sum(total_staff_all)  as  total_staff_all,\r\n"
					+ " sum(total_staff_all_m)  as  total_staff_all_m   ,\r\n"
					+ " sum(total_staff_all_f)  as  total_staff_all_f   ,\r\n"
					+ "sum(total_teacher_all)  as  total_teacher_all,\r\n"
					+ "sum(total_teacher_m)  as  total_teacher_m,\r\n"
					+ "sum(total_teacher_f)  as  total_teacher_f,\r\n"
					+ "sum(total_teacher_initiated_m)  as  total_teacher_initiated_m,\r\n"
					+ "sum(total_teacher_initiated_f)  as  total_teacher_initiated_f,\r\n"
					+ "sum(total_teacher_approved_m)  as  total_teacher_approved_m,\r\n"
					+ "sum(total_teacher_approved_f)  as  total_teacher_approved_f,\r\n"
					+ "sum(total_teacher_school_initiated_m)  as  total_teacher_school_initiated_m,\r\n"
					+ "sum(total_teacher_school_initiated_f)  as  total_teacher_school_initiated_f,\r\n"
					+ "sum(total_teacher_school_edited_m)  as  total_teacher_school_edited_m,\r\n"
					+ "sum(total_teacher_school_edited_f)  as  total_teacher_school_edited_f,\r\n"
					+ "sum(total_teacher_school_approved_m)  as  total_teacher_school_approved_m,\r\n"
					+ "sum(total_teacher_school_approved_f)  as  total_teacher_school_approved_f,\r\n"
					+ "sum(total_non_teacher_all)  as  total_non_teacher_all,\r\n"
					+ "sum(total_non_teacher_m)  as  total_non_teacher_m,\r\n"
					+ "sum(total_non_teacher_f)  as  total_non_teacher_f,\r\n"
					+ "sum(total_non_teacher_initiated_m)  as  total_non_teacher_initiated_m,\r\n"
					+ "sum(total_non_teacher_initiated_f)  as  total_non_teacher_initiated_f,\r\n"
					+ "sum(total_non_teacher_approved_m)  as  total_non_teacher_approved_m,\r\n"
					+ "sum(total_non_teacher_approved_f)  as  total_non_teacher_approved_f,\r\n"
					+ "sum(total_non_teacher_school_initiated_m)  as  total_non_teacher_school_initiated_m,\r\n"
					+ "sum(total_non_teacher_school_initiated_f)  as  total_non_teacher_school_initiated_f,\r\n"
					+ "sum(total_non_teacher_school_edited_m)  as  total_non_teacher_school_edited_m,\r\n"
					+ "sum(total_non_teacher_school_edited_f)  as  total_non_teacher_school_edited_f,\r\n"
					+ "sum(total_non_teacher_school_approved_m)  as  total_non_teacher_school_approved_m,\r\n"
					+ "sum(total_non_teacher_school_approved_f)  as  total_non_teacher_school_approved_f,\r\n"
					+ "sum(not_initiatedat_any_level)  as  not_initiatedat_any_level,\r\n"
					+ "sum(total_teacher_not_initiatedat_any_level_m)  as total_teacher_not_initiatedat_any_level_m,\r\n"
					+ "sum(total_teacher_not_initiatedat_any_level_f)  as total_teacher_not_initiatedat_any_level_f,\r\n"
					+ "sum(total_teacher_dropbox_teacher_m)  as total_teacher_dropbox_teacher_m,\r\n"
					+ "sum(total_teacher_dropbox_teacher_f)  as total_teacher_dropbox_teacher_f,\r\n"
					+ "sum(total_non_teacher_not_initiatedat_any_level_m)  as total_non_teacher_not_initiatedat_any_level_m,\r\n"
					+ "sum(total_non_teacher_not_initiatedat_any_level_f)  as total_non_teacher_not_initiatedat_any_level_f,\r\n"
					+ "sum(total_non_teacher_dropbox_teacher_m)  as total_non_teacher_dropbox_teacher_m,\r\n"
					+ "sum(total_non_teacher_dropbox_teacher_f)  as total_non_teacher_dropbox_teacher_f,\r\n" + "\r\n"
					+ "\r\n" + "sum(dropbox)  as  dropbox\r\n"
					+ "from transfer.dashboardviewone v where v.udise_sch_code  = '" + mp.get("reportvalue")
					+ "' ) no_of_techer) dd    \r\n";

		}

		System.out.println("query--->" + query);

		QueryResult qrObj1 = null;
		try {
			qrObj1 = nativeRepository.executeQueries(query);
		} catch (Exception ex) {

		}
		return qrObj1.getRowValue();
	}

	@Override
	public List<Map<String, Object>> getDashboardOnMoreClick(Map<Object, Object> mp) {
		String query = null;

		if (mp.get("reportflag").equals("A")) {
			query = "select * from transfer.dashboardviewone";
		} else if (mp.get("reportflag").equals("R")) {
			query = "select * from transfer.dashboardviewone d where region_code ='" + mp.get("reportvalue") + "'";
		} else if (mp.get("reportflag").equals("S")) {
			query = "select * from transfer.dashboardviewone d where station_code ='" + mp.get("reportvalue") + "'";
		}
		if (mp.get("reportflag").equals("SCH")) {
			query = "select * from transfer.dashboardviewone d where udise_sch_code ='" + mp.get("reportvalue") + "'";
		}

		QueryResult qrObj1 = null;
		try {
			qrObj1 = nativeRepository.executeQueries(query);
		} catch (Exception ex) {

		}
		return qrObj1.getRowValue();
	}

	@Override
	public List<Map<String, Object>> getkvsDashboardReport() {
		QueryResult qrObj1 = null;
		String query = "select sch.no_of_school,re.no_of_region,ms.no_of_station,mz.no_of_zone,tt.no_of_teaching_teacher,ntt.no_of_nonteaching_teacher from \r\n"
				+ "(select count(*) as no_of_school from uneecops.m_schools ksm where ksm.school_type=1 and shift in ('1','0')  and ksm.school_status=true)  sch, \r\n"
				+ "(select count(*) as no_of_region from uneecops.m_region mr where mr.region_type=3 and mr.is_active=true) re,\r\n"
				+ "(select count(*) as no_of_station from uneecops.m_station ms) ms,\r\n"
				+ "(select count(*) as no_of_zone from uneecops.m_schools mz where mz.school_type=2 and mz.school_status=true ) mz,\r\n"
				+ "(select count(*) as no_of_teaching_teacher from public.teacher_profile tp where tp.teaching_nonteaching='1' ) tt,\r\n"
				+ "(select count(*) as no_of_nonteaching_teacher from public.teacher_profile tp where tp.teaching_nonteaching='2' ) ntt";
		try {
			qrObj1 = nativeRepository.executeQueries(query);
		} catch (Exception ex) {

		}
		return qrObj1.getRowValue();
	}

	public Object getRoDashboard(Map<String, Object> mp) {
		KvsDashboardBean finalObj = new KvsDashboardBean();
		QueryResult qrObj1 = null;
		String catWiseStationCountQuery = null;
		String teachingNonTeachingQuery = null;
		String query = null;
		if (String.valueOf(mp.get("dashboardType")).equalsIgnoreCase("R")) {
			String ticketQuery="select r1.inprogres_ticket,r2.resolve_ticket,r3.reject_ticket from\r\n"
					+ "(select count(id) as inprogres_ticket from public.kvs_moe_ticket kmt where kmt.ticket_to_id in (select ksm.kv_code from kv.kv_school_master ksm where ksm.region_code ='"+String.valueOf(mp.get("regionCode"))+"' and ksm.school_status='1') and ticket_status ='0') r1,\r\n"
					+ "(select count(id) as resolve_ticket from public.kvs_moe_ticket kmt where kmt.ticket_to_id in (select ksm.kv_code from kv.kv_school_master ksm where ksm.region_code ='"+String.valueOf(mp.get("regionCode"))+"' and ksm.school_status='1') and ticket_status ='1') r2,\r\n"
					+ "(select count(id) as reject_ticket from public.kvs_moe_ticket kmt where kmt.ticket_to_id in (select ksm.kv_code from kv.kv_school_master ksm where ksm.region_code ='"+String.valueOf(mp.get("regionCode"))+"' and ksm.school_status='1') and ticket_status ='2') r3";
			 
			query = "select * from get_dashboard_profile('R','" + String.valueOf(mp.get("regionCode")) + "')";
			try {
				
				qrObj1 = nativeRepository.executeQueries(query);
				if (qrObj1 != null && qrObj1.getRowValue().size() > 0) {
					finalObj.setRegionCode(qrObj1.getRowValue().get(0).get("region_code"));
					finalObj.setRegionName(qrObj1.getRowValue().get(0).get("region_name"));
					finalObj.setRegionAddress(qrObj1.getRowValue().get(0).get("region_address"));
					finalObj.setEmployeeName(qrObj1.getRowValue().get(0).get("employee_name"));
					finalObj.setTeacherEmail(qrObj1.getRowValue().get(0).get("teacher_email"));
					finalObj.setTeacherMobile(qrObj1.getRowValue().get(0).get("teacher_mobile"));
					finalObj.setTotalSchool(qrObj1.getRowValue().get(0).get("total_school"));
					finalObj.setTotalSanctionPost(qrObj1.getRowValue().get(0).get("total_sanction_post"));
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			try {
				try {
					QueryResult ticketObj = nativeRepository.executeQueries(ticketQuery);
					finalObj.setInprogresTicket(ticketObj.getRowValue().get(0).get("inprogres_ticket"));
					finalObj.setResolveTicket(ticketObj.getRowValue().get(0).get("resolve_ticket"));
					finalObj.setRejectTicket(ticketObj.getRowValue().get(0).get("reject_ticket"));
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		
			try {
				QueryResult cntrlResult=new QueryResult();
				String controllerOfficerQuery = "select teacher_name as controller_name,teacher_mobile as controller_mobile, teacher_email as controller_email from teacher_profile tp where tp.teacher_employee_code in (select employee_code from kv_controller_officer kco where region_code ='"+ String.valueOf(mp.get("regionCode"))+"' and controller_type ='R' order by id desc)";
				cntrlResult = nativeRepository.executeQueries(controllerOfficerQuery);
				if(cntrlResult.getRowValue().size()>0) {
				finalObj.setEmployeeName(cntrlResult.getRowValue().get(0).get("controller_name"));
				finalObj.setTeacherEmail(cntrlResult.getRowValue().get(0).get("controller_email"));
				finalObj.setTeacherMobile(cntrlResult.getRowValue().get(0).get("controller_mobile"));
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			
		} else if (String.valueOf(mp.get("dashboardType")).equalsIgnoreCase("N")) {
			String ticketQuery="select r1.inprogres_ticket,r2.resolve_ticket,r3.reject_ticket from\r\n"
					+ "(select count(id) as inprogres_ticket from public.kvs_moe_ticket kmt where kmt.assign_to_id ='1' and ticket_status ='0') r1,\r\n"
					+ "(select count(id) as resolve_ticket from public.kvs_moe_ticket kmt where kmt.assign_to_id ='1' and ticket_status ='1') r2,\r\n"
					+ "(select count(id) as reject_ticket from public.kvs_moe_ticket kmt where kmt.assign_to_id ='1' and ticket_status ='2') r3";
			query = "select * from get_national_dashboard_profile('N','')";
			qrObj1 = nativeRepository.executeQueries(query);

			if (qrObj1 != null && qrObj1.getRowValue().size() > 0) {
				for (int i = 0; i < qrObj1.getRowValue().size(); i++) {
					if (String.valueOf(qrObj1.getRowValue().get(i).get("total_school"))
							.equalsIgnoreCase("total_school")) {
						finalObj.setTotalSchool(qrObj1.getRowValue().get(i).get("total_count"));
					} else if (String.valueOf(qrObj1.getRowValue().get(i).get("total_school"))
							.equalsIgnoreCase("total_sanction_post")) {
						finalObj.setTotalSanctionPost(qrObj1.getRowValue().get(i).get("total_count"));
					} else if (String.valueOf(qrObj1.getRowValue().get(i).get("total_school"))
							.equalsIgnoreCase("total_region")) {
						finalObj.setTotalRegion(qrObj1.getRowValue().get(i).get("total_count"));
					} else if (String.valueOf(qrObj1.getRowValue().get(i).get("total_school"))
							.equalsIgnoreCase("total_ziet")) {
						finalObj.setTotalZiet(qrObj1.getRowValue().get(i).get("total_count"));
					}
				}
			}
			
			try {
				try {
					QueryResult ticketObj =new QueryResult();
					 ticketObj = nativeRepository.executeQueries(ticketQuery);
					System.out.println("In progress--->"+ticketObj.getRowValue().get(0).get("inprogres_ticket"));
					finalObj.setInprogresTicket(ticketObj.getRowValue().get(0).get("inprogres_ticket"));
					finalObj.setResolveTicket(ticketObj.getRowValue().get(0).get("resolve_ticket"));
					finalObj.setRejectTicket(ticketObj.getRowValue().get(0).get("reject_ticket"));
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			try {
				QueryResult loginQueryResult =new QueryResult();
				String loginDetails="select sum(case when left(b.username,2)='kv' then 1 else 0 end) as school_login,\r\n"
						+ "					   sum(case when left(b.username,2)='ro' then 1 else 0 end) as ro_login,\r\n"
						+ "					   sum(case when left(b.username,2)='zi' then 1 else 0 end) as ziet_login,\r\n"
						+ "					   sum(case when left(b.username,2) not in ('ro','kv','zi') then 1 else 0 end) as emp_login,\r\n"
						+ "					   a.login_valid_date from (select distinct user_id,(current_date + interval '1 day')::date as login_valid_date from refreshtoken \r\n"
						+ "					   where expirydate::date = (current_date + interval '1 day')::date) a left join user_details b on a.user_id=b.id\r\n"
						+ "					   group by a.login_valid_date";
				
				loginQueryResult= loginNativeRepository.executeQueries(loginDetails);
				finalObj.setRoLoginCount(loginQueryResult.getRowValue().get(0).get("ro_login"));
				finalObj.setZietLoginCount(loginQueryResult.getRowValue().get(0).get("ziet_login"));
				finalObj.setSchoolLoginCount(loginQueryResult.getRowValue().get(0).get("school_login"));
				finalObj.setEmployeeLoginCount(loginQueryResult.getRowValue().get(0).get("emp_login"));
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			

		} else if (String.valueOf(mp.get("dashboardType")).equalsIgnoreCase("S")) {

			String controllerOfficerQuery = "select teacher_name as controller_name,teacher_mobile as controller_mobile, teacher_email as controller_email from teacher_profile tp where tp.teacher_employee_code in (select employee_code from kv_controller_officer kco where institution_code ='"
					+ String.valueOf(mp.get("kvCode")) + "' order by id desc)";
			String profileQuery = "\r\n"
					+ "select ms2.schooladdress ,ksm.*,scm.category_id,ms.station_code ,ms.station_name  from kv.kv_school_master ksm  left join kv_controller_officer kco on kco.institution_code =ksm.kv_code left join uneecops.station_category_mapping scm  on ksm.station_code::int =scm.station_code  left join uneecops.m_station ms on scm.station_code =ms.station_code  left join uneecops.m_schools ms2 on ksm.kv_code =ms2.kv_code::varchar where  scm.is_active =true and  ksm.kv_code ='"
					+ String.valueOf(mp.get("kvCode")) + "';\r\n" + "";
			String typeEmployeeDetails = "select teacher_gender,count(*), '1' as teaching_nonteaching  from public.teacher_profile tp where tp.teaching_nonteaching ='1' and  kv_code='"
					+ String.valueOf(mp.get("kvCode")) + "' and (tp.drop_box_flag !='1' or tp.drop_box_flag is null or tp.drop_box_flag='0') group by teacher_gender\r\n"
					+ "					union all\r\n"
					+ "select teacher_gender,count(*), '2' as teaching_nonteaching  from public.teacher_profile tp where tp.teaching_nonteaching ='2' and  kv_code='"
					+ String.valueOf(mp.get("kvCode")) + "'  and (tp.drop_box_flag !='1' or tp.drop_box_flag is null or tp.drop_box_flag='0') group by teacher_gender				\r\n" + " ";

			String schoolMisleniousData="select r1.no_of_teacher_pending,r2.no_of_teacher_approve,r3.total_no_of_employee,r4.no_of_transfer_releaving_pending,r5.no_of_transfer_joining_pending from\r\n"
					+ "(select count(tfs.teacher_id) as no_of_teacher_pending from public.teacher_form_status tfs  where tfs.teacher_id in (select teacher_id from public.teacher_profile tp where tp.kv_code ='"+ String.valueOf(mp.get("kvCode"))+"'  and (tp.drop_box_flag !='1' or tp.drop_box_flag is null or tp.drop_box_flag='0') ) and (tfs.profile_final_status is null or tfs.profile_final_status ='SP' or tfs.profile_final_status ='')) r1,\r\n"
					+ "(select count(tfs.teacher_id) as no_of_teacher_approve from public.teacher_form_status tfs  where tfs.teacher_id in (select teacher_id from public.teacher_profile tp where tp.kv_code ='"+ String.valueOf(mp.get("kvCode"))+"'  and (tp.drop_box_flag !='1' or tp.drop_box_flag is null or tp.drop_box_flag='0')) and (tfs.profile_final_status ='SA')) r2,\r\n"
					+ "(select count(tfs.teacher_id) as total_no_of_employee from public.teacher_form_status tfs  where tfs.teacher_id in (select teacher_id from public.teacher_profile tp where tp.kv_code ='"+ String.valueOf(mp.get("kvCode"))+"'  and (tp.drop_box_flag !='1' or tp.drop_box_flag is null or tp.drop_box_flag='0'))) r3,\r\n"
					+ "(select count(teacher_id) as no_of_transfer_releaving_pending  from z_emp_details_3107 zed where present_kv_code ='"+ String.valueOf(mp.get("kvCode"))+"' and allot_kv_code !='-1' and relieve_date is null ) r4,\r\n"
					+ "(select count(teacher_id) as no_of_transfer_joining_pending  from z_emp_details_3107 zed where allot_kv_code ='"+ String.valueOf(mp.get("kvCode"))+"' and allot_kv_code !='-1' and (join_date  is null )) r5 \r\n"
					+ "";
			
			String ticketQuery="select r1.inprogres_ticket,r2.resolve_ticket,r3.reject_ticket from\r\n"
					+ "(select count(id) as inprogres_ticket from public.kvs_moe_ticket kmt where kmt.ticket_to_id ='"+String.valueOf(mp.get("kvCode"))+"' and ticket_status ='0') r1,\r\n"
					+ "(select count(id) as resolve_ticket from public.kvs_moe_ticket kmt where kmt.ticket_to_id ='"+String.valueOf(mp.get("kvCode"))+"' and ticket_status ='1') r2,\r\n"
					+ "(select count(id) as reject_ticket from public.kvs_moe_ticket kmt where kmt.ticket_to_id ='"+String.valueOf(mp.get("kvCode"))+"' and ticket_status ='2') r3";
			
			try {
				QueryResult controllerResultSet = nativeRepository.executeQueries(controllerOfficerQuery);
				if(controllerResultSet.getRowValue().size()>0) {
				finalObj.setEmployeeName(controllerResultSet.getRowValue().get(0).get("controller_name"));
				finalObj.setTeacherEmail(controllerResultSet.getRowValue().get(0).get("controller_email"));
				finalObj.setTeacherMobile(controllerResultSet.getRowValue().get(0).get("controller_mobile"));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			try {
				QueryResult profileResultSet = nativeRepository.executeQueries(profileQuery);
				if(profileResultSet.getRowValue().size() >1) {
				finalObj.setRegionCode(profileResultSet.getRowValue().get(0).get("region_code"));
				finalObj.setRegionName(profileResultSet.getRowValue().get(0).get("region_name"));
				finalObj.setStationCode(profileResultSet.getRowValue().get(0).get("station_code"));
				finalObj.setStationName(profileResultSet.getRowValue().get(0).get("station_name"));
				finalObj.setKvCode(profileResultSet.getRowValue().get(0).get("kv_code"));
				finalObj.setKvName(profileResultSet.getRowValue().get(0).get("kv_name"));
				finalObj.setSchoolAddress(profileResultSet.getRowValue().get(0).get("schooladdress"));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			try {
				
				System.out.println("typeEmployeeDetails--->"+typeEmployeeDetails);
				
				QueryResult empTypeResultSet = nativeRepository.executeQueries(typeEmployeeDetails);
				for (int i = 0; i < empTypeResultSet.getRowValue().size(); i++) {
					if (String.valueOf(empTypeResultSet.getRowValue().get(i).get("teaching_nonteaching"))
							.equalsIgnoreCase("1")
							&& String.valueOf(empTypeResultSet.getRowValue().get(i).get("teacher_gender"))
									.equalsIgnoreCase("1")) {
						finalObj.setTeachingMale(empTypeResultSet.getRowValue().get(i).get("count"));
					} else if (String.valueOf(empTypeResultSet.getRowValue().get(i).get("teaching_nonteaching"))
							.equalsIgnoreCase("1")
							&& String.valueOf(empTypeResultSet.getRowValue().get(i).get("teacher_gender"))
									.equalsIgnoreCase("2")) {
						finalObj.setTeachingFemale(empTypeResultSet.getRowValue().get(i).get("count"));
					}else if(String.valueOf(empTypeResultSet.getRowValue().get(i).get("teaching_nonteaching"))
							.equalsIgnoreCase("1")
							&& String.valueOf(empTypeResultSet.getRowValue().get(i).get("teacher_gender")).equalsIgnoreCase("null")
									) {
						finalObj.setTeachingNoGender(empTypeResultSet.getRowValue().get(i).get("count"));
					} else if (String.valueOf(empTypeResultSet.getRowValue().get(i).get("teaching_nonteaching"))
							.equalsIgnoreCase("2")
							&& String.valueOf(empTypeResultSet.getRowValue().get(i).get("teacher_gender"))
									.equalsIgnoreCase("1")) {
						finalObj.setNonTeachingMale(empTypeResultSet.getRowValue().get(i).get("count"));
					} else if (String.valueOf(empTypeResultSet.getRowValue().get(i).get("teaching_nonteaching"))
							.equalsIgnoreCase("2")
							&& String.valueOf(empTypeResultSet.getRowValue().get(i).get("teacher_gender"))
									.equalsIgnoreCase("2")) {
						finalObj.setNonTeachingFeMale(empTypeResultSet.getRowValue().get(i).get("count"));
					}else if(String.valueOf(empTypeResultSet.getRowValue().get(i).get("teaching_nonteaching"))
							.equalsIgnoreCase("2")
							&& String.valueOf(empTypeResultSet.getRowValue().get(i).get("teacher_gender")).equalsIgnoreCase("null")
									) {
						finalObj.setNonteachingNoGender(empTypeResultSet.getRowValue().get(i).get("count"));
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			try {
				QueryResult schoolMisleniousDataObj = nativeRepository.executeQueries(schoolMisleniousData);
				finalObj.setNoOfTeacherPending(schoolMisleniousDataObj.getRowValue().get(0).get("no_of_teacher_pending"));
				finalObj.setNoOfTeacherApprove(schoolMisleniousDataObj.getRowValue().get(0).get("no_of_teacher_approve"));
				finalObj.setTotalNoOfEmployee(schoolMisleniousDataObj.getRowValue().get(0).get("total_no_of_employee"));
				finalObj.setNoOfTransferReleavingPending(schoolMisleniousDataObj.getRowValue().get(0).get("no_of_transfer_releaving_pending"));
				finalObj.setNoOfTransferJoiningPending(schoolMisleniousDataObj.getRowValue().get(0).get("no_of_transfer_joining_pending"));
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			try {
				System.out.println("School--->"+ticketQuery);
				QueryResult ticketObj1 =new QueryResult();
				 ticketObj1 = nativeRepository.executeQueries(ticketQuery);
				 System.out.println("school-->"+ticketObj1.getRowValue().get(0).get("inprogres_ticket"));
				finalObj.setInprogresTicket(ticketObj1.getRowValue().get(0).get("inprogres_ticket"));
				finalObj.setResolveTicket(ticketObj1.getRowValue().get(0).get("resolve_ticket"));
				finalObj.setRejectTicket(ticketObj1.getRowValue().get(0).get("reject_ticket"));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}

		if (String.valueOf(mp.get("dashboardType")).equalsIgnoreCase("R")
				|| String.valueOf(mp.get("dashboardType")).equalsIgnoreCase("N")) {
			try {
				if (String.valueOf(mp.get("dashboardType")).equalsIgnoreCase("R")) {
					catWiseStationCountQuery = "select category_id,count(*) as categories_type_count from uneecops.station_category_mapping scm left join uneecops.m_category mc on scm.category_id =mc.id where scm.station_code in (select rsm.station_code from uneecops.region_station_mapping rsm where rsm.region_code='"
							+ String.valueOf(mp.get("regionCode")) + "') and scm.is_active =true group by category_id";
				} else if (String.valueOf(mp.get("dashboardType")).equalsIgnoreCase("N")) {
					catWiseStationCountQuery = "select category_id,count(*) as categories_type_count from uneecops.station_category_mapping scm left join uneecops.m_category mc on scm.category_id =mc.id where scm.station_code in (select rsm.station_code from uneecops.region_station_mapping rsm) and  scm.is_active =true group by category_id";
				}
				System.out.println(catWiseStationCountQuery);
				QueryResult qrObj2 = nativeRepository.executeQueries(catWiseStationCountQuery);

				for (int i = 0; i < qrObj2.getRowValue().size(); i++) {
					System.out.println("cat_id--->" + String.valueOf(qrObj2.getRowValue().get(i).get("category_id")));
					if (String.valueOf(qrObj2.getRowValue().get(i).get("category_id")).equalsIgnoreCase("0")) {
						finalObj.setTotalNormalStation(qrObj2.getRowValue().get(i).get("categories_type_count"));
					} else if (String.valueOf(qrObj2.getRowValue().get(i).get("category_id")).equalsIgnoreCase("1")) {
						finalObj.setTotalNerStation(qrObj2.getRowValue().get(i).get("categories_type_count"));
					} else if (String.valueOf(qrObj2.getRowValue().get(i).get("category_id")).equalsIgnoreCase("2")) {
						System.out.println(qrObj2.getRowValue().get(i).get("categories_type_count"));
						finalObj.setTotalPriorityStation(qrObj2.getRowValue().get(i).get("categories_type_count"));
					} else if (String.valueOf(qrObj2.getRowValue().get(i).get("category_id")).equalsIgnoreCase("3")) {
						finalObj.setTotalHardStation(qrObj2.getRowValue().get(i).get("categories_type_count"));
					} else if (String.valueOf(qrObj2.getRowValue().get(i).get("category_id")).equalsIgnoreCase("4")) {
						finalObj.setTotalVeryHardStation(qrObj2.getRowValue().get(i).get("categories_type_count"));
					}
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

			try {
				if (String.valueOf(mp.get("dashboardType")).equalsIgnoreCase("R")) {
					teachingNonTeachingQuery = "select teacher_gender,count(*), '1' as teaching_nonteaching  from public.teacher_profile tp where tp.teaching_nonteaching ='1' and (tp.drop_box_flag !='1' or tp.drop_box_flag is null or tp.drop_box_flag='0') and kv_code in (select ksm.kv_code from kv.kv_school_master ksm where ksm.region_code='"
							+ String.valueOf(mp.get("regionCode"))
							+ "' and ksm.school_status='1' and ksm.school_type ='1') group by teacher_gender \r\n"
							+ "union all \r\n"
							+ "select teacher_gender,count(*), '2' as teaching_nonteaching   from public.teacher_profile tp where tp.teaching_nonteaching ='2' and (tp.drop_box_flag !='1' or tp.drop_box_flag is null or tp.drop_box_flag='0') and kv_code in (select ksm.kv_code from kv.kv_school_master ksm where ksm.region_code='"
							+ String.valueOf(mp.get("regionCode"))
							+ "' and ksm.school_status='1' and ksm.school_type ='1') group by teacher_gender\r\n" + "";
				} else if (String.valueOf(mp.get("dashboardType")).equalsIgnoreCase("N")) {
					teachingNonTeachingQuery = "select teacher_gender,count(*), '1' as teaching_nonteaching  from public.teacher_profile tp where tp.teaching_nonteaching ='1' and (tp.drop_box_flag !='1' or tp.drop_box_flag is null or tp.drop_box_flag='0') and kv_code in (select ksm.kv_code from kv.kv_school_master ksm where ksm.school_status='1' ) group by teacher_gender \r\n"
							+ "union all \r\n"
							+ "select teacher_gender,count(*), '2' as teaching_nonteaching   from public.teacher_profile tp where tp.teaching_nonteaching ='2' and (tp.drop_box_flag !='1' or tp.drop_box_flag is null or tp.drop_box_flag='0') and kv_code in (select ksm.kv_code from kv.kv_school_master ksm where ksm.school_status='1' ) group by teacher_gender\r\n"
							+ "";
				}
				QueryResult qrObj3 = nativeRepository.executeQueries(teachingNonTeachingQuery);
				for (int i = 0; i < qrObj3.getRowValue().size(); i++) {
					if (String.valueOf(qrObj3.getRowValue().get(i).get("teaching_nonteaching")).equalsIgnoreCase("1")
							&& String.valueOf(qrObj3.getRowValue().get(i).get("teacher_gender"))
									.equalsIgnoreCase("1")) {
						finalObj.setTeachingMale(qrObj3.getRowValue().get(i).get("count"));
					} else if (String.valueOf(qrObj3.getRowValue().get(i).get("teaching_nonteaching"))
							.equalsIgnoreCase("1")
							&& String.valueOf(qrObj3.getRowValue().get(i).get("teacher_gender"))
									.equalsIgnoreCase("2")) {
						finalObj.setTeachingFemale(qrObj3.getRowValue().get(i).get("count"));
					} else if (String.valueOf(qrObj3.getRowValue().get(i).get("teaching_nonteaching"))
							.equalsIgnoreCase("2")
							&& String.valueOf(qrObj3.getRowValue().get(i).get("teacher_gender"))
									.equalsIgnoreCase("1")) {
						finalObj.setNonTeachingMale(qrObj3.getRowValue().get(i).get("count"));
					} else if (String.valueOf(qrObj3.getRowValue().get(i).get("teaching_nonteaching"))
							.equalsIgnoreCase("2")
							&& String.valueOf(qrObj3.getRowValue().get(i).get("teacher_gender"))
									.equalsIgnoreCase("2")) {
						finalObj.setNonTeachingFeMale(qrObj3.getRowValue().get(i).get("count"));
					}
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return finalObj;
	}
	
	

	
	public Object getReportById(KvsReport data) {
		String query="";
		if(data.getReportId() == 1000) {
			query="select * from z_emp_details_3107 zed left join z_ext_emp_details zeed on zed.emp_code =zeed.emp_code  where (zed.is_automated_transfer =true or zeed.is_automated_transfer =true) and zed.transfer_year='2023'  order by zed.emp_name";
		}else if(data.getReportId() == 1001){
			query="select * from z_emp_details_3107 zed where zed.is_admin_transfer=true and transfer_type='A' and transfer_year='2023' order by zed.emp_name";
		}else if(data.getReportId() == 1002){
			query="select * from z_ext_emp_details zed where transfer_type='AC' and transfer_year='2023' order by zed.emp_name";
		}else if(data.getReportId() == 1003){
			query="select * from z_ext_emp_details zed where transfer_type='AM' and transfer_year='2023' order by zed.emp_name";
		}
		return nativeRepository.executeQueries(query);
	}
	
	
	public Object getDashboardEmployeeDetails() {
		
		DashboardEmployeeProfileBean  empProfileObj=new DashboardEmployeeProfileBean();
		String withdropbox="select count(1) as totalemplyincludedropbox from public.teacher_profile where kv_code<>'9999'";
		String withoutdropbox="select count(1) as totalemployeewithoutdropbox from public.teacher_profile where kv_code<>'9999' and (drop_box_flag=0 or drop_box_flag is null)";
		String indropbox="select count(1) as totaldropboxemployee from public.teacher_profile tp join kv.kv_school_master as ksm on tp.kv_code=ksm.kv_code \r\n"
				+ "where ksm.school_status='1' and tp.kv_code<>'9999' and tp.drop_box_flag=1";
		String profileNotUpdated="select count(1) as profilenotudatedthisyear from public.teacher_profile\r\n"
				+ "where (extract( 'year' from modified_time)<> extract('year' from current_date) or modified_time is null )\r\n"
				+ "and (drop_box_flag in ('0') or drop_box_flag is null ) and kv_code<>'9999'";
		String profileUpdated="select count(1) as profileupdatedthisyear from public.teacher_profile\r\n"
				+ "where ((extract( 'year' from modified_time)= extract('year' from current_date)) \r\n"
				+ "	   or (extract( 'year' from created_time)= extract('year' from current_date)) )\r\n"
				+ "and (drop_box_flag in ('0') or drop_box_flag is null ) and kv_code<>'9999'";
		String profileUpdatedAddedToday="select count(1) as profileupdatedtoday from public.teacher_profile\r\n"
				+ "where (modified_time::date = current_date or created_time::date = current_date)\r\n"
				+ "and (drop_box_flag in ('0') or drop_box_flag is null ) and kv_code<>'9999'";
		
		empProfileObj.setTotalEmplyIncludeDropbox(nativeRepository.executeQueries(withdropbox).getRowValue().get(0).get("totalemplyincludedropbox"));
		empProfileObj.setTotalEmployeeWithoutDropbox(nativeRepository.executeQueries(withoutdropbox).getRowValue().get(0).get("totalemployeewithoutdropbox"));
		empProfileObj.setTotalDropboxEmployee(nativeRepository.executeQueries(indropbox).getRowValue().get(0).get("totaldropboxemployee"));
		empProfileObj.setProfileUpdatedToday(nativeRepository.executeQueries(profileUpdatedAddedToday).getRowValue().get(0).get("profileupdatedtoday"));
		empProfileObj.setProfileUpdatedThisYear(nativeRepository.executeQueries(profileUpdated).getRowValue().get(0).get("profileupdatedthisyear"));
		empProfileObj.setProfileNotUdatedThisyear(nativeRepository.executeQueries(profileNotUpdated).getRowValue().get(0).get("profilenotudatedthisyear"));
		
		return empProfileObj;
	}

	
	public Object getNoOfEmployeeRegionSchoolWiseExcludeDropbox() {
		
		return nativeRepository.executeQueries("select region_name,kv_name, count(1) as NoOfEmpProfileAddedUpdated from public.teacher_profile tp \r\n"
				+ "join kv.kv_school_master as ksm on tp.kv_code=ksm.kv_code\r\n"
				+ "where ksm.school_status='1' and tp.kv_code<>'9999' and (drop_box_flag=0 or drop_box_flag is null)\r\n"
				+ "group by region_name,kv_name order by region_name,kv_name").getRowValue();
		
	}
	
	
	public Object getNoOfEmployeeRegionSchoolWiseIncludeDropbox() {
		return nativeRepository.executeQueries("select region_name,kv_name, count(1) as NoOfEmpProfileAddedUpdated from public.teacher_profile tp \r\n"
				+ "join kv.kv_school_master as ksm on tp.kv_code=ksm.kv_code\r\n"
				+ "where ksm.school_status='1' and tp.kv_code<>'9999' "
				+ "group by region_name,kv_name order by region_name,kv_name").getRowValue();
	}
	
	public Object getNoOfEmployeeRegionSchoolWiseDropbox() {
		return nativeRepository.executeQueries("select region_name,kv_name, count(1) as NoOfEmpProfileAddedUpdated from public.teacher_profile tp \r\n"
				+ "join kv.kv_school_master as ksm on tp.kv_code=ksm.kv_code\r\n"
				+ "where ksm.school_status='1' and tp.kv_code<>'9999' and tp.drop_box_flag=1\r\n"
				+ "group by region_name,kv_name order by region_name,kv_name").getRowValue();
	}
	
	public Object getEmployeeDetailsRegionSchoolWiseDropbox() {
		return nativeRepository.executeQueries("select distinct ksm.region_name,ksm.kv_name ||' - '||ksm.kv_code as KVSchool, \r\n"
				+ "tp.teacher_name ||' (EmpCode: '||tp.teacher_employee_code||')' As EmpNameAndCode,\r\n"
				+ "case when tp.teacher_gender='1' then 'M' when tp.teacher_gender='2' then 'F' \r\n"
				+ "when tp.teacher_gender='3' then 'T' else '-' end as Gender,\r\n"
				+ "tp.teacher_dob,tp.teacher_mobile,td.dropbox_description as ReasonToMoveToDropBox from \r\n"
				+ "public.teacher_profile as tp join kv.kv_school_master as ksm on tp.kv_code=ksm.kv_code \r\n"
				+ "join public.teacher_dropbox as td on td.teacher_employee_code = tp.teacher_employee_code \r\n"
				+ "--join master.mst_teacher_position_type mtpt on mtpt.teacher_type_id=tp.last_promotion_position_type::numeric\r\n"
				+ "where ksm.school_status='1' and tp.kv_code<>'9999' and tp.drop_box_flag=1 order by ksm.region_name,KVSchool,EmpNameAndCode").getRowValue();
	}
	
	public Object getRegionSchoolWiseProfileNotUpdatedCurrentYear() {
		return nativeRepository.executeQueries("select region_name,kv_name, count(1) as NoOfEmpProfileAddedUpdated from public.teacher_profile tp \r\n"
				+ "join kv.kv_school_master as ksm on tp.kv_code=ksm.kv_code\r\n"
				+ "where (extract( 'year' from tp.modified_time)<> extract('year' from current_date) or tp.modified_time is null )\r\n"
				+ "and (tp.drop_box_flag in ('0') or tp.drop_box_flag is null ) and tp.kv_code<>'9999' and ksm.school_status='1'\r\n"
				+ "group by region_name,kv_name order by region_name,kv_name").getRowValue();

	}
	
	public Object getEmployeeDetailsProfileNotUpdatedCurrentYear() {
		return nativeRepository.executeQueries("select distinct ksm.region_name,ksm.kv_name ||' - '||ksm.kv_code as KVSchool, \r\n"
				+ "tp.teacher_name ||' (EmpCode: '||tp.teacher_employee_code||')' As EmpNameAndCode,\r\n"
				+ "case when tp.teacher_gender='1' then 'M' when tp.teacher_gender='2' then 'F' \r\n"
				+ "when tp.teacher_gender='3' then 'T' else '-' end as Gender,\r\n"
				+ "tp.teacher_dob,tp.teacher_mobile from \r\n"
				+ "public.teacher_profile as tp join kv.kv_school_master as ksm on tp.kv_code=ksm.kv_code \r\n"
				+ "--join master.mst_teacher_position_type mtpt on mtpt.teacher_type_id=tp.last_promotion_position_type::numeric\r\n"
				+ "where ksm.school_status='1' and tp.kv_code<>'9999' and \r\n"
				+ "(extract( 'year' from tp.modified_time)<> extract('year' from current_date) or tp.modified_time is null )\r\n"
				+ "and (tp.drop_box_flag in ('0') or tp.drop_box_flag is null ) order by ksm.region_name,KVSchool,EmpNameAndCode\r\n"
				+ "").getRowValue();	
	}
	
	public Object getRegionSchoolWiseProfileUpdatedAdded() {
		return nativeRepository.executeQueries("\r\n"
				+ "select region_name,kv_name, count(1) as NoOfEmpProfileAddedUpdated from public.teacher_profile tp \r\n"
				+ "join kv.kv_school_master as ksm on tp.kv_code=ksm.kv_code\r\n"
				+ "where ((extract( 'year' from tp.modified_time)= extract('year' from current_date)) \r\n"
				+ "	   or (extract( 'year' from tp.created_time)= extract('year' from current_date)) )\r\n"
				+ "and (tp.drop_box_flag in ('0') or tp.drop_box_flag is null ) and tp.kv_code<>'9999' and ksm.school_status='1'\r\n"
				+ "group by region_name,kv_name order by region_name,kv_name").getRowValue();
	}
	
	public Object getEmployeeDetailsProfileUpdatedAdded() {
		return nativeRepository.executeQueries("select distinct ksm.region_name,ksm.kv_name ||' - '||ksm.kv_code as KVSchool, \r\n"
				+ "tp.teacher_name ||' (EmpCode: '||tp.teacher_employee_code||')' As EmpNameAndCode,\r\n"
				+ "case when tp.teacher_gender='1' then 'M' when tp.teacher_gender='2' then 'F' \r\n"
				+ "when tp.teacher_gender='3' then 'T' else '-' end as Gender,\r\n"
				+ "tp.teacher_dob,tp.teacher_mobile from \r\n"
				+ "public.teacher_profile as tp join kv.kv_school_master as ksm on tp.kv_code=ksm.kv_code \r\n"
				+ "where ksm.school_status='1' and tp.kv_code<>'9999' and \r\n"
				+ "((extract( 'year' from tp.modified_time)= extract('year' from current_date))\r\n"
				+ " or (extract( 'year' from tp.created_time)= extract('year' from current_date)))\r\n"
				+ "and (tp.drop_box_flag in ('0') or tp.drop_box_flag is null ) order by ksm.region_name,KVSchool,EmpNameAndCodel").getRowValue();		
	}
	
	public Object getRegionSchoolWiseProfileUpdatedAddedToday() {
		return nativeRepository.executeQueries("select region_name,kv_name, count(1) as NoOfEmpProfileAddedUpdated from public.teacher_profile tp join kv.kv_school_master as ksm on tp.kv_code=ksm.kv_code\r\n"
				+ "where (tp.modified_time::date = current_date or tp.created_time::date = current_date)\r\n"
				+ "and (tp.drop_box_flag in ('0') or tp.drop_box_flag is null ) and tp.kv_code<>'9999' and ksm.school_status='1'\r\n"
				+ "group by region_name,kv_name order by region_name,kv_name");
	}
	
	public Object getEmployeeDetailsProfileUpdatedAddedToday() {
		return nativeRepository.executeQueries("select distinct ksm.region_name,ksm.kv_name ||' - '||ksm.kv_code as KVSchool, \r\n"
				+ "tp.teacher_name ||' (EmpCode: '||tp.teacher_employee_code||')' As EmpNameAndCode,\r\n"
				+ "case when tp.teacher_gender='1' then 'M' when tp.teacher_gender='2' then 'F' \r\n"
				+ "when tp.teacher_gender='3' then 'T' else '-' end as Gender,\r\n"
				+ "tp.teacher_dob,tp.teacher_mobile from \r\n"
				+ "public.teacher_profile as tp join kv.kv_school_master as ksm on tp.kv_code=ksm.kv_code \r\n"
				+ "where ksm.school_status='1' and tp.kv_code<>'9999' and \r\n"
				+ "(modified_time::date = current_date or created_time::date = current_date)\r\n"
				+ "and (tp.drop_box_flag in ('0') or tp.drop_box_flag is null ) order by ksm.region_name,KVSchool,EmpNameAndCode");
	}
	
	
	public Object getNoOfEmployeeAgeWise() {
		return nativeRepository.executeQueries("select sum(case when (age(tp.teacher_dob) >='18 years' and age(tp.teacher_dob) < '31 years') then 1 else 0 end ) as EmployeesOf18_30Years,\r\n"
				+ "sum(case when (age(tp.teacher_dob) >='31 years' and age(tp.teacher_dob) < '41 years') then 1 else 0 end ) as EmployeesOf31_40Years,\r\n"
				+ "sum(case when (age(tp.teacher_dob) >='41 years' and age(tp.teacher_dob) < '51 years') then 1 else 0 end ) as EmployeesOf41_50Years,\r\n"
				+ "sum(case when (age(tp.teacher_dob) >='51 years' and age(tp.teacher_dob) <= '60 years') then 1 else 0 end ) as EmployeesOf51_60Years\r\n"
				+ "from public.teacher_profile tp where tp.kv_code<>'9999' and (drop_box_flag=0 or drop_box_flag is null)");	
	}
	
	public Object getNoOfEmployeeGenderAgeWise() {
		return nativeRepository.executeQueries("select sum(case when (age(tp.teacher_dob) >='18 years' and age(tp.teacher_dob) < '31 years' and tp.teacher_gender='1') then 1 else 0 end ) as MaleEmployeesOf18_30Years,\r\n"
				+ "sum(case when (age(tp.teacher_dob) >='18 years' and age(tp.teacher_dob) < '31 years' and tp.teacher_gender='2') then 1 else 0 end ) as FemaleEmployeesOf18_30Years,\r\n"
				+ "sum(case when (age(tp.teacher_dob) >='31 years' and age(tp.teacher_dob) < '41 years' and tp.teacher_gender='1') then 1 else 0 end ) as MaleEmployeesOf31_40Years,\r\n"
				+ "sum(case when (age(tp.teacher_dob) >='31 years' and age(tp.teacher_dob) < '41 years' and tp.teacher_gender='2') then 1 else 0 end ) as FemaleEmployeesOf31_40Years,\r\n"
				+ "sum(case when (age(tp.teacher_dob) >='41 years' and age(tp.teacher_dob) < '51 years' and tp.teacher_gender='1') then 1 else 0 end ) as MaleEmployeesOf41_50Years,\r\n"
				+ "sum(case when (age(tp.teacher_dob) >='41 years' and age(tp.teacher_dob) < '51 years' and tp.teacher_gender='2') then 1 else 0 end ) as FemaleEmployeesOf41_50Years,\r\n"
				+ "sum(case when (age(tp.teacher_dob) >='51 years' and age(tp.teacher_dob) <= '60 years' and tp.teacher_gender='1') then 1 else 0 end ) as MaleEmployeesOf51_60Years,\r\n"
				+ "sum(case when (age(tp.teacher_dob) >='51 years' and age(tp.teacher_dob) <= '60 years' and tp.teacher_gender='2') then 1 else 0 end ) as FemaleEmployeesOf51_60Years\r\n"
				+ "from public.teacher_profile tp where tp.kv_code<>'9999' and (drop_box_flag=0 or drop_box_flag is null)");	
	}
	public Object getNoOfEmployeeRegionGenderAgeWise() {
		return nativeRepository.executeQueries("select ksm.region_name, sum(case when (age(tp.teacher_dob) >='18 years' and age(tp.teacher_dob) < '31 years' and tp.teacher_gender='1') then 1 else 0 end ) as MaleEmployeesOf18_30Years,\r\n"
				+ "sum(case when (age(tp.teacher_dob) >='18 years' and age(tp.teacher_dob) < '31 years' and tp.teacher_gender='2') then 1 else 0 end ) as FemaleEmployeesOf18_30Years,\r\n"
				+ "sum(case when (age(tp.teacher_dob) >='31 years' and age(tp.teacher_dob) < '41 years' and tp.teacher_gender='1') then 1 else 0 end ) as MaleEmployeesOf31_40Years,\r\n"
				+ "sum(case when (age(tp.teacher_dob) >='31 years' and age(tp.teacher_dob) < '41 years' and tp.teacher_gender='2') then 1 else 0 end ) as FemaleEmployeesOf31_40Years,\r\n"
				+ "sum(case when (age(tp.teacher_dob) >='41 years' and age(tp.teacher_dob) < '51 years' and tp.teacher_gender='1') then 1 else 0 end ) as MaleEmployeesOf41_50Years,\r\n"
				+ "sum(case when (age(tp.teacher_dob) >='41 years' and age(tp.teacher_dob) < '51 years' and tp.teacher_gender='2') then 1 else 0 end ) as FemaleEmployeesOf41_50Years,\r\n"
				+ "sum(case when (age(tp.teacher_dob) >='51 years' and age(tp.teacher_dob) <= '60 years' and tp.teacher_gender='1') then 1 else 0 end ) as MaleEmployeesOf51_60Years,\r\n"
				+ "sum(case when (age(tp.teacher_dob) >='51 years' and age(tp.teacher_dob) <= '60 years' and tp.teacher_gender='2') then 1 else 0 end ) as FemaleEmployeesOf51_60Years\r\n"
				+ "from public.teacher_profile tp join kv.kv_school_master as ksm on tp.kv_code=ksm.kv_code \r\n"
				+ "where ksm.school_status='1' and tp.kv_code<>'9999'and (drop_box_flag=0 or drop_box_flag is null)\r\n"
				+ "group by ksm.region_name order by ksm.region_name");
	}
	
//	public Object getNoOfEmployeeRegionGenderAgeWise() {
//		return nativeRepository.executeQueries("select ksm.region_name, sum(case when (age(tp.teacher_dob) >='18 years' and age(tp.teacher_dob) < '31 years' and tp.teacher_gender='1') then 1 else 0 end ) as MaleEmployeesOf18_30Years,\r\n"
//				+ "sum(case when (age(tp.teacher_dob) >='18 years' and age(tp.teacher_dob) < '31 years' and tp.teacher_gender='2') then 1 else 0 end ) as FemaleEmployeesOf18_30Years,\r\n"
//				+ "sum(case when (age(tp.teacher_dob) >='31 years' and age(tp.teacher_dob) < '41 years' and tp.teacher_gender='1') then 1 else 0 end ) as MaleEmployeesOf31_40Years,\r\n"
//				+ "sum(case when (age(tp.teacher_dob) >='31 years' and age(tp.teacher_dob) < '41 years' and tp.teacher_gender='2') then 1 else 0 end ) as FemaleEmployeesOf31_40Years,\r\n"
//				+ "sum(case when (age(tp.teacher_dob) >='41 years' and age(tp.teacher_dob) < '51 years' and tp.teacher_gender='1') then 1 else 0 end ) as MaleEmployeesOf41_50Years,\r\n"
//				+ "sum(case when (age(tp.teacher_dob) >='41 years' and age(tp.teacher_dob) < '51 years' and tp.teacher_gender='2') then 1 else 0 end ) as FemaleEmployeesOf41_50Years,\r\n"
//				+ "sum(case when (age(tp.teacher_dob) >='51 years' and age(tp.teacher_dob) <= '60 years' and tp.teacher_gender='1') then 1 else 0 end ) as MaleEmployeesOf51_60Years,\r\n"
//				+ "sum(case when (age(tp.teacher_dob) >='51 years' and age(tp.teacher_dob) <= '60 years' and tp.teacher_gender='2') then 1 else 0 end ) as FemaleEmployeesOf51_60Years\r\n"
//				+ "from public.teacher_profile tp join kv.kv_school_master as ksm on tp.kv_code=ksm.kv_code \r\n"
//				+ "where ksm.school_status='1' and tp.kv_code<>'9999'and (drop_box_flag=0 or drop_box_flag is null)\r\n"
//				+ "group by ksm.region_name order by ksm.region_name");
//	}
//	
	
}
