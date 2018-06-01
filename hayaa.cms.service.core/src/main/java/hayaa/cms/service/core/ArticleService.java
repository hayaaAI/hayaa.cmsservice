package hayaa.cms.service.core;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import hayaa.basemodel.model.FunctionListResult;
import hayaa.basemodel.model.FunctionOpenResult;
import hayaa.basemodel.model.FunctionResult;
import hayaa.basemodel.model.GridPager.GridPager;
import hayaa.basemodel.model.GridPager.GridPagerPamater;
import hayaa.cms.service.IArticleService;
import hayaa.cms.service.model.Article;
import hayaa.cms.service.model.ArticleSearchPamater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleService")
public class ArticleService implements IArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public FunctionResult<Article> Create(Article info) {
        FunctionResult<Article> r = new FunctionResult<Article>();
        articleMapper.insert(info);
        if (info.getArticleId() > 0) {
            r.setData(info);
        }
        return r;
    }

    @Override
    public FunctionOpenResult<Boolean> UpdateByID(Article info) {
        FunctionOpenResult<Boolean> r = new FunctionOpenResult<Boolean>();
        r.setData(articleMapper.update(info));
        return r;
    }

    @Override
    public FunctionOpenResult<Boolean> DeleteByID(List<Integer> list) {
        FunctionOpenResult<Boolean> r = new FunctionOpenResult<Boolean>();
        String ids = list.toString().replace("[", "").replace("]", "");
        r.setData(articleMapper.delete(ids));
        return r;
    }

    @Override
    public GridPager<Article> GetPager(GridPagerPamater<ArticleSearchPamater> gridPagerPamater) {
        PageHelper.orderBy("ArticleId desc");
        Page pageInfo = PageHelper.startPage(gridPagerPamater.getCurrent(), gridPagerPamater.getPageSize());
        List<Article> dalResult = articleMapper.getList(gridPagerPamater.getSearchPamater());
        GridPager<Article> r = new GridPager<>(gridPagerPamater.getCurrent(), gridPagerPamater.getPageSize());
        r.setData(dalResult);
        r.setTotal((int) pageInfo.getTotal());
        return r;
    }

    @Override
    public FunctionResult<Article> Get(int id) {
        FunctionResult<Article> r = new FunctionResult<Article>();
        r.setData(articleMapper.get(id));
        return r;
    }

    @Override
    public FunctionListResult<Article> GetList(ArticleSearchPamater searchPamater) {
        FunctionListResult<Article> r = new FunctionListResult<Article>();
        r.setData(articleMapper.getList(searchPamater));
        return r;
    }
}