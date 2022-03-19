package com.org.filemanagement.watcher;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Scanner;
import java.util.logging.Logger;

import com.org.filemanagement.operations.FileProcessor;

public class FileWatcher {

	private static final Logger LOGGER = Logger.getLogger(FileWatcher.class.getName());

	public static void main(String[] args) throws IOException, InterruptedException {

		LOGGER.info("Logger Name: " + LOGGER.getName());
		Scanner scanner = new Scanner(System.in);
		 
		 System.out.println("Enter file source folder path");
		 Path sourcePath = Paths.get(scanner.nextLine());   
		 
		 System.out.println("Enter destination folder path");
		 Path destinationPath = Paths.get(scanner.nextLine());  
		 
		 System.out.println("Enter destination error folder path");
		 Path errorFilesPath  = Paths.get(scanner.nextLine());  
		 
		 // closes the scanner
		 scanner.close();
		 

		WatchService watchService = FileSystems.getDefault().newWatchService();
		sourcePath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
		sourcePath.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

		WatchKey key;
		while ((key = watchService.take()) != null) {
			for (WatchEvent<?> event : key.pollEvents()) {
				//Reading each file
				FileProcessor.processFile(sourcePath, destinationPath, errorFilesPath);
			}
			key.reset();
		}
	}
}