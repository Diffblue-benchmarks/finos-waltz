package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.attestation.ImmutableApplicationAttestationSummaryCounts.Builder;
import org.finos.waltz.model.attestation.ImmutableApplicationAttestationSummaryCounts.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationAttestationSummaryCountsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAttestationCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAttestationCounts(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllAttestationCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAttestationCounts(Iterable)"})
  void testBuilderAddAllAttestationCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryCounts.builder();

    // Act
    Builder actualAddAllAttestationCountsResult =
        builderResult.addAllAttestationCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAttestationCountsResult);
  }

  /**
   * Test Builder {@link Builder#addAttestationCounts(AttestationCount)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableAttestationCount.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAttestationCounts(AttestationCount)}
   */
  @Test
  @DisplayName(
      "Test Builder addAttestationCounts(AttestationCount) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAttestationCounts(AttestationCount)"})
  void testBuilderAddAttestationCountsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryCounts.builder();

    // Act
    Builder actualAddAttestationCountsResult =
        builderResult.addAttestationCounts(new ImmutableAttestationCount.Json());

    // Assert
    assertSame(builderResult, actualAddAttestationCountsResult);
  }

  /**
   * Test Builder {@link Builder#addAttestationCounts(AttestationCount[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableAttestationCount.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAttestationCounts(AttestationCount[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAttestationCounts(AttestationCount[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAttestationCounts(AttestationCount[])"})
  void testBuilderAddAttestationCountsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryCounts.builder();

    // Act
    Builder actualAddAttestationCountsResult =
        builderResult.addAttestationCounts(new ImmutableAttestationCount.Json());

    // Assert
    assertSame(builderResult, actualAddAttestationCountsResult);
  }

  /**
   * Test Builder {@link Builder#attestationCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#attestationCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder attestationCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.attestationCounts(Iterable)"})
  void testBuilderAttestationCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryCounts.builder();

    // Act
    Builder actualAttestationCountsResult = builderResult.attestationCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAttestationCountsResult);
  }

  /**
   * Test Builder {@link Builder#attestedKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#attestedKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder attestedKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.attestedKind(EntityKind)"})
  void testBuilderAttestedKind() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryCounts.builder();

    // Act
    Builder actualAttestedKindResult = builderResult.attestedKind(EntityKind.ALL);

    // Assert
    ImmutableApplicationAttestationSummaryCounts immutableApplicationAttestationSummaryCounts =
        builderResult.build();
    assertNull(immutableApplicationAttestationSummaryCounts.attestedId());
    assertEquals(EntityKind.ALL, immutableApplicationAttestationSummaryCounts.attestedKind());
    assertSame(builderResult, actualAttestedKindResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#attestedId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.attestedId(Long)",
    "ImmutableApplicationAttestationSummaryCounts Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableApplicationAttestationSummaryCounts
        actualImmutableApplicationAttestationSummaryCounts =
            ImmutableApplicationAttestationSummaryCounts.builder()
                .attestedId(1L)
                .attestedKind(EntityKind.ALL)
                .build();

    // Assert
    assertEquals(1L, actualImmutableApplicationAttestationSummaryCounts.attestedId().longValue());
    assertEquals(EntityKind.ALL, actualImmutableApplicationAttestationSummaryCounts.attestedKind());
    assertTrue(actualImmutableApplicationAttestationSummaryCounts.attestationCounts().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationSummaryCounts)}.
   *
   * <ul>
   *   <li>Given builder count three key {@code Key} build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ApplicationAttestationSummaryCounts)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ApplicationAttestationSummaryCounts); given builder count three key 'Key' build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationSummaryCounts)"})
  void testBuilderFrom_givenBuilderCountThreeKeyKeyBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryCounts.builder();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryCounts.builder();
    builderResult2.addAttestationCounts(
        ImmutableAttestationCount.builder().count(3).key("Key").build());
    ImmutableApplicationAttestationSummaryCounts instance =
        builderResult2.attestedId(1L).attestedKind(EntityKind.ALL).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableApplicationAttestationSummaryCounts
        actualImmutableApplicationAttestationSummaryCounts = builderResult.build();
    assertEquals(instance, actualImmutableApplicationAttestationSummaryCounts);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationSummaryCounts)}.
   *
   * <ul>
   *   <li>Then return build is builder attestedId {@code null} attestedKind {@code ALL} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ApplicationAttestationSummaryCounts)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ApplicationAttestationSummaryCounts); then return build is builder attestedId 'null' attestedKind 'ALL' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationSummaryCounts)"})
  void testBuilderFrom_thenReturnBuildIsBuilderAttestedIdNullAttestedKindAllBuild() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryCounts.builder();
    ImmutableApplicationAttestationSummaryCounts instance =
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(null)
            .attestedKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableApplicationAttestationSummaryCounts
        actualImmutableApplicationAttestationSummaryCounts = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableApplicationAttestationSummaryCounts);
    ImmutableApplicationAttestationSummaryCounts
        actualImmutableApplicationAttestationSummaryCounts2 = builderResult.build();
    assertEquals(instance, actualImmutableApplicationAttestationSummaryCounts2);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationSummaryCounts)}.
   *
   * <ul>
   *   <li>Then return build is builder attestedId one attestedKind {@code ALL} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ApplicationAttestationSummaryCounts)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ApplicationAttestationSummaryCounts); then return build is builder attestedId one attestedKind 'ALL' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationSummaryCounts)"})
  void testBuilderFrom_thenReturnBuildIsBuilderAttestedIdOneAttestedKindAllBuild() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryCounts.builder();
    ImmutableApplicationAttestationSummaryCounts instance =
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(1L)
            .attestedKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableApplicationAttestationSummaryCounts
        actualImmutableApplicationAttestationSummaryCounts = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableApplicationAttestationSummaryCounts);
    ImmutableApplicationAttestationSummaryCounts
        actualImmutableApplicationAttestationSummaryCounts2 = builderResult.build();
    assertEquals(instance, actualImmutableApplicationAttestationSummaryCounts2);
  }

  /**
   * Test {@link
   * ImmutableApplicationAttestationSummaryCounts#copyOf(ApplicationAttestationSummaryCounts)}.
   *
   * <ul>
   *   <li>Then return attestedId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryCounts#copyOf(ApplicationAttestationSummaryCounts)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ApplicationAttestationSummaryCounts); then return attestedId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryCounts ImmutableApplicationAttestationSummaryCounts.copyOf(ApplicationAttestationSummaryCounts)"
  })
  void testCopyOf_thenReturnAttestedIdLongValueIsOne() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts instance =
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(1L)
            .attestedKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableApplicationAttestationSummaryCounts actualCopyOfResult =
        ImmutableApplicationAttestationSummaryCounts.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.attestedId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedKind());
    assertTrue(actualCopyOfResult.attestationCounts().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryCounts#equals(Object)}, and {@link
   * ImmutableApplicationAttestationSummaryCounts#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationAttestationSummaryCounts#equals(Object)}
   *   <li>{@link ImmutableApplicationAttestationSummaryCounts#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationSummaryCounts.equals(Object)",
    "int ImmutableApplicationAttestationSummaryCounts.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts immutableApplicationAttestationSummaryCounts =
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(1L)
            .attestedKind(EntityKind.ALL)
            .build();
    ImmutableApplicationAttestationSummaryCounts immutableApplicationAttestationSummaryCounts2 =
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(1L)
            .attestedKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(
        immutableApplicationAttestationSummaryCounts,
        immutableApplicationAttestationSummaryCounts2);
    assertEquals(
        immutableApplicationAttestationSummaryCounts.hashCode(),
        immutableApplicationAttestationSummaryCounts2.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryCounts#equals(Object)}, and {@link
   * ImmutableApplicationAttestationSummaryCounts#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationAttestationSummaryCounts#equals(Object)}
   *   <li>{@link ImmutableApplicationAttestationSummaryCounts#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationSummaryCounts.equals(Object)",
    "int ImmutableApplicationAttestationSummaryCounts.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts immutableApplicationAttestationSummaryCounts =
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(1L)
            .attestedKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(
        immutableApplicationAttestationSummaryCounts, immutableApplicationAttestationSummaryCounts);
    int expectedHashCodeResult = immutableApplicationAttestationSummaryCounts.hashCode();
    assertEquals(expectedHashCodeResult, immutableApplicationAttestationSummaryCounts.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryCounts#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryCounts#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationSummaryCounts.equals(Object)",
    "int ImmutableApplicationAttestationSummaryCounts.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryCounts.builder();
    builderResult.addAttestationCounts(
        ImmutableAttestationCount.builder().count(3).key("Key").build());
    ImmutableApplicationAttestationSummaryCounts immutableApplicationAttestationSummaryCounts =
        builderResult.attestedId(1L).attestedKind(EntityKind.ALL).build();

    // Act and Assert
    assertNotEquals(
        immutableApplicationAttestationSummaryCounts,
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(1L)
            .attestedKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryCounts#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryCounts#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationSummaryCounts.equals(Object)",
    "int ImmutableApplicationAttestationSummaryCounts.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts immutableApplicationAttestationSummaryCounts =
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(2L)
            .attestedKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableApplicationAttestationSummaryCounts,
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(1L)
            .attestedKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryCounts#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryCounts#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationSummaryCounts.equals(Object)",
    "int ImmutableApplicationAttestationSummaryCounts.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts immutableApplicationAttestationSummaryCounts =
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(1L)
            .attestedKind(EntityKind.ACTOR)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableApplicationAttestationSummaryCounts,
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(1L)
            .attestedKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryCounts#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryCounts#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationSummaryCounts.equals(Object)",
    "int ImmutableApplicationAttestationSummaryCounts.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(1L)
            .attestedKind(EntityKind.ALL)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryCounts#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryCounts#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationSummaryCounts.equals(Object)",
    "int ImmutableApplicationAttestationSummaryCounts.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(1L)
            .attestedKind(EntityKind.ALL)
            .build(),
        "Different type to ImmutableApplicationAttestationSummaryCounts");
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryCounts#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) AttestationCounts is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryCounts#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) AttestationCounts is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryCounts ImmutableApplicationAttestationSummaryCounts.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonAttestationCountsIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setAttestedKind(EntityKind.ALL);
    json.setAttestedId(1L);
    json.setAttestationCounts(new HashSet<>());

    // Act
    ImmutableApplicationAttestationSummaryCounts actualFromJsonResult =
        ImmutableApplicationAttestationSummaryCounts.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.attestedId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.attestedKind());
    assertTrue(actualFromJsonResult.attestationCounts().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryCounts#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableAttestationCount.Json}
   *       (default constructor).
   *   <li>Then return attestationCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryCounts#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return attestationCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryCounts ImmutableApplicationAttestationSummaryCounts.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnAttestationCountsSizeIsOne() {
    // Arrange
    LinkedHashSet<AttestationCount> attestationCounts = new LinkedHashSet<>();
    attestationCounts.add(new ImmutableAttestationCount.Json());

    Json json = new Json();
    json.setAttestedKind(EntityKind.ALL);
    json.setAttestedId(1L);
    json.setAttestationCounts(attestationCounts);

    // Act
    ImmutableApplicationAttestationSummaryCounts actualFromJsonResult =
        ImmutableApplicationAttestationSummaryCounts.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.attestationCounts().size());
    assertEquals(1L, actualFromJsonResult.attestedId().longValue());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryCounts#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) AttestedId is {@code null}.
   *   <li>Then return attestedId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryCounts#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) AttestedId is 'null'; then return attestedId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryCounts ImmutableApplicationAttestationSummaryCounts.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonAttestedIdIsNull_thenReturnAttestedIdIsNull() {
    // Arrange
    LinkedHashSet<AttestationCount> attestationCounts = new LinkedHashSet<>();
    attestationCounts.add(new ImmutableAttestationCount.Json());

    Json json = new Json();
    json.setAttestedKind(EntityKind.ALL);
    json.setAttestedId(null);
    json.setAttestationCounts(attestationCounts);

    // Act
    ImmutableApplicationAttestationSummaryCounts actualFromJsonResult =
        ImmutableApplicationAttestationSummaryCounts.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.attestedId());
    assertEquals(1, actualFromJsonResult.attestationCounts().size());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryCounts#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return attestationCounts is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryCounts#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return attestationCounts is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryCounts ImmutableApplicationAttestationSummaryCounts.fromJson(Json)"
  })
  void testFromJson_thenReturnAttestationCountsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<AttestationCount> attestationCounts = new LinkedHashSet<>();
    attestationCounts.add(ImmutableAttestationCount.builder().count(3).key("Key").build());
    attestationCounts.add(new ImmutableAttestationCount.Json());

    Json json = new Json();
    json.setAttestedKind(EntityKind.ALL);
    json.setAttestedId(1L);
    json.setAttestationCounts(attestationCounts);

    // Act
    ImmutableApplicationAttestationSummaryCounts actualFromJsonResult =
        ImmutableApplicationAttestationSummaryCounts.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.attestedId().longValue());
    assertEquals(attestationCounts, actualFromJsonResult.attestationCounts());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryCounts#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) AttestationCounts is {@code null}.
   *   <li>Then return attestedKind is {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryCounts#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) AttestationCounts is 'null'; then return attestedKind is 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryCounts ImmutableApplicationAttestationSummaryCounts.fromJson(Json)"
  })
  void testFromJson_whenJsonAttestationCountsIsNull_thenReturnAttestedKindIsAll() {
    // Arrange
    Json json = new Json();
    json.setAttestedKind(EntityKind.ALL);
    json.setAttestedId(1L);
    json.setAttestationCounts(null);

    // Act
    ImmutableApplicationAttestationSummaryCounts actualFromJsonResult =
        ImmutableApplicationAttestationSummaryCounts.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.attestedId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.attestedKind());
    assertTrue(actualFromJsonResult.attestationCounts().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationAttestationSummaryCounts#toString()}
   *   <li>{@link ImmutableApplicationAttestationSummaryCounts#attestationCounts()}
   *   <li>{@link ImmutableApplicationAttestationSummaryCounts#attestedId()}
   *   <li>{@link ImmutableApplicationAttestationSummaryCounts#attestedKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableApplicationAttestationSummaryCounts.attestationCounts()",
    "Long ImmutableApplicationAttestationSummaryCounts.attestedId()",
    "EntityKind ImmutableApplicationAttestationSummaryCounts.attestedKind()",
    "String ImmutableApplicationAttestationSummaryCounts.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts immutableApplicationAttestationSummaryCounts =
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(1L)
            .attestedKind(EntityKind.ALL)
            .build();

    // Act
    String actualToStringResult = immutableApplicationAttestationSummaryCounts.toString();
    Set<AttestationCount> actualAttestationCountsResult =
        immutableApplicationAttestationSummaryCounts.attestationCounts();
    Long actualAttestedIdResult = immutableApplicationAttestationSummaryCounts.attestedId();
    EntityKind actualAttestedKindResult =
        immutableApplicationAttestationSummaryCounts.attestedKind();

    // Assert
    assertEquals(
        "ApplicationAttestationSummaryCounts{attestedKind=ALL, attestedId=1, attestationCounts=[]}",
        actualToStringResult);
    assertEquals(1L, actualAttestedIdResult.longValue());
    assertEquals(EntityKind.ALL, actualAttestedKindResult);
    assertTrue(actualAttestationCountsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#attestationCounts()}.
   *
   * <p>Method under test: {@link Json#attestationCounts()}
   */
  @Test
  @DisplayName("Test Json attestationCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.attestationCounts()"})
  void testJsonAttestationCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestationCounts());
  }

  /**
   * Test Json {@link Json#attestedId()}.
   *
   * <p>Method under test: {@link Json#attestedId()}
   */
  @Test
  @DisplayName("Test Json attestedId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.attestedId()"})
  void testJsonAttestedId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestedId());
  }

  /**
   * Test Json {@link Json#attestedKind()}.
   *
   * <p>Method under test: {@link Json#attestedKind()}
   */
  @Test
  @DisplayName("Test Json attestedKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.attestedKind()"})
  void testJsonAttestedKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestedKind());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.attestedId);
    assertNull(actualJson.attestedKind);
    assertTrue(actualJson.attestationCounts.isEmpty());
  }

  /**
   * Test {@link
   * ImmutableApplicationAttestationSummaryCounts#withAttestationCounts(AttestationCount[])} with
   * {@code AttestationCount[]}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryCounts#withAttestationCounts(AttestationCount[])}
   */
  @Test
  @DisplayName("Test withAttestationCounts(AttestationCount[]) with 'AttestationCount[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryCounts ImmutableApplicationAttestationSummaryCounts.withAttestationCounts(AttestationCount[])"
  })
  void testWithAttestationCountsWithAttestationCount() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts immutableApplicationAttestationSummaryCounts =
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(1L)
            .attestedKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableApplicationAttestationSummaryCounts actualWithAttestationCountsResult =
        immutableApplicationAttestationSummaryCounts.withAttestationCounts(
            ImmutableAttestationCount.builder().count(3).key("Key").build());

    // Assert
    assertEquals(1, actualWithAttestationCountsResult.attestationCounts().size());
    assertEquals(1L, actualWithAttestationCountsResult.attestedId().longValue());
    assertEquals(EntityKind.ALL, actualWithAttestationCountsResult.attestedKind());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryCounts#withAttestedId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return attestedId longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryCounts#withAttestedId(Long)}
   */
  @Test
  @DisplayName(
      "Test withAttestedId(Long); when forty-two; then return attestedId longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryCounts ImmutableApplicationAttestationSummaryCounts.withAttestedId(Long)"
  })
  void testWithAttestedId_whenFortyTwo_thenReturnAttestedIdLongValueIsFortyTwo() {
    // Arrange and Act
    ImmutableApplicationAttestationSummaryCounts actualWithAttestedIdResult =
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(1L)
            .attestedKind(EntityKind.ALL)
            .build()
            .withAttestedId(42L);

    // Assert
    assertEquals(42L, actualWithAttestedIdResult.attestedId().longValue());
    assertEquals(EntityKind.ALL, actualWithAttestedIdResult.attestedKind());
    assertTrue(actualWithAttestedIdResult.attestationCounts().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryCounts#withAttestedId(Long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder attestedId one attestedKind {@code ALL} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryCounts#withAttestedId(Long)}
   */
  @Test
  @DisplayName(
      "Test withAttestedId(Long); when one; then return builder attestedId one attestedKind 'ALL' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryCounts ImmutableApplicationAttestationSummaryCounts.withAttestedId(Long)"
  })
  void testWithAttestedId_whenOne_thenReturnBuilderAttestedIdOneAttestedKindAllBuild() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts immutableApplicationAttestationSummaryCounts =
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(1L)
            .attestedKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableApplicationAttestationSummaryCounts actualWithAttestedIdResult =
        immutableApplicationAttestationSummaryCounts.withAttestedId(1L);

    // Assert
    assertSame(immutableApplicationAttestationSummaryCounts, actualWithAttestedIdResult);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryCounts#withAttestedKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return attestedId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryCounts#withAttestedKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withAttestedKind(EntityKind); then return attestedId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryCounts ImmutableApplicationAttestationSummaryCounts.withAttestedKind(EntityKind)"
  })
  void testWithAttestedKind_thenReturnAttestedIdLongValueIsOne() {
    // Arrange and Act
    ImmutableApplicationAttestationSummaryCounts actualWithAttestedKindResult =
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(1L)
            .attestedKind(EntityKind.ACTOR)
            .build()
            .withAttestedKind(EntityKind.ALL);

    // Assert
    assertEquals(1L, actualWithAttestedKindResult.attestedId().longValue());
    assertEquals(EntityKind.ALL, actualWithAttestedKindResult.attestedKind());
    assertTrue(actualWithAttestedKindResult.attestationCounts().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryCounts#withAttestedKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return builder attestedId one attestedKind {@code ALL} build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryCounts#withAttestedKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withAttestedKind(EntityKind); then return builder attestedId one attestedKind 'ALL' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryCounts ImmutableApplicationAttestationSummaryCounts.withAttestedKind(EntityKind)"
  })
  void testWithAttestedKind_thenReturnBuilderAttestedIdOneAttestedKindAllBuild() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts immutableApplicationAttestationSummaryCounts =
        ImmutableApplicationAttestationSummaryCounts.builder()
            .attestedId(1L)
            .attestedKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableApplicationAttestationSummaryCounts actualWithAttestedKindResult =
        immutableApplicationAttestationSummaryCounts.withAttestedKind(EntityKind.ALL);

    // Assert
    assertSame(immutableApplicationAttestationSummaryCounts, actualWithAttestedKindResult);
  }
}
