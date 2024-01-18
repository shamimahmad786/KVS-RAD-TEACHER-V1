package com.example.MOERADTEACHER.common.transfercontroller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.example.MOERADTEACHER.common.modal.KvSchoolMaster;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
import com.example.MOERADTEACHER.common.repository.KvSchoolMasterRepo;
import com.example.MOERADTEACHER.common.repository.TeacherProfileRepository;
import com.example.MOERADTEACHER.common.transferbean.ExcelFileBean;
import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferedDetails;
import com.example.MOERADTEACHER.common.transfermodel.TransferTempoaryData;
import com.example.MOERADTEACHER.common.transferrepository.TeacherTransferedDetailsRepository;
import com.example.MOERADTEACHER.common.transferrepository.TransferTempoaryDataRepository;
import com.example.MOERADTEACHER.common.transferservice.TransferFileImpl;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.common.util.NativeRepository;

@RestController
@RequestMapping(ApiPaths.TransferFileCtrl.CTRL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransferFileCtrl {

	@Value("${userBucket.path}")
	private String UPLOADED_FOLDER;

	@Autowired
	NativeRepository nativeRepository;

	@Autowired
	TeacherTransferedDetailsRepository teacherTransferedDetailsRepository;

	@Autowired
	TeacherProfileRepository teacherProfileRepository;

	@Autowired
	KvSchoolMasterRepo kvSchoolMasterRepo;

	@Autowired
	TransferTempoaryDataRepository transferTempoaryDataRepository;

	@Autowired
	TransferFileImpl transferFileImpl;

	@RequestMapping(value = "/uploadDoc", method = RequestMethod.POST)
//	public ResponseEntity<?> uploadDoc(@ModelAttribute ExcelFileBean data, HttpServletRequest request)
//			throws Exception {
	public ResponseEntity<?> uploadDoc(@RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws Exception {
		Map<String, Object> mp = new HashMap<String, Object>();
		Set<String> duplicateset = new HashSet<String>();
		List<String> dupList = new ArrayList<String>();
		try {

			String queryTempDelete = "delete from kvs_temp_transfer";
			nativeRepository.updateQueries(queryTempDelete);

			String empCode = null;
			String kvCode = null;
			Integer tempTransferType = null; // 0- for admin, 1 - for Modification, 2- Not posible Previouse Transfer
												// huv
												// not been done
			DataFormatter df = new DataFormatter();
			Workbook workbook = new XSSFWorkbook(file.getInputStream());
			Sheet datatypeSheet = null;
			datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			Integer totalRows = datatypeSheet.getPhysicalNumberOfRows();
			DateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
			String transferOrderDate = "";

			datatypeSheet.setColumnHidden(8, false);

			while (iterator.hasNext()) {

				Integer joiningCount = 0;
				TransferTempoaryData ttd = new TransferTempoaryData();
				Row currentRow = iterator.next();

				if (currentRow.getRowNum() == 0) {
					if (!df.formatCellValue(currentRow.getCell(8)).equalsIgnoreCase("MOE-786")) {
						mp.put("status", 0);
						mp.put("message", "Not Valid Template. Please down excel file and prepare data");
						return ResponseEntity.ok(mp);
					}
				}

				if (currentRow.getRowNum() > 0) {
					if (df.formatCellValue(currentRow.getCell(7)).contains(".")) {
						transferOrderDate = df.formatCellValue(currentRow.getCell(7)).split("\\.")[2] + "-"
								+ df.formatCellValue(currentRow.getCell(7)).split("\\.")[1] + "-"
								+ df.formatCellValue(currentRow.getCell(7)).split("\\.")[0];
					} else if (df.formatCellValue(currentRow.getCell(7)).contains("-")) {
						transferOrderDate = df.formatCellValue(currentRow.getCell(7)).split("\\-")[2] + "-"
								+ df.formatCellValue(currentRow.getCell(7)).split("\\-")[1] + "-"
								+ df.formatCellValue(currentRow.getCell(7)).split("\\-")[0];
					} else if (df.formatCellValue(currentRow.getCell(7)).contains("/")) {
						transferOrderDate = df.formatCellValue(currentRow.getCell(7)).split("\\/")[2] + "-"
								+ df.formatCellValue(currentRow.getCell(7)).split("\\/")[1] + "-"
								+ df.formatCellValue(currentRow.getCell(7)).split("\\/")[0];
					}
					System.out.println("Transfer Order Date---->" + df.formatCellValue(currentRow.getCell(6)));
					empCode = df.formatCellValue(currentRow.getCell(1));
					kvCode = df.formatCellValue(currentRow.getCell(3));
					System.out.println("empCode---->" + empCode);
					System.out.println("kvCode---->" + kvCode);
					List<TeacherTransferedDetails> tObj = teacherTransferedDetailsRepository.getByEmpCode(empCode);
					if (tObj != null) {
						for (int i = 0; i < tObj.size(); i++) {
							if (tObj.get(i).getJoinDate() == null) {
								++joiningCount;
							}
						}
					}
					KvSchoolMaster allocatedSchoolObj = kvSchoolMasterRepo.findAllByKvCode(kvCode);
					TeacherProfile tpObj = teacherProfileRepository.findAllByTeacherEmployeeCode(empCode);
					System.out.println("Present kv code--->" + tpObj.getKvCode());
					if (allocatedSchoolObj.getKvCode().equalsIgnoreCase(tpObj.getKvCode())) {
						mp.put("status", 0);
						mp.put("message", "Employee ("+tpObj.getTeacherEmployeeCode()+") does not transfer on same school");
						transferTempoaryDataRepository.deleteAll();
						return ResponseEntity.ok(mp);
					}

					System.out.println("joiningCount--->" + joiningCount);

					if (joiningCount == 0) {

						KvSchoolMaster schoolObj = kvSchoolMasterRepo
								.findAllByKvCode(String.valueOf(tpObj.getKvCode()));

						tempTransferType = 0;
						ttd.setEmpName(tpObj.getTeacherName());
						ttd.setEmpCode(tpObj.getTeacherEmployeeCode());
						ttd.setDob(tpObj.getTeacherDob());
						ttd.setGender(Integer.parseInt(String.valueOf(tpObj.getTeacherGender())));
						ttd.setRegionCode(Integer.parseInt(String.valueOf(schoolObj.getRegionCode())));
						ttd.setRegionNamePresent(schoolObj.getRegionName());
						ttd.setPresentStationCode(Integer.parseInt(String.valueOf(schoolObj.getStationCode())));
						ttd.setStationNamePresent(schoolObj.getStateName());
						ttd.setKvNamePresent(schoolObj.getKvName());
						ttd.setPresentKvCode(schoolObj.getKvCode());
						ttd.setPresentKvMasterCode(schoolObj.getKvCode());
						ttd.setShift(Integer.parseInt(String.valueOf(schoolObj.getShiftType())));
						ttd.setTeacherId(tpObj.getTeacherId());
						ttd.setPostId(Integer.parseInt(String.valueOf(tpObj.getLastPromotionPositionType())));
						ttd.setPostName(String.valueOf(nativeRepository.executeQueries(
								"select * from public.get_film6('master.mst_teacher_position_type', 'organization_teacher_type_name', 'organization_teacher_type_id="
										+ tpObj.getLastPromotionPositionType() + "')")
								.getRowValue().get(0).get("reason")));
						ttd.setSubjectId(
								Integer.parseInt(String.valueOf(tpObj.getWorkExperienceAppointedForSubject())));
						ttd.setSubjectName(String.valueOf(nativeRepository.executeQueries(
								"select * from public.get_film6('master.configured_position_subject_map cpsm , master.mst_teacher_position_type mtpt , master.mst_teacher_subject mts', ' mts.subject_name', 'mtpt.teacher_type_id = cpsm.teacher_type_id and cpsm.subject_id = mts.subject_id and mtpt.application_id::integer =2 and mtpt.teacher_type_id ="
										+ tpObj.getLastPromotionPositionType() + " ')")
								.getRowValue().get(0).get("reason")));
						ttd.setDojInPresentStnIrrespectiveOfCadre(
								tpObj.getWorkExperiencePositionTypePresentStationStartDate());
						ttd.setTransferType("2");
						ttd.setIsAdminTransfer(true);
						ttd.setIsjcmRjcm(9999);
						ttd.setIsPwd(9999);
						ttd.setIsHardServed(9999);
						ttd.setIsCurrentlyInHard(9999);
						ttd.setStationCode_5(9999);
						ttd.setTotTc(9999);
						ttd.setTotTc2(9999);
						ttd.setTotDc(9999);
						ttd.setTransferAppliedFor(9999);
						ttd.setDcAppliedFor(9999);
						ttd.setIsTrasnferApplied(9999);
						ttd.setTransferredUnderCat(9999);
						ttd.setEmpTransferStatus(9999);
						ttd.setIsDisplaced(9999);
						ttd.setElgibleYn(9999);
						ttd.setIsNer(9999);
						ttd.setApplyTransferYn(9999);
						ttd.setGroundLevel(9999);
						ttd.setPrintOrder(9999);
						ttd.setTransferYear("2023");
						ttd.setTransferType("A");
						ttd.setTempTransferType(tempTransferType);
						ttd.setTransferredUnderCatId(Integer.parseInt(df.formatCellValue(currentRow.getCell(5))));
						ttd.setTransferOrderNumber(df.formatCellValue(currentRow.getCell(6)));
						ttd.setTrasndferOrderDate(new SimpleDateFormat("yyyy-MM-dd").parse(transferOrderDate));

						ttd.setRegionNameAlloted(allocatedSchoolObj.getRegionName());
						ttd.setRegionCodeAlloted(allocatedSchoolObj.getRegionCode());
						ttd.setAllotStnCode(Integer.parseInt(String.valueOf(allocatedSchoolObj.getStationCode())));
						ttd.setStationNameAlloted(allocatedSchoolObj.getStationName());
						ttd.setAllotShift(Integer.parseInt(String.valueOf(allocatedSchoolObj.getShiftType())));
						ttd.setAllotKvCode(allocatedSchoolObj.getKvCode());
						ttd.setKvNameAlloted(allocatedSchoolObj.getKvName());

						if (!duplicateset.add(tpObj.getTeacherEmployeeCode())) {
							dupList.add(tpObj.getTeacherEmployeeCode());
						}

						transferTempoaryDataRepository.save(ttd);

					} else if (joiningCount == 1) {
						tempTransferType = 1;
//					TeacherProfile	tpObj=teacherProfileRepository.findAllByTeacherEmployeeCode(empCode);
						KvSchoolMaster schoolObj = kvSchoolMasterRepo
								.findAllByKvCode(String.valueOf(tpObj.getKvCode()));

						TeacherTransferedDetails addModified = new TeacherTransferedDetails();

						ttd.setRegionCode(Integer.parseInt(String.valueOf(schoolObj.getRegionCode())));
						ttd.setRegionNamePresent(schoolObj.getRegionName());
						ttd.setPresentStationCode(Integer.parseInt(String.valueOf(schoolObj.getStationCode())));
						ttd.setStationNamePresent(schoolObj.getStateName());
						ttd.setKvNamePresent(schoolObj.getKvName());
						ttd.setPresentKvCode(schoolObj.getKvCode());
						ttd.setPresentKvMasterCode(schoolObj.getKvCode());
						ttd.setAllotKvCode(allocatedSchoolObj.getKvCode());
						ttd.setKvNameAlloted(allocatedSchoolObj.getKvName());
						ttd.setAllotShift(Integer.parseInt(String.valueOf(allocatedSchoolObj.getShiftType())));
						ttd.setStationNameAlloted(allocatedSchoolObj.getStationName());
						ttd.setAllotStnCode(Integer.parseInt(String.valueOf(allocatedSchoolObj.getStationCode())));
						ttd.setRegionNameAlloted(allocatedSchoolObj.getRegionName());
						ttd.setRegionCodeAlloted(allocatedSchoolObj.getRegionCode());
						ttd.setTransferType("AM");
//					ttd.setTransferredUnderCat(Integer.parseInt(df.formatCellValue(currentRow.getCell(4))));
						ttd.setTransferredUnderCatId(Integer.parseInt(df.formatCellValue(currentRow.getCell(5))));
						ttd.setIsAdminTransfer(true);
						ttd.setIsAutomatedTransfer(false);
						ttd.setTransferYear("2023");
						ttd.setTransferOrderNumber(df.formatCellValue(currentRow.getCell(6)));
						ttd.setTrasndferOrderDate(new SimpleDateFormat("yyyy-MM-dd").parse(transferOrderDate));
//					addModified.setApplyTransferYn(applyTransferYn);
						ttd.setDob(tpObj.getTeacherDob());
//					addModified.setDojInPresentStnIrrespectiveOfCadre(dojInPresentStnIrrespectiveOfCadre);
//					addModified.setElgibleYn(elgibleYn);
						ttd.setEmpCode(tpObj.getTeacherEmployeeCode());
						ttd.setEmpName(tpObj.getTeacherName());
//					addModified.setEmpTransferStatus(empTransferStatus);
						ttd.setGender(Integer.parseInt(String.valueOf(tpObj.getTeacherGender())));
//					addModified.setGroundLevel(groundLevel);
						ttd.setIsCurrentlyInHard(9999);
//					addModified.setIsDisplaced(isDisplaced);
						ttd.setIsHardServed(9999);
						ttd.setIsjcmRjcm(9999);
						ttd.setIsNer(9999);
						ttd.setIsNerRecruited(9999);
						ttd.setIsPwd(9999);
//					addModified.setIsTrasnferApplied(isTrasnferApplied);
						ttd.setPostId(Integer.parseInt(String.valueOf(tpObj.getLastPromotionPositionType())));
						ttd.setPostName(String.valueOf(nativeRepository.executeQueries(
								"select * from public.get_film6('master.mst_teacher_position_type', 'organization_teacher_type_name', 'organization_teacher_type_id="
										+ tpObj.getLastPromotionPositionType() + "')")
								.getRowValue().get(0).get("reason")));

//					addModified.setPresentKvCode(transDetail.get(0).getAllotKvCode());          
//					addModified.setPresentKvMasterCode(transDetail.get(0).getAllotKvCode());

						ttd.setPresentStationCode(Integer.parseInt(String.valueOf(schoolObj.getStationCode())));
						ttd.setSubjectId(
								Integer.parseInt(String.valueOf(tpObj.getWorkExperienceAppointedForSubject())));
						ttd.setSubjectName(String.valueOf(nativeRepository.executeQueries(
								"select * from public.get_film6('master.configured_position_subject_map cpsm , master.mst_teacher_position_type mtpt , master.mst_teacher_subject mts', ' mts.subject_name', 'mtpt.teacher_type_id = cpsm.teacher_type_id and cpsm.subject_id = mts.subject_id and mtpt.application_id::integer =2 and mtpt.teacher_type_id ="
										+ tpObj.getLastPromotionPositionType() + " ')")
								.getRowValue().get(0).get("reason")));
						ttd.setTeacherId(tpObj.getTeacherId());
//					addModified.setTransferQueryType(tpObj.getTransferQueryType());
						ttd.setIsjcmRjcm(9999);
						ttd.setIsPwd(9999);
						ttd.setIsHardServed(9999);
						ttd.setIsCurrentlyInHard(9999);
						ttd.setStationCode_5(9999);
						ttd.setTotTc(9999);
						ttd.setTotTc2(9999);
						ttd.setTotDc(9999);
						ttd.setTransferAppliedFor(9999);
						ttd.setDcAppliedFor(9999);
						ttd.setIsTrasnferApplied(9999);
						ttd.setTransferredUnderCat(9999);
						ttd.setEmpTransferStatus(9999);
						ttd.setIsDisplaced(9999);
						ttd.setElgibleYn(9999);
						ttd.setIsNer(9999);
						ttd.setApplyTransferYn(9999);
						ttd.setGroundLevel(9999);
						ttd.setPrintOrder(9999);
						ttd.setTempTransferType(tempTransferType);

						if (!duplicateset.add(tpObj.getTeacherEmployeeCode())) {
							dupList.add(tpObj.getTeacherEmployeeCode());
						}

					} else if (joiningCount > 1) {
						tempTransferType = 2;

//					TeacherProfile	tpObj=teacherProfileRepository.findAllByTeacherEmployeeCode(empCode);
						KvSchoolMaster schoolObj = kvSchoolMasterRepo
								.findAllByKvCode(String.valueOf(tpObj.getKvCode()));

						ttd.setEmpName(tpObj.getTeacherName());
						ttd.setEmpCode(tpObj.getTeacherEmployeeCode());
						ttd.setDob(tpObj.getTeacherDob());
						ttd.setGender(Integer.parseInt(String.valueOf(tpObj.getTeacherGender())));
						ttd.setRegionCode(Integer.parseInt(String.valueOf(schoolObj.getRegionCode())));
						ttd.setRegionNamePresent(schoolObj.getRegionName());
						ttd.setPresentStationCode(Integer.parseInt(String.valueOf(schoolObj.getStationCode())));
						ttd.setStationNamePresent(schoolObj.getStateName());
						ttd.setKvNamePresent(schoolObj.getKvName());
						ttd.setPresentKvCode(schoolObj.getKvCode());
						ttd.setPresentKvMasterCode(schoolObj.getKvCode());
						ttd.setShift(Integer.parseInt(String.valueOf(schoolObj.getShiftType())));
						ttd.setTeacherId(tpObj.getTeacherId());
						ttd.setPostId(Integer.parseInt(String.valueOf(tpObj.getLastPromotionPositionType())));
						ttd.setPostName(String.valueOf(nativeRepository.executeQueries(
								"select * from public.get_film6('master.mst_teacher_position_type', 'organization_teacher_type_name', 'organization_teacher_type_id="
										+ tpObj.getLastPromotionPositionType() + "')")
								.getRowValue().get(0).get("reason")));
						ttd.setSubjectId(
								Integer.parseInt(String.valueOf(tpObj.getWorkExperienceAppointedForSubject())));
						ttd.setSubjectName(String.valueOf(nativeRepository.executeQueries(
								"select * from public.get_film6('master.configured_position_subject_map cpsm , master.mst_teacher_position_type mtpt , master.mst_teacher_subject mts', ' mts.subject_name', 'mtpt.teacher_type_id = cpsm.teacher_type_id and cpsm.subject_id = mts.subject_id and mtpt.application_id::integer =2 and mtpt.teacher_type_id ="
										+ tpObj.getLastPromotionPositionType() + " ')")
								.getRowValue().get(0).get("reason")));
						ttd.setDojInPresentStnIrrespectiveOfCadre(
								tpObj.getWorkExperiencePositionTypePresentStationStartDate());
						ttd.setTransferType("2");
						ttd.setIsAdminTransfer(true);
						ttd.setIsjcmRjcm(9999);
						ttd.setIsPwd(9999);
						ttd.setIsHardServed(9999);
						ttd.setIsCurrentlyInHard(9999);
						ttd.setStationCode_5(9999);
						ttd.setTotTc(9999);
						ttd.setTotTc2(9999);
						ttd.setTotDc(9999);
						ttd.setTransferAppliedFor(9999);
						ttd.setDcAppliedFor(9999);
						ttd.setIsTrasnferApplied(9999);
						ttd.setTransferredUnderCat(9999);
						ttd.setEmpTransferStatus(9999);
						ttd.setIsDisplaced(9999);
						ttd.setElgibleYn(9999);
						ttd.setIsNer(9999);
						ttd.setApplyTransferYn(9999);
						ttd.setGroundLevel(9999);
						ttd.setPrintOrder(9999);
						ttd.setTransferYear("2023");
						ttd.setTransferType("NA");
						ttd.setTempTransferType(tempTransferType);
						ttd.setTransferOrderNumber(df.formatCellValue(currentRow.getCell(6)));
						System.out.println("transferOrderDate---" + transferOrderDate);
						ttd.setTrasndferOrderDate(new SimpleDateFormat("yyyy-MM-dd").parse(transferOrderDate));
						ttd.setTransferredUnderCatId(Integer.parseInt(df.formatCellValue(currentRow.getCell(5))));
						ttd.setRegionNameAlloted(allocatedSchoolObj.getRegionName());
						ttd.setRegionCodeAlloted(allocatedSchoolObj.getRegionCode());
						ttd.setAllotStnCode(Integer.parseInt(String.valueOf(allocatedSchoolObj.getStationCode())));
						ttd.setStationNameAlloted(allocatedSchoolObj.getStationName());
						ttd.setAllotShift(Integer.parseInt(String.valueOf(allocatedSchoolObj.getShiftType())));
						ttd.setAllotKvCode(allocatedSchoolObj.getKvCode());
						ttd.setKvNameAlloted(allocatedSchoolObj.getKvName());

						transferTempoaryDataRepository.save(ttd);

						if (!duplicateset.add(tpObj.getTeacherEmployeeCode())) {
							dupList.add(tpObj.getTeacherEmployeeCode());
						}

					}

					System.out.println("Before temporary save");
					transferTempoaryDataRepository.save(ttd);
//				Save `In Temprary Table

				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (dupList.size() > 0) {
			mp.put("status", 0);
			mp.put("message", "Excel file has duplicat employee. Please check and remove");
			transferTempoaryDataRepository.deleteAll();
			return ResponseEntity.ok(mp);
		} else {
			mp.put("status", 1);
			mp.put("message", "File Uploaded Sucessfully");

		}
		return ResponseEntity.ok(mp);

	}

	@RequestMapping(value = "/getTempTransferData", method = RequestMethod.POST)
	public ResponseEntity<?> getTempTransferData(@ModelAttribute ExcelFileBean data, HttpServletRequest request) {
		return ResponseEntity.ok(transferFileImpl.getTempTransferData());
	}

	@RequestMapping(value = "/confirmTransferData", method = RequestMethod.POST)
	public ResponseEntity<?> confirmTransferData() {
		return ResponseEntity.ok(transferFileImpl.confirmTransferData());
	}

//
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver canBeCalledAnything() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		return resolver;

	}

}
