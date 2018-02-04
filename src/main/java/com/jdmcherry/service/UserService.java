package com.jdmcherry.service;

import com.jdmcherry.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserService extends CrudRepository<User, Integer> {

}
