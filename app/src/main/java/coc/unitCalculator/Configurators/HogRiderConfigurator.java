package coc.unitCalculator.configurators;

import android.app.Activity;
import android.telephony.IccOpenLogicalChannelResponse;

import coc.consumables.troops.HogRider;
import coc.unitCalculator.Army;

/**
 * Created by Andrew_Ma on 13/11/2015.
 */
public class HogRiderConfigurator extends BaseConfigurator implements IConfigurator {

    public HogRiderConfigurator(Activity activity, int levelId, int amountId) {
        super(activity, levelId, amountId);
    }

    @Override
    public Army CreateTroops(Army army) {
        for(int i = 0; i < super.GetSelectedAmount(); i++) {
            army.AddTroop(new HogRider(super.GetSelectedLevel()));
        }

        return army;
    }
}
