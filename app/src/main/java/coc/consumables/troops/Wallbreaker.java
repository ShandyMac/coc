package coc.consumables.troops;

import java.util.ArrayList;
import java.util.Collection;

import coc.consumables.BaseConsumableUnit;
import coc.consumables.ElixerType;
import coc.consumables.LevelCost;

/**
 * Created by Andrew_Ma on 12/11/2015.
 */
public class Wallbreaker extends BaseConsumableUnit {
    private int _troopCost;
    private int _level = 1;
    private int _housingSpace = 2;
    private ArrayList<LevelCost> _levelCosts;
    private ElixerType _troopType = ElixerType.Normal;

    private Integer[] _levels;

    public Wallbreaker(int level)
    {
        _level = level;
        _levelCosts = new ArrayList<>();
        _levelCosts.add(new LevelCost(1,1000));
        _levelCosts.add(new LevelCost(2,1500));
        _levelCosts.add(new LevelCost(3,2000));
        _levelCosts.add(new LevelCost(4,2500));
        _levelCosts.add(new LevelCost(5,3000));
        _levelCosts.add(new LevelCost(6,3500));

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

        for(int i = 1; i < 7; i++ ) { levels.add(i); }

        Integer[] asArray = new Integer[levels.size()];

        return levels.toArray(asArray);
    }
}
