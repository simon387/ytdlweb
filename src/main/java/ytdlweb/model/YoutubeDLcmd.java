package ytdlweb.model;

public class YoutubeDLcmd {

	private static final String PGM = "youtube-dl ";

	private String url;

	public YoutubeDLcmd(String url) {
		this.url = " " + url;
	}

	public String getFileNameCmd() {
		return getHelper("--restrict-filenames --get-filename -o /tmp/%(title)s-%(id)s", "");
	}

	public String getMp3Cmd(String fileName) {
		return getHelper("--ignore-errors -x --audio-format mp3 -o ", fileName);
	}

	public String getMp4Cmd(String fileName) {
		return getHelper("--ignore-errors --recode-video mp4 -o ", fileName);
	}

	private String getHelper(String cmd, String fileName) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(PGM);
		stringBuilder.append(cmd);
		stringBuilder.append(fileName);
		stringBuilder.append(url);

		return stringBuilder.toString();
	}
}
