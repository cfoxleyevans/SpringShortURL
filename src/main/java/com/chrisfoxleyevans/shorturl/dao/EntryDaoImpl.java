package com.chrisfoxleyevans.shorturl.dao;

import com.chrisfoxleyevans.shorturl.model.Entry;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class EntryDaoImpl implements EntryDao {

    @Resource
    SessionFactory sessionFactory;

    @Override
    public void create(Entry entry) {
        sessionFactory.getCurrentSession()
                .saveOrUpdate(entry);
    }

    @Override
    public String checkForURL(String url) {
        Entry entry = (Entry) sessionFactory.getCurrentSession()
                .createQuery("from Entry where url = :url")
                .setParameter("url", url)
                .uniqueResult();

        if (entry != null) {
            return entry.getShortCode();
        } else {
            return null;
        }
    }

    @Override
    public String getLongUrl(String code) {
        Entry entry = (Entry) sessionFactory.getCurrentSession()
                .createQuery("from Entry where short_code = :shortCode")
                .setParameter("shortCode", code)
                .uniqueResult();

        entry.setTimesUsed(entry.getTimesUsed() + 1);
        sessionFactory.getCurrentSession().saveOrUpdate(entry);

        return entry.getUrl();
    }
}
