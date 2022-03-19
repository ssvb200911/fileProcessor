package com.org.filemanagement.operations;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.org.filemanagement.factory.FileFactory;
import com.org.filemanagement.model.FileData;
import com.org.filemanagement.validations.ValidateFileExtension;

public class FileProcessor {

	private static final Logger LOGGER = Logger.getLogger(FileProcessor.class.getName());

	public static void processFile(Path sourcePath, Path destinationPath, Path errorFilesPath) {
		LOGGER.info("Logger Name: " + LOGGER.getName() + ":" + "processFile()");

		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourcePath)) {
			for (Path path : directoryStream) {

				String fileExtn = ValidateFileExtension.getFileType(path.getFileName().toString());

				if (fileExtn != null) {
					IFileReader ic = FileFactory.getFileReader(fileExtn);
					FileData fileData = ic.readFileContent(path.toFile());
					fileData.setSpecialCharCount(ic.countSpecialChar(fileData.getFileContent().toString()));
					fileData.setWordCount(ic.countNoWords(fileData.getFileContent().toString()));
					LOGGER.info("File name ->" + path.getFileName() + fileData);
					Files.move(path, destinationPath.resolve(path.getFileName()), StandardCopyOption.REPLACE_EXISTING);
				} else {
					Files.move(path, errorFilesPath.resolve(path.getFileName()), StandardCopyOption.REPLACE_EXISTING);
					LOGGER.log(Level.WARNING, "File is not a valid format. Valid formats are txt & pdf ");
				}
			}

		} catch (IOException ex) {
			LOGGER.log(Level.SEVERE, "Exception occur", ex.getMessage());

		}

	}
}
