package ytdlweb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ytdlweb.model.Downloadable;
import ytdlweb.model.Mp3;
import ytdlweb.service.IYtdlwebService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class YtdlwebRestController {

	private static final String HEADER_CACHE_CONTROL = "must-revalidate, post-check=0, pre-check=0";

	@Autowired
	IYtdlwebService ytdlwebService;

	@RequestMapping(value = "/ytdlweb/{url}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> downloadMp3(@PathVariable("url") String url) {

		//final String mocName = "pop_v2.mp3";
		//final String pathName = YtdlwebRestController.class.getClassLoader().getResource(mocName).getFile();

		//InputStream inputStream = new FileInputStream(pathName);
		//byte[] contents = StreamUtils.copyToByteArray(inputStream);
		//byte[] contents = ytdlwebService.downloadMp3(url);

		Downloadable downloadable = ytdlwebService.downloadMp3(url);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(Mp3.CONTENT_TYPE));
		headers.setContentDispositionFormData(downloadable.getFileName(), downloadable.getFileName());
		headers.setCacheControl(HEADER_CACHE_CONTROL);
		ResponseEntity<byte[]> response = new ResponseEntity<>(downloadable.getContents(), headers, HttpStatus.OK);

		return response;

	}
}
