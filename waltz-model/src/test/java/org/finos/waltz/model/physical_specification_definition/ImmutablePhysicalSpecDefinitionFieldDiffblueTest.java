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
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.FieldDataType;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecDefinitionFieldDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionField#builder()}
   *   <li>{@link ImmutablePhysicalSpecDefinitionField#description(String)}
   *   <li>{@link ImmutablePhysicalSpecDefinitionField#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionField.Builder actualIdResult = ImmutablePhysicalSpecDefinitionField.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutablePhysicalSpecDefinitionField.Builder actualIdResult2 = actualIdResult.id(id);
    ImmutablePhysicalSpecDefinitionField.Builder actualLogicalDataElementIdResult = actualIdResult2
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .logicalDataElementId(1L);
    Optional<Long> logicalDataElementId = Optional.<Long>of(1L);

    // Assert
    assertSame(actualLogicalDataElementIdResult,
        actualLogicalDataElementIdResult.logicalDataElementId(logicalDataElementId));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutablePhysicalSpecDefinitionField.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutablePhysicalSpecDefinitionField.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutablePhysicalSpecDefinitionField.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutablePhysicalSpecDefinitionField.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutablePhysicalSpecDefinitionField.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
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
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionField.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#from(PhysicalSpecDefinitionField)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    PhysicalSpecDefinitionField instance = mock(PhysicalSpecDefinitionField.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.logicalDataElementId()).thenReturn(ofResult2);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.specDefinitionId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionField.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).logicalDataElementId();
    verify(instance).position();
    verify(instance).specDefinitionId();
    verify(instance).type();
    ImmutablePhysicalSpecDefinitionField buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.specDefinitionId());
    assertEquals(FieldDataType.DATE, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#from(PhysicalSpecDefinitionField)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    PhysicalSpecDefinitionField instance = mock(PhysicalSpecDefinitionField.class);
    when(instance.logicalDataElementId()).thenThrow(new IllegalStateException("instance"));
    when(instance.specDefinitionId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).logicalDataElementId();
    verify(instance).specDefinitionId();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#from(PhysicalSpecDefinitionField)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    PhysicalSpecDefinitionField instance = mock(PhysicalSpecDefinitionField.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.logicalDataElementId()).thenReturn(ofResult);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.specDefinitionId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionField.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).logicalDataElementId();
    verify(instance).position();
    verify(instance).specDefinitionId();
    verify(instance).type();
    ImmutablePhysicalSpecDefinitionField buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.specDefinitionId());
    assertEquals(FieldDataType.DATE, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#from(PhysicalSpecDefinitionField)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    PhysicalSpecDefinitionField instance = mock(PhysicalSpecDefinitionField.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.logicalDataElementId()).thenReturn(emptyResult);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.specDefinitionId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionField.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).logicalDataElementId();
    verify(instance).position();
    verify(instance).specDefinitionId();
    verify(instance).type();
    ImmutablePhysicalSpecDefinitionField buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.specDefinitionId());
    assertEquals(FieldDataType.DATE, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#from(PhysicalSpecDefinitionField)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    PhysicalSpecDefinitionField instance = mock(PhysicalSpecDefinitionField.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.logicalDataElementId()).thenReturn(ofResult2);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.specDefinitionId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn(null);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionField.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).logicalDataElementId();
    verify(instance).position();
    verify(instance).specDefinitionId();
    verify(instance).type();
    ImmutablePhysicalSpecDefinitionField buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.specDefinitionId());
    assertEquals(FieldDataType.DATE, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#logicalDataElementId(long)}
   */
  @Test
  void testBuilderLogicalDataElementId() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.logicalDataElementId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#logicalDataElementId(Optional)}
   */
  @Test
  void testBuilderLogicalDataElementId2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    Optional<Long> logicalDataElementId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.logicalDataElementId(logicalDataElementId));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#specDefinitionId(long)}
   */
  @Test
  void testBuilderSpecDefinitionId() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.specDefinitionId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Builder#type(FieldDataType)}
   */
  @Test
  void testBuilderType() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.type(FieldDataType.DATE));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField#copyOf(PhysicalSpecDefinitionField)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalSpecDefinitionField instance = mock(PhysicalSpecDefinitionField.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.logicalDataElementId()).thenReturn(ofResult2);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.specDefinitionId()).thenReturn(1L);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionField actualCopyOfResult = ImmutablePhysicalSpecDefinitionField.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).logicalDataElementId();
    verify(instance).position();
    verify(instance).specDefinitionId();
    verify(instance).type();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.specDefinitionId());
    assertEquals(FieldDataType.DATE, actualCopyOfResult.type());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField#copyOf(PhysicalSpecDefinitionField)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    PhysicalSpecDefinitionField instance = mock(PhysicalSpecDefinitionField.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.logicalDataElementId()).thenReturn(ofResult);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.specDefinitionId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionField actualCopyOfResult = ImmutablePhysicalSpecDefinitionField.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).logicalDataElementId();
    verify(instance).position();
    verify(instance).specDefinitionId();
    verify(instance).type();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.specDefinitionId());
    assertEquals(FieldDataType.DATE, actualCopyOfResult.type());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField#copyOf(PhysicalSpecDefinitionField)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    PhysicalSpecDefinitionField instance = mock(PhysicalSpecDefinitionField.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.logicalDataElementId()).thenReturn(emptyResult);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.specDefinitionId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionField actualCopyOfResult = ImmutablePhysicalSpecDefinitionField.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).logicalDataElementId();
    verify(instance).position();
    verify(instance).specDefinitionId();
    verify(instance).type();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.specDefinitionId());
    assertEquals(FieldDataType.DATE, actualCopyOfResult.type());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField#copyOf(PhysicalSpecDefinitionField)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    PhysicalSpecDefinitionField instance = mock(PhysicalSpecDefinitionField.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.logicalDataElementId()).thenReturn(ofResult2);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.specDefinitionId()).thenReturn(1L);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.description()).thenReturn(null);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionField actualCopyOfResult = ImmutablePhysicalSpecDefinitionField.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).logicalDataElementId();
    verify(instance).position();
    verify(instance).specDefinitionId();
    verify(instance).type();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertNull(actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.specDefinitionId());
    assertEquals(FieldDataType.DATE, actualCopyOfResult.type());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionField.Json()).description());
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecDefinitionField.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecDefinitionField.Json()).id());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionField.Json()).lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionField.Json()).lastUpdatedBy());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Json#logicalDataElementId()}
   */
  @Test
  void testJsonLogicalDataElementId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionField.Json()).logicalDataElementId());
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecDefinitionField.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecDefinitionField.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePhysicalSpecDefinitionField.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionField.Json actualJson = new ImmutablePhysicalSpecDefinitionField.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.type);
    assertEquals(0, actualJson.position);
    assertEquals(0L, actualJson.specDefinitionId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.logicalDataElementId.isPresent());
    assertFalse(actualJson.positionIsSet);
    assertFalse(actualJson.specDefinitionIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionField.Json()).position());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Json json = new ImmutablePhysicalSpecDefinitionField.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Json#setSpecDefinitionId(long)}
   */
  @Test
  void testJsonSetSpecDefinitionId() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField.Json json = new ImmutablePhysicalSpecDefinitionField.Json();

    // Act
    json.setSpecDefinitionId(1L);

    // Assert
    assertEquals(1L, json.specDefinitionId);
    assertTrue(json.specDefinitionIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionField.Json#specDefinitionId()}
   */
  @Test
  void testJsonSpecDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionField.Json()).specDefinitionId());
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecDefinitionField.Json#type()}
   */
  @Test
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecDefinitionField.Json()).type());
  }
}
