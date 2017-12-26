package ytdlweb.model;

public abstract class FileToDownload {

	protected String fileName;
	protected byte[] contents;

	public enum TYPE {
		mp3,
		mp4
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getContents() {
		return contents;
	}

	public void setContents(byte[] contents) {
		this.contents = contents;
	}

}
