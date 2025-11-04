package org.finos.waltz.model.datatype;

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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.WaltzEntity;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeDecoratorDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Builder#decoratorEntity(EntityReference)}
   */
  @Test
  void testBuilderDecoratorEntity() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.decoratorEntity(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Builder#flowClassificationRuleId(long)}
   */
  @Test
  void testBuilderFlowClassificationRuleId() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowClassificationRuleId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Builder#flowClassificationRuleId(Optional)}
   */
  @Test
  void testBuilderFlowClassificationRuleId2() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();
    Optional<Long> flowClassificationRuleId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.flowClassificationRuleId(flowClassificationRuleId));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableDataTypeDecorator.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableDataTypeDecorator.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableDataTypeDecorator.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();
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
   * {@link ImmutableDataTypeDecorator.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableDataTypeDecorator.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Builder#from(WaltzEntity)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();
    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableDataTypeDecorator.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Builder#from(WaltzEntity)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();
    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Builder#from(DataTypeDecorator)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();
    DataTypeDecorator instance = mock(DataTypeDecorator.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.flowClassificationRuleId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.inboundFlowClassificationRuleId()).thenReturn(ofResult2);
    when(instance.isReadonly()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).flowClassificationRuleId();
    verify(instance).inboundFlowClassificationRuleId();
    verify(instance).isReadonly();
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Builder#from(DataTypeDecorator)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();
    DataTypeDecorator instance = mock(DataTypeDecorator.class);
    when(instance.rating()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.flowClassificationRuleId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.inboundFlowClassificationRuleId()).thenReturn(ofResult2);
    when(instance.isReadonly()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).flowClassificationRuleId();
    verify(instance).inboundFlowClassificationRuleId();
    verify(instance).isReadonly();
    verify(instance).rating();
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Builder#from(DataTypeDecorator)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();
    DataTypeDecorator instance = mock(DataTypeDecorator.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<AuthoritativenessRatingValue> ofResult2 = Optional.of(AuthoritativenessRatingValue.of("42"));
    when(instance.rating()).thenReturn(ofResult2);
    Optional<AuthoritativenessRatingValue> ofResult3 = Optional.of(AuthoritativenessRatingValue.of("42"));
    when(instance.targetInboundRating()).thenReturn(ofResult3);
    when(instance.decoratorEntity()).thenReturn(mock(EntityReference.class));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.flowClassificationRuleId()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.inboundFlowClassificationRuleId()).thenReturn(ofResult5);
    when(instance.isReadonly()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableDataTypeDecorator.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).decoratorEntity();
    verify(instance).flowClassificationRuleId();
    verify(instance).inboundFlowClassificationRuleId();
    verify(instance).isReadonly();
    verify(instance).rating();
    verify(instance).targetInboundRating();
    ImmutableDataTypeDecorator buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(0L, buildResult.dataFlowId());
    assertEquals(0L, buildResult.dataTypeId());
    assertTrue(buildResult.isReadonly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDataTypeDecorator.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableDataTypeDecorator.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Builder#inboundFlowClassificationRuleId(long)}
   */
  @Test
  void testBuilderInboundFlowClassificationRuleId() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.inboundFlowClassificationRuleId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Builder#inboundFlowClassificationRuleId(Optional)}
   */
  @Test
  void testBuilderInboundFlowClassificationRuleId2() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();
    Optional<Long> inboundFlowClassificationRuleId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.inboundFlowClassificationRuleId(inboundFlowClassificationRuleId));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Builder#isReadonly(boolean)}
   */
  @Test
  void testBuilderIsReadonly() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadonly(true));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator#copyOf(DataTypeDecorator)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    DataTypeDecorator instance = mock(DataTypeDecorator.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<AuthoritativenessRatingValue> ofResult2 = Optional.of(AuthoritativenessRatingValue.of("42"));
    when(instance.rating()).thenReturn(ofResult2);
    Optional<AuthoritativenessRatingValue> ofResult3 = Optional.of(AuthoritativenessRatingValue.of("42"));
    when(instance.targetInboundRating()).thenReturn(ofResult3);
    when(instance.decoratorEntity()).thenReturn(entityReference2);
    when(instance.entityReference()).thenReturn(entityReference);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.flowClassificationRuleId()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.inboundFlowClassificationRuleId()).thenReturn(ofResult5);
    when(instance.isReadonly()).thenReturn(true);
    LocalDate ofResult6 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult6.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableDataTypeDecorator actualCopyOfResult = ImmutableDataTypeDecorator.copyOf(instance);

    // Assert
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).decoratorEntity();
    verify(instance).flowClassificationRuleId();
    verify(instance).inboundFlowClassificationRuleId();
    verify(instance).isReadonly();
    verify(instance).rating();
    verify(instance).targetInboundRating();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.dataFlowId());
    assertEquals(1L, actualCopyOfResult.dataTypeId());
    assertTrue(actualCopyOfResult.isReadonly());
    assertSame(ofResult6, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator#copyOf(DataTypeDecorator)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    DataTypeDecorator instance = mock(DataTypeDecorator.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<AuthoritativenessRatingValue> ofResult2 = Optional.of(AuthoritativenessRatingValue.of("42"));
    when(instance.rating()).thenReturn(ofResult2);
    Optional<AuthoritativenessRatingValue> ofResult3 = Optional.of(AuthoritativenessRatingValue.of("42"));
    when(instance.targetInboundRating()).thenReturn(ofResult3);
    when(instance.decoratorEntity()).thenReturn(entityReference2);
    when(instance.entityReference()).thenReturn(entityReference);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.flowClassificationRuleId()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.inboundFlowClassificationRuleId()).thenReturn(ofResult5);
    when(instance.isReadonly()).thenReturn(false);
    LocalDate ofResult6 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult6.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableDataTypeDecorator actualCopyOfResult = ImmutableDataTypeDecorator.copyOf(instance);

    // Assert
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).decoratorEntity();
    verify(instance).flowClassificationRuleId();
    verify(instance).inboundFlowClassificationRuleId();
    verify(instance).isReadonly();
    verify(instance).rating();
    verify(instance).targetInboundRating();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.dataFlowId());
    assertEquals(1L, actualCopyOfResult.dataTypeId());
    assertFalse(actualCopyOfResult.isReadonly());
    assertSame(ofResult6, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableDataTypeDecorator.Json#dataFlowId()}
   */
  @Test
  void testJsonDataFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataTypeDecorator.Json()).dataFlowId());
  }

  /**
   * Method under test: {@link ImmutableDataTypeDecorator.Json#dataTypeId()}
   */
  @Test
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataTypeDecorator.Json()).dataTypeId());
  }

  /**
   * Method under test: {@link ImmutableDataTypeDecorator.Json#decoratorEntity()}
   */
  @Test
  void testJsonDecoratorEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataTypeDecorator.Json()).decoratorEntity());
  }

  /**
   * Method under test: {@link ImmutableDataTypeDecorator.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataTypeDecorator.Json()).entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Json#flowClassificationRuleId()}
   */
  @Test
  void testJsonFlowClassificationRuleId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeDecorator.Json()).flowClassificationRuleId());
  }

  /**
   * Method under test: {@link ImmutableDataTypeDecorator.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataTypeDecorator.Json()).id());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Json#inboundFlowClassificationRuleId()}
   */
  @Test
  void testJsonInboundFlowClassificationRuleId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeDecorator.Json()).inboundFlowClassificationRuleId());
  }

  /**
   * Method under test: {@link ImmutableDataTypeDecorator.Json#isReadonly()}
   */
  @Test
  void testJsonIsReadonly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataTypeDecorator.Json()).isReadonly());
  }

  /**
   * Method under test: {@link ImmutableDataTypeDecorator.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataTypeDecorator.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableDataTypeDecorator.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataTypeDecorator.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableDataTypeDecorator.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableDataTypeDecorator.Json actualJson = new ImmutableDataTypeDecorator.Json();

    // Assert
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.decoratorEntity);
    assertNull(actualJson.entityReference);
    assertFalse(actualJson.flowClassificationRuleId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.inboundFlowClassificationRuleId.isPresent());
    assertFalse(actualJson.rating.isPresent());
    assertFalse(actualJson.targetInboundRating.isPresent());
    assertFalse(actualJson.isReadonly);
    assertFalse(actualJson.isReadonlyIsSet);
  }

  /**
   * Method under test: {@link ImmutableDataTypeDecorator.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataTypeDecorator.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableDataTypeDecorator.Json#rating()}
   */
  @Test
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataTypeDecorator.Json()).rating());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Json#setIsReadonly(boolean)}
   */
  @Test
  void testJsonSetIsReadonly() {
    // Arrange
    ImmutableDataTypeDecorator.Json json = new ImmutableDataTypeDecorator.Json();

    // Act
    json.setIsReadonly(true);

    // Assert
    assertTrue(json.isReadonly);
    assertTrue(json.isReadonlyIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Json#setIsReadonly(boolean)}
   */
  @Test
  void testJsonSetIsReadonly2() {
    // Arrange
    ImmutableDataTypeDecorator.Json json = new ImmutableDataTypeDecorator.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setIsReadonly(true);

    // Assert
    assertTrue(json.isReadonly);
    assertTrue(json.isReadonlyIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecorator.Json#targetInboundRating()}
   */
  @Test
  void testJsonTargetInboundRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeDecorator.Json()).targetInboundRating());
  }
}
