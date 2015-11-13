package coc.consumables.troops;

import java.util.ArrayList;
import java.util.Collection;

import coc.consumables.BaseConsumableUnit;
import coc.consumables.ElixerType;
import coc.consumables.LevelCost;

/**
 * Created by Andrew_Ma on 13/11/2015.
 */
public class Valkyrie extends BaseConsumableUnit {
    private int _level = 1;
    private int _troopCost;
    private ElixerType _troopType = ElixerType.Dark;
    private int _housingSpace = 8;
    private ArrayList<LevelCost> _levelCosts;
    private Integer[] _levels;

    public Valkyrie(int level)
    {
        _level = level;
        _levelCosts = new ArrayList<>();
        _levelCosts.add(new LevelCost(1,70));
        _levelCosts.add(new LevelCost(2,100));
        _levelCosts.add(new LevelCost(3,130));
        _levelCosts.add(new LevelCost(4,160));

        _troopCost = GetCost();

        _levels = GetLevels();
    }

    @Override
    public int GetLevel() { return _level; }

    public int GetTroopCost(){ return _troopCost; }

    @Override
    public ElixerType GetElixerType() {
        return _troopType;
    }

    @Override
    public Collection<LevelCost> GetLevelCosts() {
        return _levelCosts;
    }

    @Override
    public int GetHousingSpace() {
        return _housingSpace;
    }

    public static Integer[] GetLevels() {
        ArrayList<Integer> levels  = new ArrayList();

        for(int i = 1; i < 5; i++ ) { levels.add(i); }

        Integer[] asArray = new Integer[levels.size()];

        return levels.toArray(asArray);
    }
}
