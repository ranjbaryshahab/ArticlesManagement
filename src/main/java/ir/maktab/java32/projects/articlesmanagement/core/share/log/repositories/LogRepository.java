package ir.maktab.java32.projects.articlesmanagement.core.share.log.repositories;

import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.repositories.CrudRepository;
import ir.maktab.java32.projects.articlesmanagement.domain.Log;

public class LogRepository extends CrudRepository<Log, Integer> {
    private static LogRepository logRepository;
    private LogRepository() {
        setSession(HibernateUtil.getSecondSession());
    }

    public static LogRepository getInstance() {
        if (logRepository == null) {
            logRepository = new LogRepository();
        }
        return logRepository;
    }

    @Override
    protected Class<Log> getEntityClass() {
        return Log.class;
    }
}
