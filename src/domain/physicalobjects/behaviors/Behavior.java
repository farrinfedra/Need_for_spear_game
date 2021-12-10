package domain.physicalobjects.behaviors;

import domain.services.Service;

import java.util.List;

public abstract class Behavior {

    private List<Service> services;

    public Behavior(List<Service> services){
        this.services = services;
    }

    protected Service getService(int i){
        return services.get(i);
    }
}
