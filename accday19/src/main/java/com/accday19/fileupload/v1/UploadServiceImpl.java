package com.accday19.fileupload.v1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService {

	private final Path loc;

	@Autowired
	public UploadServiceImpl(UploadProperty fup)
	{
		this.loc = Paths.get(fup.getLocation()).toAbsolutePath().normalize();
	}

	@Override
	public void init() throws IOException {

			Files.createDirectories(this.loc);

	}

	@Override
	public String savetheFile(MultipartFile file) throws IOException {

		String fileName = file.getOriginalFilename();
		Path dfile = this.loc.resolve(fileName);
		Files.copy(file.getInputStream(), dfile, StandardCopyOption.REPLACE_EXISTING);
		return fileName;
	}

	@Override
	public Resource loadtheFile(String fname) throws MalformedURLException {

			Path file = this.loc.resolve(fname).normalize();
			Resource resource = new UrlResource(file.toUri());
			return resource;
//			if (resource.exists() || resource.isReadable()) {
//				return resource;
//			} else {
//				throw new FileNotFoundException("Could not find file");
//			}


	}

}
