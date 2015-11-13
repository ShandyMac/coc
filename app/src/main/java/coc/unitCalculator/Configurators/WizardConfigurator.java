package coc.unitCalculator.configurators;

import android.app.Activity;

import coc.unitCalculator.Army;
import coc.consumables.troops.Wizard;

/**
 * Created by Andrew_Ma on 13/11/2015.
 */
public class WizardConfigurator extends BaseConfigurator implements IConfigurator {

    public WizardConfigurator(Activity activity, int levelId, int amountId) {
        super(activity, levelId, amountId);
    }

    @Override
    public Army CreateTroops(Army army) {
        for(int i = 0; i < super.GetSelectedAmount(); i++) {
            army.AddTroop(new Wizard(super.GetSelectedLevel()));
        }

        return army;
    }
}
