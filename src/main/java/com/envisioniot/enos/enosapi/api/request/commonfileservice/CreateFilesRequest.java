package com.envisioniot.enos.enosapi.api.request.commonfileservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.lang.String;
import java.io.File;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class CreateFilesRequest extends EnOSRequest<EnOSResponse> {
    private static final String API_METHOD = "/commonFileService/files";
    private static final String REQUEST_METHOD = "POST";
    
    private String orgId;
    
    private String path;
    @EnOSTransferFileField(name = "files", type = TransferType.UPLOAD)
    private File[] files;

    public CreateFilesRequest(String orgId, String path, File[] files) {
        this.orgId = orgId;
        this.path = path;
        this.files = files;
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