package org.xbib.adapter.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by sanyu on 2017/8/19.
 * single field type will
 */
public class JdbcConfigInfo {


    private String url = "jdbc:mysql://localhost:3306/sbes";
    private String user = "root";
    private String password = "";
    private String sql =  "select *, s_movie_id as _id from s_movie";
    @SerializedName("elasticsearch")
    @JsonProperty("elasticsearch")
    private ElasticsearchConfigInfo elasticsearchConfigInfo;
    private String index = "s_movie";

    private String interval = "5s";

    @SerializedName("index_settings")
    @JsonProperty("index_settings")
    private Map<String, Object> indexSettingsInfo;

    @SerializedName("type_mapping")
    @JsonProperty("type_mapping")
    private Map<String, Object> typeMappingInfo;


    public Map<String, Object> getTypeMappingInfo() {
        return typeMappingInfo;
    }

    public void setTypeMappingInfo(Map<String, Object> typeMappingInfo) {
        this.typeMappingInfo = typeMappingInfo;
    }

    public Map<String, Object> getIndexSettingsInfo() {
        return indexSettingsInfo;
    }

    public void setIndexSettingsInfo(Map<String, Object> indexSettingsInfo) {
        this.indexSettingsInfo = indexSettingsInfo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }


    public ElasticsearchConfigInfo getElasticsearchConfigInfo() {
        return elasticsearchConfigInfo;
    }

    public void setElasticsearchConfigInfo(ElasticsearchConfigInfo elasticsearchConfigInfo) {
        this.elasticsearchConfigInfo = elasticsearchConfigInfo;
    }


    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }
}
