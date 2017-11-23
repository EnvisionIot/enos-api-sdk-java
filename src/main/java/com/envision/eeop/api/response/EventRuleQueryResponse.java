package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionPaginationResponse;
import com.envision.eeop.api.domain.EventRule;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author jonnas.li
 */
public class EventRuleQueryResponse extends EnvisionPaginationResponse {
    private static final long serialVersionUID = 7067120480125036591L;

    @SerializedName("data")
    private List<EventRule> eventRules;

    public List<EventRule> getEventRules() {
        return eventRules;
    }

    public void setEventRules(List<EventRule> eventRules) {
        this.eventRules = eventRules;
    }

    @Override
    public EnvisionPaginationResponse merge(EnvisionPaginationResponse another) {
        if (another.isSuccess() &&
                another instanceof EventRuleQueryResponse) {
            eventRules.addAll(((EventRuleQueryResponse) another).eventRules);
        }
        return this;
    }
}
