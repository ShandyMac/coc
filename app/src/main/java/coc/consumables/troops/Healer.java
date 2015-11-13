package coc.consumables.troops;

import java.util.ArrayList;
import java.util.Collection;

import coc.consumables.BaseConsumableUnit;
import coc.consumables.ElixerType;
import coc.consumables.LevelCost;

/**
 * Created by Andrew_Ma on 13/11/2015.
 */
public class Healer extends BaseConsumableUnit {
    private int _troopCost;
    private int _level = 1;
    private int _housingSpace = 14;
    private ArrayList<LevelCost> _levelCosts;
    private ElixerType _troopType = ElixerType.Normal;

    private Integer[] _levels;

    public Healer(int level)
    {
        _level = level;
        _levelCosts = new ArrayList<>();
        _levelCosts.add(new LevelCost(1,5000));
        _levelCosts.add(new LevelCost(2,6000));
        _levelCosts.add(new LevelCost(3,8000));
        _levelCosts.add(new LevelCost(4,10000));

        _troopCost = GetCost();

        _levels = GetLevels();
    }

    @Override
    public ElixerType GetElixerType() { return _troopType; }

    @Override
    public Collection<LevelCost> GetLevelCosts() { return _levelCosts; }

    @Override
    public int GetHousingSpace() { return _housingSpace; }

    @Override
    public int GetLevel() { return _level; }

    @Override
    public int GetTroopCost(){ return _troopCost; }

    public static Integer[] GetLevels() {
        ArrayList<Integer> levels  = new ArrayList();

        for(int i = 1; i < 5; i++ ) { levels.add(i); }

        Integer[] asArray = new Integer[levels.size()];

        return levels.toArray(asArray);
    }
}
