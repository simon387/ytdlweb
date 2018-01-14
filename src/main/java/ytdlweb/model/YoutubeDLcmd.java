package ytdlweb.model;

public class YoutubeDLcmd {

	private static final String PGM = "youtube-dl ";
	private static final String CMD_GET_FILENAME = "--restrict-filenames --get-filename -o /tmp/%(title)s-%(id)s";
	private static final String CMD_GET_MP3 = "--ignore-errors -x --audio-format mp3 -o ";
	private static final String CMD_GET_MP4 = "--ignore-errors --recode-video mp4 -o ";

	private String url;

	public YoutubeDLcmd(String url) {
		this.url = " " + url;
	}

	public String getFileNameCmd() {
		return getterHelper(CMD_GET_FILENAME, "");
	}

	public String getMp3Cmd(String fileName) {
		return getterHelper(CMD_GET_MP3, fileName);
	}

	public String getMp4Cmd(String fileName) {
		return getterHelper(CMD_GET_MP4, fileName);
	}

	private String getterHelper(String cmd, String fileName) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(PGM);
		stringBuilder.append(cmd);
		stringBuilder.append(fileName);
		stringBuilder.append(url);

		return stringBuilder.toString();

	}
}
