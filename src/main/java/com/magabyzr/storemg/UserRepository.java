package com.magabyzr.storemg;

public interface UserRepository {
    void save(User user);                                //method implementation.
    User findByEmail(String email);                     //method for detecting duplicate user.
}
