package hayaa.cms.service.model;

import java.util.Date;
import java.util.List;

public class ChannelSearchPamater {
    private Integer channelId;

    public void setchannelId(Integer channelIdvalue) {
        this.channelId = channelIdvalue;
    }

    public Integer getchannelId() {
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

    public void setname(String namevalue) {
        this.name = namevalue;
    }

    public String getname() {
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

    private String remark;

    public void setremark(String remarkvalue) {
        this.remark = remarkvalue;
    }

    public String getremark() {
        return this.remark;
    }

    private List<String> remarkList;

    public void setremarkList(List<String> remarkvalue) {
        this.remarkList = remarkvalue;
    }

    public List<String> getremarkList() {
        return this.remarkList;
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