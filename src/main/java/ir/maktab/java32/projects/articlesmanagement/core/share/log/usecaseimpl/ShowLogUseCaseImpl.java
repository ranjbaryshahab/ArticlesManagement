package ir.maktab.java32.projects.articlesmanagement.core.share.log.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.share.log.repositories.LogRepository;
import ir.maktab.java32.projects.articlesmanagement.core.share.log.usecases.ShowLogUseCase;
import ir.maktab.java32.projects.articlesmanagement.domain.Log;

import java.util.List;

public class ShowLogUseCaseImpl implements ShowLogUseCase {
    private LogRepository logRepository = LogRepository.getInstance();
    @Override
    public List<Log> showLog() {
        return logRepository.findAll();
    }
}

