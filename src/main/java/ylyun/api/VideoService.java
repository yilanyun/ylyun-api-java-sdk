package ylyun.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;
import ylyun.api.entity.MediaDetail;
import ylyun.api.entity.MediaInfo;
import ylyun.api.entity.MediaList;
import ylyun.api.entity.Play;
import ylyun.api.entity.PlayUrlList;
import ylyun.common.connection.ApacheHttpClient;

/**
 * 视频频道服务
 */
public class VideoService {
	
	private static Map<String, String> servUri = new HashMap<String, String>();
	private YLYunClient client;
	private Map<String, String> comm = new HashMap<String, String>();
	private static Logger LOG = LoggerFactory.getLogger(ChannelService.class);
	private static Gson GSON = new Gson();
	
	public VideoService(YLYunClient client) {
		servUri.put("detail", "/video/detail");
		servUri.put("relate", "/video/relation");
		servUri.put("play", "/video/play");
		this.client = client;
		this.comm = this.client.getCommParams();
	}
	
	/**
	 * 获取视频详情
	 */
	public MediaDetail videoDetail(String vid) {
		MediaDetail data = new MediaDetail();
		Map<String, String> params = new HashMap<String, String>();
		params.putAll(this.comm);
		params.put("id", vid);
		String servUrl = this.client.getFullUrl(servUri.get("detail"), params);
		//发送请求
		String result = ApacheHttpClient.httpGet(servUrl);
		MediaDetail list = GSON.fromJson(result, MediaDetail.class);
		if (list.isOk()) {
			data = list;
		} else {
			LOG.warn("call video detail fail");
		}
		return data;
	}
	
	/**
	 * 视频相关推荐
	 */
	public List<MediaInfo> videoRelate(String vid) {
		List<MediaInfo> data = new ArrayList<MediaInfo>();
		Map<String, String> params = new HashMap<String, String>();
		params.putAll(this.comm);
		params.put("id", vid);
		String servUrl = this.client.getFullUrl(servUri.get("relate"), params);
		//发送请求
		String result = ApacheHttpClient.httpGet(servUrl);
		MediaList list = GSON.fromJson(result, MediaList.class);
		if (list.isOk() && !list.getData().isEmpty()) {
			data = list.getData();
		} else {
			LOG.warn("call video relate service fail");
		}
		return data;
	}
	
	/**
	 * 视频播放信息
	 */
	public List<Play> videoPlay(String vid) {
		List<Play> data = new ArrayList<Play>();
		Map<String, String> params = new HashMap<String, String>();
		params.putAll(this.comm);
		params.put("id", vid);
		String servUrl = this.client.getFullUrl(servUri.get("play"), params);
		//发送请求
		String result = ApacheHttpClient.httpGet(servUrl);
		PlayUrlList list = GSON.fromJson(result, PlayUrlList.class);
		if (list.isOk() && list.getBitrates()!= null &&!list.getBitrates().isEmpty()) {
			data = list.getBitrates();
		} else {
			LOG.warn("call video play fail");
		}
		return data;
	}
}