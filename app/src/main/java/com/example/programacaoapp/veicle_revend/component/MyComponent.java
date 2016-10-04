package com.example.programacaoapp.veicle_revend.component;

import com.example.programacaoapp.veicle_revend.MainActivity;
import com.example.programacaoapp.veicle_revend.module.MyModule;
import com.example.programacaoapp.veicle_revend.service.MainService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MyModule.class)
public interface MyComponent {
    MainService mainService();

    void inject(MainActivity mainActivity);
}
