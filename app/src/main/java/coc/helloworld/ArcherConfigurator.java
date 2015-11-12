package coc.helloworld;

import android.app.Activity;
import android.graphics.drawable.Icon;

import java.util.ArrayList;

/**
 * Created by Andrew_Ma on 12/11/2015.
 */
public class ArcherConfigurator extends BaseConfigurator implements IConfigurator {

    public ArcherConfigurator(Activity activity, int levelId, int amountId) {
        super(activity, levelId, amountId);
    }

    @Override
    public Army CreateTroops(Army army) {
        for(int i = 0; i < super.GetSelectedAmount(); i++) {
            army.AddTroop(new Archer(super.GetSelectedLevel()));
        }

        return army;
    }
}
