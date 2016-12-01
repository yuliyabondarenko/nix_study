package com.nixsolutions.bondarenko.study.jsp.user.library;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Yuliya Bondarenko
 */
public interface UserDao {
    void create(User user) throws Exception;

    void update(User user) throws Exception;

    void remove(User user) throws Exception;

    List<User> findAll() throws Exception;

    User findById(Long id) throws Exception;

    User findByLogin(String login) throws Exception;

    User findByEmail(String email) throws Exception;
}