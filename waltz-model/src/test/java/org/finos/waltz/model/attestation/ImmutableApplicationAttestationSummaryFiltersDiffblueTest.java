package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#appCriticality()}
   */
  @Test
  @DisplayName("Test appCriticality()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ImmutableApplicationAttestationSummaryFilters.appCriticality()"})
  void testAppCriticality() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act and Assert
    assertEquals(appCriticality, buildResult.appCriticality());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#appLifecyclePhase()}.
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#appLifecyclePhase()}
   */
  @Test
  @DisplayName("Test appLifecyclePhase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ImmutableApplicationAttestationSummaryFilters.appLifecyclePhase()"})
  void testAppLifecyclePhase() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act and Assert
    assertEquals(appLifecyclePhase, buildResult.appLifecyclePhase());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#attestationState()}.
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#attestationState()}
   */
  @Test
  @DisplayName("Test attestationState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ImmutableApplicationAttestationSummaryFilters.attestationState()"})
  void testAttestationState() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act and Assert
    assertEquals(attestationState, buildResult.attestationState());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#attestationsFromDate()}.
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#attestationsFromDate()}
   */
  @Test
  @DisplayName("Test attestationsFromDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ImmutableApplicationAttestationSummaryFilters.attestationsFromDate()"})
  void testAttestationsFromDate() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    LocalDate attestationsFromDate = LocalDate.of(1970, 1, 1);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(attestationsFromDate)
        .build();

    // Act
    Optional<LocalDate> actualAttestationsFromDateResult = buildResult.attestationsFromDate();

    // Assert
    LocalDate getResult = actualAttestationsFromDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(actualAttestationsFromDateResult.isPresent());
    assertSame(attestationsFromDate, getResult);
  }

  /**
   * Test Builder {@link Builder#appCriticality(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#appCriticality(Optional)}
   */
  @Test
  @DisplayName("Test Builder appCriticality(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.appCriticality(Optional)"})
  void testBuilderAppCriticalityWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    // Act and Assert
    assertSame(builderResult, builderResult.appCriticality(appCriticality));
  }

  /**
   * Test Builder {@link Builder#appLifecyclePhase(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#appLifecyclePhase(Optional)}
   */
  @Test
  @DisplayName("Test Builder appLifecyclePhase(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.appLifecyclePhase(Optional)"})
  void testBuilderAppLifecyclePhaseWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    // Act and Assert
    assertSame(builderResult, builderResult.appLifecyclePhase(appLifecyclePhase));
  }

  /**
   * Test Builder {@link Builder#attestationState(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#attestationState(Optional)}
   */
  @Test
  @DisplayName("Test Builder attestationState(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestationState(Optional)"})
  void testBuilderAttestationStateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    // Act and Assert
    assertSame(builderResult, builderResult.attestationState(attestationState));
  }

  /**
   * Test Builder {@link Builder#attestationsFromDate(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#attestationsFromDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder attestationsFromDate(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestationsFromDate(Optional)"})
  void testBuilderAttestationsFromDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends LocalDate> attestationsFromDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertSame(builderResult, builderResult.attestationsFromDate(attestationsFromDate));
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationSummaryFilters)}.
   * <p>
   * Method under test: {@link Builder#from(ApplicationAttestationSummaryFilters)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationSummaryFilters)")
  @Tag("MaintainedByDiffblue")
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
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters instance = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationSummaryFilters)}.
   * <p>
   * Method under test: {@link Builder#from(ApplicationAttestationSummaryFilters)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationSummaryFilters)")
  @Tag("MaintainedByDiffblue")
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
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters instance = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationSummaryFilters)}.
   * <p>
   * Method under test: {@link Builder#from(ApplicationAttestationSummaryFilters)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationSummaryFilters)")
  @Tag("MaintainedByDiffblue")
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
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters instance = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationSummaryFilters)}.
   * <p>
   * Method under test: {@link Builder#from(ApplicationAttestationSummaryFilters)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationSummaryFilters)")
  @Tag("MaintainedByDiffblue")
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
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters instance = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#copyOf(ApplicationAttestationSummaryFilters)}.
   * <ul>
   *   <li>Then return attestationsFromDate toString is {@code 1970-01-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#copyOf(ApplicationAttestationSummaryFilters)}
   */
  @Test
  @DisplayName("Test copyOf(ApplicationAttestationSummaryFilters); then return attestationsFromDate toString is '1970-01-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.copyOf(ApplicationAttestationSummaryFilters)"})
  void testCopyOf_thenReturnAttestationsFromDateToStringIs19700101() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    LocalDate attestationsFromDate = LocalDate.of(1970, 1, 1);
    ImmutableApplicationAttestationSummaryFilters instance = attestationStateResult
        .attestationsFromDate(attestationsFromDate)
        .build();

    // Act
    ImmutableApplicationAttestationSummaryFilters actualCopyOfResult = ImmutableApplicationAttestationSummaryFilters
        .copyOf(instance);

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
   * Test {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}, and {@link ImmutableApplicationAttestationSummaryFilters#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}
   *   <li>{@link ImmutableApplicationAttestationSummaryFilters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableApplicationAttestationSummaryFilters.equals(Object)",
      "int ImmutableApplicationAttestationSummaryFilters.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();
    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality2 = Optional.of(Criticality.LOW);
    Builder appCriticalityResult2 = builderResult2.appCriticality(appCriticality2);
    Optional<? extends LifecyclePhase> appLifecyclePhase2 = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult2 = appCriticalityResult2.appLifecyclePhase(appLifecyclePhase2);
    Optional<? extends AttestationState> attestationState2 = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult2 = appLifecyclePhaseResult2.attestationState(attestationState2);
    ImmutableApplicationAttestationSummaryFilters buildResult2 = attestationStateResult2
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}, and {@link ImmutableApplicationAttestationSummaryFilters#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}
   *   <li>{@link ImmutableApplicationAttestationSummaryFilters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableApplicationAttestationSummaryFilters.equals(Object)",
      "int ImmutableApplicationAttestationSummaryFilters.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableApplicationAttestationSummaryFilters.equals(Object)",
      "int ImmutableApplicationAttestationSummaryFilters.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.MEDIUM);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();
    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality2 = Optional.of(Criticality.LOW);
    Builder appCriticalityResult2 = builderResult2.appCriticality(appCriticality2);
    Optional<? extends LifecyclePhase> appLifecyclePhase2 = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult2 = appCriticalityResult2.appLifecyclePhase(appLifecyclePhase2);
    Optional<? extends AttestationState> attestationState2 = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult2 = appLifecyclePhaseResult2.attestationState(attestationState2);
    ImmutableApplicationAttestationSummaryFilters buildResult2 = attestationStateResult2
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableApplicationAttestationSummaryFilters.equals(Object)",
      "int ImmutableApplicationAttestationSummaryFilters.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.DEVELOPMENT);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();
    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality2 = Optional.of(Criticality.LOW);
    Builder appCriticalityResult2 = builderResult2.appCriticality(appCriticality2);
    Optional<? extends LifecyclePhase> appLifecyclePhase2 = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult2 = appCriticalityResult2.appLifecyclePhase(appLifecyclePhase2);
    Optional<? extends AttestationState> attestationState2 = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult2 = appLifecyclePhaseResult2.attestationState(attestationState2);
    ImmutableApplicationAttestationSummaryFilters buildResult2 = attestationStateResult2
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableApplicationAttestationSummaryFilters.equals(Object)",
      "int ImmutableApplicationAttestationSummaryFilters.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.NEVER_ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();
    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality2 = Optional.of(Criticality.LOW);
    Builder appCriticalityResult2 = builderResult2.appCriticality(appCriticality2);
    Optional<? extends LifecyclePhase> appLifecyclePhase2 = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult2 = appCriticalityResult2.appLifecyclePhase(appLifecyclePhase2);
    Optional<? extends AttestationState> attestationState2 = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult2 = appLifecyclePhaseResult2.attestationState(attestationState2);
    ImmutableApplicationAttestationSummaryFilters buildResult2 = attestationStateResult2
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableApplicationAttestationSummaryFilters.equals(Object)",
      "int ImmutableApplicationAttestationSummaryFilters.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.now())
        .build();
    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality2 = Optional.of(Criticality.LOW);
    Builder appCriticalityResult2 = builderResult2.appCriticality(appCriticality2);
    Optional<? extends LifecyclePhase> appLifecyclePhase2 = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult2 = appCriticalityResult2.appLifecyclePhase(appLifecyclePhase2);
    Optional<? extends AttestationState> attestationState2 = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult2 = appLifecyclePhaseResult2.attestationState(attestationState2);
    ImmutableApplicationAttestationSummaryFilters buildResult2 = attestationStateResult2
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableApplicationAttestationSummaryFilters.equals(Object)",
      "int ImmutableApplicationAttestationSummaryFilters.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableApplicationAttestationSummaryFilters.equals(Object)",
      "int ImmutableApplicationAttestationSummaryFilters.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableApplicationAttestationSummaryFilters");
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return not appCriticality Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; then return not appCriticality Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.fromJson(Json)"})
  void testFromJson_givenNull_thenReturnNotAppCriticalityPresent() {
    // Arrange
    Json json = new Json();
    json.setAttestationsFromDate(null);
    json.setAppLifecyclePhase(null);
    json.setAppCriticality(null);
    json.setAttestationState(null);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualFromJsonResult = ImmutableApplicationAttestationSummaryFilters
        .fromJson(json);

    // Assert
    Optional<Criticality> appCriticalityResult = actualFromJsonResult.appCriticality();
    assertFalse(appCriticalityResult.isPresent());
    assertSame(appCriticalityResult, actualFromJsonResult.appLifecyclePhase());
    assertSame(appCriticalityResult, actualFromJsonResult.attestationState());
    assertSame(appCriticalityResult, actualFromJsonResult.attestationsFromDate());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return appLifecyclePhase is {@link Json} (default constructor) {@link Json#attestationsFromDate}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return appLifecyclePhase is Json (default constructor) attestationsFromDate")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnAppLifecyclePhaseIsJsonAttestationsFromDate() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableApplicationAttestationSummaryFilters actualFromJsonResult = ImmutableApplicationAttestationSummaryFilters
        .fromJson(json);

    // Assert
    Optional<LocalDate> optional = json.attestationsFromDate;
    assertSame(optional, actualFromJsonResult.appLifecyclePhase());
    assertSame(optional, actualFromJsonResult.attestationState());
    assertSame(optional, actualFromJsonResult.attestationsFromDate());
  }

  /**
   * Test Json {@link Json#appCriticality()}.
   * <p>
   * Method under test: {@link Json#appCriticality()}
   */
  @Test
  @DisplayName("Test Json appCriticality()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.appCriticality()"})
  void testJsonAppCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).appCriticality());
  }

  /**
   * Test Json {@link Json#appLifecyclePhase()}.
   * <p>
   * Method under test: {@link Json#appLifecyclePhase()}
   */
  @Test
  @DisplayName("Test Json appLifecyclePhase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.appLifecyclePhase()"})
  void testJsonAppLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).appLifecyclePhase());
  }

  /**
   * Test Json {@link Json#attestationState()}.
   * <p>
   * Method under test: {@link Json#attestationState()}
   */
  @Test
  @DisplayName("Test Json attestationState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.attestationState()"})
  void testJsonAttestationState() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestationState());
  }

  /**
   * Test Json {@link Json#attestationsFromDate()}.
   * <p>
   * Method under test: {@link Json#attestationsFromDate()}
   */
  @Test
  @DisplayName("Test Json attestationsFromDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.attestationsFromDate()"})
  void testJsonAttestationsFromDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestationsFromDate());
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
    assertFalse(actualJson.appCriticality.isPresent());
    assertFalse(actualJson.appLifecyclePhase.isPresent());
    assertFalse(actualJson.attestationState.isPresent());
    assertFalse(actualJson.attestationsFromDate.isPresent());
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAppCriticality(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#withAppCriticality(Optional)}
   */
  @Test
  @DisplayName("Test withAppCriticality(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAppCriticality(Optional)"})
  void testWithAppCriticalityWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();
    Optional<? extends Criticality> optional = Optional.of(Criticality.LOW);

    // Act and Assert
    assertSame(buildResult, buildResult.withAppCriticality(optional));
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAppCriticality(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#withAppCriticality(Optional)}
   */
  @Test
  @DisplayName("Test withAppCriticality(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAppCriticality(Optional)"})
  void testWithAppCriticalityWithOptional2() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.MEDIUM);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    LocalDate attestationsFromDate = LocalDate.of(1970, 1, 1);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(attestationsFromDate)
        .build();
    Optional<? extends Criticality> optional = Optional.of(Criticality.LOW);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAppCriticalityResult = buildResult
        .withAppCriticality(optional);

    // Assert
    Optional<LocalDate> attestationsFromDateResult = actualWithAppCriticalityResult.attestationsFromDate();
    LocalDate getResult = attestationsFromDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(attestationsFromDateResult.isPresent());
    assertEquals(optional, actualWithAppCriticalityResult.appCriticality());
    assertEquals(appLifecyclePhase, actualWithAppCriticalityResult.appLifecyclePhase());
    assertEquals(attestationState, actualWithAppCriticalityResult.attestationState());
    assertSame(attestationsFromDate, getResult);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAppCriticality(Criticality)} with {@code value}.
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#withAppCriticality(Criticality)}
   */
  @Test
  @DisplayName("Test withAppCriticality(Criticality) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAppCriticality(Criticality)"})
  void testWithAppCriticalityWithValue() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withAppCriticality(Criticality.LOW));
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAppCriticality(Criticality)} with {@code value}.
   * <ul>
   *   <li>Then return attestationsFromDate toString is {@code 1970-01-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#withAppCriticality(Criticality)}
   */
  @Test
  @DisplayName("Test withAppCriticality(Criticality) with 'value'; then return attestationsFromDate toString is '1970-01-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAppCriticality(Criticality)"})
  void testWithAppCriticalityWithValue_thenReturnAttestationsFromDateToStringIs19700101() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.MEDIUM);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    LocalDate attestationsFromDate = LocalDate.of(1970, 1, 1);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(attestationsFromDate)
        .build();

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAppCriticalityResult = buildResult
        .withAppCriticality(Criticality.LOW);

    // Assert
    Optional<LocalDate> attestationsFromDateResult = actualWithAppCriticalityResult.attestationsFromDate();
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
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAppLifecyclePhase(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#withAppLifecyclePhase(Optional)}
   */
  @Test
  @DisplayName("Test withAppLifecyclePhase(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAppLifecyclePhase(Optional)"})
  void testWithAppLifecyclePhaseWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();
    Optional<? extends LifecyclePhase> optional = Optional.of(LifecyclePhase.PRODUCTION);

    // Act and Assert
    assertSame(buildResult, buildResult.withAppLifecyclePhase(optional));
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAppLifecyclePhase(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#withAppLifecyclePhase(Optional)}
   */
  @Test
  @DisplayName("Test withAppLifecyclePhase(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAppLifecyclePhase(Optional)"})
  void testWithAppLifecyclePhaseWithOptional2() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.DEVELOPMENT);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    LocalDate attestationsFromDate = LocalDate.of(1970, 1, 1);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(attestationsFromDate)
        .build();
    Optional<? extends LifecyclePhase> optional = Optional.of(LifecyclePhase.PRODUCTION);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAppLifecyclePhaseResult = buildResult
        .withAppLifecyclePhase(optional);

    // Assert
    Optional<LocalDate> attestationsFromDateResult = actualWithAppLifecyclePhaseResult.attestationsFromDate();
    LocalDate getResult = attestationsFromDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(attestationsFromDateResult.isPresent());
    assertEquals(appCriticality, actualWithAppLifecyclePhaseResult.appCriticality());
    assertEquals(optional, actualWithAppLifecyclePhaseResult.appLifecyclePhase());
    assertEquals(attestationState, actualWithAppLifecyclePhaseResult.attestationState());
    assertSame(attestationsFromDate, getResult);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAppLifecyclePhase(LifecyclePhase)} with {@code value}.
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#withAppLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test withAppLifecyclePhase(LifecyclePhase) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAppLifecyclePhase(LifecyclePhase)"})
  void testWithAppLifecyclePhaseWithValue() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withAppLifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAppLifecyclePhase(LifecyclePhase)} with {@code value}.
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#withAppLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test withAppLifecyclePhase(LifecyclePhase) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAppLifecyclePhase(LifecyclePhase)"})
  void testWithAppLifecyclePhaseWithValue2() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.DEVELOPMENT);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    LocalDate attestationsFromDate = LocalDate.of(1970, 1, 1);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(attestationsFromDate)
        .build();

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAppLifecyclePhaseResult = buildResult
        .withAppLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    Optional<LocalDate> attestationsFromDateResult = actualWithAppLifecyclePhaseResult.attestationsFromDate();
    LocalDate getResult = attestationsFromDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    Optional<LifecyclePhase> appLifecyclePhaseResult2 = actualWithAppLifecyclePhaseResult.appLifecyclePhase();
    assertEquals(LifecyclePhase.PRODUCTION, appLifecyclePhaseResult2.get());
    assertTrue(appLifecyclePhaseResult2.isPresent());
    assertTrue(attestationsFromDateResult.isPresent());
    assertEquals(appCriticality, actualWithAppLifecyclePhaseResult.appCriticality());
    assertEquals(attestationState, actualWithAppLifecyclePhaseResult.attestationState());
    assertSame(attestationsFromDate, getResult);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAttestationState(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#withAttestationState(Optional)}
   */
  @Test
  @DisplayName("Test withAttestationState(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAttestationState(Optional)"})
  void testWithAttestationStateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();
    Optional<? extends AttestationState> optional = Optional.of(AttestationState.ATTESTED);

    // Act and Assert
    assertSame(buildResult, buildResult.withAttestationState(optional));
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAttestationState(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#withAttestationState(Optional)}
   */
  @Test
  @DisplayName("Test withAttestationState(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAttestationState(Optional)"})
  void testWithAttestationStateWithOptional2() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.NEVER_ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    LocalDate attestationsFromDate = LocalDate.of(1970, 1, 1);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(attestationsFromDate)
        .build();
    Optional<? extends AttestationState> optional = Optional.of(AttestationState.ATTESTED);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAttestationStateResult = buildResult
        .withAttestationState(optional);

    // Assert
    Optional<LocalDate> attestationsFromDateResult = actualWithAttestationStateResult.attestationsFromDate();
    LocalDate getResult = attestationsFromDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(attestationsFromDateResult.isPresent());
    assertEquals(appCriticality, actualWithAttestationStateResult.appCriticality());
    assertEquals(appLifecyclePhase, actualWithAttestationStateResult.appLifecyclePhase());
    assertEquals(optional, actualWithAttestationStateResult.attestationState());
    assertSame(attestationsFromDate, getResult);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAttestationState(AttestationState)} with {@code value}.
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#withAttestationState(AttestationState)}
   */
  @Test
  @DisplayName("Test withAttestationState(AttestationState) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAttestationState(AttestationState)"})
  void testWithAttestationStateWithValue() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withAttestationState(AttestationState.ATTESTED));
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAttestationState(AttestationState)} with {@code value}.
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#withAttestationState(AttestationState)}
   */
  @Test
  @DisplayName("Test withAttestationState(AttestationState) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAttestationState(AttestationState)"})
  void testWithAttestationStateWithValue2() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.NEVER_ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    LocalDate attestationsFromDate = LocalDate.of(1970, 1, 1);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(attestationsFromDate)
        .build();

    // Act
    ImmutableApplicationAttestationSummaryFilters actualWithAttestationStateResult = buildResult
        .withAttestationState(AttestationState.ATTESTED);

    // Assert
    Optional<LocalDate> attestationsFromDateResult = actualWithAttestationStateResult.attestationsFromDate();
    LocalDate getResult = attestationsFromDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    Optional<AttestationState> attestationStateResult2 = actualWithAttestationStateResult.attestationState();
    assertEquals(AttestationState.ATTESTED, attestationStateResult2.get());
    assertTrue(attestationStateResult2.isPresent());
    assertTrue(attestationsFromDateResult.isPresent());
    assertEquals(appCriticality, actualWithAttestationStateResult.appCriticality());
    assertEquals(appLifecyclePhase, actualWithAttestationStateResult.appLifecyclePhase());
    assertSame(attestationsFromDate, getResult);
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAttestationsFromDate(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#withAttestationsFromDate(Optional)}
   */
  @Test
  @DisplayName("Test withAttestationsFromDate(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAttestationsFromDate(Optional)"})
  void testWithAttestationsFromDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();
    Optional<? extends LocalDate> optional = Optional.of(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertEquals(buildResult, buildResult.withAttestationsFromDate(optional));
  }

  /**
   * Test {@link ImmutableApplicationAttestationSummaryFilters#withAttestationsFromDate(LocalDate)} with {@code value}.
   * <p>
   * Method under test: {@link ImmutableApplicationAttestationSummaryFilters#withAttestationsFromDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withAttestationsFromDate(LocalDate) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationAttestationSummaryFilters ImmutableApplicationAttestationSummaryFilters.withAttestationsFromDate(LocalDate)"})
  void testWithAttestationsFromDateWithValue() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    Builder attestationStateResult = appLifecyclePhaseResult.attestationState(attestationState);
    ImmutableApplicationAttestationSummaryFilters buildResult = attestationStateResult
        .attestationsFromDate(LocalDate.of(1970, 1, 1))
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult.withAttestationsFromDate(LocalDate.of(1970, 1, 1)));
  }
}
