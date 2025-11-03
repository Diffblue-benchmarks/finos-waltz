package org.finos.waltz.model.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableBackingEntity.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableBackingEntity.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBackingEntityDiffblueTest {
  /**
   * Test Builder {@link Builder#cellId(String)}.
   * <p>
   * Method under test: {@link Builder#cellId(String)}
   */
  @Test
  @DisplayName("Test Builder cellId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.cellId(String)"})
  void testBuilderCellId() {
    // Arrange
    Builder builderResult = ImmutableBackingEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cellId("42"));
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBackingEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(BackingEntity)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then builder build cellId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BackingEntity)}
   */
  @Test
  @DisplayName("Test Builder from(BackingEntity); given '42'; then builder build cellId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BackingEntity)"})
  void testBuilderFrom_given42_thenBuilderBuildCellIdIs42() {
    // Arrange
    Builder builderResult = ImmutableBackingEntity.builder();
    BackingEntity instance = mock(BackingEntity.class);
    when(instance.cellId()).thenReturn("42");
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellId();
    verify(instance).entityReference();
    assertEquals("42", builderResult.build().cellId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BackingEntity)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BackingEntity)}
   */
  @Test
  @DisplayName("Test Builder from(BackingEntity); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BackingEntity)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBackingEntity.builder();
    BackingEntity instance = mock(BackingEntity.class);
    when(instance.cellId()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).cellId();
    verify(instance).entityReference();
  }

  /**
   * Test Json {@link Json#cellId()}.
   * <p>
   * Method under test: {@link Json#cellId()}
   */
  @Test
  @DisplayName("Test Json cellId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.cellId()"})
  void testJsonCellId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).cellId());
  }

  /**
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReference());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCellId(String)}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCellId(String)",
      "void Json.setEntityReference(EntityReference)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCellId("42");
    actualJson.setEntityReference(null);

    // Assert
    assertEquals("42", actualJson.cellId);
    assertNull(actualJson.entityReference);
  }
}
