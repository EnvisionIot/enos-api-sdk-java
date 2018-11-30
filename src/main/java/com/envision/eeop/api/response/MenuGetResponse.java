package com.envision.eeop.api.response;

import java.util.List;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.AppMenu;

public class MenuGetResponse extends EnvisionResponse{
    private static final long serialVersionUID = -1994732865561923392L;
    
    private List<AppMenu> menuInfos;
    
    public List<AppMenu> getMenuInfos(){
        return menuInfos;
    }
    
    public void setMenuInfos(List<AppMenu> menuInfos){
        this.menuInfos = menuInfos;
    }
}
