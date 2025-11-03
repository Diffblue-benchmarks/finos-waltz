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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.WaltzEntity;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecorator.Builder;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecorator.Json;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeDecoratorDiffblueTest {
  /**
   * Test {@link ImmutableDataTypeDecorator#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableDataTypeDecorator#builder()}
   *   <li>{@link ImmutableDataTypeDecorator#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableDataTypeDecorator#provenance(String)}
   *   <li>{@link ImmutableDataTypeDecorator#rating(AuthoritativenessRatingValue)}
   *   <li>{@link ImmutableDataTypeDecorator#targetInboundRating(AuthoritativenessRatingValue)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableDataTypeDecorator Builder.build()", "Builder Builder.lastUpdatedAt(LocalDateTime)",
      "Builder Builder.provenance(String)", "Builder Builder.rating(AuthoritativenessRatingValue)",
      "Builder Builder.targetInboundRating(AuthoritativenessRatingValue)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualFlowClassificationRuleIdResult = ImmutableDataTypeDecorator.builder().flowClassificationRuleId(1L);
    Optional<Long> flowClassificationRuleId = Optional.<Long>of(1L);
    Builder actualIdResult = actualFlowClassificationRuleIdResult.flowClassificationRuleId(flowClassificationRuleId)
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualInboundFlowClassificationRuleIdResult = actualIdResult.id(id).inboundFlowClassificationRuleId(1L);
    Optional<Long> inboundFlowClassificationRuleId = Optional.<Long>of(1L);
    Builder actualInboundFlowClassificationRuleIdResult2 = actualInboundFlowClassificationRuleIdResult
        .inboundFlowClassificationRuleId(inboundFlowClassificationRuleId);
    Builder actualProvenanceResult = actualInboundFlowClassificationRuleIdResult2
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating = Optional.of(AuthoritativenessRatingValue.of("42"));
    Builder actualRatingResult = actualProvenanceResult.rating(rating);
    Builder actualRatingResult2 = actualRatingResult.rating(AuthoritativenessRatingValue.of("42"));
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating = Optional
        .of(AuthoritativenessRatingValue.of("42"));
    Builder actualTargetInboundRatingResult = actualRatingResult2.targetInboundRating(targetInboundRating);

    // Assert
    assertSame(actualTargetInboundRatingResult,
        actualTargetInboundRatingResult.targetInboundRating(AuthoritativenessRatingValue.of("42")));
  }

  /**
   * Test Builder {@link Builder#decoratorEntity(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#decoratorEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder decoratorEntity(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.decoratorEntity(EntityReference)"})
  void testBuilderDecoratorEntity_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.decoratorEntity(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#flowClassificationRuleId(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#flowClassificationRuleId(long)}
   */
  @Test
  @DisplayName("Test Builder flowClassificationRuleId(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.flowClassificationRuleId(long)"})
  void testBuilderFlowClassificationRuleIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowClassificationRuleId(1L));
  }

  /**
   * Test Builder {@link Builder#flowClassificationRuleId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#flowClassificationRuleId(Optional)}
   */
  @Test
  @DisplayName("Test Builder flowClassificationRuleId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.flowClassificationRuleId(Optional)"})
  void testBuilderFlowClassificationRuleIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
    Optional<Long> flowClassificationRuleId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.flowClassificationRuleId(flowClassificationRuleId));
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecorator)} with {@code DataTypeDecorator}.
   * <p>
   * Method under test: {@link Builder#from(DataTypeDecorator)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecorator) with 'DataTypeDecorator'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecorator)"})
  void testBuilderFromWithDataTypeDecorator() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
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
   * Test Builder {@link Builder#from(DataTypeDecorator)} with {@code DataTypeDecorator}.
   * <p>
   * Method under test: {@link Builder#from(DataTypeDecorator)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecorator) with 'DataTypeDecorator'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecorator)"})
  void testBuilderFromWithDataTypeDecorator2() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
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
   * Test Builder {@link Builder#from(DataTypeDecorator)} with {@code DataTypeDecorator}.
   * <ul>
   *   <li>Then builder build lastUpdatedBy is {@code 2020-03-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataTypeDecorator)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecorator) with 'DataTypeDecorator'; then builder build lastUpdatedBy is '2020-03-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecorator)"})
  void testBuilderFromWithDataTypeDecorator_thenBuilderBuildLastUpdatedByIs20200301() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   * <ul>
   *   <li>Given {@code Provenance}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; given 'Provenance'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_givenProvenance_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(WaltzEntity)} with {@code WaltzEntity}.
   * <ul>
   *   <li>Given {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(WaltzEntity)}
   */
  @Test
  @DisplayName("Test Builder from(WaltzEntity) with 'WaltzEntity'; given EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(WaltzEntity)"})
  void testBuilderFromWithWaltzEntity_givenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(WaltzEntity)} with {@code WaltzEntity}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(WaltzEntity)}
   */
  @Test
  @DisplayName("Test Builder from(WaltzEntity) with 'WaltzEntity'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(WaltzEntity)"})
  void testBuilderFromWithWaltzEntity_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#inboundFlowClassificationRuleId(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#inboundFlowClassificationRuleId(long)}
   */
  @Test
  @DisplayName("Test Builder inboundFlowClassificationRuleId(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.inboundFlowClassificationRuleId(long)"})
  void testBuilderInboundFlowClassificationRuleIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.inboundFlowClassificationRuleId(1L));
  }

  /**
   * Test Builder {@link Builder#inboundFlowClassificationRuleId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#inboundFlowClassificationRuleId(Optional)}
   */
  @Test
  @DisplayName("Test Builder inboundFlowClassificationRuleId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.inboundFlowClassificationRuleId(Optional)"})
  void testBuilderInboundFlowClassificationRuleIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
    Optional<Long> inboundFlowClassificationRuleId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.inboundFlowClassificationRuleId(inboundFlowClassificationRuleId));
  }

  /**
   * Test Builder {@link Builder#isReadonly(boolean)}.
   * <p>
   * Method under test: {@link Builder#isReadonly(boolean)}
   */
  @Test
  @DisplayName("Test Builder isReadonly(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isReadonly(boolean)"})
  void testBuilderIsReadonly() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadonly(true));
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   * <p>
   * Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#rating(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#rating(Optional)}
   */
  @Test
  @DisplayName("Test Builder rating(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rating(Optional)"})
  void testBuilderRatingWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
    Optional<? extends AuthoritativenessRatingValue> rating = Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertSame(builderResult, builderResult.rating(rating));
  }

  /**
   * Test Builder {@link Builder#targetInboundRating(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#targetInboundRating(Optional)}
   */
  @Test
  @DisplayName("Test Builder targetInboundRating(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targetInboundRating(Optional)"})
  void testBuilderTargetInboundRatingWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating = Optional
        .of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertSame(builderResult, builderResult.targetInboundRating(targetInboundRating));
  }

  /**
   * Test Json {@link Json#dataFlowId()}.
   * <p>
   * Method under test: {@link Json#dataFlowId()}
   */
  @Test
  @DisplayName("Test Json dataFlowId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.dataFlowId()"})
  void testJsonDataFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dataFlowId());
  }

  /**
   * Test Json {@link Json#dataTypeId()}.
   * <p>
   * Method under test: {@link Json#dataTypeId()}
   */
  @Test
  @DisplayName("Test Json dataTypeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.dataTypeId()"})
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dataTypeId());
  }

  /**
   * Test Json {@link Json#decoratorEntity()}.
   * <p>
   * Method under test: {@link Json#decoratorEntity()}
   */
  @Test
  @DisplayName("Test Json decoratorEntity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.decoratorEntity()"})
  void testJsonDecoratorEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).decoratorEntity());
  }

  /**
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReference());
  }

  /**
   * Test Json {@link Json#flowClassificationRuleId()}.
   * <p>
   * Method under test: {@link Json#flowClassificationRuleId()}
   */
  @Test
  @DisplayName("Test Json flowClassificationRuleId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.flowClassificationRuleId()"})
  void testJsonFlowClassificationRuleId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).flowClassificationRuleId());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#inboundFlowClassificationRuleId()}.
   * <p>
   * Method under test: {@link Json#inboundFlowClassificationRuleId()}
   */
  @Test
  @DisplayName("Test Json inboundFlowClassificationRuleId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.inboundFlowClassificationRuleId()"})
  void testJsonInboundFlowClassificationRuleId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).inboundFlowClassificationRuleId());
  }

  /**
   * Test Json {@link Json#isReadonly()}.
   * <p>
   * Method under test: {@link Json#isReadonly()}
   */
  @Test
  @DisplayName("Test Json isReadonly()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isReadonly()"})
  void testJsonIsReadonly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isReadonly());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedBy());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

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
   * Test Json {@link Json#provenance()}.
   * <p>
   * Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).provenance());
  }

  /**
   * Test Json {@link Json#rating()}.
   * <p>
   * Method under test: {@link Json#rating()}
   */
  @Test
  @DisplayName("Test Json rating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rating());
  }

  /**
   * Test Json {@link Json#setIsReadonly(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsReadonly(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsReadonly(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsReadonly(boolean)"})
  void testJsonSetIsReadonly() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsReadonly(true);

    // Assert
    assertTrue(json.isReadonly);
    assertTrue(json.isReadonlyIsSet);
  }

  /**
   * Test Json {@link Json#targetInboundRating()}.
   * <p>
   * Method under test: {@link Json#targetInboundRating()}
   */
  @Test
  @DisplayName("Test Json targetInboundRating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.targetInboundRating()"})
  void testJsonTargetInboundRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).targetInboundRating());
  }
}
