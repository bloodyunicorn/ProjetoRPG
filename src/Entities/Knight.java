package Entities;

import Itens.Potion;
import Itens.Weapon;

import java.util.ArrayList;

public class Knight extends Hero{
    private double boost;
    public Knight(String name, int gold){
        super(name, gold);
        this.boost = 0.2;
    }

    public double getBoost() {
        return boost;
    }

    public void setBoost(double boost) {
        this.boost = boost;
    }
}
