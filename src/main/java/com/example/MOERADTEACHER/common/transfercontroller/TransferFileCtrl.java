package com.example.MOERADTEACHER.common.transfercontroller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.example.MOERADTEACHER.common.util.ApiPaths;



@RestController
@RequestMapping(ApiPaths.TransferFileCtrl.CTRL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransferFileCtrl {

	
	@RequestMapping(value = "/uploadDoc", method = RequestMethod.POST)
	public ResponseEntity<?> uploadDoc(@RequestPart ("file") MultipartFile multifile,HttpServletRequest request) throws Exception {
		System.out.println("upload cal--->"+multifile.getInputStream());
		
		try {
		Workbook workbook = new XSSFWorkbook(multifile.getInputStream());
		Sheet datatypeSheet=null;
		try {
		datatypeSheet = workbook.getSheetAt(1);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		Iterator<Row> iterator = datatypeSheet.iterator();
		Integer totalRows = datatypeSheet.getPhysicalNumberOfRows();
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
		
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver canBeCalledAnything(){
		 CommonsMultipartResolver resolver = new 
				    CommonsMultipartResolver();
				    return resolver;
		
	}
	
}
