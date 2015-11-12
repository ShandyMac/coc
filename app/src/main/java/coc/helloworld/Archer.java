package coc.helloworld;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Andrew_Ma on 12/11/2015.
 */
public class Archer extends BaseConsumableUnit {
    private int _level = 1;
    private int _troopCost;
    private ElixerType _troopType = ElixerType.Normal;
    private int _housingSpace = 1;
    private ArrayList<LevelCost> _levelCosts;
    private Integer[] _levels;

    public Archer(int level)
    {
        _level = level;
        _levelCosts = new ArrayList<>();
        _levelCosts.add(0, new LevelCost(1,50));
        _levelCosts.add(0, new LevelCost(2,80));
        _levelCosts.add(0, new LevelCost(3,120));
        _levelCosts.add(0, new LevelCost(4,200));
        _levelCosts.add(0, new LevelCost(5,300));
        _levelCosts.add(0, new LevelCost(6,400));
        _levelCosts.add(0, new LevelCost(7,500));

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

        for(int i = 1; i < 8; i++ ) { levels.add(i); }

        Integer[] asArray = new Integer[levels.size()];

        return levels.toArray(asArray);
    }
}
