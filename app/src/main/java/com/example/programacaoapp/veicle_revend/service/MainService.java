package com.example.programacaoapp.veicle_revend.service;

import javax.inject.Inject;

public class MainService {
    private RestService restService;
    private MyPrinter printer;

    @Inject
    public MainService(RestService restService,
                       MyPrinter printer) {
        this.restService = restService;
        this.printer = printer;
    }

    public void doSomething() {
        String s = restService.getSomething();
        printer.print(s.toUpperCase());
    }
}
