package hackyeah.hackyeahlotto;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class StateActivity extends AppCompatActivity {

    private Button buyTicketBtn;
    private Button bonusBtn;
    private Button accountState;
    private TextView nextDrawTv;
    private Button seeResultBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_state);
        buyTicketBtn = findViewById(R.id.buy_ticket_btn);
        bonusBtn = findViewById(R.id.daily_bonus_btn);
        accountState = findViewById(R.id.point_state_btn);
        seeResultBtn = findViewById(R.id.see_results_btn);
        nextDrawTv = findViewById(R.id.next_draw_tv);
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


}
