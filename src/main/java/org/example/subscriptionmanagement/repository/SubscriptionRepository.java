package org.example.subscriptionmanagement.repository;

import org.example.subscriptionmanagement.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
