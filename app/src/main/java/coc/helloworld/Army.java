package coc.helloworld;

import java.util.ArrayList;

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

    public int GetTotalCost(){
        int totalCost = 0;

        for (IBaseConsumableUnit troop:_troops) {
            int troopCost = troop.GetCost();
            totalCost = totalCost + troopCost;
        }

        return totalCost;
    }
}
