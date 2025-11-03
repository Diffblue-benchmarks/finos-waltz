package org.finos.waltz.model.measurable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.measurable.ImmutableMeasurableHierarchyAlignment.Builder;
import org.finos.waltz.model.measurable.ImmutableMeasurableHierarchyAlignment.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableHierarchyAlignmentDiffblueTest {
  /**
   * Test Builder {@link Builder#from(MeasurableHierarchyAlignment)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build level intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableHierarchyAlignment)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableHierarchyAlignment); given one; then builder build level intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableHierarchyAlignment)"})
  void testBuilderFrom_givenOne_thenBuilderBuildLevelIntValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchyAlignment.builder();
    MeasurableHierarchyAlignment instance = mock(MeasurableHierarchyAlignment.class);
    when(instance.level()).thenReturn(1);
    when(instance.parentReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).level();
    verify(instance).parentReference();
    assertEquals(1, builderResult.build().level().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableHierarchyAlignment)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableHierarchyAlignment)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableHierarchyAlignment); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableHierarchyAlignment)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchyAlignment.builder();
    MeasurableHierarchyAlignment instance = mock(MeasurableHierarchyAlignment.class);
    when(instance.level()).thenThrow(new IllegalStateException("instance"));
    when(instance.parentReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).level();
    verify(instance).parentReference();
  }

  /**
   * Test Builder {@link Builder#level(Integer)}.
   * <p>
   * Method under test: {@link Builder#level(Integer)}
   */
  @Test
  @DisplayName("Test Builder level(Integer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.level(Integer)"})
  void testBuilderLevel() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchyAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.level(1));
  }

  /**
   * Test Builder {@link Builder#parentReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parentReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder parentReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentReference(EntityReference)"})
  void testBuilderParentReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchyAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentReference(mock(EntityReference.class)));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setLevel(Integer)}
   *   <li>{@link Json#setParentReference(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setLevel(Integer)",
      "void Json.setParentReference(EntityReference)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setLevel(1);
    actualJson.setParentReference(null);

    // Assert
    assertEquals(1, actualJson.level.intValue());
  }

  /**
   * Test Json {@link Json#level()}.
   * <p>
   * Method under test: {@link Json#level()}
   */
  @Test
  @DisplayName("Test Json level()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer Json.level()"})
  void testJsonLevel() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).level());
  }

  /**
   * Test Json {@link Json#parentReference()}.
   * <p>
   * Method under test: {@link Json#parentReference()}
   */
  @Test
  @DisplayName("Test Json parentReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.parentReference()"})
  void testJsonParentReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parentReference());
  }
}
