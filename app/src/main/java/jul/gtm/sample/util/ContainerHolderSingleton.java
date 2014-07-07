package jul.gtm.sample.util;

import com.google.android.gms.tagmanager.ContainerHolder;

/**
 * Created by JuL on 2014-07-07.
 */
public class ContainerHolderSingleton {
    private static ContainerHolder containerHolder;

    /**
     * Utility class; don't instantiate.
     */
    private ContainerHolderSingleton() {
    }

    public static ContainerHolder getContainerHolder() {
        return containerHolder;
    }

    public static void setContainerHolder(ContainerHolder c) {
        containerHolder = c;
    }
}
