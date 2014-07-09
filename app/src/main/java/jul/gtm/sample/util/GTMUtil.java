package jul.gtm.sample.util;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.TagManager;

import jul.gtm.sample.MyApplication;

/**
 * Created by JuL on 2014-07-07.
 */
public class GTMUtil {

    public static void openScreen(Context context, String screenName){
        boolean enable = getBoolean("ga_screen_enable");
        Log.i("JuL", "ga_screen_enable = "+enable);

        if(enable){
            DataLayer dataLayer = TagManager.getInstance(context).getDataLayer();

            dataLayer.pushEvent("openScreen", DataLayer.mapOf("screenName", screenName));
        }
    }


    public static void fireEvent(Context context, String btnName){
        boolean enable = getBoolean("ga_event_enable");
        Log.i("JuL", "ga_event_enable = "+enable);

        if(enable){
            DataLayer dataLayer = TagManager.getInstance(context).getDataLayer();

            dataLayer.pushEvent("btnClick", DataLayer.mapOf("btnName", btnName));
        }
    }


    public static void refreshContainer(){
        if(!ContainerHolderSingleton.isEmptyContainer()){
            ContainerHolderSingleton.getContainerHolder().refresh();
        }
    }

    public static boolean getBoolean(String key){
        if(ContainerHolderSingleton.isEmptyContainer()){
            return false;
        } else{
            return ContainerHolderSingleton.getContainerHolder().getContainer().getBoolean(key);
        }
    }

}
