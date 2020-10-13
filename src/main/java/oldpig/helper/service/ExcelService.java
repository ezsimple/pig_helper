package oldpig.helper.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import io.mkeasy.resolver.CommandMap;
import io.mkeasy.utils.ListUtil;
import io.mkeasy.utils.excel.ExcelRead;
import io.mkeasy.utils.excel.ExcelReadOption;
import lombok.extern.slf4j.Slf4j;
import oldpig.common.service.AbstractPigService;
import oldpig.utils.PropertiesUtil;

@Slf4j
@Service
public class ExcelService extends AbstractPigService {
	
    @Autowired
    PropertiesUtil propertiesUtil;
    
    @Autowired
    FileService fileService;

	public List<Map<String, String>> upload(MultipartFile excelfile, ModelMap model, CommandMap commandMap) throws Exception {

		if(excelfile==null) {
			log.error("#ERROR# excelImport file is null");
			return ListUtil.EMPTY;
		}

		String filePath = fileService.upload(excelfile);
        String origFileName = excelfile.getOriginalFilename();
        String ext = FilenameUtils.getExtension(origFileName);

		File file = new File(filePath);
		File tempFile = File.createTempFile("temp-","."+ext); 
		tempFile.deleteOnExit();

		FileUtils.copyFile(file, tempFile);
		
		ExcelReadOption ro = new ExcelReadOption();
		ro.setFilePath(tempFile.getAbsolutePath());
		
		String[] cols = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"
				, "M", "N" , "O", "P", "Q", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		ro.setOutputColumns(cols);
		ro.setStartRow(2); // skip first rows (skip titles)

		List<Map<String, String>> result = ExcelRead.read(ro);
		// log.debug("excel result : {}", result);

		FileUtils.deleteQuietly(tempFile);
		
		return result;
	}
	
}
