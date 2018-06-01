package hayaa.cms.service.model;

import hayaa.basemodel.model.BaseData;

public class Template extends BaseData {
    private Integer templateId;

    public void setTemplateId(Integer templateIdvalue) {
        this.templateId = templateIdvalue;
    }

    public Integer getTemplateId() {
        return this.templateId;
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

    private String content;

    public void setContent(String contentvalue) {
        this.content = contentvalue;
    }

    public String getContent() {
        return this.content;
    }
}