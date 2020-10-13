package oldpig.helper.service;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.mkeasy.resolver.CommandMap;
import io.mkeasy.utils.CalUtil;
import io.mkeasy.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import oldpig.common.service.AbstractPigService;
import oldpig.utils.PropertiesUtil;

@Slf4j
@Service
public class FileService extends AbstractPigService {
	
    @Autowired
    PropertiesUtil propertiesUtil;

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    
    @Value("${upload.dir}")
	private String UPLOAD_DIR;
    
    
	public String upload(MultipartFile file) throws Exception {
		ArrayList<MultipartFile> files = new ArrayList<>();
		files.add(file);
		ArrayList<String> fileIds = uploadFiles(files);
		String filePath = fileIds.get(0);
		log.debug("upload FilePath => {}", filePath);
		return filePath;
	}

	public void download(HttpServletRequest request, HttpServletResponse response, CommandMap commandMap) throws Exception {

		commandMap.debugParams();

    	String dnKey = propertiesUtil.getProperty("download.key");
    	String dir = propertiesUtil.getProperty("download.dir");

		String key = String.valueOf(commandMap.getParam("key"));
		if(!StringUtils.equals(key, dnKey)) {
			log.error("{} key is mismatch");
			return;
		}
		
		String fid = commandMap.getParam("fid");
		if(StringUtils.isEmpty(fid)) {
			log.error("{} fid is empty");
			return;
		}
		
		String dnFile = propertiesUtil.getProperty("download.file"+fid);
		String dnFileName = propertiesUtil.getProperty("download.file"+fid+"Name");
		if(StringUtils.isEmpty(dnFile)
				|| StringUtils.isEmpty(dnFileName)) {
			log.error("{} download file is not defined");
			return;
		}
		
		// log.debug("dir={}, dnFile={}, dnFileName={}, dnKey={}", dir, dnFile, dnFileName, dnKey);
	
		String filePath = dir + "/" + dnFile;
		File file = new File(filePath);

		FileUtil.download(request, response, file, dnFileName);
		
	}

    private String getFileId() {
    	String fileId = dateFormater.format(new Date());
    	return fileId;
    }

	private ArrayList<String> uploadFiles(List<MultipartFile> files) throws Exception {

		ArrayList<String> fileIds = new ArrayList<>();

		for (MultipartFile file : files) {
			if (file.isEmpty()) continue;

			String year = String.format("%4d",CalUtil.nowYear());
			String month = String.format("%02d",CalUtil.nowMonth());
			String day = String.format("%02d",CalUtil.nowDay());

			String filePath = year+"/"+month+"/"+day;
			String targetDir = this.UPLOAD_DIR+"/"+filePath;

			FileUtil.forceMkdir(new File(targetDir));

			String origFileName = file.getOriginalFilename();
			String ext = FilenameUtils.getExtension(origFileName);

			String fileId = StringUtils.replace(origFileName,"."+ext,"")+"_"+getFileId()+"."+ext;
			Path path = Paths.get(targetDir + "/" + fileId);

			InputStream is = file.getInputStream();
			String saveFileName = path.toString();

			log.warn("origFileName : {}, saveFileName : {}, fileId : {}, len : {}"
				,origFileName, saveFileName, fileId, fileId.length());

			File tmp = File.createTempFile(fileId, ".tmp");
			FileUtils.copyInputStreamToFile(is, tmp);
			File dstFile = new File(saveFileName);
			FileUtils.moveFile(tmp, dstFile);

			fileIds.add(dstFile.getAbsolutePath());
			
			log.debug("파일 저장 완료 : {}",dstFile.getAbsolutePath());
		}
		return fileIds;
	}
	
}
