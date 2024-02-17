package com.example.MOERADTEACHER.common.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;

//import javax.annotation.Resource;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
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

import com.example.MOERADTEACHER.common.service.FileManagementImpl;
import com.example.MOERADTEACHER.common.util.ApiPaths;
import com.example.MOERADTEACHER.common.util.CustomObjectMapper;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(ApiPaths.FileManagementCtrl.CTRL)
@CrossOrigin(origins = { "https://kvsdemo.udiseplus.gov.in/", "https://kvsonlinetransfer.kvs.gov.in",
		"http://10.25.26.251:4200", "http://10.25.26.10:4200", "http://10.25.26.10:6200", "http://demo.sdmis.gov.in",
		"http://pgi.seshagun.gov.in", "https://pgi.udiseplus.gov.in", "http://pgi.udiseplus.gov.in",
		"https://demopgi.udiseplus.gov.in", "https://dashboard.seshagun.gov.in/",
		"https://dashboard.udiseplus.gov.in" }, allowedHeaders = "*", allowCredentials = "true")
public class FileManagementCtrl {
	
	@Autowired
	FileManagementImpl  fileManagementImpl;
	
	@Autowired
	CustomObjectMapper customObjectMapper;
	
	@Value("${nationalBucket.path}")
	private String UPLOADED_FOLDER;
	
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public ResponseEntity<?> fileUpload(@RequestParam("file") MultipartFile file,
			@RequestParam("type") String type, @RequestParam("orderName") String orderName,@RequestParam("orderDate") Date orderDate,@RequestParam("description") String description,@RequestParam("noOfAssociatedEmployee") Integer noOfAssociatedEmployee,@RequestParam("documentTitle") String documentTitle ,@RequestHeader("username") String username) throws Exception {
		Integer noOfEmp=0;
		if(noOfAssociatedEmployee >0 ) {
			noOfEmp=noOfAssociatedEmployee;
		}
		return ResponseEntity.ok(fileManagementImpl.fileUpload(file,type,orderName,orderDate,description,noOfEmp,documentTitle,username));
	}
	
	@RequestMapping(value = "/getUploadedDocument", method = RequestMethod.POST)
	public ResponseEntity<?> getUploadedDocument() throws Exception {
		return ResponseEntity.ok(fileManagementImpl.getUploadedDocument());
	}
	
	@RequestMapping(value = "/downloadUploadDocumentById", method = RequestMethod.GET)
	public ResponseEntity<Resource> downloadUploadDocumentById(@RequestParam("fileId") String fileId) throws Exception {
//		System.out.println(data);
//		ObjectMapper mapperObj = new ObjectMapper();
//		Map<String,Object> obj=customObjectMapper.getMapObject(data);
		System.out.println("Called");
		File file = new File(UPLOADED_FOLDER + File.separator +  fileId + ".pdf");

		Path path = Paths.get(file.getAbsolutePath());
		ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileId + ".pdf");
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");
		return ResponseEntity.ok().headers(header).contentLength(file.length()).contentType(MediaType.APPLICATION_PDF)
				.body(resource);
		
	}
	
	
}
