package com.envisioniot.enos.enosapi.api.request.alarmruleservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.api.resource.alarmruleservice.AlertContent;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class GetAlertContentRequest extends EnOSRequest<EnOSResponse<AlertContent>> {
    private static final String API_METHOD = "/eventService/rules/alertContents/{contentId}";
    private static final String REQUEST_METHOD = "GET";

    
    private String orgId;
    @EnOSPathVariable(name = "contentId")
    private String contentId;

    public GetAlertContentRequest(String orgId, String contentId) {
        this.orgId = orgId;
        this.contentId = contentId;
    }

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public String getRequestMethod() {
        return REQUEST_METHOD;
    }

    @Override
    public void check() throws EnOSRuleException {
        // super.check();
    }
}