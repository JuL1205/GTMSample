package jul.gtm.sample.util;

import android.content.Context;

import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.TagManager;

/**
 * Created by JuL on 2014-07-07.
 */
public class GTMUtil {

    public static void openScreen(Context context, String screenName){
        DataLayer dataLayer = TagManager.getInstance(context).getDataLayer();

        dataLayer.pushEvent("openScreen", DataLayer.mapOf("screenName", screenName));
    }


    public static void fireEvent(Context context, String btnName){
        DataLayer dataLayer = TagManager.getInstance(context).getDataLayer();

        dataLayer.pushEvent("btnClick", DataLayer.mapOf("btnName", btnName));
    }
}
