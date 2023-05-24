package Entities;
import Itens.Potion;
import Itens.Weapon;

import java.util.ArrayList;


public class Archer extends Hero {

    private double nerf;
    public Archer(String name, int gold){
        super(name,gold);

        this.nerf = 0.1;
    }

    public double getNerf() {
        return nerf;
    }

    public void setNerf(double nerf) {
        this.nerf = nerf;
    }
}
