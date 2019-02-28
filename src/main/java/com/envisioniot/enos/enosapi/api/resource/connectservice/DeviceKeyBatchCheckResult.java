package com.envisioniot.enos.enosapi.api.resource.connectservice;

import java.io.Serializable;
import java.util.Set;

public class DeviceKeyBatchCheckResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private Set<String> successSet;
    private Set<String> existedSet;
    private Set<String> invalidSet;
    private Set<String> invalidCharSet;

    public DeviceKeyBatchCheckResult() {
    }

    public Set<String> getSuccessSet() {
        return this.successSet;
    }

    public void setSuccessSet(Set<String> successSet) {
        this.successSet = successSet;
    }

    public Set<String> getExistedSet() {
        return this.existedSet;
    }

    public void setExistedSet(Set<String> existedSet) {
        this.existedSet = existedSet;
    }

    public Set<String> getInvalidSet() {
        return this.invalidSet;
    }

    public void setInvalidSet(Set<String> invalidSet) {
        this.invalidSet = invalidSet;
    }

    public Set<String> getInvalidCharSet()
    {
        return invalidCharSet;
    }

    public void setInvalidCharSet(Set<String> invalidCharSet)
    {
        this.invalidCharSet = invalidCharSet;
    }

}
