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
import com.example.MOERADTEACHER.common.bean.KvsDashboardBean;
import com.example.MOERADTEACHER.common.interfaces.DashboardInterface;
import com.example.MOERADTEACHER.common.modal.TeacherExperience;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;

@Service
public class DashboardImpl implements DashboardInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(DashboardImpl.class);

	@Autowired
	NativeRepository nativeRepository;

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
		} else if (String.valueOf(mp.get("dashboardType")).equalsIgnoreCase("N")) {
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

		} else if (String.valueOf(mp.get("dashboardType")).equalsIgnoreCase("S")) {

			String controllerOfficerQuery = "select teacher_name as controller_name,teacher_mobile as controller_mobile, teacher_email as controller_email from teacher_profile tp where tp.teacher_employee_code in (select employee_code from kv_controller_officer kco where institution_code ='"
					+ String.valueOf(mp.get("kvCode")) + "')";
			String profileQuery = "\r\n"
					+ "select ms2.schooladdress ,ksm.*,scm.category_id,ms.station_code ,ms.station_name  from kv.kv_school_master ksm  left join kv_controller_officer kco on kco.institution_code =ksm.kv_code left join uneecops.station_category_mapping scm  on ksm.station_code::int =scm.station_code  left join uneecops.m_station ms on scm.station_code =ms.station_code  left join uneecops.m_schools ms2 on ksm.kv_code =ms2.kv_code::varchar where  scm.is_active =true and  ksm.kv_code ='"
					+ String.valueOf(mp.get("kvCode")) + "';\r\n" + "";
			String typeEmployeeDetails = "select teacher_gender,count(*), '1' as teaching_nonteaching  from public.teacher_profile tp where tp.teaching_nonteaching ='1' and  kv_code='"
					+ String.valueOf(mp.get("kvCode")) + "' group by teacher_gender\r\n"
					+ "					union all\r\n"
					+ "select teacher_gender,count(*), '2' as teaching_nonteaching  from public.teacher_profile tp where tp.teaching_nonteaching ='2' and  kv_code='"
					+ String.valueOf(mp.get("kvCode")) + "' group by teacher_gender				\r\n" + " ";

			try {
				QueryResult controllerResultSet = nativeRepository.executeQueries(controllerOfficerQuery);
				finalObj.setEmployeeName(controllerResultSet.getRowValue().get(0).get("controller_name"));
				finalObj.setTeacherEmail(controllerResultSet.getRowValue().get(0).get("controller_email"));
				finalObj.setTeacherMobile(controllerResultSet.getRowValue().get(0).get("controller_mobile"));
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			try {
				QueryResult profileResultSet = nativeRepository.executeQueries(profileQuery);
				finalObj.setRegionCode(profileResultSet.getRowValue().get(0).get("region_code"));
				finalObj.setRegionName(profileResultSet.getRowValue().get(0).get("region_name"));
				finalObj.setStationCode(profileResultSet.getRowValue().get(0).get("station_code"));
				finalObj.setStationName(profileResultSet.getRowValue().get(0).get("station_name"));
				finalObj.setKvCode(profileResultSet.getRowValue().get(0).get("kv_code"));
				finalObj.setKvName(profileResultSet.getRowValue().get(0).get("kv_name"));
				finalObj.setSchoolAddress(profileResultSet.getRowValue().get(0).get("schooladdress"));
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			try {
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
					}
				}
			} catch (Exception ex) {
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
					teachingNonTeachingQuery = "select teacher_gender,count(*), '1' as teaching_nonteaching  from public.teacher_profile tp where tp.teaching_nonteaching ='1' and kv_code in (select ksm.kv_code from kv.kv_school_master ksm where ksm.region_code='"
							+ String.valueOf(mp.get("regionCode"))
							+ "' and ksm.school_status='1' and ksm.school_type ='1') group by teacher_gender \r\n"
							+ "union all \r\n"
							+ "select teacher_gender,count(*), '2' as teaching_nonteaching   from public.teacher_profile tp where tp.teaching_nonteaching ='2' and kv_code in (select ksm.kv_code from kv.kv_school_master ksm where ksm.region_code='"
							+ String.valueOf(mp.get("regionCode"))
							+ "' and ksm.school_status='1' and ksm.school_type ='1') group by teacher_gender\r\n" + "";
				} else if (String.valueOf(mp.get("dashboardType")).equalsIgnoreCase("N")) {
					teachingNonTeachingQuery = "select teacher_gender,count(*), '1' as teaching_nonteaching  from public.teacher_profile tp where tp.teaching_nonteaching ='1' and kv_code in (select ksm.kv_code from kv.kv_school_master ksm where ksm.school_status='1' ) group by teacher_gender \r\n"
							+ "union all \r\n"
							+ "select teacher_gender,count(*), '2' as teaching_nonteaching   from public.teacher_profile tp where tp.teaching_nonteaching ='2' and kv_code in (select ksm.kv_code from kv.kv_school_master ksm where ksm.school_status='1' ) group by teacher_gender\r\n"
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

}
