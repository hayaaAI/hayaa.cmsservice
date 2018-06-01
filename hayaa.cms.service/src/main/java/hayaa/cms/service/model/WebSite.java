package hayaa.cms.service.model;

import hayaa.basemodel.model.BaseData;

public class WebSite extends BaseData {
    private Integer webSiteId;

    public void setWebSiteId(Integer webSiteIdvalue) {
        this.webSiteId = webSiteIdvalue;
    }

    public Integer getWebSiteId() {
        return this.webSiteId;
    }

    private String name;

    public void setName(String namevalue) {
        this.name = namevalue;
    }

    public String getName() {
        return this.name;
    }

    private String title;

    public void setTitle(String titlevalue) {
        this.title = titlevalue;
    }

    public String getTitle() {
        return this.title;
    }

    private String remark;

    public void setRemark(String remarkvalue) {
        this.remark = remarkvalue;
    }

    public String getRemark() {
        return this.remark;
    }
}