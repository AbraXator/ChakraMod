package net.chakramod.mod.chakra;

import net.chakramod.mod.entity.MineralSnailEntity;

public abstract class Chakras {
    public Mineral mineral;

    protected Chakras(Mineral mineral){
        this.mineral = mineral;
    }
}
