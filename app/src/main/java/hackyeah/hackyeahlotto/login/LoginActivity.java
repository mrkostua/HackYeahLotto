package hackyeah.hackyeahlotto.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import hackyeah.hackyeahlotto.AllFeaturesActivity;
import hackyeah.hackyeahlotto.R;

/**
 * @author Kostiantyn Prysiazhnyi on 11/24/2018.
 */
public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginClickListener(View view) {
        Intent intentAllFeaturesActiivity = new Intent(this, AllFeaturesActivity.class);
        startActivity(intentAllFeaturesActiivity);
    }
}
