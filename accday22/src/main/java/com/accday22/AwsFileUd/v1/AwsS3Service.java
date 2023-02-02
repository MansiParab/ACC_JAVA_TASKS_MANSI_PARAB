package com.accday22.AwsFileUd.v1;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.S3Object;

public interface AwsS3Service {
	
	public String upload(MultipartFile file) throws IOException;

	public S3Object download(int id);

	public String deleteFile(final String fileName);

	public List<AwsModel> list();

	public S3Object downloadfile(String name);

}
