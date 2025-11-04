package org.finos.waltz.model.physical_specification_definition;

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
import java.time.LocalTime;
import java.util.Optional;
import org.finos.waltz.model.CreatedProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecDefinitionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinition#builder()}
   *   <li>{@link ImmutablePhysicalSpecDefinition#createdAt(LocalDateTime)}
   *   <li>{@link ImmutablePhysicalSpecDefinition#delimiter(String)}
   *   <li>{@link ImmutablePhysicalSpecDefinition#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutablePhysicalSpecDefinition#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinition.Builder actualBuilderResult = ImmutablePhysicalSpecDefinition.builder();
    ImmutablePhysicalSpecDefinition.Builder actualDelimiterResult = actualBuilderResult
        .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .delimiter("Delimiter");
    Optional<String> delimiter = Optional.of("foo");
    ImmutablePhysicalSpecDefinition.Builder actualIdResult = actualDelimiterResult.delimiter(delimiter).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutablePhysicalSpecDefinition.Builder actualIdResult2 = actualIdResult.id(id);
    ImmutablePhysicalSpecDefinition.Builder actualLastUpdatedAtResult = actualIdResult2
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#createdBy(String)}
   */
  @Test
  void testBuilderCreatedBy() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#delimiter(Optional)}
   */
  @Test
  void testBuilderDelimiter() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    Optional<String> delimiter = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.delimiter(delimiter));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#from(CreatedProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutablePhysicalSpecDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#from(CreatedProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenThrow(new IllegalStateException("instance"));
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutablePhysicalSpecDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutablePhysicalSpecDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutablePhysicalSpecDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalSpecDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#from(PhysicalSpecDefinition)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    PhysicalSpecDefinition instance = mock(PhysicalSpecDefinition.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.delimiter()).thenReturn(ofResult2);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalSpecDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).delimiter();
    verify(instance).specificationId();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
    ImmutablePhysicalSpecDefinition buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.specificationId());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#from(PhysicalSpecDefinition)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    PhysicalSpecDefinition instance = mock(PhysicalSpecDefinition.class);
    when(instance.status()).thenThrow(new IllegalStateException("instance"));
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.delimiter()).thenReturn(ofResult2);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).delimiter();
    verify(instance).specificationId();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#from(PhysicalSpecDefinition)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    PhysicalSpecDefinition instance = mock(PhysicalSpecDefinition.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.delimiter()).thenReturn(ofResult);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalSpecDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).delimiter();
    verify(instance).specificationId();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
    ImmutablePhysicalSpecDefinition buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.specificationId());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#from(PhysicalSpecDefinition)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    PhysicalSpecDefinition instance = mock(PhysicalSpecDefinition.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.delimiter()).thenReturn(emptyResult);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalSpecDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).delimiter();
    verify(instance).specificationId();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
    ImmutablePhysicalSpecDefinition buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.specificationId());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecDefinition.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#specificationId(long)}
   */
  @Test
  void testBuilderSpecificationId() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.specificationId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#status(ReleaseLifecycleStatus)}
   */
  @Test
  void testBuilderStatus() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.status(ReleaseLifecycleStatus.DRAFT));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#type(PhysicalSpecDefinitionType)}
   */
  @Test
  void testBuilderType() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.type(PhysicalSpecDefinitionType.DELIMITED));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Builder#version(String)}
   */
  @Test
  void testBuilderVersion() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.version("1.0.2"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition#copyOf(PhysicalSpecDefinition)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalSpecDefinition instance = mock(PhysicalSpecDefinition.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.delimiter()).thenReturn(ofResult2);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult4.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalSpecDefinition actualCopyOfResult = ImmutablePhysicalSpecDefinition.copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).delimiter();
    verify(instance).specificationId();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1.0.2", actualCopyOfResult.version());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    LocalDate toLocalDateResult2 = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.specificationId());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualCopyOfResult.type());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult3, toLocalDateResult2);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition#copyOf(PhysicalSpecDefinition)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    PhysicalSpecDefinition instance = mock(PhysicalSpecDefinition.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.delimiter()).thenReturn(ofResult);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalSpecDefinition actualCopyOfResult = ImmutablePhysicalSpecDefinition.copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).delimiter();
    verify(instance).specificationId();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1.0.2", actualCopyOfResult.version());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    LocalDate toLocalDateResult2 = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.specificationId());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualCopyOfResult.type());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
    assertSame(ofResult3, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition#copyOf(PhysicalSpecDefinition)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    PhysicalSpecDefinition instance = mock(PhysicalSpecDefinition.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.delimiter()).thenReturn(emptyResult);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalSpecDefinition actualCopyOfResult = ImmutablePhysicalSpecDefinition.copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).delimiter();
    verify(instance).specificationId();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1.0.2", actualCopyOfResult.version());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    LocalDate toLocalDateResult2 = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.specificationId());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualCopyOfResult.type());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
    assertSame(ofResult3, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecDefinition.Json#createdAt()}
   */
  @Test
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecDefinition.Json()).createdAt());
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecDefinition.Json#createdBy()}
   */
  @Test
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecDefinition.Json()).createdBy());
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecDefinition.Json#delimiter()}
   */
  @Test
  void testJsonDelimiter() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecDefinition.Json()).delimiter());
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecDefinition.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecDefinition.Json()).id());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinition.Json()).lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinition.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePhysicalSpecDefinition.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinition.Json actualJson = new ImmutablePhysicalSpecDefinition.Json();

    // Assert
    assertNull(actualJson.createdBy);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.version);
    assertNull(actualJson.createdAt);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.status);
    assertNull(actualJson.type);
    assertEquals(0L, actualJson.specificationId);
    assertFalse(actualJson.delimiter.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.specificationIdIsSet);
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecDefinition.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecDefinition.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Json#setSpecificationId(long)}
   */
  @Test
  void testJsonSetSpecificationId() {
    // Arrange
    ImmutablePhysicalSpecDefinition.Json json = new ImmutablePhysicalSpecDefinition.Json();

    // Act
    json.setSpecificationId(1L);

    // Assert
    assertEquals(1L, json.specificationId);
    assertTrue(json.specificationIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinition.Json#specificationId()}
   */
  @Test
  void testJsonSpecificationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinition.Json()).specificationId());
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecDefinition.Json#status()}
   */
  @Test
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecDefinition.Json()).status());
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecDefinition.Json#type()}
   */
  @Test
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecDefinition.Json()).type());
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecDefinition.Json#version()}
   */
  @Test
  void testJsonVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecDefinition.Json()).version());
  }
}
