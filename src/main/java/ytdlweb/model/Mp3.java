package ytdlweb.model;

public class Mp3 extends FileToDownload implements Downloadable {

	private static final String CONTENT_TYPE = "audio/mpeg";
	private static final String EXTENSION = ".mp3";

	public Mp3 (String fileName) {
		this.fileName = fileName + EXTENSION;
	}

	@Override
	public String getContentType() {
		return CONTENT_TYPE;
	}

}
