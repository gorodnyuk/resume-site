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
    public String getIndexPage(HttpServletRequest httpServletRequest) {
        statisticsService.calculate(httpServletRequest.getRemoteAddr());
        return "index.html";
    }

    @GetMapping("/work")
    public String getWorkInfoPage() {
        return "work.html";
    }

    @GetMapping("/projects")
    public String getProjectsInfoPage() {
        return "projects.html";
    }

    @GetMapping("/about")
    public String getAboutInfoPage() {
        return "about.html";
    }
}
