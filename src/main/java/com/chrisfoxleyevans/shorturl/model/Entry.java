package com.chrisfoxleyevans.shorturl.model;

import javax.persistence.*;

@Entity
@Table(name = "entry")
public class Entry {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer Id;

    @Column(name = "url")
    private String Url;

    @Column(name = "short_code")
    private String shortCode;

    @Column(name = "times_used")
    private Integer timesUsed;

    public Integer getId() {
        return Id;
    }

    public String getUrl() {
        return Url;
    }

    public String getShortCode() {
        return shortCode;
    }

    public Integer getTimesUsed() {
        return timesUsed;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public void setTimesUsed(Integer timesUsed) {
        this.timesUsed = timesUsed;
    }
}
