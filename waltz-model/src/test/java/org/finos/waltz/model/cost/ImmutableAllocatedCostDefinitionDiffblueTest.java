package org.finos.waltz.model.cost;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.junit.jupiter.api.Test;

class ImmutableAllocatedCostDefinitionDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAllocatedCostDefinition.Builder#allocationScheme(EntityReference)}
   */
  @Test
  void testBuilderAllocationScheme() {
    // Arrange
    ImmutableAllocatedCostDefinition.Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allocationScheme(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAllocatedCostDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAllocatedCostDefinition.Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableAllocatedCostDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocatedCostDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAllocatedCostDefinition.Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableAllocatedCostDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocatedCostDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAllocatedCostDefinition.Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableAllocatedCostDefinition.Builder#from(AllocatedCostDefinition)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAllocatedCostDefinition.Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    AllocatedCostDefinition instance = mock(AllocatedCostDefinition.class);
    when(instance.allocationScheme()).thenThrow(new IllegalStateException("instance"));
    when(instance.targetCostKind()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).allocationScheme();
    verify(instance).targetCostKind();
  }

  /**
   * Method under test:
   * {@link ImmutableAllocatedCostDefinition.Builder#from(AllocatedCostDefinition)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAllocatedCostDefinition.Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    AllocatedCostDefinition instance = mock(AllocatedCostDefinition.class);
    when(instance.sourceCostKind()).thenThrow(new IllegalStateException("instance"));
    when(instance.allocationScheme()).thenReturn(mock(EntityReference.class));
    when(instance.targetCostKind()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).allocationScheme();
    verify(instance).sourceCostKind();
    verify(instance).targetCostKind();
  }

  /**
   * Method under test:
   * {@link ImmutableAllocatedCostDefinition.Builder#from(AllocatedCostDefinition)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAllocatedCostDefinition.Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    AllocatedCostDefinition instance = mock(AllocatedCostDefinition.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.sourceCostKind()).thenReturn(mock(EntityReference.class));
    when(instance.allocationScheme()).thenReturn(mock(EntityReference.class));
    when(instance.targetCostKind()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableAllocatedCostDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).allocationScheme();
    verify(instance).sourceCostKind();
    verify(instance).targetCostKind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocatedCostDefinition.Builder#from(AllocatedCostDefinition)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableAllocatedCostDefinition.Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    AllocatedCostDefinition instance = mock(AllocatedCostDefinition.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.sourceCostKind()).thenReturn(mock(EntityReference.class));
    when(instance.allocationScheme()).thenReturn(mock(EntityReference.class));
    when(instance.targetCostKind()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableAllocatedCostDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).allocationScheme();
    verify(instance).sourceCostKind();
    verify(instance).targetCostKind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocatedCostDefinition.Builder#from(AllocatedCostDefinition)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableAllocatedCostDefinition.Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    AllocatedCostDefinition instance = mock(AllocatedCostDefinition.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.sourceCostKind()).thenReturn(mock(EntityReference.class));
    when(instance.allocationScheme()).thenReturn(mock(EntityReference.class));
    when(instance.targetCostKind()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).allocationScheme();
    verify(instance).sourceCostKind();
    verify(instance).targetCostKind();
  }

  /**
   * Method under test: {@link ImmutableAllocatedCostDefinition.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableAllocatedCostDefinition.Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAllocatedCostDefinition.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableAllocatedCostDefinition.Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableAllocatedCostDefinition.Builder#sourceCostKind(EntityReference)}
   */
  @Test
  void testBuilderSourceCostKind() {
    // Arrange
    ImmutableAllocatedCostDefinition.Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sourceCostKind(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAllocatedCostDefinition.Builder#targetCostKind(EntityReference)}
   */
  @Test
  void testBuilderTargetCostKind() {
    // Arrange
    ImmutableAllocatedCostDefinition.Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetCostKind(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAllocatedCostDefinition#copyOf(AllocatedCostDefinition)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AllocatedCostDefinition instance = mock(AllocatedCostDefinition.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.sourceCostKind()).thenReturn(mock(EntityReference.class));
    when(instance.allocationScheme()).thenReturn(mock(EntityReference.class));
    when(instance.targetCostKind()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableAllocatedCostDefinition.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).allocationScheme();
    verify(instance).sourceCostKind();
    verify(instance).targetCostKind();
  }

  /**
   * Method under test:
   * {@link ImmutableAllocatedCostDefinition#copyOf(AllocatedCostDefinition)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AllocatedCostDefinition instance = mock(AllocatedCostDefinition.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.sourceCostKind()).thenReturn(mock(EntityReference.class));
    when(instance.allocationScheme()).thenReturn(mock(EntityReference.class));
    when(instance.targetCostKind()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableAllocatedCostDefinition.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).allocationScheme();
    verify(instance).sourceCostKind();
    verify(instance).targetCostKind();
  }

  /**
   * Method under test:
   * {@link ImmutableAllocatedCostDefinition#fromJson(ImmutableAllocatedCostDefinition.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAllocatedCostDefinition.Json json = new ImmutableAllocatedCostDefinition.Json();
    json.setTargetCostKind(mock(EntityReference.class));
    json.setSourceCostKind(mock(EntityReference.class));
    json.setAllocationScheme(mock(EntityReference.class));

    // Act
    ImmutableAllocatedCostDefinition actualFromJsonResult = ImmutableAllocatedCostDefinition.fromJson(json);

    // Assert
    EntityReference expectedAllocationSchemeResult = json.allocationScheme;
    assertSame(expectedAllocationSchemeResult, actualFromJsonResult.allocationScheme());
    EntityReference expectedSourceCostKindResult = json.sourceCostKind;
    assertSame(expectedSourceCostKindResult, actualFromJsonResult.sourceCostKind());
    EntityReference expectedTargetCostKindResult = json.targetCostKind;
    assertSame(expectedTargetCostKindResult, actualFromJsonResult.targetCostKind());
  }

  /**
   * Method under test:
   * {@link ImmutableAllocatedCostDefinition.Json#allocationScheme()}
   */
  @Test
  void testJsonAllocationScheme() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAllocatedCostDefinition.Json()).allocationScheme());
  }

  /**
   * Method under test: {@link ImmutableAllocatedCostDefinition.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAllocatedCostDefinition.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAllocatedCostDefinition.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAllocatedCostDefinition.Json actualJson = new ImmutableAllocatedCostDefinition.Json();

    // Assert
    assertNull(actualJson.allocationScheme);
    assertNull(actualJson.sourceCostKind);
    assertNull(actualJson.targetCostKind);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableAllocatedCostDefinition.Json#sourceCostKind()}
   */
  @Test
  void testJsonSourceCostKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAllocatedCostDefinition.Json()).sourceCostKind());
  }

  /**
   * Method under test:
   * {@link ImmutableAllocatedCostDefinition.Json#targetCostKind()}
   */
  @Test
  void testJsonTargetCostKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAllocatedCostDefinition.Json()).targetCostKind());
  }
}
