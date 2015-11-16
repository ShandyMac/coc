package coc.unitCalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import coc.consumables.troops.Golem;
import coc.consumables.troops.HogRider;
import coc.consumables.troops.LavaHound;
import coc.consumables.troops.Minion;
import coc.consumables.troops.Valkyrie;
import coc.consumables.troops.Witch;
import coc.unitCalculator.configurators.ArcherConfigurator;
import coc.unitCalculator.configurators.BalloonConfigurator;
import coc.unitCalculator.configurators.BarbarianConfigurator;
import coc.unitCalculator.configurators.DragonConfigurator;
import coc.unitCalculator.configurators.GiantConfigurator;
import coc.unitCalculator.configurators.GoblinConfigurator;
import coc.unitCalculator.configurators.GolemConfigurator;
import coc.unitCalculator.configurators.HealerConfigurator;
import coc.unitCalculator.configurators.HogRiderConfigurator;
import coc.unitCalculator.configurators.LavaHoundConfigurator;
import coc.unitCalculator.configurators.MinionConfigurator;
import coc.unitCalculator.configurators.PekkaConfigurator;
import coc.unitCalculator.configurators.ValkyrieConfigurator;
import coc.unitCalculator.configurators.WallbreakerConfigurator;
import coc.unitCalculator.configurators.WitchConfigurator;
import coc.unitCalculator.configurators.WizardConfigurator;
import coc.consumables.troops.Archer;
import coc.consumables.troops.Balloon;
import coc.consumables.troops.Barbarian;
import coc.consumables.troops.Dragon;
import coc.consumables.troops.Giant;
import coc.consumables.troops.Goblin;
import coc.consumables.troops.Healer;
import coc.consumables.troops.Pekka;
import coc.consumables.troops.Wallbreaker;
import coc.consumables.troops.Wizard;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bindEvents();
    }

    private void bindEvents()
    {
        Button btnUnitCalculator = (Button)findViewById(R.id.btnUnitCalculator);
        btnUnitCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UnitCalculatorActivity.class);
                startActivity(intent);
            }
        });
    }
}