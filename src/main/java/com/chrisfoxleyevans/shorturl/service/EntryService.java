package com.chrisfoxleyevans.shorturl.service;

import com.chrisfoxleyevans.shorturl.dao.EntryDao;
import com.chrisfoxleyevans.shorturl.model.Entry;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
@Transactional
public class EntryService {

    @Resource
    EntryDao entryDao;

    public String create(String url) {

        Entry entry = new Entry();
        entry.setUrl(url);
        entry.setShortCode(RandomStringUtils.randomAlphanumeric(5));
        entry.setTimesUsed(0);

        entryDao.create(entry);

        return entry.getShortCode();
    }

    public String checkForURL(String url) {
        return entryDao.checkForURL(url);
    }

    public String getLongUrl(String code) {
        return entryDao.getLongUrl(code);
    }
}
