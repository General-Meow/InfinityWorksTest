package com.paulhoang.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Data object to retrieve application properties
 * Created by paul on 26/05/15.
 */
@Component
public class ApplicationConfig {

    @Value("${get.authorities.url}")
    private String getAuthoritiesUrl;

    @Value("${header.api}")
    private String headerApi;

    @Value("${header.api.version}")
    private String apiVersion;

    @Value("${get.establishments.url}")
    private String getEstablishmentsUrl;


    public String getGetAuthoritiesUrl() {
        return getAuthoritiesUrl;
    }

    public void setGetAuthoritiesUrl(final String getAuthoritiesUrl) {
        this.getAuthoritiesUrl = getAuthoritiesUrl;
    }

    public String getHeaderApi() {
        return headerApi;
    }

    public void setHeaderApi(final String headerApi) {
        this.headerApi = headerApi;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getGetEstablishmentsUrl() {
        return getEstablishmentsUrl;
    }

    public void setGetEstablishmentsUrl(final String getEstablishmentsUrl) {
        this.getEstablishmentsUrl = getEstablishmentsUrl;
    }
}
