package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGeneric;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGenericImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.EditArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Service
@SuppressWarnings({"Duplicates", "unchecked"})
public class EditArticleByUserUseCaseImpl implements EditArticleByUserUseCase {
    CrudGeneric<Article, Integer> crudGeneric = new CrudGenericImpl<>(Article.class);

    @Override
    public Article edit(Article article) throws EditArticleByUserFailedException {
        Article editArticle;
        try {
            validate(article);
            editArticle = updateArticle(article);
        } catch (EditArticleByUserFailedException e) {
            throw new EditArticleByUserFailedException(e.getMessage());
        }
        return editArticle;
    }

    private Article updateArticle(Article article) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CrudGenericImpl.setSession(session);
        CrudGenericImpl.getSession().beginTransaction();
        Article updateArticle = crudGeneric.update(article);
        CrudGenericImpl.getSession().getTransaction().commit();
        CrudGenericImpl.getSession().close();
        return updateArticle;
    }

    private void validate(Article article) throws EditArticleByUserFailedException {
        if (article.getTitle() == null || article.getTitle().isEmpty())
            throw new EditArticleByUserFailedException("Title is empty");

        if (article.getTitle().length() > 30)
            throw new EditArticleByUserFailedException("Title is bigger than 30 characters");

        if (article.getBrief() == null || article.getBrief().isEmpty())
            throw new EditArticleByUserFailedException("Brief is empty");

        if (article.getBrief().length() > 15)
            throw new EditArticleByUserFailedException("Brief is bigger than 30 characters");

        if (article.getContent() == null || article.getContent().isEmpty())
            throw new EditArticleByUserFailedException("Content is empty");

        if (article.getContent().length() > 254)
            throw new EditArticleByUserFailedException("Content is bigger than 254 characters");
    }

}
