package com.envision.eeop.api.request;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.LicensedClientsGetResponse;
import com.envision.eeop.api.response.LicensedObjectsGetResponse;

/**
 * Test eeop/mdmService/getObjectAttributes
 * 
 * @author jieyuan.shen
 */
public class LicensedRequestTest
{

    Logger logger = LoggerFactory.getLogger(LicensedRequestTest.class);

    private static EnvisionClient client = new EnvisionDefaultClient(
            "http://localhost:8080/eeop", 
            "a0720bb5-916c-43e2-b8e4-b129cfaf8bb6", 
            "0E133FBBFC57CA282FC2FC34C6651218");
    
    @Test
    public void testGetLicensedClients() throws EnvisionApiException
    {
        String licenseFingerprint = "2ccc509e-9ac0-4afd-b2b3-eb7914e77072@#@D2A893DC3544D48492984AB0AAB8288D25171889";
        List<String> clientSnList = Arrays.asList("64498", "40802", "PF09RWCP1", "PF09RWCP");
        List<String> attributes = Arrays.asList("name", "city", "address");
        LicensedClientsGetRequest request = new LicensedClientsGetRequest(licenseFingerprint, clientSnList, attributes, "en-US");
        LicensedClientsGetResponse response = client.execute(request, "token-white-line");
        
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void testGetLicensedObjects() throws EnvisionApiException
    {
        String licenseFingerprint = "2ccc509e-9ac0-4afd-b2b3-eb7914e77072@#@D2A893DC3544D48492984AB0AAB8288D25171889";
        List<String> uidList = Arrays.asList("SPREE_1201", "SPREE_1202", "AA0001200010");
        LicensedObjectsGetRequest request = new LicensedObjectsGetRequest(licenseFingerprint, uidList);
        LicensedObjectsGetResponse response = client.execute(request, "token-white-line");

        System.out.println(response);
        System.out.println(response.getBody());
    }
    
    @Test
    public void testRegisterClient() throws EnvisionApiException
    {
        String licenseFingerprint = "2ccc509e-9ac0-4afd-b2b3-eb7914e77072@#@D2A893DC3544D48492984AB0AAB8288D25171889";
        String clientSN = "64498";
        String siteID = "";
        LicensedClientRegisterRequest request = new LicensedClientRegisterRequest(licenseFingerprint, clientSN, siteID);
        EnvisionResponse response = client.execute(request, "token-white-line");

        System.out.println(response);
        System.out.println(response.getBody());
        
        licenseFingerprint = "2ccc509e-9ac0-4afd-b2b3-eb7914e77072@#@D2A893DC3544D48492984AB0AAB8288D25171889";
        clientSN = "64498";
        siteID = "1831c96cc13e6000";

        request = new LicensedClientRegisterRequest(licenseFingerprint, clientSN, siteID);
        response = client.execute(request, "token-white-line");

        System.out.println(response);
        System.out.println(response.getBody());
        
        licenseFingerprint = "2ccc509e-9ac0-4afd-b2b3-eb7914e77072@#@D2A893DC3544D48492984AB0AAB8288D25171889";
        clientSN = "64498";
        
        LicensedClientUnregisterRequest urequest = new LicensedClientUnregisterRequest(licenseFingerprint, clientSN);
        response = client.execute(urequest, "token-white-line");

        System.out.println(response);
        System.out.println(response.getBody());
    }
    
    @Test
    public void testRegisterObject() throws EnvisionApiException
    {
        String licenseFingerprint = "2ccc509e-9ac0-4afd-b2b3-eb7914e77072@#@D2A893DC3544D48492984AB0AAB8288D25171889";
        String uid = "SPREE_1202";
        String mdmID = "";
        LicensedObjectRegisterRequest request = new LicensedObjectRegisterRequest(licenseFingerprint, uid, mdmID);
        EnvisionResponse response = client.execute(request, "token-white-line");

        System.out.println(response);
        System.out.println(response.getBody());

        licenseFingerprint = "2ccc509e-9ac0-4afd-b2b3-eb7914e77072@#@D2A893DC3544D48492984AB0AAB8288D25171889";
        uid = "SPREE_1202";
        mdmID = "17c7e1f8f143e000";
        request = new LicensedObjectRegisterRequest(licenseFingerprint, uid, mdmID);
        response = client.execute(request, "token-white-line");

        System.out.println(response);
        System.out.println(response.getBody());
    }
}
