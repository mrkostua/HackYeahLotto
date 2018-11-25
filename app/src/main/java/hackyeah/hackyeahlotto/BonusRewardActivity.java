package hackyeah.hackyeahlotto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;


public class BonusRewardActivity extends AppCompatActivity {

    private Button bonusBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_reward);
        bonusBtn = findViewById(R.id.daily_bonus_btn);
    }
}