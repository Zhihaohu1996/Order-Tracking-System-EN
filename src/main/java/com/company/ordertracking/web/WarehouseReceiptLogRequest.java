package com.company.ordertracking.web;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Warehouse receipt logs: one submission writes one warehouse_receipt_log row plus multiple warehouse_receipt_log_item rows.
 */
public class WarehouseReceiptLogRequest {

    public LocalDateTime receivedAt; // optional, default now
    public String receivedBy;
    public String note;

    @Valid
    public List<Item> items;

    public static class Item {
        @NotNull
        public Long orderItemId;

        @NotNull
        public Integer qty;
    }
}
