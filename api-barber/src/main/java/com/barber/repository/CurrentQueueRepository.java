package com.barber.repository;

import com.barber.entity.CurrentQueueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentQueueRepository extends JpaRepository<CurrentQueueEntity, Long> {
}
