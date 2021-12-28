package domain.services;

import domain.listeners.ServiceListener;

import java.util.ArrayList;
import java.util.List;

public abstract class Service {
    private static List<ServiceListener> serviceListeners;
    private final ServiceType type;

    public Service(ServiceType type){
        this.type = type;
        serviceListeners = new ArrayList<>();
    }

    public static void addServiceListener(ServiceListener listener){
        serviceListeners.add(listener);
    }

    public final Object perform(Object o){
        Object temp = performSpecification(o);


        for(ServiceListener listener: serviceListeners)
            listener.onServicePerformed(type, o, temp);

        return temp;
    }

    abstract Object performSpecification(Object o);
}
