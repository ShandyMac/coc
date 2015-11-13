package coc.consumables;

import java.util.Collection;

/**
 * Created by Andrew_Ma on 12/11/2015.
 */
public abstract class BaseConsumableUnit implements IBaseConsumableUnit {

    public abstract int GetLevel();
    public abstract int GetTroopCost();
    public abstract int GetHousingSpace();
    public abstract ElixerType GetElixerType();
    public abstract Collection<LevelCost> GetLevelCosts();

    public int GetCost()
    {
        for (LevelCost cost:GetLevelCosts())
        {
            if(cost.Level == GetLevel())
            {
                return cost.Cost;
            }
        }

        return 0;
    }

    public ElixerType GetType(){ return GetElixerType(); }
}
