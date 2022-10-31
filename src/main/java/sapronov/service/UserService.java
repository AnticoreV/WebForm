package sapronov.service;

import sapronov.repository.UserRepositoryImpl;

public class UserService {
    UserRepositoryImpl userRepository = new UserRepositoryImpl();
    public void save(String pol_num, String name, String surname) throws Exception {
        userRepository.saveUser(pol_num, name, surname);
    }

    public void save(String req) throws Exception {
        userRepository.saveRequest(req);
    }
}
