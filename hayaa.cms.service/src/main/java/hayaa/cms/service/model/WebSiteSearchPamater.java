package hayaa.cms.service.model;

import java.util.List;

public class WebSiteSearchPamater {
    private Integer webSiteId;

    public void setWebSiteId(Integer webSiteIdvalue) {
        this.webSiteId = webSiteIdvalue;
    }

    public Integer getWebSiteId() {
        return this.webSiteId;
    }

    private List<Integer> webSiteIdList;

    public void setwebSiteIdList(List<Integer> webSiteIdvalue) {
        this.webSiteIdList = webSiteIdvalue;
    }

    public List<Integer> getwebSiteIdList() {
        return this.webSiteIdList;
    }

    private Integer webSiteIdMax;

    public void setwebSiteIdMax(Integer webSiteIdvalue) {
        this.webSiteIdMax = webSiteIdvalue;
    }

    public Integer getwebSiteIdMax() {
        return this.webSiteIdMax;
    }

    private Integer webSiteIdMin;

    public void setwebSiteIdMin(Integer webSiteIdvalue) {
        this.webSiteIdMin = webSiteIdvalue;
    }

    public Integer getwebSiteIdMin() {
        return this.webSiteIdMin;
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

    private String remark;

    public void setRemark(String remarkvalue) {
        this.remark = remarkvalue;
    }

    public String getRemark() {
        return this.remark;
    }

    private List<String> remarkList;

    public void setremarkList(List<String> remarkvalue) {
        this.remarkList = remarkvalue;
    }

    public List<String> getremarkList() {
        return this.remarkList;
    }
}