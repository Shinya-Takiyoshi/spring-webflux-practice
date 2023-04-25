package com.springMvcPractice.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class ViewController {
    @GetMapping("/")
    public Mono<String> index(final Model model) {
        return Mono.just("pages/index");


    }
}
