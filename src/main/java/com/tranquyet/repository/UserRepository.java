package com.tranquyet.repository;

import com.tranquyet.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "SELECT * FROM users u WHERE u.id_facebook like :idFacebook", nativeQuery = true)
    UserEntity getUserByIdFacebook(String idFacebook);

    @Query(value = "SELECT * FROM users u WHERE u.email like :email", nativeQuery = true)
    UserEntity findByEmail(@Param("email") String email);

    @Query(value = "SELECT u FROM users u WHERE u.username = :username", nativeQuery = true)
    public UserEntity getUserByUsername(@Param("username") String username);
}
