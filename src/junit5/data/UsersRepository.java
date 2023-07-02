package junit5.data;


import junit5.model.User;

public interface UsersRepository {
    boolean save(User user);
}
