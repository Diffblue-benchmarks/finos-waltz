package org.finos.waltz.model.involvement;

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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.involvement.ImmutableApplicationInvolvement.Builder;
import org.finos.waltz.model.involvement.ImmutableApplicationInvolvement.Json;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationInvolvementDiffblueTest {
  /**
   * Test Builder {@link Builder#application(Application)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#application(Application)}
   */
  @Test
  @DisplayName("Test Builder application(Application); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.application(Application)"})
  void testBuilderApplication_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationInvolvement.builder();

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
    Builder actualApplicationResult =
        builderResult.application(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    // Assert
    assertSame(builderResult, actualApplicationResult);
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
  @MethodsUnderTest({"ImmutableApplicationInvolvement Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableApplicationInvolvement.builder();
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
    ImmutableApplication application =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    Builder actualApplicationResult = actualBuilderResult.application(application);
    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableInvolvement involvement =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build();
    ImmutableApplicationInvolvement actualImmutableApplicationInvolvement =
        actualApplicationResult.involvement(involvement).build();

    // Assert
    assertSame(application, actualImmutableApplicationInvolvement.application());
    assertSame(involvement, actualImmutableApplicationInvolvement.involvement());
  }

  /**
   * Test Builder {@link Builder#from(ApplicationInvolvement)}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationInvolvement)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationInvolvement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationInvolvement)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableApplicationInvolvement.builder();

    Builder builderResult2 = ImmutableApplicationInvolvement.builder();

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

    Builder applicationResult =
        builderResult2.application(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableApplicationInvolvement instance =
        applicationResult
            .involvement(
                employeeIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableApplicationInvolvement actualImmutableApplicationInvolvement = builderResult.build();
    assertEquals(instance, actualImmutableApplicationInvolvement);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#involvement(Involvement)}.
   *
   * <ul>
   *   <li>When {@link ImmutableInvolvement.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#involvement(Involvement)}
   */
  @Test
  @DisplayName(
      "Test Builder involvement(Involvement); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.involvement(Involvement)"})
  void testBuilderInvolvement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationInvolvement.builder();

    // Act
    Builder actualInvolvementResult = builderResult.involvement(new ImmutableInvolvement.Json());

    // Assert
    assertSame(builderResult, actualInvolvementResult);
  }

  /**
   * Test {@link ImmutableApplicationInvolvement#copyOf(ApplicationInvolvement)}.
   *
   * <ul>
   *   <li>Then involvement entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationInvolvement#copyOf(ApplicationInvolvement)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ApplicationInvolvement); then involvement entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationInvolvement ImmutableApplicationInvolvement.copyOf(ApplicationInvolvement)"
  })
  void testCopyOf_thenInvolvementEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableApplicationInvolvement.builder();

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

    Builder applicationResult =
        builderResult.application(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableApplicationInvolvement instance =
        applicationResult
            .involvement(
                employeeIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    ImmutableApplicationInvolvement actualCopyOfResult =
        ImmutableApplicationInvolvement.copyOf(instance);

    // Assert
    Involvement involvementResult = actualCopyOfResult.involvement();
    assertTrue(involvementResult.entityReference() instanceof ImmutableEntityReference);
    Application applicationResult2 = actualCopyOfResult.application();
    assertTrue(applicationResult2 instanceof ImmutableApplication);
    assertTrue(involvementResult instanceof ImmutableInvolvement);
    assertEquals("42", involvementResult.employeeId());
    assertEquals("Name", applicationResult2.name());
    assertEquals("Provenance", applicationResult2.provenance());
    assertEquals("Provenance", involvementResult.provenance());
    assertEquals("The characteristics of someone or something", applicationResult2.description());
    assertEquals(1L, applicationResult2.organisationalUnitId().longValue());
    assertEquals(1L, involvementResult.kindId());
    assertEquals(Criticality.LOW, applicationResult2.businessCriticality());
    assertEquals(EntityKind.ALL, applicationResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, applicationResult2.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, applicationResult2.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, applicationResult2.lifecyclePhase());
    assertEquals(RagRating.R, applicationResult2.overallRating());
    assertFalse(applicationResult2.isRemoved());
    assertTrue(involvementResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableApplicationInvolvement#equals(Object)}, and {@link
   * ImmutableApplicationInvolvement#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationInvolvement#equals(Object)}
   *   <li>{@link ImmutableApplicationInvolvement#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationInvolvement.equals(Object)",
    "int ImmutableApplicationInvolvement.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationInvolvement.builder();

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

    Builder applicationResult =
        builderResult.application(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableApplicationInvolvement immutableApplicationInvolvement =
        applicationResult
            .involvement(
                employeeIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    Builder builderResult2 = ImmutableApplicationInvolvement.builder();

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

    Builder applicationResult2 =
        builderResult2.application(
            overallRatingResult2
                .parentAssetCode(parentAssetCode2)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableInvolvement.Builder employeeIdResult2 =
        ImmutableInvolvement.builder().employeeId("42");
    ImmutableApplicationInvolvement immutableApplicationInvolvement2 =
        applicationResult2
            .involvement(
                employeeIdResult2
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableApplicationInvolvement, immutableApplicationInvolvement2);
    assertEquals(
        immutableApplicationInvolvement.hashCode(), immutableApplicationInvolvement2.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationInvolvement#equals(Object)}, and {@link
   * ImmutableApplicationInvolvement#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationInvolvement#equals(Object)}
   *   <li>{@link ImmutableApplicationInvolvement#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationInvolvement.equals(Object)",
    "int ImmutableApplicationInvolvement.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationInvolvement.builder();

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

    Builder applicationResult =
        builderResult.application(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableApplicationInvolvement immutableApplicationInvolvement =
        applicationResult
            .involvement(
                employeeIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableApplicationInvolvement, immutableApplicationInvolvement);
    int expectedHashCodeResult = immutableApplicationInvolvement.hashCode();
    assertEquals(expectedHashCodeResult, immutableApplicationInvolvement.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationInvolvement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationInvolvement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationInvolvement.equals(Object)",
    "int ImmutableApplicationInvolvement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationInvolvement.builder();

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

    Builder applicationResult =
        builderResult.application(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableApplicationInvolvement immutableApplicationInvolvement =
        applicationResult
            .involvement(
                employeeIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    Builder builderResult2 = ImmutableApplicationInvolvement.builder();

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

    Builder applicationResult2 =
        builderResult2.application(
            overallRatingResult2
                .parentAssetCode(parentAssetCode2)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableInvolvement.Builder employeeIdResult2 =
        ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertNotEquals(
        immutableApplicationInvolvement,
        applicationResult2
            .involvement(
                employeeIdResult2
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
                    .provenance("Provenance")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableApplicationInvolvement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationInvolvement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationInvolvement.equals(Object)",
    "int ImmutableApplicationInvolvement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableApplicationInvolvement.builder();

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

    Builder applicationResult =
        builderResult.application(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableInvolvement.Builder employeeIdResult =
        ImmutableInvolvement.builder().employeeId("Name");
    ImmutableApplicationInvolvement immutableApplicationInvolvement =
        applicationResult
            .involvement(
                employeeIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    Builder builderResult2 = ImmutableApplicationInvolvement.builder();

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

    Builder applicationResult2 =
        builderResult2.application(
            overallRatingResult2
                .parentAssetCode(parentAssetCode2)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableInvolvement.Builder employeeIdResult2 =
        ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertNotEquals(
        immutableApplicationInvolvement,
        applicationResult2
            .involvement(
                employeeIdResult2
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
                    .provenance("Provenance")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableApplicationInvolvement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationInvolvement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationInvolvement.equals(Object)",
    "int ImmutableApplicationInvolvement.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationInvolvement.builder();

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

    Builder applicationResult =
        builderResult.application(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertNotEquals(
        applicationResult
            .involvement(
                employeeIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
                    .provenance("Provenance")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableApplicationInvolvement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationInvolvement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationInvolvement.equals(Object)",
    "int ImmutableApplicationInvolvement.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationInvolvement.builder();

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

    Builder applicationResult =
        builderResult.application(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertNotEquals(
        applicationResult
            .involvement(
                employeeIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
                    .provenance("Provenance")
                    .build())
            .build(),
        "Different type to ImmutableApplicationInvolvement");
  }

  /**
   * Test {@link ImmutableApplicationInvolvement#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return application is {@link Json} (default constructor) {@link Json#application}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationInvolvement#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return application is Json (default constructor) application")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationInvolvement ImmutableApplicationInvolvement.fromJson(Json)"
  })
  void testFromJson_thenReturnApplicationIsJsonApplication() {
    // Arrange
    Json json = new Json();

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
    json.setApplication(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    json.setInvolvement(
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build());

    // Act
    ImmutableApplicationInvolvement actualFromJsonResult =
        ImmutableApplicationInvolvement.fromJson(json);

    // Assert
    Application expectedApplicationResult = json.application;
    assertSame(expectedApplicationResult, actualFromJsonResult.application());
    Involvement expectedInvolvementResult = json.involvement;
    assertSame(expectedInvolvementResult, actualFromJsonResult.involvement());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationInvolvement#toString()}
   *   <li>{@link ImmutableApplicationInvolvement#application()}
   *   <li>{@link ImmutableApplicationInvolvement#involvement()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Application ImmutableApplicationInvolvement.application()",
    "Involvement ImmutableApplicationInvolvement.involvement()",
    "String ImmutableApplicationInvolvement.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableApplicationInvolvement.builder();

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

    Builder applicationResult =
        builderResult.application(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableApplicationInvolvement immutableApplicationInvolvement =
        applicationResult
            .involvement(
                employeeIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableApplicationInvolvement.toString();
    Application actualApplicationResult = immutableApplicationInvolvement.application();

    // Assert
    assertTrue(actualApplicationResult instanceof ImmutableApplication);
    assertTrue(immutableApplicationInvolvement.involvement() instanceof ImmutableInvolvement);
    assertEquals(
        "ApplicationInvolvement{application=Application{id=1, isRemoved=false, name=Name, entityLifecycleStatus"
            + "=ACTIVE, organisationalUnitId=1, assetCode=42, parentAssetCode=42, applicationKind=IN_HOUSE,"
            + " lifecyclePhase=PRODUCTION, overallRating=R, plannedRetirementDate=1970-01-01T00:00, actualRetirementDate"
            + "=1970-01-01T00:00, commissionDate=1970-01-01T00:00, kind=ALL, provenance=Provenance, externalId"
            + "=Optional[42], businessCriticality=LOW}, involvement=Involvement{kindId=1, entityReference=EntityReference"
            + "{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, employeeId=42, isReadOnly=true, provenance=Provenance"
            + "}}",
        actualToStringResult);
  }

  /**
   * Test Json {@link Json#application()}.
   *
   * <p>Method under test: {@link Json#application()}
   */
  @Test
  @DisplayName("Test Json application()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Application Json.application()"})
  void testJsonApplication() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().application());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setApplication(Application)}
   *   <li>{@link Json#setInvolvement(Involvement)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setApplication(Application)",
    "void Json.setInvolvement(Involvement)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
    actualJson.setApplication(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    actualJson.setInvolvement(
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build());

    // Assert
    Involvement involvement = actualJson.involvement;
    EntityReference entityReferenceResult = involvement.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    Application application = actualJson.application;
    assertTrue(application instanceof ImmutableApplication);
    assertTrue(involvement instanceof ImmutableInvolvement);
    Optional<String> externalIdResult = application.externalId();
    assertEquals("42", externalIdResult.get());
    assertEquals("42", involvement.employeeId());
    assertEquals("Name", application.name());
    assertEquals("Provenance", application.provenance());
    assertEquals("Provenance", involvement.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("The characteristics of someone or something", application.description());
    assertEquals(1L, application.organisationalUnitId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, involvement.kindId());
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
    assertTrue(involvement.isReadOnly());
  }

  /**
   * Test Json {@link Json#involvement()}.
   *
   * <p>Method under test: {@link Json#involvement()}
   */
  @Test
  @DisplayName("Test Json involvement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Involvement Json.involvement()"})
  void testJsonInvolvement() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().involvement());
  }

  /**
   * Test {@link ImmutableApplicationInvolvement#withApplication(Application)}.
   *
   * <p>Method under test: {@link ImmutableApplicationInvolvement#withApplication(Application)}
   */
  @Test
  @DisplayName("Test withApplication(Application)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationInvolvement ImmutableApplicationInvolvement.withApplication(Application)"
  })
  void testWithApplication() {
    // Arrange
    Builder builderResult = ImmutableApplicationInvolvement.builder();

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

    Builder applicationResult =
        builderResult.application(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableApplicationInvolvement immutableApplicationInvolvement =
        applicationResult
            .involvement(
                employeeIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
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
    ImmutableApplicationInvolvement actualWithApplicationResult =
        immutableApplicationInvolvement.withApplication(
            overallRatingResult2
                .parentAssetCode(parentAssetCode2)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(immutableApplicationInvolvement, actualWithApplicationResult);
  }

  /**
   * Test {@link ImmutableApplicationInvolvement#withInvolvement(Involvement)}.
   *
   * <p>Method under test: {@link ImmutableApplicationInvolvement#withInvolvement(Involvement)}
   */
  @Test
  @DisplayName("Test withInvolvement(Involvement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationInvolvement ImmutableApplicationInvolvement.withInvolvement(Involvement)"
  })
  void testWithInvolvement() {
    // Arrange
    Builder builderResult = ImmutableApplicationInvolvement.builder();

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

    Builder applicationResult =
        builderResult.application(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableApplicationInvolvement immutableApplicationInvolvement =
        applicationResult
            .involvement(
                employeeIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    ImmutableInvolvement.Builder employeeIdResult2 =
        ImmutableInvolvement.builder().employeeId("42");

    // Act
    ImmutableApplicationInvolvement actualWithInvolvementResult =
        immutableApplicationInvolvement.withInvolvement(
            employeeIdResult2
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .kindId(1L)
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(immutableApplicationInvolvement, actualWithInvolvementResult);
  }
}
