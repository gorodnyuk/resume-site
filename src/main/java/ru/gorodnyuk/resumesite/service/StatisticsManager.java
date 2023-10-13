package ru.gorodnyuk.resumesite.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StatisticsManager {

    private final RestTemplate restTemplate;
    private final String statisticsUri;
    private final boolean isStatisticsEnabled;

    public StatisticsManager(@Value("${statistics.uri}") String statisticsUri,
                             @Value("${statistics.enabled}") Boolean isStatisticsEnabled) {
        this.restTemplate = new RestTemplate();
        this.statisticsUri = statisticsUri;
        this.isStatisticsEnabled = isStatisticsEnabled;
    }

    public void calculate() {
        if (isStatisticsEnabled) {
            restTemplate.postForLocation(statisticsUri, null);
        }
    }
}
