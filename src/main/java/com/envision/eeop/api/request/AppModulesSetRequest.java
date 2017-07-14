package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.AppModulesSetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.JsonParser;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/7/13.
 */
public class AppModulesSetRequest implements EnvisionRequest<AppModulesSetResponse> {
    private static final String API_METHOD = "/appService/setModules";
    private String appId;
    private List<Modules> modules = new ArrayList<>();


    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("appId", this.getAppId());
        txtParams.put("modules", JsonParser.toJson(this.getModules()));
        return txtParams;
    }

    @Override
    public Class<AppModulesSetResponse> getResponseClass() {
        return AppModulesSetResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(this.appId, "appId");
        RuleCheckUtils.checkNotEmpty(this.modules, "modules");
        for (Modules m : modules){
            RuleCheckUtils.checkNotEmpty(m.id, "modules.id");
            RuleCheckUtils.checkNotEmpty(m.name, "modules.name");

            if (m.GROUPTYPE_LIST.contains(m.getGroupType())){
                throw new EnvisionRuleException(RuleCheckUtils.ERROR_CODE_ARGUMENTS_INVALID,
                        "client-error:Invalid Arguments:the value of groupType should be one of " + JsonParser.toJson(m.GROUPTYPE_LIST));
            }
        }
    }

    public class Modules implements Serializable{
        private static final long serialVersionUID = 7329122062669394838L;

        public static final int GROUPTYPE_GENERAL = 0;
        public static final int GROUPTYPE_SINGLE = 1;
        public static final int GROUPTYPE_MULTI = 2;

        transient public final List<Integer> GROUPTYPE_LIST = new ArrayList<>();

        public Modules() {
            GROUPTYPE_LIST.add(GROUPTYPE_GENERAL);
            GROUPTYPE_LIST.add(GROUPTYPE_SINGLE);
            GROUPTYPE_LIST.add(GROUPTYPE_MULTI);
        }

        private String id;
        private String name;
        private String nameEn;
        private String nameZh;
        private String url;
        private int groupType = GROUPTYPE_GENERAL;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNameEn() {
            return nameEn;
        }

        public void setNameEn(String nameEn) {
            this.nameEn = nameEn;
        }

        public String getNameZh() {
            return nameZh;
        }

        public void setNameZh(String nameZh) {
            this.nameZh = nameZh;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getGroupType() {
            return groupType;
        }

        public void setGroupType(int groupType) {
            this.groupType = groupType;
        }
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public List<Modules> getModules() {
        return modules;
    }

    public void setModules(List<Modules> modules) {
        this.modules = modules;
    }
}
