package hayaa.cms.service.core;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import hayaa.basemodel.model.FunctionListResult;
import hayaa.basemodel.model.FunctionOpenResult;
import hayaa.basemodel.model.FunctionResult;
import hayaa.basemodel.model.GridPager.GridPager;
import hayaa.basemodel.model.GridPager.GridPagerPamater;
import hayaa.cms.service.IWebSiteService;
import hayaa.cms.service.model.WebSite;
import hayaa.cms.service.model.WebSiteSearchPamater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("webSiteService")
public class WebSiteService implements IWebSiteService {
    @Autowired
    private WebSiteMapper webSiteMapper;

    @Override
    public FunctionResult<WebSite> Create(WebSite info) {
        FunctionResult<WebSite> r = new FunctionResult<WebSite>();
        webSiteMapper.insert(info);
        if (info.getWebSiteId() > 0) {
            r.setData(info);
        }
        return r;
    }

    @Override
    public FunctionOpenResult<Boolean> UpdateByID(WebSite info) {
        FunctionOpenResult<Boolean> r = new FunctionOpenResult<Boolean>();
        r.setData(webSiteMapper.update(info));
        return r;
    }

    @Override
    public FunctionOpenResult<Boolean> DeleteByID(List<Integer> list) {
        FunctionOpenResult<Boolean> r = new FunctionOpenResult<Boolean>();
        String ids = list.toString().replace("[", "").replace("]", "");
        r.setData(webSiteMapper.delete(ids));
        return r;
    }

    @Override
    public GridPager<WebSite> GetPager(GridPagerPamater<WebSiteSearchPamater> gridPagerPamater) {
        PageHelper.orderBy("WebSiteId desc");
        Page pageInfo = PageHelper.startPage(gridPagerPamater.getCurrent(), gridPagerPamater.getPageSize());
        List<WebSite> dalResult = webSiteMapper.getList(gridPagerPamater.getSearchPamater());
        GridPager<WebSite> r = new GridPager<>(gridPagerPamater.getCurrent(), gridPagerPamater.getPageSize());
        r.setData(dalResult);
        r.setTotal((int) pageInfo.getTotal());
        return r;
    }

    @Override
    public FunctionResult<WebSite> Get(int id) {
        FunctionResult<WebSite> r = new FunctionResult<WebSite>();
        r.setData(webSiteMapper.get(id));
        return r;
    }

    @Override
    public FunctionListResult<WebSite> GetList(WebSiteSearchPamater searchPamater) {
        FunctionListResult<WebSite> r = new FunctionListResult<WebSite>();
        r.setData(webSiteMapper.getList(searchPamater));
        return r;
    }
}