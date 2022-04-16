/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableList$Builder
 *  com.google.common.collect.ImmutableSet
 *  com.google.common.collect.ImmutableSet$Builder
 *  javax.annotation.Nullable
 */
package me.axua.impactplus.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import javax.annotation.Nullable;

public class Immutables {
    public static <T> List<T> copyToList(@Nullable Collection<T> llllllllllllllllIllIIllllIlIIllI) {
        if (llllllllllllllllIllIIllllIlIIllI == null || llllllllllllllllIllIIllllIlIIllI.isEmpty()) {
            return Collections.emptyList();
        }
        if (llllllllllllllllIllIIllllIlIIllI instanceof ImmutableList) {
            return (List)llllllllllllllllIllIIllllIlIIllI;
        }
        if (llllllllllllllllIllIIllllIlIIllI.size() == 1) {
            return Collections.singletonList(llllllllllllllllIllIIllllIlIIllI.iterator().next());
        }
        return ImmutableList.copyOf(llllllllllllllllIllIIllllIlIIllI);
    }

    public static <T> Collector<T, ImmutableList.Builder<T>, ImmutableList<T>> toImmutableList() {
        return new ImmutableListCollector();
    }

    public Immutables() {
        Immutables llllllllllllllllIllIIllllIlIllll;
    }

    public static <T> Set<T> copyToSet(@Nullable Collection<T> llllllllllllllllIllIIllllIIllllI) {
        if (llllllllllllllllIllIIllllIIllllI == null || llllllllllllllllIllIIllllIIllllI.isEmpty()) {
            return Collections.emptySet();
        }
        if (llllllllllllllllIllIIllllIIllllI.size() == 1) {
            return Collections.singleton(llllllllllllllllIllIIllllIIllllI.iterator().next());
        }
        return ImmutableSet.copyOf(llllllllllllllllIllIIllllIIllllI);
    }

    public static <T> Collector<T, ImmutableSet.Builder<T>, ImmutableSet<T>> toImmutableSet() {
        return new ImmutableSetCollector();
    }

    private static class ImmutableSetCollector<E>
    implements Collector<E, ImmutableSet.Builder<E>, ImmutableSet<E>> {
        @Override
        public Function<ImmutableSet.Builder<E>, ImmutableSet<E>> finisher() {
            return ImmutableSet.Builder::build;
        }

        @Override
        public BiConsumer<ImmutableSet.Builder<E>, E> accumulator() {
            return ImmutableSet.Builder::add;
        }

        @Override
        public BinaryOperator<ImmutableSet.Builder<E>> combiner() {
            return (lllllllllllllllIlllIllllIlllIlIl, lllllllllllllllIlllIllllIlllIllI) -> {
                lllllllllllllllIlllIllllIlllIlIl.addAll((Iterable)lllllllllllllllIlllIllllIlllIllI.build());
                return lllllllllllllllIlllIllllIlllIlIl;
            };
        }

        private ImmutableSetCollector() {
            ImmutableSetCollector lllllllllllllllIlllIlllllIIIIIII;
        }

        @Override
        public Supplier<ImmutableSet.Builder<E>> supplier() {
            return ImmutableSet::builder;
        }

        @Override
        public Set<Collector.Characteristics> characteristics() {
            return EnumSet.of(Collector.Characteristics.UNORDERED);
        }
    }

    private static class ImmutableListCollector<E>
    implements Collector<E, ImmutableList.Builder<E>, ImmutableList<E>> {
        @Override
        public Supplier<ImmutableList.Builder<E>> supplier() {
            return ImmutableList::builder;
        }

        @Override
        public Function<ImmutableList.Builder<E>, ImmutableList<E>> finisher() {
            return ImmutableList.Builder::build;
        }

        private ImmutableListCollector() {
            ImmutableListCollector lIlllIllllIllll;
        }

        @Override
        public BiConsumer<ImmutableList.Builder<E>, E> accumulator() {
            return ImmutableList.Builder::add;
        }

        @Override
        public Set<Collector.Characteristics> characteristics() {
            return Collections.emptySet();
        }

        @Override
        public BinaryOperator<ImmutableList.Builder<E>> combiner() {
            return (lIlllIllllIIlll, lIlllIllllIIllI) -> {
                lIlllIllllIIlll.addAll((Iterable)lIlllIllllIIllI.build());
                return lIlllIllllIIlll;
            };
        }
    }
}

