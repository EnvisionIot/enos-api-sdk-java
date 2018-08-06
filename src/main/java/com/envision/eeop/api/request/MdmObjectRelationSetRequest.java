package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

/**
 * This class implements a request to set mdm object relationship
 * @author shenjieyuan
 */
public class MdmObjectRelationSetRequest implements EnvisionRequest<EnvisionResponse>
{
    private static final String API_METHOD = "/mdmService/setObjectRelation";
    
    public static final String RELATION_TYPE_PARENT = "parent";

    private String mdmID;                   // mandatory
    private String relationType;            // mandatory, only "parent" is supported now
    private String relatedMdmID;            // mandatory

    /**
     * Request to set a relation
     * @param parentID
     * @param type
     */
    public MdmObjectRelationSetRequest(String mdmID, String relationType, String relatedMdmID)
    {
        this.mdmID = mdmID;
        this.relationType = relationType;
        this.relatedMdmID = relatedMdmID;
    }

    public String getMdmID()
    {
        return mdmID;
    }

    public void setMdmID(String mdmID)
    {
        this.mdmID = mdmID;
    }

    public String getRelationType()
    {
        return relationType;
    }

    public void setRelationType(String relationType)
    {
        this.relationType = relationType;
    }

    public String getRelatedMdmID()
    {
        return relatedMdmID;
    }

    public void setRelatedMdmID(String relatedMdmID)
    {
        this.relatedMdmID = relatedMdmID;
    }

    @Override
    public String getApiMethodName()
    {
        return API_METHOD;
    }

    public Map<String, String> getTextParams()
    {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("mdmid", mdmID);
        txtParams.put("relationType", relationType);
        txtParams.put("relatedMdmid", relatedMdmID);
        return txtParams;
    }

    public Class<EnvisionResponse> getResponseClass()
    {
        return EnvisionResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkNotEmpty(mdmID, "mdmid");
        RuleCheckUtils.checkNotEmpty(relationType, "relationType");
        RuleCheckUtils.checkNotEmpty(relatedMdmID, "relatedMdmid");
    }
}