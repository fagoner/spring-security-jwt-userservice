package com.fagoner.userservice.security.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityProperties {

    @Value("#{'${security.allowed-credentials}'.split(',')}")
    private boolean allowedCredentials;

    @Value("#{'${security.allowed-origins}'.split(',')}")
    private List<String> allowedOrigins;

    @Value("#{'${security.allowed-methods}'.split(',')}")
    private List<String> allowedMethods;

    @Value("#{'${security.allowed-headers}'.split(',')}")
    private List<String> allowedHeaders;

    @Value("#{'${security.allowed-public-apis}'.split(',')}")
    private List<String> allowedPublicApis;

    @Value("#{'${exposed-headers}'.split(',')}")
    private List<String> exposedHeaders;

    public List<String> getAllowedHeaders() {
        return allowedHeaders;
    }

    public boolean getAllowedCredentials() {
        return allowedCredentials;
    }

    public List<String> getAllowedOrigins() {
        return allowedOrigins;
    }

    public List<String> getAllowedMethods() {
        return allowedMethods;
    }

    public List<String> getAllowedPublicApis() {
        return allowedPublicApis;
    }

    public List<String> getExposedHeaders() {
        return exposedHeaders;
    }
}
