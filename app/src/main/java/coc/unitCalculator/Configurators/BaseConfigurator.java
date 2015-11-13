package coc.unitCalculator.configurators;

import android.app.Activity;
import android.widget.Spinner;

/**
 * Created by Andrew_Ma on 12/11/2015.
 */
public class BaseConfigurator {
    private Spinner _levelSpinner;
    private Spinner _amountSpinner;

    private int _selectedLevel;
    private int _selectedAmount;

    public BaseConfigurator(Activity activity, int levelId, int amountId) {
        _levelSpinner = (Spinner) activity.findViewById(levelId);
        _amountSpinner = (Spinner) activity.findViewById(amountId);

        _selectedLevel = (int) _levelSpinner.getSelectedItem();
        _selectedAmount = (int) _amountSpinner.getSelectedItem();
    }

    public int GetSelectedLevel(){ return _selectedLevel; }
    public int GetSelectedAmount(){ return _selectedAmount; }
}
