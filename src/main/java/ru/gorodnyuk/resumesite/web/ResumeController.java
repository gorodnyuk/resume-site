package ru.gorodnyuk.resumesite.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gorodnyuk.resumesite.service.StatisticsService;

@Controller
@RequiredArgsConstructor
public class ResumeController {

    private final StatisticsService statisticsService;

    @GetMapping("/")
    public String index(HttpServletRequest httpServletRequest) {
        statisticsService.calculate(httpServletRequest.getRemoteAddr());
        return "index.html";
    }
}
