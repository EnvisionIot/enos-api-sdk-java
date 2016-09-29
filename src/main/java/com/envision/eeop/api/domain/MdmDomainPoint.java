/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * MdmDomainPoints
 *
 */
public class MdmDomainPoint implements Serializable{

	private static final long serialVersionUID = 3297939999819386800L;

	@SerializedName("mdmid")
	private String mdmID;
	
	@SerializedName("points")
	private List<DomainPoint> domainPointList;
	
	public MdmDomainPoint() {
	}
	
	public MdmDomainPoint(String mdmID, List<DomainPoint> domainPointList){
		this.mdmID = mdmID;
		this.domainPointList = domainPointList;
	}
	
	public String getMdmID() {
		return mdmID;
	}

	public void setMdmID(String mdmID) {
		this.mdmID = mdmID;
	}

	public List<DomainPoint> getDomainPointList() {
		return domainPointList;
	}

	public void setDomainPointList(List<DomainPoint> domainPointList) {
		this.domainPointList = domainPointList;
	}

	@Override
	public String toString() {
		return "MdmDomainPoint [mdmID=" + mdmID + ", domainPointList="
				+ domainPointList + "]";
	}
}
