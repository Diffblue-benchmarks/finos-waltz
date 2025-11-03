package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Timestamp;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.attestation.ImmutableApplicationAttestationInstanceSummary.Builder;
import org.finos.waltz.model.attestation.ImmutableApplicationAttestationInstanceSummary.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationAttestationInstanceSummaryDiffblueTest {
  /**
   * Test {@link ImmutableApplicationAttestationInstanceSummary#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableApplicationAttestationInstanceSummary#builder()}
   *   <li>{@link ImmutableApplicationAttestationInstanceSummary#attestedAt(Timestamp)}
   *   <li>{@link ImmutableApplicationAttestationInstanceSummary#attestedBy(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestedAt(Timestamp)", "Builder Builder.attestedBy(String)",
      "ImmutableApplicationAttestationInstanceSummary Builder.build()"})
  void testBuilder() {
    // Arrange and Act
    Builder actualAttestedAtResult = ImmutableApplicationAttestationInstanceSummary.builder()
        .attestedAt(mock(Timestamp.class));

    // Assert
    assertSame(actualAttestedAtResult, actualAttestedAtResult.attestedBy("Attested By"));
  }

  /**
   * Test Builder {@link Builder#appAssetCode(String)}.
   * <p>
   * Method under test: {@link Builder#appAssetCode(String)}
   */
  @Test
  @DisplayName("Test Builder appAssetCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.appAssetCode(String)"})
  void testBuilderAppAssetCode() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appAssetCode("App Asset Code"));
  }

  /**
   * Test Builder {@link Builder#appCriticality(Criticality)}.
   * <p>
   * Method under test: {@link Builder#appCriticality(Criticality)}
   */
  @Test
  @DisplayName("Test Builder appCriticality(Criticality)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.appCriticality(Criticality)"})
  void testBuilderAppCriticality() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appCriticality(Criticality.LOW));
  }

  /**
   * Test Builder {@link Builder#appKind(ApplicationKind)}.
   * <p>
   * Method under test: {@link Builder#appKind(ApplicationKind)}
   */
  @Test
  @DisplayName("Test Builder appKind(ApplicationKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.appKind(ApplicationKind)"})
  void testBuilderAppKind() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appKind(ApplicationKind.IN_HOUSE));
  }

  /**
   * Test Builder {@link Builder#appLifecyclePhase(LifecyclePhase)}.
   * <p>
   * Method under test: {@link Builder#appLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test Builder appLifecyclePhase(LifecyclePhase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.appLifecyclePhase(LifecyclePhase)"})
  void testBuilderAppLifecyclePhase() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appLifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Test Builder {@link Builder#appRef(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#appRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder appRef(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.appRef(EntityReference)"})
  void testBuilderAppRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appRef(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationInstanceSummary)}.
   * <ul>
   *   <li>Given {@code Attested By}.</li>
   *   <li>Then builder build attestedBy is {@code Attested By}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationAttestationInstanceSummary)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationInstanceSummary); given 'Attested By'; then builder build attestedBy is 'Attested By'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationInstanceSummary)"})
  void testBuilderFrom_givenAttestedBy_thenBuilderBuildAttestedByIsAttestedBy() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();
    ApplicationAttestationInstanceSummary instance = mock(ApplicationAttestationInstanceSummary.class);
    when(instance.attestedBy()).thenReturn("Attested By");
    when(instance.attestedAt()).thenReturn(mock(Timestamp.class));
    when(instance.appLifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.appCriticality()).thenReturn(Criticality.LOW);
    when(instance.appKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.appAssetCode()).thenReturn("App Asset Code");
    when(instance.appRef()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(ApplicationAttestationInstanceSummary)}.
   * <ul>
   *   <li>Then builder build attestedBy is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationAttestationInstanceSummary)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationInstanceSummary); then builder build attestedBy is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationInstanceSummary)"})
  void testBuilderFrom_thenBuilderBuildAttestedByIsNull() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();
    ApplicationAttestationInstanceSummary instance = mock(ApplicationAttestationInstanceSummary.class);
    when(instance.attestedBy()).thenReturn(null);
    when(instance.attestedAt()).thenReturn(mock(Timestamp.class));
    when(instance.appLifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.appCriticality()).thenReturn(Criticality.LOW);
    when(instance.appKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.appAssetCode()).thenReturn("App Asset Code");
    when(instance.appRef()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(ApplicationAttestationInstanceSummary)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationAttestationInstanceSummary)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationInstanceSummary); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationInstanceSummary)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();
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
   * Test Json {@link Json#appAssetCode()}.
   * <p>
   * Method under test: {@link Json#appAssetCode()}
   */
  @Test
  @DisplayName("Test Json appAssetCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.appAssetCode()"})
  void testJsonAppAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).appAssetCode());
  }

  /**
   * Test Json {@link Json#appCriticality()}.
   * <p>
   * Method under test: {@link Json#appCriticality()}
   */
  @Test
  @DisplayName("Test Json appCriticality()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Criticality Json.appCriticality()"})
  void testJsonAppCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).appCriticality());
  }

  /**
   * Test Json {@link Json#appKind()}.
   * <p>
   * Method under test: {@link Json#appKind()}
   */
  @Test
  @DisplayName("Test Json appKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApplicationKind Json.appKind()"})
  void testJsonAppKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).appKind());
  }

  /**
   * Test Json {@link Json#appLifecyclePhase()}.
   * <p>
   * Method under test: {@link Json#appLifecyclePhase()}
   */
  @Test
  @DisplayName("Test Json appLifecyclePhase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LifecyclePhase Json.appLifecyclePhase()"})
  void testJsonAppLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).appLifecyclePhase());
  }

  /**
   * Test Json {@link Json#appRef()}.
   * <p>
   * Method under test: {@link Json#appRef()}
   */
  @Test
  @DisplayName("Test Json appRef()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.appRef()"})
  void testJsonAppRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).appRef());
  }

  /**
   * Test Json {@link Json#attestedAt()}.
   * <p>
   * Method under test: {@link Json#attestedAt()}
   */
  @Test
  @DisplayName("Test Json attestedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Timestamp Json.attestedAt()"})
  void testJsonAttestedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestedAt());
  }

  /**
   * Test Json {@link Json#attestedBy()}.
   * <p>
   * Method under test: {@link Json#attestedBy()}
   */
  @Test
  @DisplayName("Test Json attestedBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.attestedBy()"})
  void testJsonAttestedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestedBy());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAppAssetCode(String)}
   *   <li>{@link Json#setAppCriticality(Criticality)}
   *   <li>{@link Json#setAppKind(ApplicationKind)}
   *   <li>{@link Json#setAppLifecyclePhase(LifecyclePhase)}
   *   <li>{@link Json#setAppRef(EntityReference)}
   *   <li>{@link Json#setAttestedAt(Timestamp)}
   *   <li>{@link Json#setAttestedBy(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setAppAssetCode(String)",
      "void Json.setAppCriticality(Criticality)", "void Json.setAppKind(ApplicationKind)",
      "void Json.setAppLifecyclePhase(LifecyclePhase)", "void Json.setAppRef(EntityReference)",
      "void Json.setAttestedAt(Timestamp)", "void Json.setAttestedBy(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
