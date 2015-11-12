package coc.helloworld;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Andrew_Ma on 12/11/2015.
 */
public class Giant extends BaseConsumableUnit {
    private int _troopCost;
    private int _level = 1;
    private int _housingSpace = 5;
    private ArrayList<LevelCost> _levelCosts;
    private ElixerType _troopType = ElixerType.Normal;

    private Integer[] _levels;

    public Giant(int level)
    {
        _level = level;
        _levelCosts = new ArrayList<>();
        _levelCosts.add(new LevelCost(1,250));
        _levelCosts.add(new LevelCost(2,750));
        _levelCosts.add(new LevelCost(3,1250));
        _levelCosts.add(new LevelCost(4,1750));
        _levelCosts.add(new LevelCost(5,2250));
        _levelCosts.add(new LevelCost(6,3000));
        _levelCosts.add(new LevelCost(7, 3500));

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

        for(int i = 1; i < 8; i++ ) { levels.add(i); }

        Integer[] asArray = new Integer[levels.size()];

        return levels.toArray(asArray);
    }
}
