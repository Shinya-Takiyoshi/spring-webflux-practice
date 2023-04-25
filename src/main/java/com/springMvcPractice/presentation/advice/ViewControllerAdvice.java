package com.springMvcPractice.presentation.advice;

import com.springMvcPractice.infrastracture.api.ApiProxy;
import com.springMvcPractice.presentation.controller.ViewController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@ControllerAdvice(assignableTypes = {ViewController.class})
public class ViewControllerAdvice {
    private final ApiProxy apiProxy;
    @ModelAttribute("monoJust")
    public Mono<String> monoJustReceive(){
        Mono<String> mono = apiProxy.getApiMonoJust();
        System.out.println("mono:"+mono.block());
        return mono;
    }

    @ModelAttribute("monoZip")
    public Mono<String> monoZipReceive(){
        Mono<String> mono = apiProxy.getApiMonoZip();
        System.out.println("mono:"+mono.block());
        return mono;
    }

    @ModelAttribute("FluxJust")
    public Mono<String> fluxJustReceive(){
        Mono<String> mono = apiProxy.getApiFluxJust();
        System.out.println("mono:"+mono.block());
        return mono;
    }

    @ModelAttribute("FluxZip")
    public Mono<String> fluxZipReceive(){
        Mono<String> mono = apiProxy.getApiFluxZip();
        System.out.println("mono:"+mono.block());
        return mono;
    }

    //呼び出すとレスポンス遅いのでお試しの時だけ
    /*@ModelAttribute("FluxInterval")
    public Mono<String> fluxIntervalReceive(){
        Mono<String> mono = apiProxy.getApiFluxInterval();
        System.out.println("mono:"+mono.block());
        return mono;
    }*/
}
