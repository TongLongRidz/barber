package com.barber.service;

import com.barber.dto.CurrentQueueDto;
import com.barber.entity.CurrentQueueEntity;
import com.barber.repository.CurrentQueueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrentQueueService {

    private final CurrentQueueRepository currentQueueRepository;

    // Create
    public CurrentQueueEntity addQueue(CurrentQueueDto dto) {
        CurrentQueueEntity entity = new CurrentQueueEntity();
        entity.setCustomerTel(dto.getCustomerTel());
        entity.setQueueAt(LocalDateTime.now());

        return currentQueueRepository.save(entity);
    }

    // Read All
    public List<CurrentQueueEntity> getAllQueues() {
        return currentQueueRepository.findAll();
    }

    // Read ByID
    public CurrentQueueEntity getQueueById(Long id) {

        return currentQueueRepository.findById(id).orElse(null);
//                .orElseThrow(() -> new EntityNotFoundException("Queue not found with id: " + id));
    }

    // Update ByID
    public CurrentQueueEntity updateQueue(Long id, CurrentQueueDto dto) {
        CurrentQueueEntity entity = getQueueById(id);

        if (dto.getCustomerTel() != null) {
            entity.setCustomerTel(dto.getCustomerTel());
        }

        return currentQueueRepository.save(entity);
    }

    // Delete ByID
    public void deleteQueue(Long id) {
//        if (!currentQueueRepository.existsById(id)) {
//            throw new EntityNotFoundException("Queue not found with id: " + id);
//        }
        currentQueueRepository.deleteById(id);
    }
}