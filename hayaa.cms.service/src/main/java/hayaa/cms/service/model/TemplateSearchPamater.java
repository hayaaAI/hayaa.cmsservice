package hayaa.cms.service.model;

import java.util.List;

public class TemplateSearchPamater {
    private Integer templateId;

    public void setTemplateId(Integer templateIdvalue) {
        this.templateId = templateIdvalue;
    }

    public Integer getTemplateId() {
        return this.templateId;
    }

    private List<Integer> templateIdList;

    public void settemplateIdList(List<Integer> templateIdvalue) {
        this.templateIdList = templateIdvalue;
    }

    public List<Integer> gettemplateIdList() {
        return this.templateIdList;
    }

    private Integer templateIdMax;

    public void settemplateIdMax(Integer templateIdvalue) {
        this.templateIdMax = templateIdvalue;
    }

    public Integer gettemplateIdMax() {
        return this.templateIdMax;
    }

    private Integer templateIdMin;

    public void settemplateIdMin(Integer templateIdvalue) {
        this.templateIdMin = templateIdvalue;
    }

    public Integer gettemplateIdMin() {
        return this.templateIdMin;
    }

    private String name;

    public void setName(String namevalue) {
        this.name = namevalue;
    }

    public String getName() {
        return this.name;
    }

    private List<String> nameList;

    public void setnameList(List<String> namevalue) {
        this.nameList = namevalue;
    }

    public List<String> getnameList() {
        return this.nameList;
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
}