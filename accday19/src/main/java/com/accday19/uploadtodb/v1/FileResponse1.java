package com.accday19.uploadtodb.v1;

public class FileResponse1 {

	private String msg;
	private String fileName;
	private String fileUrl;
	private String type;
	private long size;
	private String date;
	private String time;

	public FileResponse1(String msg, String uf, String fdu, String type, long size, String date, String time) {
		this.msg = msg;
		this.fileName = uf;
		this.fileUrl = fdu;
		this.type = type;
		this.size = size;
		this.date = date;
		this.time = time;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
