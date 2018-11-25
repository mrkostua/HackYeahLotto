package hackyeah.hackyeahlotto;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import dagger.android.support.DaggerAppCompatActivity;
import hackyeah.hackyeahlotto.databinding.ActivityStateBinding;
import hackyeah.hackyeahlotto.injection.ActivityScope;

import javax.inject.Inject;
import java.util.Objects;

@ActivityScope
public class StateActivity extends DaggerAppCompatActivity {
    @Inject
    public StateViewModel stateViewModel;

    private Button buyTicketBtn;
    private Button bonusBtn;
    private Button accountState;
    private TextView nextDrawTv;
    private Button seeResultBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStateBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_state);
        binding.setViewModel(stateViewModel);
        buyTicketBtn = findViewById(R.id.buy_ticket_btn);
        bonusBtn = findViewById(R.id.daily_bonus_btn);
        accountState = findViewById(R.id.point_state_btn);
        seeResultBtn = findViewById(R.id.see_results_btn);
        nextDrawTv = findViewById(R.id.next_draw_tv);

        stateViewModel.subscribeToGPSResults();
        binding.executePendingBindings();
        binding.setLifecycleOwner(this);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return true;
    }

    public void loginClickListener(View view) {
        Intent intentAllFeaturesActiivity = new Intent(this, AllFeaturesActivity.class);
        startActivity(intentAllFeaturesActiivity);
    }


    private void onBuyTicketClick() {

    }

    private void onBonusBtnClick() {
    }

    private void onSeeResultBtnClick() {
    }


    public void setButtonText(int pointAmounts) {
        accountState.setText(getString(R.string.pointsText, pointAmounts));
    }
}
