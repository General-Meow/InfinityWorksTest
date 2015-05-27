package com.paulhoang.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by paul on 26/05/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EstablishmentListData {

    private List<EstablishmentData> establishments;

    public List<EstablishmentData> getEstablishments() {
        return establishments;
    }

    public void setEstablishments(final List<EstablishmentData> establishments) {
        this.establishments = establishments;
    }
}
