package ytdlweb.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import ytdlweb.model.*;
import ytdlweb.service.IYtdlwebService;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class YytdlwebService implements IYtdlwebService {

	private final Logger log = LoggerFactory.getLogger(YytdlwebService.class);

	@Override
	public Downloadable download(YoutubeRequestType youtubeRequestType) {
		Downloadable downloadable;
		String url = youtubeRequestType.getUrl();
		String type = youtubeRequestType.getType();
		boolean isMp3 = type.equals(FileToDownload.TYPE.mp3.name());

		YoutubeDLcmd ytdlcmd = new YoutubeDLcmd(url);
		String command = ytdlcmd.getFileNameCmd();
		String fileName = executeCommand(command);

		if (isMp3) {
			downloadable = new Mp3(fileName);
			command = ytdlcmd.getMp3Cmd(downloadable.getFileName());
		} else {
			downloadable = new Video(fileName);
			command = ytdlcmd.getMp4Cmd(downloadable.getFileName());
		}

		executeCommand(command);
		byte[] contents = null;

		try {
			InputStream inputStream = new FileInputStream(downloadable.getFileName());
			contents = StreamUtils.copyToByteArray(inputStream);
		} catch (Exception exception) {

		} finally {
			downloadable.setContents(contents);
		}

		return downloadable;
	}

	private String executeCommand(String command) {

		log.info(String.format("Running command %s", command));

		StringBuffer output = new StringBuffer();

		Process process;

		try {
			process = Runtime.getRuntime().exec(command);
			process.waitFor();
			BufferedReader bufferedReader =
					new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				output.append(line/* + "\n"*/);
				//System.out.print(output);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return output.toString();
	}
}
