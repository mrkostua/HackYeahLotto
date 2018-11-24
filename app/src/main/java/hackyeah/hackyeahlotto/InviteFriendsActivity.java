package hackyeah.hackyeahlotto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * @author Patrick Täsler on 11/24/2018.
 */
public class InviteFriendsActivity extends AppCompatActivity {
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friends);
        image = findViewById(R.id.imageViewInviteFacebookMessenger);

    }
}
