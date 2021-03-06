package coc.unitCalculator.configurators;

import android.app.Activity;

import coc.unitCalculator.Army;
import coc.consumables.troops.Goblin;

/**
 * Created by Andrew_Ma on 12/11/2015.
 */
public class GoblinConfigurator extends BaseConfigurator implements IConfigurator {
    public GoblinConfigurator(Activity activity, int levelId, int amountId) {
        super(activity, levelId, amountId);
    }

    @Override
    public Army CreateTroops(Army army) {
        for(int i = 0; i < super.GetSelectedAmount(); i++) {
            army.AddTroop(new Goblin(super.GetSelectedLevel()));
        }

        return army;
    }
}
