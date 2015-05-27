package com.paulhoang.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by paul on 25/05/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorityData
{
    private int localAuthorityId;
    private int localAuthorityIdCode;
    private String name;


    @JsonProperty("LocalAuthorityId")
    public int getLocalAuthorityId() {
        return localAuthorityId;
    }

    public void setLocalAuthorityId(int localAuthorityId) {
        this.localAuthorityId = localAuthorityId;
    }

    @JsonProperty("LocalAuthorityIdCode")
    public int getLocalAuthorityIdCode() {
        return localAuthorityIdCode;
    }

    public void setLocalAuthorityIdCode(int localAuthorityIdCode) {
        this.localAuthorityIdCode = localAuthorityIdCode;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
