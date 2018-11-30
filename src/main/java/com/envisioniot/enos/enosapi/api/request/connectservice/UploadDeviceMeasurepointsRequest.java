package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;

import java.io.File;
import java.lang.String;

import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class UploadDeviceMeasurepointsRequest extends EnOSRequest<EnOSResponse>
{
    private static final String API_METHOD = "/connectService/products/{productKey}/devices/measurepoints";
    private static final String REQUEST_METHOD = "POST";

    private String orgId;
    @EnOSPathVariable(name = "productKey")
    private String productKey;

    private String data;

    @EnOSTransferFileField(type = TransferType.UPLOAD)
    Map<String, File> files;

    public UploadDeviceMeasurepointsRequest(String orgId, String productKey, String data, Map<String, File> files)
    {
        this.orgId = orgId;
        this.productKey = productKey;
        this.data = data;
        this.files = files;
    }

    @Override
    public String getApiMethodName()
    {
        return API_METHOD;
    }

    @Override
    public String getRequestMethod()
    {
        return REQUEST_METHOD;
    }

    @Override
    public void check() throws EnOSRuleException
    {
        // super.check();
    }
}