package ylyun.api.entity;

public class MediaAdInfo extends BaseEntity {
    private String item_type;
    private MediaInfo video;
    private AdInfo ad;

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public MediaInfo getVideo() {
        return video;
    }

    public void setVideo(MediaInfo video) {
        this.video = video;
    }

    public AdInfo getAd() {
        return ad;
    }

    public void setAd(AdInfo ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "MediaAdInfo{" +
                "item_type='" + item_type + '\'' +
                ", video=" + video +
                ", ad=" + ad +
                '}';
    }
}
