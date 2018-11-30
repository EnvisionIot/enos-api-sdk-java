package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;

import java.io.File;

/**
 * Created by changyi.yuan on 2017/4/26.
 */
@SuppressWarnings("rawtypes")
public abstract class AbstractEnvisionStreamRequest implements EnvisionRequest {
    protected File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
