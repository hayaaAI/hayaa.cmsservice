package hayaa.cms.service.core;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
interface Rel_WebSite_Channel_ArticleMapper {
    @Insert("insert into Rel_WebSite_Channel_Article(Id,webSiteId,channelId,articleId,createTime) values(#{rel_WebSite_Channel_Article.Id},#{rel_WebSite_Channel_Article.webSiteId},#{rel_WebSite_Channel_Article.channelId},#{rel_WebSite_Channel_Article.articleId},#{rel_WebSite_Channel_Article.createTime});")
    @Options(useGeneratedKeys = true, keyProperty = "rel_WebSite_Channel_Article.Rel_WebSite_Channel_ArticleId")
    void insert(@Param("rel_WebSite_Channel_Article") Rel_WebSite_Channel_Article rel_WebSite_Channel_Article);

    @Update("update Rel_WebSite_Channel_Article set Id=#{rel_WebSite_Channel_Article.Id},webSiteId=#{rel_WebSite_Channel_Article.webSiteId},channelId=#{rel_WebSite_Channel_Article.channelId},articleId=#{rel_WebSite_Channel_Article.articleId},createTime=#{rel_WebSite_Channel_Article.createTime} where Rel_WebSite_Channel_ArticleId=#{rel_WebSite_Channel_Article.Rel_WebSite_Channel_ArticleId}")
    Boolean update(@Param("rel_WebSite_Channel_Article") Rel_WebSite_Channel_Article rel_WebSite_Channel_Article);

    @Delete("delete from Rel_WebSite_Channel_Article where rel_WebSite_Channel_ArticleId in (${ids})")
    Boolean delete(@Param("ids") String ids);

    @Select("select * from Rel_WebSite_Channel_Article where Rel_WebSite_Channel_ArticleId =#{Id}")
    Rel_WebSite_Channel_Article get(int Id);
}