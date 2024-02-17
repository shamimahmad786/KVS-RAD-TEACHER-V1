package com.example.MOERADTEACHER.common.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.MOERADTEACHER.common.modal.KvsFileManage;
import com.example.MOERADTEACHER.common.repository.KvsFileManageRepo;
import com.example.MOERADTEACHER.common.util.CustomObjectMapper;

@Service
public class FileManagementImpl {

	@Autowired
	KvsFileManageRepo kvsFileManageRepo;
	
	@Value("${nationalBucket.path}")
	private String UPLOADED_FOLDER;
	
	@Autowired
	CustomObjectMapper customObjectMapper;
	
	public KvsFileManage fileUpload(MultipartFile file,String type,String orderName,Date orderDate,String description,Integer noOfAssociatedEmployee,String documentTitle,String username) {
		try {
		byte[] bytes = file.getBytes();
		Path path = Paths.get(UPLOADED_FOLDER + File.separator + orderName + ".pdf" );
		Files.write(path, bytes);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		KvsFileManage kfm=new KvsFileManage();
		kfm.setFileType(type);
	
		kfm.setTransferOrderNumber(orderName);
		kfm.setTransferOrderDate(orderDate);
		kfm.setCreatedBy(username);
		kfm.setDescription(description);
		kfm.setNoOfAssociatedEmployee(noOfAssociatedEmployee);
		kfm.setDocumentTitle(documentTitle);
		System.out.println("Before upload");
		return kvsFileManageRepo.save(kfm);
		
	}
	
	public List<KvsFileManage> getUploadedDocument() {
		return kvsFileManageRepo.findAll();
	}
	
	public Object downloadUplodedDocumentById(String docId) throws IOException {
		File file = new File(UPLOADED_FOLDER + File.separator +  docId + ".pdf");
		Path path = Paths.get(file.getAbsolutePath());
		ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + docId + ".pdf");
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");
		return ResponseEntity.ok().headers(header).contentLength(file.length()).contentType(MediaType.APPLICATION_PDF)
				.body(resource);
	}
}
