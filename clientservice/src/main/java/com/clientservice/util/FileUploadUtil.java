package com.clientservice.util;

import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;


/********
 *
 * This class is for uploading the file to the particular folder
 */
@Configuration
public class FileUploadUtil {

	/*******
	 *
	 *
	 * @param fileNamme
	 * @param multipartFile
	 * @return String<status of operation>
	 * @throws IOException
	 */
	public  String saveFile(String fileName, MultipartFile multipartFile) throws IOException {
		Path uploadPath = Paths.get("Files-Upload");

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		String fileCode = RandomStringUtils.randomAlphanumeric(8);

		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = uploadPath.resolve(fileCode + "-" + fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Could not save file: " + fileName, ioe);
		}

		return fileCode;
	}
}