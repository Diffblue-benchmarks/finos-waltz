package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;

class UnsupportedSearcherDiffblueTest {
  /**
   * Method under test:
   * {@link UnsupportedSearcher#searchFullText(DSLContext, EntitySearchOptions)}
   */
  @Test
  void testSearchFullText() {
    // Arrange
    UnsupportedSearcher<Object> unsupportedSearcher = new UnsupportedSearcher<>(SQLDialect.SQL99);

    // Act and Assert
    assertTrue(
        unsupportedSearcher.searchFullText(new DefaultDSLContext(SQLDialect.SQL99), mock(EntitySearchOptions.class))
            .isEmpty());
  }
}
