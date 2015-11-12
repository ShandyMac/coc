package coc.helloworld;

import android.os.Bundle;
import android.support.annotation.TransitionRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnCalculate;
    Button btnReset;
    Army army = new Army();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<Integer> troopCapactiy = new ArrayList<>();
        for (int i = 0; i < 240; i++) troopCapactiy.add(i);

        Integer[] campCapacity = new Integer[troopCapactiy.size()];
        troopCapactiy.toArray(campCapacity);

        ConfigureEvents();

        ConfigureSpinner(R.id.spinnerBarbLevel, Barbarian.GetLevels());
        ConfigureSpinner(R.id.spinnerBarbAmount, campCapacity);

        ConfigureSpinner(R.id.spinnerArcherLevel, Archer.GetLevels());
        ConfigureSpinner(R.id.spinnerArcherAmount, campCapacity);

        ConfigureSpinner(R.id.spinnerGiantLevel, Giant.GetLevels());
        ConfigureSpinner(R.id.spinnerGiantAmount, campCapacity);

        ConfigureSpinner(R.id.spinnerGoblinLevel, Goblin.GetLevels());
        ConfigureSpinner(R.id.spinnerGoblinAmount, campCapacity);
    }

    private void ConfigureEvents() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnCalculate = (Button)findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(this);
        btnCalculate.setVisibility(View.VISIBLE);

        btnReset = (Button)findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reset();
            }
        });
    }

    private void ConfigureSpinner(int spinnerId, Integer[] levels) {
        Spinner spinner = (Spinner) findViewById(spinnerId);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, levels);
        spinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void Reset()
    {
        TextView cost = (TextView)findViewById(R.id.textViewCost);
        cost.setText("");
        Army.Clear();
        btnReset.setVisibility(View.INVISIBLE);
        btnCalculate.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v)
    {
        BarbarianConfigurator barbConfigurator = new BarbarianConfigurator(this, R.id.spinnerBarbLevel, R.id.spinnerBarbAmount);
        ArcherConfigurator archerConfigurator = new ArcherConfigurator(this, R.id.spinnerArcherLevel, R.id.spinnerArcherAmount);
        GiantConfigurator giantConfigurator = new GiantConfigurator(this, R.id.spinnerGiantLevel, R.id.spinnerGiantAmount);
        GoblinConfigurator goblinConfigurator = new GoblinConfigurator(this, R.id.spinnerGoblinLevel, R.id.spinnerGoblinAmount);

        army = barbConfigurator.CreateTroops(army);
        army = archerConfigurator.CreateTroops(army);
        army = giantConfigurator.CreateTroops(army);
        army = goblinConfigurator.CreateTroops(army);

        int total = army.GetTotalCost();

        TextView cost = (TextView)findViewById(R.id.textViewCost);
        cost.setText("" + total);

        btnReset.setVisibility(View.VISIBLE);
        btnCalculate.setVisibility(View.GONE);
    }
}