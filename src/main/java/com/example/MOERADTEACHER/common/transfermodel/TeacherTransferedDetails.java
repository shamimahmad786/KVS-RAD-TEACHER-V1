package com.example.MOERADTEACHER.common.transfermodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "z_emp_details_3107", schema="public")
@Data
public class TeacherTransferedDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="teacher_transfered_details_id")
	@SequenceGenerator(name="teacher_transfered_details_id",sequenceName="teacher_transfered_details_seq_id", allocationSize=1)
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
	public Integer presentKvCode;
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
	public Integer allotKvCode;
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
    @Column(name="join_date")
	public String joinDate;
    @Column(name="relieve_date")
	public String relieveDate;
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
    

    @PrePersist
    void updatedAt() {
      this.modifiedDateTime = new Date();
    }
}
