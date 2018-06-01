package hayaa.cms.service.model;

import java.util.Date;
import java.util.List;

public class ArticleSearchPamater {
    private Integer articleId;

    public void setarticleId(Integer articleIdvalue) {
        this.articleId = articleIdvalue;
    }

    public Integer getarticleId() {
        return this.articleId;
    }

    private List<Integer> articleIdList;

    public void setarticleIdList(List<Integer> articleIdvalue) {
        this.articleIdList = articleIdvalue;
    }

    public List<Integer> getarticleIdList() {
        return this.articleIdList;
    }

    private Integer articleIdMax;

    public void setarticleIdMax(Integer articleIdvalue) {
        this.articleIdMax = articleIdvalue;
    }

    public Integer getarticleIdMax() {
        return this.articleIdMax;
    }

    private Integer articleIdMin;

    public void setarticleIdMin(Integer articleIdvalue) {
        this.articleIdMin = articleIdvalue;
    }

    public Integer getarticleIdMin() {
        return this.articleIdMin;
    }

    private String title;

    public void settitle(String titlevalue) {
        this.title = titlevalue;
    }

    public String gettitle() {
        return this.title;
    }

    private List<String> titleList;

    public void settitleList(List<String> titlevalue) {
        this.titleList = titlevalue;
    }

    public List<String> gettitleList() {
        return this.titleList;
    }

    private String subTitle;

    public void setsubTitle(String subTitlevalue) {
        this.subTitle = subTitlevalue;
    }

    public String getsubTitle() {
        return this.subTitle;
    }

    private List<String> subTitleList;

    public void setsubTitleList(List<String> subTitlevalue) {
        this.subTitleList = subTitlevalue;
    }

    public List<String> getsubTitleList() {
        return this.subTitleList;
    }

    private String content;

    public void setcontent(String contentvalue) {
        this.content = contentvalue;
    }

    public String getcontent() {
        return this.content;
    }

    private List<String> contentList;

    public void setcontentList(List<String> contentvalue) {
        this.contentList = contentvalue;
    }

    public List<String> getcontentList() {
        return this.contentList;
    }

    private String seo;

    public void setseo(String seovalue) {
        this.seo = seovalue;
    }

    public String getseo() {
        return this.seo;
    }

    private List<String> seoList;

    public void setseoList(List<String> seovalue) {
        this.seoList = seovalue;
    }

    public List<String> getseoList() {
        return this.seoList;
    }

    private Date createTime;

    public void setcreateTime(Date createTimevalue) {
        this.createTime = createTimevalue;
    }

    public Date getcreateTime() {
        return this.createTime;
    }

    private List<Date> createTimeList;

    public void setcreateTimeList(List<Date> createTimevalue) {
        this.createTimeList = createTimevalue;
    }

    public List<Date> getcreateTimeList() {
        return this.createTimeList;
    }

    private Date createTimeMax;

    public void setcreateTimeMax(Date createTimevalue) {
        this.createTimeMax = createTimevalue;
    }

    public Date getcreateTimeMax() {
        return this.createTimeMax;
    }

    private Date createTimeMin;

    public void setcreateTimeMin(Date createTimevalue) {
        this.createTimeMin = createTimevalue;
    }

    public Date getcreateTimeMin() {
        return this.createTimeMin;
    }

    private Date updateTime;

    public void setupdateTime(Date updateTimevalue) {
        this.updateTime = updateTimevalue;
    }

    public Date getupdateTime() {
        return this.updateTime;
    }

    private List<Date> updateTimeList;

    public void setupdateTimeList(List<Date> updateTimevalue) {
        this.updateTimeList = updateTimevalue;
    }

    public List<Date> getupdateTimeList() {
        return this.updateTimeList;
    }

    private Date updateTimeMax;

    public void setupdateTimeMax(Date updateTimevalue) {
        this.updateTimeMax = updateTimevalue;
    }

    public Date getupdateTimeMax() {
        return this.updateTimeMax;
    }

    private Date updateTimeMin;

    public void setupdateTimeMin(Date updateTimevalue) {
        this.updateTimeMin = updateTimevalue;
    }

    public Date getupdateTimeMin() {
        return this.updateTimeMin;
    }
}