package ru.gorodnyuk.resumesite.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.gorodnyuk.resumesite.model.StatisticsEntity;
import ru.gorodnyuk.resumesite.repository.StatisticsRepository;

@Service
@RequiredArgsConstructor
@Deprecated(forRemoval = true)
public class StatisticsService {

    public static final String UNKNOWN_IP = "unknown";

    private final StatisticsRepository statisticsRepository;

    @Transactional
    public void calculate(String ip) {
        if (StringUtils.hasText(ip)) {
            if (statisticsRepository.existsByIp(ip)) {
                statisticsRepository.updateStatisticByIp(ip);
            } else {
                statisticsRepository.save(new StatisticsEntity(ip));
            }
        } else {
            statisticsRepository.updateStatisticByIp(UNKNOWN_IP);
        }
    }
}
