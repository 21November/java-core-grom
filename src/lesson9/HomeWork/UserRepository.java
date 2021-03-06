package lesson9.HomeWork;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    //    part2 _____________________________________________
    //    getUserNames() - для получения массива имен пользователей
    //    getUserIds() - для получения массива id пользователей
    //    getUserNameById(long id) - для получения имени пользователя, по его id

    public String[] getUserNames() {
        int a = 0;
        for (User u : users) {
            if (u != null)
                a++;
        }

        String[] names = new String[a];
        int i = 0;
        if (users != null)
            for (User user : users) {
                if (user != null && user.getName() != null) {
                    names[i] = user.getName();
                    i++;
                }
            }
        return names;
    }

    public long[] getUserIds() {
        int a = 0;
        for (User u : users) {
            if (u != null)
                a++;
        }

        long[] ids = new long[a];
        int i = 0;
        for (User user : users) {
            if (user != null) {
                ids[i] = user.getId();
                i++;
            }
        }
        return ids;
    }

    public String getUserNameById(long id) {

        String name = null;
        if (users != null)
            for (User user : users) {
                if (user != null && user.getId() == id && user.getId() != 0)
                    name = user.getName();
            }
        return name != null ? name : "Name not found";
    }

    //    part3 _____________________________________________
    //  getUserByName(String name) - нахождение юзера по имени
    //  getUserById(long id) - нахождение юзера по id
    //  getUserBySessionId(String sessionId) - нахождение юзера по sessionId

    public User getUserByName(String name) {
        if (users != null)
            for (User user : users) {
                if (user != null && name == user.getName())
                    return user;
            }
        return null;
    }

    public User findById(long id) {
        if (users != null)
            for (User user : users) {
                if (user != null && id == user.getId())
                    return user;
            }
        return null;
    }

    public User getUserBySessionId(String sessionId) {
        if (users != null)
            for (User user : users) {
                if (user != null && sessionId == user.getSessionId())
                    return user;
            }
        return null;
    }


    //    part 4 __________________________________________________
    //    User save(User user) - будет добавлять юзера и возвращать его

    public User save(User user) {
        UserRepository userRepository = new UserRepository(users);

        for (User u : userRepository.getUsers()) {
            if (user != null && userRepository.findById(user.getId()) == user)
                return null;
        }

        for (int i = 0; i < userRepository.getUsers().length; i++) {
            if (userRepository.getUsers()[i] == null) {
                userRepository.getUsers()[i] = user;
                return user;
            }
        }
        return null;
    }

    //     part 5 ________________________________________________
    //  User update(User user) - будет обновлять текущего юзера в массиве (перезаписывать) и возвращать его. Если юзера нет, результат метода null
    //  void delete(long id) - удаляет юзера с массива

    public User update(User user) {
        UserRepository userRepository = new UserRepository(users);

        for (int i = 0; i < userRepository.getUsers().length; i++) {
            if (user != null && userRepository.getUsers()[i] == userRepository.findById(user.getId())) {
                userRepository.getUsers()[i] = user;
                return userRepository.getUsers()[i];
            }
            return null;
        }
        return null;
    }


    public void delete(long id) {
        UserRepository userRepository = new UserRepository(users);
        for (int i = 0; i < userRepository.getUsers().length; i++) {
            if (userRepository.getUsers()[i] == userRepository.findById(id))
                userRepository.getUsers()[i] = null;
        }
    }

}
