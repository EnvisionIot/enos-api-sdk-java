package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.PushSingleResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/1/3.
 */
public class PushSingleRequest implements EnvisionRequest<PushSingleResponse> {
    private static final String API_METHOD = "/pushService/push";
    private String tag;
    private String content;
    private String title;

    public PushSingleRequest(String tag, String content) {
        super();
        this.tag = tag;
        this.content = content;
    }

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("tag", this.tag);
        txtParams.put("content", this.content);
        if ( ! StringUtils.isEmpty(this.content)){
            txtParams.put("title",this.getTitle());
        }
        return txtParams;
    }

    @Override
    public Class<PushSingleResponse> getResponseClass() {
        return PushSingleResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(tag,"tag");
        RuleCheckUtils.checkNotEmpty(content,"content");
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
