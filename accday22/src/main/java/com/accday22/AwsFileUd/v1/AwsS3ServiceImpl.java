package com.accday22.AwsFileUd.v1;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;

@Service
@Transactional
public class AwsS3ServiceImpl implements AwsS3Service {

	@Autowired
	private AmazonS3 as3;

	@Autowired
	private AwsRepo ar;

	@Value("${aws.s3.bucket.name}")
	private String bucketName;

	@Override
	public String upload(MultipartFile file) throws IOException {
		Map<String, String> metadata = new HashMap<>();
		metadata.put("Content-Type", file.getContentType());
		metadata.put("Content-Length", String.valueOf(file.getSize()));

		Optional<Map<String, String>> optionalMetaData = Optional.of(metadata);
		ObjectMetadata objectMetadata = new ObjectMetadata();
		optionalMetaData.ifPresent(map -> {
			if (!map.isEmpty()) {
				map.forEach(objectMetadata::addUserMetadata);
			}
		});

		String path = String.format("%s", bucketName);
		String fileName = String.format("%s", file.getOriginalFilename());
//		AwsModel sf = ar.findByfilename(fileName);
//		int x = sf.getId();
//		AwsModel sf1 = ar.findById(x).orElseThrow();
//		if (x == 0)
//		{
//		ar.save(new AwsModel(fileName, path));
//		}
//		else
//		{
//			sf1.setFilename(fileName);
//			sf1.setBucketname(bucketName);
//			ar.save(sf);
//		}
		LocalDate d = LocalDate.now();
		LocalTime t = LocalTime.now();
		String date = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(d);
		String time = t.truncatedTo(ChronoUnit.SECONDS).toString();
		ar.save(new AwsModel(fileName, path, date, time));
		as3.putObject(path, fileName, file.getInputStream(), objectMetadata);
		return fileName + " File Uploaded Successfully";

	}

	@Override
	public S3Object download(int id) {
		AwsModel a = ar.findById(id).orElseThrow();
		return as3.getObject(a.getBucketName(), a.getFilename());
	}

	public List<AwsModel> list() {
		List<AwsModel> metas = new ArrayList<>();
		ar.findAll().forEach(metas::add);
		return metas;
	}

	@Override
	public String deleteFile(String fileName) {
		ar.deleteByfilename(fileName);
		as3.deleteObject(bucketName, fileName);
		return "Deleted File: " + fileName;
	}

	@Override
	public S3Object downloadfile(String name) {
		return as3.getObject(bucketName, name);
	}

}
