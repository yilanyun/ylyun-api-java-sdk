package ylyun.api.examples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ylyun.api.YLYunClient;
import ylyun.api.entity.Channel;
import ylyun.api.entity.MediaDetail;
import ylyun.api.entity.MediaInfo;
import ylyun.api.entity.Play;

public class ClientExample {

	public static void main(String[] args) {
		//公共参数
		Map<String, String> comm = new HashMap<String, String>();
		comm.put("accessKey", "ylx36jukc8oq");
		comm.put("accessToken", "ow5um6c233cax89dyuaqzh3g3l4duxdx");
		comm.put("platform", "bjqm");
		comm.put("udid", "5459daf640bdb6a6a7e294a5f3f5f0d1");
		comm.put("ver", "1.5.3.224");
		comm.put("model", "COL-AL10");
		comm.put("ip", "1.202.240.202");
		//client
		YLYunClient client = new YLYunClient(comm);

		//channel test
		List<Channel> chan = client.channel().getChannel();
		System.out.println("channel test:");
		System.out.println(chan);

		//recomment test
		long uid = 1024024;
		int type = 0;
		int channelId = 1351;
		List<MediaInfo> feed = client.recommend().recommendFeed(type, channelId, uid);
		System.out.println("video recommend test:");
		System.out.println(feed);
		List<MediaInfo> ugc = client.recommend().recommendUgcFeed(type, uid);
		System.out.println("ugc recommend test:");
		System.out.println(ugc);
		Map<String, String> param = new HashMap<String, String>();
		param.put("channel_id", "1351");
		param.put("adid", "TEST_YILAN");
		param.put("os", "1");
		param.put("os_ver", "12,1");
		param.put("pkg_name", "");
		param.put("network", "1");
		param.put("ua", "test");
		param.put("carrier", "70120");
		List<MediaAdInfo> feedWithAd = client.recommend().recommendFeedWithAd(param);
		System.out.println("recommend whit ad test:");
		System.out.println(feedWithAd);

		//search test
		String keyword = "好兔视频";
		List<MediaInfo> search = client.search().searchVideo(keyword);
		System.out.println("video search test:");
		System.out.println(search);

		//video test
		String vid = "lm5lG1kXxjp2";
		MediaDetail info = client.video().videoDetail(vid);
		System.out.println("video detail test:");
		System.out.println(info);

		List<MediaInfo> relate = client.video().videoRelate(vid);
		System.out.println("video relate test:");
		System.out.println(relate);
	}
}
