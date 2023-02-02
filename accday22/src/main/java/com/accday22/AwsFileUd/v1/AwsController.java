package com.accday22.AwsFileUd.v1;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.S3Object;

@RestController
public class AwsController {

	@Autowired
	private AwsS3Service as;

	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) throws IOException {
		return as.upload(file);
	}

	@GetMapping("/download/{id}")
	public ByteArrayResource download(@PathVariable int id) throws IOException {

		S3Object s3Object = as.download(id);
		s3Object.getObjectMetadata().getContentType();
		var bytes = s3Object.getObjectContent().readAllBytes();
		return new ByteArrayResource(bytes);
	}

	@GetMapping("/downloadbyname/{fname}")
	public ByteArrayResource downloadfile(@PathVariable("fname") String name) throws IOException {

		S3Object s3Object = as.downloadfile(name);
		s3Object.getObjectMetadata().getContentType();
		var bytes = s3Object.getObjectContent().readAllBytes();
		return new ByteArrayResource(bytes);
	}

	@GetMapping("/allfiles")
	public List<AwsModel> dashboard() {
		List<AwsModel> files = as.list();
		return files;
	}

//	@PutMapping("/upload")
//	public String update(@RequestParam("file") MultipartFile file) throws IOException {
//		String fn = as.upload(file);
//		return fn + " File Uploaded Successfully";
//	}

	@DeleteMapping("/deletefile/{filename}")
    public String deleteFile(@PathVariable("filename") String filename) {
		return as.deleteFile(filename);
    }
}
