package org.finos.waltz.model.process_diagram;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagramEntity.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProcessDiagramEntityDiffblueTest {
  /**
   * Test {@link ProcessDiagramEntity#isNotable()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramEntity#isNotable()}
   */
  @Test
  @DisplayName("Test isNotable(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProcessDiagramEntity.isNotable()"})
  void testIsNotable_thenReturnFalse() {
    // Arrange
    Builder diagramIdResult = ImmutableProcessDiagramEntity.builder().diagramId(1L);

    // Act and Assert
    assertFalse(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .isNotable());
  }
}
