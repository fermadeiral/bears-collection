/* Copyright (C) 2013-2018 TU Dortmund
 * This file is part of AutomataLib, http://www.automatalib.net/.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.automatalib.graphs.concepts;

import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * A Kripke interpretation for a graph. A Kripke interpretation assigns to each node a set of so-called <i>atomic
 * propositions</i>.
 *
 * @param <N>
 *         node class
 * @param <AP>
 *         atomic proposition class
 *
 * @author Malte Isberner
 */
@ParametersAreNonnullByDefault
public interface KripkeInterpretation<N, AP> {

    /**
     * Retrieves the atomic propositions holding at the given node.
     *
     * @param node
     *         the node
     *
     * @return the set of atomic propositions that hold at the given node
     */
    @Nonnull
    Set<AP> getAtomicPropositions(N node);
}