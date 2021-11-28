package com.tranquyet.repository;

import com.tranquyet.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "SELECT * FROM users u WHERE u.id_facebook like :idFacebook", nativeQuery = true)
    UserEntity getUserByIdFacebook(String idFacebook);

    UserEntity findByEmail(String email);
}
