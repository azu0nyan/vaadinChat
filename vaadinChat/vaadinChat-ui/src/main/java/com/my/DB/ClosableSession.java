package com.my.DB;

import org.hibernate.Session;

/**
 * Created by azu on 17.01.2015.
 */
public class ClosableSession implements AutoCloseable {
    private final Session session;

    public ClosableSession(Session session) {
        this.session = session;
    }

    public Session delegate() {
        return session;
    }

    @Override
    public void close() throws Exception {
        session.close();
    }
}
