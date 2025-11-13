package org.finos.waltz.model.custom_environment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.CustomEnvironmentAsset;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.custom_environment.ImmutableCustomEnvironmentUsageInfo.Builder;
import org.finos.waltz.model.custom_environment.ImmutableCustomEnvironmentUsageInfo.Json;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCustomEnvironmentUsageInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#asset(CustomEnvironmentAsset)}.
   *
   * <ul>
   *   <li>When {@link CustomEnvironmentAsset}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#asset(CustomEnvironmentAsset)}
   */
  @Test
  @DisplayName(
      "Test Builder asset(CustomEnvironmentAsset); when CustomEnvironmentAsset; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.asset(CustomEnvironmentAsset)"})
  void testBuilderAsset_whenCustomEnvironmentAsset_thenReturnBuilder() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();

    // Act
    Builder<CustomEnvironmentAsset> actualAssetResult =
        builderResult.asset(mock(CustomEnvironmentAsset.class));

    // Assert
    assertSame(builderResult, actualAssetResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCustomEnvironmentUsageInfo Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder<CustomEnvironmentAsset> actualBuilderResult =
        ImmutableCustomEnvironmentUsageInfo.builder();
    CustomEnvironmentAsset customEnvironmentAsset = mock(CustomEnvironmentAsset.class);
    Builder<CustomEnvironmentAsset> actualAssetResult =
        actualBuilderResult.asset(customEnvironmentAsset);
    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication.Builder overallRatingResult =
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
    ImmutableApplication owningApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    Builder<CustomEnvironmentAsset> actualOwningApplicationResult =
        actualAssetResult.owningApplication(owningApplication);
    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage usage =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();
    ImmutableCustomEnvironmentUsageInfo<CustomEnvironmentAsset>
        actualImmutableCustomEnvironmentUsageInfo =
            actualOwningApplicationResult.usage(usage).build();

    // Assert
    assertSame(owningApplication, actualImmutableCustomEnvironmentUsageInfo.owningApplication());
    assertSame(usage, actualImmutableCustomEnvironmentUsageInfo.usage());
    assertSame(customEnvironmentAsset, actualImmutableCustomEnvironmentUsageInfo.asset());
  }

  /**
   * Test Builder {@link Builder#from(CustomEnvironmentUsageInfo)}.
   *
   * <p>Method under test: {@link Builder#from(CustomEnvironmentUsageInfo)}
   */
  @Test
  @DisplayName("Test Builder from(CustomEnvironmentUsageInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CustomEnvironmentUsageInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();

    Builder<CustomEnvironmentAsset> builderResult2 = ImmutableCustomEnvironmentUsageInfo.builder();

    Builder<CustomEnvironmentAsset> assetResult =
        builderResult2.asset(mock(CustomEnvironmentAsset.class));

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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

    Builder<CustomEnvironmentAsset> owningApplicationResult =
        assetResult.owningApplication(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsageInfo<CustomEnvironmentAsset> instance =
        owningApplicationResult
            .usage(
                customEnvironmentIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    Builder<CustomEnvironmentAsset> actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCustomEnvironmentUsageInfo<CustomEnvironmentAsset>
        actualImmutableCustomEnvironmentUsageInfo = builderResult.build();
    assertEquals(instance, actualImmutableCustomEnvironmentUsageInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#owningApplication(Application)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#owningApplication(Application)}
   */
  @Test
  @DisplayName("Test Builder owningApplication(Application); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.owningApplication(Application)"})
  void testBuilderOwningApplication_thenReturnBuilder() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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
    Builder<CustomEnvironmentAsset> actualOwningApplicationResult =
        builderResult.owningApplication(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    // Assert
    assertSame(builderResult, actualOwningApplicationResult);
  }

  /**
   * Test Builder {@link Builder#usage(CustomEnvironmentUsage)}.
   *
   * <ul>
   *   <li>When {@link ImmutableCustomEnvironmentUsage.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#usage(CustomEnvironmentUsage)}
   */
  @Test
  @DisplayName(
      "Test Builder usage(CustomEnvironmentUsage); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.usage(CustomEnvironmentUsage)"})
  void testBuilderUsage_whenJson_thenReturnBuilder() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();

    // Act
    Builder<CustomEnvironmentAsset> actualUsageResult =
        builderResult.usage(new ImmutableCustomEnvironmentUsage.Json());

    // Assert
    assertSame(builderResult, actualUsageResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsageInfo#copyOf(CustomEnvironmentUsageInfo)}.
   *
   * <ul>
   *   <li>Then usage entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableCustomEnvironmentUsageInfo#copyOf(CustomEnvironmentUsageInfo)}
   */
  @Test
  @DisplayName(
      "Test copyOf(CustomEnvironmentUsageInfo); then usage entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsageInfo ImmutableCustomEnvironmentUsageInfo.copyOf(CustomEnvironmentUsageInfo)"
  })
  void testCopyOf_thenUsageEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();

    Builder<CustomEnvironmentAsset> assetResult =
        builderResult.asset(mock(CustomEnvironmentAsset.class));

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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

    Builder<CustomEnvironmentAsset> owningApplicationResult =
        assetResult.owningApplication(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsageInfo<CustomEnvironmentAsset> instance =
        owningApplicationResult
            .usage(
                customEnvironmentIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    ImmutableCustomEnvironmentUsageInfo<CustomEnvironmentAsset> actualCopyOfResult =
        ImmutableCustomEnvironmentUsageInfo.copyOf(instance);

    // Assert
    CustomEnvironmentUsage usageResult = actualCopyOfResult.usage();
    assertTrue(usageResult.entityReference() instanceof ImmutableEntityReference);
    Application owningApplicationResult2 = actualCopyOfResult.owningApplication();
    assertTrue(owningApplicationResult2 instanceof ImmutableApplication);
    assertTrue(usageResult instanceof ImmutableCustomEnvironmentUsage);
    assertEquals("Jan 1, 2020 8:00am GMT+0100", usageResult.createdBy());
    assertEquals("Name", owningApplicationResult2.name());
    assertEquals("Provenance", usageResult.provenance());
    assertEquals("Provenance", owningApplicationResult2.provenance());
    assertEquals(
        "The characteristics of someone or something", owningApplicationResult2.description());
    assertEquals(1L, owningApplicationResult2.organisationalUnitId().longValue());
    assertEquals(1L, usageResult.customEnvironmentId().longValue());
    assertEquals(Criticality.LOW, owningApplicationResult2.businessCriticality());
    assertEquals(EntityKind.ALL, owningApplicationResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, owningApplicationResult2.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, owningApplicationResult2.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, owningApplicationResult2.lifecyclePhase());
    assertEquals(RagRating.R, owningApplicationResult2.overallRating());
    assertFalse(owningApplicationResult2.isRemoved());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsageInfo#equals(Object)}, and {@link
   * ImmutableCustomEnvironmentUsageInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCustomEnvironmentUsageInfo#equals(Object)}
   *   <li>{@link ImmutableCustomEnvironmentUsageInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironmentUsageInfo.equals(Object)",
    "int ImmutableCustomEnvironmentUsageInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();

    Builder<CustomEnvironmentAsset> assetResult =
        builderResult.asset(mock(CustomEnvironmentAsset.class));

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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

    Builder<CustomEnvironmentAsset> owningApplicationResult =
        assetResult.owningApplication(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsageInfo<CustomEnvironmentAsset>
        immutableCustomEnvironmentUsageInfo =
            owningApplicationResult
                .usage(
                    customEnvironmentIdResult
                        .entityReference(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .id(1L)
                        .provenance("Provenance")
                        .build())
                .build();

    // Act and Assert
    assertEquals(immutableCustomEnvironmentUsageInfo, immutableCustomEnvironmentUsageInfo);
    int expectedHashCodeResult = immutableCustomEnvironmentUsageInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableCustomEnvironmentUsageInfo.hashCode());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironmentUsageInfo.equals(Object)",
    "int ImmutableCustomEnvironmentUsageInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();

    Builder<CustomEnvironmentAsset> assetResult =
        builderResult.asset(mock(CustomEnvironmentAsset.class));

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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

    Builder<CustomEnvironmentAsset> owningApplicationResult =
        assetResult.owningApplication(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsageInfo<CustomEnvironmentAsset>
        immutableCustomEnvironmentUsageInfo =
            owningApplicationResult
                .usage(
                    customEnvironmentIdResult
                        .entityReference(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .id(1L)
                        .provenance("Provenance")
                        .build())
                .build();

    Builder<CustomEnvironmentAsset> builderResult2 = ImmutableCustomEnvironmentUsageInfo.builder();

    Builder<CustomEnvironmentAsset> assetResult2 =
        builderResult2.asset(mock(CustomEnvironmentAsset.class));

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
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

    Builder<CustomEnvironmentAsset> owningApplicationResult2 =
        assetResult2.owningApplication(
            overallRatingResult2
                .parentAssetCode(parentAssetCode2)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult2 =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act and Assert
    assertNotEquals(
        immutableCustomEnvironmentUsageInfo,
        owningApplicationResult2
            .usage(
                customEnvironmentIdResult2
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .provenance("Provenance")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironmentUsageInfo.equals(Object)",
    "int ImmutableCustomEnvironmentUsageInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();

    Builder<CustomEnvironmentAsset> assetResult =
        builderResult.asset(mock(CustomEnvironmentAsset.class));

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.now().atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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

    Builder<CustomEnvironmentAsset> owningApplicationResult =
        assetResult.owningApplication(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsageInfo<CustomEnvironmentAsset>
        immutableCustomEnvironmentUsageInfo =
            owningApplicationResult
                .usage(
                    customEnvironmentIdResult
                        .entityReference(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .id(1L)
                        .provenance("Provenance")
                        .build())
                .build();

    Builder<CustomEnvironmentAsset> builderResult2 = ImmutableCustomEnvironmentUsageInfo.builder();

    Builder<CustomEnvironmentAsset> assetResult2 =
        builderResult2.asset(mock(CustomEnvironmentAsset.class));

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
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

    Builder<CustomEnvironmentAsset> owningApplicationResult2 =
        assetResult2.owningApplication(
            overallRatingResult2
                .parentAssetCode(parentAssetCode2)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult2 =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act and Assert
    assertNotEquals(
        immutableCustomEnvironmentUsageInfo,
        owningApplicationResult2
            .usage(
                customEnvironmentIdResult2
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .provenance("Provenance")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironmentUsageInfo.equals(Object)",
    "int ImmutableCustomEnvironmentUsageInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();

    Builder<CustomEnvironmentAsset> assetResult =
        builderResult.asset(mock(CustomEnvironmentAsset.class));

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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

    Builder<CustomEnvironmentAsset> owningApplicationResult =
        assetResult.owningApplication(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.now().atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsageInfo<CustomEnvironmentAsset>
        immutableCustomEnvironmentUsageInfo =
            owningApplicationResult
                .usage(
                    customEnvironmentIdResult
                        .entityReference(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .id(1L)
                        .provenance("Provenance")
                        .build())
                .build();

    Builder<CustomEnvironmentAsset> builderResult2 = ImmutableCustomEnvironmentUsageInfo.builder();

    Builder<CustomEnvironmentAsset> assetResult2 =
        builderResult2.asset(mock(CustomEnvironmentAsset.class));

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
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

    Builder<CustomEnvironmentAsset> owningApplicationResult2 =
        assetResult2.owningApplication(
            overallRatingResult2
                .parentAssetCode(parentAssetCode2)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult2 =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act and Assert
    assertNotEquals(
        immutableCustomEnvironmentUsageInfo,
        owningApplicationResult2
            .usage(
                customEnvironmentIdResult2
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .provenance("Provenance")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironmentUsageInfo.equals(Object)",
    "int ImmutableCustomEnvironmentUsageInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();

    Builder<CustomEnvironmentAsset> assetResult =
        builderResult.asset(mock(CustomEnvironmentAsset.class));

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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

    Builder<CustomEnvironmentAsset> owningApplicationResult =
        assetResult.owningApplication(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act and Assert
    assertNotEquals(
        owningApplicationResult
            .usage(
                customEnvironmentIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .provenance("Provenance")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironmentUsageInfo.equals(Object)",
    "int ImmutableCustomEnvironmentUsageInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();

    Builder<CustomEnvironmentAsset> assetResult =
        builderResult.asset(mock(CustomEnvironmentAsset.class));

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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

    Builder<CustomEnvironmentAsset> owningApplicationResult =
        assetResult.owningApplication(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act and Assert
    assertNotEquals(
        owningApplicationResult
            .usage(
                customEnvironmentIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .provenance("Provenance")
                    .build())
            .build(),
        "Different type to ImmutableCustomEnvironmentUsageInfo");
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsageInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return asset is {@link Json} (default constructor) {@link Json#asset}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsageInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return asset is Json (default constructor) asset")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsageInfo ImmutableCustomEnvironmentUsageInfo.fromJson(Json)"
  })
  void testFromJson_thenReturnAssetIsJsonAsset() {
    // Arrange
    Json<CustomEnvironmentAsset> json = new Json<>();

    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    json.setUsage(
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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
    json.setOwningApplication(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    json.setAsset(mock(CustomEnvironmentAsset.class));

    // Act
    ImmutableCustomEnvironmentUsageInfo<CustomEnvironmentAsset> actualFromJsonResult =
        ImmutableCustomEnvironmentUsageInfo.fromJson(json);

    // Assert
    CustomEnvironmentAsset expectedAssetResult = json.asset;
    assertSame(expectedAssetResult, actualFromJsonResult.asset());
    Application expectedOwningApplicationResult = json.owningApplication;
    assertSame(expectedOwningApplicationResult, actualFromJsonResult.owningApplication());
    CustomEnvironmentUsage expectedUsageResult = json.usage;
    assertSame(expectedUsageResult, actualFromJsonResult.usage());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCustomEnvironmentUsageInfo#toString()}
   *   <li>{@link ImmutableCustomEnvironmentUsageInfo#asset()}
   *   <li>{@link ImmutableCustomEnvironmentUsageInfo#owningApplication()}
   *   <li>{@link ImmutableCustomEnvironmentUsageInfo#usage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomEnvironmentAsset ImmutableCustomEnvironmentUsageInfo.asset()",
    "Application ImmutableCustomEnvironmentUsageInfo.owningApplication()",
    "String ImmutableCustomEnvironmentUsageInfo.toString()",
    "CustomEnvironmentUsage ImmutableCustomEnvironmentUsageInfo.usage()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();

    Builder<CustomEnvironmentAsset> assetResult =
        builderResult.asset(mock(CustomEnvironmentAsset.class));

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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

    Builder<CustomEnvironmentAsset> owningApplicationResult =
        assetResult.owningApplication(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsageInfo<CustomEnvironmentAsset>
        immutableCustomEnvironmentUsageInfo =
            owningApplicationResult
                .usage(
                    customEnvironmentIdResult
                        .entityReference(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .id(1L)
                        .provenance("Provenance")
                        .build())
                .build();

    // Act
    immutableCustomEnvironmentUsageInfo.toString();
    immutableCustomEnvironmentUsageInfo.asset();
    Application actualOwningApplicationResult =
        immutableCustomEnvironmentUsageInfo.owningApplication();

    // Assert
    assertTrue(actualOwningApplicationResult instanceof ImmutableApplication);
    assertTrue(
        immutableCustomEnvironmentUsageInfo.usage() instanceof ImmutableCustomEnvironmentUsage);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAsset(CustomEnvironmentAsset)}
   *   <li>{@link Json#setOwningApplication(Application)}
   *   <li>{@link Json#setUsage(CustomEnvironmentUsage)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setAsset(CustomEnvironmentAsset)",
    "void Json.setOwningApplication(Application)",
    "void Json.setUsage(CustomEnvironmentUsage)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json<CustomEnvironmentAsset> actualJson = new Json<>();
    actualJson.setAsset(mock(CustomEnvironmentAsset.class));
    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication.Builder overallRatingResult =
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
    actualJson.setOwningApplication(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    actualJson.setUsage(
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build());

    // Assert
    CustomEnvironmentUsage customEnvironmentUsage = actualJson.usage;
    EntityReference entityReferenceResult = customEnvironmentUsage.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    Application application = actualJson.owningApplication;
    assertTrue(application instanceof ImmutableApplication);
    assertTrue(customEnvironmentUsage instanceof ImmutableCustomEnvironmentUsage);
    LocalDateTime createdAtResult = customEnvironmentUsage.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    Optional<String> externalIdResult = application.externalId();
    assertEquals("42", externalIdResult.get());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", customEnvironmentUsage.createdBy());
    assertEquals("Name", application.name());
    assertEquals("Provenance", customEnvironmentUsage.provenance());
    assertEquals("Provenance", application.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("The characteristics of someone or something", application.description());
    assertEquals(1L, application.organisationalUnitId().longValue());
    assertEquals(1L, customEnvironmentUsage.customEnvironmentId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(Criticality.LOW, application.businessCriticality());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityKind.ALL, application.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, application.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, application.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, application.lifecyclePhase());
    assertEquals(RagRating.R, application.overallRating());
    assertFalse(application.isRemoved());
    assertTrue(externalIdResult.isPresent());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#owningApplication()}.
   *
   * <p>Method under test: {@link Json#owningApplication()}
   */
  @Test
  @DisplayName("Test Json owningApplication()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Application Json.owningApplication()"})
  void testJsonOwningApplication() {
    // Arrange
    Json<CustomEnvironmentAsset> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.owningApplication());
  }

  /**
   * Test Json {@link Json#usage()}.
   *
   * <p>Method under test: {@link Json#usage()}
   */
  @Test
  @DisplayName("Test Json usage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomEnvironmentUsage Json.usage()"})
  void testJsonUsage() {
    // Arrange
    Json<CustomEnvironmentAsset> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.usage());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsageInfo#withAsset(CustomEnvironmentAsset)}.
   *
   * <ul>
   *   <li>Then usage entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableCustomEnvironmentUsageInfo#withAsset(CustomEnvironmentAsset)}
   */
  @Test
  @DisplayName(
      "Test withAsset(CustomEnvironmentAsset); then usage entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsageInfo ImmutableCustomEnvironmentUsageInfo.withAsset(CustomEnvironmentAsset)"
  })
  void testWithAsset_thenUsageEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();

    Builder<CustomEnvironmentAsset> assetResult =
        builderResult.asset(mock(CustomEnvironmentAsset.class));

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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

    Builder<CustomEnvironmentAsset> owningApplicationResult =
        assetResult.owningApplication(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    CustomEnvironmentAsset customEnvironmentAsset = mock(CustomEnvironmentAsset.class);

    // Act
    ImmutableCustomEnvironmentUsageInfo<CustomEnvironmentAsset> actualWithAssetResult =
        owningApplicationResult
            .usage(
                customEnvironmentIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .provenance("Provenance")
                    .build())
            .build()
            .withAsset(customEnvironmentAsset);

    // Assert
    CustomEnvironmentUsage usageResult = actualWithAssetResult.usage();
    assertTrue(usageResult.entityReference() instanceof ImmutableEntityReference);
    Application owningApplicationResult2 = actualWithAssetResult.owningApplication();
    assertTrue(owningApplicationResult2 instanceof ImmutableApplication);
    assertTrue(usageResult instanceof ImmutableCustomEnvironmentUsage);
    assertEquals("Jan 1, 2020 8:00am GMT+0100", usageResult.createdBy());
    assertEquals("Name", owningApplicationResult2.name());
    assertEquals("Provenance", usageResult.provenance());
    assertEquals("Provenance", owningApplicationResult2.provenance());
    assertEquals(
        "The characteristics of someone or something", owningApplicationResult2.description());
    assertEquals(1L, owningApplicationResult2.organisationalUnitId().longValue());
    assertEquals(1L, usageResult.customEnvironmentId().longValue());
    assertEquals(Criticality.LOW, owningApplicationResult2.businessCriticality());
    assertEquals(EntityKind.ALL, owningApplicationResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, owningApplicationResult2.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, owningApplicationResult2.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, owningApplicationResult2.lifecyclePhase());
    assertEquals(RagRating.R, owningApplicationResult2.overallRating());
    assertFalse(owningApplicationResult2.isRemoved());
    assertSame(customEnvironmentAsset, actualWithAssetResult.asset());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsageInfo#withOwningApplication(Application)}.
   *
   * <p>Method under test: {@link
   * ImmutableCustomEnvironmentUsageInfo#withOwningApplication(Application)}
   */
  @Test
  @DisplayName("Test withOwningApplication(Application)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsageInfo ImmutableCustomEnvironmentUsageInfo.withOwningApplication(Application)"
  })
  void testWithOwningApplication() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();

    Builder<CustomEnvironmentAsset> assetResult =
        builderResult.asset(mock(CustomEnvironmentAsset.class));

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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

    Builder<CustomEnvironmentAsset> owningApplicationResult =
        assetResult.owningApplication(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsageInfo<CustomEnvironmentAsset>
        immutableCustomEnvironmentUsageInfo =
            owningApplicationResult
                .usage(
                    customEnvironmentIdResult
                        .entityReference(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .id(1L)
                        .provenance("Provenance")
                        .build())
                .build();

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
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

    // Act
    ImmutableCustomEnvironmentUsageInfo<CustomEnvironmentAsset> actualWithOwningApplicationResult =
        immutableCustomEnvironmentUsageInfo.withOwningApplication(
            overallRatingResult2
                .parentAssetCode(parentAssetCode2)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(immutableCustomEnvironmentUsageInfo, actualWithOwningApplicationResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsageInfo#withUsage(CustomEnvironmentUsage)}.
   *
   * <p>Method under test: {@link
   * ImmutableCustomEnvironmentUsageInfo#withUsage(CustomEnvironmentUsage)}
   */
  @Test
  @DisplayName("Test withUsage(CustomEnvironmentUsage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsageInfo ImmutableCustomEnvironmentUsageInfo.withUsage(CustomEnvironmentUsage)"
  })
  void testWithUsage() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();

    Builder<CustomEnvironmentAsset> assetResult =
        builderResult.asset(mock(CustomEnvironmentAsset.class));

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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

    Builder<CustomEnvironmentAsset> owningApplicationResult =
        assetResult.owningApplication(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsageInfo<CustomEnvironmentAsset>
        immutableCustomEnvironmentUsageInfo =
            owningApplicationResult
                .usage(
                    customEnvironmentIdResult
                        .entityReference(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .id(1L)
                        .provenance("Provenance")
                        .build())
                .build();

    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult2 =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act
    ImmutableCustomEnvironmentUsageInfo<CustomEnvironmentAsset> actualWithUsageResult =
        immutableCustomEnvironmentUsageInfo.withUsage(
            customEnvironmentIdResult2
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(immutableCustomEnvironmentUsageInfo, actualWithUsageResult);
  }
}
