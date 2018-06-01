package hayaa.cms.service.model;

import java.util.List;

public class ArticleSearchPamater {
    private Integer articleId;

    public void setArticleId(Integer articleIdvalue) {
        this.articleId = articleIdvalue;
    }

    public Integer getArticleId() {
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

    public void setTitle(String titlevalue) {
        this.title = titlevalue;
    }

    public String getTitle() {
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

    public void setSubTitle(String subTitlevalue) {
        this.subTitle = subTitlevalue;
    }

    public String getSubTitle() {
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

    public void setContent(String contentvalue) {
        this.content = contentvalue;
    }

    public String getContent() {
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

    public void setSeo(String seovalue) {
        this.seo = seovalue;
    }

    public String getSeo() {
        return this.seo;
    }

    private List<String> seoList;

    public void setseoList(List<String> seovalue) {
        this.seoList = seovalue;
    }

    public List<String> getseoList() {
        return this.seoList;
    }
}