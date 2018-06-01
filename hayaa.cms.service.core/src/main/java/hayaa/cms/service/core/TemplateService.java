package hayaa.cms.service.core;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import hayaa.basemodel.model.FunctionListResult;
import hayaa.basemodel.model.FunctionOpenResult;
import hayaa.basemodel.model.FunctionResult;
import hayaa.basemodel.model.GridPager.GridPager;
import hayaa.basemodel.model.GridPager.GridPagerPamater;
import hayaa.cms.service.ITemplateService;
import hayaa.cms.service.model.Template;
import hayaa.cms.service.model.TemplateSearchPamater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("templateService")
public class TemplateService implements ITemplateService {
    @Autowired
    private TemplateMapper templateMapper;

    @Override
    public FunctionResult<Template> Create(Template info) {
        FunctionResult<Template> r = new FunctionResult<Template>();
        templateMapper.insert(info);
        if (info.getTemplateId() > 0) {
            r.setData(info);
        }
        return r;
    }

    @Override
    public FunctionOpenResult<Boolean> UpdateByID(Template info) {
        FunctionOpenResult<Boolean> r = new FunctionOpenResult<Boolean>();
        r.setData(templateMapper.update(info));
        return r;
    }

    @Override
    public FunctionOpenResult<Boolean> DeleteByID(List<Integer> list) {
        FunctionOpenResult<Boolean> r = new FunctionOpenResult<Boolean>();
        String ids = list.toString().replace("[", "").replace("]", "");
        r.setData(templateMapper.delete(ids));
        return r;
    }

    @Override
    public GridPager<Template> GetPager(GridPagerPamater<TemplateSearchPamater> gridPagerPamater) {
        PageHelper.orderBy("TemplateId desc");
        Page pageInfo = PageHelper.startPage(gridPagerPamater.getCurrent(), gridPagerPamater.getPageSize());
        List<Template> dalResult = templateMapper.getList(gridPagerPamater.getSearchPamater());
        GridPager<Template> r = new GridPager<>(gridPagerPamater.getCurrent(), gridPagerPamater.getPageSize());
        r.setData(dalResult);
        r.setTotal((int) pageInfo.getTotal());
        return r;
    }

    @Override
    public FunctionResult<Template> Get(int id) {
        FunctionResult<Template> r = new FunctionResult<Template>();
        r.setData(templateMapper.get(id));
        return r;
    }

    @Override
    public FunctionListResult<Template> GetList(TemplateSearchPamater searchPamater) {
        FunctionListResult<Template> r = new FunctionListResult<Template>();
        r.setData(templateMapper.getList(searchPamater));
        return r;
    }
}