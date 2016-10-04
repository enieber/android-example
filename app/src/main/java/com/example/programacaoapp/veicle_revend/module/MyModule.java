package com.example.programacaoapp.veicle_revend.module;

import com.example.programacaoapp.veicle_revend.service.MyPrinter;
import com.example.programacaoapp.veicle_revend.service.RestService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {

    @Provides @Singleton
    public RestService provideRestService() {
        return new RestService();
    }


    @Provides @Singleton
    public MyPrinter provideMyPrinter() {
        return new MyPrinter();
    }

}
