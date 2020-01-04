package ir.maktab.java32.projects.articlesmanagement.features.tagmanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.domain.Tag;

import java.util.List;

public interface FindAllTagByAdminUseCase {
    List<Tag> findAll();
}
