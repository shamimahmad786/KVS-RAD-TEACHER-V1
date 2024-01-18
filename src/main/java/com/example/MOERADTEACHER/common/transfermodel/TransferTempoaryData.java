package com.example.MOERADTEACHER.common.transfermodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

//import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name = "kvs_temp_transfer", schema="public")
@Data
public class TransferTempoaryData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    public Long id; 
    @Column(name="teacher_id")
	public Integer teacherId;
    @Column(name="emp_code")
    public String empCode;
    @Column(name="emp_name")
	public String empName;
    @Column(name="gender")
	public Integer gender;
    @Column(name="dob")
	public Date dob;
    @Column(name="post_id")
	public Integer postId;
    @Column(name="subject_id")
	public Integer subjectId;
    @Column(name="region_code")
	public Integer regionCode;
    @Column(name="present_station_code")
	public Integer presentStationCode;
    @Column(name="present_kv_code")
	public String presentKvCode;
    @Column(name="present_kv_master_code")
	public String presentKvMasterCode;
    @Column(name="shift")
	public Integer shift;
    @Column(name="doj_in_present_stn_irrespective_of_cadre")
	public Date dojInPresentStnIrrespectiveOfCadre;
    @Column(name="is_ner_recruited")
	public Integer isNerRecruited;
    @Column(name="isjcm_rjcm")
	public Integer isjcmRjcm;
    @Column(name="is_pwd")
	public Integer isPwd;
    @Column(name="is_hard_served")
	public Integer isHardServed;
    @Column(name="is_currently_in_hard")
	public Integer isCurrentlyInHard;
    @Column(name="station_code_1")
	public Integer stationCode_1;
    @Column(name="station_code_2")
	public Integer stationCode_2;
    @Column(name="station_code_3")
	public Integer stationCode_3;
    @Column(name="station_code_4")
	public Integer stationCode_4;
    @Column(name="station_code_5")
	public Integer stationCode_5;
    @Column(name="tot_tc")
	public Integer totTc;
    @Column(name="tot_tc2")
	public Integer totTc2;
    @Column(name="tot_dc")
	public Integer totDc;
    @Column(name="transfer_applied_for")
	public Integer transferAppliedFor;
    @Column(name="dc_applied_for")
	public Integer dcAppliedFor;
    @Column(name="is_trasnfer_applied")
	public Integer isTrasnferApplied;
    @Column(name="allot_stn_code")
	public Integer allotStnCode;
    @Column(name="allot_kv_code")
	public String allotKvCode;
    @Column(name="allot_shift")
	public Integer allotShift;
    @Column(name="transferred_under_cat")
	public Integer transferredUnderCat;
    @Column(name="emp_transfer_status")
	public Integer empTransferStatus;
    @Column(name="is_displaced")
	public Integer isDisplaced;
    @Column(name="elgible_yn")
	public Integer elgibleYn;
    @Column(name="is_ner")
	public Integer isNer;
    @Column(name="apply_transfer_yn")
	public Integer applyTransferYn;
    @Column(name="ground_level")
	public Integer groundLevel;
    @Column(name="print_order")
	public Integer printOrder;
    @Column(name="kv_name_present")
	public String kvNamePresent;
    @Column(name="kv_name_alloted")
	public String kvNameAlloted;
    @Column(name="station_name1")
	public String stationName1;
    @Column(name="station_name2")
	public String stationName2;
    @Column(name="station_name3")
	public String stationName3;
    @Column(name="station_name4")
	public String stationName4;
    @Column(name="station_name5")
	public String stationName5;
    @Column(name="region_name_present")
	public String regionNamePresent;
    @Column(name="region_code_alloted")
	public String regionCodeAlloted;
    @Column(name="region_name_alloted")
	public String regionNameAlloted;
    @Column(name="station_name_present")
	public String stationNamePresent;
    @Column(name="station_name_alloted")
	public String stationNameAlloted;
    @Column(name="post_name")
	public String postName;
    @Column(name="subject_name")
	public String subjectName;
//    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name="join_date")
	public Date joinDate;
//    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name="relieve_date")
	public Date relieveDate;
    @Column(name="join_relieve_flag")
	public String joinRelieveFlag;
    @Column(name="transfer_type")
	public String transferType;
    @Column(name="modified_date_time")
    public Date modifiedDateTime;
    @Column(name="transferred_under_cat_id")
    public Integer transferredUnderCatId;
    @Column(name="transfer_query_type")
    public Integer transferQueryType;  //1-National,2 -presant school,3- allocated school
    @Column(name="is_admin_transfer")
    public Boolean isAdminTransfer;
    @Column(name="is_automated_transfer")
    public Boolean isAutomatedTransfer;
    @Column(name="transfer_order_number")
    public String transferOrderNumber;
    @Column(name="cancel_order_number")
    public String cancelOrderNumber;
    @Column(name="is_joined_allocated_school")
    public Boolean isJoinedAllocatedSchool;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
    @DateTimeFormat(pattern="dd-MM-yyyy")
    @Column(name="trasndfer_order_date")
    public Date trasndferOrderDate;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name="transfer_cancel_order_date")
    public Date transferCancelOrderDate;
    @Column(name="transfer_year")
    public String transferYear;
    @Column(name="temptransfertype")
    public Integer tempTransferType;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
    @Column(name="upload_date")
    public Date uploadDate;
}
