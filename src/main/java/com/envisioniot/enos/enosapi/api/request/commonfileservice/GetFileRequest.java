package com.envisioniot.enos.enosapi.api.request.commonfileservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.lang.String;
import java.io.File;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class GetFileRequest extends EnOSRequest<EnOSResponse> {
    private static final String API_METHOD = "/commonFileService/files";
    private static final String REQUEST_METHOD = "GET";
    @EnOSTransferFileField(type = TransferType.DOWNLOAD)
    private File downloadFile;
    
    private String orgId;
    
    private String path;

    public GetFileRequest(File downloadFile, String orgId, String path) {
        this.downloadFile = downloadFile;
        this.orgId = orgId;
        this.path = path;
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