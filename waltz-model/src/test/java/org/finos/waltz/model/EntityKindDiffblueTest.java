package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityKindDiffblueTest {
  /**
   * Test {@link EntityKind#prettyName()}.
   *
   * <p>Method under test: {@link EntityKind#prettyName()}
   */
  @Test
  @DisplayName("Test prettyName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EntityKind.prettyName()"})
  void testPrettyName() {
    // Arrange, Act and Assert
    assertEquals("All", EntityKind.valueOf("ALL").prettyName());
  }
}
