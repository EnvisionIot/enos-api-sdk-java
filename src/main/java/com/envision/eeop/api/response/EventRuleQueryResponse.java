package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.EventRule;

import java.util.List;

/**
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author jonnas.li
 */
public class EventRuleQueryResponse extends EnvisionResponse {
    private static final long serialVersionUID = 7067120480125036591L;

    private List<EventRule> eventRules;
    private Integer total;

    public List<EventRule> getEventRules() {
        return eventRules;
    }

    public void setEventRules(List<EventRule> eventRules) {
        this.eventRules = eventRules;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
