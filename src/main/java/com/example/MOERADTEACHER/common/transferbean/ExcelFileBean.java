package com.example.MOERADTEACHER.common.transferbean;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class ExcelFileBean  implements Serializable{
public MultipartFile file;

public MultipartFile getFile() {
	return file;
}

public void setFile(MultipartFile file) {
	this.file = file;
}

}
