package com.mwb.web.framework.service.api;

import com.mwb.web.framework.api.service.rs.api.ServiceResponse;
import com.mwb.web.framework.service.StatusCodeManager;


public abstract class AbstractBaseService {

    protected void setStatusCode(ServiceResponse response, String code) {
        response.setResultCode(code);
        response.setResultMessage(StatusCodeManager.getMessage(code));
    }

}
