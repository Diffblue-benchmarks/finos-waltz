package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Timestamp;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.attestation.ImmutableApplicationAttestationInstanceSummary.Builder;
import org.finos.waltz.model.attestation.ImmutableApplicationAttestationInstanceSummary.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationAttestationInstanceSummaryDiffblueTest {
  /**
   * Test Builder {@link Builder#appAssetCode(String)}.
   *
   * <ul>
   *   <li>When {@code App Asset Code}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#appAssetCode(String)}
   */
  @Test
  @DisplayName("Test Builder appAssetCode(String); when 'App Asset Code'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.appAssetCode(String)"})
  void testBuilderAppAssetCode_whenAppAssetCode_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();

    // Act
    Builder actualAppAssetCodeResult = builderResult.appAssetCode("App Asset Code");

    // Assert
    assertSame(builderResult, actualAppAssetCodeResult);
  }

  /**
   * Test Builder {@link Builder#appCriticality(Criticality)}.
   *
   * <p>Method under test: {@link Builder#appCriticality(Criticality)}
   */
  @Test
  @DisplayName("Test Builder appCriticality(Criticality)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.appCriticality(Criticality)"})
  void testBuilderAppCriticality() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();

    // Act
    Builder actualAppCriticalityResult = builderResult.appCriticality(Criticality.LOW);

    // Assert
    assertSame(builderResult, actualAppCriticalityResult);
  }

  /**
   * Test Builder {@link Builder#appKind(ApplicationKind)}.
   *
   * <p>Method under test: {@link Builder#appKind(ApplicationKind)}
   */
  @Test
  @DisplayName("Test Builder appKind(ApplicationKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.appKind(ApplicationKind)"})
  void testBuilderAppKind() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();

    // Act
    Builder actualAppKindResult = builderResult.appKind(ApplicationKind.IN_HOUSE);

    // Assert
    assertSame(builderResult, actualAppKindResult);
  }

  /**
   * Test Builder {@link Builder#appLifecyclePhase(LifecyclePhase)}.
   *
   * <p>Method under test: {@link Builder#appLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test Builder appLifecyclePhase(LifecyclePhase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.appLifecyclePhase(LifecyclePhase)"})
  void testBuilderAppLifecyclePhase() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();

    // Act
    Builder actualAppLifecyclePhaseResult =
        builderResult.appLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertSame(builderResult, actualAppLifecyclePhaseResult);
  }

  /**
   * Test Builder {@link Builder#appRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#appRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder appRef(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.appRef(EntityReference)"})
  void testBuilderAppRef_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();

    // Act
    Builder actualAppRefResult =
        builderResult.appRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualAppRefResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationInstanceSummary)}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationAttestationInstanceSummary)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationInstanceSummary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationInstanceSummary)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();

    ApplicationAttestationInstanceSummary instance =
        mock(ApplicationAttestationInstanceSummary.class);
    when(instance.appAssetCode()).thenThrow(new IllegalStateException());
    when(instance.appRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).appAssetCode();
    verify(instance).appRef();
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationInstanceSummary)}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationAttestationInstanceSummary)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationInstanceSummary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationInstanceSummary)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();

    ApplicationAttestationInstanceSummary instance =
        mock(ApplicationAttestationInstanceSummary.class);
    when(instance.appKind()).thenThrow(new IllegalStateException());
    when(instance.appAssetCode()).thenReturn("App Asset Code");
    when(instance.appRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).appAssetCode();
    verify(instance).appKind();
    verify(instance).appRef();
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationInstanceSummary)}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationAttestationInstanceSummary)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationInstanceSummary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationInstanceSummary)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();

    ApplicationAttestationInstanceSummary instance =
        mock(ApplicationAttestationInstanceSummary.class);
    when(instance.appCriticality()).thenThrow(new IllegalStateException());
    when(instance.appKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.appAssetCode()).thenReturn("App Asset Code");
    when(instance.appRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).appAssetCode();
    verify(instance).appCriticality();
    verify(instance).appKind();
    verify(instance).appRef();
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationInstanceSummary)}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationAttestationInstanceSummary)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationInstanceSummary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationInstanceSummary)"})
  void testBuilderFrom4() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();

    ApplicationAttestationInstanceSummary instance =
        mock(ApplicationAttestationInstanceSummary.class);
    when(instance.appLifecyclePhase()).thenThrow(new IllegalStateException());
    when(instance.appCriticality()).thenReturn(Criticality.LOW);
    when(instance.appKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.appAssetCode()).thenReturn("App Asset Code");
    when(instance.appRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).appAssetCode();
    verify(instance).appCriticality();
    verify(instance).appKind();
    verify(instance).appLifecyclePhase();
    verify(instance).appRef();
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationInstanceSummary)}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationAttestationInstanceSummary)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationInstanceSummary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationInstanceSummary)"})
  void testBuilderFrom5() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();

    ApplicationAttestationInstanceSummary instance =
        mock(ApplicationAttestationInstanceSummary.class);
    when(instance.attestedAt()).thenThrow(new IllegalStateException());
    when(instance.appLifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.appCriticality()).thenReturn(Criticality.LOW);
    when(instance.appKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.appAssetCode()).thenReturn("App Asset Code");
    when(instance.appRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

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
   * Test Builder {@link Builder#from(ApplicationAttestationInstanceSummary)}.
   *
   * <ul>
   *   <li>Given {@code Attested By}.
   *   <li>Then return build attestedBy is {@code Attested By}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ApplicationAttestationInstanceSummary)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ApplicationAttestationInstanceSummary); given 'Attested By'; then return build attestedBy is 'Attested By'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationInstanceSummary)"})
  void testBuilderFrom_givenAttestedBy_thenReturnBuildAttestedByIsAttestedBy() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();

    ApplicationAttestationInstanceSummary instance =
        mock(ApplicationAttestationInstanceSummary.class);
    when(instance.attestedBy()).thenReturn("Attested By");
    when(instance.attestedAt()).thenReturn(null);
    when(instance.appLifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.appCriticality()).thenReturn(Criticality.LOW);
    when(instance.appKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.appAssetCode()).thenReturn("App Asset Code");
    when(instance.appRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

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
    ImmutableApplicationAttestationInstanceSummary immutableApplicationAttestationInstanceSummary =
        actualFromResult.build();
    assertEquals("Attested By", immutableApplicationAttestationInstanceSummary.attestedBy());
    ImmutableApplicationAttestationInstanceSummary immutableApplicationAttestationInstanceSummary2 =
        builderResult.build();
    assertEquals("Attested By", immutableApplicationAttestationInstanceSummary2.attestedBy());
    assertNull(immutableApplicationAttestationInstanceSummary.attestedAt());
    assertNull(immutableApplicationAttestationInstanceSummary2.attestedAt());
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationInstanceSummary)}.
   *
   * <ul>
   *   <li>Then builder build attestedAt is {@link Timestamp#Timestamp(long)} with time is ten.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ApplicationAttestationInstanceSummary)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ApplicationAttestationInstanceSummary); then builder build attestedAt is Timestamp(long) with time is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationInstanceSummary)"})
  void testBuilderFrom_thenBuilderBuildAttestedAtIsTimestampWithTimeIsTen() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();

    ApplicationAttestationInstanceSummary instance =
        mock(ApplicationAttestationInstanceSummary.class);
    when(instance.attestedBy()).thenReturn("Attested By");
    Timestamp timestamp = new Timestamp(10L);
    when(instance.attestedAt()).thenReturn(timestamp);
    when(instance.appLifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.appCriticality()).thenReturn(Criticality.LOW);
    when(instance.appKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.appAssetCode()).thenReturn("App Asset Code");
    when(instance.appRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

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
    assertEquals("Attested By", actualFromResult.build().attestedBy());
    ImmutableApplicationAttestationInstanceSummary immutableApplicationAttestationInstanceSummary =
        builderResult.build();
    assertEquals("Attested By", immutableApplicationAttestationInstanceSummary.attestedBy());
    assertSame(timestamp, immutableApplicationAttestationInstanceSummary.attestedAt());
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationInstanceSummary)}.
   *
   * <ul>
   *   <li>Then return build attestedBy is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ApplicationAttestationInstanceSummary)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ApplicationAttestationInstanceSummary); then return build attestedBy is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationInstanceSummary)"})
  void testBuilderFrom_thenReturnBuildAttestedByIsNull() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceSummary.builder();

    ApplicationAttestationInstanceSummary instance =
        mock(ApplicationAttestationInstanceSummary.class);
    when(instance.attestedBy()).thenReturn(null);
    when(instance.attestedAt()).thenReturn(null);
    when(instance.appLifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.appCriticality()).thenReturn(Criticality.LOW);
    when(instance.appKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.appAssetCode()).thenReturn("App Asset Code");
    when(instance.appRef())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

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
    ImmutableApplicationAttestationInstanceSummary immutableApplicationAttestationInstanceSummary =
        actualFromResult.build();
    assertNull(immutableApplicationAttestationInstanceSummary.attestedBy());
    ImmutableApplicationAttestationInstanceSummary immutableApplicationAttestationInstanceSummary2 =
        builderResult.build();
    assertNull(immutableApplicationAttestationInstanceSummary2.attestedBy());
    assertNull(immutableApplicationAttestationInstanceSummary.attestedAt());
    assertNull(immutableApplicationAttestationInstanceSummary2.attestedAt());
  }

  /**
   * Test Json {@link Json#appAssetCode()}.
   *
   * <p>Method under test: {@link Json#appAssetCode()}
   */
  @Test
  @DisplayName("Test Json appAssetCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.appAssetCode()"})
  void testJsonAppAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().appAssetCode());
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
  @MethodsUnderTest({"Criticality Json.appCriticality()"})
  void testJsonAppCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().appCriticality());
  }

  /**
   * Test Json {@link Json#appKind()}.
   *
   * <p>Method under test: {@link Json#appKind()}
   */
  @Test
  @DisplayName("Test Json appKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ApplicationKind Json.appKind()"})
  void testJsonAppKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().appKind());
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
  @MethodsUnderTest({"LifecyclePhase Json.appLifecyclePhase()"})
  void testJsonAppLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().appLifecyclePhase());
  }

  /**
   * Test Json {@link Json#appRef()}.
   *
   * <p>Method under test: {@link Json#appRef()}
   */
  @Test
  @DisplayName("Test Json appRef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.appRef()"})
  void testJsonAppRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().appRef());
  }

  /**
   * Test Json {@link Json#attestedAt()}.
   *
   * <p>Method under test: {@link Json#attestedAt()}
   */
  @Test
  @DisplayName("Test Json attestedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Timestamp Json.attestedAt()"})
  void testJsonAttestedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestedAt());
  }

  /**
   * Test Json {@link Json#attestedBy()}.
   *
   * <p>Method under test: {@link Json#attestedBy()}
   */
  @Test
  @DisplayName("Test Json attestedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.attestedBy()"})
  void testJsonAttestedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestedBy());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAppAssetCode(String)}
   *   <li>{@link Json#setAppCriticality(Criticality)}
   *   <li>{@link Json#setAppKind(ApplicationKind)}
   *   <li>{@link Json#setAppLifecyclePhase(LifecyclePhase)}
   *   <li>{@link Json#setAppRef(EntityReference)}
   *   <li>{@link Json#setAttestedBy(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setAppAssetCode(String)",
    "void Json.setAppCriticality(Criticality)",
    "void Json.setAppKind(ApplicationKind)",
    "void Json.setAppLifecyclePhase(LifecyclePhase)",
    "void Json.setAppRef(EntityReference)",
    "void Json.setAttestedAt(Timestamp)",
    "void Json.setAttestedBy(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAppAssetCode("App Asset Code");
    actualJson.setAppCriticality(Criticality.LOW);
    actualJson.setAppKind(ApplicationKind.IN_HOUSE);
    actualJson.setAppLifecyclePhase(LifecyclePhase.PRODUCTION);
    actualJson.setAppRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setAttestedBy("Attested By");

    // Assert
    EntityReference entityReference = actualJson.appRef;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    assertEquals("App Asset Code", actualJson.appAssetCode);
    assertEquals("Attested By", actualJson.attestedBy);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertNull(actualJson.attestedAt);
    assertEquals(1L, entityReference.id());
    assertEquals(Criticality.LOW, actualJson.appCriticality);
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualJson.appKind);
    assertEquals(LifecyclePhase.PRODUCTION, actualJson.appLifecyclePhase);
  }
}
