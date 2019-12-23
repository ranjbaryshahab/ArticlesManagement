package ir.maktab.java32.projects.articlesmanagement.features.categorymanagement.usecases;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.UseCase;
import ir.maktab.java32.projects.articlesmanagement.model.Category;

import java.util.List;

@UseCase
public interface FindAllCategoryByUserUseCase {
    List<Category> findAll();
}
