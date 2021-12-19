package domain.abilities;

import domain.services.Service;
import domain.services.ServiceAttachable;

import java.util.ArrayList;
import java.util.List;

public abstract class Ability extends ServiceAttachable {

	public Ability(){
		super(new ArrayList<Service>());
	}
	public Ability(List<Service> services){
		super(services);
	}

	abstract void perform(Object o);
}
