package com.paulhoang.service;

import com.paulhoang.data.AuthorityListData;

import java.util.Map;

/**
 * Created by paul on 26/05/15.
 */
public interface RequestService {

    /**
     * get a list of authorities from the webservice
     * @return
     */
    AuthorityListData getAuthorities();

    /**
     * get the calculated data from establishments in a region
     * @param regionId the unique id of a region defined by ws
     * @return
     */
    Map<String, String> getEstablishmentData(int regionId);
}
