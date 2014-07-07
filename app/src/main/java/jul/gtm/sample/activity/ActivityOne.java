package jul.gtm.sample.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import jul.gtm.sample.R;
import jul.gtm.sample.util.GTMUtil;

/**
 * Created by JuL on 2014-07-04.
 */
public class ActivityOne extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn = (Button) findViewById(R.id.btnStart);
        btn.setText("Go to ActivityTwo");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GTMUtil.fireEvent(ActivityOne.this, btn.getText().toString());
                startActivity(new Intent(ActivityOne.this, ActivityTwo.class));
            }
        });

        GTMUtil.openScreen(this, getString(R.string.activity_one));
    }
}
