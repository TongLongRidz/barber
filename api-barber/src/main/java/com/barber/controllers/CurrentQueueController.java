package com.barber.controllers;

import com.barber.dto.CurrentQueueDto;
import com.barber.entity.CurrentQueueEntity;
import com.barber.service.CurrentQueueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/currentQueue")
@RequiredArgsConstructor
@Slf4j
public class CurrentQueueController {

    private final CurrentQueueService currentQueueService;

    // Create
    @PostMapping("/add")
    public ResponseEntity<CurrentQueueEntity> addCurrentQueue(@RequestBody CurrentQueueDto body) {
        CurrentQueueEntity currentQueue = currentQueueService.addQueue(body);
        log.info("Added current queue: {}", currentQueue);
        return ResponseEntity.ok(currentQueue);
    }

    // Read All
    @GetMapping("/all")
    public ResponseEntity<List<CurrentQueueEntity>> getAllQueues() {
        List<CurrentQueueEntity> list = currentQueueService.getAllQueues();
        return ResponseEntity.ok(list);
    }

    // Read ByID
    @GetMapping("/{id}")
    public ResponseEntity<CurrentQueueEntity> getQueueById(@PathVariable Long id) {
        CurrentQueueEntity entity = currentQueueService.getQueueById(id);
        return ResponseEntity.ok(entity);
    }

    // Update ByID
    @PutMapping("/{id}")
    public ResponseEntity<CurrentQueueEntity> updateQueue(@PathVariable Long id, @RequestBody CurrentQueueDto body) {
        CurrentQueueEntity updated = currentQueueService.updateQueue(id, body);
        return ResponseEntity.ok(updated);
    }

    // Delete ByID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQueue(@PathVariable Long id) {
        currentQueueService.deleteQueue(id);
        return ResponseEntity.noContent().build();
    }
}
