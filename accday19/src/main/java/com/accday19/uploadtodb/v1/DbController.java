package com.accday19.uploadtodb.v1;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class DbController {
	@Autowired
	private DbServiceImpl dsi;

	@PostMapping("/uploadfile")
	public FileResponse1 uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		DbModel dbFile = dsi.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadfile/")
				.path(dbFile.getId()).toUriString();

		return new FileResponse1("File Upload Successful!!", dbFile.getFileName(), fileDownloadUri,
				file.getContentType(), file.getSize(), dbFile.getDate(), dbFile.getTime());
	}
	
	@PostMapping("/uploadmultiplefiles")
    public List<FileResponse1> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
				.map(file -> {
					try {
						return uploadFile(file);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return null;
				})
                .collect(Collectors.toList());
    }
	
	@GetMapping("/downloadfile/{id}")
	public ByteArrayResource downloadFile(@PathVariable String id) {
		DbModel dm = dsi.getFile(id);
		return new ByteArrayResource(dm.getData());
	}

	@GetMapping("/files")
	  public List<FileResponse1> getListFiles() {
			List<FileResponse1> files = dsi.getAllFiles().map(DbModel -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/files/")
						.path(DbModel.getId())
	          .toUriString();

				return new FileResponse1("Files:",
						DbModel.getFileName(),
	          fileDownloadUri,
						DbModel.getFileType(), DbModel.getSize(), DbModel.getDate(), DbModel.getTime());
	    }).collect(Collectors.toList());

	    return files;
	  }
}
