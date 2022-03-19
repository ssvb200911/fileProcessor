package com.org.filemanagement.validations;

import com.org.filemanagement.constants.FileConstants;

public class ValidateFileExtension {

	public static String getFileType(String fileName) {
		String[] res = fileName.split(FileConstants.REG_EXP_FILE_EXTN_CHECK, 0);
		return FileConstants.fileTypes.contains(res[1]) ? res[1] : null;
	}
}
