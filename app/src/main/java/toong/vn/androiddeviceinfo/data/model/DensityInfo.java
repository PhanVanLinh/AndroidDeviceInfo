package toong.vn.androiddeviceinfo.data.model;

import android.content.Context;
import toong.vn.androiddeviceinfo.Constant;

/**
 * Created by PhanVanLinh on 27/02/2018.
 * phanvanlinh.94vn@gmail.com
 */

public class DensityInfo extends DeviceInfo {

    public static DeviceInfo build(Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        String displayDensity = Constant.UNKNOWN;
        if (density == 0.75) {
            displayDensity = "ldpi";
        }
        if (density == 1.0) {
            displayDensity = "mdpi";
        }
        if (density == 1.5) {
            displayDensity = "hdpi";
        }
        if (density == 2.0) {
            displayDensity = "xhdpi";
        }
        if (density == 3.0) {
            displayDensity = "xxhdpi";
        }
        if (density == 4.0) {
            displayDensity = "xxxhdpi";
        }

        DeviceInfo densityItem = new DeviceInfo();
        densityItem.setTitle("Density");
        densityItem.setDescription(".75 on ldpi (120 dpi)\n"
                + "1.0 on mdpi (160 dpi;\n"
                + "1.5 on hdpi (240 dpi)\n"
                + "2.0 on xhdpi (320 dpi)\n"
                + "3.0 on xxhdpi (480 dpi)\n"
                + "4.0 on xxxhdpi (640 dpi)");
        densityItem.setValue(displayDensity);
        return densityItem;
    }
}
