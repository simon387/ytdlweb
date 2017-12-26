package ytdlweb.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ytdlweb.model.Downloadable;
import ytdlweb.model.YoutubeRequestType;
import ytdlweb.service.IYtdlwebService;
import ytdlweb.utils.ValidationValue;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;

@RestController
public class YtdlwebRestController {

	private static final String HEADER_CACHE_CONTROL = "must-revalidate, post-check=0, pre-check=0";

	private final Logger log = LoggerFactory.getLogger(YtdlwebRestController.class);

	@Autowired
	IYtdlwebService ytdlwebService;

	@RequestMapping(value = "/ytdl", method = RequestMethod.POST, headers="Accept=application/json")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public ResponseEntity<byte[]> download(
			@RequestBody @Valid @NotNull(message = ValidationValue.YOUTUBEREQUESTTYPE) YoutubeRequestType youtubeRequestType,
			BindingResult bindingResult) {

		Downloadable downloadable = ytdlwebService.download(youtubeRequestType);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(downloadable.getContentType()));
		headers.setContentDispositionFormData(downloadable.getFileName(), downloadable.getFileName());
		headers.setCacheControl(HEADER_CACHE_CONTROL);
		ResponseEntity<byte[]> response = new ResponseEntity<>(downloadable.getContents(), headers, HttpStatus.OK);

		return response;

	}
}
