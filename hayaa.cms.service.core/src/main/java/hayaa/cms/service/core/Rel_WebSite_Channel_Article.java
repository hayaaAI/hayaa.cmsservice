package hayaa.cms.service.core;

import hayaa.basemodel.model.BaseData;

import java.util.Date;

public class Rel_WebSite_Channel_Article extends BaseData {
    private Integer Id;

    public void setId(Integer Idvalue) {
        this.Id = Idvalue;
    }

    public Integer getId() {
        return this.Id;
    }

    private Integer webSiteId;

    public void setwebSiteId(Integer webSiteIdvalue) {
        this.webSiteId = webSiteIdvalue;
    }

    public Integer getwebSiteId() {
        return this.webSiteId;
    }

    private Integer channelId;

    public void setchannelId(Integer channelIdvalue) {
        this.channelId = channelIdvalue;
    }

    public Integer getchannelId() {
        return this.channelId;
    }

    private Integer articleId;

    public void setarticleId(Integer articleIdvalue) {
        this.articleId = articleIdvalue;
    }

    public Integer getarticleId() {
        return this.articleId;
    }

    private Date createTime;

    public void setcreateTime(Date createTimevalue) {
        this.createTime = createTimevalue;
    }

    public Date getcreateTime() {
        return this.createTime;
    }
}