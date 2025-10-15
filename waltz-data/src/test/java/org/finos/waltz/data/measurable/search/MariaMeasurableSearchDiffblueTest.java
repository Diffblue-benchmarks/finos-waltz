package org.finos.waltz.data.measurable.search;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.util.List;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.measurable.Measurable;
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
   *   <li>Given {@code [}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MariaMeasurableSearch#searchFullText(DSLContext,
   * EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test searchFullText(DSLContext, EntitySearchOptions); given '['; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MariaMeasurableSearch.searchFullText(DSLContext, EntitySearchOptions)"})
  void testSearchFullText_givenLeftSquareBracket_thenReturnEmpty() {
    // Arrange
    MariaMeasurableSearch mariaMeasurableSearch = new MariaMeasurableSearch();
    DefaultDSLContext dsl = new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.searchQuery()).thenReturn("[");

    // Act
    List<Measurable> actualSearchFullTextResult =
        mariaMeasurableSearch.searchFullText(dsl, options);

    // Assert
    verify(options).searchQuery();
    assertTrue(actualSearchFullTextResult.isEmpty());
  }
}
