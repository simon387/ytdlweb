package ytdlweb.model;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.hibernate.validator.constraints.NotEmpty;
import ytdlweb.utils.ValidationValue;

import java.io.Serializable;

@JsonPropertyOrder({
		"url",
		"type"
})

public class YoutubeRequestType implements Serializable {

	@NotEmpty(message = ValidationValue.YOUTUBEREQUESTTYPE_URL)
	private String url;

	@NotEmpty(message = ValidationValue.YOUTUBEREQUESTTYPE_TYPE)
	private String type;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("YoutubeRequestType [url=");
		stringBuilder.append(url);
		stringBuilder.append(", type=");
		stringBuilder.append(type);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}
