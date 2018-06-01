package hayaa.cms.service.model;

import hayaa.basemodel.model.BaseData;

import java.util.Date;

public class Article extends BaseData {
    private Integer articleId;

    public void setarticleId(Integer articleIdvalue) {
        this.articleId = articleIdvalue;
    }

    public Integer getarticleId() {
        return this.articleId;
    }

    private String title;

    public void settitle(String titlevalue) {
        this.title = titlevalue;
    }

    public String gettitle() {
        return this.title;
    }

    private String subTitle;

    public void setsubTitle(String subTitlevalue) {
        this.subTitle = subTitlevalue;
    }

    public String getsubTitle() {
        return this.subTitle;
    }

    private String content;

    public void setcontent(String contentvalue) {
        this.content = contentvalue;
    }

    public String getcontent() {
        return this.content;
    }

    private String seo;

    public void setseo(String seovalue) {
        this.seo = seovalue;
    }

    public String getseo() {
        return this.seo;
    }

    private Date createTime;

    public void setcreateTime(Date createTimevalue) {
        this.createTime = createTimevalue;
    }

    public Date getcreateTime() {
        return this.createTime;
    }

    private Date updateTime;

    public void setupdateTime(Date updateTimevalue) {
        this.updateTime = updateTimevalue;
    }

    public Date getupdateTime() {
        return this.updateTime;
    }
}