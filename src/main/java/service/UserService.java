
package service;

import model.User;
import repository.UserRepository;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public void addUserService(String username, String password){
        if(username!=null && !username.equals(password)) {
            User user = new User(username, password);
            userRepository.addUser(user);
        }
    }

    public boolean userLoginService(User user){
        User username = null;
        User password = null;
        try{
            username = userRepository.userCheckPassword(user);
            password = userRepository.userCheckPassword(user);

        }catch (Exception e){
            System.out.println("\n ! User was not found ! \n");
        }
        return username.getId().equals(password.getId());
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

}

