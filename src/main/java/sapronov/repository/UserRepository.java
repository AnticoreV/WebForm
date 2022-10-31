package sapronov.repository;

import java.sql.SQLException;

public interface UserRepository {
    void createTable() throws SQLException;
    void createForeignKey() throws SQLException;
    void createExtraConstraints() throws SQLException;
    void save() throws SQLException;
    void update() throws SQLException;
}
