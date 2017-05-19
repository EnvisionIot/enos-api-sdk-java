package com.envision.eeop.api.request;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.domain.MdmObject;
import com.envision.eeop.api.domain.MdmObjectAttributes;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.MdmObjectAttributesGetResponse;
import com.envision.eeop.api.response.MdmObjectsGetResponse;
import static com.envision.energy.cim_service.share.constants.AttributeKey.*;
import static com.envision.energy.cim_service.share.constants.CIMObjectTypeId.*;
import com.envision.energy.cim_service.share.constants.LocaleString;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * This is a tool to migrate sites between environment
 * @author jieyuan.shen
 */
public class MdmDataMigrationTool
{
    
    private static final String FROM_URL = "https://eos.envisioncn.com/eeop";
    private static final String FROM_APP = "CPGJM-HAHAHA";
    private static final String TO_URL = "http://172.16.33.223:8080/eeop";
    private static final String TO_APP = "EEOP_TEST";
    
    private static final String fromObjectID = "580829c6910bfb0b1c660deb";
    private static final String toParentID = "580829e6910bfb0b1c660dec";

    private static EnvisionClient fromClient = new EnvisionDefaultClient(
			FROM_URL, FROM_APP, "dummy");

    private static EnvisionClient toClient = new EnvisionDefaultClient(
			TO_URL, TO_APP, "dummy");
    
    /**
     * Convert an getObjects result to a insert request
     * @param objectAttributes
     * @return
     */
    private static MdmObjectInsertRequest toInsertRequest(String newParentID, Map<String,String> objectAttributes, String locale)
    {
        String objectID = objectAttributes.get(OBJECT_ID);
        objectAttributes.remove(OBJECT_ID);

        String parentID = newParentID;
        objectAttributes.remove(PARENT_ID);
        
        int typeID = Integer.valueOf(objectAttributes.get(OBJECT_TYPE_ID));
        objectAttributes.remove(OBJECT_TYPE_ID);
        
        int categoryID = 0;
        if (typeID >= PROJECT)
        {
            categoryID = Integer.valueOf(objectAttributes.get(BUSINESS_TYPE));
        }
        objectAttributes.remove(BUSINESS_TYPE);
        
        objectAttributes.remove(CREATED_DATE);
        objectAttributes.remove(UPDATED_DATE);
        
        MdmObjectInsertRequest request = new MdmObjectInsertRequest(parentID, typeID, objectAttributes, objectID);
        if (categoryID != 0)
        {
            request.setCategory(categoryID);
        }
        request.setLocale(locale);
        
        return request;
    }
    
    /**
     * Convert an getObjectAttributes result to a update request
     * @param objectAttributes
     * @return
     */
    private static MdmObjectAttributesSetRequest toUpdateRequest(Map<String,String> objectAttributes, String locale, boolean asDefault)
    {
        String objectID = objectAttributes.get(OBJECT_ID);
        objectAttributes.remove(OBJECT_ID);
        objectAttributes.remove(PARENT_ID);
        objectAttributes.remove(OBJECT_TYPE_ID);
        objectAttributes.remove(BUSINESS_TYPE);
        objectAttributes.remove(CREATED_DATE);
        objectAttributes.remove(UPDATED_DATE);
        
        MdmObjectAttributesSetRequest request = 
                new MdmObjectAttributesSetRequest(objectID, objectAttributes, locale, asDefault);
        
        return request;
    }
	
    public static void main(String[] args) throws EnvisionApiException
    {
        List<String> movedObjectIDs = Lists.newArrayList();

        // read an object tree from 
        MdmObjectsGetRequest readRequest = null;
        // read site and project first/ zh-CN
        readRequest = new MdmObjectsGetRequest(ImmutableList.of(fromObjectID), 
                LocaleString.CHINA);
        readRequest.setTypeList(String.valueOf(PROJECT));

        MdmObjectsGetResponse readResponse = fromClient.execute(readRequest, "token-white-line");
        
        Map<String,String> site = 
                readResponse.getMdmChildObjects().get(fromObjectID).getAttributes();
        
        MdmObjectInsertRequest insertRequest = toInsertRequest(toParentID, site, LocaleString.CHINA);
        Preconditions.checkArgument(
                toClient.execute(insertRequest, "token-white-line").getStatus() == 0);
        movedObjectIDs.add(insertRequest.getMdmID());
        
        List<MdmObject> projects = readResponse.getMdmChildObjects()
                .get(fromObjectID).getMdmObjectList().get(String.valueOf(PROJECT));
        
        for (MdmObject project: projects)
        {
            insertRequest = toInsertRequest(project.getAttributes().get(PARENT_ID), 
                    project.getAttributes(), LocaleString.CHINA);
            Preconditions.checkArgument(
                    toClient.execute(insertRequest, "token-white-line").getStatus() == 0);
            movedObjectIDs.add(insertRequest.getMdmID());
        }
        
        // read site and devices then / zh-CN
        readRequest = new MdmObjectsGetRequest(ImmutableList.of(fromObjectID), 
                LocaleString.CHINA);
        readResponse = fromClient.execute(readRequest, "token-white-line");

        Collection<List<MdmObject>> deviceList = readResponse.getMdmChildObjects()
                .get(fromObjectID).getMdmObjectList().values();
        
        List<MdmObject> devices = Lists.newArrayList();
        for (List<MdmObject> deviceSublist: deviceList)
        {
            devices.addAll(deviceSublist);
        }
        for (MdmObject device: devices)
        {
            insertRequest = toInsertRequest(device.getAttributes().get(PARENT_ID), 
                    device.getAttributes(), LocaleString.CHINA);
            Preconditions.checkArgument(
                    toClient.execute(insertRequest, "token-white-line").getStatus() == 0);
            movedObjectIDs.add(insertRequest.getMdmID());
        }
        
        // read en-US attributes
        MdmObjectAttributesGetRequest attrReadRequest = 
                new MdmObjectAttributesGetRequest(movedObjectIDs, LocaleString.US);
        
        MdmObjectAttributesGetResponse attrReadResponse =
                fromClient.execute(attrReadRequest, "token-white-line");
        MdmObjectAttributesSetRequest updateRequest;
        for (MdmObjectAttributes attributes: attrReadResponse.getMdmObjects().values())
        {
            updateRequest = toUpdateRequest(attributes.getAttributes(), LocaleString.US, false);
            Preconditions.checkArgument(
                    toClient.execute(updateRequest, "token-white-line").getStatus() == 0);
        }
    }
}
