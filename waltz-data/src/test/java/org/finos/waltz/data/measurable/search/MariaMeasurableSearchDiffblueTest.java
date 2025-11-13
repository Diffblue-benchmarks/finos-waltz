package org.finos.waltz.data.measurable.search;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.util.ArrayList;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions.Builder;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MariaMeasurableSearchDiffblueTest {
  /**
   * Test {@link MariaMeasurableSearch#searchFullText(DSLContext, EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MariaMeasurableSearch#searchFullText(DSLContext,
   * EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test searchFullText(DSLContext, EntitySearchOptions); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List MariaMeasurableSearch.searchFullText(DSLContext, EntitySearchOptions)"
  })
  void testSearchFullText_thenReturnEmpty() {
    // Arrange
    MariaMeasurableSearch mariaMeasurableSearch = new MariaMeasurableSearch();
    DefaultDSLContext dsl = new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertTrue(
        mariaMeasurableSearch
            .searchFullText(
                dsl,
                builderResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .searchQuery("[")
                    .userId("42")
                    .build())
            .isEmpty());
  }
}
