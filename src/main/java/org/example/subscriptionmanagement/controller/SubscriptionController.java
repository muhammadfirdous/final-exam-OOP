package org.example.subscriptionmanagement.controller;

import org.example.subscriptionmanagement.entity.Subscription;
import org.example.subscriptionmanagement.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @PostMapping
    public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription) {
        Subscription createdSubscription = subscriptionService.createSubscription(subscription);
        return ResponseEntity.ok(createdSubscription);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subscription> updateSubscription(
            @PathVariable Long id, @RequestBody Subscription subscription) {
        Subscription updatedSubscription = subscriptionService.updateSubscription(id, subscription);
        return ResponseEntity.ok(updatedSubscription);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
        return ResponseEntity.noContent().build();
    }
}
