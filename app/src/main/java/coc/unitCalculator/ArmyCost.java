package coc.unitCalculator;

/**
 * Created by Andrew_Ma on 13/11/2015.
 */
public class ArmyCost {
    private int _total;
    private int _totalDark;

    public ArmyCost(int total, int totalDark)
    {
        _total = total;
        _totalDark = totalDark;
    }

    public int GetTotal(){return _total;}
    public int GetTotalDark(){return _totalDark;}
}
