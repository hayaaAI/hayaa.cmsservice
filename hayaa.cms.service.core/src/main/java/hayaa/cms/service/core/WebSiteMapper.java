package hayaa.cms.service.core;

import hayaa.cms.service.model.WebSite;
import hayaa.cms.service.model.WebSiteSearchPamater;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
interface WebSiteMapper {
    @Insert("insert into WebSite(name,title,remark) values(#{webSite.name},#{webSite.title},#{webSite.remark});")
    @Options(useGeneratedKeys = true, keyProperty = "webSite.WebSiteId")
    void insert(@Param("webSite") WebSite webSite);

    @Update("update WebSite set webSiteId=#{webSite.webSiteId},name=#{webSite.name},title=#{webSite.title},remark=#{webSite.remark} where webSiteId=#{webSite.WebSiteId}")
    Boolean update(@Param("webSite") WebSite webSite);

    @Delete("delete from WebSite where webSiteId in (${ids})")
    Boolean delete(@Param("ids") String ids);

    @Select("select * from WebSite where WebSiteId =#{Id}")
    WebSite get(int Id);

    List<WebSite> getList(@Param("searchPamater") WebSiteSearchPamater searchPamater);
}