package ytdlweb.model;

public class Video extends FileToDownload implements Downloadable {

	private static final String CONTENT_TYPE = "video/mp4";
	private static final String EXTENSION = ".mp4";

	public Video(String fileName) {
		this.fileName = fileName + EXTENSION;
	}

	@Override
	public String getContentType() {
		return CONTENT_TYPE;
	}

}
