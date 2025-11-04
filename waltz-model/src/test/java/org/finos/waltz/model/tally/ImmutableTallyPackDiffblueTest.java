package org.finos.waltz.model.tally;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableTallyPackDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableTallyPack#builder()}
   *   <li>{@link ImmutableTallyPack#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableTallyPack.Builder<Object> actualBuilderResult = ImmutableTallyPack.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Method under test: {@link ImmutableTallyPack.Builder#addAllTallies(Iterable)}
   */
  @Test
  void testBuilderAddAllTallies() {
    // Arrange
    ImmutableTallyPack.Builder<Object> builderResult = ImmutableTallyPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllTallies(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableTallyPack.Builder#addTallies(Tally)}
   */
  @Test
  void testBuilderAddTallies() {
    // Arrange
    ImmutableTallyPack.Builder<Object> builderResult = ImmutableTallyPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTallies(new ImmutableOrderedTally.Json<>()));
  }

  /**
   * Method under test: {@link ImmutableTallyPack.Builder#addTallies(Tally[])}
   */
  @Test
  void testBuilderAddTallies2() {
    // Arrange
    ImmutableTallyPack.Builder<Object> builderResult = ImmutableTallyPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTallies(new ImmutableOrderedTally.Json<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableTallyPack.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableTallyPack.Builder<Object> builderResult = ImmutableTallyPack.builder();
    EntityReference entityReference = mock(EntityReference.class);

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(entityReference));
    assertSame(entityReference, builderResult.build().entityReference());
  }

  /**
   * Method under test: {@link ImmutableTallyPack.Builder#from(TallyPack)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableTallyPack.Builder<Object> builderResult = ImmutableTallyPack.builder();
    TallyPack<Object> instance = mock(TallyPack.class);
    when(instance.tallies()).thenReturn(new ArrayList<>());
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableTallyPack.Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).lastUpdatedAt();
    verify(instance).tallies();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableTallyPack.Builder#from(TallyPack)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableTallyPack.Builder<Object> builderResult = ImmutableTallyPack.builder();

    ArrayList<Tally<Object>> tallyList = new ArrayList<>();
    ImmutableOrderedTally.Json<Object> json = new ImmutableOrderedTally.Json<>();
    tallyList.add(json);
    TallyPack<Object> instance = mock(TallyPack.class);
    when(instance.tallies()).thenReturn(tallyList);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableTallyPack.Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).lastUpdatedAt();
    verify(instance).tallies();
    List<Tally<Object>> talliesResult = builderResult.build().tallies();
    assertEquals(1, talliesResult.size());
    assertSame(json, talliesResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableTallyPack.Builder#from(TallyPack)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableTallyPack.Builder<Object> builderResult = ImmutableTallyPack.builder();
    TallyPack<Object> instance = mock(TallyPack.class);
    when(instance.tallies()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
    verify(instance).tallies();
  }

  /**
   * Method under test: {@link ImmutableTallyPack.Builder#tallies(Iterable)}
   */
  @Test
  void testBuilderTallies() {
    // Arrange
    ImmutableTallyPack.Builder<Object> builderResult = ImmutableTallyPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.tallies(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableTallyPack#copyOf(TallyPack)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    TallyPack<Object> instance = mock(TallyPack.class);
    when(instance.tallies()).thenReturn(new ArrayList<>());
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableTallyPack<Object> actualCopyOfResult = ImmutableTallyPack.copyOf(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).lastUpdatedAt();
    verify(instance).tallies();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertTrue(actualCopyOfResult.tallies().isEmpty());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableTallyPack#copyOf(TallyPack)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<Tally<Object>> tallyList = new ArrayList<>();
    tallyList.add(new ImmutableOrderedTally.Json<>());
    TallyPack<Object> instance = mock(TallyPack.class);
    when(instance.tallies()).thenReturn(tallyList);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableTallyPack<Object> actualCopyOfResult = ImmutableTallyPack.copyOf(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).lastUpdatedAt();
    verify(instance).tallies();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(tallyList, actualCopyOfResult.tallies());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableTallyPack#copyOf(TallyPack)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<Tally<Object>> tallyList = new ArrayList<>();
    tallyList.add(new ImmutableOrderedTally.Json<>());
    tallyList.add(new ImmutableOrderedTally.Json<>());
    TallyPack<Object> instance = mock(TallyPack.class);
    when(instance.tallies()).thenReturn(tallyList);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableTallyPack<Object> actualCopyOfResult = ImmutableTallyPack.copyOf(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).lastUpdatedAt();
    verify(instance).tallies();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(tallyList, actualCopyOfResult.tallies());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTallyPack#fromJson(ImmutableTallyPack.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableTallyPack.Json<Object> json = new ImmutableTallyPack.Json<>();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    ImmutableTallyPack<Object> actualFromJsonResult = ImmutableTallyPack.fromJson(json);

    // Assert
    List<Tally<Object>> talliesResult = actualFromJsonResult.tallies();
    assertTrue(talliesResult.isEmpty());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    assertSame(json.tallies, talliesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTallyPack#fromJson(ImmutableTallyPack.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableTallyPack.Json<Object> json = new ImmutableTallyPack.Json<>();
    json.setEntityReference(mock(EntityReference.class));
    json.setTallies(null);
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableTallyPack<Object> actualFromJsonResult = ImmutableTallyPack.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.tallies().isEmpty());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutableTallyPack#fromJson(ImmutableTallyPack.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<Tally<Object>> tallies = new ArrayList<>();
    tallies.add(new ImmutableOrderedTally.Json<>());

    ImmutableTallyPack.Json<Object> json = new ImmutableTallyPack.Json<>();
    json.setEntityReference(mock(EntityReference.class));
    json.setTallies(tallies);
    json.setLastUpdatedAt(null);

    // Act
    ImmutableTallyPack<Object> actualFromJsonResult = ImmutableTallyPack.fromJson(json);

    // Assert
    assertEquals(tallies, actualFromJsonResult.tallies());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableTallyPack#fromJson(ImmutableTallyPack.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ArrayList<Tally<Object>> tallies = new ArrayList<>();
    tallies.add(new ImmutableOrderedTally.Json<>());
    tallies.add(new ImmutableOrderedTally.Json<>());

    ImmutableTallyPack.Json<Object> json = new ImmutableTallyPack.Json<>();
    json.setEntityReference(mock(EntityReference.class));
    json.setTallies(tallies);
    json.setLastUpdatedAt(null);

    // Act
    ImmutableTallyPack<Object> actualFromJsonResult = ImmutableTallyPack.fromJson(json);

    // Assert
    assertEquals(tallies, actualFromJsonResult.tallies());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test: {@link ImmutableTallyPack.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange
    ImmutableTallyPack.Json<Object> json = new ImmutableTallyPack.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.entityReference());
  }

  /**
   * Method under test: {@link ImmutableTallyPack.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange
    ImmutableTallyPack.Json<Object> json = new ImmutableTallyPack.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.lastUpdatedAt());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableTallyPack.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableTallyPack.Json<Object> actualJson = new ImmutableTallyPack.Json<>();

    // Assert
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.entityReference);
    assertTrue(actualJson.tallies.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableTallyPack.Json#tallies()}
   */
  @Test
  void testJsonTallies() {
    // Arrange
    ImmutableTallyPack.Json<Object> json = new ImmutableTallyPack.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.tallies());
  }
}
