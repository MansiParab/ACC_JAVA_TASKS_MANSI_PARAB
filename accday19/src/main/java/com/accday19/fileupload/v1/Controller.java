package com.accday19.fileupload.v1;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class Controller {

	@Autowired
	UploadServiceImpl usi;

	@PostMapping("/upload")
	public FileResponse upfile(@RequestParam("file") MultipartFile file) throws IOException
	{
		String uf = usi.savetheFile(file);
		String fdu = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/uploads")
				.path(uf).toUriString();
		return new FileResponse(uf,fdu,"File Uploaded");
	}

	@GetMapping("/download/{filename:.+}")
	public Resource downfile(@PathVariable String filename) throws MalformedURLException {
		Resource r = usi.loadtheFile(filename);
		return r;
	}

}
