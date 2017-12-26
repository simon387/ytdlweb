package ytdlweb.model;

public class YoutubeDLcmd {

	private static final String PGM = "youtube-dl";

	public enum MacroOperation {
		GET_FILE_NAME,
		GET_MP3,
		GET_MP4
	}
	private boolean ignoreErrors;
	private boolean restrictFilenames;
	private boolean getFileName;
	private String output;
	private String url;
	private boolean audioFormat;
	private boolean recodeVideo;

	YoutubeDLcmd (String output, String url, MacroOperation macroOperation) {
		this.output = output;
		this.url = url;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(PGM);
		stringBuilder.append(" ");
		return stringBuilder.toString();
	}
}
