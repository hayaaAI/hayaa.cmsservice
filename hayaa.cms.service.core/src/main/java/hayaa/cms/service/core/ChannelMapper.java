package hayaa.cms.service.core;

import hayaa.cms.service.model.Channel;
import hayaa.cms.service.model.ChannelSearchPamater;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
interface ChannelMapper {
    @Insert("insert into Channel(name,title,remark) values(#{channel.name},#{channel.title},#{channel.remark});")
    @Options(useGeneratedKeys = true, keyProperty = "channel.ChannelId")
    void insert(@Param("channel") Channel channel);

    @Update("update Channel set channelId=#{channel.channelId},name=#{channel.name},title=#{channel.title},remark=#{channel.remark} where channelId=#{channel.ChannelId}")
    Boolean update(@Param("channel") Channel channel);

    @Delete("delete from Channel where channelId in (${ids})")
    Boolean delete(@Param("ids") String ids);

    @Select("select * from Channel where ChannelId =#{Id}")
    Channel get(int Id);

    List<Channel> getList(@Param("searchPamater") ChannelSearchPamater searchPamater);
}