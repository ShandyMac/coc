package coc.unitCalculator.configurators;

import android.app.Activity;
import android.graphics.drawable.Icon;

import coc.consumables.troops.LavaHound;
import coc.unitCalculator.Army;

/**
 * Created by Andrew_Ma on 13/11/2015.
 */
public class LavaHoundConfigurator extends BaseConfigurator implements IConfigurator {
    public LavaHoundConfigurator(Activity activity, int levelId, int amountId) {
        super(activity, levelId, amountId);
    }

    @Override
    public Army CreateTroops(Army army) {
        for(int i = 0; i < super.GetSelectedAmount(); i++) {
            army.AddTroop(new LavaHound(super.GetSelectedLevel()));
        }

        return army;
    }
}
