package ytdlweb.model;

public class Mp3 extends FileToDownload implements Downloadable {

	public static final String CONTENT_TYPE = "audio/mpeg";

	public Mp3 (String fileName, byte[] contents) {
		this.fileName = fileName;
		this.contents = contents;
	}

	@Override
	public String getFileName() {
		return fileName;
	}

	@Override
	public byte[] getContents() {
		return contents;
	}
}
