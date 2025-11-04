package org.finos.waltz.model.roadmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableRoadmapDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableRoadmap#builder()}
   *   <li>{@link ImmutableRoadmap#description(String)}
   *   <li>{@link ImmutableRoadmap#entityLifecycleStatus(EntityLifecycleStatus)}
   *   <li>{@link ImmutableRoadmap#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableRoadmap.Builder actualIdResult = ImmutableRoadmap.builder()
        .description("The characteristics of someone or something")
        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableRoadmap.Builder actualIdResult2 = actualIdResult.id(id);

    // Assert
    assertSame(actualIdResult2, actualIdResult2.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmap.Builder#columnType(EntityReference)}
   */
  @Test
  void testBuilderColumnType() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.columnType(mock(EntityReference.class)));
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableRoadmap.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableRoadmap.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmap.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableRoadmap.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatus();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmap.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityLifecycleStatus();
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableRoadmap.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableRoadmap.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableRoadmap.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRoadmap.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#from(Roadmap)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    Roadmap instance = mock(Roadmap.class);
    when(instance.rowType()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).rowType();
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#from(Roadmap)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    Roadmap instance = mock(Roadmap.class);
    when(instance.rowType()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).rowType();
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#from(Roadmap)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    Roadmap instance = mock(Roadmap.class);
    when(instance.columnType()).thenThrow(new IllegalStateException("instance"));
    when(instance.rowType()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).columnType();
    verify(instance).rowType();
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#from(Roadmap)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    Roadmap instance = mock(Roadmap.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.columnType()).thenReturn(mock(EntityReference.class));
    when(instance.rowType()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRoadmap.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).columnType();
    verify(instance).ratingSchemeId();
    verify(instance).rowType();
    ImmutableRoadmap buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#from(Roadmap)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    Roadmap instance = mock(Roadmap.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.columnType()).thenReturn(mock(EntityReference.class));
    when(instance.rowType()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).columnType();
    verify(instance).rowType();
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#from(Roadmap)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    Roadmap instance = mock(Roadmap.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.columnType()).thenReturn(mock(EntityReference.class));
    when(instance.rowType()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRoadmap.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).columnType();
    verify(instance).ratingSchemeId();
    verify(instance).rowType();
    ImmutableRoadmap buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#ratingSchemeId(long)}
   */
  @Test
  void testBuilderRatingSchemeId() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeId(1L));
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Builder#rowType(EntityReference)}
   */
  @Test
  void testBuilderRowType() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rowType(mock(EntityReference.class)));
  }

  /**
   * Method under test: {@link ImmutableRoadmap#copyOf(Roadmap)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Roadmap instance = mock(Roadmap.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.ratingSchemeId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.columnType()).thenReturn(mock(EntityReference.class));
    when(instance.rowType()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRoadmap actualCopyOfResult = ImmutableRoadmap.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).columnType();
    verify(instance).ratingSchemeId();
    verify(instance).rowType();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableRoadmap#copyOf(Roadmap)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    Roadmap instance = mock(Roadmap.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.ratingSchemeId()).thenReturn(1L);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.columnType()).thenReturn(mock(EntityReference.class));
    when(instance.rowType()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRoadmap actualCopyOfResult = ImmutableRoadmap.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).columnType();
    verify(instance).ratingSchemeId();
    verify(instance).rowType();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableRoadmap#copyOf(Roadmap)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    Roadmap instance = mock(Roadmap.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.ratingSchemeId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.columnType()).thenReturn(mock(EntityReference.class));
    when(instance.rowType()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRoadmap actualCopyOfResult = ImmutableRoadmap.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).columnType();
    verify(instance).ratingSchemeId();
    verify(instance).rowType();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Json#columnType()}
   */
  @Test
  void testJsonColumnType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRoadmap.Json()).columnType());
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRoadmap.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Json#entityLifecycleStatus()}
   */
  @Test
  void testJsonEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRoadmap.Json()).entityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRoadmap.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRoadmap.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRoadmap.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRoadmap.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableRoadmap.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableRoadmap.Json actualJson = new ImmutableRoadmap.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.entityLifecycleStatus);
    assertNull(actualJson.columnType);
    assertNull(actualJson.rowType);
    assertEquals(0L, actualJson.ratingSchemeId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.ratingSchemeIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Json#ratingSchemeId()}
   */
  @Test
  void testJsonRatingSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRoadmap.Json()).ratingSchemeId());
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Json#rowType()}
   */
  @Test
  void testJsonRowType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRoadmap.Json()).rowType());
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Json#setRatingSchemeId(long)}
   */
  @Test
  void testJsonSetRatingSchemeId() {
    // Arrange
    ImmutableRoadmap.Json json = new ImmutableRoadmap.Json();

    // Act
    json.setRatingSchemeId(1L);

    // Assert
    assertEquals(1L, json.ratingSchemeId);
    assertTrue(json.ratingSchemeIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableRoadmap.Json#setRatingSchemeId(long)}
   */
  @Test
  void testJsonSetRatingSchemeId2() {
    // Arrange
    ImmutableRoadmap.Json json = new ImmutableRoadmap.Json();
    json.setRowType(mock(EntityReference.class));

    // Act
    json.setRatingSchemeId(1L);

    // Assert
    assertEquals(1L, json.ratingSchemeId);
    assertTrue(json.ratingSchemeIdIsSet);
  }
}
