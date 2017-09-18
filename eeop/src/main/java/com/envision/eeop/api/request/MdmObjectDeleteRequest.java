/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.request;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

/**
 * Delete MDM object
 * @author jieyuan.shen
 */
public class MdmObjectDeleteRequest implements EnvisionRequest<EnvisionResponse>
{
    private static final String API_METHOD = "/mdmService/deleteObject";

    private String mdmIDList;           // mandatory
    private String deleteSecret;		// hidden

    public MdmObjectDeleteRequest(List<String> mdmIDs)
    {
        this.mdmIDList = StringUtils.listToString(mdmIDs, ',');
    }

    public List<String> getMdmIDList()
    {
        return Arrays.asList(StringUtils.split(mdmIDList, ","));
    }

    public void setMdmIDList(List<String> mdmIDList)
    {
        this.mdmIDList = StringUtils.listToString(mdmIDList, ',');
    }
    
    public void setDeleteSecret(String deleteSecret)
    {
    	this.deleteSecret = deleteSecret;
    }

    public String getApiMethodName()
    {
        return API_METHOD;
    }

    public Map<String, String> getTextParams()
    {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("mdmids", mdmIDList);
        txtParams.put("deleteSecret", deleteSecret);

        return txtParams;
    }

    public Class<EnvisionResponse> getResponseClass()
    {
        return EnvisionResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmids");
    }
}
