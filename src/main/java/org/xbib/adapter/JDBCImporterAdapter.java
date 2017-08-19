package org.xbib.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.elasticsearch.common.settings.Settings;
import org.xbib.adapter.config.ConfigInfo;
import org.xbib.adapter.config.ElasticsearchConfigInfo;
import org.xbib.adapter.config.JdbcConfigInfo;
import org.xbib.tools.JDBCImporter;

import static org.elasticsearch.common.settings.Settings.settingsBuilder;

/**
 * Created by sanyu on 2017/8/19.
 */
public class JDBCImporterAdapter {

    public static void main(String[] args) throws Exception {
        // todo: get config data from config page, currently it's a mockup
        ElasticsearchConfigInfo elasticsearchConfigInfo = new ElasticsearchConfigInfo();
        JdbcConfigInfo jdbcConfigInfo = new JdbcConfigInfo();
        jdbcConfigInfo.setElasticsearchConfigInfo(elasticsearchConfigInfo);
        ConfigInfo configInfo = new ConfigInfo();
        configInfo.setJdbcConfigInfo(jdbcConfigInfo);

        // convert config object to json
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

//        Gson gson = new Gson();
        String json = gson.toJson(configInfo);
        System.out.println(json);

        // run jdbcImporter
        JDBCImporter jdbcImporter = new JDBCImporter();
        Settings settings = settingsBuilder().loadFromSource(json).build();
        jdbcImporter.setSettings(settings);
        jdbcImporter.run();
        Thread.sleep(12000L);
        jdbcImporter.shutdown();
    }

}