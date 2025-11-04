package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.allocation.Allocation;
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.junit.jupiter.api.Test;

class ImmutableAllocationsViewDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAllocationsView.Builder#addAllAllocationSchemes(Iterable)}
   */
  @Test
  void testBuilderAddAllAllocationSchemes() {
    // Arrange
    ImmutableAllocationsView.Builder builderResult = ImmutableAllocationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAllocationSchemes(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationsView.Builder#addAllAllocations(Iterable)}
   */
  @Test
  void testBuilderAddAllAllocations() {
    // Arrange
    ImmutableAllocationsView.Builder builderResult = ImmutableAllocationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAllocations(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationsView.Builder#addAllocationSchemes(AllocationScheme)}
   */
  @Test
  void testBuilderAddAllocationSchemes() {
    // Arrange
    ImmutableAllocationsView.Builder builderResult = ImmutableAllocationsView.builder();

    // Act
    ImmutableAllocationsView.Builder actualAddAllocationSchemesResult = builderResult
        .addAllocationSchemes(mock(AllocationScheme.class));

    // Assert
    assertEquals(1, builderResult.build().allocationSchemes().size());
    assertSame(builderResult, actualAddAllocationSchemesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationsView.Builder#addAllocationSchemes(AllocationScheme[])}
   */
  @Test
  void testBuilderAddAllocationSchemes2() {
    // Arrange
    ImmutableAllocationsView.Builder builderResult = ImmutableAllocationsView.builder();

    // Act
    ImmutableAllocationsView.Builder actualAddAllocationSchemesResult = builderResult
        .addAllocationSchemes(mock(AllocationScheme.class));

    // Assert
    assertEquals(1, builderResult.build().allocationSchemes().size());
    assertSame(builderResult, actualAddAllocationSchemesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationsView.Builder#addAllocations(Allocation)}
   */
  @Test
  void testBuilderAddAllocations() {
    // Arrange
    ImmutableAllocationsView.Builder builderResult = ImmutableAllocationsView.builder();

    // Act
    ImmutableAllocationsView.Builder actualAddAllocationsResult = builderResult.addAllocations(mock(Allocation.class));

    // Assert
    assertEquals(1, builderResult.build().allocations().size());
    assertSame(builderResult, actualAddAllocationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationsView.Builder#addAllocations(Allocation[])}
   */
  @Test
  void testBuilderAddAllocations2() {
    // Arrange
    ImmutableAllocationsView.Builder builderResult = ImmutableAllocationsView.builder();

    // Act
    ImmutableAllocationsView.Builder actualAddAllocationsResult = builderResult.addAllocations(mock(Allocation.class));

    // Assert
    assertEquals(1, builderResult.build().allocations().size());
    assertSame(builderResult, actualAddAllocationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationsView.Builder#allocationSchemes(Iterable)}
   */
  @Test
  void testBuilderAllocationSchemes() {
    // Arrange
    ImmutableAllocationsView.Builder builderResult = ImmutableAllocationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allocationSchemes(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationsView.Builder#allocations(Iterable)}
   */
  @Test
  void testBuilderAllocations() {
    // Arrange
    ImmutableAllocationsView.Builder builderResult = ImmutableAllocationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allocations(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableAllocationsView.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableAllocationsView.builder().build().allocationSchemes().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationsView.Builder#from(AllocationsView)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAllocationsView.Builder builderResult = ImmutableAllocationsView.builder();
    AllocationsView instance = mock(AllocationsView.class);
    when(instance.allocationSchemes()).thenReturn(new HashSet<>());
    when(instance.allocations()).thenReturn(new HashSet<>());

    // Act
    ImmutableAllocationsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationsView.Builder#from(AllocationsView)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAllocationsView.Builder builderResult = ImmutableAllocationsView.builder();

    HashSet<AllocationScheme> allocationSchemeSet = new HashSet<>();
    allocationSchemeSet.add(mock(AllocationScheme.class));
    AllocationsView instance = mock(AllocationsView.class);
    when(instance.allocationSchemes()).thenReturn(allocationSchemeSet);
    when(instance.allocations()).thenReturn(new HashSet<>());

    // Act
    ImmutableAllocationsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    assertEquals(1, builderResult.build().allocationSchemes().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationsView.Builder#from(AllocationsView)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAllocationsView.Builder builderResult = ImmutableAllocationsView.builder();

    HashSet<Allocation> allocationSet = new HashSet<>();
    allocationSet.add(mock(Allocation.class));
    AllocationsView instance = mock(AllocationsView.class);
    when(instance.allocationSchemes()).thenReturn(new HashSet<>());
    when(instance.allocations()).thenReturn(allocationSet);

    // Act
    ImmutableAllocationsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    assertEquals(1, builderResult.build().allocations().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAllocationsView#copyOf(AllocationsView)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AllocationsView instance = mock(AllocationsView.class);
    when(instance.allocationSchemes()).thenReturn(new HashSet<>());
    when(instance.allocations()).thenReturn(new HashSet<>());

    // Act
    ImmutableAllocationsView actualCopyOfResult = ImmutableAllocationsView.copyOf(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    Set<AllocationScheme> allocationSchemesResult = actualCopyOfResult.allocationSchemes();
    assertTrue(allocationSchemesResult.isEmpty());
    assertSame(allocationSchemesResult, actualCopyOfResult.allocations());
  }

  /**
   * Method under test: {@link ImmutableAllocationsView#copyOf(AllocationsView)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AllocationScheme> allocationSchemeSet = new HashSet<>();
    allocationSchemeSet.add(mock(AllocationScheme.class));
    AllocationsView instance = mock(AllocationsView.class);
    when(instance.allocationSchemes()).thenReturn(allocationSchemeSet);
    when(instance.allocations()).thenReturn(new HashSet<>());

    // Act
    ImmutableAllocationsView actualCopyOfResult = ImmutableAllocationsView.copyOf(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    assertEquals(1, actualCopyOfResult.allocationSchemes().size());
    assertTrue(actualCopyOfResult.allocations().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableAllocationsView#copyOf(AllocationsView)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AllocationScheme> allocationSchemeSet = new HashSet<>();
    allocationSchemeSet.add(mock(AllocationScheme.class));
    allocationSchemeSet.add(mock(AllocationScheme.class));
    AllocationsView instance = mock(AllocationsView.class);
    when(instance.allocationSchemes()).thenReturn(allocationSchemeSet);
    when(instance.allocations()).thenReturn(new HashSet<>());

    // Act
    ImmutableAllocationsView actualCopyOfResult = ImmutableAllocationsView.copyOf(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    assertTrue(actualCopyOfResult.allocations().isEmpty());
    assertEquals(allocationSchemeSet, actualCopyOfResult.allocationSchemes());
  }

  /**
   * Method under test: {@link ImmutableAllocationsView#copyOf(AllocationsView)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<Allocation> allocationSet = new HashSet<>();
    allocationSet.add(mock(Allocation.class));
    AllocationsView instance = mock(AllocationsView.class);
    when(instance.allocationSchemes()).thenReturn(new HashSet<>());
    when(instance.allocations()).thenReturn(allocationSet);

    // Act
    ImmutableAllocationsView actualCopyOfResult = ImmutableAllocationsView.copyOf(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    assertEquals(1, actualCopyOfResult.allocations().size());
    assertTrue(actualCopyOfResult.allocationSchemes().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationsView#fromJson(ImmutableAllocationsView.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAllocationsView.Json json = new ImmutableAllocationsView.Json();

    // Act
    ImmutableAllocationsView actualFromJsonResult = ImmutableAllocationsView.fromJson(json);

    // Assert
    Set<AllocationScheme> allocationSchemesResult = actualFromJsonResult.allocationSchemes();
    assertTrue(allocationSchemesResult.isEmpty());
    Set<Allocation> allocationSet = json.allocations;
    assertSame(allocationSet, allocationSchemesResult);
    assertSame(allocationSet, actualFromJsonResult.allocations());
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationsView#fromJson(ImmutableAllocationsView.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableAllocationsView.Json json = new ImmutableAllocationsView.Json();
    json.setAllocationSchemes(null);
    json.setAllocations(null);

    // Act
    ImmutableAllocationsView actualFromJsonResult = ImmutableAllocationsView.fromJson(json);

    // Assert
    Set<AllocationScheme> allocationSchemesResult = actualFromJsonResult.allocationSchemes();
    assertTrue(allocationSchemesResult.isEmpty());
    assertSame(allocationSchemesResult, actualFromJsonResult.allocations());
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationsView#fromJson(ImmutableAllocationsView.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<Allocation> allocations = new LinkedHashSet<>();
    allocations.add(mock(Allocation.class));

    ImmutableAllocationsView.Json json = new ImmutableAllocationsView.Json();
    json.setAllocationSchemes(null);
    json.setAllocations(allocations);

    // Act
    ImmutableAllocationsView actualFromJsonResult = ImmutableAllocationsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.allocations().size());
    assertTrue(actualFromJsonResult.allocationSchemes().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationsView#fromJson(ImmutableAllocationsView.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<AllocationScheme> allocationSchemes = new LinkedHashSet<>();
    allocationSchemes.add(mock(AllocationScheme.class));

    ImmutableAllocationsView.Json json = new ImmutableAllocationsView.Json();
    json.setAllocationSchemes(allocationSchemes);
    json.setAllocations(null);

    // Act
    ImmutableAllocationsView actualFromJsonResult = ImmutableAllocationsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.allocationSchemes().size());
    assertTrue(actualFromJsonResult.allocations().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableAllocationsView.Json#allocationSchemes()}
   */
  @Test
  void testJsonAllocationSchemes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAllocationsView.Json()).allocationSchemes());
  }

  /**
   * Method under test: {@link ImmutableAllocationsView.Json#allocations()}
   */
  @Test
  void testJsonAllocations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAllocationsView.Json()).allocations());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAllocationsView.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAllocationsView.Json actualJson = new ImmutableAllocationsView.Json();

    // Assert
    assertTrue(actualJson.allocationSchemes.isEmpty());
    assertTrue(actualJson.allocations.isEmpty());
  }
}
