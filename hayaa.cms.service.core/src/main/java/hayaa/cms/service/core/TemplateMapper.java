package hayaa.cms.service.core;

import hayaa.cms.service.model.Template;
import hayaa.cms.service.model.TemplateSearchPamater;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
interface TemplateMapper {
    @Insert("insert into Template(name,title,content) values(#{template.name},#{template.title},#{template.content});")
    @Options(useGeneratedKeys = true, keyProperty = "template.TemplateId")
    void insert(@Param("template") Template template);

    @Update("update Template set templateId=#{template.templateId},name=#{template.name},title=#{template.title},content=#{template.content} where templateId=#{template.TemplateId}")
    Boolean update(@Param("template") Template template);

    @Delete("delete from Template where templateId in (${ids})")
    Boolean delete(@Param("ids") String ids);

    @Select("select * from Template where TemplateId =#{Id}")
    Template get(int Id);

    List<Template> getList(@Param("searchPamater") TemplateSearchPamater searchPamater);
}