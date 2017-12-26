package ytdlweb.service;

import ytdlweb.model.Downloadable;
import ytdlweb.model.YoutubeRequestType;

public interface IYtdlwebService {

	Downloadable download(YoutubeRequestType youtubeRequestType);
}
