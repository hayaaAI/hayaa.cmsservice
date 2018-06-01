package hayaa.cms.service.model;

import java.util.List;

public class ChannelSearchPamater {
    private Integer channelId;

    public void setChannelId(Integer channelIdvalue) {
        this.channelId = channelIdvalue;
    }

    public Integer getChannelId() {
        return this.channelId;
    }

    private List<Integer> channelIdList;

    public void setchannelIdList(List<Integer> channelIdvalue) {
        this.channelIdList = channelIdvalue;
    }

    public List<Integer> getchannelIdList() {
        return this.channelIdList;
    }

    private Integer channelIdMax;

    public void setchannelIdMax(Integer channelIdvalue) {
        this.channelIdMax = channelIdvalue;
    }

    public Integer getchannelIdMax() {
        return this.channelIdMax;
    }

    private Integer channelIdMin;

    public void setchannelIdMin(Integer channelIdvalue) {
        this.channelIdMin = channelIdvalue;
    }

    public Integer getchannelIdMin() {
        return this.channelIdMin;
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