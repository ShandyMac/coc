package coc.unitCalculator.configurators;

import android.app.Activity;

import coc.consumables.troops.Witch;
import coc.unitCalculator.Army;

/**
 * Created by Andrew_Ma on 13/11/2015.
 */
public class WitchConfigurator extends BaseConfigurator implements IConfigurator {
    public WitchConfigurator(Activity activity, int levelId, int amountId) {
        super(activity, levelId, amountId);
    }

    @Override
    public Army CreateTroops(Army army) {
        for(int i = 0; i < super.GetSelectedAmount(); i++) {
            army.AddTroop(new Witch(super.GetSelectedLevel()));
        }

        return army;
    }
}
