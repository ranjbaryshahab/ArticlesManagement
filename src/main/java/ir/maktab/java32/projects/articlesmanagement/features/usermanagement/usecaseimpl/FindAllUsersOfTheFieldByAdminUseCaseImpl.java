package ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecaseimpl;

import ir.maktab.java32.projects.articlesmanagement.domain.Role;
import ir.maktab.java32.projects.articlesmanagement.domain.User;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.repositories.UserRepository;
import ir.maktab.java32.projects.articlesmanagement.features.usermanagement.usecases.FindAllUsersOfTheFieldByAdminUseCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class FindAllUsersOfTheFieldByAdminUseCaseImpl implements FindAllUsersOfTheFieldByAdminUseCase {
    @Override
    public List<User> findAll(String fieldName, Object value) throws FindAllUsersOfTheFieldByAdminFailedException {
        List<User> result;

        switch (fieldName) {
            case "username" -> result = UserRepository.getInstance().findAll((Predicate<User>) user -> user.getUsername().contains((String) value));
            case "role" -> {
                List<User> userList = UserRepository.getInstance().findAll();
                result = new ArrayList<>();
                for (User user : userList) {
                    for (Role role : user.getRoles())
                        if (role.getTitle().contains((String) value))
                            result.add(user);
                }
            }
            case "birth day" -> {
                List<User> userList = UserRepository.getInstance().findAll();
                result = new ArrayList<>();
                for (User user : userList) {
                    Date birthday = null;
                    LocalDate localDate = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    int dayOfMonth = localDate.getDayOfMonth();
                    if (dayOfMonth == Integer.parseInt(value.toString()))
                        result.add(user);
                }
            }
            case "birth month" -> {
                List<User> userList = UserRepository.getInstance().findAll();
                result = new ArrayList<>();
                for (User user : userList) {
                    Date birthday = null;
                    LocalDate localDate = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    int monthValue = localDate.getMonthValue();
                    if (monthValue == Integer.parseInt(value.toString()))
                        result.add(user);
                }
            }
            case "birth year" -> {
                List<User> userList = UserRepository.getInstance().findAll();
                result = new ArrayList<>();
                for (User user : userList) {
                    Date birthday = null;
                    LocalDate localDate = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    int year = localDate.getYear();
                    if (year == Integer.parseInt(value.toString()))
                        result.add(user);
                }
            }

            case "birthday" -> {
                List<User> userList = UserRepository.getInstance().findAll();
                result = new ArrayList<>();
                for (User user : userList) {
                    Date birthday =null;
                    try {
                        birthday = new SimpleDateFormat("dd/MM/yyyy").parse((String) value);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (birthday.compareTo(user.getBirthday()) == 0)
                        result.add(user);
                }
            }

            case "password" -> result = UserRepository.getInstance().findAll((Predicate<User>) user -> user.getPassword().contains((String) value));
            case "national code" -> result = UserRepository.getInstance().findAll((Predicate<User>) user -> user.getNationalCode().contains((String) value));
            case "country" -> result = UserRepository.getInstance().findAll((Predicate<User>) user -> user.getAddress().getCountry().contains((String) value));
            case "city" -> result = UserRepository.getInstance().findAll((Predicate<User>) user -> user.getAddress().getCity().contains((String) value));
            case "street" -> result = UserRepository.getInstance().findAll((Predicate<User>) user -> user.getAddress().getStreet().contains((String) value));
            case "postal code" -> result = UserRepository.getInstance().findAll((Predicate<User>) user -> user.getAddress().getPostalCode().contains((String) value));
            default -> throw new FindAllUsersOfTheFieldByAdminFailedException("Loading user failed !");
        }
        if (result == null)
            throw new FindAllUsersOfTheFieldByAdminFailedException("No matches found for the query!");
        return result;
    }
}
