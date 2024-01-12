package com.example.MOERADTEACHER.common.transfercontroller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.MOERADTEACHER.common.bean.TransferSpouseBean;
import com.example.MOERADTEACHER.common.modal.Teacher;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
//import com.example.MOERADTEACHER.common.service.QualificationImpl;
import com.example.MOERADTEACHER.common.transferbean.DocumentBean;
import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferDeclaration;
import com.example.MOERADTEACHER.common.transfermodel.TransferHistory;
import com.example.MOERADTEACHER.common.transfermodel.TransferKVTeacherDetails;
import com.example.MOERADTEACHER.common.transferservice.TransferImpl;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.common.util.CustomObjectMapper;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.example.MOERADTEACHER.common.util.ResponseEntityBeans;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(ApiPaths.TransferCtrl.CTRL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransferController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransferController.class);
	@Autowired
	TransferImpl transferImpl;

	@Value("${userBucket.path}")
	private String UPLOADED_FOLDER;
	
	@Autowired
	CustomObjectMapper customObjectMapper;
	

	@RequestMapping(value = "/saveTeacherTransfer", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> saveTeacherTransfer(@RequestBody String data,
			@RequestHeader("username") String username) throws Exception {

		
		// System.out.println(data);
		
//		CustomResponse custRes = new CustomResponse();
//		if (username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return ResponseEntity.ok(custRes);
//		}
	

		ObjectMapper mapperObj = new ObjectMapper();
		TransferKVTeacherDetails tdata = new TransferKVTeacherDetails();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TransferKVTeacherDetails>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
			LOGGER.warn("message",ex);
		}
//// System.out.println(tdata);
		try {
//			// System.out.println("teacher id tdata-->" + tdata.getTeacherId());
//			// System.out.println("Absenvce dats tc--->" + tdata.getAbsenceDaysOne());

//			tdata.setQ1TPt(tdata.getQ1DPt());
//			tdata.setQ2TPt(tdata.getQ2DPt());
//			tdata.setQ3TPt(String.valueOf(Integer.parseInt(tdata.getQ11DPt())* -1 ));

			// System.out.println("%555DPT---->" + tdata.getQ5DPt());
			if(tdata.getQ5DPt() !=null && tdata.getQ5DPt() !="") {
			if (!tdata.getQ5DPt().equalsIgnoreCase("-20")) {
//				tdata.setQ4TPt(String.valueOf(Integer.parseInt(tdata.getQ5DPt()) * -1));
			} else {
				
			}
			}else {
				tdata.setQ4TPt("0");
			}
			
			// System.out.println(tdata.getQ10DPt());
			// System.out.println(tdata.getQ4DPt());
			// System.out.println(tdata.getQ9DPt());
			
			if(tdata.getQ10DPt() !=null && tdata.getQ10DPt() !="") {
				tdata.setQ10TPt(String.valueOf(Integer.parseInt(tdata.getQ10DPt()) * -1));
			}
			
			if(tdata.getQ4DPt() !=null && tdata.getQ4DPt() !="") {
//				tdata.setQ6TPt(String.valueOf(Integer.parseInt(tdata.getQ4DPt()) * -1));
				
//				// System.out.println("tdata.isLastTransferGroundPersonalStatusYn--->"+tdata.isLastTransferGroundPersonalStatusYn);
//				
//				if(tdata.isLastTransferGroundPersonalStatusYn.equalsIgnoreCase("1")) {
//					tdata.setQ6TPt("0");
//				}
			}
			
			if(tdata.getQ9DPt() !=null && tdata.getQ9DPt() !="") {
				
				tdata.setQ8TPt(String.valueOf(Integer.parseInt(tdata.getQ9DPt()) * -1));
				
				if(tdata.isLastTransferGroundTeacherDisabilityYn.equalsIgnoreCase("1")) {
					tdata.setQ8TPt("0");
				}
			}
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			LOGGER.warn("message",ex);
		}
		// System.out.println("6-->"+tdata.getQ4TPt());
		
		try {
			transferImpl.saveTeacherTransfer(tdata);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		tdata.setModifiedBy(username);
		TransferKVTeacherDetails result = transferImpl.saveTeacherTransfer(tdata);
//		custRes.setStatus(1);
//		custRes.setResponse(result);
		
		// System.out.println("result----->"+result);
		
		
		
		
		return ResponseEntity.ok(new CustomResponse(1,"sucess",result,"200"));
	}

	@RequestMapping(value = "/getTeacherTransferByTeacherId", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getTeacherTransferByTeacherId(@RequestBody String data,
			@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes = new CustomResponse();
//		if (username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return ResponseEntity.ok(custRes);
//		}
		TransferKVTeacherDetails result = transferImpl.getTeacherTransferByTeacherId(Integer.parseInt(data));
//		custRes.setStatus(1);
//		custRes.setResponse(result);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",result,"200"));
	}

	@RequestMapping(value = "/initiateTeacherTransfer", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> initiateTeacherTransfer(@RequestBody String data,
			@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes = new CustomResponse();
//		if (username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return ResponseEntity.ok(custRes);
//		}
		ObjectMapper mapperObj = new ObjectMapper();
		ArrayList<TransferHistory> tdata = new ArrayList<TransferHistory>();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<ArrayList<TransferHistory>>() {
			});
		} catch (Exception ex) {
			LOGGER.warn("message",ex);
		}
		TransferKVTeacherDetails result = transferImpl.initiateTeacherTransfer(tdata);
//		custRes.setStatus(1);
//		custRes.setResponse(result);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",result,"200"));
	}

	@RequestMapping(value = "/reInitiateTeacherTransfer", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> reInitiateTeacherTransfer(@RequestBody String data,
			@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes = new CustomResponse();
//		if (username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return ResponseEntity.ok(custRes);
//		}
		TransferKVTeacherDetails result = transferImpl.reInitiateTeacherTransfer(Integer.parseInt(data));
//		custRes.setStatus(1);
//		custRes.setResponse(result);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",result,"200"));
	}

	@RequestMapping(value = "/getInitiateTeacherTransfer", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getInitiateTeacherTransfer(@RequestBody String data,
			@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes = new CustomResponse();
//		if (username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return ResponseEntity.ok(custRes);
//		}
		TransferKVTeacherDetails result = transferImpl.getInitiateTeacherTransfer(Integer.parseInt(data));
//		custRes.setStatus(1);
//		custRes.setResponse(result);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",result,"200"));
	}

	@RequestMapping(value = "/getTransferByTeacherId", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getTransferByTeacherId(@RequestBody String data,
			@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes = new CustomResponse();
//		if (username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return ResponseEntity.ok(custRes);
//		}
		List<TransferHistory> result = transferImpl.getTransferByTeacherId(Integer.parseInt(data));
//		custRes.setStatus(1);
//		custRes.setResponse(result);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",result,"200"));
	}

	@RequestMapping(value = "/saveTransferHistory", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> saveTransferHistory(@RequestBody String data,
			@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes = new CustomResponse();
//		if (username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return ResponseEntity.ok(custRes);
//		}
		ObjectMapper mapperObj = new ObjectMapper();
		List<TransferHistory> tdata = new ArrayList<TransferHistory>();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<List<TransferHistory>>() {
			});
		} catch (Exception ex) {

		}

		List<TransferHistory> result = transferImpl.saveTransferHistory(tdata);
//		custRes.setStatus(1);
//		custRes.setResponse(result);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",result,"200"));
	}

	@RequestMapping(value = "/getTransferBasicProfileByTeacherId", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getTransferBasicProfileByTeacherId(@RequestBody String data,
			@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes = new CustomResponse();
//		if (username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return ResponseEntity.ok(custRes);
//		}

//		custRes.setStatus(1);
//		custRes.setResponse(transferImpl.getTransferBasicProfileByTeacherId(Integer.parseInt(data)));
		return ResponseEntity.ok(new CustomResponse(1,"sucess",transferImpl.getTransferBasicProfileByTeacherId(Integer.parseInt(data)),"200"));
	}

	@RequestMapping(value = "/getSpouseByEmpCode", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getSpouseByEmpCode(@RequestBody String data,
			@RequestHeader("username") String username) throws Exception {
//		CustomResponse custRes = new CustomResponse();
//		if (username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
//			return ResponseEntity.ok(custRes);
//		}
		ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
		TransferSpouseBean pojo = mapper.convertValue(transferImpl.getSpouseByEmpCode(data), TransferSpouseBean.class);
		if (pojo.getTeacherid() == null) {
			return ResponseEntity.ok(new CustomResponse(0,"fail",pojo,"200"));
		} else {
//			custRes.setStatus(1);
		}

//		custRes.setResponse(pojo);
		return ResponseEntity.ok(new CustomResponse(1,"sucess",pojo,"200"));
	}

	@RequestMapping(value = "/uploadDocument", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> uploadDocument(@RequestParam("file") MultipartFile file,
			@RequestHeader("username") String username, @RequestParam("teacherId") String teacherId,
			@RequestParam("filename") String filename) throws Exception {
//		CustomResponse custRes = new CustomResponse();
		Map<String, Object> mp = new HashMap<String, Object>();
//		if (username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
////			return  ResponseEntity.ok(custRes);
//		}
		File teacherFolder = new File(UPLOADED_FOLDER + File.separator + teacherId);
		// System.out.println(teacherFolder);
		if (!teacherFolder.exists()) {
			teacherFolder.mkdirs();
		}

		if (file.isEmpty()) {
			// System.out.println("File is null");
		}
		try {
			// System.out.println("file.getOriginalFilename()--->" + file.getOriginalFilename());
			// Get the file and save it somewhere
			String[] arrOfStr = file.getOriginalFilename().split("\\.");
			byte[] bytes = file.getBytes();
			Path path = Paths.get(teacherFolder + File.separator + filename + ".pdf" );
			Files.write(path, bytes);
			
			
			// System.out.println("Upload Sucessfully");
//			custRes.setStatus(1);
			mp.put("docName", filename);
			mp.put("url", "http://10.25.26.251:8014/api/transfer/downloadDocument?teacherId="
					+ teacherId + "&filename=" + filename);
//			mp.put("url", "https://kvsonlinetransfer.kvs.gov.in/MOE-RAD-TEACHER/api/transfer/downloadDocument?teacherId="
//					+ teacherId + "&filename=" + filename);
//			custRes.setResponse(mp);

		} catch (IOException ex) {
			ex.printStackTrace();
			LOGGER.warn("message",ex);
		}

		return ResponseEntity.ok(new CustomResponse(1,"sucess",mp,"200"));
	}

	@RequestMapping(value = "/downloadDocument", method = RequestMethod.GET)
	public ResponseEntity<Resource> downloadDocument(@RequestParam("teacherId") String teacherId, @RequestParam("filename") String filename) throws Exception {
//	public ResponseEntity<Resource> downloadDocument(@RequestHeader("username") String username,
//			@RequestParam("teacherId") String teacherId, @RequestParam("filename") String filename) throws Exception {

//		String UPLOADED_FOLDER = "E:\\uploadDoc";
		File file = new File(UPLOADED_FOLDER + File.separator + teacherId + File.separator + filename + ".pdf");
		// System.out.println("filepath--->" + file.getAbsolutePath());
		Path path = Paths.get(file.getAbsolutePath());
		ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename + ".pdf");
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");
		return ResponseEntity.ok().headers(header).contentLength(file.length()).contentType(MediaType.APPLICATION_PDF)
				.body(resource);
	}

	@RequestMapping(value = "/getDocumentByTeacherId", method = RequestMethod.POST)
	public ResponseEntity<?> getDocumentByTeacherId(@RequestHeader("username") String username,
			@RequestBody String data) throws Exception {
		
		System.out.println("Techer Id--->"+data);
		
		return ResponseEntity.ok(transferImpl.getDocumentByTeacherId(data));
	}

	@RequestMapping(value = "/deleteDocumentByTeacherIdAndName", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> deleteDocumentByTeacherIdAndName(
			@RequestHeader("username") String username, @RequestBody String data) throws Exception {

		ObjectMapper mapperObj = new ObjectMapper();
		DocumentBean tdata = new DocumentBean();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<DocumentBean>() {
			});
		} catch (Exception ex) {
			LOGGER.warn("message",ex);
		}

		return ResponseEntity.ok(transferImpl.deleteDocumentByTeacherIdAndName(tdata));
	}

	@RequestMapping(value = "/uploadProfileImage", method = RequestMethod.POST)
	public ResponseEntity<?> uploadProfileImage(@RequestParam("file") MultipartFile file,
			@RequestHeader("username") String username, @RequestParam("teacherId") String teacherId,
			@RequestParam("filename") String filename) throws Exception {
//		CustomResponse custRes = new CustomResponse();
		Map<String, Object> mp = new HashMap<String, Object>();
//		if (username.equalsIgnoreCase("tokenFail")) {
//			custRes.setStatus(0);
//			custRes.setMessage("Session Expire");
////			return  ResponseEntity.ok(custRes);
//		}
		File teacherFolder = new File(UPLOADED_FOLDER + File.separator + teacherId + File.separator + "profileImage");
		// System.out.println(teacherFolder);
		if (!teacherFolder.exists()) {
			teacherFolder.mkdirs();
		}
		
		for (final File fileEntry : teacherFolder.listFiles()) {
			// System.out.println("delete");
			fileEntry.delete();
		}

		if (file.isEmpty()) {
			// System.out.println("File is null");
		}
		try {
			// System.out.println("file.getOriginalFilename()--->" + file.getOriginalFilename());
			// Get the file and save it somewhere
			String[] arrOfStr = file.getOriginalFilename().split("\\.");
			byte[] bytes = file.getBytes();
			Path path = Paths.get(teacherFolder + File.separator + filename + "." + arrOfStr[1]);
			Files.write(path, bytes);
			// System.out.println("Upload Sucessfully");
//			custRes.setStatus(1);
			mp.put("docName", filename);
			mp.put("url", "https://kvsonlinetransfer.kvs.gov.in/MOE-RAD-TEACHER/api/transfer/downloadDocument?teacherId="
					+ teacherId + "&filename=" + filename);
//			custRes.setResponse(mp);

		} catch (IOException ex) {
			LOGGER.warn("message",ex);
		}

		return ResponseEntity.ok(new CustomResponse(1,"sucess",mp,"200"));
	}

	@RequestMapping(value = "/getProfileImage", method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> getProfileImage(@RequestHeader("username") String username,
			@RequestBody String teacherId) throws Exception {
		String fileName = null;
		String base64=null;
		Map<String,Object> mp=new HashMap<String, Object>();
		File file = new File(UPLOADED_FOLDER + File.separator + teacherId + File.separator + "profileImage");
		// System.out.println(file.getAbsolutePath());
		if(file.exists()) {
		if(file.listFiles().length>0) {
		for (final File fileEntry : file.listFiles()) {
			fileName = fileEntry.getName();
		}
		BufferedImage bufferimage = ImageIO.read(new File(UPLOADED_FOLDER + File.separator + teacherId + File.separator
				+ "profileImage" + File.separator + fileName));
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		String[] arrOfStr = fileName.split("\\.");
		
		ImageIO.write(bufferimage, arrOfStr[1], output);
		byte[] data = output.toByteArray();
		 base64 = Base64.encodeBase64String(data);
		 mp.put("status", 1);
		 mp.put("data", base64);
		 mp.put("type", arrOfStr[1]);
		}else {
			mp.put("status", 0);
			mp.put("data", "");	
		}
		}else {
			mp.put("status", 0);
			mp.put("data", "");
		}
		 return ResponseEntity.ok(mp);
	}
	
	
	@RequestMapping(value = "/getInitiatedTransferByUdisecode", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getInitiatedTransferByUdisecode(@RequestBody String data) throws Exception {		
		return ResponseEntity.ok(ResponseEntityBeans.reponseBoject(1, "sucess", transferImpl.getInitiatedTransferByUdisecode(data), HttpStatus.OK.toString()));
	}
	
	
	@RequestMapping(value = "/getInitiatedTransferByKvCode", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getInitiatedTransferByKvCode(@RequestBody String data) throws Exception {		
		Map<String,Object>  dataObj=customObjectMapper.getMapObject(data);
		return ResponseEntity.ok(ResponseEntityBeans.reponseBoject(1, "sucess", transferImpl.getInitiatedTransferByKvCode(String.valueOf(dataObj.get("kvCode"))), HttpStatus.OK.toString()));
	}
	
	
	@RequestMapping(value = "/resetTransfer", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> resetTransfer(@RequestBody String data) throws Exception {		
		return ResponseEntity.ok(ResponseEntityBeans.reponseBoject(1, "sucess", transferImpl.resetTransfer(data), HttpStatus.OK.toString()));
	}
	
	@RequestMapping(value = "/schoolTransferVerify", method = RequestMethod.POST)
	public ResponseEntity<?> schoolTransferVerify(@RequestBody String data) throws Exception {		
		return ResponseEntity.ok(transferImpl.schoolTransferVerify(Integer.parseInt(data)));
	}
	
	@RequestMapping(value = "/saveTransferDeclaration", method = RequestMethod.POST)
	public ResponseEntity<?> saveTransferDeclaration(@RequestBody String data) throws Exception {		
		
		ObjectMapper mapperObj = new ObjectMapper();
		TeacherTransferDeclaration tdata = new TeacherTransferDeclaration();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<TeacherTransferDeclaration>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
			LOGGER.warn("message",ex);
		}
		
		return ResponseEntity.ok(transferImpl.saveTransferDeclaration(tdata));
	}
	
	@RequestMapping(value = "/getTransferDeclaration", method = RequestMethod.POST)
	public ResponseEntity<?> getTransferDeclaration(@RequestBody String data) throws Exception {				
		return ResponseEntity.ok(transferImpl.getTransferDeclaration(Integer.parseInt(data)));
	}
	
	
	@RequestMapping(value = "/getTransferRegionByEmployee", method = RequestMethod.POST)
	public ResponseEntity<?> getTransferRegionByEmployee(@RequestBody String data) throws Exception {		
		ObjectMapper mapperObj = new ObjectMapper();
		HashMap<String,String> mp=new HashMap<String,String>();
		System.out.println("data--->"+data);
		try {
			mp = mapperObj.readValue(data, new TypeReference<HashMap<String,String>>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
			LOGGER.warn("message",ex);
		}
		return ResponseEntity.ok(transferImpl.getTransferRegionByEmployee(Integer.parseInt(mp.get("teacherId"))));
	}
	
	@RequestMapping(value = "/getTransferStationByEmployee", method = RequestMethod.POST)
	public ResponseEntity<?> getTransferStationByEmployee(@RequestBody String data) throws Exception {	
		ObjectMapper mapperObj = new ObjectMapper();
		HashMap<String,String> mp=new HashMap<String,String>();
		try {
			mp = mapperObj.readValue(data, new TypeReference<HashMap<String,String>>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
			LOGGER.warn("message",ex);
		}
		
		System.out.println(mp.get("teacherId"));
		System.out.println(mp.get("regionCode"));
		
		return ResponseEntity.ok(transferImpl.getTransferStationByEmployee(Integer.parseInt(mp.get("teacherId")),mp.get("regionCode")));
	}
	
	@RequestMapping(value = "/getTransferINByKvCode", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> getTransferINByKvCode(@RequestBody String data) throws Exception {		
		Map<String,Object>  dataObj=customObjectMapper.getMapObject(data);
		return ResponseEntity.ok(ResponseEntityBeans.reponseBoject(1, "sucess", transferImpl.getTransferINByKvCode(String.valueOf(dataObj.get("kvCode"))), HttpStatus.OK.toString()));
	}
	
	
	
	@RequestMapping(value = "/updateTransferINByKvCode", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> updateTransferINByKvCode(@RequestBody String data) throws Exception {		
		Map<String,Object>  dataObj=customObjectMapper.getMapObject(data);
		return ResponseEntity.ok(ResponseEntityBeans.reponseBoject(1, "sucess", transferImpl.updateTransferINByKvCode(String.valueOf(dataObj.get("teacherId")), String.valueOf(dataObj.get("doj")), String.valueOf(dataObj.get("kvCode")), String.valueOf(dataObj.get("emp_code")),  String.valueOf(dataObj.get("transfer_type")),dataObj), HttpStatus.OK.toString()));
	}
	
	
	@RequestMapping(value = "/updateTransferOutByKvCode", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> updateTransferOutByKvCode(@RequestBody String data) throws Exception {		
		Map<String,Object>  dataObj=customObjectMapper.getMapObject(data);
		return ResponseEntity.ok(ResponseEntityBeans.reponseBoject(1, "sucess", transferImpl.updateTransferOutByKvCode(String.valueOf(dataObj.get("doj")),  String.valueOf(dataObj.get("emp_code")), String.valueOf(dataObj.get("allotedKvCode"))), HttpStatus.OK.toString()));
	}
	

}
