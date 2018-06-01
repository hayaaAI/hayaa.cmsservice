package hayaa.cms.service.controller;

import hayaa.basemodel.model.FunctionListResult;
import hayaa.basemodel.model.FunctionOpenResult;
import hayaa.basemodel.model.FunctionResult;
import hayaa.basemodel.model.GridPager.GridPager;
import hayaa.basemodel.model.GridPager.GridPagerPamater;
import hayaa.basemodel.model.TransactionResult;
import hayaa.cms.service.ITemplateService;
import hayaa.cms.service.model.Template;
import hayaa.cms.service.model.TemplateSearchPamater;
import hayaa.common.AssertHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/template/", method = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*", allowCredentials = "true")
public class TemplateController {
    @Autowired
    private ITemplateService templateService;

    @RequestMapping(value = "pager")
    public TransactionResult<GridPager<Template>> GetPager(int page, int size) throws Exception {
        AssertHelper.AssertRangInt(page, 1, Integer.MAX_VALUE);
        AssertHelper.AssertRangInt(size, 1, Integer.MAX_VALUE);
        TransactionResult<GridPager<Template>> result = new TransactionResult<GridPager<Template>>();
        GridPagerPamater<TemplateSearchPamater> pamater = new GridPagerPamater<>();
        TemplateSearchPamater sp = new TemplateSearchPamater();
        pamater.setSearchPamater(sp);
        pamater.setCurrent(page);
        pamater.setPageSize(size);
        GridPager<Template> serviceReusult = templateService.GetPager(pamater);
        if (serviceReusult.isActionResult() && serviceReusult.isHavingData()) {
            result.setData(serviceReusult);
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "get")
    public TransactionResult<Template> Get(int id) throws Exception {
        AssertHelper.AssertRangInt(id, 1, Integer.MAX_VALUE);
        TransactionResult<Template> result = new TransactionResult<Template>();
        FunctionResult<Template> serviceResult = templateService.Get(id);
        if (serviceResult.isActionResult() && serviceResult.isHavingData()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "list")
    public TransactionResult<List<Template>> GetList() throws Exception {
        TransactionResult<List<Template>> result = new TransactionResult<List<Template>>();
        FunctionListResult<Template> serviceResult = templateService.GetList(new TemplateSearchPamater());
        if (serviceResult.isActionResult() && serviceResult.isHavingData()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "add")
    public TransactionResult<Template> Add(Template info) throws Exception {
        AssertHelper.AssertRangInt(info.getTemplateId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertStringNullorEmpty(info.getName());
        AssertHelper.AssertStringNullorEmpty(info.getTitle());
        AssertHelper.AssertStringNullorEmpty(info.getContent());
        TransactionResult<Template> result = new TransactionResult<Template>();
        FunctionResult<Template> serviceResult = templateService.Create(info);
        if (serviceResult.isActionResult() && serviceResult.isHavingData()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "edit")
    public TransactionResult<Boolean> Edit(Template info) throws Exception {
        AssertHelper.AssertRangInt(info.getTemplateId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertStringNullorEmpty(info.getName());
        AssertHelper.AssertStringNullorEmpty(info.getTitle());
        AssertHelper.AssertStringNullorEmpty(info.getContent());
        TransactionResult<Boolean> result = new TransactionResult<Boolean>();
        FunctionOpenResult<Boolean> serviceResult = templateService.UpdateByID(info);
        if (serviceResult.isActionResult()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "del")
    public TransactionResult<Boolean> Delete(int id) throws Exception {
        AssertHelper.AssertRangInt(id, 1, Integer.MAX_VALUE);
        TransactionResult<Boolean> result = new TransactionResult<Boolean>();
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        FunctionOpenResult<Boolean> serviceResult = templateService.DeleteByID(ids);
        if (serviceResult.isActionResult()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }
}