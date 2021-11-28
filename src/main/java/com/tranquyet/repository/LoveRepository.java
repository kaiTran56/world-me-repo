package com.tranquyet.repository;

import com.tranquyet.entity.LoveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface LoveRepository extends JpaRepository<LoveEntity, Long>, JpaSpecificationExecutor {
}
