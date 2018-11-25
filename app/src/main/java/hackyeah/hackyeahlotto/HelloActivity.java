package hackyeah.hackyeahlotto;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import hackyeah.hackyeahlotto.login.LoginActivity;
import hackyeah.hackyeahlotto.service.GPSService;

public class HelloActivity extends AppCompatActivity {
    public GPSService gpsService;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            String name = className.getClassName();

            if (name.endsWith(GPSService.class.getSimpleName())) {
                gpsService = ((GPSService.LocationServiceBinder) service).getService();
            }
        }

        public void onServiceDisconnected(ComponentName className) {

            if (className.getClassName().equals(GPSService.class.getSimpleName())) {

                gpsService = null;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        setPBColor();
        initializeGpsService();
        sleepBeforeStarting();
    }

    private void startTracking() {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        if (gpsService != null) {
                            gpsService.startTracking();
                        } else {
                            Log.i(this.getClass().getSimpleName(), "BAD");
                            Toast.makeText(getApplicationContext(), "Tracking is not available ", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        if (response.isPermanentlyDenied()) {
                            openSettings();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    private void openSettings() {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", BuildConfig.APPLICATION_ID, null);
        intent.setData(uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void initializeGpsService() {
        final Intent intent = new Intent(this.getApplication(), GPSService.class);
        this.getApplication().startService(intent);
        this.getApplication().bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private void sleepBeforeStarting() {
        final Intent startMainActivity = new Intent(this, LoginActivity.class);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startTracking();
                startActivity(startMainActivity);
            }
        }, 3000);

    }

    private void setPBColor() {
        ProgressBar bar = findViewById(R.id.pbHelloActivity);
        bar.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.pb_color), PorterDuff.Mode.SRC_IN);
    }
}
