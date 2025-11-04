package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.Optional;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.application.LifecyclePhase;
import org.junit.jupiter.api.Test;

class ImmutableApplicationAttestationSummaryFiltersDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryFilters.Builder#from(ApplicationAttestationSummaryFilters)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableApplicationAttestationSummaryFilters.Builder builderResult = ImmutableApplicationAttestationSummaryFilters
        .builder();
    ApplicationAttestationSummaryFilters instance = mock(ApplicationAttestationSummaryFilters.class);
    Optional<Criticality> ofResult = Optional.of(Criticality.LOW);
    when(instance.appCriticality()).thenReturn(ofResult);
    Optional<LifecyclePhase> ofResult2 = Optional.of(LifecyclePhase.PRODUCTION);
    when(instance.appLifecyclePhase()).thenReturn(ofResult2);
    Optional<AttestationState> ofResult3 = Optional.of(AttestationState.ATTESTED);
    when(instance.attestationState()).thenReturn(ofResult3);
    Optional<LocalDate> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.attestationsFromDate()).thenReturn(ofResult4);

    // Act
    ImmutableApplicationAttestationSummaryFilters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appCriticality();
    verify(instance).appLifecyclePhase();
    verify(instance).attestationState();
    verify(instance).attestationsFromDate();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryFilters.Builder#from(ApplicationAttestationSummaryFilters)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableApplicationAttestationSummaryFilters.Builder builderResult = ImmutableApplicationAttestationSummaryFilters
        .builder();
    ApplicationAttestationSummaryFilters instance = mock(ApplicationAttestationSummaryFilters.class);
    Optional<Criticality> emptyResult = Optional.empty();
    when(instance.appCriticality()).thenReturn(emptyResult);
    Optional<LifecyclePhase> ofResult = Optional.of(LifecyclePhase.PRODUCTION);
    when(instance.appLifecyclePhase()).thenReturn(ofResult);
    Optional<AttestationState> ofResult2 = Optional.of(AttestationState.ATTESTED);
    when(instance.attestationState()).thenReturn(ofResult2);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.attestationsFromDate()).thenReturn(ofResult3);

    // Act
    ImmutableApplicationAttestationSummaryFilters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appCriticality();
    verify(instance).appLifecyclePhase();
    verify(instance).attestationState();
    verify(instance).attestationsFromDate();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryFilters.Builder#from(ApplicationAttestationSummaryFilters)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableApplicationAttestationSummaryFilters.Builder builderResult = ImmutableApplicationAttestationSummaryFilters
        .builder();
    ApplicationAttestationSummaryFilters instance = mock(ApplicationAttestationSummaryFilters.class);
    Optional<Criticality> ofResult = Optional.of(Criticality.LOW);
    when(instance.appCriticality()).thenReturn(ofResult);
    Optional<LifecyclePhase> emptyResult = Optional.empty();
    when(instance.appLifecyclePhase()).thenReturn(emptyResult);
    Optional<AttestationState> ofResult2 = Optional.of(AttestationState.ATTESTED);
    when(instance.attestationState()).thenReturn(ofResult2);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.attestationsFromDate()).thenReturn(ofResult3);

    // Act
    ImmutableApplicationAttestationSummaryFilters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appCriticality();
    verify(instance).appLifecyclePhase();
    verify(instance).attestationState();
    verify(instance).attestationsFromDate();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryFilters.Builder#from(ApplicationAttestationSummaryFilters)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableApplicationAttestationSummaryFilters.Builder builderResult = ImmutableApplicationAttestationSummaryFilters
        .builder();
    ApplicationAttestationSummaryFilters instance = mock(ApplicationAttestationSummaryFilters.class);
    Optional<Criticality> ofResult = Optional.of(Criticality.LOW);
    when(instance.appCriticality()).thenReturn(ofResult);
    Optional<LifecyclePhase> ofResult2 = Optional.of(LifecyclePhase.PRODUCTION);
    when(instance.appLifecyclePhase()).thenReturn(ofResult2);
    Optional<AttestationState> emptyResult = Optional.empty();
    when(instance.attestationState()).thenReturn(emptyResult);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.attestationsFromDate()).thenReturn(ofResult3);

    // Act
    ImmutableApplicationAttestationSummaryFilters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appCriticality();
    verify(instance).appLifecyclePhase();
    verify(instance).attestationState();
    verify(instance).attestationsFromDate();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryFilters.Builder#from(ApplicationAttestationSummaryFilters)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableApplicationAttestationSummaryFilters.Builder builderResult = ImmutableApplicationAttestationSummaryFilters
        .builder();
    ApplicationAttestationSummaryFilters instance = mock(ApplicationAttestationSummaryFilters.class);
    Optional<Criticality> ofResult = Optional.of(Criticality.LOW);
    when(instance.appCriticality()).thenReturn(ofResult);
    Optional<LifecyclePhase> ofResult2 = Optional.of(LifecyclePhase.PRODUCTION);
    when(instance.appLifecyclePhase()).thenReturn(ofResult2);
    Optional<AttestationState> ofResult3 = Optional.of(AttestationState.ATTESTED);
    when(instance.attestationState()).thenReturn(ofResult3);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.attestationsFromDate()).thenReturn(emptyResult);

    // Act
    ImmutableApplicationAttestationSummaryFilters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appCriticality();
    verify(instance).appLifecyclePhase();
    verify(instance).attestationState();
    verify(instance).attestationsFromDate();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryFilters#copyOf(ApplicationAttestationSummaryFilters)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ApplicationAttestationSummaryFilters instance = mock(ApplicationAttestationSummaryFilters.class);
    Optional<Criticality> ofResult = Optional.of(Criticality.LOW);
    when(instance.appCriticality()).thenReturn(ofResult);
    Optional<LifecyclePhase> ofResult2 = Optional.of(LifecyclePhase.PRODUCTION);
    when(instance.appLifecyclePhase()).thenReturn(ofResult2);
    Optional<AttestationState> ofResult3 = Optional.of(AttestationState.ATTESTED);
    when(instance.attestationState()).thenReturn(ofResult3);
    Optional<LocalDate> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.attestationsFromDate()).thenReturn(ofResult4);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualCopyOfResult = ImmutableApplicationAttestationSummaryFilters
        .copyOf(instance);

    // Assert
    verify(instance).appCriticality();
    verify(instance).appLifecyclePhase();
    verify(instance).attestationState();
    verify(instance).attestationsFromDate();
    assertEquals(ofResult, actualCopyOfResult.appCriticality());
    assertEquals(ofResult2, actualCopyOfResult.appLifecyclePhase());
    assertEquals(ofResult3, actualCopyOfResult.attestationState());
    assertEquals(ofResult4, actualCopyOfResult.attestationsFromDate());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryFilters#copyOf(ApplicationAttestationSummaryFilters)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ApplicationAttestationSummaryFilters instance = mock(ApplicationAttestationSummaryFilters.class);
    Optional<Criticality> emptyResult = Optional.empty();
    when(instance.appCriticality()).thenReturn(emptyResult);
    Optional<LifecyclePhase> ofResult = Optional.of(LifecyclePhase.PRODUCTION);
    when(instance.appLifecyclePhase()).thenReturn(ofResult);
    Optional<AttestationState> ofResult2 = Optional.of(AttestationState.ATTESTED);
    when(instance.attestationState()).thenReturn(ofResult2);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.attestationsFromDate()).thenReturn(ofResult3);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualCopyOfResult = ImmutableApplicationAttestationSummaryFilters
        .copyOf(instance);

    // Assert
    verify(instance).appCriticality();
    verify(instance).appLifecyclePhase();
    verify(instance).attestationState();
    verify(instance).attestationsFromDate();
    Optional<Criticality> appCriticalityResult = actualCopyOfResult.appCriticality();
    assertFalse(appCriticalityResult.isPresent());
    assertEquals(ofResult, actualCopyOfResult.appLifecyclePhase());
    assertEquals(ofResult2, actualCopyOfResult.attestationState());
    assertEquals(ofResult3, actualCopyOfResult.attestationsFromDate());
    assertSame(emptyResult, appCriticalityResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryFilters#copyOf(ApplicationAttestationSummaryFilters)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ApplicationAttestationSummaryFilters instance = mock(ApplicationAttestationSummaryFilters.class);
    Optional<Criticality> ofResult = Optional.of(Criticality.LOW);
    when(instance.appCriticality()).thenReturn(ofResult);
    Optional<LifecyclePhase> emptyResult = Optional.empty();
    when(instance.appLifecyclePhase()).thenReturn(emptyResult);
    Optional<AttestationState> ofResult2 = Optional.of(AttestationState.ATTESTED);
    when(instance.attestationState()).thenReturn(ofResult2);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.attestationsFromDate()).thenReturn(ofResult3);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualCopyOfResult = ImmutableApplicationAttestationSummaryFilters
        .copyOf(instance);

    // Assert
    verify(instance).appCriticality();
    verify(instance).appLifecyclePhase();
    verify(instance).attestationState();
    verify(instance).attestationsFromDate();
    Optional<LifecyclePhase> appLifecyclePhaseResult = actualCopyOfResult.appLifecyclePhase();
    assertFalse(appLifecyclePhaseResult.isPresent());
    assertEquals(ofResult, actualCopyOfResult.appCriticality());
    assertEquals(ofResult2, actualCopyOfResult.attestationState());
    assertEquals(ofResult3, actualCopyOfResult.attestationsFromDate());
    assertSame(emptyResult, appLifecyclePhaseResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryFilters#copyOf(ApplicationAttestationSummaryFilters)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ApplicationAttestationSummaryFilters instance = mock(ApplicationAttestationSummaryFilters.class);
    Optional<Criticality> ofResult = Optional.of(Criticality.LOW);
    when(instance.appCriticality()).thenReturn(ofResult);
    Optional<LifecyclePhase> ofResult2 = Optional.of(LifecyclePhase.PRODUCTION);
    when(instance.appLifecyclePhase()).thenReturn(ofResult2);
    Optional<AttestationState> emptyResult = Optional.empty();
    when(instance.attestationState()).thenReturn(emptyResult);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.attestationsFromDate()).thenReturn(ofResult3);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualCopyOfResult = ImmutableApplicationAttestationSummaryFilters
        .copyOf(instance);

    // Assert
    verify(instance).appCriticality();
    verify(instance).appLifecyclePhase();
    verify(instance).attestationState();
    verify(instance).attestationsFromDate();
    Optional<AttestationState> attestationStateResult = actualCopyOfResult.attestationState();
    assertFalse(attestationStateResult.isPresent());
    assertEquals(ofResult, actualCopyOfResult.appCriticality());
    assertEquals(ofResult2, actualCopyOfResult.appLifecyclePhase());
    assertEquals(ofResult3, actualCopyOfResult.attestationsFromDate());
    assertSame(emptyResult, attestationStateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryFilters#copyOf(ApplicationAttestationSummaryFilters)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ApplicationAttestationSummaryFilters instance = mock(ApplicationAttestationSummaryFilters.class);
    Optional<Criticality> ofResult = Optional.of(Criticality.LOW);
    when(instance.appCriticality()).thenReturn(ofResult);
    Optional<LifecyclePhase> ofResult2 = Optional.of(LifecyclePhase.PRODUCTION);
    when(instance.appLifecyclePhase()).thenReturn(ofResult2);
    Optional<AttestationState> ofResult3 = Optional.of(AttestationState.ATTESTED);
    when(instance.attestationState()).thenReturn(ofResult3);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.attestationsFromDate()).thenReturn(emptyResult);

    // Act
    ImmutableApplicationAttestationSummaryFilters actualCopyOfResult = ImmutableApplicationAttestationSummaryFilters
        .copyOf(instance);

    // Assert
    verify(instance).appCriticality();
    verify(instance).appLifecyclePhase();
    verify(instance).attestationState();
    verify(instance).attestationsFromDate();
    Optional<LocalDate> attestationsFromDateResult = actualCopyOfResult.attestationsFromDate();
    assertFalse(attestationsFromDateResult.isPresent());
    assertEquals(ofResult, actualCopyOfResult.appCriticality());
    assertEquals(ofResult2, actualCopyOfResult.appLifecyclePhase());
    assertEquals(ofResult3, actualCopyOfResult.attestationState());
    assertSame(emptyResult, attestationsFromDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryFilters#fromJson(ImmutableApplicationAttestationSummaryFilters.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableApplicationAttestationSummaryFilters.Json json = new ImmutableApplicationAttestationSummaryFilters.Json();

    // Act
    ImmutableApplicationAttestationSummaryFilters actualFromJsonResult = ImmutableApplicationAttestationSummaryFilters
        .fromJson(json);

    // Assert
    Optional<Criticality> appCriticalityResult = actualFromJsonResult.appCriticality();
    assertFalse(appCriticalityResult.isPresent());
    Optional<LocalDate> optional = json.attestationsFromDate;
    assertSame(optional, appCriticalityResult);
    assertSame(optional, actualFromJsonResult.appLifecyclePhase());
    assertSame(optional, actualFromJsonResult.attestationState());
    assertSame(optional, actualFromJsonResult.attestationsFromDate());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryFilters#fromJson(ImmutableApplicationAttestationSummaryFilters.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableApplicationAttestationSummaryFilters.Json json = new ImmutableApplicationAttestationSummaryFilters.Json();
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
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryFilters.Json#appCriticality()}
   */
  @Test
  void testJsonAppCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationAttestationSummaryFilters.Json()).appCriticality());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryFilters.Json#appLifecyclePhase()}
   */
  @Test
  void testJsonAppLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationAttestationSummaryFilters.Json()).appLifecyclePhase());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryFilters.Json#attestationState()}
   */
  @Test
  void testJsonAttestationState() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationAttestationSummaryFilters.Json()).attestationState());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryFilters.Json#attestationsFromDate()}
   */
  @Test
  void testJsonAttestationsFromDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationAttestationSummaryFilters.Json()).attestationsFromDate());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableApplicationAttestationSummaryFilters.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableApplicationAttestationSummaryFilters.Json actualJson = new ImmutableApplicationAttestationSummaryFilters.Json();

    // Assert
    assertFalse(actualJson.appCriticality.isPresent());
    assertFalse(actualJson.appLifecyclePhase.isPresent());
    assertFalse(actualJson.attestationState.isPresent());
    assertFalse(actualJson.attestationsFromDate.isPresent());
  }
}
