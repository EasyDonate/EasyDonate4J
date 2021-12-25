package ru.easydonate.easydonate4j.api.v3.data.model;

import org.jetbrains.annotations.NotNull;

/**
 * The interface that describes any items sorted by index and which has this index.
 * @author soknight
 */
public interface Sorted extends Comparable<Sorted> {

    /**
     * Get the sort index of this item.
     * @return The item sort index.
     */
    int getSortIndex();

    @Override
    default int compareTo(@NotNull Sorted other) {
        return Integer.compare(getSortIndex(), other.getSortIndex());
    }

}
