package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.finos.waltz.model.bookmark.BookmarkKindValue;
import org.junit.jupiter.api.Test;

class WrapperDiffblueTest {
  /**
   * Method under test: {@link Wrapper#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("42", BookmarkKindValue.of("42").toString());
  }
}
