package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class DomainControlRequest implements EnvisionRequest<EnvisionResponse> {
    private static final String API_METHOD = "/controlService/control";

    private String mdmid; //mandatory

    private String point; //mandatory

    private String parameter; // optional

    /**
	 * @param mdmID
	 * @param point
	 * @param parameter
	 */
	public DomainControlRequest(String mdmid, String point) {
		super();
		this.mdmid = mdmid;
		this.point = point;
	}

    /**
	 * @param mdmID
	 * @param point
	 * @param parameter
	 */
	public DomainControlRequest(String mdmid, String point, String parameter) {
		this(mdmid, point);
		this.parameter = parameter;
	}
	

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
	public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();

        txtParams.put("mdmid", mdmid);
        txtParams.put("point", point);
        
        if(!StringUtils.isEmpty(parameter)){
        	 txtParams.put("parameter", parameter);
        }

        return txtParams;
    }

    @Override
    public Class<EnvisionResponse> getResponseClass() {
        return EnvisionResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(mdmid, "mdmid");
        RuleCheckUtils.checkNotEmpty(point, "point");
    }
}
