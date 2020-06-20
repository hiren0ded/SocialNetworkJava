package com.hiren.social.socialnetwork.repository;

import com.hiren.social.socialnetwork.datamodel.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
