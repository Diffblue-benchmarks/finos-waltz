package org.finos.waltz.model.measurable_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.measurable_relationship.ImmutableMeasurableRelationship.Builder;
import org.finos.waltz.model.measurable_relationship.ImmutableMeasurableRelationship.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRelationshipDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRelationship Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    ImmutableMeasurableRelationship actualImmutableMeasurableRelationship =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableMeasurableRelationship.lastUpdatedBy());
    assertEquals("Provenance", actualImmutableMeasurableRelationship.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableMeasurableRelationship.description());
    assertEquals(1L, actualImmutableMeasurableRelationship.measurableA());
    assertEquals(1L, actualImmutableMeasurableRelationship.measurableB());
    assertEquals(
        MeasurableRelationshipKind.WEAKLY_RELATES_TO,
        actualImmutableMeasurableRelationship.relationshipKind());
    assertSame(lastUpdatedAt, actualImmutableMeasurableRelationship.lastUpdatedAt());
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();
    ImmutableMeasurableRelationship instance =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act and Assert
    ImmutableMeasurableRelationship actualImmutableMeasurableRelationship =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurableRelationship);
    ImmutableMeasurableRelationship actualImmutableMeasurableRelationship2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRelationship2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();
    ImmutableMeasurableRelationship instance =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act and Assert
    ImmutableMeasurableRelationship actualImmutableMeasurableRelationship =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurableRelationship);
    ImmutableMeasurableRelationship actualImmutableMeasurableRelationship2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRelationship2);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedBy()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider3() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();

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
   * Test Builder {@link Builder#from(MeasurableRelationship)} with {@code MeasurableRelationship}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRelationship) with 'MeasurableRelationship'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableRelationship)"})
  void testBuilderFromWithMeasurableRelationship() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();
    ImmutableMeasurableRelationship instance =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableRelationship actualImmutableMeasurableRelationship = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRelationship);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRelationship)} with {@code MeasurableRelationship}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRelationship) with 'MeasurableRelationship'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableRelationship)"})
  void testBuilderFromWithMeasurableRelationship2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();
    ImmutableMeasurableRelationship instance =
        ImmutableMeasurableRelationship.builder()
            .description(null)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableRelationship actualImmutableMeasurableRelationship = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRelationship);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableActor.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isExternal(true)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();
    ImmutableMeasurableRelationship instance =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act and Assert
    ImmutableMeasurableRelationship actualImmutableMeasurableRelationship =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurableRelationship);
    ImmutableMeasurableRelationship actualImmutableMeasurableRelationship2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRelationship2);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider3() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableActor.builder()
                    .description(null)
                    .externalId("42")
                    .id(1L)
                    .isExternal(true)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>When {@code 2020-03-01}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String); when '2020-03-01'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy_when20200301_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#measurableA(long)}.
   *
   * <p>Method under test: {@link Builder#measurableA(long)}
   */
  @Test
  @DisplayName("Test Builder measurableA(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableA(long)"})
  void testBuilderMeasurableA() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();

    // Act
    Builder actualMeasurableAResult = builderResult.measurableA(1L);

    // Assert
    assertSame(builderResult, actualMeasurableAResult);
  }

  /**
   * Test Builder {@link Builder#measurableB(long)}.
   *
   * <p>Method under test: {@link Builder#measurableB(long)}
   */
  @Test
  @DisplayName("Test Builder measurableB(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableB(long)"})
  void testBuilderMeasurableB() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();

    // Act
    Builder actualMeasurableBResult = builderResult.measurableB(1L);

    // Assert
    assertSame(builderResult, actualMeasurableBResult);
  }

  /**
   * Test Builder {@link Builder#relationshipKind(MeasurableRelationshipKind)}.
   *
   * <p>Method under test: {@link Builder#relationshipKind(MeasurableRelationshipKind)}
   */
  @Test
  @DisplayName("Test Builder relationshipKind(MeasurableRelationshipKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.relationshipKind(MeasurableRelationshipKind)"})
  void testBuilderRelationshipKind() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRelationship.builder();

    // Act
    Builder actualRelationshipKindResult =
        builderResult.relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO);

    // Assert
    assertSame(builderResult, actualRelationshipKindResult);
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#copyOf(MeasurableRelationship)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#copyOf(MeasurableRelationship)}
   */
  @Test
  @DisplayName(
      "Test copyOf(MeasurableRelationship); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRelationship ImmutableMeasurableRelationship.copyOf(MeasurableRelationship)"
  })
  void testCopyOf_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableMeasurableRelationship instance =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act
    ImmutableMeasurableRelationship actualCopyOfResult =
        ImmutableMeasurableRelationship.copyOf(instance);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.measurableA());
    assertEquals(1L, actualCopyOfResult.measurableB());
    assertEquals(
        MeasurableRelationshipKind.WEAKLY_RELATES_TO, actualCopyOfResult.relationshipKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#equals(Object)}, and {@link
   * ImmutableMeasurableRelationship#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRelationship#equals(Object)}
   *   <li>{@link ImmutableMeasurableRelationship#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRelationship.equals(Object)",
    "int ImmutableMeasurableRelationship.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableRelationship immutableMeasurableRelationship =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();
    ImmutableMeasurableRelationship immutableMeasurableRelationship2 =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableRelationship, immutableMeasurableRelationship2);
    assertEquals(
        immutableMeasurableRelationship.hashCode(), immutableMeasurableRelationship2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#equals(Object)}, and {@link
   * ImmutableMeasurableRelationship#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRelationship#equals(Object)}
   *   <li>{@link ImmutableMeasurableRelationship#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRelationship.equals(Object)",
    "int ImmutableMeasurableRelationship.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableRelationship immutableMeasurableRelationship =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableRelationship, immutableMeasurableRelationship);
    int expectedHashCodeResult = immutableMeasurableRelationship.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableRelationship.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRelationship.equals(Object)",
    "int ImmutableMeasurableRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableMeasurableRelationship immutableMeasurableRelationship =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRelationship,
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRelationship.equals(Object)",
    "int ImmutableMeasurableRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableMeasurableRelationship immutableMeasurableRelationship =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRelationship,
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRelationship.equals(Object)",
    "int ImmutableMeasurableRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableMeasurableRelationship immutableMeasurableRelationship =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(0L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRelationship,
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRelationship.equals(Object)",
    "int ImmutableMeasurableRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableMeasurableRelationship immutableMeasurableRelationship =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(0L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRelationship,
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRelationship.equals(Object)",
    "int ImmutableMeasurableRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableMeasurableRelationship immutableMeasurableRelationship =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("2020-03-01")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRelationship,
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRelationship.equals(Object)",
    "int ImmutableMeasurableRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableMeasurableRelationship immutableMeasurableRelationship =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.STRONGLY_RELATES_TO)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRelationship,
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRelationship.equals(Object)",
    "int ImmutableMeasurableRelationship.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRelationship.equals(Object)",
    "int ImmutableMeasurableRelationship.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build(),
        "Different type to ImmutableMeasurableRelationship");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRelationship#toString()}
   *   <li>{@link ImmutableMeasurableRelationship#description()}
   *   <li>{@link ImmutableMeasurableRelationship#lastUpdatedBy()}
   *   <li>{@link ImmutableMeasurableRelationship#measurableA()}
   *   <li>{@link ImmutableMeasurableRelationship#measurableB()}
   *   <li>{@link ImmutableMeasurableRelationship#relationshipKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableMeasurableRelationship.description()",
    "String ImmutableMeasurableRelationship.lastUpdatedBy()",
    "long ImmutableMeasurableRelationship.measurableA()",
    "long ImmutableMeasurableRelationship.measurableB()",
    "MeasurableRelationshipKind ImmutableMeasurableRelationship.relationshipKind()",
    "String ImmutableMeasurableRelationship.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableMeasurableRelationship immutableMeasurableRelationship =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act
    String actualToStringResult = immutableMeasurableRelationship.toString();
    String actualDescriptionResult = immutableMeasurableRelationship.description();
    String actualLastUpdatedByResult = immutableMeasurableRelationship.lastUpdatedBy();
    long actualMeasurableAResult = immutableMeasurableRelationship.measurableA();
    long actualMeasurableBResult = immutableMeasurableRelationship.measurableB();

    // Assert
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals(
        "MeasurableRelationship{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance,"
            + " measurableA=1, measurableB=1, relationshipKind=WEAKLY_RELATES_TO}",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualMeasurableAResult);
    assertEquals(1L, actualMeasurableBResult);
    assertEquals(
        MeasurableRelationshipKind.WEAKLY_RELATES_TO,
        immutableMeasurableRelationship.relationshipKind());
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link Json#setLastUpdatedBy(String)}
   *   <li>{@link Json#setProvenance(String)}
   *   <li>{@link Json#setRelationshipKind(MeasurableRelationshipKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDescription(String)",
    "void Json.setLastUpdatedAt(LocalDateTime)",
    "void Json.setLastUpdatedBy(String)",
    "void Json.setProvenance(String)",
    "void Json.setRelationshipKind(MeasurableRelationshipKind)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setProvenance("Provenance");
    actualJson.setRelationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO);

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedBy());
  }

  /**
   * Test Json {@link Json#measurableA()}.
   *
   * <p>Method under test: {@link Json#measurableA()}
   */
  @Test
  @DisplayName("Test Json measurableA()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.measurableA()"})
  void testJsonMeasurableA() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableA());
  }

  /**
   * Test Json {@link Json#measurableB()}.
   *
   * <p>Method under test: {@link Json#measurableB()}
   */
  @Test
  @DisplayName("Test Json measurableB()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.measurableB()"})
  void testJsonMeasurableB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableB());
  }

  /**
   * Test Json {@link Json#provenance()}.
   *
   * <p>Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().provenance());
  }

  /**
   * Test Json {@link Json#relationshipKind()}.
   *
   * <p>Method under test: {@link Json#relationshipKind()}
   */
  @Test
  @DisplayName("Test Json relationshipKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRelationshipKind Json.relationshipKind()"})
  void testJsonRelationshipKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().relationshipKind());
  }

  /**
   * Test Json {@link Json#setMeasurableA(long)}.
   *
   * <p>Method under test: {@link Json#setMeasurableA(long)}
   */
  @Test
  @DisplayName("Test Json setMeasurableA(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setMeasurableA(long)"})
  void testJsonSetMeasurableA() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMeasurableA(1L);

    // Assert
    assertEquals(1L, json.measurableA);
    assertTrue(json.measurableAIsSet);
  }

  /**
   * Test Json {@link Json#setMeasurableB(long)}.
   *
   * <p>Method under test: {@link Json#setMeasurableB(long)}
   */
  @Test
  @DisplayName("Test Json setMeasurableB(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setMeasurableB(long)"})
  void testJsonSetMeasurableB() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMeasurableB(1L);

    // Assert
    assertEquals(1L, json.measurableB);
    assertTrue(json.measurableBIsSet);
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableMeasurableRelationship.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#provenance()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableMeasurableRelationship.provenance()"})
  void testProvenance() {
    // Arrange, Act and Assert
    assertEquals(
        "Provenance",
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRelationship ImmutableMeasurableRelationship.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableMeasurableRelationship immutableMeasurableRelationship =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act
    ImmutableMeasurableRelationship actualWithDescriptionResult =
        immutableMeasurableRelationship.withDescription("42");

    // Assert
    assertEquals(immutableMeasurableRelationship, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRelationship ImmutableMeasurableRelationship.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableMeasurableRelationship immutableMeasurableRelationship =
        ImmutableMeasurableRelationship.builder()
            .description("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act
    ImmutableMeasurableRelationship actualWithDescriptionResult =
        immutableMeasurableRelationship.withDescription("42");

    // Assert
    assertSame(immutableMeasurableRelationship, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRelationship ImmutableMeasurableRelationship.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableMeasurableRelationship immutableMeasurableRelationship =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act
    ImmutableMeasurableRelationship actualWithLastUpdatedAtResult =
        immutableMeasurableRelationship.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableMeasurableRelationship, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRelationship ImmutableMeasurableRelationship.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    ImmutableMeasurableRelationship immutableMeasurableRelationship =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act
    ImmutableMeasurableRelationship actualWithLastUpdatedByResult =
        immutableMeasurableRelationship.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableMeasurableRelationship, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRelationship ImmutableMeasurableRelationship.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableRelationship actualWithLastUpdatedByResult =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithLastUpdatedByResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals(1L, actualWithLastUpdatedByResult.measurableA());
    assertEquals(1L, actualWithLastUpdatedByResult.measurableB());
    assertEquals(
        MeasurableRelationshipKind.WEAKLY_RELATES_TO,
        actualWithLastUpdatedByResult.relationshipKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#withMeasurableA(long)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#withMeasurableA(long)}
   */
  @Test
  @DisplayName("Test withMeasurableA(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRelationship ImmutableMeasurableRelationship.withMeasurableA(long)"
  })
  void testWithMeasurableA() {
    // Arrange
    ImmutableMeasurableRelationship immutableMeasurableRelationship =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(42L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act
    ImmutableMeasurableRelationship actualWithMeasurableAResult =
        immutableMeasurableRelationship.withMeasurableA(42L);

    // Assert
    assertSame(immutableMeasurableRelationship, actualWithMeasurableAResult);
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#withMeasurableA(long)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#withMeasurableA(long)}
   */
  @Test
  @DisplayName(
      "Test withMeasurableA(long); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRelationship ImmutableMeasurableRelationship.withMeasurableA(long)"
  })
  void testWithMeasurableA_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableRelationship actualWithMeasurableAResult =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build()
            .withMeasurableA(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithMeasurableAResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithMeasurableAResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithMeasurableAResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithMeasurableAResult.description());
    assertEquals(1L, actualWithMeasurableAResult.measurableB());
    assertEquals(42L, actualWithMeasurableAResult.measurableA());
    assertEquals(
        MeasurableRelationshipKind.WEAKLY_RELATES_TO,
        actualWithMeasurableAResult.relationshipKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#withMeasurableB(long)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#withMeasurableB(long)}
   */
  @Test
  @DisplayName("Test withMeasurableB(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRelationship ImmutableMeasurableRelationship.withMeasurableB(long)"
  })
  void testWithMeasurableB() {
    // Arrange
    ImmutableMeasurableRelationship immutableMeasurableRelationship =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(42L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act
    ImmutableMeasurableRelationship actualWithMeasurableBResult =
        immutableMeasurableRelationship.withMeasurableB(42L);

    // Assert
    assertSame(immutableMeasurableRelationship, actualWithMeasurableBResult);
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#withMeasurableB(long)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#withMeasurableB(long)}
   */
  @Test
  @DisplayName(
      "Test withMeasurableB(long); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRelationship ImmutableMeasurableRelationship.withMeasurableB(long)"
  })
  void testWithMeasurableB_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableRelationship actualWithMeasurableBResult =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build()
            .withMeasurableB(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithMeasurableBResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithMeasurableBResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithMeasurableBResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithMeasurableBResult.description());
    assertEquals(1L, actualWithMeasurableBResult.measurableA());
    assertEquals(42L, actualWithMeasurableBResult.measurableB());
    assertEquals(
        MeasurableRelationshipKind.WEAKLY_RELATES_TO,
        actualWithMeasurableBResult.relationshipKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRelationship ImmutableMeasurableRelationship.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    ImmutableMeasurableRelationship immutableMeasurableRelationship =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("42")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act
    ImmutableMeasurableRelationship actualWithProvenanceResult =
        immutableMeasurableRelationship.withProvenance("42");

    // Assert
    assertSame(immutableMeasurableRelationship, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRelationship#withProvenance(String)}
   */
  @Test
  @DisplayName(
      "Test withProvenance(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRelationship ImmutableMeasurableRelationship.withProvenance(String)"
  })
  void testWithProvenance_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableRelationship actualWithProvenanceResult =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build()
            .withProvenance("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithProvenanceResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithProvenanceResult.lastUpdatedBy());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(1L, actualWithProvenanceResult.measurableA());
    assertEquals(1L, actualWithProvenanceResult.measurableB());
    assertEquals(
        MeasurableRelationshipKind.WEAKLY_RELATES_TO,
        actualWithProvenanceResult.relationshipKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#withRelationshipKind(MeasurableRelationshipKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRelationship#withRelationshipKind(MeasurableRelationshipKind)}
   */
  @Test
  @DisplayName("Test withRelationshipKind(MeasurableRelationshipKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRelationship ImmutableMeasurableRelationship.withRelationshipKind(MeasurableRelationshipKind)"
  })
  void testWithRelationshipKind() {
    // Arrange
    ImmutableMeasurableRelationship immutableMeasurableRelationship =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO)
            .build();

    // Act
    ImmutableMeasurableRelationship actualWithRelationshipKindResult =
        immutableMeasurableRelationship.withRelationshipKind(
            MeasurableRelationshipKind.WEAKLY_RELATES_TO);

    // Assert
    assertSame(immutableMeasurableRelationship, actualWithRelationshipKindResult);
  }

  /**
   * Test {@link ImmutableMeasurableRelationship#withRelationshipKind(MeasurableRelationshipKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRelationship#withRelationshipKind(MeasurableRelationshipKind)}
   */
  @Test
  @DisplayName(
      "Test withRelationshipKind(MeasurableRelationshipKind); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRelationship ImmutableMeasurableRelationship.withRelationshipKind(MeasurableRelationshipKind)"
  })
  void testWithRelationshipKind_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableRelationship actualWithRelationshipKindResult =
        ImmutableMeasurableRelationship.builder()
            .description("The characteristics of someone or something")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableA(1L)
            .measurableB(1L)
            .provenance("Provenance")
            .relationshipKind(MeasurableRelationshipKind.STRONGLY_RELATES_TO)
            .build()
            .withRelationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithRelationshipKindResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithRelationshipKindResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithRelationshipKindResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithRelationshipKindResult.description());
    assertEquals(1L, actualWithRelationshipKindResult.measurableA());
    assertEquals(1L, actualWithRelationshipKindResult.measurableB());
    assertEquals(
        MeasurableRelationshipKind.WEAKLY_RELATES_TO,
        actualWithRelationshipKindResult.relationshipKind());
    assertSame(ofResult, toLocalDateResult);
  }
}
