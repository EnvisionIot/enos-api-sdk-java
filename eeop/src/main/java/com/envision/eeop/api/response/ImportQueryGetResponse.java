package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class ImportQueryGetResponse extends EnvisionResponse {
    private static final long serialVersionUID = -3404113306837189188L;

    private String process;

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }
}
