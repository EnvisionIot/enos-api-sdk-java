package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.event.bean.GroupByResult;

import java.util.List;

/**
 * Created by haifeng.zhu on 2018/8/13.
 */
public class GroupByResponse  extends EnvisionResponse  {
    private static final long serialVersionUID = 4189147451036990068L;
    private List<GroupByResult> eventPagedList;

    public List<GroupByResult> getEventPagedList() {
        return eventPagedList;
    }

    public void setEventPagedList(List<GroupByResult> eventPagedList) {
        this.eventPagedList = eventPagedList;
    }
}
