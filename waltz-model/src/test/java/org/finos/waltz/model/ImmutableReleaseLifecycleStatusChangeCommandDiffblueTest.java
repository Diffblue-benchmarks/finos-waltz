package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableReleaseLifecycleStatusChangeCommand.Builder;
import org.finos.waltz.model.ImmutableReleaseLifecycleStatusChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReleaseLifecycleStatusChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(ReleaseLifecycleStatusChangeCommand)}.
   * <ul>
   *   <li>Given {@code DRAFT}.</li>
   *   <li>Then builder build newStatus is {@code DRAFT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ReleaseLifecycleStatusChangeCommand); given 'DRAFT'; then builder build newStatus is 'DRAFT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReleaseLifecycleStatusChangeCommand)"})
  void testBuilderFrom_givenDraft_thenBuilderBuildNewStatusIsDraft() {
    // Arrange
    Builder builderResult = ImmutableReleaseLifecycleStatusChangeCommand.builder();
    ReleaseLifecycleStatusChangeCommand instance = mock(ReleaseLifecycleStatusChangeCommand.class);
    when(instance.newStatus()).thenReturn(ReleaseLifecycleStatus.DRAFT);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newStatus();
    assertEquals(ReleaseLifecycleStatus.DRAFT, builderResult.build().newStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newStatus(ReleaseLifecycleStatus)}.
   * <p>
   * Method under test: {@link Builder#newStatus(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder newStatus(ReleaseLifecycleStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.newStatus(ReleaseLifecycleStatus)"})
  void testBuilderNewStatus() {
    // Arrange
    Builder builderResult = ImmutableReleaseLifecycleStatusChangeCommand.builder();

    // Act
    Builder actualNewStatusResult = builderResult.newStatus(ReleaseLifecycleStatus.DRAFT);

    // Assert
    assertEquals(ReleaseLifecycleStatus.DRAFT, builderResult.build().newStatus());
    assertSame(builderResult, actualNewStatusResult);
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setNewStatus(ReleaseLifecycleStatus)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setNewStatus(ReleaseLifecycleStatus)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setNewStatus(ReleaseLifecycleStatus.DRAFT);

    // Assert
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualJson.newStatus);
  }

  /**
   * Test Json {@link Json#newStatus()}.
   * <p>
   * Method under test: {@link Json#newStatus()}
   */
  @Test
  @DisplayName("Test Json newStatus()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReleaseLifecycleStatus Json.newStatus()"})
  void testJsonNewStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).newStatus());
  }
}
