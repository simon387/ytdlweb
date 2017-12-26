package ytdlweb.model;

public interface Downloadable {

	String getContentType();

	String getFileName();

	byte[] getContents();

	void setContents(byte[] array);
}
