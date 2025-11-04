package org.finos.waltz.model.attribute_change;

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
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableAttributeChangeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAttributeChange#builder()}
   *   <li>{@link ImmutableAttributeChange#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableAttributeChange#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAttributeChange.Builder actualIdResult = ImmutableAttributeChange.builder().id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableAttributeChange.Builder actualIdResult2 = actualIdResult.id(id);
    ImmutableAttributeChange.Builder actualLastUpdatedAtResult = actualIdResult2
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableAttributeChange.Builder#changeUnitId(long)}
   */
  @Test
  void testBuilderChangeUnitId() {
    // Arrange
    ImmutableAttributeChange.Builder builderResult = ImmutableAttributeChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeUnitId(1L));
  }

  /**
   * Method under test: {@link ImmutableAttributeChange.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAttributeChange.Builder builderResult = ImmutableAttributeChange.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableAttributeChange.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAttributeChange.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAttributeChange.Builder builderResult = ImmutableAttributeChange.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableAttributeChange.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAttributeChange.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAttributeChange.Builder builderResult = ImmutableAttributeChange.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableAttributeChange.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAttributeChange.Builder builderResult = ImmutableAttributeChange.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableAttributeChange.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttributeChange.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAttributeChange.Builder builderResult = ImmutableAttributeChange.builder();
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
   * {@link ImmutableAttributeChange.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAttributeChange.Builder builderResult = ImmutableAttributeChange.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttributeChange.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttributeChange.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableAttributeChange.Builder builderResult = ImmutableAttributeChange.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAttributeChange.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttributeChange.Builder#from(AttributeChange)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableAttributeChange.Builder builderResult = ImmutableAttributeChange.builder();
    AttributeChange instance = mock(AttributeChange.class);
    when(instance.changeUnitId()).thenReturn(1L);
    when(instance.type()).thenReturn("Type");
    when(instance.oldValue()).thenReturn("42");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.newValue()).thenReturn("42");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttributeChange.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).changeUnitId();
    verify(instance).newValue();
    verify(instance).oldValue();
    verify(instance).type();
    ImmutableAttributeChange buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("42", buildResult.newValue());
    assertEquals("42", buildResult.oldValue());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("Type", buildResult.type());
    assertEquals(1L, buildResult.changeUnitId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttributeChange.Builder#from(AttributeChange)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableAttributeChange.Builder builderResult = ImmutableAttributeChange.builder();
    AttributeChange instance = mock(AttributeChange.class);
    when(instance.changeUnitId()).thenThrow(new IllegalStateException("instance"));
    when(instance.type()).thenReturn("Type");
    when(instance.oldValue()).thenReturn("42");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.newValue()).thenReturn("42");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).changeUnitId();
    verify(instance).newValue();
    verify(instance).oldValue();
    verify(instance).type();
  }

  /**
   * Method under test:
   * {@link ImmutableAttributeChange.Builder#from(AttributeChange)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableAttributeChange.Builder builderResult = ImmutableAttributeChange.builder();
    AttributeChange instance = mock(AttributeChange.class);
    when(instance.changeUnitId()).thenReturn(1L);
    when(instance.type()).thenReturn("Type");
    when(instance.oldValue()).thenReturn("42");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.newValue()).thenReturn("42");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttributeChange.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).changeUnitId();
    verify(instance).newValue();
    verify(instance).oldValue();
    verify(instance).type();
    ImmutableAttributeChange buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("42", buildResult.newValue());
    assertEquals("42", buildResult.oldValue());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("Type", buildResult.type());
    assertEquals(1L, buildResult.changeUnitId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAttributeChange.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableAttributeChange.Builder builderResult = ImmutableAttributeChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableAttributeChange.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableAttributeChange.Builder builderResult = ImmutableAttributeChange.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableAttributeChange.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableAttributeChange.Builder builderResult = ImmutableAttributeChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableAttributeChange.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableAttributeChange.Builder builderResult = ImmutableAttributeChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableAttributeChange.Builder#newValue(String)}
   */
  @Test
  void testBuilderNewValue() {
    // Arrange
    ImmutableAttributeChange.Builder builderResult = ImmutableAttributeChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.newValue("42"));
  }

  /**
   * Method under test: {@link ImmutableAttributeChange.Builder#oldValue(String)}
   */
  @Test
  void testBuilderOldValue() {
    // Arrange
    ImmutableAttributeChange.Builder builderResult = ImmutableAttributeChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.oldValue("42"));
  }

  /**
   * Method under test: {@link ImmutableAttributeChange.Builder#type(String)}
   */
  @Test
  void testBuilderType() {
    // Arrange
    ImmutableAttributeChange.Builder builderResult = ImmutableAttributeChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.type("Type"));
  }

  /**
   * Method under test: {@link ImmutableAttributeChange#copyOf(AttributeChange)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AttributeChange instance = mock(AttributeChange.class);
    when(instance.changeUnitId()).thenReturn(1L);
    when(instance.type()).thenReturn("Type");
    when(instance.oldValue()).thenReturn("42");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.newValue()).thenReturn("42");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttributeChange actualCopyOfResult = ImmutableAttributeChange.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).changeUnitId();
    verify(instance).newValue();
    verify(instance).oldValue();
    verify(instance).type();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("42", actualCopyOfResult.newValue());
    assertEquals("42", actualCopyOfResult.oldValue());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Type", actualCopyOfResult.type());
    assertEquals(1L, actualCopyOfResult.changeUnitId());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableAttributeChange#copyOf(AttributeChange)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AttributeChange instance = mock(AttributeChange.class);
    when(instance.changeUnitId()).thenReturn(1L);
    when(instance.type()).thenReturn("Type");
    when(instance.oldValue()).thenReturn("42");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.newValue()).thenReturn("42");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttributeChange actualCopyOfResult = ImmutableAttributeChange.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).changeUnitId();
    verify(instance).newValue();
    verify(instance).oldValue();
    verify(instance).type();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("42", actualCopyOfResult.newValue());
    assertEquals("42", actualCopyOfResult.oldValue());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Type", actualCopyOfResult.type());
    assertEquals(1L, actualCopyOfResult.changeUnitId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableAttributeChange.Json#changeUnitId()}
   */
  @Test
  void testJsonChangeUnitId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttributeChange.Json()).changeUnitId());
  }

  /**
   * Method under test: {@link ImmutableAttributeChange.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttributeChange.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableAttributeChange.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttributeChange.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableAttributeChange.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttributeChange.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableAttributeChange.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttributeChange.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAttributeChange.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAttributeChange.Json actualJson = new ImmutableAttributeChange.Json();

    // Assert
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.newValue);
    assertNull(actualJson.oldValue);
    assertNull(actualJson.provenance);
    assertNull(actualJson.type);
    assertNull(actualJson.lastUpdatedAt);
    assertEquals(0L, actualJson.changeUnitId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.changeUnitIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableAttributeChange.Json#newValue()}
   */
  @Test
  void testJsonNewValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttributeChange.Json()).newValue());
  }

  /**
   * Method under test: {@link ImmutableAttributeChange.Json#oldValue()}
   */
  @Test
  void testJsonOldValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttributeChange.Json()).oldValue());
  }

  /**
   * Method under test: {@link ImmutableAttributeChange.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttributeChange.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutableAttributeChange.Json#setChangeUnitId(long)}
   */
  @Test
  void testJsonSetChangeUnitId() {
    // Arrange
    ImmutableAttributeChange.Json json = new ImmutableAttributeChange.Json();

    // Act
    json.setChangeUnitId(1L);

    // Assert
    assertEquals(1L, json.changeUnitId);
    assertTrue(json.changeUnitIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableAttributeChange.Json#type()}
   */
  @Test
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttributeChange.Json()).type());
  }
}
