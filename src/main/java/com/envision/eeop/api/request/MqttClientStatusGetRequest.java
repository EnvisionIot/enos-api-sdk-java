package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.MqttClientStatusGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

/**
 * This request is to get MQTT client status
 * @author shenjieyuan
 */
public class MqttClientStatusGetRequest implements EnvisionRequest<MqttClientStatusGetResponse>
{
    private static final String API_METHOD = "/connectService/getMqttClientStatus";

    private String licenseId;   // mandatory
    private String thingName;   // mandatory
    private String clientId;    // mandatory

    public MqttClientStatusGetRequest(String licenseId, String thingName, String clientId)
    {
        this.licenseId = licenseId;
        this.thingName = thingName;
        this.clientId = clientId;
    }

    public String getLicenseId()
    {
        return licenseId;
    }

    public void setLicenseId(String licenseId)
    {
        this.licenseId = licenseId;
    }

    public String getThingName()
    {
        return thingName;
    }

    public void setThingName(String thingName)
    {
        this.thingName = thingName;
    }

    public String getClientId()
    {
        return clientId;
    }

    public void setClientId(String clientId)
    {
        this.clientId = clientId;
    }

    public String getApiMethodName()
    {
        return API_METHOD;
    }

    public Map<String, String> getTextParams()
    {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("licenseId", licenseId);
        txtParams.put("thingName", thingName);
        txtParams.put("clientId", clientId);
        return txtParams;
    }

    public Class<MqttClientStatusGetResponse> getResponseClass()
    {
        return MqttClientStatusGetResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkNotEmpty(licenseId, "licenseId");
        RuleCheckUtils.checkNotEmpty(thingName, "thingName");
        RuleCheckUtils.checkNotEmpty(clientId, "clientId");
    }
}
