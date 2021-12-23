package ru.easydonate.easydonate4j.testing.api.v3.ordering;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.ClassDescriptor;

import java.util.Comparator;
import java.util.Optional;

public final class TestClassesComparator implements Comparator<ClassDescriptor> {

    @Override
    public int compare(@NotNull ClassDescriptor first, @NotNull ClassDescriptor second) {
        Optional<TestClassesOrder> firstOrder = first.findAnnotation(TestClassesOrder.class);
        Optional<TestClassesOrder> secondOrder = second.findAnnotation(TestClassesOrder.class);

        boolean firstHasOrder = firstOrder.isPresent();
        boolean secondHasOrder = secondOrder.isPresent();

        if(firstHasOrder) {
            if(secondHasOrder) {
                return Integer.compare(firstOrder.get().value(), secondOrder.get().value());
            } else {
                return -1;
            }
        } else {
            if(secondHasOrder) {
                return 1;
            } else {
                return 0;
            }
        }
    }

}
