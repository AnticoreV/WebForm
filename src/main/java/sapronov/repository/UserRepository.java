package sapronov.repository;

import java.sql.SQLException;

public interface UserRepository {
    void saveUser(String pol_num, String name, String surname) throws Exception;
    void saveRequest(String req_text) throws Exception;
}
