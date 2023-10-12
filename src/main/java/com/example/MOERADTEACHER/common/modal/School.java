package com.example.MOERADTEACHER.common.modal;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;



//@Data
//@Entity
//@Table(name = "sch_master")
public class School implements Serializable{
	private Integer school_id;
	private String udise_sch_code;
	private String school_name;
	private String state_cd;
	private String district_cd;
	private String block_cd;
	private String vill_ward_cd;
	private String cluster_cd;
	private Integer state_id;
	private Integer district_id;
	private Integer block_id;
	private Integer vill_ward_id;
	private Integer cluster_id;
	private Integer pincode;
	private Integer sch_loc_r_u;
	private Integer sch_category_id;
	private Integer sch_type_id;
	private Integer sch_mgmt_id;
	private Integer class_frm;
	private Integer class_to;
	private String inityear;
	private Integer sch_mgmt_center_id;
	private Integer school_status;
	private String sch_id_merged;
	private String sch_merged_year;
	private String remarks_any;
	private Integer is_modified;
	private String created_by;
	private Date created_time;
	private String modified_by;
	private Date modified_time;
	private String modified_by_label;
	private Integer sch_cat_ly;
	private Integer sch_mgmt_ly;
	private Integer sch_type_ly;
	private Integer sch_status_ly;
	private String udise_sch_code_ly;
	private Integer is_nsqf;
	private Integer latitude;
	private Integer longitude;
	private Integer service_req_id;
	private Integer ppsec_yn;
	private Integer cluster_id_2;
	private Integer vill_ward_id_2;
	private Integer block_id_2;
	private Integer status_overall;
	private Integer merge_teacher;
	private Integer merged_sch_id;
	private Integer sch_braod_mgmt_id;
	private Integer sch_broad_mgt_id;
	private Integer sch_broad_cat_id;
	private String state_name;
	private String district_name;
	private String block_name;
	private String sch_category_name;
	private String loc_name;
	private String sch_mgmt_name;
	private String sch_type_name;
	private String tr_cat_name;
	private String min_mgmt_name;
	private Integer min_mgmt_id;
	private Integer broad_mgmt_id;
}
