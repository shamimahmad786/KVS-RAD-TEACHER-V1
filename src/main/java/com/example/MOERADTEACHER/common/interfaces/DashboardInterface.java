package com.example.MOERADTEACHER.common.interfaces;

import java.util.List;
import java.util.Map;

import com.example.MOERADTEACHER.common.bean.DashboardBean;
import com.example.MOERADTEACHER.common.modal.KvsReport;
import com.example.MOERADTEACHER.common.util.QueryResult;

public interface DashboardInterface {
	 Map<Object,Object> getDashboard(DashboardBean data);
	 List<Map<String, Object>> getDashboardBasicCountDetails(Map<Object,Object> mp);
	 List<Map<String, Object>> getDashboardOnMoreClick(Map<Object,Object> mp);
	 List<Map<String, Object>> getkvsDashboardReport();
	 Object getRoDashboard(Map<String,Object> mp);
	 Object getDashboardEmployeeDetails();
Object getNoOfEmployeeRegionSchoolWiseExcludeDropbox();
	 Object getReportById(KvsReport data);
	 Object getNoOfEmployeeRegionSchoolWiseIncludeDropbox();
	 Object getNoOfEmployeeRegionSchoolWiseDropbox();
	 Object getEmployeeDetailsRegionSchoolWiseDropbox();
	 Object getRegionSchoolWiseProfileNotUpdatedCurrentYear();
	 Object getEmployeeDetailsProfileNotUpdatedCurrentYear();
	 Object getRegionSchoolWiseProfileUpdatedAdded();
	 Object getEmployeeDetailsProfileUpdatedAdded();
	 Object getRegionSchoolWiseProfileUpdatedAddedToday();
	 Object getEmployeeDetailsProfileUpdatedAddedToday();
	 Object getNoOfEmployeeAgeWise();
	 Object getNoOfEmployeeGenderAgeWise();
	 Object getNoOfEmployeeRegionGenderAgeWise();
}
