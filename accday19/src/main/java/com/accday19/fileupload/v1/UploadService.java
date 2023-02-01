package com.accday19.fileupload.v1;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

	void init() throws IOException;

	String savetheFile(MultipartFile file) throws IOException;

	Resource loadtheFile(String fname) throws IOException;
}
