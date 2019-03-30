package com.envisioniot.enos.enosapi.api.request.alarmruleservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.api.resource.alarmruleservice.AlertType;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class GetAlertTypeRequest extends EnOSRequest<EnOSResponse<AlertType>> {
    private static final String API_METHOD = "/eventService/rules/alertTypes/{typeId}";
    private static final String REQUEST_METHOD = "GET";

    
    private String orgId;
    @EnOSPathVariable(name = "typeId")
    private String typeId;

    public GetAlertTypeRequest(String orgId, String typeId) {
        this.orgId = orgId;
        this.typeId = typeId;
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