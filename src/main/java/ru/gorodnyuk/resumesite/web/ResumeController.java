package ru.gorodnyuk.resumesite.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import ru.gorodnyuk.resumesite.service.StatisticsService;

@Controller
@RequiredArgsConstructor
public class ResumeController {

    private final StatisticsService statisticsService;

    @GetMapping("/")
    public String getIndexPage(@RequestHeader("User-Agent") String userAgent, HttpServletRequest httpServletRequest) {
        if (StringUtils.containsIgnoreCase(userAgent, "Mobi")
                || StringUtils.containsIgnoreCase(userAgent, "Android")) {
            return "mobile-error.html";
        }
        statisticsService.calculate(httpServletRequest.getRemoteAddr());
        return "index.html";
    }

    @GetMapping("/work")
    public String getWorkInfoPage(@RequestHeader("User-Agent") String userAgent) {
        if (StringUtils.containsIgnoreCase(userAgent, "Mobi")
                || StringUtils.containsIgnoreCase(userAgent, "Android")) {
            return "mobile-error.html";
        }
        return "work.html";
    }

    @GetMapping("/projects")
    public String getProjectsInfoPage(@RequestHeader("User-Agent") String userAgent) {
        if (StringUtils.containsIgnoreCase(userAgent, "Mobi")
                || StringUtils.containsIgnoreCase(userAgent, "Android")) {
            return "mobile-error.html";
        }
        return "projects.html";
    }

    @GetMapping("/about")
    public String getAboutInfoPage(@RequestHeader("User-Agent") String userAgent) {
        if (StringUtils.containsIgnoreCase(userAgent, "Mobi")
                || StringUtils.containsIgnoreCase(userAgent, "Android")) {
            return "mobile-error.html";
        }
        return "about.html";
    }
}
