package com.accday19.uploadtodb.v1;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

public interface DbService {

	DbModel storeFile(MultipartFile file) throws IOException;

	DbModel getFile(String fileId);

	Stream<DbModel> getAllFiles();
}
