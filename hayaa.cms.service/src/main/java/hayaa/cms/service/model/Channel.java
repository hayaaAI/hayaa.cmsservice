package hayaa.cms.service.model;

import hayaa.basemodel.model.BaseData;

import java.util.Date;

public class Channel extends BaseData {
    private Integer channelId;

    public void setchannelId(Integer channelIdvalue) {
        this.channelId = channelIdvalue;
    }

    public Integer getchannelId() {
        return this.channelId;
    }

    private String name;

    public void setname(String namevalue) {
        this.name = namevalue;
    }

    public String getname() {
        return this.name;
    }

    private String title;

    public void settitle(String titlevalue) {
        this.title = titlevalue;
    }

    public String gettitle() {
        return this.title;
    }

    private String remark;

    public void setremark(String remarkvalue) {
        this.remark = remarkvalue;
    }

    public String getremark() {
        return this.remark;
    }

    private Date createTime;

    public void setcreateTime(Date createTimevalue) {
        this.createTime = createTimevalue;
    }

    public Date getcreateTime() {
        return this.createTime;
    }

    private Date updateTime;

    public void setupdateTime(Date updateTimevalue) {
        this.updateTime = updateTimevalue;
    }

    public Date getupdateTime() {
        return this.updateTime;
    }
}