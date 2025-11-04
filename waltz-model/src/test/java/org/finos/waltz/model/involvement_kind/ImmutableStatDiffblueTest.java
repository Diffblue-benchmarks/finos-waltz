package org.finos.waltz.model.involvement_kind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.Test;

class ImmutableStatDiffblueTest {
  /**
   * Method under test: {@link ImmutableStat.Builder#entityKind(EntityKind)}
   */
  @Test
  void testBuilderEntityKind() {
    // Arrange
    ImmutableStat.Builder builderResult = ImmutableStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableStat.Builder#from(InvolvementKindUsageStat.Stat)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableStat.Builder builderResult = ImmutableStat.builder();
    InvolvementKindUsageStat.Stat instance = mock(InvolvementKindUsageStat.Stat.class);
    when(instance.isCountOfRemovedPeople()).thenReturn(true);
    when(instance.personCount()).thenReturn(3);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableStat.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityKind();
    verify(instance).isCountOfRemovedPeople();
    verify(instance).personCount();
    ImmutableStat buildResult = builderResult.build();
    assertEquals(3, buildResult.personCount());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertTrue(buildResult.isCountOfRemovedPeople());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableStat.Builder#from(InvolvementKindUsageStat.Stat)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableStat.Builder builderResult = ImmutableStat.builder();
    InvolvementKindUsageStat.Stat instance = mock(InvolvementKindUsageStat.Stat.class);
    when(instance.isCountOfRemovedPeople()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityKind();
    verify(instance).isCountOfRemovedPeople();
  }

  /**
   * Method under test:
   * {@link ImmutableStat.Builder#isCountOfRemovedPeople(boolean)}
   */
  @Test
  void testBuilderIsCountOfRemovedPeople() {
    // Arrange
    ImmutableStat.Builder builderResult = ImmutableStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isCountOfRemovedPeople(true));
  }

  /**
   * Method under test: {@link ImmutableStat.Builder#personCount(int)}
   */
  @Test
  void testBuilderPersonCount() {
    // Arrange
    ImmutableStat.Builder builderResult = ImmutableStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.personCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableStat#copyOf(InvolvementKindUsageStat.Stat)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    InvolvementKindUsageStat.Stat instance = mock(InvolvementKindUsageStat.Stat.class);
    when(instance.isCountOfRemovedPeople()).thenReturn(true);
    when(instance.personCount()).thenReturn(3);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableStat actualCopyOfResult = ImmutableStat.copyOf(instance);

    // Assert
    verify(instance).entityKind();
    verify(instance).isCountOfRemovedPeople();
    verify(instance).personCount();
    assertEquals(3, actualCopyOfResult.personCount());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertTrue(actualCopyOfResult.isCountOfRemovedPeople());
  }

  /**
   * Method under test: {@link ImmutableStat.Json#entityKind()}
   */
  @Test
  void testJsonEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableStat.Json()).entityKind());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableStat.Json}
   *   <li>{@link ImmutableStat.Json#setEntityKind(EntityKind)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableStat.Json actualJson = new ImmutableStat.Json();
    actualJson.setEntityKind(EntityKind.ALL);

    // Assert
    assertEquals(0, actualJson.personCount);
    assertEquals(EntityKind.ALL, actualJson.entityKind);
    assertFalse(actualJson.isCountOfRemovedPeople);
    assertFalse(actualJson.isCountOfRemovedPeopleIsSet);
    assertFalse(actualJson.personCountIsSet);
  }

  /**
   * Method under test: {@link ImmutableStat.Json#isCountOfRemovedPeople()}
   */
  @Test
  void testJsonIsCountOfRemovedPeople() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableStat.Json()).isCountOfRemovedPeople());
  }

  /**
   * Method under test: {@link ImmutableStat.Json#personCount()}
   */
  @Test
  void testJsonPersonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableStat.Json()).personCount());
  }

  /**
   * Method under test:
   * {@link ImmutableStat.Json#setIsCountOfRemovedPeople(boolean)}
   */
  @Test
  void testJsonSetIsCountOfRemovedPeople() {
    // Arrange
    ImmutableStat.Json json = new ImmutableStat.Json();

    // Act
    json.setIsCountOfRemovedPeople(true);

    // Assert
    assertTrue(json.isCountOfRemovedPeople);
    assertTrue(json.isCountOfRemovedPeopleIsSet);
  }

  /**
   * Method under test: {@link ImmutableStat.Json#setPersonCount(int)}
   */
  @Test
  void testJsonSetPersonCount() {
    // Arrange
    ImmutableStat.Json json = new ImmutableStat.Json();

    // Act
    json.setPersonCount(3);

    // Assert
    assertEquals(3, json.personCount);
    assertTrue(json.personCountIsSet);
  }
}
