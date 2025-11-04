package org.finos.waltz.model.measurable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableHierarchyAlignmentDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchyAlignment.Builder#from(MeasurableHierarchyAlignment)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableHierarchyAlignment.Builder builderResult = ImmutableMeasurableHierarchyAlignment.builder();
    MeasurableHierarchyAlignment instance = mock(MeasurableHierarchyAlignment.class);
    when(instance.level()).thenReturn(1);
    when(instance.parentReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableMeasurableHierarchyAlignment.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).level();
    verify(instance).parentReference();
    assertEquals(1, actualFromResult.build().level().intValue());
    assertEquals(1, builderResult.build().level().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchyAlignment.Builder#from(MeasurableHierarchyAlignment)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableHierarchyAlignment.Builder builderResult = ImmutableMeasurableHierarchyAlignment.builder();
    MeasurableHierarchyAlignment instance = mock(MeasurableHierarchyAlignment.class);
    when(instance.level()).thenThrow(new IllegalStateException("instance"));
    when(instance.parentReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).level();
    verify(instance).parentReference();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchyAlignment.Builder#level(Integer)}
   */
  @Test
  void testBuilderLevel() {
    // Arrange
    ImmutableMeasurableHierarchyAlignment.Builder builderResult = ImmutableMeasurableHierarchyAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.level(1));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchyAlignment.Builder#parentReference(EntityReference)}
   */
  @Test
  void testBuilderParentReference() {
    // Arrange
    ImmutableMeasurableHierarchyAlignment.Builder builderResult = ImmutableMeasurableHierarchyAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchyAlignment#copyOf(MeasurableHierarchyAlignment)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableHierarchyAlignment instance = mock(MeasurableHierarchyAlignment.class);
    when(instance.level()).thenReturn(1);
    when(instance.parentReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableMeasurableHierarchyAlignment actualCopyOfResult = ImmutableMeasurableHierarchyAlignment.copyOf(instance);

    // Assert
    verify(instance).level();
    verify(instance).parentReference();
    assertEquals(1, actualCopyOfResult.level().intValue());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchyAlignment#fromJson(ImmutableMeasurableHierarchyAlignment.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableMeasurableHierarchyAlignment.Json json = new ImmutableMeasurableHierarchyAlignment.Json();
    json.setParentReference(mock(EntityReference.class));
    json.setLevel(1);

    // Act
    ImmutableMeasurableHierarchyAlignment actualFromJsonResult = ImmutableMeasurableHierarchyAlignment.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.level().intValue());
    EntityReference expectedParentReferenceResult = json.parentReference;
    assertSame(expectedParentReferenceResult, actualFromJsonResult.parentReference());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableMeasurableHierarchyAlignment.Json}
   *   <li>{@link ImmutableMeasurableHierarchyAlignment.Json#setLevel(Integer)}
   *   <li>
   * {@link ImmutableMeasurableHierarchyAlignment.Json#setParentReference(EntityReference)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableMeasurableHierarchyAlignment.Json actualJson = new ImmutableMeasurableHierarchyAlignment.Json();
    actualJson.setLevel(1);
    actualJson.setParentReference(null);

    // Assert
    assertEquals(1, actualJson.level.intValue());
  }

  /**
   * Method under test: {@link ImmutableMeasurableHierarchyAlignment.Json#level()}
   */
  @Test
  void testJsonLevel() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableHierarchyAlignment.Json()).level());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchyAlignment.Json#parentReference()}
   */
  @Test
  void testJsonParentReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableHierarchyAlignment.Json()).parentReference());
  }
}
