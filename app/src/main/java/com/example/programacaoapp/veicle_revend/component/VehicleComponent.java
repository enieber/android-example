package com.example.programacaoapp.veicle_revend.component;


import com.example.programacaoapp.veicle_revend.model.Vehicle;
import com.example.programacaoapp.veicle_revend.module.VehicleModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {VehicleModule.class})
public interface VehicleComponent {
    Vehicle provideVehicle();
}
