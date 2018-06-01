package hayaa.cms.service.model;

import hayaa.basemodel.model.BaseData;

public class Article extends BaseData {
    private Integer articleId;

    public void setArticleId(Integer articleIdvalue) {
        this.articleId = articleIdvalue;
    }

    public Integer getArticleId() {
        return this.articleId;
    }

    private String title;

    public void setTitle(String titlevalue) {
        this.title = titlevalue;
    }

    public String getTitle() {
        return this.title;
    }

    private String subTitle;

    public void setSubTitle(String subTitlevalue) {
        this.subTitle = subTitlevalue;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    private String content;

    public void setContent(String contentvalue) {
        this.content = contentvalue;
    }

    public String getContent() {
        return this.content;
    }

    private String seo;

    public void setSeo(String seovalue) {
        this.seo = seovalue;
    }

    public String getSeo() {
        return this.seo;
    }
}