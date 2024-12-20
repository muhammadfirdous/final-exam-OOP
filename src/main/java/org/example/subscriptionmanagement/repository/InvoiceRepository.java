package org.example.subscriptionmanagement.repository;

import org.example.subscriptionmanagement.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
