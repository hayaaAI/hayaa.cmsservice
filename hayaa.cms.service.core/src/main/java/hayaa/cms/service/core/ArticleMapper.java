package hayaa.cms.service.core;

import hayaa.cms.service.model.Article;
import hayaa.cms.service.model.ArticleSearchPamater;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
interface ArticleMapper {
    @Insert("insert into Article(title,subTitle,content,seo) values(#{article.title},#{article.subTitle},#{article.content},#{article.seo});")
    @Options(useGeneratedKeys = true, keyProperty = "article.ArticleId")
    void insert(@Param("article") Article article);

    @Update("update Article set articleId=#{article.articleId},title=#{article.title},subTitle=#{article.subTitle},content=#{article.content},seo=#{article.seo} where articleId=#{article.ArticleId}")
    Boolean update(@Param("article") Article article);

    @Delete("delete from Article where articleId in (${ids})")
    Boolean delete(@Param("ids") String ids);

    @Select("select * from Article where ArticleId =#{Id}")
    Article get(int Id);

    List<Article> getList(@Param("searchPamater") ArticleSearchPamater searchPamater);
}