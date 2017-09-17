package org.xbib.jdbc.input;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.elasticsearch.common.settings.Settings;
import org.xbib.adapter.config.ConfigInfo;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by sanyu on 2017/9/7.
 */
public class InputImpl implements Input{

    @Override
    public void init() {
        // 1. load json config as stream
        // use config_template.json should have the same structure as package, so use absolute path here
        InputStream configTemplateInputStream = getClass().getResourceAsStream(ROOT_PATH + "/config_template.json");
        InputStream indexSettingsInputStream = getClass().getResourceAsStream(ROOT_PATH + "/elasticsearch/index_settings/index_settings.json");
        String typeName = "order";
        InputStream typeMappingInputStream = getClass().getResourceAsStream(ROOT_PATH + "/elasticsearch/type_mappings/" + typeName + "_mapping.json");

        // 2. merge json file and use gson to convert object to json
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        Settings configTemplateSettings = Settings.settingsBuilder()
                .loadFromStream("configTemplate", configTemplateInputStream)
                .build();
        String configTemplateJsonStr = gson.toJson(configTemplateSettings.getAsStructuredMap());
        ConfigInfo configInfo = gson.fromJson(configTemplateJsonStr, ConfigInfo.class);

        Settings indexSettingsSettings = Settings.settingsBuilder()
                .loadFromStream("indexSettings", indexSettingsInputStream)
                .build();
        configInfo.getJdbcConfigInfo().setIndexSettingsInfo(indexSettingsSettings.getAsStructuredMap());

        Settings typeMappingSettings = Settings.settingsBuilder()
                .loadFromStream("typeMapping", typeMappingInputStream)
                .build();
        configInfo.getJdbcConfigInfo().setTypeMappingInfo(typeMappingSettings.getAsStructuredMap());

        configTemplateJsonStr = gson.toJson(configInfo);

        System.out.println(configTemplateJsonStr);

        // 3. re-build by merge json
        configTemplateSettings = Settings.settingsBuilder()
                .loadFromSource(configTemplateJsonStr)
                .build();

    }

    @Override
    public void prepare() {

    }

    @Override
    public void execute() {

    }

}
