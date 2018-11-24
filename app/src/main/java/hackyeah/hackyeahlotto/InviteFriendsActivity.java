package hackyeah.hackyeahlotto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class InviteFriendsActivity extends AppCompatActivity {
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friends);
        image = (ImageView) findViewById(R.id.imageViewInviteFacebookMessenger);
//        image.setImageResource(R.drawable.ic_facebook_messenger);
    }
}
