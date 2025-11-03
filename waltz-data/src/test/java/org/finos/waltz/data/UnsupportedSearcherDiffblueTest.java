package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UnsupportedSearcherDiffblueTest {
  /**
   * Test {@link UnsupportedSearcher#searchFullText(DSLContext, EntitySearchOptions)}.
   * <p>
   * Method under test: {@link UnsupportedSearcher#searchFullText(DSLContext, EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test searchFullText(DSLContext, EntitySearchOptions)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List UnsupportedSearcher.searchFullText(DSLContext, EntitySearchOptions)"})
  void testSearchFullText() {
    // Arrange
    UnsupportedSearcher<Object> unsupportedSearcher = new UnsupportedSearcher<>(SQLDialect.SQL99);

    // Act and Assert
    assertTrue(
        unsupportedSearcher.searchFullText(new DefaultDSLContext(SQLDialect.SQL99), mock(EntitySearchOptions.class))
            .isEmpty());
  }
}
