package org.finos.waltz.web;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MainDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Main}
   *   <li>{@link Main#getSpringContext()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Main.<init>()",
    "org.springframework.context.annotation.AnnotationConfigApplicationContext Main.getSpringContext()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull(new Main().getSpringContext());
  }
}
