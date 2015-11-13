package coc.consumables.troops;

import java.util.ArrayList;
import java.util.Collection;

import coc.consumables.BaseConsumableUnit;
import coc.consumables.ElixerType;
import coc.consumables.LevelCost;

/**
 * Created by Andrew_Ma on 13/11/2015.
 */
public class LavaHound extends BaseConsumableUnit {
    private int _level = 1;
    private int _troopCost;
    private ElixerType _troopType = ElixerType.Dark;
    private int _housingSpace = 30;
    private ArrayList<LevelCost> _levelCosts;
    private Integer[] _levels;

    public LavaHound(int level)
    {
        _level = level;
        _levelCosts = new ArrayList<>();
        _levelCosts.add(new LevelCost(1,390));
        _levelCosts.add(new LevelCost(2,450));
        _levelCosts.add(new LevelCost(2,510));

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

        for(int i = 1; i < 4; i++ ) { levels.add(i); }

        Integer[] asArray = new Integer[levels.size()];

        return levels.toArray(asArray);
    }
}
