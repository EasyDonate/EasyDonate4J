package ru.easydonate.easydonate4j.v3.data.model;

import org.jetbrains.annotations.NotNull;

public interface Sorted extends Comparable<Sorted> {

    int getSortIndex();

    @Override
    default int compareTo(@NotNull Sorted other) {
        return Integer.compare(getSortIndex(), other.getSortIndex());
    }

}
