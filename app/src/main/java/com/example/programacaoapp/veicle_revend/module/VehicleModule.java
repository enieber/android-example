package com.example.programacaoapp.veicle_revend.module;

import com.example.programacaoapp.veicle_revend.model.Motor;
import com.example.programacaoapp.veicle_revend.model.Vehicle;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class VehicleModule {

    @Provides @Singleton
    Motor providerMortor() {
        return new Motor();
    }

    @Provides @Singleton
    Vehicle providerVehicle() {
        return new Vehicle(new Motor());
    }
}
