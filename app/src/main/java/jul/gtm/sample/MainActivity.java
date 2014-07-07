package jul.gtm.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import jul.gtm.sample.activity.ActivityOne;
import jul.gtm.sample.util.GTMUtil;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final Button btn = (Button) findViewById(R.id.btnStart);
        btn.setText("Go to ActivityOne");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GTMUtil.fireEvent(MainActivity.this, btn.getText().toString());
                startActivity(new Intent(MainActivity.this, ActivityOne.class));
            }
        });

        GTMUtil.openScreen(this, getString(R.string.main_activity));
    }
}
