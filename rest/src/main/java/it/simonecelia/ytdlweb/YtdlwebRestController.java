package it.simonecelia.ytdlweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/ytdlweb")
public class YtdlwebRestController {

	@Autowired
	YtdlwebRestController() {
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Resource> download(@PathVariable String url) throws IOException {

		File file = new File("");
	}
}
