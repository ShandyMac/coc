package coc.unitCalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import coc.consumables.troops.Archer;
import coc.consumables.troops.Balloon;
import coc.consumables.troops.Barbarian;
import coc.consumables.troops.Dragon;
import coc.consumables.troops.Giant;
import coc.consumables.troops.Goblin;
import coc.consumables.troops.Golem;
import coc.consumables.troops.Healer;
import coc.consumables.troops.HogRider;
import coc.consumables.troops.LavaHound;
import coc.consumables.troops.Minion;
import coc.consumables.troops.Pekka;
import coc.consumables.troops.Valkyrie;
import coc.consumables.troops.Wallbreaker;
import coc.consumables.troops.Witch;
import coc.consumables.troops.Wizard;
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

public class UnitCalculatorActivity extends AppCompatActivity {
    Button btnReset;
    Button btnCalculate;
    TextView cost;
    TextView darkCost;

    ArrayList<Spinner> spinners;

    Army army = new Army();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_calculator);

        ArrayList<Integer> troopCapactiy = new ArrayList<>();
        for (int i = 0; i < 240; i++) troopCapactiy.add(i);

        Integer[] campCapacity = new Integer[troopCapactiy.size()];
        troopCapactiy.toArray(campCapacity);

        ConfigureEvents();

        ConfigureSpinners(campCapacity);

        cost = (TextView)findViewById(R.id.textViewCost);
        darkCost = (TextView)findViewById(R.id.textViewDarkCost);
    }

    private void ConfigureSpinners(Integer[] campCapacity) {
        spinners = new ArrayList<>();

        ConfigureSpinner(R.id.spinnerBarbLevel, Barbarian.GetLevels());
        ConfigureSpinner(R.id.spinnerBarbAmount, campCapacity);

        ConfigureSpinner(R.id.spinnerArcherLevel, Archer.GetLevels());
        ConfigureSpinner(R.id.spinnerArcherAmount, campCapacity);

        ConfigureSpinner(R.id.spinnerGiantLevel, Giant.GetLevels());
        ConfigureSpinner(R.id.spinnerGiantAmount, campCapacity);

        ConfigureSpinner(R.id.spinnerGoblinLevel, Goblin.GetLevels());
        ConfigureSpinner(R.id.spinnerGoblinAmount, campCapacity);

        ConfigureSpinner(R.id.spinnerWallbreakerLevel, Wallbreaker.GetLevels());
        ConfigureSpinner(R.id.spinnerWallbreakerAmount, campCapacity);

        ConfigureSpinner(R.id.spinnerBalloonLevel, Balloon.GetLevels());
        ConfigureSpinner(R.id.spinnerBalloonAmount, campCapacity);

        ConfigureSpinner(R.id.spinnerWizardLevel, Wizard.GetLevels());
        ConfigureSpinner(R.id.spinnerWizardAmount, campCapacity);

        ConfigureSpinner(R.id.spinnerHealerLevel, Healer.GetLevels());
        ConfigureSpinner(R.id.spinnerHealerAmount, campCapacity);

        ConfigureSpinner(R.id.spinnerDragonLevel, Dragon.GetLevels());
        ConfigureSpinner(R.id.spinnerDragonAmount, campCapacity);

        ConfigureSpinner(R.id.spinnerPekkaLevel, Pekka.GetLevels());
        ConfigureSpinner(R.id.spinnerPekkaAmount, campCapacity);

        ConfigureSpinner(R.id.spinnerMinionLevel, Minion.GetLevels());
        ConfigureSpinner(R.id.spinnerMinionAmount, campCapacity);

        ConfigureSpinner(R.id.spinnerHogLevel, HogRider.GetLevels());
        ConfigureSpinner(R.id.spinnerHogAmount, campCapacity);

        ConfigureSpinner(R.id.spinnerValkLevel, Valkyrie.GetLevels());
        ConfigureSpinner(R.id.spinnerValkAmount, campCapacity);

        ConfigureSpinner(R.id.spinnerGolemLevel, Golem.GetLevels());
        ConfigureSpinner(R.id.spinnerGolemAmount, campCapacity);

        ConfigureSpinner(R.id.spinnerWitchLevel, Witch.GetLevels());
        ConfigureSpinner(R.id.spinnerWitchAmount, campCapacity);

        ConfigureSpinner(R.id.spinnerLavaLevel, LavaHound.GetLevels());
        ConfigureSpinner(R.id.spinnerLavaAmount, campCapacity);
    }

    private void ConfigureEvents() {
        btnCalculate = (Button)findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                btnCalculateOnClick();
            }
        });

        btnReset = (Button)findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reset();
            }
        });
    }

    private void Reset() {
        Army.Clear();

        for (Spinner spinner:spinners){
            spinner.setSelection(0);
        }

        cost = (TextView)findViewById(R.id.textViewCost);
        cost.setText("0");

        darkCost = (TextView)findViewById(R.id.textViewDarkCost);
        darkCost.setText("0");
    }

    private void ConfigureSpinner(int spinnerId, Integer[] levels) {
        Spinner spinner = (Spinner) findViewById(spinnerId);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, levels);
        spinner.setAdapter(adapter);

        spinners.add(spinner);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void btnCalculateOnClick()
    {
        BarbarianConfigurator barbConfigurator = new BarbarianConfigurator(this, R.id.spinnerBarbLevel, R.id.spinnerBarbAmount);
        ArcherConfigurator archerConfigurator = new ArcherConfigurator(this, R.id.spinnerArcherLevel, R.id.spinnerArcherAmount);
        GiantConfigurator giantConfigurator = new GiantConfigurator(this, R.id.spinnerGiantLevel, R.id.spinnerGiantAmount);
        GoblinConfigurator goblinConfigurator = new GoblinConfigurator(this, R.id.spinnerGoblinLevel, R.id.spinnerGoblinAmount);
        WallbreakerConfigurator wallbreakerConfigurator = new WallbreakerConfigurator(this, R.id.spinnerWallbreakerLevel, R.id.spinnerWallbreakerAmount);
        BalloonConfigurator balloonConfigurator = new BalloonConfigurator(this, R.id.spinnerWallbreakerLevel, R.id.spinnerWallbreakerAmount);
        WizardConfigurator wizardConfigurator = new WizardConfigurator(this, R.id.spinnerWizardLevel, R.id.spinnerWizardAmount);
        HealerConfigurator healerConfigurator = new HealerConfigurator(this, R.id.spinnerHealerLevel, R.id.spinnerHealerAmount);
        DragonConfigurator dragonConfigurator = new DragonConfigurator(this, R.id.spinnerDragonLevel, R.id.spinnerDragonAmount);
        PekkaConfigurator pekkaConfigurator = new PekkaConfigurator(this, R.id.spinnerPekkaLevel, R.id.spinnerPekkaAmount);

        MinionConfigurator minionConfigurator = new MinionConfigurator(this, R.id.spinnerMinionLevel, R.id.spinnerMinionAmount);
        HogRiderConfigurator hogRiderConfigurator = new HogRiderConfigurator(this, R.id.spinnerHogLevel, R.id.spinnerHogAmount);
        ValkyrieConfigurator valkyrieConfigurator = new ValkyrieConfigurator(this, R.id.spinnerValkLevel, R.id.spinnerValkAmount);
        GolemConfigurator golemConfigurator = new GolemConfigurator(this, R.id.spinnerGolemLevel, R.id.spinnerGolemAmount);
        WitchConfigurator witchConfigurator = new WitchConfigurator(this, R.id.spinnerWitchLevel, R.id.spinnerWitchAmount);
        LavaHoundConfigurator lavahoundConfigurator = new LavaHoundConfigurator(this, R.id.spinnerLavaLevel, R.id.spinnerLavaAmount);

        army.Clear();

        army = barbConfigurator.CreateTroops(army);
        army = archerConfigurator.CreateTroops(army);
        army = giantConfigurator.CreateTroops(army);
        army = goblinConfigurator.CreateTroops(army);
        army = wallbreakerConfigurator.CreateTroops(army);
        army = balloonConfigurator.CreateTroops(army);
        army = wizardConfigurator.CreateTroops(army);
        army = healerConfigurator.CreateTroops(army);
        army = dragonConfigurator.CreateTroops(army);
        army = pekkaConfigurator.CreateTroops(army);

        army = minionConfigurator.CreateTroops(army);
        army = hogRiderConfigurator.CreateTroops(army);
        army = valkyrieConfigurator.CreateTroops(army);
        army = golemConfigurator.CreateTroops(army);
        army = witchConfigurator.CreateTroops(army);
        army = lavahoundConfigurator.CreateTroops(army);

        ArmyCost total = army.GetTotalCost();


        cost.setText(""+total.GetTotal());

        TextView darkCost = (TextView)findViewById(R.id.textViewDarkCost);
        darkCost.setText(""+total.GetTotalDark());
    }
}
