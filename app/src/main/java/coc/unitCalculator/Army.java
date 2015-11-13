package coc.unitCalculator;

import java.util.ArrayList;

import coc.consumables.ElixerType;
import coc.consumables.IBaseConsumableUnit;

/**
 * Created by Andrew_Ma on 12/11/2015.
 */
public class Army {
    private static ArrayList<IBaseConsumableUnit> _troops;

    public Army()
    {
        _troops = new ArrayList<>();
    }

    public void AddTroop(IBaseConsumableUnit troop)
    {
        _troops.add(troop);
    }

    public static void Clear(){
        _troops = new ArrayList<>();
    }

    public ArmyCost GetTotalCost(){
        int totalCost = 0;
        int totalDark = 0;

        for (IBaseConsumableUnit troop:_troops) {
            int troopCost = troop.GetCost();

            if(troop.GetType() == ElixerType.Dark)
                totalDark = totalDark + troopCost;
            else
                totalCost = totalCost + troopCost;
        }

        return new ArmyCost(totalCost, totalDark);
    }
}
