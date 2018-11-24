package hackyeah.hackyeahlotto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AllFeaturesActivity extends AppCompatActivity {
    private Button stateActivityBtn;


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
    }

    public void inviteFriendsViewClickListener(View view) {
        Intent intentAllFeaturesActiivity = new Intent(this, InviteFriendsActivity.class);
        startActivity(intentAllFeaturesActiivity);
    }


    public void runStateActivity() {
        Intent activity = new Intent(this, StateActivity.class);
        startActivity(activity);
    }



}
