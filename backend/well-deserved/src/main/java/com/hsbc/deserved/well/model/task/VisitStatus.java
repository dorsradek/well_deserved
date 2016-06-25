package com.hsbc.deserved.well.model.task;

import com.google.common.collect.ImmutableMap;

import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

public enum VisitStatus {

    VISITOR_WAITING, HOST_INFORMED, APPROVED_BY_HOST, REJECTED_BY_HOST, REJECTED_BY_VISITOR, HOST_CHANGED_ON_DEMAND, AUTO_HOST_CHANGED, FAILED;

    private static final Map<VisitStatus, Set<VisitStatus>> ALLOWED_TRANSITIONS = ImmutableMap.<VisitStatus, Set<VisitStatus>> builder()
            .put(VisitStatus.VISITOR_WAITING, EnumSet.allOf(VisitStatus.class))
            .put(HOST_INFORMED, EnumSet.complementOf(EnumSet.of(VisitStatus.VISITOR_WAITING)))
            .put(VisitStatus.APPROVED_BY_HOST, EnumSet.noneOf(VisitStatus.class))
            .put(VisitStatus.REJECTED_BY_HOST, EnumSet.noneOf(VisitStatus.class))
            .put(VisitStatus.REJECTED_BY_VISITOR, EnumSet.noneOf(VisitStatus.class))
            .put(VisitStatus.HOST_CHANGED_ON_DEMAND, EnumSet.noneOf(VisitStatus.class))
            .put(VisitStatus.AUTO_HOST_CHANGED, EnumSet.noneOf(VisitStatus.class))
            .put(VisitStatus.FAILED,EnumSet.noneOf(VisitStatus.class)).build();

    public boolean canTransferToStatus(VisitStatus targetStatus) {
        return ALLOWED_TRANSITIONS.get(this).contains(targetStatus);
    }
}