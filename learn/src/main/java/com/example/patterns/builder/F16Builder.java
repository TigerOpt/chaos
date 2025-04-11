package com.example.patterns.builder;

public class F16Builder extends AircraftBuilder{

    F16 f16;

    @Override
    public void buildEngine() {
        super.buildEngine();
    }

    @Override
    public void buildWings() {
        super.buildWings();
    }

    @Override
    public void buildCockpit() {
        super.buildCockpit();
    }

    @Override
    public IAircraft getResult() {
        return f16;
    }
    
}
