package org.example.subscriptionmanagement.service;

import org.example.subscriptionmanagement.entity.Subscription;
import org.example.subscriptionmanagement.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public Subscription updateSubscription(Long id, Subscription updatedSubscription) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));
        subscription.setTier(updatedSubscription.getTier());
        subscription.setPrice(updatedSubscription.getPrice());
        subscription.setStartDate(updatedSubscription.getStartDate());
        subscription.setEndDate(updatedSubscription.getEndDate());
        return subscriptionRepository.save(subscription);
    }

    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }

    public Subscription updateSubscription(Long id, String tier, Double price) {
        return null;
    }

    public Subscription createSubscription(Long userId, String tier, Double price) {
        return null;
    }
}
