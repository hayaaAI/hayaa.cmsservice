package hayaa.cms.service.core;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import hayaa.basemodel.model.FunctionListResult;
import hayaa.basemodel.model.FunctionOpenResult;
import hayaa.basemodel.model.FunctionResult;
import hayaa.basemodel.model.GridPager.GridPager;
import hayaa.basemodel.model.GridPager.GridPagerPamater;
import hayaa.cms.service.IChannelService;
import hayaa.cms.service.model.Channel;
import hayaa.cms.service.model.ChannelSearchPamater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("channelService")
public class ChannelService implements IChannelService {
    @Autowired
    private ChannelMapper channelMapper;

    @Override
    public FunctionResult<Channel> Create(Channel info) {
        FunctionResult<Channel> r = new FunctionResult<Channel>();
        channelMapper.insert(info);
        if (info.getchannelId() > 0) {
            r.setData(info);
        }
        return r;
    }

    @Override
    public FunctionOpenResult<Boolean> UpdateByID(Channel info) {
        FunctionOpenResult<Boolean> r = new FunctionOpenResult<Boolean>();
        r.setData(channelMapper.update(info));
        return r;
    }

    @Override
    public FunctionOpenResult<Boolean> DeleteByID(List<Integer> list) {
        FunctionOpenResult<Boolean> r = new FunctionOpenResult<Boolean>();
        String ids = list.toString().replace("[", "").replace("]", "");
        r.setData(channelMapper.delete(ids));
        return r;
    }

    @Override
    public GridPager<Channel> GetPager(GridPagerPamater<ChannelSearchPamater> gridPagerPamater) {
        PageHelper.orderBy("ChannelId desc");
        Page pageInfo = PageHelper.startPage(gridPagerPamater.getCurrent(), gridPagerPamater.getPageSize());
        List<Channel> dalResult = channelMapper.getList(gridPagerPamater.getSearchPamater());
        GridPager<Channel> r = new GridPager<>(gridPagerPamater.getCurrent(), gridPagerPamater.getPageSize());
        r.setData(dalResult);
        r.setTotal((int) pageInfo.getTotal());
        return r;
    }

    @Override
    public FunctionResult<Channel> Get(int id) {
        FunctionResult<Channel> r = new FunctionResult<Channel>();
        r.setData(channelMapper.get(id));
        return r;
    }

    @Override
    public FunctionListResult<Channel> GetList(ChannelSearchPamater searchPamater) {
        FunctionListResult<Channel> r = new FunctionListResult<Channel>();
        r.setData(channelMapper.getList(searchPamater));
        return r;
    }
}