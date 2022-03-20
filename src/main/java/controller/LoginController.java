package controller;

import model.User;
import repository.UserRepository;
import service.UserService;
import view.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginController {
    Login login = new Login();
    UserService userService = new UserService();

    public LoginController(){
        login.getSignUpButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = login.getUsernameJTextField().getText();
                String password = login.getPasswordJTextField().getText();
                User user = new User(username, password);
                userService.addUserService(username, password);
            }
        });

        login.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = login.getUsernameJTextField().getText();
                String password = login.getPasswordJTextField().getText();
                User checkRole = userService.getUserByUsername(username);
                User user = new User(username, password);
                //System.out.println(userService.userLoginService(user));
                if(userService.userLoginService(user) && checkRole.getRole()== User.Role.ADMIN){
                    VacationController vacationController = new VacationController();
                }else if(userService.userLoginService(user)&& checkRole.getRole()== User.Role.USER){
                    UserController userController = new UserController();
                }
            }
        });
    }
}
