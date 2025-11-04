package org.finos.waltz.model.physical_specification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecificationDeleteCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationDeleteCommand.Builder#from(PhysicalSpecificationDeleteCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalSpecificationDeleteCommand.Builder builderResult = ImmutablePhysicalSpecificationDeleteCommand
        .builder();
    PhysicalSpecificationDeleteCommand instance = mock(PhysicalSpecificationDeleteCommand.class);
    when(instance.specificationId()).thenReturn(1L);

    // Act
    ImmutablePhysicalSpecificationDeleteCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).specificationId();
    assertEquals(1L, actualFromResult.build().specificationId());
    assertEquals(1L, builderResult.build().specificationId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationDeleteCommand.Builder#specificationId(long)}
   */
  @Test
  void testBuilderSpecificationId() {
    // Arrange
    ImmutablePhysicalSpecificationDeleteCommand.Builder builderResult = ImmutablePhysicalSpecificationDeleteCommand
        .builder();

    // Act
    ImmutablePhysicalSpecificationDeleteCommand.Builder actualSpecificationIdResult = builderResult.specificationId(1L);

    // Assert
    assertEquals(1L, actualSpecificationIdResult.build().specificationId());
    assertEquals(1L, builderResult.build().specificationId());
    assertSame(builderResult, actualSpecificationIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationDeleteCommand#copyOf(PhysicalSpecificationDeleteCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalSpecificationDeleteCommand instance = mock(PhysicalSpecificationDeleteCommand.class);
    when(instance.specificationId()).thenReturn(1L);

    // Act
    ImmutablePhysicalSpecificationDeleteCommand actualCopyOfResult = ImmutablePhysicalSpecificationDeleteCommand
        .copyOf(instance);

    // Assert
    verify(instance).specificationId();
    assertEquals(1L, actualCopyOfResult.specificationId());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePhysicalSpecificationDeleteCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePhysicalSpecificationDeleteCommand.Json actualJson = new ImmutablePhysicalSpecificationDeleteCommand.Json();

    // Assert
    assertEquals(0L, actualJson.specificationId);
    assertFalse(actualJson.specificationIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationDeleteCommand.Json#setSpecificationId(long)}
   */
  @Test
  void testJsonSetSpecificationId() {
    // Arrange
    ImmutablePhysicalSpecificationDeleteCommand.Json json = new ImmutablePhysicalSpecificationDeleteCommand.Json();

    // Act
    json.setSpecificationId(1L);

    // Assert
    assertEquals(1L, json.specificationId);
    assertTrue(json.specificationIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationDeleteCommand.Json#specificationId()}
   */
  @Test
  void testJsonSpecificationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecificationDeleteCommand.Json()).specificationId());
  }
}
