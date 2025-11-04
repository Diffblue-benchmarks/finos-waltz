package org.finos.waltz.model.involvement_group;

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
import org.junit.jupiter.api.Test;

class ImmutableInvolvementGroupCreateCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableInvolvementGroupCreateCommand.Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllInvolvementKindIds() {
    // Arrange
    ImmutableInvolvementGroupCreateCommand.Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInvolvementKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroupCreateCommand.Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllInvolvementKindIds2() {
    // Arrange
    ImmutableInvolvementGroupCreateCommand.Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInvolvementKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroupCreateCommand.Builder#addInvolvementKindIds(long)}
   */
  @Test
  void testBuilderAddInvolvementKindIds() {
    // Arrange
    ImmutableInvolvementGroupCreateCommand.Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroupCreateCommand.Builder#addInvolvementKindIds(long[])}
   */
  @Test
  void testBuilderAddInvolvementKindIds2() {
    // Arrange
    ImmutableInvolvementGroupCreateCommand.Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L, -2L, 1L, -2L));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroupCreateCommand.Builder#from(InvolvementGroupCreateCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableInvolvementGroupCreateCommand.Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();
    InvolvementGroupCreateCommand instance = mock(InvolvementGroupCreateCommand.class);
    when(instance.involvementGroup()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).involvementGroup();
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroupCreateCommand.Builder#from(InvolvementGroupCreateCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableInvolvementGroupCreateCommand.Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();
    InvolvementGroupCreateCommand instance = mock(InvolvementGroupCreateCommand.class);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.involvementGroup()).thenReturn(mock(InvolvementGroup.class));

    // Act
    ImmutableInvolvementGroupCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).involvementGroup();
    verify(instance).involvementKindIds();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroupCreateCommand.Builder#from(InvolvementGroupCreateCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableInvolvementGroupCreateCommand.Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    InvolvementGroupCreateCommand instance = mock(InvolvementGroupCreateCommand.class);
    when(instance.involvementKindIds()).thenReturn(resultLongSet);
    when(instance.involvementGroup()).thenReturn(mock(InvolvementGroup.class));

    // Act
    ImmutableInvolvementGroupCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).involvementGroup();
    verify(instance).involvementKindIds();
    Set<Long> involvementKindIdsResult = builderResult.build().involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    assertTrue(involvementKindIdsResult.contains(-2L));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroupCreateCommand.Builder#from(InvolvementGroupCreateCommand)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableInvolvementGroupCreateCommand.Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();
    InvolvementGroupCreateCommand instance = mock(InvolvementGroupCreateCommand.class);
    when(instance.involvementKindIds()).thenThrow(new IllegalStateException("instance"));
    when(instance.involvementGroup()).thenReturn(mock(InvolvementGroup.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).involvementGroup();
    verify(instance).involvementKindIds();
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroupCreateCommand.Builder#involvementGroup(InvolvementGroup)}
   */
  @Test
  void testBuilderInvolvementGroup() {
    // Arrange
    ImmutableInvolvementGroupCreateCommand.Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();
    InvolvementGroup involvementGroup = mock(InvolvementGroup.class);

    // Act and Assert
    assertSame(builderResult, builderResult.involvementGroup(involvementGroup));
    assertSame(involvementGroup, builderResult.build().involvementGroup());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroupCreateCommand.Builder#involvementKindIds(Iterable)}
   */
  @Test
  void testBuilderInvolvementKindIds() {
    // Arrange
    ImmutableInvolvementGroupCreateCommand.Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroupCreateCommand.Builder#involvementKindIds(Iterable)}
   */
  @Test
  void testBuilderInvolvementKindIds2() {
    // Arrange
    ImmutableInvolvementGroupCreateCommand.Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroupCreateCommand#copyOf(InvolvementGroupCreateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    InvolvementGroupCreateCommand instance = mock(InvolvementGroupCreateCommand.class);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.involvementGroup()).thenReturn(mock(InvolvementGroup.class));

    // Act
    ImmutableInvolvementGroupCreateCommand actualCopyOfResult = ImmutableInvolvementGroupCreateCommand.copyOf(instance);

    // Assert
    verify(instance).involvementGroup();
    verify(instance).involvementKindIds();
    assertTrue(actualCopyOfResult.involvementKindIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroupCreateCommand#copyOf(InvolvementGroupCreateCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    InvolvementGroupCreateCommand instance = mock(InvolvementGroupCreateCommand.class);
    when(instance.involvementKindIds()).thenReturn(resultLongSet);
    when(instance.involvementGroup()).thenReturn(mock(InvolvementGroup.class));

    // Act
    ImmutableInvolvementGroupCreateCommand actualCopyOfResult = ImmutableInvolvementGroupCreateCommand.copyOf(instance);

    // Assert
    verify(instance).involvementGroup();
    verify(instance).involvementKindIds();
    Set<Long> involvementKindIdsResult = actualCopyOfResult.involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    assertTrue(involvementKindIdsResult.contains(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementGroupCreateCommand#copyOf(InvolvementGroupCreateCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    resultLongSet.add(1L);
    InvolvementGroupCreateCommand instance = mock(InvolvementGroupCreateCommand.class);
    when(instance.involvementKindIds()).thenReturn(resultLongSet);
    when(instance.involvementGroup()).thenReturn(mock(InvolvementGroup.class));

    // Act
    ImmutableInvolvementGroupCreateCommand actualCopyOfResult = ImmutableInvolvementGroupCreateCommand.copyOf(instance);

    // Assert
    verify(instance).involvementGroup();
    verify(instance).involvementKindIds();
    assertEquals(resultLongSet, actualCopyOfResult.involvementKindIds());
  }
}
