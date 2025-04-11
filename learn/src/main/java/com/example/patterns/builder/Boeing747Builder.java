package com.example.patterns.builder;

public class Boeing747Builder extends AircraftBuilder {

    Boeing747 boeing747;

    @Override
    public void buildEngine() {
        super.buildEngine();
    }

    @Override
    public void buildWings() {
        super.buildWings();
    }

    @Override
    public void buildBathrooms() {
        super.buildBathrooms();
    }

    @Override
    public void buildCockpit() {
        super.buildCockpit();
    }

    @Override
    public IAircraft getResult() {
        return boeing747;
    }
}
