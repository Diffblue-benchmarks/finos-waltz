package org.finos.waltz.web.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.web.action.ImmutableAppChangeAction.Builder;
import org.finos.waltz.web.action.ImmutableAppChangeAction.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppChangeActionDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllChanges(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllChanges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChanges(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllChanges(Iterable)"})
  void testBuilderAddAllChanges_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

    // Act
    Builder actualAddAllChangesResult = builderResult.addAllChanges(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllChangesResult);
  }

  /**
   * Test Builder {@link Builder#addChanges(FieldChange)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableFieldChange.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addChanges(FieldChange)}
   */
  @Test
  @DisplayName(
      "Test Builder addChanges(FieldChange) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addChanges(FieldChange)"})
  void testBuilderAddChangesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

    // Act
    Builder actualAddChangesResult = builderResult.addChanges(new ImmutableFieldChange.Json());

    // Assert
    assertSame(builderResult, actualAddChangesResult);
  }

  /**
   * Test Builder {@link Builder#addChanges(FieldChange[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableFieldChange.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addChanges(FieldChange[])}
   */
  @Test
  @DisplayName(
      "Test Builder addChanges(FieldChange[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addChanges(FieldChange[])"})
  void testBuilderAddChangesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

    // Act
    Builder actualAddChangesResult = builderResult.addChanges(new ImmutableFieldChange.Json());

    // Assert
    assertSame(builderResult, actualAddChangesResult);
  }

  /**
   * Test Builder {@link Builder#app(Application)}.
   *
   * <p>Method under test: {@link Builder#app(Application)}
   */
  @Test
  @DisplayName("Test Builder app(Application)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.app(Application)"})
  void testBuilderApp() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

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
    ImmutableApplication app =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualAppResult = builderResult.app(app);

    // Assert
    assertSame(app, builderResult.build().app());
    assertSame(builderResult, actualAppResult);
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
  @MethodsUnderTest({"ImmutableAppChangeAction Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAppChangeAction.builder();
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
    ImmutableApplication app =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    ImmutableAppChangeAction actualImmutableAppChangeAction = actualBuilderResult.app(app).build();

    // Assert
    assertTrue(actualImmutableAppChangeAction.changes().isEmpty());
    assertSame(app, actualImmutableAppChangeAction.app());
  }

  /**
   * Test Builder {@link Builder#changes(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#changes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder changes(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changes(Iterable)"})
  void testBuilderChanges_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

    // Act
    Builder actualChangesResult = builderResult.changes(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualChangesResult);
  }

  /**
   * Test Builder {@link Builder#from(AppChangeAction)}.
   *
   * <p>Method under test: {@link Builder#from(AppChangeAction)}
   */
  @Test
  @DisplayName("Test Builder from(AppChangeAction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppChangeAction)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

    Builder builderResult2 = ImmutableAppChangeAction.builder();

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
    ImmutableAppChangeAction instance =
        builderResult2
            .app(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAppChangeAction actualImmutableAppChangeAction = builderResult.build();
    assertEquals(instance, actualImmutableAppChangeAction);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AppChangeAction)}.
   *
   * <ul>
   *   <li>Then return build changes size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AppChangeAction)}
   */
  @Test
  @DisplayName("Test Builder from(AppChangeAction); then return build changes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppChangeAction)"})
  void testBuilderFrom_thenReturnBuildChangesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

    Builder builderResult2 = ImmutableAppChangeAction.builder();
    builderResult2.addChanges(
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
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

    // Act and Assert
    List<FieldChange> changesResult =
        builderResult
            .from(
                builderResult2
                    .app(
                        overallRatingResult
                            .parentAssetCode(parentAssetCode)
                            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .provenance("Provenance")
                            .build())
                    .build())
            .build()
            .changes();
    assertEquals(1, changesResult.size());
    FieldChange getResult = changesResult.get(0);
    assertTrue(getResult instanceof ImmutableFieldChange);
    assertEquals("Key", getResult.key());
    assertEquals("Name", getResult.name());
    assertTrue(getResult.dirty());
  }

  /**
   * Test {@link ImmutableAppChangeAction#copyOf(AppChangeAction)}.
   *
   * <ul>
   *   <li>Then app return {@link ImmutableApplication}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeAction#copyOf(AppChangeAction)}
   */
  @Test
  @DisplayName("Test copyOf(AppChangeAction); then app return ImmutableApplication")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppChangeAction ImmutableAppChangeAction.copyOf(AppChangeAction)"})
  void testCopyOf_thenAppReturnImmutableApplication() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

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
    ImmutableAppChangeAction instance =
        builderResult
            .app(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    ImmutableAppChangeAction actualCopyOfResult = ImmutableAppChangeAction.copyOf(instance);

    // Assert
    Application appResult = actualCopyOfResult.app();
    assertTrue(appResult instanceof ImmutableApplication);
    assertEquals("Name", appResult.name());
    assertEquals("Provenance", appResult.provenance());
    assertEquals("The characteristics of someone or something", appResult.description());
    assertEquals(1L, appResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, appResult.businessCriticality());
    assertEquals(EntityKind.ALL, appResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, appResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, appResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, appResult.lifecyclePhase());
    assertEquals(RagRating.R, appResult.overallRating());
    assertFalse(appResult.isRemoved());
    assertTrue(actualCopyOfResult.changes().isEmpty());
  }

  /**
   * Test {@link ImmutableAppChangeAction#equals(Object)}, and {@link
   * ImmutableAppChangeAction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppChangeAction#equals(Object)}
   *   <li>{@link ImmutableAppChangeAction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppChangeAction.equals(Object)",
    "int ImmutableAppChangeAction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

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
    ImmutableAppChangeAction immutableAppChangeAction =
        builderResult
            .app(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .build();

    Builder builderResult2 = ImmutableAppChangeAction.builder();

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
    ImmutableAppChangeAction immutableAppChangeAction2 =
        builderResult2
            .app(
                overallRatingResult2
                    .parentAssetCode(parentAssetCode2)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableAppChangeAction, immutableAppChangeAction2);
    assertEquals(immutableAppChangeAction.hashCode(), immutableAppChangeAction2.hashCode());
  }

  /**
   * Test {@link ImmutableAppChangeAction#equals(Object)}, and {@link
   * ImmutableAppChangeAction#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppChangeAction#equals(Object)}
   *   <li>{@link ImmutableAppChangeAction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppChangeAction.equals(Object)",
    "int ImmutableAppChangeAction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

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
    ImmutableAppChangeAction immutableAppChangeAction =
        builderResult
            .app(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableAppChangeAction, immutableAppChangeAction);
    int expectedHashCodeResult = immutableAppChangeAction.hashCode();
    assertEquals(expectedHashCodeResult, immutableAppChangeAction.hashCode());
  }

  /**
   * Test {@link ImmutableAppChangeAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppChangeAction.equals(Object)",
    "int ImmutableAppChangeAction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();
    builderResult.addChanges(
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
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
    ImmutableAppChangeAction immutableAppChangeAction =
        builderResult
            .app(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .build();

    Builder builderResult2 = ImmutableAppChangeAction.builder();

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

    // Act and Assert
    assertNotEquals(
        immutableAppChangeAction,
        builderResult2
            .app(
                overallRatingResult2
                    .parentAssetCode(parentAssetCode2)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAppChangeAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppChangeAction.equals(Object)",
    "int ImmutableAppChangeAction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

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
    ImmutableAppChangeAction immutableAppChangeAction =
        builderResult
            .app(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .build();

    Builder builderResult2 = ImmutableAppChangeAction.builder();

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

    // Act and Assert
    assertNotEquals(
        immutableAppChangeAction,
        builderResult2
            .app(
                overallRatingResult2
                    .parentAssetCode(parentAssetCode2)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAppChangeAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppChangeAction.equals(Object)",
    "int ImmutableAppChangeAction.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

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

    // Act and Assert
    assertNotEquals(
        builderResult
            .app(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAppChangeAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppChangeAction.equals(Object)",
    "int ImmutableAppChangeAction.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

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

    // Act and Assert
    assertNotEquals(
        builderResult
            .app(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .build(),
        "Different type to ImmutableAppChangeAction");
  }

  /**
   * Test {@link ImmutableAppChangeAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return changes Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeAction#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList(); then return changes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppChangeAction ImmutableAppChangeAction.fromJson(Json)"})
  void testFromJson_givenArrayList_thenReturnChangesEmpty() {
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
    json.setApp(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    json.setChanges(new ArrayList<>());

    // Act
    ImmutableAppChangeAction actualFromJsonResult = ImmutableAppChangeAction.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.changes().isEmpty());
    Application expectedAppResult = json.app;
    assertSame(expectedAppResult, actualFromJsonResult.app());
  }

  /**
   * Test {@link ImmutableAppChangeAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return changes is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeAction#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return changes is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppChangeAction ImmutableAppChangeAction.fromJson(Json)"})
  void testFromJson_thenReturnChangesIsArrayList() {
    // Arrange
    ArrayList<FieldChange> changes = new ArrayList<>();
    changes.add(
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build());

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
    json.setApp(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    json.setChanges(changes);

    // Act
    ImmutableAppChangeAction actualFromJsonResult = ImmutableAppChangeAction.fromJson(json);

    // Assert
    assertEquals(changes, actualFromJsonResult.changes());
  }

  /**
   * Test {@link ImmutableAppChangeAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return changes is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeAction#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return changes is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppChangeAction ImmutableAppChangeAction.fromJson(Json)"})
  void testFromJson_thenReturnChangesIsArrayList2() {
    // Arrange
    ArrayList<FieldChange> changes = new ArrayList<>();
    changes.add(
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build());
    changes.add(
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build());

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
    json.setApp(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    json.setChanges(changes);

    // Act
    ImmutableAppChangeAction actualFromJsonResult = ImmutableAppChangeAction.fromJson(json);

    // Assert
    assertEquals(changes, actualFromJsonResult.changes());
  }

  /**
   * Test {@link ImmutableAppChangeAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Changes is {@code null}.
   *   <li>Then return changes Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeAction#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Changes is 'null'; then return changes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppChangeAction ImmutableAppChangeAction.fromJson(Json)"})
  void testFromJson_whenJsonChangesIsNull_thenReturnChangesEmpty() {
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
    json.setApp(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    json.setChanges(null);

    // Act
    ImmutableAppChangeAction actualFromJsonResult = ImmutableAppChangeAction.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.changes().isEmpty());
    Application expectedAppResult = json.app;
    assertSame(expectedAppResult, actualFromJsonResult.app());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppChangeAction#toString()}
   *   <li>{@link ImmutableAppChangeAction#app()}
   *   <li>{@link ImmutableAppChangeAction#changes()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Application ImmutableAppChangeAction.app()",
    "List ImmutableAppChangeAction.changes()",
    "String ImmutableAppChangeAction.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

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
    ImmutableAppChangeAction immutableAppChangeAction =
        builderResult
            .app(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableAppChangeAction.toString();
    Application actualAppResult = immutableAppChangeAction.app();

    // Assert
    assertTrue(actualAppResult instanceof ImmutableApplication);
    assertEquals(
        "AppChangeAction{app=Application{id=1, isRemoved=false, name=Name, entityLifecycleStatus=ACTIVE,"
            + " organisationalUnitId=1, assetCode=42, parentAssetCode=42, applicationKind=IN_HOUSE, lifecyclePhase"
            + "=PRODUCTION, overallRating=R, plannedRetirementDate=1970-01-01T00:00, actualRetirementDate=1970-01-01T00:00,"
            + " commissionDate=1970-01-01T00:00, kind=ALL, provenance=Provenance, externalId=Optional[42],"
            + " businessCriticality=LOW}, changes=[]}",
        actualToStringResult);
    assertTrue(immutableAppChangeAction.changes().isEmpty());
  }

  /**
   * Test Json {@link Json#app()}.
   *
   * <p>Method under test: {@link Json#app()}
   */
  @Test
  @DisplayName("Test Json app()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Application Json.app()"})
  void testJsonApp() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().app());
  }

  /**
   * Test Json {@link Json#changes()}.
   *
   * <p>Method under test: {@link Json#changes()}
   */
  @Test
  @DisplayName("Test Json changes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.changes()"})
  void testJsonChanges() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().changes());
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
    assertNull(actualJson.app);
    assertTrue(actualJson.changes.isEmpty());
  }

  /**
   * Test {@link ImmutableAppChangeAction#withApp(Application)}.
   *
   * <p>Method under test: {@link ImmutableAppChangeAction#withApp(Application)}
   */
  @Test
  @DisplayName("Test withApp(Application)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppChangeAction ImmutableAppChangeAction.withApp(Application)"})
  void testWithApp() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

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
    ImmutableAppChangeAction immutableAppChangeAction =
        builderResult
            .app(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
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
    ImmutableAppChangeAction actualWithAppResult =
        immutableAppChangeAction.withApp(
            overallRatingResult2
                .parentAssetCode(parentAssetCode2)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(immutableAppChangeAction, actualWithAppResult);
  }

  /**
   * Test {@link ImmutableAppChangeAction#withChanges(FieldChange[])} with {@code FieldChange[]}.
   *
   * <p>Method under test: {@link ImmutableAppChangeAction#withChanges(FieldChange[])}
   */
  @Test
  @DisplayName("Test withChanges(FieldChange[]) with 'FieldChange[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppChangeAction ImmutableAppChangeAction.withChanges(FieldChange[])"
  })
  void testWithChangesWithFieldChange() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

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
    ImmutableAppChangeAction immutableAppChangeAction =
        builderResult
            .app(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    ImmutableAppChangeAction actualWithChangesResult =
        immutableAppChangeAction.withChanges(
            ImmutableFieldChange.builder()
                .current("Current")
                .dirty(true)
                .key("Key")
                .name("Name")
                .original("Original")
                .build());

    // Assert
    Application appResult = actualWithChangesResult.app();
    assertTrue(appResult instanceof ImmutableApplication);
    List<FieldChange> changesResult = actualWithChangesResult.changes();
    assertEquals(1, changesResult.size());
    assertTrue(changesResult.get(0) instanceof ImmutableFieldChange);
    assertEquals("Name", appResult.name());
    assertEquals("Provenance", appResult.provenance());
    assertEquals("The characteristics of someone or something", appResult.description());
    assertEquals(1L, appResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, appResult.businessCriticality());
    assertEquals(EntityKind.ALL, appResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, appResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, appResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, appResult.lifecyclePhase());
    assertEquals(RagRating.R, appResult.overallRating());
    assertFalse(appResult.isRemoved());
  }
}
