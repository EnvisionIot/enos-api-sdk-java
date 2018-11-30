package com.envision.eeop.api;

import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.exception.EnvisionIOException;
import com.envision.eeop.api.request.AbstractEnvisionStreamRequest;
import com.envision.eeop.api.request.FileDownloadRequest;
import com.envision.eeop.api.request.FileUploadRequest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * EEOP client with streaming
 * <p/>
 * Created by changyi.yuan on 2016/10/18.
 */
@SuppressWarnings("unused")
public interface EnvisionStreamClient {
    /**
     * streaming download
     *
     * @param request
     * @param token
     * @return
     * @throws EnvisionApiException
     */
    public boolean download(AbstractEnvisionStreamRequest request, String token) throws EnvisionApiException, IOException;

    /**
     * streaming upload
     *
     * @param request
     * @param token
     * @return
     * @throws EnvisionApiException
     * @throws IOException
     */
    public boolean upload(AbstractEnvisionStreamRequest request, String token) throws EnvisionApiException, IOException;
}
