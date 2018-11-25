package hackyeah.hackyeahlotto.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import hackyeah.hackyeahlotto.AllFeaturesActivity;
import hackyeah.hackyeahlotto.R;

/**
 * @author Kostiantyn Prysiazhnyi on 11/24/2018.
 */
public class LoginActivity extends AppCompatActivity {
    private Pair admin = new Pair("admin", "admin");
    private Pair userNormall = new Pair("kowalski@gmail.com","1111");
    private EditText etLogin;
    private EditText etPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);
    }

    public void loginClickListener(View view) {
        String login = etLogin.getText().toString();
        String password = etPassword.getText().toString();
        if (login.equals(admin.first) && password.equals(admin.second) || login.equals(userNormall.first) && password.equals(userNormall.second)) {
            Intent intentAllFeaturesActiivity = new Intent(this, AllFeaturesActivity.class);
            startActivity(intentAllFeaturesActiivity);
        } else {
            Toast.makeText(this, "wrong email or password", Toast.LENGTH_LONG).show();
        }

    }
}
