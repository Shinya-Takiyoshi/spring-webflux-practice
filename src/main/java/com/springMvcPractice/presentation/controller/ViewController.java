package com.springMvcPractice.presentation.controller;

import com.springMvcPractice.infrastracture.api.ApiProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class ViewController {
    private final ApiProxy apiProxy;
    @GetMapping("/")
    public Mono<String> index(final Model model) {
        return Mono.just("pages/index");


    }
}
