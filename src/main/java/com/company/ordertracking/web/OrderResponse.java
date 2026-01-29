package com.company.ordertracking.web;

import com.company.ordertracking.entity.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class OrderResponse {
    public Long id;

    // Base fields (sensitive fields: customer/contact/payment/amount/unitPrice/currency)
    public String orderNo;
    public String currency;
    public String customerName;
    public String contact;
    public String paymentTerms;
    public BigDecimal totalAmount;

    public String productReq;
    public String packagingReq;

    public OrderStatus status;
    public LocalDateTime createdAt;

    public List<Item> items;

    // === Workflow sections (may be null) ===
    public ProductionPlan plan;
    public List<Material> materials;
    public List<Process> processes;
    public WarehouseReceipt warehouseReceipt;
    // Warehouse receipt stats (also available via /warehouse-receipt-stats)
    // public List<WarehouseReceiptStat> warehouseReceiptStats;
    public Shipment shipment;

    public static class Item {
        public Long id;
        public String productName;
        public String spec;
        public Integer quantity;
        public Double unitPrice; // sensitive
        public String notes;
    }

    public static class ProductionPlan {
        public Long id;
        public LocalDate plannedStartDate;
        public LocalDate plannedEndDate;
        public LocalDate plannedShipDate;
        public String note;
        public LocalDateTime updatedAt;
    }

    public static class Material {
        public Long id;
        public String materialName;
        public String procurementType; // EXTERNAL_PURCHASE / IN_STOCK
        public String note;
        public LocalDateTime createdAt;
    }

    public static class Process {
        public Long id;
        public String processName;
        public Integer targetQuantity;
        public Integer finishedQuantity;
        public String note;
        public LocalDateTime updatedAt;
    }

    public static class WarehouseReceipt {
        public Long id;
        public LocalDateTime receivedAt;
        public String receivedBy;
        public String note;
    }

    /**
     * Warehouse receipt: aggregated stats (grouped by order line item).
     */
    public static class WarehouseReceiptStat {
        public Long orderItemId;
        public String productName;
        public String spec;
        public Integer demandQty;
        public Integer receivedQty;
        public Integer remainingQty;
    }

    /**
     * Warehouse receipt: a single receipt record (header + items).
     */
    public static class WarehouseReceiptLog {
        public Long id;
        public LocalDateTime receivedAt;
        public String receivedBy;
        public String note;
        public List<WarehouseReceiptLogItem> items;
    }

    public static class WarehouseReceiptLogItem {
        public Long orderItemId;
        public String productName;
        public String spec;
        public Integer qty;
    }

    public static class Shipment {
        public Long id;
        public LocalDate plannedShipDate;
        public LocalDateTime shippedAt;
        public String confirmedBy;
        public String note;
        public LocalDateTime updatedAt;
    }
}
