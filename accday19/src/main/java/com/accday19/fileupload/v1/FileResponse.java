package com.accday19.fileupload.v1;

public class FileResponse {

	private String fileName;
	private String fileUrl;
	private String message;

	public FileResponse(String uf, String fdu, String string) {
		this.fileName = uf;
		this.fileUrl = fdu;
		this.message = string;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
