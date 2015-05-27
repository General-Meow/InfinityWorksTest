package com.paulhoang.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by paul on 25/05/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorityListData {
    private List<AuthorityData> authorities;

    public List<AuthorityData> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<AuthorityData> authorities) {
        this.authorities = authorities;
    }
}
