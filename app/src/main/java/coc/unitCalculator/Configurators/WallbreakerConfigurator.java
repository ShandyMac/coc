package coc.unitCalculator.configurators;

import android.app.Activity;

import coc.unitCalculator.Army;
import coc.consumables.troops.Wallbreaker;

/**
 * Created by Andrew_Ma on 13/11/2015.
 */
public class WallbreakerConfigurator extends BaseConfigurator implements IConfigurator {
    public WallbreakerConfigurator(Activity activity, int levelId, int amountId) {
        super(activity, levelId, amountId);
    }

    @Override
    public Army CreateTroops(Army army) {
        for(int i = 0; i < super.GetSelectedAmount(); i++) {
            army.AddTroop(new Wallbreaker(super.GetSelectedLevel()));
        }

        return army;
    }
}
