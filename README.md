# 一览视频云 JAVA SDK

## 概述

这是 一览视频云 REST API 的 Java 版本封装开发包，是由一览云官方提供的，一般支持最新的 API 功能。


## 安装

### maven 方式
将下边的依赖条件放到你项目的 maven pom.xml 文件里。

```
<dependency>
    <groupId>ylyun.api</groupId>
    <artifactId>ylyun-client</artifactId>
    <version>1.0.0</version>
</dependency>
```
### jar 包方式

请到 [github](https://github.com/yilanyun/ylyun-api-java-sdk)下载最新版本的发布包。


### 导入本项目

* 可以采用 `git clone https://github.com/yilanyun/ylyun-api-java-sdk` 命令下载源码
* 如果不使用git，请到[github](https://github.com/yilanyun/ylyun-api-java-sdk)下载源码包并解压
* 采用eclipse导入下载的源码工程，推荐采用maven的方式，方便依赖包的管理
* 开发者需要注意，将本项目的编码格式设置为UTF-8

### 构建本项目

可以用 Eclipse 类 IDE 导出 jar 包。建议直接使用 maven，执行命令：

	mvn package


## 使用样例

> 以下片断来自项目代码里的文件：ylyun.api.examples.ClientExample

### 初始化

```		
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ylyun.api.YLYunClient;
import ylyun.api.entity.Channel;
import ylyun.api.entity.MediaDetail;
import ylyun.api.entity.MediaInfo;
import ylyun.api.entity.Play;
...
...

    Map<String, String> comm = new HashMap<String, String>();
    comm.put("accessKey", "***");
    comm.put("accessToken", "*******");
    comm.put("platform", "***");
    comm.put("udid", "5459daf640bdb6a6a7e294a5f3f5f0d1");
    comm.put("ver", "1.5.3.224");
    comm.put("model", "COL-AL10");
    comm.put("ip", "1.202.240.202");
    //client
    YLYunClient client = new YLYunClient(comm);

...
```

#### 参数说明

| 参数名称 | 类型 | 默认值 | 是否必传 | 解释 |
| --- | --- | --- | --- | --- |
| accessKey | string | 无 | 是 | 分配给第三方平台的应用ID |
| accessToken | string | 无 | 是 | 长度为32个字符的ASCII字符串 |
| platform | string | 无 | 是 | 平台标识 如  [Android，iPhone] |
| udid | string | 无 | 是 | 设备唯一标识 |
| ver | string | 无 | 是 | 客户端版本 |
| model | string | 无 | 是 | 客户端设备型号  如 Nexus 4 |
| ip | string | 无 | 是 | 客户端ip地址 |

### 渠道相关服务

```
    List<Channel> chan = client.channel().getChannel();
    System.out.println("channel test:");
    System.out.println(chan);
```

### 推荐相关服务

```
    long uid = 1024024;
    int type = 0;
    int channelId = 1351;
    List<MediaInfo> feed = client.recommend().recommendFeed(type, channelId, uid);
    System.out.println("video recommend test:");
    System.out.println(feed);
    
    List<MediaInfo> ugc = client.recommend().recommendUgcFeed(type, uid);
    System.out.println("ugc recommend test:");
    System.out.println(ugc);
```
#### 参数说明

| 参数名称 | 类型 | 默认值 | 是否必传 | 解释 |
| --- | --- | --- | --- | --- |
| uid | long | 无 | 是 | 用户唯一标识 |
| type | int | 无 | 是 | 加载方式 0-上拉加载更多 1-非首次下拉刷新时 2-首次刷新某个频道 |
| channelId | int |  无 | 是 | 频道ID |

### 搜索相关服务

```
    String keyword = "好兔视频";
    List<MediaInfo> search = client.search().searchVideo(keyword);
    System.out.println("video search test:");
    System.out.println(search);
```
#### 参数说明

| 参数名称 | 类型 | 默认值 | 是否必传 | 解释 |
| --- | --- | --- | --- | --- |
| keyword | string | 无 | 是 | 搜索关键字 |

### 视频相关服务

```
    String vid = "lm5lG1kXxjp2";
    MediaDetail info = client.video().videoDetail(vid);
    System.out.println("video detail test:");
    System.out.println(info);
    
    List<MediaInfo> relate = client.video().videoRelate(vid);
    System.out.println("video relate test:");
    System.out.println(relate);
```
#### 参数说明

| 参数名称 | 类型 | 默认值 | 是否必传 | 解释 |
| --- | --- | --- | --- | --- |
| vid | string | 无 | 是 | 视频唯一标识ID |


## Examples

测试样例 ylyun.api.examples.ClientExample


## License

MIT

