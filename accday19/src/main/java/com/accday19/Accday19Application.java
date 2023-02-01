package com.accday19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.accday19.fileupload.v1.UploadProperty;

@SpringBootApplication
@EnableConfigurationProperties({ UploadProperty.class })
public class Accday19Application {

	public static void main(String[] args) {
		SpringApplication.run(Accday19Application.class, args);
	}

}
