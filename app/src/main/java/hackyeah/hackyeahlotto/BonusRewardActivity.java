package hackyeah.hackyeahlotto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;


public class BonusRewardActivity extends AppCompatActivity {

    private Button getDetailsAboutBonusRewardWonBtn;
    private Button tryToGetBonusReward;
    private TextView youWonTv;
    private TextView clickTheTreasureTv;
    private TextView pleaseComeBackBabyTv;
    private TextView detailsBonusRewardsTv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_reward);
        youWonTv = findViewById(R.id.you_won_tv);
        pleaseComeBackBabyTv = findViewById(R.id.please_come_back_baby);
        getDetailsAboutBonusRewardWonBtn = findViewById(R.id.get_details_about_won_bonus_reward_btn);
        tryToGetBonusReward = findViewById(R.id.try_to_get_bonus_reward_btn);
        clickTheTreasureTv = findViewById(R.id.click_the_trasure);
        detailsBonusRewardsTv = findViewById(R.id.details_bonus_reward);
        youWonTv.setVisibility(View.GONE);
        pleaseComeBackBabyTv.setVisibility(View.GONE);
        detailsBonusRewardsTv.setVisibility(View.GONE);
        getDetailsAboutBonusRewardWonBtn.setVisibility(View.GONE);
        getDetailsAboutBonusRewardWonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDetailsAboutBonusRewardWonBtn.setVisibility(View.GONE);
                detailsBonusRewardsTv.setVisibility(View.VISIBLE);
                pleaseComeBackBabyTv.setVisibility(View.GONE);
                tryToGetBonusReward.setVisibility(View.GONE);
            }
        });
        tryToGetBonusReward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youWonTv.setVisibility(View.VISIBLE);
                pleaseComeBackBabyTv.setVisibility(View.VISIBLE);
                getDetailsAboutBonusRewardWonBtn.setVisibility(View.VISIBLE);
                clickTheTreasureTv.setVisibility(View.GONE);

                //mock
                int random = new Random().nextInt(3) + 1;
                String prize;
                switch (random) {
                    case 1:
                        prize = "An additional ticket";
                        break;
                    case 2:
                        prize = "220 Points";
                        break;
                    case 3:
                    default:
                        prize = "Nothing";
                }
                getDetailsAboutBonusRewardWonBtn.setText(prize);
                getDetailsAboutBonusRewardWonBtn.setVisibility(View.VISIBLE);
            }
        });
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return true;
    }
}