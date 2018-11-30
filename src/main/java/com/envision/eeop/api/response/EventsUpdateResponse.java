package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.event.bean.Event;
import com.envision.event.util.PagedList;

/**
 * Created by alan.wang on 2018/6/25.
 */
public class EventsUpdateResponse extends EnvisionResponse {

    private static final long serialVersionUID = -1528053815320222833L;
    private int successNum;

    public int getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(int successNum) {
        this.successNum = successNum;
    }
}
