package com.paulhoang.service.impl;

import com.google.common.collect.Maps;
import com.paulhoang.configuration.ApplicationConfig;
import com.paulhoang.data.AuthorityListData;
import com.paulhoang.data.EstablishmentData;
import com.paulhoang.data.EstablishmentListData;
import com.paulhoang.service.RequestService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by paul on 26/05/15.
 */
@Component
public class DefaultRequestService implements RequestService {

    //TODO: ADD CACHING
    //Not done because of time constraints, would have used guava collections
    //public static final LoadingCache<> cache;

    public static final int MAX_FRACTION_DIGIT = 2;
    public static final NumberFormat NUMBER_FORMATTER;

    static {
        NUMBER_FORMATTER = NumberFormat.getPercentInstance();
        NUMBER_FORMATTER.setRoundingMode(RoundingMode.HALF_UP);
        NUMBER_FORMATTER.setMaximumFractionDigits(MAX_FRACTION_DIGIT);
    }

    @Autowired
    private ApplicationConfig applicationConfig;

    @Override
    public AuthorityListData getAuthorities() {
        final RestTemplate restTemplate = new RestTemplate();

        final HttpHeaders headers = new HttpHeaders();
        headers.add(applicationConfig.getHeaderApi(), applicationConfig.getApiVersion());
        final HttpEntity<?> entity = new HttpEntity<Object>("parameters", headers);

        final ResponseEntity<AuthorityListData> exchange = restTemplate.exchange(applicationConfig.getGetAuthoritiesUrl(),
                HttpMethod.GET, entity, AuthorityListData.class);

        return exchange.getBody();
    }


    @Override
    public Map<String, String> getEstablishmentData(final int regionId) {

        final EstablishmentListData establishmentListData = requestEstablishmentsForRegion(regionId);

        Map<String, Integer> ratingCount = null;

        final Map<String, String> calculatedRatings = Maps.newTreeMap();
        if(CollectionUtils.isNotEmpty(establishmentListData.getEstablishments()))
        {
            ratingCount = countRatings(establishmentListData.getEstablishments());

            if(MapUtils.isNotEmpty(ratingCount))
            {
                final int totalEstablishments = establishmentListData.getEstablishments().size();

                //calculate result
                for(final Map.Entry<String, Integer> entry : ratingCount.entrySet())
                {
                    final String key = entry.getKey();
                    double percent = (new Float(entry.getValue()) / totalEstablishments);
                    calculatedRatings.put(key, NUMBER_FORMATTER.format(percent));
                }
            }
        }

        return calculatedRatings;
    }


    protected Map<String, Integer> countRatings(final List<EstablishmentData> establishments)
    {
        final Map<String, Integer> ratingCount = Maps.newTreeMap();
        for (final EstablishmentData establishmentData : establishments)
        {
            final String key = establishmentData.getRatingValue().replaceAll(" ", "");
            if(ratingCount.containsKey(key))
            {
                int currentCount = ratingCount.get(key).intValue();
                ratingCount.put(key, ++currentCount);
            }
            else
            {
                ratingCount.put(key, 1);
            }
        }
        return ratingCount;
    }


    protected EstablishmentListData requestEstablishmentsForRegion(final int regionId) {
        final RestTemplate restTemplate = new RestTemplate();

        final HttpHeaders headers = new HttpHeaders();
        headers.add(applicationConfig.getHeaderApi(), applicationConfig.getApiVersion());
        final HttpEntity<?> entity = new HttpEntity<Object>("parameters", headers);

        final String queryUrl = applicationConfig.getGetEstablishmentsUrl() + regionId;
        final ResponseEntity<EstablishmentListData> response = restTemplate.exchange(queryUrl,
                HttpMethod.GET, entity, EstablishmentListData.class);

        return response.getBody();

    }

}
