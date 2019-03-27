package com.casterwx;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-03-27-16:03
 */
public class Interfor {
    private String title ;
    private String desc ;
    private String url ;

    @Override
    public String toString() {
        return "Interfor{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", url='" + url + '\'' +
                '}';
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
