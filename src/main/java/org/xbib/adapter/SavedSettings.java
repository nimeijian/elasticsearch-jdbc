package org.xbib.adapter;

import org.elasticsearch.common.settings.Settings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanyu on 2017/8/26.
 */

//TODO rename to SettingsService, and integrate with JPA to save and get settings
public class SavedSettings {

    private static Map<String, Settings> settingsMap = new HashMap<>();

    public static void init(){
        // TODO: init settingsMap for saved settings in database
    }

    public static Map<String, Settings> getSettingsMap() {
        return settingsMap;
    }

    public static void setSettingsMap(Map<String, Settings> settingsMap) {
        SavedSettings.settingsMap = settingsMap;
    }

    public static void addSettings(String index, Settings settings){
        settingsMap.put(index, settings);
    }

    public static Settings getSettings(String index){
        return settingsMap.get(index);
    }

}
