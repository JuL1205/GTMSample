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
public class ActivityTwo extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn = (Button) findViewById(R.id.btnStart);
        btn.setText("Go to ActivityThree");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GTMUtil.fireEvent(ActivityTwo.this, btn.getText().toString());
                startActivity(new Intent(ActivityTwo.this, ActivityThree.class));
            }
        });

        GTMUtil.openScreen(this, getString(R.string.activity_two));
    }
}
