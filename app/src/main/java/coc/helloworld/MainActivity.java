package coc.helloworld;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mainTextView;
    Button mainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mainButton = (Button)findViewById(R.id.btnCalculate);
        mainButton.setOnClickListener(this);

        Spinner barbSpinner = (Spinner)findViewById(R.id.spinnerBarb);
        Integer[] levels = new Integer[]{1,2,3,4,5,6,7};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, levels);
        barbSpinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {

        Spinner spinner = (Spinner)findViewById(R.id.spinnerBarb);
        Integer level = (int)spinner.getSelectedItem();
        Barbarian barb = new Barbarian(level);

        TextView cost = (TextView)findViewById(R.id.textViewCost);
        cost.setText("" + barb.GetTroopCost());

        //TextView unitCost = (TextView)findViewById(R.id.main_unit_cost);
        //unitCost.setText("Cost: " + barb.GetTroopCost());

        //TextView unitTrainTime = (TextView)findViewById(R.id.main_unit_name);
        //unitTrainTime.setText("Training Time: " + barb.GetTrainingTime());
    }
}

class ArmyCompositions
{
    public static List<Troop> BAM()
    {
        List<Troop> army = new ArrayList<Troop>();

        for (int i = 0; i < 5; i++)
        {
            Barbarian barb = new Barbarian(5);
            army.add(barb);
        }

        return army;
    }
}


//region Troops

class Troop extends BaseConsumableUnit { }

class Barbarian extends Troop
{
    private int _level = 1;
    private int _troopCost;
    private ElixerType _troopType = ElixerType.Normal;
    private int _housingSpace = 1;
    private ArrayList<LevelCost> _levelCosts;

    private double _troopTrainTime = 0.5;

    public Barbarian(int level)
    {
        _level = level;
        _levelCosts = new ArrayList<LevelCost>();
        _levelCosts.add(0, new LevelCost(1,25));
        _levelCosts.add(0, new LevelCost(2,40));
        _levelCosts.add(0, new LevelCost(3,60));
        _levelCosts.add(0, new LevelCost(4,100));
        _levelCosts.add(0, new LevelCost(5,150));
        _levelCosts.add(0, new LevelCost(6,200));
        _levelCosts.add(0, new LevelCost(7,250));

        _troopCost = GetCost(_level, _levelCosts);
    }

    public int GetTroopCost(){ return _troopCost; }
    public double GetTrainingTime(){ return _troopTrainTime; }
}

//endregion


enum ElixerType
{
    Dark,
    Normal
}

class LevelCost
{
    public int Level;
    public int Cost;

    public LevelCost(int level, int cost)
    {
        Level = level;
        Cost = cost;
    }
}

class BaseConsumableUnit
{
    public ElixerType Type;
    public Collection<LevelCost> LevelCosts;
    public int ConsumableCost;

    public int GetCost(int level, List<LevelCost> levelCosts)
    {
        for (LevelCost cost:levelCosts)
        {
            if(cost.Level == level)
            {
                return cost.Cost;
            }
        }

        return 0;
    }
}