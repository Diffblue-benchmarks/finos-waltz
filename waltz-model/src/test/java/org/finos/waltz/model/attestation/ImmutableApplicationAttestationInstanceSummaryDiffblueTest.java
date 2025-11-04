package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Timestamp;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.LifecyclePhase;
import org.junit.jupiter.api.Test;

class ImmutableApplicationAttestationInstanceSummaryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableApplicationAttestationInstanceSummary#builder()}
   *   <li>
   * {@link ImmutableApplicationAttestationInstanceSummary#attestedAt(Timestamp)}
   *   <li>{@link ImmutableApplicationAttestationInstanceSummary#attestedBy(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableApplicationAttestationInstanceSummary.Builder actualAttestedAtResult = ImmutableApplicationAttestationInstanceSummary
        .builder()
        .attestedAt(mock(Timestamp.class));

    // Assert
    assertSame(actualAttestedAtResult, actualAttestedAtResult.attestedBy("Attested By"));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Builder#appAssetCode(String)}
   */
  @Test
  void testBuilderAppAssetCode() {
    // Arrange
    ImmutableApplicationAttestationInstanceSummary.Builder builderResult = ImmutableApplicationAttestationInstanceSummary
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appAssetCode("App Asset Code"));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Builder#appAssetCode(String)}
   */
  @Test
  void testBuilderAppAssetCode2() {
    // Arrange
    ImmutableApplicationAttestationInstanceSummary.Builder builderResult = ImmutableApplicationAttestationInstanceSummary
        .builder();
    builderResult.attestedAt(mock(Timestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.appAssetCode("App Asset Code"));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Builder#appCriticality(Criticality)}
   */
  @Test
  void testBuilderAppCriticality() {
    // Arrange
    ImmutableApplicationAttestationInstanceSummary.Builder builderResult = ImmutableApplicationAttestationInstanceSummary
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appCriticality(Criticality.LOW));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Builder#appCriticality(Criticality)}
   */
  @Test
  void testBuilderAppCriticality2() {
    // Arrange
    ImmutableApplicationAttestationInstanceSummary.Builder builderResult = ImmutableApplicationAttestationInstanceSummary
        .builder();
    builderResult.attestedAt(mock(Timestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.appCriticality(Criticality.LOW));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Builder#appKind(ApplicationKind)}
   */
  @Test
  void testBuilderAppKind() {
    // Arrange
    ImmutableApplicationAttestationInstanceSummary.Builder builderResult = ImmutableApplicationAttestationInstanceSummary
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appKind(ApplicationKind.IN_HOUSE));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Builder#appKind(ApplicationKind)}
   */
  @Test
  void testBuilderAppKind2() {
    // Arrange
    ImmutableApplicationAttestationInstanceSummary.Builder builderResult = ImmutableApplicationAttestationInstanceSummary
        .builder();
    builderResult.attestedAt(mock(Timestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.appKind(ApplicationKind.IN_HOUSE));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Builder#appLifecyclePhase(LifecyclePhase)}
   */
  @Test
  void testBuilderAppLifecyclePhase() {
    // Arrange
    ImmutableApplicationAttestationInstanceSummary.Builder builderResult = ImmutableApplicationAttestationInstanceSummary
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appLifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Builder#appLifecyclePhase(LifecyclePhase)}
   */
  @Test
  void testBuilderAppLifecyclePhase2() {
    // Arrange
    ImmutableApplicationAttestationInstanceSummary.Builder builderResult = ImmutableApplicationAttestationInstanceSummary
        .builder();
    builderResult.attestedAt(mock(Timestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.appLifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Builder#appRef(EntityReference)}
   */
  @Test
  void testBuilderAppRef() {
    // Arrange
    ImmutableApplicationAttestationInstanceSummary.Builder builderResult = ImmutableApplicationAttestationInstanceSummary
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Builder#from(ApplicationAttestationInstanceSummary)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableApplicationAttestationInstanceSummary.Builder builderResult = ImmutableApplicationAttestationInstanceSummary
        .builder();
    ApplicationAttestationInstanceSummary instance = mock(ApplicationAttestationInstanceSummary.class);
    when(instance.attestedBy()).thenReturn("Attested By");
    when(instance.attestedAt()).thenReturn(mock(Timestamp.class));
    when(instance.appLifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.appCriticality()).thenReturn(Criticality.LOW);
    when(instance.appKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.appAssetCode()).thenReturn("App Asset Code");
    when(instance.appRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableApplicationAttestationInstanceSummary.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appAssetCode();
    verify(instance).appCriticality();
    verify(instance).appKind();
    verify(instance).appLifecyclePhase();
    verify(instance).appRef();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    ImmutableApplicationAttestationInstanceSummary buildResult = builderResult.build();
    assertEquals("App Asset Code", buildResult.appAssetCode());
    assertEquals("Attested By", buildResult.attestedBy());
    assertEquals(Criticality.LOW, buildResult.appCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.appKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.appLifecyclePhase());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Builder#from(ApplicationAttestationInstanceSummary)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableApplicationAttestationInstanceSummary.Builder builderResult = ImmutableApplicationAttestationInstanceSummary
        .builder();
    ApplicationAttestationInstanceSummary instance = mock(ApplicationAttestationInstanceSummary.class);
    when(instance.attestedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.appLifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.appCriticality()).thenReturn(Criticality.LOW);
    when(instance.appKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.appAssetCode()).thenReturn("App Asset Code");
    when(instance.appRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).appAssetCode();
    verify(instance).appCriticality();
    verify(instance).appKind();
    verify(instance).appLifecyclePhase();
    verify(instance).appRef();
    verify(instance).attestedAt();
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Builder#from(ApplicationAttestationInstanceSummary)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableApplicationAttestationInstanceSummary.Builder builderResult = ImmutableApplicationAttestationInstanceSummary
        .builder();
    ApplicationAttestationInstanceSummary instance = mock(ApplicationAttestationInstanceSummary.class);
    when(instance.attestedBy()).thenReturn(null);
    when(instance.attestedAt()).thenReturn(mock(Timestamp.class));
    when(instance.appLifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.appCriticality()).thenReturn(Criticality.LOW);
    when(instance.appKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.appAssetCode()).thenReturn("App Asset Code");
    when(instance.appRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableApplicationAttestationInstanceSummary.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appAssetCode();
    verify(instance).appCriticality();
    verify(instance).appKind();
    verify(instance).appLifecyclePhase();
    verify(instance).appRef();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    ImmutableApplicationAttestationInstanceSummary buildResult = builderResult.build();
    assertEquals("App Asset Code", buildResult.appAssetCode());
    assertNull(buildResult.attestedBy());
    assertEquals(Criticality.LOW, buildResult.appCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.appKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.appLifecyclePhase());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary#copyOf(ApplicationAttestationInstanceSummary)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ApplicationAttestationInstanceSummary instance = mock(ApplicationAttestationInstanceSummary.class);
    when(instance.attestedBy()).thenReturn("Attested By");
    when(instance.attestedAt()).thenReturn(mock(Timestamp.class));
    when(instance.appLifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.appCriticality()).thenReturn(Criticality.LOW);
    when(instance.appKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.appAssetCode()).thenReturn("App Asset Code");
    when(instance.appRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableApplicationAttestationInstanceSummary actualCopyOfResult = ImmutableApplicationAttestationInstanceSummary
        .copyOf(instance);

    // Assert
    verify(instance).appAssetCode();
    verify(instance).appCriticality();
    verify(instance).appKind();
    verify(instance).appLifecyclePhase();
    verify(instance).appRef();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    assertEquals("App Asset Code", actualCopyOfResult.appAssetCode());
    assertEquals("Attested By", actualCopyOfResult.attestedBy());
    assertEquals(Criticality.LOW, actualCopyOfResult.appCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualCopyOfResult.appKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.appLifecyclePhase());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Json#appAssetCode()}
   */
  @Test
  void testJsonAppAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationAttestationInstanceSummary.Json()).appAssetCode());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Json#appCriticality()}
   */
  @Test
  void testJsonAppCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationAttestationInstanceSummary.Json()).appCriticality());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Json#appKind()}
   */
  @Test
  void testJsonAppKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationAttestationInstanceSummary.Json()).appKind());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Json#appLifecyclePhase()}
   */
  @Test
  void testJsonAppLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationAttestationInstanceSummary.Json()).appLifecyclePhase());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Json#appRef()}
   */
  @Test
  void testJsonAppRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationAttestationInstanceSummary.Json()).appRef());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Json#attestedAt()}
   */
  @Test
  void testJsonAttestedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationAttestationInstanceSummary.Json()).attestedAt());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceSummary.Json#attestedBy()}
   */
  @Test
  void testJsonAttestedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationAttestationInstanceSummary.Json()).attestedBy());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableApplicationAttestationInstanceSummary.Json}
   *   <li>
   * {@link ImmutableApplicationAttestationInstanceSummary.Json#setAppAssetCode(String)}
   *   <li>
   * {@link ImmutableApplicationAttestationInstanceSummary.Json#setAppCriticality(Criticality)}
   *   <li>
   * {@link ImmutableApplicationAttestationInstanceSummary.Json#setAppKind(ApplicationKind)}
   *   <li>
   * {@link ImmutableApplicationAttestationInstanceSummary.Json#setAppLifecyclePhase(LifecyclePhase)}
   *   <li>
   * {@link ImmutableApplicationAttestationInstanceSummary.Json#setAppRef(EntityReference)}
   *   <li>
   * {@link ImmutableApplicationAttestationInstanceSummary.Json#setAttestedAt(Timestamp)}
   *   <li>
   * {@link ImmutableApplicationAttestationInstanceSummary.Json#setAttestedBy(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableApplicationAttestationInstanceSummary.Json actualJson = new ImmutableApplicationAttestationInstanceSummary.Json();
    actualJson.setAppAssetCode("App Asset Code");
    actualJson.setAppCriticality(Criticality.LOW);
    actualJson.setAppKind(ApplicationKind.IN_HOUSE);
    actualJson.setAppLifecyclePhase(LifecyclePhase.PRODUCTION);
    actualJson.setAppRef(null);
    actualJson.setAttestedAt(mock(Timestamp.class));
    actualJson.setAttestedBy("Attested By");

    // Assert
    assertEquals("App Asset Code", actualJson.appAssetCode);
    assertEquals("Attested By", actualJson.attestedBy);
    assertNull(actualJson.appRef);
    assertEquals(Criticality.LOW, actualJson.appCriticality);
    assertEquals(ApplicationKind.IN_HOUSE, actualJson.appKind);
    assertEquals(LifecyclePhase.PRODUCTION, actualJson.appLifecyclePhase);
  }
}
