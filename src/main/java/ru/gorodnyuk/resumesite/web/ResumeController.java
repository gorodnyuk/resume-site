package ru.gorodnyuk.resumesite.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class ResumeController {

    @GetMapping("/")
    public String getHelloPage() {
        return "hello.html";
    }

//    @GetMapping("/")
//    public String getIndexPage(@RequestHeader("User-Agent") String userAgent) {
//        if (StringUtils.containsIgnoreCase(userAgent, "Mobi")
//                || StringUtils.containsIgnoreCase(userAgent, "Android")) {
//            return "mobile-error.html";
//        }
//        return "index.html";
//    }

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
