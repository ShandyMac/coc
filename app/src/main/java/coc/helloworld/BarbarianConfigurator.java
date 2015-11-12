package coc.helloworld;

import java.util.ArrayList;
import android.app.Activity;

/**
 * Created by Andrew_Ma on 12/11/2015.
 */
public class BarbarianConfigurator extends BaseConfigurator implements IConfigurator {

    public BarbarianConfigurator(Activity activity, int levelId, int amountId) {
        super(activity, levelId, amountId);
    }

    @Override
    public Army CreateTroops(Army army) {
        for(int i = 0; i < super.GetSelectedAmount(); i++) {
            army.AddTroop(new Barbarian(super.GetSelectedLevel()));
        }

        return army;
    }
}