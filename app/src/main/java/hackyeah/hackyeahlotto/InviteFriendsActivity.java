package hackyeah.hackyeahlotto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.Objects;
/**
 * @author Patrick Täsler on 11/24/2018.
 */
public class InviteFriendsActivity extends AppCompatActivity {
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friends);
    }
}
