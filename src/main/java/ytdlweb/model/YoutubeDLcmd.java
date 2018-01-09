package ytdlweb.model;

public class YoutubeDLcmd {

	private static final String PGM = "youtube-dl ";

	private String url;
	private String fileName;

	public YoutubeDLcmd(String url) {
		this.url = " " + url;
	}

	public String getFileNameCmd() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(PGM);
		stringBuilder.append("--restrict-filenames --get-filename -o /tmp/%(title)s-%(id)s");
		stringBuilder.append(url);

		return stringBuilder.toString();
	}

	public String getMp3Cmd(String fileName) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(PGM);
		stringBuilder.append("--ignore-errors -x --audio-format mp3 -o ");
		stringBuilder.append(fileName);
		stringBuilder.append(url);

		return stringBuilder.toString();
	}

	public String getMp4Cmd(String fileName) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(PGM);
		stringBuilder.append("--ignore-errors --recode-video mp4 -o ");
		stringBuilder.append(fileName);
		stringBuilder.append(url);

		return stringBuilder.toString();
	}
}
