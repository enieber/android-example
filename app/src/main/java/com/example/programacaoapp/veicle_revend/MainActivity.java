package com.example.programacaoapp.veicle_revend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.programacaoapp.veicle_revend.component.DaggerVehicleComponent;
import com.example.programacaoapp.veicle_revend.component.VehicleComponent;
import com.example.programacaoapp.veicle_revend.model.Vehicle;
import com.example.programacaoapp.veicle_revend.module.VehicleModule;

public class MainActivity extends AppCompatActivity {

    Vehicle vehicle;

    TextView speedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speedValue = (TextView) findViewById(R.id.current_speed_value);

        VehicleComponent component = DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();
        vehicle = component.provideVehicle();

        speedValue.setText(String.valueOf(vehicle.getSpeed()));
    }

    public void callBrake(View v){
        vehicle.stop();
        speedValue.setText(String.valueOf(vehicle.getSpeed()));
    }

    public void callIncrease(View v){
        vehicle.increaseSpeed(10);
        speedValue.setText(String.valueOf(vehicle.getSpeed()));
    }
}
