package com.paulhoang.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by paul on 26/05/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EstablishmentData {

    private String ratingKey;
    private String ratingValue;

    @JsonProperty("RatingKey")
    public String getRatingKey() {
        return ratingKey;
    }

    public void setRatingKey(final String ratingKey) {
        this.ratingKey = ratingKey;
    }

    @JsonProperty("RatingValue")
    public String getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(final String ratingValue) {
        this.ratingValue = ratingValue;
    }
}
