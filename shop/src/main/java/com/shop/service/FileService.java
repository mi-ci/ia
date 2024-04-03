package com.shop.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Service
@Log
public class FileService {
	public String uploadFile(String uploadPath, String OriginalFileName, byte[] fileData) throws Exception {
		
		UUID uuid = UUID.randomUUID();
		String extension = OriginalFileName.substring(OriginalFileName.lastIndexOf('.'));
		String savedFileName = uuid.toString()+extension;
		String fileuploadFullUrl = uploadPath + "/" + savedFileName;
		FileOutputStream fos = new FileOutputStream(fileuploadFullUrl);
		fos.write(fileData);
		fos.close();
		return savedFileName;
	}
	
	public void deleteFile(String filePath) throws Exception{
		File deleteFile = new File(filePath);
		if(deleteFile.exists()) {
			deleteFile.delete();
			log.info("파일을 삭제하였습니다");
		}
		else {
			log.info("파일이 존재하지 않습니다");
		}
	}
}
