package com.example.MOERADTEACHER.common.transferservice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.transferrepository.TransferTempoaryDataRepository;
import com.example.MOERADTEACHER.common.util.NativeRepository;

@Service
public class TransferFileImpl {

	@Autowired
	TransferTempoaryDataRepository transferTempoaryDataRepository;
	
	@Autowired
	NativeRepository  nativeRepository;
	
	public Object getTempTransferData() {
		return transferTempoaryDataRepository.findAll();
	}
	
	public Map<String,Object>  confirmTransferData(){
		
		try {
		String query="\r\n"
				+ "insert into z_emp_details_3107 (teacher_id,emp_code,emp_name,gender,dob,post_id,subject_id,region_code,present_station_code,present_kv_code,present_kv_master_code,shift,doj_in_present_stn_irrespective_of_cadre,is_ner_recruited\r\n"
				+ ",isjcm_rjcm,is_pwd,is_hard_served,is_currently_in_hard,station_code_1,station_code_2,station_code_3,station_code_4,station_code_5,tot_tc,tot_tc2,tot_dc\r\n"
				+ ",transfer_applied_for,dc_applied_for,is_trasnfer_applied,allot_stn_code,allot_kv_code,allot_shift,transferred_under_cat,emp_transfer_status,is_displaced,elgible_yn,is_ner,apply_transfer_yn,ground_level,print_order,kv_name_present,kv_name_alloted,station_name1\r\n"
				+ ",station_name2,station_name3,station_name4,station_name5,region_name_present,region_code_alloted,region_name_alloted,station_name_present,station_name_alloted,post_name,subject_name,join_date,relieve_date,join_relieve_flag,transfer_type,modified_date_time\r\n"
				+ ",id,transferred_under_cat_id,transfer_query_type,is_automated_transfer,is_admin_transfer,is_joined_allocated_school,cancel_order_number,transfer_order_number,transfer_cancel_order_date,trasndfer_order_date\r\n"
				+ ",transfer_year) \r\n"
				+ "select teacher_id,emp_code,emp_name,gender,dob,post_id,subject_id,region_code,present_station_code,present_kv_code,present_kv_master_code,shift,doj_in_present_stn_irrespective_of_cadre,is_ner_recruited\r\n"
				+ ",isjcm_rjcm,is_pwd,is_hard_served,is_currently_in_hard,station_code_1,station_code_2,station_code_3,station_code_4,station_code_5,tot_tc,tot_tc2,tot_dc\r\n"
				+ ",transfer_applied_for,dc_applied_for,is_trasnfer_applied,allot_stn_code,allot_kv_code,allot_shift,transferred_under_cat,emp_transfer_status,is_displaced,elgible_yn,is_ner,apply_transfer_yn,ground_level,print_order,kv_name_present,kv_name_alloted,station_name1\r\n"
				+ ",station_name2,station_name3,station_name4,station_name5,region_name_present,region_code_alloted,region_name_alloted,station_name_present,station_name_alloted,post_name,subject_name,join_date,relieve_date,join_relieve_flag,transfer_type,modified_date_time\r\n"
				+ ",nextval('teacher_transfered_details_seq_id'),transferred_under_cat_id,transfer_query_type,is_automated_transfer,is_admin_transfer,is_joined_allocated_school,cancel_order_number,transfer_order_number,transfer_cancel_order_date,trasndfer_order_date\r\n"
				+ ",transfer_year from kvs_temp_transfer \r\n"
				+ "where transfer_type in ('A','AM')";
		
		nativeRepository.insertQueriesString(query);
		
		String queryHistory="\r\n"
				+ "insert into kvs_temp_transfer_history (teacher_id,emp_code,emp_name,gender,dob,post_id,subject_id,region_code,present_station_code,present_kv_code,present_kv_master_code,shift,doj_in_present_stn_irrespective_of_cadre,is_ner_recruited\r\n"
				+ ",isjcm_rjcm,is_pwd,is_hard_served,is_currently_in_hard,station_code_1,station_code_2,station_code_3,station_code_4,station_code_5,tot_tc,tot_tc2,tot_dc\r\n"
				+ ",transfer_applied_for,dc_applied_for,is_trasnfer_applied,allot_stn_code,allot_kv_code,allot_shift,transferred_under_cat,emp_transfer_status,is_displaced,elgible_yn,is_ner,apply_transfer_yn,ground_level,print_order,kv_name_present,kv_name_alloted,station_name1\r\n"
				+ ",station_name2,station_name3,station_name4,station_name5,region_name_present,region_code_alloted,region_name_alloted,station_name_present,station_name_alloted,post_name,subject_name,join_date,relieve_date,join_relieve_flag,transfer_type,modified_date_time\r\n"
				+ ",id,transferred_under_cat_id,transfer_query_type,is_automated_transfer,is_admin_transfer,is_joined_allocated_school,cancel_order_number,transfer_order_number,transfer_cancel_order_date,trasndfer_order_date\r\n"
				+ ",transfer_year,final_submit_date) \r\n"
				+ "select (teacher_id,emp_code,emp_name,gender,dob,post_id,subject_id,region_code,present_station_code,present_kv_code,present_kv_master_code,shift,doj_in_present_stn_irrespective_of_cadre,is_ner_recruited\r\n"
				+ ",isjcm_rjcm,is_pwd,is_hard_served,is_currently_in_hard,station_code_1,station_code_2,station_code_3,station_code_4,station_code_5,tot_tc,tot_tc2,tot_dc\r\n"
				+ ",transfer_applied_for,dc_applied_for,is_trasnfer_applied,allot_stn_code,allot_kv_code,allot_shift,transferred_under_cat,emp_transfer_status,is_displaced,elgible_yn,is_ner,apply_transfer_yn,ground_level,print_order,kv_name_present,kv_name_alloted,station_name1\r\n"
				+ ",station_name2,station_name3,station_name4,station_name5,region_name_present,region_code_alloted,region_name_alloted,station_name_present,station_name_alloted,post_name,subject_name,join_date,relieve_date,join_relieve_flag,transfer_type,modified_date_time\r\n"
				+ ",id,transferred_under_cat_id,transfer_query_type,is_automated_transfer,is_admin_transfer,is_joined_allocated_school,cancel_order_number,transfer_order_number,transfer_cancel_order_date,trasndfer_order_date\r\n"
				+ ",transfer_year,now()) from kvs_temp_transfer \r\n";
				
		nativeRepository.insertQueriesString(queryHistory);
		
		
		String queryTempDelete="delete from kvs_temp_transfer";
		nativeRepository.updateQueries(queryTempDelete);
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	
	
	
}
