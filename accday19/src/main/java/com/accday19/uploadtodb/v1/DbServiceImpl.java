package com.accday19.uploadtodb.v1;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DbServiceImpl implements DbService {

	@Autowired
	private DbRepo repo;

	@Override
	public DbModel storeFile(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		SimpleDateFormat fd = new SimpleDateFormat("DD-MM-YY");
//		SimpleDateFormat ft = new SimpleDateFormat("hh.mm.ss aa");
		LocalDate d = LocalDate.now();
		LocalTime t = LocalTime.now();
		String date = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(d);
		String time = t.truncatedTo(ChronoUnit.SECONDS).toString();
		DbModel df = new DbModel(fileName, file.getContentType(), file.getBytes(), file.getSize(), date, time);
		return repo.save(df);
	}

	@Override
	public DbModel getFile(String fileId) {
		return repo.findById(fileId).orElseThrow();
	}

	public Stream<DbModel> getAllFiles() {

		return repo.findAll().stream();
	}

}
