package hackyeah.hackyeahlotto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AllFeaturesActivity extends AppCompatActivity {

    private Button stateActivityBtn;
    private Button friendInviteBtn;
    private Button bonusRewardBtn;
    private Button drawActivityBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_features);
        stateActivityBtn = findViewById(R.id.state_activity_btn);
        stateActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runStateActivity();
            }
        });
        friendInviteBtn = findViewById(R.id.friend_invite_btn);
        friendInviteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inviteFriendsViewClickListener();
            }
        });
        bonusRewardBtn = findViewById(R.id.bonus_reward_btn);
        bonusRewardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bonusRewardViewClickListener();
            }
        });
        drawActivityBtn = findViewById(R.id.btn_draw_activity);
        drawActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runDrawsActivity();
            }
        });
    }

    public void inviteFriendsViewClickListener() {
        Intent intentAllFeaturesActiivity = new Intent(this, InviteFriendsActivity.class);
        startActivity(intentAllFeaturesActiivity);
    }


    public void runStateActivity() {
        Intent activity = new Intent(this, StateActivity.class);
        startActivity(activity);
    }

    public void runDrawsActivity() {
        Intent activity = new Intent(this, DrawActivity.class);
        startActivity(activity);
    }


    public void bonusRewardViewClickListener() {
        Intent activity = new Intent(this, BonusRewardActivity.class);
        startActivity(activity);
    }
}
