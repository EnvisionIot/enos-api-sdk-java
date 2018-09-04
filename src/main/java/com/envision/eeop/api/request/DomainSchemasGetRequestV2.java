package com.envision.eeop.api.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.DomainSchemasGetResponseV2;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

public class DomainSchemasGetRequestV2 implements EnvisionRequest<DomainSchemasGetResponseV2>
{
    private static final String API_METHOD = "/mdmService/getSchemasV2";

    public static final String FIELD_SCHEMA_TYPE = "schemaType";
    public static final String FIELD_DESC = "desc";
    public static final String FIELD_METADATA = "metadata";
    public static final String FIELD_VALUE_TYPE = "valueType";

    private String mdmIDList;   // mandatory
    private String fieldList;   // optional
    private String locale;      // optional

    public DomainSchemasGetRequestV2(List<String> mdmIDList, boolean includeDesc, boolean includeMetadata)
    {
        this.mdmIDList = StringUtils.listToString(mdmIDList, ',');
        List<String> fields = new ArrayList<>();
        if (includeDesc)
        {
            fields.add(FIELD_DESC);
        }
        if (includeMetadata)
        {
            fields.add(FIELD_METADATA);
        }
        if (!fields.isEmpty())
        {
            this.fieldList = StringUtils.listToString(fields, ',');
        }
    }

    public DomainSchemasGetRequestV2(List<String> mdmIDList, boolean includeDesc, boolean includeMetadata, String locale)
    {
        this(mdmIDList, includeDesc, includeMetadata);
        this.locale = locale;
    }
    
    public DomainSchemasGetRequestV2(List<String> mdmIDList)
    {
        this.mdmIDList = StringUtils.listToString(mdmIDList, ',');
    }
    
    public DomainSchemasGetRequestV2(List<String> mdmIDList, List<String> fieldList)
    {
        this.mdmIDList = StringUtils.listToString(mdmIDList, ',');
        this.fieldList = StringUtils.listToString(fieldList, ',');
    }
    public String getMdmIDList()
    {
        return mdmIDList;
    }

    public void setMdmIDList(String mdmIDList)
    {
        this.mdmIDList = mdmIDList;
    }

    public String getFieldList()
    {
        return fieldList;
    }

    public void setFieldList(String fieldList)
    {
        this.fieldList = fieldList;
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
        txtParams.put("mdmids", mdmIDList);
        if (!StringUtils.isEmpty(fieldList))
        {
            txtParams.put("fields", fieldList);
        }
        if (!StringUtils.isEmpty(locale))
        {
            txtParams.put("locale", locale);
        }
        return txtParams;
    }

    public Class<DomainSchemasGetResponseV2> getResponseClass()
    {
        return DomainSchemasGetResponseV2.class;
    }

    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmids");
    }

}
