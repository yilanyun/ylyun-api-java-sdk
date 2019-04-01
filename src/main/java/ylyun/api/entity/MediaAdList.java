package ylyun.api.entity;

import java.util.List;

public class MediaAdList extends BaseEntity {
    private List<MediaAdInfo> data;

    public List<MediaAdInfo> getData() {
        return data;
    }

    public void setData(List<MediaAdInfo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MediaAdList{" +
                "data=" + data +
                '}';
    }
}
