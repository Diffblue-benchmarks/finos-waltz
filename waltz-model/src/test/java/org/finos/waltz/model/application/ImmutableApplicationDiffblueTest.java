package org.finos.waltz.model.application;

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
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.IsRemovedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.OrganisationalUnitIdProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.Test;

class ImmutableApplicationDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableApplication.Builder#applicationKind(ApplicationKind)}
   */
  @Test
  void testBuilderApplicationKind() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationKind(ApplicationKind.IN_HOUSE));
  }

  /**
   * Method under test:
   * {@link ImmutableApplication.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplication.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplication.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableApplication.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplication.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableApplication.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatus();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplication.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityLifecycleStatus();
  }

  /**
   * Method under test: {@link ImmutableApplication.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableApplication.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableApplication.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableApplication.Builder#from(IsRemovedProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    IsRemovedProvider instance = mock(IsRemovedProvider.class);
    when(instance.isRemoved()).thenReturn(true);

    // Act
    ImmutableApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).isRemoved();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableApplication.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplication.Builder#from(OrganisationalUnitIdProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    OrganisationalUnitIdProvider instance = mock(OrganisationalUnitIdProvider.class);
    when(instance.organisationalUnitId()).thenReturn(1L);

    // Act
    ImmutableApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).organisationalUnitId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplication.Builder#from(OrganisationalUnitIdProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    OrganisationalUnitIdProvider instance = mock(OrganisationalUnitIdProvider.class);
    when(instance.organisationalUnitId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).organisationalUnitId();
  }

  /**
   * Method under test:
   * {@link ImmutableApplication.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableApplication.Builder#from(Application)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult5);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult6 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult6);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    ImmutableApplication buildResult = builderResult.build();
    Optional<String> externalIdResult = buildResult.externalId();
    assertEquals("42", externalIdResult.get());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableApplication.Builder#from(Application)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    Application instance = mock(Application.class);
    when(instance.plannedRetirementDate()).thenThrow(new IllegalStateException("instance"));
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult2 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult2);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult3 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult3);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).name();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
  }

  /**
   * Method under test: {@link ImmutableApplication.Builder#from(Application)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult2);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult4 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult4);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult5);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    ImmutableApplication buildResult = builderResult.build();
    Optional<String> externalIdResult = buildResult.externalId();
    assertEquals("42", externalIdResult.get());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableApplication.Builder#from(Application)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.commissionDate()).thenReturn(emptyResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult2);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult4 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult4);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult5);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    ImmutableApplication buildResult = builderResult.build();
    Optional<String> externalIdResult = buildResult.externalId();
    assertEquals("42", externalIdResult.get());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableApplication.Builder#from(Application)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.plannedRetirementDate()).thenReturn(emptyResult);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult4 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult4);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult5);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    ImmutableApplication buildResult = builderResult.build();
    Optional<String> externalIdResult = buildResult.externalId();
    assertEquals("42", externalIdResult.get());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableApplication.Builder#from(Application)}
   */
  @Test
  void testBuilderFrom21() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.actualRetirementDate()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult4 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult4);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult5);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    ImmutableApplication buildResult = builderResult.build();
    Optional<String> externalIdResult = buildResult.externalId();
    assertEquals("42", externalIdResult.get());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableApplication.Builder#from(Application)}
   */
  @Test
  void testBuilderFrom22() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> emptyResult = Optional.empty();
    when(instance.assetCode()).thenReturn(emptyResult);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult5);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    ImmutableApplication buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertTrue(buildResult.isRemoved());
    assertSame(emptyResult, buildResult.externalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableApplication.Builder#from(Application)}
   */
  @Test
  void testBuilderFrom23() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult5);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> emptyResult = Optional.empty();
    when(instance.parentAssetCode()).thenReturn(emptyResult);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    ImmutableApplication buildResult = builderResult.build();
    Optional<String> externalIdResult = buildResult.externalId();
    assertEquals("42", externalIdResult.get());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableApplication.Builder#from(Application)}
   */
  @Test
  void testBuilderFrom24() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult5);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult6 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult6);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    ImmutableApplication buildResult = builderResult.build();
    Optional<String> externalIdResult = buildResult.externalId();
    assertEquals("42", externalIdResult.get());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableApplication.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableApplication.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableApplication.Builder#isRemoved(boolean)}
   */
  @Test
  void testBuilderIsRemoved() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRemoved(true));
  }

  /**
   * Method under test:
   * {@link ImmutableApplication.Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  void testBuilderLifecyclePhase() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Method under test: {@link ImmutableApplication.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableApplication.Builder#organisationalUnitId(Long)}
   */
  @Test
  void testBuilderOrganisationalUnitId() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.organisationalUnitId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableApplication.Builder#overallRating(RagRating)}
   */
  @Test
  void testBuilderOverallRating() {
    // Arrange
    ImmutableApplication.Builder builderResult = ImmutableApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.overallRating(RagRating.R));
  }

  /**
   * Method under test: {@link ImmutableApplication#copyOf(Application)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult5);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult6 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult6);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableApplication actualCopyOfResult = ImmutableApplication.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    Optional<String> externalIdResult = actualCopyOfResult.externalId();
    assertEquals("42", externalIdResult.get());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualCopyOfResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualCopyOfResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(RagRating.R, actualCopyOfResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutableApplication#copyOf(Application)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult2);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult4 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult4);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult5);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableApplication actualCopyOfResult = ImmutableApplication.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    Optional<String> externalIdResult = actualCopyOfResult.externalId();
    assertEquals("42", externalIdResult.get());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualCopyOfResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualCopyOfResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(RagRating.R, actualCopyOfResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutableApplication#copyOf(Application)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.commissionDate()).thenReturn(emptyResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult2);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult4 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult4);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult5);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableApplication actualCopyOfResult = ImmutableApplication.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    Optional<String> externalIdResult = actualCopyOfResult.externalId();
    assertEquals("42", externalIdResult.get());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualCopyOfResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualCopyOfResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(RagRating.R, actualCopyOfResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutableApplication#copyOf(Application)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.plannedRetirementDate()).thenReturn(emptyResult);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult4 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult4);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult5);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableApplication actualCopyOfResult = ImmutableApplication.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    Optional<String> externalIdResult = actualCopyOfResult.externalId();
    assertEquals("42", externalIdResult.get());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualCopyOfResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualCopyOfResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(RagRating.R, actualCopyOfResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutableApplication#copyOf(Application)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(false);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult5);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult6 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult6);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableApplication actualCopyOfResult = ImmutableApplication.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    Optional<String> externalIdResult = actualCopyOfResult.externalId();
    assertEquals("42", externalIdResult.get());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualCopyOfResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualCopyOfResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(RagRating.R, actualCopyOfResult.overallRating());
    assertFalse(actualCopyOfResult.isRemoved());
    assertTrue(externalIdResult.isPresent());
  }

  /**
   * Method under test: {@link ImmutableApplication#copyOf(Application)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.actualRetirementDate()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult4 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult4);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult5);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableApplication actualCopyOfResult = ImmutableApplication.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    Optional<String> externalIdResult = actualCopyOfResult.externalId();
    assertEquals("42", externalIdResult.get());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualCopyOfResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualCopyOfResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(RagRating.R, actualCopyOfResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutableApplication#copyOf(Application)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> emptyResult = Optional.empty();
    when(instance.assetCode()).thenReturn(emptyResult);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult5);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableApplication actualCopyOfResult = ImmutableApplication.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualCopyOfResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualCopyOfResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(RagRating.R, actualCopyOfResult.overallRating());
    Optional<String> externalIdResult = actualCopyOfResult.externalId();
    assertFalse(externalIdResult.isPresent());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(emptyResult, externalIdResult);
  }

  /**
   * Method under test: {@link ImmutableApplication#copyOf(Application)}
   */
  @Test
  void testCopyOf8() {
    // Arrange
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult5);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> emptyResult = Optional.empty();
    when(instance.parentAssetCode()).thenReturn(emptyResult);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableApplication actualCopyOfResult = ImmutableApplication.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    Optional<String> externalIdResult = actualCopyOfResult.externalId();
    assertEquals("42", externalIdResult.get());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualCopyOfResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualCopyOfResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(RagRating.R, actualCopyOfResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutableApplication#copyOf(Application)}
   */
  @Test
  void testCopyOf9() {
    // Arrange
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult5);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult6 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult6);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableApplication actualCopyOfResult = ImmutableApplication.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    Optional<String> externalIdResult = actualCopyOfResult.externalId();
    assertEquals("42", externalIdResult.get());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualCopyOfResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualCopyOfResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(RagRating.R, actualCopyOfResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#actualRetirementDate()}
   */
  @Test
  void testJsonActualRetirementDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplication.Json()).actualRetirementDate());
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#applicationKind()}
   */
  @Test
  void testJsonApplicationKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplication.Json()).applicationKind());
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#assetCode()}
   */
  @Test
  void testJsonAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplication.Json()).assetCode());
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#businessCriticality()}
   */
  @Test
  void testJsonBusinessCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplication.Json()).businessCriticality());
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#commissionDate()}
   */
  @Test
  void testJsonCommissionDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplication.Json()).commissionDate());
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplication.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#entityLifecycleStatus()}
   */
  @Test
  void testJsonEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplication.Json()).entityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplication.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplication.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#isRemoved()}
   */
  @Test
  void testJsonIsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplication.Json()).isRemoved());
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplication.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#lifecyclePhase()}
   */
  @Test
  void testJsonLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplication.Json()).lifecyclePhase());
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplication.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableApplication.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableApplication.Json actualJson = new ImmutableApplication.Json();

    // Assert
    assertNull(actualJson.organisationalUnitId);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.businessCriticality);
    assertNull(actualJson.kind);
    assertNull(actualJson.entityLifecycleStatus);
    assertNull(actualJson.applicationKind);
    assertNull(actualJson.lifecyclePhase);
    assertNull(actualJson.overallRating);
    assertFalse(actualJson.actualRetirementDate.isPresent());
    assertFalse(actualJson.assetCode.isPresent());
    assertFalse(actualJson.commissionDate.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.parentAssetCode.isPresent());
    assertFalse(actualJson.plannedRetirementDate.isPresent());
    assertFalse(actualJson.isRemoved);
    assertFalse(actualJson.isRemovedIsSet);
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#organisationalUnitId()}
   */
  @Test
  void testJsonOrganisationalUnitId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplication.Json()).organisationalUnitId());
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#overallRating()}
   */
  @Test
  void testJsonOverallRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplication.Json()).overallRating());
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#parentAssetCode()}
   */
  @Test
  void testJsonParentAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplication.Json()).parentAssetCode());
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#plannedRetirementDate()}
   */
  @Test
  void testJsonPlannedRetirementDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplication.Json()).plannedRetirementDate());
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplication.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableApplication.Json#setIsRemoved(boolean)}
   */
  @Test
  void testJsonSetIsRemoved() {
    // Arrange
    ImmutableApplication.Json json = new ImmutableApplication.Json();

    // Act
    json.setIsRemoved(true);

    // Assert
    assertTrue(json.isRemoved);
    assertTrue(json.isRemovedIsSet);
  }
}
