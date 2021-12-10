package domain.services;

import domain.listeners.ServiceListener;

import java.util.ArrayList;
import java.util.List;

public abstract class Service {
    private static List<ServiceListener> serviceListeners;

    public Service(){
    }

    public static void addServiceListener(ServiceListener listener){
        if(serviceListeners == null)
            serviceListeners = new ArrayList<>();
        serviceListeners.add(listener);
    }

    public final void perform(Object o){
        performSpecification(o);

        for(ServiceListener listener: serviceListeners)
            listener.onServicePerformed(o);
    };

    abstract void performSpecification(Object o);
}
