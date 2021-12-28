package domain.physicalobjects;

import domain.Constants;
import domain.physicalobjects.behaviors.collision.CollisionBehavior;
import domain.physicalobjects.behaviors.collision.MagicalHexAmmoCollisionBehavior;
import domain.physicalobjects.behaviors.movement.MagicalHexAmmoMovementBehavior;
import domain.physicalobjects.behaviors.movement.MovementBehavior;
import domain.physicalobjects.boundingbox.BoundingBox;
import domain.physicalobjects.boundingbox.PolygonBoundingBox;
import domain.services.Service;

import javax.swing.*;
import java.util.List;

public class MagicalHexAmmo extends PhysicalObject{

    private int attackDamage;

    public MagicalHexAmmo(Vector location) {
        super(location, null, 20, 20, PolygonBoundingBox.createRectangleBoundingBox(location, 20, 20), new MagicalHexAmmoMovementBehavior(), new MagicalHexAmmoCollisionBehavior(), null);
        attackDamage = Constants.MAGICAL_HEX_ATTACK_DAMAGE;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
}