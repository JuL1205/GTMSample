package jul.gtm.sample;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.TagManager;

import java.util.concurrent.TimeUnit;

import jul.gtm.sample.util.ContainerHolderSingleton;

/**
 * Created by JuL on 2014-07-04.
 */
public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;

        initGTM();
    }

    private void initGTM(){
        TagManager tagManager = TagManager.getInstance(this);

        //TODO : input your gtm info
        PendingResult<ContainerHolder> pending = tagManager.loadContainerPreferNonDefault("your container id", -1/* your gtm default container resource */);

        pending.setResultCallback(new ResultCallback<ContainerHolder>() {
            @Override
            public void onResult(ContainerHolder containerHolder) {
                if(!containerHolder.getStatus().isSuccess()){
                    Log.e("JuL", "failure loading container");
                    return;
                }

                ContainerHolderSingleton.setContainerHolder(containerHolder);
                containerHolder.refresh();
                containerHolder.setContainerAvailableListener(new ContainerHolder.ContainerAvailableListener() {
                    @Override
                    public void onContainerAvailable(ContainerHolder containerHolder, String containerVer) {
                        Log.e("JuL", "containerVer = "+containerVer);
                    }
                });


            }
        }, 2, TimeUnit.SECONDS);
    }
}
