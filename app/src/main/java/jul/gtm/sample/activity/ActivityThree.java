package jul.gtm.sample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import jul.gtm.sample.R;
import jul.gtm.sample.util.GTMUtil;

/**
 * Created by JuL on 2014-07-04.
 */
public class ActivityThree extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btnStart);
        btn.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        GTMUtil.openScreen(this, getString(R.string.activity_three));
    }
}
