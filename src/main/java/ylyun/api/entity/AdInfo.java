package ylyun.api.entity;

import java.io.Serializable;
import java.util.List;

public class AdInfo implements Serializable {
    private String advid;
    private String adxpid;
    private String arid;
    private String cid;
    private int ctype;
    private String formatid;
    private String gpid;
    private String height;
    private String impid;
    private List<AdMtls> mtls;
    private String oid;
    private String pid;
    private String plid;
    private String ppid;
    private String price;
    private String pricetype;
    private String tview;
    private String unid;
    private String width;
    private String xcurl;

    public String getAdvid() {
        return advid;
    }

    public void setAdvid(String advid) {
        this.advid = advid;
    }

    public String getAdxpid() {
        return adxpid;
    }

    public void setAdxpid(String adxpid) {
        this.adxpid = adxpid;
    }

    public String getArid() {
        return arid;
    }

    public void setArid(String arid) {
        this.arid = arid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getCtype() {
        return ctype;
    }

    public void setCtype(int ctype) {
        this.ctype = ctype;
    }

    public String getFormatid() {
        return formatid;
    }

    public void setFormatid(String formatid) {
        this.formatid = formatid;
    }

    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getImpid() {
        return impid;
    }

    public void setImpid(String impid) {
        this.impid = impid;
    }

    public List<AdMtls> getMtls() {
        return mtls;
    }

    public void setMtls(List<AdMtls> mtls) {
        this.mtls = mtls;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPlid() {
        return plid;
    }

    public void setPlid(String plid) {
        this.plid = plid;
    }

    public String getPpid() {
        return ppid;
    }

    public void setPpid(String ppid) {
        this.ppid = ppid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPricetype() {
        return pricetype;
    }

    public void setPricetype(String pricetype) {
        this.pricetype = pricetype;
    }

    public String getTview() {
        return tview;
    }

    public void setTview(String tview) {
        this.tview = tview;
    }

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getXcurl() {
        return xcurl;
    }

    public void setXcurl(String xcurl) {
        this.xcurl = xcurl;
    }








    @Override
    public String toString() {
        return "AdInfo{" +
                "advid='" + advid + '\'' +
                ", adxpid='" + adxpid + '\'' +
                ", arid='" + arid + '\'' +
                ", cid='" + cid + '\'' +
                ", ctype=" + ctype +
                ", formatid='" + formatid + '\'' +
                ", gpid='" + gpid + '\'' +
                ", height='" + height + '\'' +
                ", impid='" + impid + '\'' +
                ", mtls=" + mtls +
                ", oid='" + oid + '\'' +
                ", pid='" + pid + '\'' +
                ", plid='" + plid + '\'' +
                ", ppid='" + ppid + '\'' +
                ", price='" + price + '\'' +
                ", pricetype='" + pricetype + '\'' +
                ", tview='" + tview + '\'' +
                ", unid='" + unid + '\'' +
                ", width='" + width + '\'' +
                ", xcurl='" + xcurl + '\'' +
                '}';
    }
}
