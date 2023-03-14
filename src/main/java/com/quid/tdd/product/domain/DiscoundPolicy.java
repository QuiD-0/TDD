package com.quid.tdd.product.domain;

public enum DiscoundPolicy {
    NONE(0L), FIVE_PERCENT(5L), TEN_PERCENT(10L), TWENTY_PERCENT(20L);

    private Long discountRate;

    DiscoundPolicy(Long discountRate) {
        this.discountRate = discountRate;
    }

    public Double getDiscountRate() {
        return (100 - discountRate) * 0.01;
    }
}
