package domain.abilities;

import domain.physicalobjects.PhysicalObject;
import domain.services.Service;
import domain.services.ServiceAttachable;

import java.util.ArrayList;
import java.util.List;

public abstract class Ability extends ServiceAttachable {

	private PhysicalObject appliesTo;

	public Ability(PhysicalObject appliesTo){
		this(appliesTo, null);
	}

	public Ability(PhysicalObject appliesTo, List<Service> services){
		super(new ArrayList<Service>());
		this.appliesTo = appliesTo;
	}

	public abstract void perform();
	public abstract void revert();

	public PhysicalObject getAppliesTo() {
		return appliesTo;
	}
}
