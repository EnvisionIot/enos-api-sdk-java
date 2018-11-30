/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionSkipAndLimitRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.MdmObjectStructureGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.JsonParser;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

/**
 * This class defines request to get filtered objects
 * 
 * @author jieyuan.shen
 */
public class MdmFilteredObjectsGetRequest 
extends EnvisionSkipAndLimitRequest<MdmObjectStructureGetResponse>
{
    private static final String API_METHOD = "/mdmService/getFilteredObjects";

    private String token;                   // mandatory
    private String type;                    // mandatory
    private String filterList;              // optional
    private String appointedFilterList;     // optional
    private String attributeList;           // optional
    private boolean queryOrgUnit = false;   // optional
    private String locale;                  // optional

    public MdmFilteredObjectsGetRequest(String token, String type)
    {
        super();
        this.token = token;
        this.type = type;
        this.filterList = JsonParser.toJson(new ArrayList<>());
        this.appointedFilterList = JsonParser.toJson(new ArrayList<>());
        this.attributeList = "";
    }

    public MdmFilteredObjectsGetRequest(String token, String type, boolean queryOrgUnit)
    {
        this(token, type);
        this.queryOrgUnit = queryOrgUnit;
    }

    public MdmFilteredObjectsGetRequest(String token, String type, String locale)
    {
        this(token, type);
        this.locale = locale;
    }
    
    public MdmFilteredObjectsGetRequest(String token, String type, boolean queryOrgUnit, String locale)
    {
        this(token, type, locale);
        this.queryOrgUnit = queryOrgUnit;
    }

    public MdmFilteredObjectsGetRequest(String token, String type, List<Filter> filterList, 
            List<AppointedFilter> appointedFilterList, List<String> attributeList)
    {
        super();
        this.token = token;
        this.type = type;
        this.filterList = JsonParser.toJson(filterList);
        this.appointedFilterList = JsonParser.toJson(appointedFilterList);
        this.attributeList = StringUtils.listToString(attributeList, ',');
    }

    public MdmFilteredObjectsGetRequest(String token, String type, List<Filter> filterList, 
            List<AppointedFilter> appointedFilterList, List<String> attributeList, boolean queryOrgUnit)
    {
        this(token, type, filterList, appointedFilterList, attributeList);
        this.queryOrgUnit = queryOrgUnit;
    }

    public MdmFilteredObjectsGetRequest(String token, String type, List<Filter> filterList, 
            List<AppointedFilter> appointedFilterList, List<String> attributeList, String locale)
    {
        this(token, type, filterList, appointedFilterList, attributeList);
        this.locale = locale;
    }

    public MdmFilteredObjectsGetRequest(String token, String type, List<Filter> filterList, 
            List<AppointedFilter> appointedFilterList, List<String> attributeList, 
            boolean queryOrgUnit, String locale)
    {
        this(token, type, filterList, appointedFilterList, attributeList, locale);
        this.queryOrgUnit = queryOrgUnit;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getFilterList()
    {
        return filterList;
    }

    public void setFilterList(String filterList)
    {
        this.filterList = filterList;
    }

    public String getAppointedFilterList()
    {
        return appointedFilterList;
    }

    public void setAppointedFilterList(String appointedFilterList)
    {
        this.appointedFilterList = appointedFilterList;
    }

    public String getAttributeList()
    {
        return attributeList;
    }

    public void setAttributeList(String attributeList)
    {
        this.attributeList = attributeList;
    }

    public boolean isQueryOrgUnit()
    {
        return queryOrgUnit;
    }

    public void setQueryOrgUnit(boolean queryOrgUnit)
    {
        this.queryOrgUnit = queryOrgUnit;
    }

    public String getLocale()
    {
        return locale;
    }

    public void setLocale(String locale)
    {
        this.locale = locale;
    }

    public String getApiMethodName()
    {
        return API_METHOD;
    }

    public Map<String, String> getTextParams()
    {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("token", token);
        txtParams.put("type", type);
        txtParams.put("filter", filterList);
        txtParams.put("appointedFilter", appointedFilterList);
        txtParams.put("attributes", attributeList);
        if (queryOrgUnit)
        {
            txtParams.put("queryOrgUnit", String.valueOf(true));
        }
        if (!StringUtils.isEmpty(locale))
        {
            txtParams.put("locale", locale);
        }
        txtParams.putAll(getPaginationParams());

        return txtParams;
    }

    public Class<MdmObjectStructureGetResponse> getResponseClass()
    {
        return MdmObjectStructureGetResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        super.check();
        RuleCheckUtils.checkNotEmpty(token, "token");
        RuleCheckUtils.checkNotEmpty(type, "type");
        RuleCheckUtils.checkFilterFormat(filterList, "filter");
    }
}