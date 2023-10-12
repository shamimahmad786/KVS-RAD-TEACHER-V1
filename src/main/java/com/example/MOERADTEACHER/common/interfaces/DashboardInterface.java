package com.example.MOERADTEACHER.common.interfaces;

import java.util.List;
import java.util.Map;

import com.example.MOERADTEACHER.common.bean.DashboardBean;

public interface DashboardInterface {
	 Map<Object,Object> getDashboard(DashboardBean data);
	 List<Map<String, Object>> getDashboardBasicCountDetails(Map<Object,Object> mp);
	 List<Map<String, Object>> getDashboardOnMoreClick(Map<Object,Object> mp);
	 List<Map<String, Object>> getkvsDashboardReport();
}
