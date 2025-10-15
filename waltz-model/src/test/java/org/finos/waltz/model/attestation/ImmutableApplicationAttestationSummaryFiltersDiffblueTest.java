package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.Optional;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.attestation.ImmutableApplicationAttestationSummaryFilters.Builder;
import org.finos.waltz.model.attestation.ImmutableApplicationAttestationSummaryFilters.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationAttestationSummaryFiltersDiffblueTest {
  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#appCriticality()}.
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryFilters#appCriticality()}
   */
  @Test
  @DisplayName("Test appCriticality()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableApplicationAttestationSummaryFilters.appCriticality()"})
  void testAppCriticality() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    // Act and Assert
    assertEquals(
        appCriticality,
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build()
            .appCriticality());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#appLifecyclePhase()}.
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryFilters#appLifecyclePhase()}
   */
  @Test
  @DisplayName("Test appLifecyclePhase()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableApplicationAttestationSummaryFilters.appLifecyclePhase()"})
  void testAppLifecyclePhase() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    // Act and Assert
    assertEquals(
        appLifecyclePhase,
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build()
            .appLifecyclePhase());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#attestationState()}.
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryFilters#attestationState()}
   */
  @Test
  @DisplayName("Test attestationState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableApplicationAttestationSummaryFilters.attestationState()"})
  void testAttestationState() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    // Act and Assert
    assertEquals(
        attestationState,
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build()
            .attestationState());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#attestationsFromDate()}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryFilters#attestationsFromDate()}
   */
  @Test
  @DisplayName("Test attestationsFromDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ImmutableApplicationAttestationSummaryFilters.attestationsFromDate()"
  })
  void testAttestationsFromDate() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    LocalDate attestationsFromDate = LocalDate.of(1970, 1, 1);

    // Act
    Optional<LocalDate> actualAttestationsFromDateResult =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(attestationsFromDate)
            .build()
            .attestationsFromDate();

    // Assert
    LocalDate getResult = actualAttestationsFromDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(actualAttestationsFromDateResult.isPresent());
    assertSame(attestationsFromDate, getResult);
  }

  /**
   * Test Builder {@link Builder#appCriticality(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#appCriticality(Optional)}
   */
  @Test
  @DisplayName("Test Builder appCriticality(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.appCriticality(Optional)"})
  void testBuilderAppCriticalityWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    // Act
    Builder actualAppCriticalityResult = builderResult.appCriticality(appCriticality);

    // Assert
    assertSame(builderResult, actualAppCriticalityResult);
  }

  /**
   * Test Builder {@link Builder#appLifecyclePhase(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#appLifecyclePhase(Optional)}
   */
  @Test
  @DisplayName("Test Builder appLifecyclePhase(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.appLifecyclePhase(Optional)"})
  void testBuilderAppLifecyclePhaseWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    // Act
    Builder actualAppLifecyclePhaseResult = builderResult.appLifecyclePhase(appLifecyclePhase);

    // Assert
    assertSame(builderResult, actualAppLifecyclePhaseResult);
  }

  /**
   * Test Builder {@link Builder#attestationState(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#attestationState(Optional)}
   */
  @Test
  @DisplayName("Test Builder attestationState(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.attestationState(Optional)"})
  void testBuilderAttestationStateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    // Act
    Builder actualAttestationStateResult = builderResult.attestationState(attestationState);

    // Assert
    assertSame(builderResult, actualAttestationStateResult);
  }

  /**
   * Test Builder {@link Builder#attestationsFromDate(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#attestationsFromDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder attestationsFromDate(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.attestationsFromDate(Optional)"})
  void testBuilderAttestationsFromDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends LocalDate> attestationsFromDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    Builder actualAttestationsFromDateResult =
        builderResult.attestationsFromDate(attestationsFromDate);

    // Assert
    assertSame(builderResult, actualAttestationsFromDateResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationSummaryFilters)}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationAttestationSummaryFilters)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationSummaryFilters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationSummaryFilters)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationSummaryFilters instance =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableApplicationAttestationSummaryFilters
        actualImmutableApplicationAttestationSummaryFilters = builderResult.build();
    assertEquals(instance, actualImmutableApplicationAttestationSummaryFilters);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationSummaryFilters)}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationAttestationSummaryFilters)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationSummaryFilters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationSummaryFilters)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.empty();

    Builder appCriticalityResult = builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationSummaryFilters instance =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableApplicationAttestationSummaryFilters
        actualImmutableApplicationAttestationSummaryFilters = builderResult.build();
    assertEquals(instance, actualImmutableApplicationAttestationSummaryFilters);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationSummaryFilters)}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationAttestationSummaryFilters)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationSummaryFilters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationSummaryFilters)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.empty();

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationSummaryFilters instance =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableApplicationAttestationSummaryFilters
        actualImmutableApplicationAttestationSummaryFilters = builderResult.build();
    assertEquals(instance, actualImmutableApplicationAttestationSummaryFilters);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationSummaryFilters)}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationAttestationSummaryFilters)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationSummaryFilters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationSummaryFilters)"})
  void testBuilderFrom4() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.empty();
    ImmutableApplicationAttestationSummaryFilters instance =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableApplicationAttestationSummaryFilters
        actualImmutableApplicationAttestationSummaryFilters = builderResult.build();
    assertEquals(instance, actualImmutableApplicationAttestationSummaryFilters);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link
   * ImmutableApplicationAttestationSummaryFilters#copyOf(ApplicationAttestationSummaryFilters)}.
   *
   * <ul>
   *   <li>Then return attestationsFromDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryFilters#copyOf(ApplicationAttestationSummaryFilters)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ApplicationAttestationSummaryFilters); then return attestationsFromDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.copyOf(ApplicationAttestationSummaryFilters)"
  })
  void testCopyOf_thenReturnAttestationsFromDateToStringIs19700101() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    LocalDate attestationsFromDate = LocalDate.of(1970, 1, 1);
    ImmutableApplicationAttestationSummaryFilters instance =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(attestationsFromDate)
            .build();

    // Act
    ImmutableApplicationAttestationSummaryFilters actualCopyOfResult =
        ImmutableApplicationAttestationSummaryFilters.copyOf(instance);

    // Assert
    Optional<LocalDate> attestationsFromDateResult = actualCopyOfResult.attestationsFromDate();
    LocalDate getResult = attestationsFromDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(attestationsFromDateResult.isPresent());
    assertEquals(appCriticality, actualCopyOfResult.appCriticality());
    assertEquals(appLifecyclePhase, actualCopyOfResult.appLifecyclePhase());
    assertEquals(attestationState, actualCopyOfResult.attestationState());
    assertSame(attestationsFromDate, getResult);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}, and {@link
   * ImmutableApplicationAttestationSummaryFilters#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}
   *   <li>{@link ImmutableApplicationAttestationSummaryFilters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationSummaryFilters.equals(Object)",
    "int ImmutableApplicationAttestationSummaryFilters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationSummaryFilters immutableApplicationAttestationSummaryFilters =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality2 = Optional.of(Criticality.LOW);

    Builder appCriticalityResult2 = builderResult2.appCriticality(appCriticality2);
    Optional<? extends LifecyclePhase> appLifecyclePhase2 = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult2 = appCriticalityResult2.appLifecyclePhase(appLifecyclePhase2);
    Optional<? extends AttestationState> attestationState2 = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationSummaryFilters immutableApplicationAttestationSummaryFilters2 =
        appLifecyclePhaseResult2
            .attestationState(attestationState2)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertEquals(
        immutableApplicationAttestationSummaryFilters,
        immutableApplicationAttestationSummaryFilters2);
    assertEquals(
        immutableApplicationAttestationSummaryFilters.hashCode(),
        immutableApplicationAttestationSummaryFilters2.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}, and {@link
   * ImmutableApplicationAttestationSummaryFilters#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}
   *   <li>{@link ImmutableApplicationAttestationSummaryFilters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationSummaryFilters.equals(Object)",
    "int ImmutableApplicationAttestationSummaryFilters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationSummaryFilters immutableApplicationAttestationSummaryFilters =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertEquals(
        immutableApplicationAttestationSummaryFilters,
        immutableApplicationAttestationSummaryFilters);
    int expectedHashCodeResult = immutableApplicationAttestationSummaryFilters.hashCode();
    assertEquals(expectedHashCodeResult, immutableApplicationAttestationSummaryFilters.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationSummaryFilters.equals(Object)",
    "int ImmutableApplicationAttestationSummaryFilters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.MEDIUM);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationSummaryFilters immutableApplicationAttestationSummaryFilters =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality2 = Optional.of(Criticality.LOW);

    Builder appCriticalityResult2 = builderResult2.appCriticality(appCriticality2);
    Optional<? extends LifecyclePhase> appLifecyclePhase2 = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult2 = appCriticalityResult2.appLifecyclePhase(appLifecyclePhase2);
    Optional<? extends AttestationState> attestationState2 = Optional.of(AttestationState.ATTESTED);

    // Act and Assert
    assertNotEquals(
        immutableApplicationAttestationSummaryFilters,
        appLifecyclePhaseResult2
            .attestationState(attestationState2)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationSummaryFilters.equals(Object)",
    "int ImmutableApplicationAttestationSummaryFilters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.DEVELOPMENT);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationSummaryFilters immutableApplicationAttestationSummaryFilters =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality2 = Optional.of(Criticality.LOW);

    Builder appCriticalityResult2 = builderResult2.appCriticality(appCriticality2);
    Optional<? extends LifecyclePhase> appLifecyclePhase2 = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult2 = appCriticalityResult2.appLifecyclePhase(appLifecyclePhase2);
    Optional<? extends AttestationState> attestationState2 = Optional.of(AttestationState.ATTESTED);

    // Act and Assert
    assertNotEquals(
        immutableApplicationAttestationSummaryFilters,
        appLifecyclePhaseResult2
            .attestationState(attestationState2)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationSummaryFilters.equals(Object)",
    "int ImmutableApplicationAttestationSummaryFilters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState =
        Optional.of(AttestationState.NEVER_ATTESTED);
    ImmutableApplicationAttestationSummaryFilters immutableApplicationAttestationSummaryFilters =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality2 = Optional.of(Criticality.LOW);

    Builder appCriticalityResult2 = builderResult2.appCriticality(appCriticality2);
    Optional<? extends LifecyclePhase> appLifecyclePhase2 = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult2 = appCriticalityResult2.appLifecyclePhase(appLifecyclePhase2);
    Optional<? extends AttestationState> attestationState2 = Optional.of(AttestationState.ATTESTED);

    // Act and Assert
    assertNotEquals(
        immutableApplicationAttestationSummaryFilters,
        appLifecyclePhaseResult2
            .attestationState(attestationState2)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationSummaryFilters.equals(Object)",
    "int ImmutableApplicationAttestationSummaryFilters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationSummaryFilters immutableApplicationAttestationSummaryFilters =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.now())
            .build();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality2 = Optional.of(Criticality.LOW);

    Builder appCriticalityResult2 = builderResult2.appCriticality(appCriticality2);
    Optional<? extends LifecyclePhase> appLifecyclePhase2 = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult2 = appCriticalityResult2.appLifecyclePhase(appLifecyclePhase2);
    Optional<? extends AttestationState> attestationState2 = Optional.of(AttestationState.ATTESTED);

    // Act and Assert
    assertNotEquals(
        immutableApplicationAttestationSummaryFilters,
        appLifecyclePhaseResult2
            .attestationState(attestationState2)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationSummaryFilters.equals(Object)",
    "int ImmutableApplicationAttestationSummaryFilters.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    // Act and Assert
    assertNotEquals(
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationSummaryFilters.equals(Object)",
    "int ImmutableApplicationAttestationSummaryFilters.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    // Act and Assert
    assertNotEquals(
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build(),
        "Different type to ImmutableApplicationAttestationSummaryFilters");
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return not appCriticality Present.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryFilters#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; then return not appCriticality Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.fromJson(Json)"
  })
  void testFromJson_givenNull_thenReturnNotAppCriticalityPresent() {
    // Arrange
    Json json = new Json();
    json.setAttestationsFromDate(null);
    json.setAppLifecyclePhase(null);
    json.setAppCriticality(null);
    json.setAttestationState(null);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualFromJsonResult =
        ImmutableApplicationAttestationSummaryFilters.fromJson(json);

    // Assert
    Optional<Criticality> appCriticalityResult = actualFromJsonResult.appCriticality();
    assertFalse(appCriticalityResult.isPresent());
    assertSame(appCriticalityResult, actualFromJsonResult.appLifecyclePhase());
    assertSame(appCriticalityResult, actualFromJsonResult.attestationState());
    assertSame(appCriticalityResult, actualFromJsonResult.attestationsFromDate());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return appLifecyclePhase is {@link Json} (default constructor) {@link
   *       Json#attestationsFromDate}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryFilters#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return appLifecyclePhase is Json (default constructor) attestationsFromDate")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnAppLifecyclePhaseIsJsonAttestationsFromDate() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableApplicationAttestationSummaryFilters actualFromJsonResult =
        ImmutableApplicationAttestationSummaryFilters.fromJson(json);

    // Assert
    Optional<LocalDate> optional = json.attestationsFromDate;
    assertSame(optional, actualFromJsonResult.appLifecyclePhase());
    assertSame(optional, actualFromJsonResult.attestationState());
    assertSame(optional, actualFromJsonResult.attestationsFromDate());
  }

  /**
   * Test Json {@link Json#appCriticality()}.
   *
   * <p>Method under test: {@link Json#appCriticality()}
   */
  @Test
  @DisplayName("Test Json appCriticality()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.appCriticality()"})
  void testJsonAppCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().appCriticality());
  }

  /**
   * Test Json {@link Json#appLifecyclePhase()}.
   *
   * <p>Method under test: {@link Json#appLifecyclePhase()}
   */
  @Test
  @DisplayName("Test Json appLifecyclePhase()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.appLifecyclePhase()"})
  void testJsonAppLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().appLifecyclePhase());
  }

  /**
   * Test Json {@link Json#attestationState()}.
   *
   * <p>Method under test: {@link Json#attestationState()}
   */
  @Test
  @DisplayName("Test Json attestationState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.attestationState()"})
  void testJsonAttestationState() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestationState());
  }

  /**
   * Test Json {@link Json#attestationsFromDate()}.
   *
   * <p>Method under test: {@link Json#attestationsFromDate()}
   */
  @Test
  @DisplayName("Test Json attestationsFromDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.attestationsFromDate()"})
  void testJsonAttestationsFromDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestationsFromDate());
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
    assertFalse(actualJson.appCriticality.isPresent());
    assertFalse(actualJson.appLifecyclePhase.isPresent());
    assertFalse(actualJson.attestationState.isPresent());
    assertFalse(actualJson.attestationsFromDate.isPresent());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#toString()}.
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryFilters#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableApplicationAttestationSummaryFilters.toString()"})
  void testToString() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    // Act and Assert
    assertEquals(
        "ApplicationAttestationSummaryFilters{attestationsFromDate=1970-01-01, appLifecyclePhase=PRODUCTION,"
            + " appCriticality=LOW, attestationState=ATTESTED}",
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#toString()}.
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryFilters#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableApplicationAttestationSummaryFilters.toString()"})
  void testToString2() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.empty();

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    // Act and Assert
    assertEquals(
        "ApplicationAttestationSummaryFilters{attestationsFromDate=1970-01-01, appLifecyclePhase=PRODUCTION,"
            + " attestationState=ATTESTED}",
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#toString()}.
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryFilters#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableApplicationAttestationSummaryFilters.toString()"})
  void testToString3() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.empty();

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    // Act and Assert
    assertEquals(
        "ApplicationAttestationSummaryFilters{attestationsFromDate=1970-01-01, appCriticality=LOW, attestationState"
            + "=ATTESTED}",
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#toString()}.
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationSummaryFilters#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableApplicationAttestationSummaryFilters.toString()"})
  void testToString4() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.empty();

    // Act and Assert
    assertEquals(
        "ApplicationAttestationSummaryFilters{attestationsFromDate=1970-01-01, appLifecyclePhase=PRODUCTION,"
            + " appCriticality=LOW}",
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAppCriticality(Optional)} with
   * {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryFilters#withAppCriticality(Optional)}
   */
  @Test
  @DisplayName("Test withAppCriticality(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAppCriticality(Optional)"
  })
  void testWithAppCriticalityWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationSummaryFilters immutableApplicationAttestationSummaryFilters =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();
    Optional<? extends Criticality> optional = Optional.of(Criticality.LOW);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAppCriticalityResult =
        immutableApplicationAttestationSummaryFilters.withAppCriticality(optional);

    // Assert
    assertSame(immutableApplicationAttestationSummaryFilters, actualWithAppCriticalityResult);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAppCriticality(Optional)} with
   * {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryFilters#withAppCriticality(Optional)}
   */
  @Test
  @DisplayName("Test withAppCriticality(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAppCriticality(Optional)"
  })
  void testWithAppCriticalityWithOptional2() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.MEDIUM);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    LocalDate attestationsFromDate = LocalDate.of(1970, 1, 1);
    ImmutableApplicationAttestationSummaryFilters immutableApplicationAttestationSummaryFilters =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(attestationsFromDate)
            .build();
    Optional<? extends Criticality> optional = Optional.of(Criticality.LOW);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAppCriticalityResult =
        immutableApplicationAttestationSummaryFilters.withAppCriticality(optional);

    // Assert
    Optional<LocalDate> attestationsFromDateResult =
        actualWithAppCriticalityResult.attestationsFromDate();
    LocalDate getResult = attestationsFromDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(attestationsFromDateResult.isPresent());
    assertEquals(optional, actualWithAppCriticalityResult.appCriticality());
    assertEquals(appLifecyclePhase, actualWithAppCriticalityResult.appLifecyclePhase());
    assertEquals(attestationState, actualWithAppCriticalityResult.attestationState());
    assertSame(attestationsFromDate, getResult);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAppCriticality(Criticality)} with
   * {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryFilters#withAppCriticality(Criticality)}
   */
  @Test
  @DisplayName("Test withAppCriticality(Criticality) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAppCriticality(Criticality)"
  })
  void testWithAppCriticalityWithValue() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationSummaryFilters immutableApplicationAttestationSummaryFilters =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAppCriticalityResult =
        immutableApplicationAttestationSummaryFilters.withAppCriticality(Criticality.LOW);

    // Assert
    assertSame(immutableApplicationAttestationSummaryFilters, actualWithAppCriticalityResult);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAppCriticality(Criticality)} with
   * {@code value}.
   *
   * <ul>
   *   <li>Then return attestationsFromDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryFilters#withAppCriticality(Criticality)}
   */
  @Test
  @DisplayName(
      "Test withAppCriticality(Criticality) with 'value'; then return attestationsFromDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAppCriticality(Criticality)"
  })
  void testWithAppCriticalityWithValue_thenReturnAttestationsFromDateToStringIs19700101() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.MEDIUM);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    LocalDate attestationsFromDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAppCriticalityResult =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(attestationsFromDate)
            .build()
            .withAppCriticality(Criticality.LOW);

    // Assert
    Optional<LocalDate> attestationsFromDateResult =
        actualWithAppCriticalityResult.attestationsFromDate();
    LocalDate getResult = attestationsFromDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    Optional<Criticality> appCriticalityResult2 = actualWithAppCriticalityResult.appCriticality();
    assertEquals(Criticality.LOW, appCriticalityResult2.get());
    assertTrue(appCriticalityResult2.isPresent());
    assertTrue(attestationsFromDateResult.isPresent());
    assertEquals(appLifecyclePhase, actualWithAppCriticalityResult.appLifecyclePhase());
    assertEquals(attestationState, actualWithAppCriticalityResult.attestationState());
    assertSame(attestationsFromDate, getResult);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAppLifecyclePhase(Optional)} with
   * {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryFilters#withAppLifecyclePhase(Optional)}
   */
  @Test
  @DisplayName("Test withAppLifecyclePhase(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAppLifecyclePhase(Optional)"
  })
  void testWithAppLifecyclePhaseWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationSummaryFilters immutableApplicationAttestationSummaryFilters =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();
    Optional<? extends LifecyclePhase> optional = Optional.of(LifecyclePhase.PRODUCTION);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAppLifecyclePhaseResult =
        immutableApplicationAttestationSummaryFilters.withAppLifecyclePhase(optional);

    // Assert
    assertSame(immutableApplicationAttestationSummaryFilters, actualWithAppLifecyclePhaseResult);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAppLifecyclePhase(Optional)} with
   * {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryFilters#withAppLifecyclePhase(Optional)}
   */
  @Test
  @DisplayName("Test withAppLifecyclePhase(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAppLifecyclePhase(Optional)"
  })
  void testWithAppLifecyclePhaseWithOptional2() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.DEVELOPMENT);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    LocalDate attestationsFromDate = LocalDate.of(1970, 1, 1);
    ImmutableApplicationAttestationSummaryFilters immutableApplicationAttestationSummaryFilters =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(attestationsFromDate)
            .build();
    Optional<? extends LifecyclePhase> optional = Optional.of(LifecyclePhase.PRODUCTION);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAppLifecyclePhaseResult =
        immutableApplicationAttestationSummaryFilters.withAppLifecyclePhase(optional);

    // Assert
    Optional<LocalDate> attestationsFromDateResult =
        actualWithAppLifecyclePhaseResult.attestationsFromDate();
    LocalDate getResult = attestationsFromDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(attestationsFromDateResult.isPresent());
    assertEquals(appCriticality, actualWithAppLifecyclePhaseResult.appCriticality());
    assertEquals(optional, actualWithAppLifecyclePhaseResult.appLifecyclePhase());
    assertEquals(attestationState, actualWithAppLifecyclePhaseResult.attestationState());
    assertSame(attestationsFromDate, getResult);
  }

  /**
   * Test {@link
   * ImmutableApplicationAttestationSummaryFilters#withAppLifecyclePhase(LifecyclePhase)} with
   * {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryFilters#withAppLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test withAppLifecyclePhase(LifecyclePhase) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAppLifecyclePhase(LifecyclePhase)"
  })
  void testWithAppLifecyclePhaseWithValue() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationSummaryFilters immutableApplicationAttestationSummaryFilters =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAppLifecyclePhaseResult =
        immutableApplicationAttestationSummaryFilters.withAppLifecyclePhase(
            LifecyclePhase.PRODUCTION);

    // Assert
    assertSame(immutableApplicationAttestationSummaryFilters, actualWithAppLifecyclePhaseResult);
  }

  /**
   * Test {@link
   * ImmutableApplicationAttestationSummaryFilters#withAppLifecyclePhase(LifecyclePhase)} with
   * {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryFilters#withAppLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test withAppLifecyclePhase(LifecyclePhase) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAppLifecyclePhase(LifecyclePhase)"
  })
  void testWithAppLifecyclePhaseWithValue2() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.DEVELOPMENT);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    LocalDate attestationsFromDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAppLifecyclePhaseResult =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(attestationsFromDate)
            .build()
            .withAppLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    Optional<LocalDate> attestationsFromDateResult =
        actualWithAppLifecyclePhaseResult.attestationsFromDate();
    LocalDate getResult = attestationsFromDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    Optional<LifecyclePhase> appLifecyclePhaseResult2 =
        actualWithAppLifecyclePhaseResult.appLifecyclePhase();
    assertEquals(LifecyclePhase.PRODUCTION, appLifecyclePhaseResult2.get());
    assertTrue(appLifecyclePhaseResult2.isPresent());
    assertTrue(attestationsFromDateResult.isPresent());
    assertEquals(appCriticality, actualWithAppLifecyclePhaseResult.appCriticality());
    assertEquals(attestationState, actualWithAppLifecyclePhaseResult.attestationState());
    assertSame(attestationsFromDate, getResult);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAttestationState(Optional)} with
   * {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryFilters#withAttestationState(Optional)}
   */
  @Test
  @DisplayName("Test withAttestationState(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAttestationState(Optional)"
  })
  void testWithAttestationStateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationSummaryFilters immutableApplicationAttestationSummaryFilters =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();
    Optional<? extends AttestationState> optional = Optional.of(AttestationState.ATTESTED);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAttestationStateResult =
        immutableApplicationAttestationSummaryFilters.withAttestationState(optional);

    // Assert
    assertSame(immutableApplicationAttestationSummaryFilters, actualWithAttestationStateResult);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAttestationState(Optional)} with
   * {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryFilters#withAttestationState(Optional)}
   */
  @Test
  @DisplayName("Test withAttestationState(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAttestationState(Optional)"
  })
  void testWithAttestationStateWithOptional2() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState =
        Optional.of(AttestationState.NEVER_ATTESTED);
    LocalDate attestationsFromDate = LocalDate.of(1970, 1, 1);
    ImmutableApplicationAttestationSummaryFilters immutableApplicationAttestationSummaryFilters =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(attestationsFromDate)
            .build();
    Optional<? extends AttestationState> optional = Optional.of(AttestationState.ATTESTED);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAttestationStateResult =
        immutableApplicationAttestationSummaryFilters.withAttestationState(optional);

    // Assert
    Optional<LocalDate> attestationsFromDateResult =
        actualWithAttestationStateResult.attestationsFromDate();
    LocalDate getResult = attestationsFromDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(attestationsFromDateResult.isPresent());
    assertEquals(appCriticality, actualWithAttestationStateResult.appCriticality());
    assertEquals(appLifecyclePhase, actualWithAttestationStateResult.appLifecyclePhase());
    assertEquals(optional, actualWithAttestationStateResult.attestationState());
    assertSame(attestationsFromDate, getResult);
  }

  /**
   * Test {@link
   * ImmutableApplicationAttestationSummaryFilters#withAttestationState(AttestationState)} with
   * {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryFilters#withAttestationState(AttestationState)}
   */
  @Test
  @DisplayName("Test withAttestationState(AttestationState) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAttestationState(AttestationState)"
  })
  void testWithAttestationStateWithValue() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationSummaryFilters immutableApplicationAttestationSummaryFilters =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAttestationStateResult =
        immutableApplicationAttestationSummaryFilters.withAttestationState(
            AttestationState.ATTESTED);

    // Assert
    assertSame(immutableApplicationAttestationSummaryFilters, actualWithAttestationStateResult);
  }

  /**
   * Test {@link
   * ImmutableApplicationAttestationSummaryFilters#withAttestationState(AttestationState)} with
   * {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryFilters#withAttestationState(AttestationState)}
   */
  @Test
  @DisplayName("Test withAttestationState(AttestationState) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAttestationState(AttestationState)"
  })
  void testWithAttestationStateWithValue2() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState =
        Optional.of(AttestationState.NEVER_ATTESTED);
    LocalDate attestationsFromDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAttestationStateResult =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(attestationsFromDate)
            .build()
            .withAttestationState(AttestationState.ATTESTED);

    // Assert
    Optional<LocalDate> attestationsFromDateResult =
        actualWithAttestationStateResult.attestationsFromDate();
    LocalDate getResult = attestationsFromDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    Optional<AttestationState> attestationStateResult =
        actualWithAttestationStateResult.attestationState();
    assertEquals(AttestationState.ATTESTED, attestationStateResult.get());
    assertTrue(attestationStateResult.isPresent());
    assertTrue(attestationsFromDateResult.isPresent());
    assertEquals(appCriticality, actualWithAttestationStateResult.appCriticality());
    assertEquals(appLifecyclePhase, actualWithAttestationStateResult.appLifecyclePhase());
    assertSame(attestationsFromDate, getResult);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAttestationsFromDate(Optional)}
   * with {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryFilters#withAttestationsFromDate(Optional)}
   */
  @Test
  @DisplayName("Test withAttestationsFromDate(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAttestationsFromDate(Optional)"
  })
  void testWithAttestationsFromDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationSummaryFilters immutableApplicationAttestationSummaryFilters =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();
    Optional<? extends LocalDate> optional = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAttestationsFromDateResult =
        immutableApplicationAttestationSummaryFilters.withAttestationsFromDate(optional);

    // Assert
    assertEquals(
        immutableApplicationAttestationSummaryFilters, actualWithAttestationsFromDateResult);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAttestationsFromDate(LocalDate)}
   * with {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationSummaryFilters#withAttestationsFromDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withAttestationsFromDate(LocalDate) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAttestationsFromDate(LocalDate)"
  })
  void testWithAttestationsFromDateWithValue() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationSummaryFilters immutableApplicationAttestationSummaryFilters =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAttestationsFromDateResult =
        immutableApplicationAttestationSummaryFilters.withAttestationsFromDate(
            LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(
        immutableApplicationAttestationSummaryFilters, actualWithAttestationsFromDateResult);
  }
}
