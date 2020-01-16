package ir.maktab.java32.projects.articlesmanagement.core.share.log.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.share.log.repositories.LogRepository;
import ir.maktab.java32.projects.articlesmanagement.core.share.log.usecases.LogRecordUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Log;

public class LogRecordUseCaseImpl implements LogRecordUseCase {
    private LogRepository logRepository = LogRepository.getInstance();
    @Override
    public void log(Log log) {
        logRepository.save(log);
    }
}

