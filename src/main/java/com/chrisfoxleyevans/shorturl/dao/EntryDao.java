package com.chrisfoxleyevans.shorturl.dao;

import com.chrisfoxleyevans.shorturl.model.Entry;

public interface EntryDao {

    void create(Entry entry);

    String checkForURL(String url);

    String getLongUrl(String code);
}
