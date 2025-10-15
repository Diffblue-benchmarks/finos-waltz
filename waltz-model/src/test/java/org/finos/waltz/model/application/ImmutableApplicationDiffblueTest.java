package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.util.Optional;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.IsRemovedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.OrganisationalUnitIdProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.app_group.AppGroupKind;
import org.finos.waltz.model.app_group.ImmutableAppGroup;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.application.ImmutableApplication.Builder;
import org.finos.waltz.model.application.ImmutableApplication.Json;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationDiffblueTest {
  /**
   * Test {@link ImmutableApplication#actualRetirementDate()}.
   *
   * <p>Method under test: {@link ImmutableApplication#actualRetirementDate()}
   */
  @Test
  @DisplayName("Test actualRetirementDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableApplication.actualRetirementDate()"})
  void testActualRetirementDate() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(ofResult.atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    Optional<LocalDateTime> actualActualRetirementDateResult =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .actualRetirementDate();

    // Assert
    LocalDateTime getResult = actualActualRetirementDateResult.get();
    assertEquals("00:00", getResult.toLocalTime().toString());
    LocalDate toLocalDateResult = getResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertTrue(actualActualRetirementDateResult.isPresent());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableApplication#assetCode()}.
   *
   * <p>Method under test: {@link ImmutableApplication#assetCode()}
   */
  @Test
  @DisplayName("Test assetCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableApplication.assetCode()"})
  void testAssetCode() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertEquals(
        assetCode,
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .assetCode());
  }

  /**
   * Test Builder {@link Builder#actualRetirementDate(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#actualRetirementDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder actualRetirementDate(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.actualRetirementDate(Optional)"})
  void testBuilderActualRetirementDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Optional<? extends LocalDateTime> actualRetirementDate =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualActualRetirementDateResult =
        builderResult.actualRetirementDate(actualRetirementDate);

    // Assert
    assertSame(builderResult, actualActualRetirementDateResult);
  }

  /**
   * Test Builder {@link Builder#applicationKind(ApplicationKind)}.
   *
   * <p>Method under test: {@link Builder#applicationKind(ApplicationKind)}
   */
  @Test
  @DisplayName("Test Builder applicationKind(ApplicationKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicationKind(ApplicationKind)"})
  void testBuilderApplicationKind() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act
    Builder actualApplicationKindResult = builderResult.applicationKind(ApplicationKind.IN_HOUSE);

    // Assert
    assertSame(builderResult, actualApplicationKindResult);
  }

  /**
   * Test Builder {@link Builder#assetCode(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#assetCode(Optional)}
   */
  @Test
  @DisplayName("Test Builder assetCode(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assetCode(Optional)"})
  void testBuilderAssetCodeWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    Builder actualAssetCodeResult = builderResult.assetCode(assetCode);

    // Assert
    assertSame(builderResult, actualAssetCodeResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#actualRetirementDate(LocalDateTime)}
   *   <li>{@link Builder#assetCode(ExternalIdValue)}
   *   <li>{@link Builder#businessCriticality(Criticality)}
   *   <li>{@link Builder#commissionDate(LocalDateTime)}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#entityLifecycleStatus(EntityLifecycleStatus)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#parentAssetCode(ExternalIdValue)}
   *   <li>{@link Builder#plannedRetirementDate(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.actualRetirementDate(LocalDateTime)",
    "Builder Builder.assetCode(ExternalIdValue)",
    "ImmutableApplication Builder.build()",
    "Builder Builder.businessCriticality(Criticality)",
    "Builder Builder.commissionDate(LocalDateTime)",
    "Builder Builder.description(String)",
    "Builder Builder.entityLifecycleStatus(EntityLifecycleStatus)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.parentAssetCode(ExternalIdValue)",
    "Builder Builder.plannedRetirementDate(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualActualRetirementDateResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<? extends LocalDateTime> actualRetirementDate =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    Builder actualApplicationKindResult =
        actualActualRetirementDateResult
            .actualRetirementDate(actualRetirementDate)
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));
    Builder actualAssetCodeResult = actualApplicationKindResult.assetCode(assetCode);
    Builder actualCommissionDateResult =
        actualAssetCodeResult
            .assetCode(ExternalIdValue.of("42"))
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<? extends LocalDateTime> commissionDate =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    Builder actualIdResult =
        actualCommissionDateResult
            .commissionDate(commissionDate)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L);
    Optional<Long> id = Optional.of(1L);
    Builder actualOverallRatingResult =
        actualIdResult
            .id(id)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    Builder actualParentAssetCodeResult =
        actualOverallRatingResult.parentAssetCode(parentAssetCode);
    Builder actualPlannedRetirementDateResult =
        actualParentAssetCodeResult
            .parentAssetCode(ExternalIdValue.of("42"))
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<? extends LocalDateTime> plannedRetirementDate =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    ImmutableApplication actualImmutableApplication =
        actualPlannedRetirementDateResult
            .plannedRetirementDate(plannedRetirementDate)
            .provenance("Provenance")
            .build();

    // Assert
    Optional<String> externalIdResult = actualImmutableApplication.externalId();
    assertEquals("42", externalIdResult.get());
    assertEquals("Name", actualImmutableApplication.name());
    assertEquals("Provenance", actualImmutableApplication.provenance());
    assertEquals(
        "The characteristics of someone or something", actualImmutableApplication.description());
    assertEquals(1L, actualImmutableApplication.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualImmutableApplication.businessCriticality());
    assertEquals(EntityKind.ALL, actualImmutableApplication.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualImmutableApplication.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualImmutableApplication.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualImmutableApplication.lifecyclePhase());
    assertEquals(RagRating.R, actualImmutableApplication.overallRating());
    assertFalse(actualImmutableApplication.isRemoved());
    assertTrue(externalIdResult.isPresent());
  }

  /**
   * Test Builder {@link Builder#commissionDate(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#commissionDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder commissionDate(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.commissionDate(Optional)"})
  void testBuilderCommissionDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Optional<? extends LocalDateTime> commissionDate =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualCommissionDateResult = builderResult.commissionDate(commissionDate);

    // Assert
    assertSame(builderResult, actualCommissionDateResult);
  }

  /**
   * Test Builder {@link Builder#from(Application)} with {@code Application}.
   *
   * <p>Method under test: {@link Builder#from(Application)}
   */
  @Test
  @DisplayName("Test Builder from(Application) with 'Application'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Application)"})
  void testBuilderFromWithApplication() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableApplication actualImmutableApplication = builderResult.build();
    assertEquals(instance, actualImmutableApplication);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Application)} with {@code Application}.
   *
   * <p>Method under test: {@link Builder#from(Application)}
   */
  @Test
  @DisplayName("Test Builder from(Application) with 'Application'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Application)"})
  void testBuilderFromWithApplication2() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.empty();

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableApplication actualImmutableApplication = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableApplication);
    ImmutableApplication actualImmutableApplication2 = builderResult.build();
    assertEquals(instance, actualImmutableApplication2);
  }

  /**
   * Test Builder {@link Builder#from(Application)} with {@code Application}.
   *
   * <p>Method under test: {@link Builder#from(Application)}
   */
  @Test
  @DisplayName("Test Builder from(Application) with 'Application'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Application)"})
  void testBuilderFromWithApplication3() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description(null)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableApplication actualImmutableApplication = builderResult.build();
    assertEquals(instance, actualImmutableApplication);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Application)} with {@code Application}.
   *
   * <p>Method under test: {@link Builder#from(Application)}
   */
  @Test
  @DisplayName("Test Builder from(Application) with 'Application'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Application)"})
  void testBuilderFromWithApplication4() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.empty();
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableApplication actualImmutableApplication = builderResult.build();
    assertEquals(instance, actualImmutableApplication);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableApplication.builder();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableApplication actualImmutableApplication = builderResult.build();
    assertEquals(instance, actualImmutableApplication);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableApplication actualImmutableApplication = builderResult.build();
    assertEquals(instance, actualImmutableApplication);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (EntityLifecycleStatusProvider)
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider2() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityLifecycleStatusProvider) instance);

    // Assert
    ImmutableApplication actualImmutableApplication = builderResult.build();
    assertEquals(instance, actualImmutableApplication);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider3() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (EntityLifecycleStatusProvider)
                ImmutableAppGroupEntry.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider4() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (EntityLifecycleStatusProvider)
                ImmutableAppGroupEntry.builder()
                    .description(null)
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider5() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.empty();

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableApplication actualImmutableApplication =
        builderResult.from((EntityLifecycleStatusProvider) instance).build();
    assertEquals(instance, actualImmutableApplication);
    ImmutableApplication actualImmutableApplication2 = builderResult.build();
    assertEquals(instance, actualImmutableApplication2);
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider6() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.empty();
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityLifecycleStatusProvider) instance);

    // Assert
    ImmutableApplication actualImmutableApplication = builderResult.build();
    assertEquals(instance, actualImmutableApplication);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableApplication actualImmutableApplication = builderResult.build();
    assertEquals(instance, actualImmutableApplication);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

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
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (IsRemovedProvider)
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider2() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IsRemovedProvider) instance);

    // Assert
    ImmutableApplication actualImmutableApplication = builderResult.build();
    assertEquals(instance, actualImmutableApplication);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider3() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (IsRemovedProvider)
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description(null)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider4() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.empty();

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableApplication actualImmutableApplication =
        builderResult.from((IsRemovedProvider) instance).build();
    assertEquals(instance, actualImmutableApplication);
    ImmutableApplication actualImmutableApplication2 = builderResult.build();
    assertEquals(instance, actualImmutableApplication2);
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider5() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.empty();
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IsRemovedProvider) instance);

    // Assert
    ImmutableApplication actualImmutableApplication = builderResult.build();
    assertEquals(instance, actualImmutableApplication);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableApplication actualImmutableApplication = builderResult.build();
    assertEquals(instance, actualImmutableApplication);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then calls {@link NameProvider#name()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then calls name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenCallsName() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OrganisationalUnitIdProvider)} with {@code
   * OrganisationalUnitIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(OrganisationalUnitIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OrganisationalUnitIdProvider) with 'OrganisationalUnitIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OrganisationalUnitIdProvider)"})
  void testBuilderFromWithOrganisationalUnitIdProvider() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((OrganisationalUnitIdProvider) instance);

    // Assert
    ImmutableApplication actualImmutableApplication = builderResult.build();
    assertEquals(instance, actualImmutableApplication);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OrganisationalUnitIdProvider)} with {@code
   * OrganisationalUnitIdProvider}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(OrganisationalUnitIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OrganisationalUnitIdProvider) with 'OrganisationalUnitIdProvider'; given one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OrganisationalUnitIdProvider)"})
  void testBuilderFromWithOrganisationalUnitIdProvider_givenOne() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    OrganisationalUnitIdProvider instance = mock(OrganisationalUnitIdProvider.class);
    when(instance.organisationalUnitId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).organisationalUnitId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OrganisationalUnitIdProvider)} with {@code
   * OrganisationalUnitIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(OrganisationalUnitIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OrganisationalUnitIdProvider) with 'OrganisationalUnitIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OrganisationalUnitIdProvider)"})
  void testBuilderFromWithOrganisationalUnitIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    OrganisationalUnitIdProvider instance = mock(OrganisationalUnitIdProvider.class);
    when(instance.organisationalUnitId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).organisationalUnitId();
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
    Builder builderResult = ImmutableApplication.builder();

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
    Builder builderResult = ImmutableApplication.builder();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableApplication actualImmutableApplication = builderResult.build();
    assertEquals(instance, actualImmutableApplication);
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
  void testBuilderFromWithProvenanceProvider3() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
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
  void testBuilderFromWithProvenanceProvider4() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description(null)
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
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
  void testBuilderFromWithProvenanceProvider5() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.empty();

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableApplication actualImmutableApplication =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableApplication);
    ImmutableApplication actualImmutableApplication2 = builderResult.build();
    assertEquals(instance, actualImmutableApplication2);
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
  void testBuilderFromWithProvenanceProvider6() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.empty();
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableApplication actualImmutableApplication = builderResult.build();
    assertEquals(instance, actualImmutableApplication);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isRemoved(boolean)}.
   *
   * <p>Method under test: {@link Builder#isRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Builder isRemoved(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isRemoved(boolean)"})
  void testBuilderIsRemoved() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act
    Builder actualIsRemovedResult = builderResult.isRemoved(true);

    // Assert
    assertSame(builderResult, actualIsRemovedResult);
  }

  /**
   * Test Builder {@link Builder#lifecyclePhase(LifecyclePhase)}.
   *
   * <p>Method under test: {@link Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test Builder lifecyclePhase(LifecyclePhase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lifecyclePhase(LifecyclePhase)"})
  void testBuilderLifecyclePhase() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act
    Builder actualLifecyclePhaseResult = builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertSame(builderResult, actualLifecyclePhaseResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#organisationalUnitId(Long)}.
   *
   * <p>Method under test: {@link Builder#organisationalUnitId(Long)}
   */
  @Test
  @DisplayName("Test Builder organisationalUnitId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.organisationalUnitId(Long)"})
  void testBuilderOrganisationalUnitId() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act
    Builder actualOrganisationalUnitIdResult = builderResult.organisationalUnitId(1L);

    // Assert
    assertSame(builderResult, actualOrganisationalUnitIdResult);
  }

  /**
   * Test Builder {@link Builder#overallRating(RagRating)}.
   *
   * <p>Method under test: {@link Builder#overallRating(RagRating)}
   */
  @Test
  @DisplayName("Test Builder overallRating(RagRating)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.overallRating(RagRating)"})
  void testBuilderOverallRating() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act
    Builder actualOverallRatingResult = builderResult.overallRating(RagRating.R);

    // Assert
    assertSame(builderResult, actualOverallRatingResult);
  }

  /**
   * Test Builder {@link Builder#parentAssetCode(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#parentAssetCode(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentAssetCode(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentAssetCode(Optional)"})
  void testBuilderParentAssetCodeWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    Builder actualParentAssetCodeResult = builderResult.parentAssetCode(parentAssetCode);

    // Assert
    assertSame(builderResult, actualParentAssetCodeResult);
  }

  /**
   * Test Builder {@link Builder#plannedRetirementDate(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#plannedRetirementDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder plannedRetirementDate(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.plannedRetirementDate(Optional)"})
  void testBuilderPlannedRetirementDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Optional<? extends LocalDateTime> plannedRetirementDate =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualPlannedRetirementDateResult =
        builderResult.plannedRetirementDate(plannedRetirementDate);

    // Assert
    assertSame(builderResult, actualPlannedRetirementDateResult);
  }

  /**
   * Test {@link ImmutableApplication#businessCriticality()}.
   *
   * <p>Method under test: {@link ImmutableApplication#businessCriticality()}
   */
  @Test
  @DisplayName("Test businessCriticality()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Criticality ImmutableApplication.businessCriticality()"})
  void testBusinessCriticality() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertEquals(
        Criticality.LOW,
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .businessCriticality());
  }

  /**
   * Test {@link ImmutableApplication#commissionDate()}.
   *
   * <p>Method under test: {@link ImmutableApplication#commissionDate()}
   */
  @Test
  @DisplayName("Test commissionDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableApplication.commissionDate()"})
  void testCommissionDate() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(ofResult.atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    Optional<LocalDateTime> actualCommissionDateResult =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .commissionDate();

    // Assert
    LocalDateTime getResult = actualCommissionDateResult.get();
    assertEquals("00:00", getResult.toLocalTime().toString());
    LocalDate toLocalDateResult = getResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertTrue(actualCommissionDateResult.isPresent());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableApplication#copyOf(Application)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#copyOf(Application)}
   */
  @Test
  @DisplayName("Test copyOf(Application); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.copyOf(Application)"})
  void testCopyOf_thenReturnName() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication instance =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableApplication actualCopyOfResult = ImmutableApplication.copyOf(instance);

    // Assert
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
  }

  /**
   * Test {@link ImmutableApplication#entityLifecycleStatus()}.
   *
   * <p>Method under test: {@link ImmutableApplication#entityLifecycleStatus()}
   */
  @Test
  @DisplayName("Test entityLifecycleStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus ImmutableApplication.entityLifecycleStatus()"})
  void testEntityLifecycleStatus() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}, and {@link ImmutableApplication#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplication#equals(Object)}
   *   <li>{@link ImmutableApplication#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication2 =
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableApplication, immutableApplication2);
    assertEquals(immutableApplication.hashCode(), immutableApplication2.hashCode());
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}, and {@link ImmutableApplication#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplication#equals(Object)}
   *   <li>{@link ImmutableApplication#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableApplication, immutableApplication);
    int expectedHashCodeResult = immutableApplication.hashCode();
    assertEquals(expectedHashCodeResult, immutableApplication.hashCode());
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.now().atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableApplication,
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.INTERNALLY_HOSTED);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableApplication,
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("Name"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableApplication,
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.MEDIUM)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableApplication,
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.now().atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableApplication,
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableApplication,
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(2L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableApplication,
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableApplication,
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.DEVELOPMENT)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableApplication,
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("42")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableApplication,
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(2L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableApplication,
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.A);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableApplication,
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("Name"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableApplication,
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.now().atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableApplication,
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Name")
            .build();

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableApplication,
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertNotEquals(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplication.equals(Object)",
    "int ImmutableApplication.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertNotEquals(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build(),
        "Different type to ImmutableApplication");
  }

  /**
   * Test {@link ImmutableApplication#externalId()}.
   *
   * <p>Method under test: {@link ImmutableApplication#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableApplication.externalId()"})
  void testExternalId() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    Optional<String> actualExternalIdResult =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplication#applicationKind()}
   *   <li>{@link ImmutableApplication#description()}
   *   <li>{@link ImmutableApplication#lifecyclePhase()}
   *   <li>{@link ImmutableApplication#name()}
   *   <li>{@link ImmutableApplication#organisationalUnitId()}
   *   <li>{@link ImmutableApplication#overallRating()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationKind ImmutableApplication.applicationKind()",
    "String ImmutableApplication.description()",
    "LifecyclePhase ImmutableApplication.lifecyclePhase()",
    "String ImmutableApplication.name()",
    "Long ImmutableApplication.organisationalUnitId()",
    "RagRating ImmutableApplication.overallRating()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ApplicationKind actualApplicationKindResult = immutableApplication.applicationKind();
    String actualDescriptionResult = immutableApplication.description();
    LifecyclePhase actualLifecyclePhaseResult = immutableApplication.lifecyclePhase();
    String actualNameResult = immutableApplication.name();
    Long actualOrganisationalUnitIdResult = immutableApplication.organisationalUnitId();
    RagRating actualOverallRatingResult = immutableApplication.overallRating();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualOrganisationalUnitIdResult.longValue());
    assertEquals(ApplicationKind.IN_HOUSE, actualApplicationKindResult);
    assertEquals(LifecyclePhase.PRODUCTION, actualLifecyclePhaseResult);
    assertEquals(RagRating.R, actualOverallRatingResult);
  }

  /**
   * Test {@link ImmutableApplication#id()}.
   *
   * <p>Method under test: {@link ImmutableApplication#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableApplication.id()"})
  void testId() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    Optional<Long> actualIdResult =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableApplication#isRemoved()}.
   *
   * <p>Method under test: {@link ImmutableApplication#isRemoved()}
   */
  @Test
  @DisplayName("Test isRemoved()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableApplication.isRemoved()"})
  void testIsRemoved() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertFalse(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .isRemoved());
  }

  /**
   * Test Json {@link Json#actualRetirementDate()}.
   *
   * <p>Method under test: {@link Json#actualRetirementDate()}
   */
  @Test
  @DisplayName("Test Json actualRetirementDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.actualRetirementDate()"})
  void testJsonActualRetirementDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().actualRetirementDate());
  }

  /**
   * Test Json {@link Json#applicationKind()}.
   *
   * <p>Method under test: {@link Json#applicationKind()}
   */
  @Test
  @DisplayName("Test Json applicationKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ApplicationKind Json.applicationKind()"})
  void testJsonApplicationKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().applicationKind());
  }

  /**
   * Test Json {@link Json#assetCode()}.
   *
   * <p>Method under test: {@link Json#assetCode()}
   */
  @Test
  @DisplayName("Test Json assetCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.assetCode()"})
  void testJsonAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().assetCode());
  }

  /**
   * Test Json {@link Json#businessCriticality()}.
   *
   * <p>Method under test: {@link Json#businessCriticality()}
   */
  @Test
  @DisplayName("Test Json businessCriticality()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Criticality Json.businessCriticality()"})
  void testJsonBusinessCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().businessCriticality());
  }

  /**
   * Test Json {@link Json#commissionDate()}.
   *
   * <p>Method under test: {@link Json#commissionDate()}
   */
  @Test
  @DisplayName("Test Json commissionDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.commissionDate()"})
  void testJsonCommissionDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().commissionDate());
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
   * Test Json {@link Json#entityLifecycleStatus()}.
   *
   * <p>Method under test: {@link Json#entityLifecycleStatus()}
   */
  @Test
  @DisplayName("Test Json entityLifecycleStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus Json.entityLifecycleStatus()"})
  void testJsonEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityLifecycleStatus());
  }

  /**
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#isRemoved()}.
   *
   * <p>Method under test: {@link Json#isRemoved()}
   */
  @Test
  @DisplayName("Test Json isRemoved()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isRemoved()"})
  void testJsonIsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isRemoved());
  }

  /**
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
  }

  /**
   * Test Json {@link Json#lifecyclePhase()}.
   *
   * <p>Method under test: {@link Json#lifecyclePhase()}
   */
  @Test
  @DisplayName("Test Json lifecyclePhase()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LifecyclePhase Json.lifecyclePhase()"})
  void testJsonLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lifecyclePhase());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
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
   * Test Json {@link Json#organisationalUnitId()}.
   *
   * <p>Method under test: {@link Json#organisationalUnitId()}
   */
  @Test
  @DisplayName("Test Json organisationalUnitId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.organisationalUnitId()"})
  void testJsonOrganisationalUnitId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().organisationalUnitId());
  }

  /**
   * Test Json {@link Json#overallRating()}.
   *
   * <p>Method under test: {@link Json#overallRating()}
   */
  @Test
  @DisplayName("Test Json overallRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RagRating Json.overallRating()"})
  void testJsonOverallRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().overallRating());
  }

  /**
   * Test Json {@link Json#parentAssetCode()}.
   *
   * <p>Method under test: {@link Json#parentAssetCode()}
   */
  @Test
  @DisplayName("Test Json parentAssetCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.parentAssetCode()"})
  void testJsonParentAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentAssetCode());
  }

  /**
   * Test Json {@link Json#plannedRetirementDate()}.
   *
   * <p>Method under test: {@link Json#plannedRetirementDate()}
   */
  @Test
  @DisplayName("Test Json plannedRetirementDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.plannedRetirementDate()"})
  void testJsonPlannedRetirementDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().plannedRetirementDate());
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
   * Test Json {@link Json#setIsRemoved(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsRemoved(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsRemoved(boolean)"})
  void testJsonSetIsRemoved() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsRemoved(true);

    // Assert
    assertTrue(json.isRemoved);
    assertTrue(json.isRemovedIsSet);
  }

  /**
   * Test {@link ImmutableApplication#kind()}.
   *
   * <p>Method under test: {@link ImmutableApplication#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableApplication.kind()"})
  void testKind() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertEquals(
        EntityKind.ALL,
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableApplication#parentAssetCode()}.
   *
   * <p>Method under test: {@link ImmutableApplication#parentAssetCode()}
   */
  @Test
  @DisplayName("Test parentAssetCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableApplication.parentAssetCode()"})
  void testParentAssetCode() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertEquals(
        assetCode,
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .parentAssetCode());
  }

  /**
   * Test {@link ImmutableApplication#plannedRetirementDate()}.
   *
   * <p>Method under test: {@link ImmutableApplication#plannedRetirementDate()}
   */
  @Test
  @DisplayName("Test plannedRetirementDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableApplication.plannedRetirementDate()"})
  void testPlannedRetirementDate() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    Optional<LocalDateTime> actualPlannedRetirementDateResult =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(ofResult.atStartOfDay())
            .provenance("Provenance")
            .build()
            .plannedRetirementDate();

    // Assert
    LocalDateTime getResult = actualPlannedRetirementDateResult.get();
    assertEquals("00:00", getResult.toLocalTime().toString());
    LocalDate toLocalDateResult = getResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertTrue(actualPlannedRetirementDateResult.isPresent());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableApplication#provenance()}.
   *
   * <p>Method under test: {@link ImmutableApplication#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableApplication.provenance()"})
  void testProvenance() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertEquals(
        "Provenance",
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableApplication#toString()}.
   *
   * <p>Method under test: {@link ImmutableApplication#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableApplication.toString()"})
  void testToString() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertEquals(
        "Application{id=1, isRemoved=false, name=Name, entityLifecycleStatus=ACTIVE, organisationalUnitId=1,"
            + " assetCode=42, parentAssetCode=42, applicationKind=IN_HOUSE, lifecyclePhase=PRODUCTION, overallRating=R,"
            + " plannedRetirementDate=1970-01-01T00:00, actualRetirementDate=1970-01-01T00:00, commissionDate=1970"
            + "-01-01T00:00, kind=ALL, provenance=Provenance, externalId=Optional[42], businessCriticality=LOW}",
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableApplication#toString()}.
   *
   * <p>Method under test: {@link ImmutableApplication#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableApplication.toString()"})
  void testToString2() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.empty();

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertEquals(
        "Application{id=1, isRemoved=false, name=Name, entityLifecycleStatus=ACTIVE, organisationalUnitId=1,"
            + " parentAssetCode=42, applicationKind=IN_HOUSE, lifecyclePhase=PRODUCTION, overallRating=R, plannedRe"
            + "tirementDate=1970-01-01T00:00, actualRetirementDate=1970-01-01T00:00, commissionDate=1970-01-01T00:00,"
            + " kind=ALL, provenance=Provenance, externalId=Optional.empty, businessCriticality=LOW}",
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableApplication#toString()}.
   *
   * <p>Method under test: {@link ImmutableApplication#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableApplication.toString()"})
  void testToString3() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.empty();

    // Act and Assert
    assertEquals(
        "Application{id=1, isRemoved=false, name=Name, entityLifecycleStatus=ACTIVE, organisationalUnitId=1,"
            + " assetCode=42, applicationKind=IN_HOUSE, lifecyclePhase=PRODUCTION, overallRating=R, plannedRetirementDate"
            + "=1970-01-01T00:00, actualRetirementDate=1970-01-01T00:00, commissionDate=1970-01-01T00:00, kind=ALL,"
            + " provenance=Provenance, externalId=Optional[42], businessCriticality=LOW}",
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableApplication#withActualRetirementDate(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableApplication#withActualRetirementDate(Optional)}
   */
  @Test
  @DisplayName("Test withActualRetirementDate(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplication ImmutableApplication.withActualRetirementDate(Optional)"
  })
  void testWithActualRetirementDateWithOptional() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    Optional<? extends LocalDateTime> optional =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableApplication actualWithActualRetirementDateResult =
        immutableApplication.withActualRetirementDate(optional);

    // Assert
    assertEquals(immutableApplication, actualWithActualRetirementDateResult);
  }

  /**
   * Test {@link ImmutableApplication#withActualRetirementDate(LocalDateTime)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableApplication#withActualRetirementDate(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withActualRetirementDate(LocalDateTime) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplication ImmutableApplication.withActualRetirementDate(LocalDateTime)"
  })
  void testWithActualRetirementDateWithValue() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableApplication actualWithActualRetirementDateResult =
        immutableApplication.withActualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableApplication, actualWithActualRetirementDateResult);
  }

  /**
   * Test {@link ImmutableApplication#withApplicationKind(ApplicationKind)}.
   *
   * <p>Method under test: {@link ImmutableApplication#withApplicationKind(ApplicationKind)}
   */
  @Test
  @DisplayName("Test withApplicationKind(ApplicationKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplication ImmutableApplication.withApplicationKind(ApplicationKind)"
  })
  void testWithApplicationKind() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableApplication actualWithApplicationKindResult =
        immutableApplication.withApplicationKind(ApplicationKind.IN_HOUSE);

    // Assert
    assertSame(immutableApplication, actualWithApplicationKindResult);
  }

  /**
   * Test {@link ImmutableApplication#withApplicationKind(ApplicationKind)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#withApplicationKind(ApplicationKind)}
   */
  @Test
  @DisplayName("Test withApplicationKind(ApplicationKind); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplication ImmutableApplication.withApplicationKind(ApplicationKind)"
  })
  void testWithApplicationKind_thenReturnName() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.INTERNALLY_HOSTED);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    ImmutableApplication actualWithApplicationKindResult =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .withApplicationKind(ApplicationKind.IN_HOUSE);

    // Assert
    assertEquals("Name", actualWithApplicationKindResult.name());
    assertEquals("Provenance", actualWithApplicationKindResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithApplicationKindResult.description());
    assertEquals(1L, actualWithApplicationKindResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualWithApplicationKindResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualWithApplicationKindResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithApplicationKindResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithApplicationKindResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithApplicationKindResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithApplicationKindResult.overallRating());
    assertFalse(actualWithApplicationKindResult.isRemoved());
  }

  /**
   * Test {@link ImmutableApplication#withAssetCode(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableApplication#withAssetCode(Optional)}
   */
  @Test
  @DisplayName("Test withAssetCode(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withAssetCode(Optional)"})
  void testWithAssetCodeWithOptional() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    Optional<? extends ExternalIdValue> optional = Optional.of(ExternalIdValue.of("42"));

    // Act
    ImmutableApplication actualWithAssetCodeResult = immutableApplication.withAssetCode(optional);

    // Assert
    assertEquals(immutableApplication, actualWithAssetCodeResult);
  }

  /**
   * Test {@link ImmutableApplication#withAssetCode(ExternalIdValue)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableApplication#withAssetCode(ExternalIdValue)}
   */
  @Test
  @DisplayName("Test withAssetCode(ExternalIdValue) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withAssetCode(ExternalIdValue)"})
  void testWithAssetCodeWithValue() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableApplication actualWithAssetCodeResult =
        immutableApplication.withAssetCode(ExternalIdValue.of("42"));

    // Assert
    assertEquals(immutableApplication, actualWithAssetCodeResult);
  }

  /**
   * Test {@link ImmutableApplication#withBusinessCriticality(Criticality)}.
   *
   * <p>Method under test: {@link ImmutableApplication#withBusinessCriticality(Criticality)}
   */
  @Test
  @DisplayName("Test withBusinessCriticality(Criticality)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplication ImmutableApplication.withBusinessCriticality(Criticality)"
  })
  void testWithBusinessCriticality() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableApplication actualWithBusinessCriticalityResult =
        immutableApplication.withBusinessCriticality(Criticality.LOW);

    // Assert
    assertSame(immutableApplication, actualWithBusinessCriticalityResult);
  }

  /**
   * Test {@link ImmutableApplication#withBusinessCriticality(Criticality)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#withBusinessCriticality(Criticality)}
   */
  @Test
  @DisplayName("Test withBusinessCriticality(Criticality); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplication ImmutableApplication.withBusinessCriticality(Criticality)"
  })
  void testWithBusinessCriticality_thenReturnName() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.MEDIUM)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    ImmutableApplication actualWithBusinessCriticalityResult =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .withBusinessCriticality(Criticality.LOW);

    // Assert
    assertEquals("Name", actualWithBusinessCriticalityResult.name());
    assertEquals("Provenance", actualWithBusinessCriticalityResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithBusinessCriticalityResult.description());
    assertEquals(1L, actualWithBusinessCriticalityResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualWithBusinessCriticalityResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualWithBusinessCriticalityResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithBusinessCriticalityResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithBusinessCriticalityResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithBusinessCriticalityResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithBusinessCriticalityResult.overallRating());
    assertFalse(actualWithBusinessCriticalityResult.isRemoved());
  }

  /**
   * Test {@link ImmutableApplication#withCommissionDate(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableApplication#withCommissionDate(Optional)}
   */
  @Test
  @DisplayName("Test withCommissionDate(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withCommissionDate(Optional)"})
  void testWithCommissionDateWithOptional() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    Optional<? extends LocalDateTime> optional =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableApplication actualWithCommissionDateResult =
        immutableApplication.withCommissionDate(optional);

    // Assert
    assertEquals(immutableApplication, actualWithCommissionDateResult);
  }

  /**
   * Test {@link ImmutableApplication#withCommissionDate(LocalDateTime)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableApplication#withCommissionDate(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withCommissionDate(LocalDateTime) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withCommissionDate(LocalDateTime)"})
  void testWithCommissionDateWithValue() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableApplication actualWithCommissionDateResult =
        immutableApplication.withCommissionDate(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableApplication, actualWithCommissionDateResult);
  }

  /**
   * Test {@link ImmutableApplication#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableApplication#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableApplication actualWithDescriptionResult = immutableApplication.withDescription("42");

    // Assert
    assertEquals(immutableApplication, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableApplication#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableApplication#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("42")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableApplication actualWithDescriptionResult = immutableApplication.withDescription("42");

    // Assert
    assertSame(immutableApplication, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableApplication#withEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutableApplication#withEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withEntityLifecycleStatus(EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplication ImmutableApplication.withEntityLifecycleStatus(EntityLifecycleStatus)"
  })
  void testWithEntityLifecycleStatus() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableApplication actualWithEntityLifecycleStatusResult =
        immutableApplication.withEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(immutableApplication, actualWithEntityLifecycleStatusResult);
  }

  /**
   * Test {@link ImmutableApplication#withEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplication#withEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withEntityLifecycleStatus(EntityLifecycleStatus); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplication ImmutableApplication.withEntityLifecycleStatus(EntityLifecycleStatus)"
  })
  void testWithEntityLifecycleStatus_thenReturnName() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    ImmutableApplication actualWithEntityLifecycleStatusResult =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .withEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertEquals("Name", actualWithEntityLifecycleStatusResult.name());
    assertEquals("Provenance", actualWithEntityLifecycleStatusResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithEntityLifecycleStatusResult.description());
    assertEquals(1L, actualWithEntityLifecycleStatusResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualWithEntityLifecycleStatusResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualWithEntityLifecycleStatusResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        actualWithEntityLifecycleStatusResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithEntityLifecycleStatusResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithEntityLifecycleStatusResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithEntityLifecycleStatusResult.overallRating());
    assertFalse(actualWithEntityLifecycleStatusResult.isRemoved());
  }

  /**
   * Test {@link ImmutableApplication#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableApplication#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableApplication actualWithIdResult = immutableApplication.withId(optional);

    // Assert
    assertSame(immutableApplication, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableApplication#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withId(Optional)"})
  void testWithIdWithOptional_thenReturnName() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(2L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableApplication actualWithIdResult = immutableApplication.withId(optional);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualWithIdResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithIdResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithIdResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithIdResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithIdResult.overallRating());
    assertFalse(actualWithIdResult.isRemoved());
  }

  /**
   * Test {@link ImmutableApplication#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableApplication#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableApplication actualWithIdResult = immutableApplication.withId(1L);

    // Assert
    assertSame(immutableApplication, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableApplication#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    ImmutableApplication actualWithIdResult =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .withId(42L);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualWithIdResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithIdResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithIdResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithIdResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithIdResult.overallRating());
    assertFalse(actualWithIdResult.isRemoved());
  }

  /**
   * Test {@link ImmutableApplication#withIsRemoved(boolean)}.
   *
   * <p>Method under test: {@link ImmutableApplication#withIsRemoved(boolean)}
   */
  @Test
  @DisplayName("Test withIsRemoved(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withIsRemoved(boolean)"})
  void testWithIsRemoved() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableApplication actualWithIsRemovedResult = immutableApplication.withIsRemoved(false);

    // Assert
    assertSame(immutableApplication, actualWithIsRemovedResult);
  }

  /**
   * Test {@link ImmutableApplication#withIsRemoved(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#withIsRemoved(boolean)}
   */
  @Test
  @DisplayName("Test withIsRemoved(boolean); when 'true'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withIsRemoved(boolean)"})
  void testWithIsRemoved_whenTrue_thenReturnName() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    ImmutableApplication actualWithIsRemovedResult =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .withIsRemoved(true);

    // Assert
    assertEquals("Name", actualWithIsRemovedResult.name());
    assertEquals("Provenance", actualWithIsRemovedResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithIsRemovedResult.description());
    assertEquals(1L, actualWithIsRemovedResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualWithIsRemovedResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualWithIsRemovedResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithIsRemovedResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithIsRemovedResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithIsRemovedResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithIsRemovedResult.overallRating());
    assertTrue(actualWithIsRemovedResult.isRemoved());
  }

  /**
   * Test {@link ImmutableApplication#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableApplication#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableApplication actualWithKindResult = immutableApplication.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableApplication, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableApplication#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withKind(EntityKind)"})
  void testWithKind_thenReturnName() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    ImmutableApplication actualWithKindResult =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(1L, actualWithKindResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualWithKindResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithKindResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithKindResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithKindResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithKindResult.overallRating());
    assertFalse(actualWithKindResult.isRemoved());
  }

  /**
   * Test {@link ImmutableApplication#withLifecyclePhase(LifecyclePhase)}.
   *
   * <p>Method under test: {@link ImmutableApplication#withLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test withLifecyclePhase(LifecyclePhase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplication ImmutableApplication.withLifecyclePhase(LifecyclePhase)"
  })
  void testWithLifecyclePhase() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableApplication actualWithLifecyclePhaseResult =
        immutableApplication.withLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertSame(immutableApplication, actualWithLifecyclePhaseResult);
  }

  /**
   * Test {@link ImmutableApplication#withLifecyclePhase(LifecyclePhase)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#withLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test withLifecyclePhase(LifecyclePhase); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplication ImmutableApplication.withLifecyclePhase(LifecyclePhase)"
  })
  void testWithLifecyclePhase_thenReturnName() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.DEVELOPMENT)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    ImmutableApplication actualWithLifecyclePhaseResult =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .withLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertEquals("Name", actualWithLifecyclePhaseResult.name());
    assertEquals("Provenance", actualWithLifecyclePhaseResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithLifecyclePhaseResult.description());
    assertEquals(1L, actualWithLifecyclePhaseResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualWithLifecyclePhaseResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualWithLifecyclePhaseResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithLifecyclePhaseResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithLifecyclePhaseResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithLifecyclePhaseResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithLifecyclePhaseResult.overallRating());
    assertFalse(actualWithLifecyclePhaseResult.isRemoved());
  }

  /**
   * Test {@link ImmutableApplication#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableApplication#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withName(String)"})
  void testWithName() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("42")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableApplication actualWithNameResult = immutableApplication.withName("42");

    // Assert
    assertSame(immutableApplication, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableApplication#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    ImmutableApplication actualWithNameResult =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1L, actualWithNameResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualWithNameResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithNameResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithNameResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithNameResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithNameResult.overallRating());
    assertFalse(actualWithNameResult.isRemoved());
  }

  /**
   * Test {@link ImmutableApplication#withOrganisationalUnitId(Long)}.
   *
   * <p>Method under test: {@link ImmutableApplication#withOrganisationalUnitId(Long)}
   */
  @Test
  @DisplayName("Test withOrganisationalUnitId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withOrganisationalUnitId(Long)"})
  void testWithOrganisationalUnitId() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableApplication actualWithOrganisationalUnitIdResult =
        immutableApplication.withOrganisationalUnitId(1L);

    // Assert
    assertSame(immutableApplication, actualWithOrganisationalUnitIdResult);
  }

  /**
   * Test {@link ImmutableApplication#withOrganisationalUnitId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#withOrganisationalUnitId(Long)}
   */
  @Test
  @DisplayName("Test withOrganisationalUnitId(Long); when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withOrganisationalUnitId(Long)"})
  void testWithOrganisationalUnitId_whenFortyTwo_thenReturnName() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    ImmutableApplication actualWithOrganisationalUnitIdResult =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .withOrganisationalUnitId(42L);

    // Assert
    assertEquals("Name", actualWithOrganisationalUnitIdResult.name());
    assertEquals("Provenance", actualWithOrganisationalUnitIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithOrganisationalUnitIdResult.description());
    assertEquals(42L, actualWithOrganisationalUnitIdResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualWithOrganisationalUnitIdResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualWithOrganisationalUnitIdResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithOrganisationalUnitIdResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithOrganisationalUnitIdResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithOrganisationalUnitIdResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithOrganisationalUnitIdResult.overallRating());
    assertFalse(actualWithOrganisationalUnitIdResult.isRemoved());
  }

  /**
   * Test {@link ImmutableApplication#withOverallRating(RagRating)}.
   *
   * <p>Method under test: {@link ImmutableApplication#withOverallRating(RagRating)}
   */
  @Test
  @DisplayName("Test withOverallRating(RagRating)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withOverallRating(RagRating)"})
  void testWithOverallRating() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableApplication actualWithOverallRatingResult =
        immutableApplication.withOverallRating(RagRating.R);

    // Assert
    assertSame(immutableApplication, actualWithOverallRatingResult);
  }

  /**
   * Test {@link ImmutableApplication#withOverallRating(RagRating)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#withOverallRating(RagRating)}
   */
  @Test
  @DisplayName("Test withOverallRating(RagRating); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withOverallRating(RagRating)"})
  void testWithOverallRating_thenReturnName() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.A);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    ImmutableApplication actualWithOverallRatingResult =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .withOverallRating(RagRating.R);

    // Assert
    assertEquals("Name", actualWithOverallRatingResult.name());
    assertEquals("Provenance", actualWithOverallRatingResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithOverallRatingResult.description());
    assertEquals(1L, actualWithOverallRatingResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualWithOverallRatingResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualWithOverallRatingResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithOverallRatingResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithOverallRatingResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithOverallRatingResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithOverallRatingResult.overallRating());
    assertFalse(actualWithOverallRatingResult.isRemoved());
  }

  /**
   * Test {@link ImmutableApplication#withParentAssetCode(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableApplication#withParentAssetCode(Optional)}
   */
  @Test
  @DisplayName("Test withParentAssetCode(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withParentAssetCode(Optional)"})
  void testWithParentAssetCodeWithOptional() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    Optional<? extends ExternalIdValue> optional = Optional.of(ExternalIdValue.of("42"));

    // Act
    ImmutableApplication actualWithParentAssetCodeResult =
        immutableApplication.withParentAssetCode(optional);

    // Assert
    assertEquals(immutableApplication, actualWithParentAssetCodeResult);
  }

  /**
   * Test {@link ImmutableApplication#withParentAssetCode(ExternalIdValue)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableApplication#withParentAssetCode(ExternalIdValue)}
   */
  @Test
  @DisplayName("Test withParentAssetCode(ExternalIdValue) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplication ImmutableApplication.withParentAssetCode(ExternalIdValue)"
  })
  void testWithParentAssetCodeWithValue() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableApplication actualWithParentAssetCodeResult =
        immutableApplication.withParentAssetCode(ExternalIdValue.of("42"));

    // Assert
    assertEquals(immutableApplication, actualWithParentAssetCodeResult);
  }

  /**
   * Test {@link ImmutableApplication#withPlannedRetirementDate(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableApplication#withPlannedRetirementDate(Optional)}
   */
  @Test
  @DisplayName("Test withPlannedRetirementDate(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplication ImmutableApplication.withPlannedRetirementDate(Optional)"
  })
  void testWithPlannedRetirementDateWithOptional() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    Optional<? extends LocalDateTime> optional =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableApplication actualWithPlannedRetirementDateResult =
        immutableApplication.withPlannedRetirementDate(optional);

    // Assert
    assertEquals(immutableApplication, actualWithPlannedRetirementDateResult);
  }

  /**
   * Test {@link ImmutableApplication#withPlannedRetirementDate(LocalDateTime)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableApplication#withPlannedRetirementDate(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withPlannedRetirementDate(LocalDateTime) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplication ImmutableApplication.withPlannedRetirementDate(LocalDateTime)"
  })
  void testWithPlannedRetirementDateWithValue() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableApplication actualWithPlannedRetirementDateResult =
        immutableApplication.withPlannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableApplication, actualWithPlannedRetirementDateResult);
  }

  /**
   * Test {@link ImmutableApplication#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableApplication#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("42")
            .build();

    // Act
    ImmutableApplication actualWithProvenanceResult = immutableApplication.withProvenance("42");

    // Assert
    assertSame(immutableApplication, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableApplication#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return provenance is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplication#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return provenance is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplication ImmutableApplication.withProvenance(String)"})
  void testWithProvenance_thenReturnProvenanceIs42() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    ImmutableApplication actualWithProvenanceResult =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(1L, actualWithProvenanceResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualWithProvenanceResult.businessCriticality());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithProvenanceResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithProvenanceResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithProvenanceResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithProvenanceResult.overallRating());
    assertFalse(actualWithProvenanceResult.isRemoved());
  }
}
