package ytdlweb.service.impl;

import org.springframework.stereotype.Service;
import ytdlweb.model.Mp3;
import ytdlweb.service.IYtdlwebService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class YytdlwebService implements IYtdlwebService {

	@Override
	public Mp3 downloadMp3(String url) {
		url = "https://www.youtube.com/watch?v=oHNKTlz1lps";

		String command = "youtube-dl -x -o /tmp/%(title)s-%(id)s.%(ext)s " + url;

		String output = executeCommand(command);


		return null;
	}

	private String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process process;

		try {
			process = Runtime.getRuntime().exec(command);
			process.waitFor();
			BufferedReader bufferedReader =
					new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				output.append(line + "\n");
				System.out.print(output);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return output.toString();
	}
}
