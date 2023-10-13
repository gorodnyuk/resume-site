package ru.gorodnyuk.resumesite.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gorodnyuk.resumesite.service.StatisticsManager;

@Controller
public class ResumeController {

    private final StatisticsManager statisticsManager;

    public ResumeController(StatisticsManager statisticsManager) {
        this.statisticsManager = statisticsManager;
    }

    @GetMapping("/")
    public String index() {
        statisticsManager.calculate();
        return "index.html";
    }
}
