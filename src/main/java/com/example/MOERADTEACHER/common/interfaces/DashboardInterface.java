package com.example.MOERADTEACHER.common.interfaces;

import java.util.List;
import java.util.Map;

import com.example.MOERADTEACHER.common.bean.DashboardBean;
import com.example.MOERADTEACHER.common.util.QueryResult;

public interface DashboardInterface {
	 Map<Object,Object> getDashboard(DashboardBean data);
	 List<Map<String, Object>> getDashboardBasicCountDetails(Map<Object,Object> mp);
	 List<Map<String, Object>> getDashboardOnMoreClick(Map<Object,Object> mp);
	 List<Map<String, Object>> getkvsDashboardReport();
	 Object getRoDashboard(Map<String,Object> mp);
}
