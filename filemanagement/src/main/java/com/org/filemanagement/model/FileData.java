package com.org.filemanagement.model;

public class FileData {

	private long wordCount;
	private long specialCharCount;
	private StringBuilder fileContent = new StringBuilder();

	public FileData() {
		super();
	}

	public StringBuilder getFileContent() {
		return fileContent;
	}

	public void setFileContent(StringBuilder fileContent) {
		this.fileContent = fileContent;
	}

	public long getWordCount() {
		return wordCount;
	}

	public void setWordCount(long wordCount) {
		this.wordCount = wordCount;
	}

	public long getSpecialCharCount() {
		return specialCharCount;
	}

	public void setSpecialCharCount(long specialCharCount) {
		this.specialCharCount = specialCharCount;
	}

	@Override
	public String toString() {
		return " [ wordCount=" + wordCount + ", specialCharCount=" + specialCharCount + " ]";
	}

}
