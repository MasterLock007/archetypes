package mx.com.santander.hexagonalmodularmaven.user.service;


import mx.com.santander.hexagonalmodularmaven.user.model.dto.command.UserEditCommand;
import mx.com.santander.hexagonalmodularmaven.user.model.entity.User;
import mx.com.santander.hexagonalmodularmaven.user.port.dao.UserDao;
import mx.com.santander.hexagonalmodularmaven.user.port.repository.UserRepository;

public class UserEditService {
    private final UserDao userDao;
    private final UserRepository userRepository;

    public UserEditService(UserDao userDao, UserRepository userRepository) {
        this.userDao = userDao;
        this.userRepository = userRepository;
    }

    public User execute(UserEditCommand userEditCommand, Long id){

        var currentUser = userDao.getById(id);

        var taskToUpdate = new User(
                currentUser.getId(),
                userEditCommand.getName(),
                userEditCommand.getAge(),
                userEditCommand.getCountry(),
                currentUser.getTasks());

        return userRepository.update(taskToUpdate);

    }

}
