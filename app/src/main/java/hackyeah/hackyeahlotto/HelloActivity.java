package hackyeah.hackyeahlotto;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        // setPBColor();//TODO error with Drawable to check
        sleepBeforeStarting();
    }

    private void sleepBeforeStarting() {
        final Intent startMainActivity = new Intent(this, LoginActivity.class);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(startMainActivity);
            }
        }, 3000);

    }

    private void setPBColor() {
        ProgressBar bar = findViewById(R.id.pbHelloActivity);
        Drawable progressDrawable = bar.getProgressDrawable().mutate();
        progressDrawable.setColorFilter(ContextCompat.getColor(this, R.color.background), android.graphics.PorterDuff.Mode.SRC_IN);
        bar.setProgressDrawable(progressDrawable);
    }
}
