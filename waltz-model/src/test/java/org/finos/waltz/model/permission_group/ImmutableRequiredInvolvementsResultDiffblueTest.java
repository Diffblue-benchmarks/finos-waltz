package org.finos.waltz.model.permission_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import org.junit.jupiter.api.Test;

class ImmutableRequiredInvolvementsResultDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableRequiredInvolvementsResult.Builder#addAllRequiredInvolvementKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllRequiredInvolvementKindIds() {
    // Arrange
    ImmutableRequiredInvolvementsResult.Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRequiredInvolvementKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableRequiredInvolvementsResult.Builder#addAllRequiredInvolvementKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllRequiredInvolvementKindIds2() {
    // Arrange
    ImmutableRequiredInvolvementsResult.Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRequiredInvolvementKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableRequiredInvolvementsResult.Builder#addRequiredInvolvementKindIds(long)}
   */
  @Test
  void testBuilderAddRequiredInvolvementKindIds() {
    // Arrange
    ImmutableRequiredInvolvementsResult.Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRequiredInvolvementKindIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableRequiredInvolvementsResult.Builder#addRequiredInvolvementKindIds(long[])}
   */
  @Test
  void testBuilderAddRequiredInvolvementKindIds2() {
    // Arrange
    ImmutableRequiredInvolvementsResult.Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRequiredInvolvementKindIds(1L, -2L, 1L, -2L));
  }

  /**
   * Method under test:
   * {@link ImmutableRequiredInvolvementsResult.Builder#areAllUsersAllowed(boolean)}
   */
  @Test
  void testBuilderAreAllUsersAllowed() {
    // Arrange
    ImmutableRequiredInvolvementsResult.Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    // Act
    ImmutableRequiredInvolvementsResult.Builder actualAreAllUsersAllowedResult = builderResult.areAllUsersAllowed(true);

    // Assert
    assertTrue(builderResult.build().areAllUsersAllowed());
    assertSame(builderResult, actualAreAllUsersAllowedResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRequiredInvolvementsResult.Builder#from(RequiredInvolvementsResult)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableRequiredInvolvementsResult.Builder builderResult = ImmutableRequiredInvolvementsResult.builder();
    RequiredInvolvementsResult instance = mock(RequiredInvolvementsResult.class);
    when(instance.areAllUsersAllowed()).thenReturn(true);
    when(instance.requiredInvolvementKindIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableRequiredInvolvementsResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).areAllUsersAllowed();
    verify(instance).requiredInvolvementKindIds();
    assertTrue(builderResult.build().areAllUsersAllowed());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRequiredInvolvementsResult.Builder#from(RequiredInvolvementsResult)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableRequiredInvolvementsResult.Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(12L);
    RequiredInvolvementsResult instance = mock(RequiredInvolvementsResult.class);
    when(instance.areAllUsersAllowed()).thenReturn(true);
    when(instance.requiredInvolvementKindIds()).thenReturn(resultLongSet);

    // Act
    ImmutableRequiredInvolvementsResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).areAllUsersAllowed();
    verify(instance).requiredInvolvementKindIds();
    ImmutableRequiredInvolvementsResult buildResult = builderResult.build();
    Set<Long> requiredInvolvementKindIdsResult = buildResult.requiredInvolvementKindIds();
    assertEquals(1, requiredInvolvementKindIdsResult.size());
    assertTrue(requiredInvolvementKindIdsResult.contains(12L));
    assertTrue(buildResult.areAllUsersAllowed());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRequiredInvolvementsResult.Builder#requiredInvolvementKindIds(Iterable)}
   */
  @Test
  void testBuilderRequiredInvolvementKindIds() {
    // Arrange
    ImmutableRequiredInvolvementsResult.Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.requiredInvolvementKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableRequiredInvolvementsResult.Builder#requiredInvolvementKindIds(Iterable)}
   */
  @Test
  void testBuilderRequiredInvolvementKindIds2() {
    // Arrange
    ImmutableRequiredInvolvementsResult.Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.requiredInvolvementKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableRequiredInvolvementsResult#copyOf(RequiredInvolvementsResult)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    RequiredInvolvementsResult instance = mock(RequiredInvolvementsResult.class);
    when(instance.areAllUsersAllowed()).thenReturn(true);
    when(instance.requiredInvolvementKindIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableRequiredInvolvementsResult actualCopyOfResult = ImmutableRequiredInvolvementsResult.copyOf(instance);

    // Assert
    verify(instance).areAllUsersAllowed();
    verify(instance).requiredInvolvementKindIds();
    assertTrue(actualCopyOfResult.requiredInvolvementKindIds().isEmpty());
    assertTrue(actualCopyOfResult.areAllUsersAllowed());
  }

  /**
   * Method under test:
   * {@link ImmutableRequiredInvolvementsResult#copyOf(RequiredInvolvementsResult)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    RequiredInvolvementsResult instance = mock(RequiredInvolvementsResult.class);
    when(instance.areAllUsersAllowed()).thenReturn(true);
    when(instance.requiredInvolvementKindIds()).thenReturn(resultLongSet);

    // Act
    ImmutableRequiredInvolvementsResult actualCopyOfResult = ImmutableRequiredInvolvementsResult.copyOf(instance);

    // Assert
    verify(instance).areAllUsersAllowed();
    verify(instance).requiredInvolvementKindIds();
    Set<Long> requiredInvolvementKindIdsResult = actualCopyOfResult.requiredInvolvementKindIds();
    assertEquals(1, requiredInvolvementKindIdsResult.size());
    assertTrue(requiredInvolvementKindIdsResult.contains(1L));
    assertTrue(actualCopyOfResult.areAllUsersAllowed());
  }

  /**
   * Method under test:
   * {@link ImmutableRequiredInvolvementsResult#copyOf(RequiredInvolvementsResult)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(12L);
    resultLongSet.add(1L);
    RequiredInvolvementsResult instance = mock(RequiredInvolvementsResult.class);
    when(instance.areAllUsersAllowed()).thenReturn(true);
    when(instance.requiredInvolvementKindIds()).thenReturn(resultLongSet);

    // Act
    ImmutableRequiredInvolvementsResult actualCopyOfResult = ImmutableRequiredInvolvementsResult.copyOf(instance);

    // Assert
    verify(instance).areAllUsersAllowed();
    verify(instance).requiredInvolvementKindIds();
    assertTrue(actualCopyOfResult.areAllUsersAllowed());
    assertEquals(resultLongSet, actualCopyOfResult.requiredInvolvementKindIds());
  }

  /**
   * Method under test:
   * {@link ImmutableRequiredInvolvementsResult.Json#areAllUsersAllowed()}
   */
  @Test
  void testJsonAreAllUsersAllowed() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableRequiredInvolvementsResult.Json()).areAllUsersAllowed());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableRequiredInvolvementsResult.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableRequiredInvolvementsResult.Json actualJson = new ImmutableRequiredInvolvementsResult.Json();

    // Assert
    assertFalse(actualJson.areAllUsersAllowed);
    assertFalse(actualJson.areAllUsersAllowedIsSet);
    assertTrue(actualJson.requiredInvolvementKindIds.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableRequiredInvolvementsResult.Json#requiredInvolvementKindIds()}
   */
  @Test
  void testJsonRequiredInvolvementKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableRequiredInvolvementsResult.Json()).requiredInvolvementKindIds());
  }

  /**
   * Method under test:
   * {@link ImmutableRequiredInvolvementsResult.Json#setAreAllUsersAllowed(boolean)}
   */
  @Test
  void testJsonSetAreAllUsersAllowed() {
    // Arrange
    ImmutableRequiredInvolvementsResult.Json json = new ImmutableRequiredInvolvementsResult.Json();

    // Act
    json.setAreAllUsersAllowed(true);

    // Assert
    assertTrue(json.areAllUsersAllowed);
    assertTrue(json.areAllUsersAllowedIsSet);
  }
}
