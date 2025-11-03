package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bookmark.BookmarkKindValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WrapperDiffblueTest {
  /**
   * Test {@link Wrapper#toString()}.
   * <p>
   * Method under test: {@link Wrapper#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String Wrapper.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("42", BookmarkKindValue.of("42").toString());
  }
}
