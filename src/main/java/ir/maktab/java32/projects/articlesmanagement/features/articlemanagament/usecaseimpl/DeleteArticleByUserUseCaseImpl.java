package ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.core.config.anotations.Service;
import ir.maktab.java32.projects.articlesmanagement.core.config.hibernate.HibernateUtil;
import ir.maktab.java32.projects.articlesmanagement.core.share.AuthenticationService;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGeneric;
import ir.maktab.java32.projects.articlesmanagement.core.share.CrudGenericImpl;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.DeleteArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.features.articlemanagament.usecases.FindArticleByUserUseCase;
import ir.maktab.java32.projects.articlesmanagement.model.Article;
import ir.maktab.java32.projects.articlesmanagement.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

@Service
@SuppressWarnings("Duplicates")
public class DeleteArticleByUserUseCaseImpl implements DeleteArticleByUserUseCase {
    CrudGeneric<Article, Integer> crudGeneric = new CrudGenericImpl<>(Article.class);
    User user = AuthenticationService.getInstance().getLoginUser();

    @Override
    public void delete(int id) throws DeleteArticleByUserFailedException {
        try {
            validate(id);
            deleteArticle(id);
        } catch (DeleteArticleByUserFailedException | FindArticleByUserUseCase.FindArticleByUserFailedException e) {
            throw new DeleteArticleByUserFailedException(e.getMessage());
        }
    }

    private void deleteArticle(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CrudGenericImpl.setSession(session);
        CrudGenericImpl.getSession().beginTransaction();
        Query query = session.createQuery("delete from Article where id=:id and user=:user");
        query.setParameter("id", id);
        query.setParameter("user", user);
        CrudGenericImpl.getSession().getTransaction().commit();
        CrudGenericImpl.getSession().close();
    }

    private void validate(int id) throws DeleteArticleByUserFailedException, FindArticleByUserUseCase.FindArticleByUserFailedException {
        FindArticleByUserUseCase findArticleByUserUseCase = new FindArticleByUserUseCaseImpl();
        Article article = findArticleByUserUseCase.findById(id);
        if (article == null)
            throw new DeleteArticleByUserFailedException("It wasn't deleted !");
    }
}
