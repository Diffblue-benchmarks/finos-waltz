package org.finos.waltz.model.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Severity;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangeCommand.Builder;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangePreview.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTaxonomyChangePreviewDiffblueTest {
  /**
   * Test Builder {@link ImmutableTaxonomyChangePreview.Builder#addAllImpacts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangePreview.Builder#addAllImpacts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllImpacts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview.Builder ImmutableTaxonomyChangePreview.Builder.addAllImpacts(Iterable)"
  })
  void testBuilderAddAllImpacts_whenArrayList_thenReturnBuilder() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    // Act
    ImmutableTaxonomyChangePreview.Builder actualAddAllImpactsResult =
        builderResult.addAllImpacts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllImpactsResult);
  }

  /**
   * Test Builder {@link ImmutableTaxonomyChangePreview.Builder#addImpacts(TaxonomyChangeImpact)}
   * with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableTaxonomyChangeImpact.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableTaxonomyChangePreview.Builder#addImpacts(TaxonomyChangeImpact)}
   */
  @Test
  @DisplayName(
      "Test Builder addImpacts(TaxonomyChangeImpact) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview.Builder ImmutableTaxonomyChangePreview.Builder.addImpacts(TaxonomyChangeImpact)"
  })
  void testBuilderAddImpactsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    // Act
    ImmutableTaxonomyChangePreview.Builder actualAddImpactsResult =
        builderResult.addImpacts(new ImmutableTaxonomyChangeImpact.Json());

    // Assert
    assertSame(builderResult, actualAddImpactsResult);
  }

  /**
   * Test Builder {@link ImmutableTaxonomyChangePreview.Builder#addImpacts(TaxonomyChangeImpact[])}
   * with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableTaxonomyChangeImpact.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableTaxonomyChangePreview.Builder#addImpacts(TaxonomyChangeImpact[])}
   */
  @Test
  @DisplayName(
      "Test Builder addImpacts(TaxonomyChangeImpact[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview.Builder ImmutableTaxonomyChangePreview.Builder.addImpacts(TaxonomyChangeImpact[])"
  })
  void testBuilderAddImpactsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    // Act
    ImmutableTaxonomyChangePreview.Builder actualAddImpactsResult =
        builderResult.addImpacts(new ImmutableTaxonomyChangeImpact.Json());

    // Assert
    assertSame(builderResult, actualAddImpactsResult);
  }

  /**
   * Test Builder {@link ImmutableTaxonomyChangePreview.Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTaxonomyChangePreview.Builder#build()}
   *   <li>{@link ImmutableTaxonomyChangePreview.Builder#errorMessage(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview ImmutableTaxonomyChangePreview.Builder.build()",
    "ImmutableTaxonomyChangePreview.Builder ImmutableTaxonomyChangePreview.Builder.errorMessage(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableTaxonomyChangePreview.Builder actualBuilderResult =
        ImmutableTaxonomyChangePreview.builder();
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand command =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();
    ImmutableTaxonomyChangePreview actualImmutableTaxonomyChangePreview =
        actualBuilderResult.command(command).errorMessage("An error occurred").build();

    // Assert
    assertEquals("An error occurred", actualImmutableTaxonomyChangePreview.errorMessage());
    assertTrue(actualImmutableTaxonomyChangePreview.impacts().isEmpty());
    assertSame(command, actualImmutableTaxonomyChangePreview.command());
  }

  /**
   * Test Builder {@link ImmutableTaxonomyChangePreview.Builder#command(TaxonomyChangeCommand)}.
   *
   * <ul>
   *   <li>When {@link ImmutableTaxonomyChangeCommand.Json} (default constructor).
   *   <li>Then builder build errorMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableTaxonomyChangePreview.Builder#command(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder command(TaxonomyChangeCommand); when Json (default constructor); then builder build errorMessage is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview.Builder ImmutableTaxonomyChangePreview.Builder.command(TaxonomyChangeCommand)"
  })
  void testBuilderCommand_whenJson_thenBuilderBuildErrorMessageIsNull() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();
    ImmutableTaxonomyChangeCommand.Json command = new ImmutableTaxonomyChangeCommand.Json();

    // Act
    ImmutableTaxonomyChangePreview.Builder actualCommandResult = builderResult.command(command);

    // Assert
    ImmutableTaxonomyChangePreview immutableTaxonomyChangePreview = builderResult.build();
    assertNull(immutableTaxonomyChangePreview.errorMessage());
    assertSame(command, immutableTaxonomyChangePreview.command());
    assertSame(builderResult, actualCommandResult);
  }

  /**
   * Test Builder {@link ImmutableTaxonomyChangePreview.Builder#from(TaxonomyChangePreview)}.
   *
   * <p>Method under test: {@link
   * ImmutableTaxonomyChangePreview.Builder#from(TaxonomyChangePreview)}
   */
  @Test
  @DisplayName("Test Builder from(TaxonomyChangePreview)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview.Builder ImmutableTaxonomyChangePreview.Builder.from(TaxonomyChangePreview)"
  })
  void testBuilderFrom() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    ImmutableTaxonomyChangePreview.Builder builderResult2 =
        ImmutableTaxonomyChangePreview.builder();

    Builder builderResult3 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult3
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangePreview instance =
        builderResult2
            .command(
                paramsResult
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage("An error occurred")
            .build();

    // Act and Assert
    ImmutableTaxonomyChangePreview actualImmutableTaxonomyChangePreview =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableTaxonomyChangePreview);
    ImmutableTaxonomyChangePreview actualImmutableTaxonomyChangePreview2 = builderResult.build();
    assertEquals(instance, actualImmutableTaxonomyChangePreview2);
  }

  /**
   * Test Builder {@link ImmutableTaxonomyChangePreview.Builder#from(TaxonomyChangePreview)}.
   *
   * <p>Method under test: {@link
   * ImmutableTaxonomyChangePreview.Builder#from(TaxonomyChangePreview)}
   */
  @Test
  @DisplayName("Test Builder from(TaxonomyChangePreview)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview.Builder ImmutableTaxonomyChangePreview.Builder.from(TaxonomyChangePreview)"
  })
  void testBuilderFrom2() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    ImmutableTaxonomyChangePreview.Builder builderResult2 =
        ImmutableTaxonomyChangePreview.builder();

    Builder builderResult3 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult3
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangePreview instance =
        builderResult2
            .command(
                paramsResult
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage(null)
            .build();

    // Act and Assert
    ImmutableTaxonomyChangePreview actualImmutableTaxonomyChangePreview =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableTaxonomyChangePreview);
    ImmutableTaxonomyChangePreview actualImmutableTaxonomyChangePreview2 = builderResult.build();
    assertEquals(instance, actualImmutableTaxonomyChangePreview2);
  }

  /**
   * Test Builder {@link ImmutableTaxonomyChangePreview.Builder#from(TaxonomyChangePreview)}.
   *
   * <ul>
   *   <li>Then return build impacts size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableTaxonomyChangePreview.Builder#from(TaxonomyChangePreview)}
   */
  @Test
  @DisplayName("Test Builder from(TaxonomyChangePreview); then return build impacts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview.Builder ImmutableTaxonomyChangePreview.Builder.from(TaxonomyChangePreview)"
  })
  void testBuilderFrom_thenReturnBuildImpactsSizeIsOne() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    ImmutableTaxonomyChangePreview.Builder builderResult2 =
        ImmutableTaxonomyChangePreview.builder();
    builderResult2.addImpacts(
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build());

    Builder builderResult3 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult3
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act and Assert
    List<TaxonomyChangeImpact> impactsResult =
        builderResult
            .from(
                builderResult2
                    .command(
                        paramsResult
                            .primaryReference(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .status(TaxonomyChangeLifecycleStatus.DRAFT)
                            .build())
                    .errorMessage("An error occurred")
                    .build())
            .build()
            .impacts();
    assertEquals(1, impactsResult.size());
    TaxonomyChangeImpact getResult = impactsResult.get(0);
    assertTrue(getResult instanceof ImmutableTaxonomyChangeImpact);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(3, getResult.impactCount());
    assertEquals(Severity.INFORMATION, getResult.severity());
  }

  /**
   * Test Builder {@link ImmutableTaxonomyChangePreview.Builder#impacts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangePreview.Builder#impacts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder impacts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview.Builder ImmutableTaxonomyChangePreview.Builder.impacts(Iterable)"
  })
  void testBuilderImpacts_whenArrayList_thenReturnBuilder() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    // Act
    ImmutableTaxonomyChangePreview.Builder actualImpactsResult =
        builderResult.impacts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualImpactsResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangePreview#copyOf(TaxonomyChangePreview)}.
   *
   * <ul>
   *   <li>Then command changeDomain return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangePreview#copyOf(TaxonomyChangePreview)}
   */
  @Test
  @DisplayName(
      "Test copyOf(TaxonomyChangePreview); then command changeDomain return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview ImmutableTaxonomyChangePreview.copyOf(TaxonomyChangePreview)"
  })
  void testCopyOf_thenCommandChangeDomainReturnImmutableEntityReference() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangePreview instance =
        builderResult
            .command(
                paramsResult
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage("An error occurred")
            .build();

    // Act
    ImmutableTaxonomyChangePreview actualCopyOfResult =
        ImmutableTaxonomyChangePreview.copyOf(instance);

    // Assert
    TaxonomyChangeCommand commandResult = actualCopyOfResult.command();
    EntityReference changeDomainResult = commandResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = commandResult.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertTrue(commandResult instanceof ImmutableTaxonomyChangeCommand);
    assertEquals("2020-03-01", commandResult.lastUpdatedBy());
    assertEquals("An error occurred", actualCopyOfResult.errorMessage());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", commandResult.createdBy());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, commandResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, commandResult.changeType());
    assertTrue(actualCopyOfResult.impacts().isEmpty());
    assertTrue(commandResult.params().isEmpty());
    assertEquals(changeDomainResult, primaryReferenceResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangePreview#equals(Object)}, and {@link
   * ImmutableTaxonomyChangePreview#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTaxonomyChangePreview#equals(Object)}
   *   <li>{@link ImmutableTaxonomyChangePreview#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangePreview.equals(Object)",
    "int ImmutableTaxonomyChangePreview.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangePreview immutableTaxonomyChangePreview =
        builderResult
            .command(
                paramsResult
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage("An error occurred")
            .build();

    ImmutableTaxonomyChangePreview.Builder builderResult3 =
        ImmutableTaxonomyChangePreview.builder();

    Builder builderResult4 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult2 =
        builderResult4
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult2 = lastUpdatedByResult2.params(new HashMap<>());
    ImmutableTaxonomyChangePreview immutableTaxonomyChangePreview2 =
        builderResult3
            .command(
                paramsResult2
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage("An error occurred")
            .build();

    // Act and Assert
    assertEquals(immutableTaxonomyChangePreview, immutableTaxonomyChangePreview2);
    assertEquals(
        immutableTaxonomyChangePreview.hashCode(), immutableTaxonomyChangePreview2.hashCode());
  }

  /**
   * Test {@link ImmutableTaxonomyChangePreview#equals(Object)}, and {@link
   * ImmutableTaxonomyChangePreview#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTaxonomyChangePreview#equals(Object)}
   *   <li>{@link ImmutableTaxonomyChangePreview#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangePreview.equals(Object)",
    "int ImmutableTaxonomyChangePreview.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangePreview immutableTaxonomyChangePreview =
        builderResult
            .command(
                paramsResult
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage("An error occurred")
            .build();

    // Act and Assert
    assertEquals(immutableTaxonomyChangePreview, immutableTaxonomyChangePreview);
    int expectedHashCodeResult = immutableTaxonomyChangePreview.hashCode();
    assertEquals(expectedHashCodeResult, immutableTaxonomyChangePreview.hashCode());
  }

  /**
   * Test {@link ImmutableTaxonomyChangePreview#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangePreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangePreview.equals(Object)",
    "int ImmutableTaxonomyChangePreview.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();
    builderResult.addImpacts(
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build());

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangePreview immutableTaxonomyChangePreview =
        builderResult
            .command(
                paramsResult
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage("An error occurred")
            .build();

    ImmutableTaxonomyChangePreview.Builder builderResult3 =
        ImmutableTaxonomyChangePreview.builder();

    Builder builderResult4 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult2 =
        builderResult4
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult2 = lastUpdatedByResult2.params(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        immutableTaxonomyChangePreview,
        builderResult3
            .command(
                paramsResult2
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage("An error occurred")
            .build());
  }

  /**
   * Test {@link ImmutableTaxonomyChangePreview#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangePreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangePreview.equals(Object)",
    "int ImmutableTaxonomyChangePreview.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangePreview immutableTaxonomyChangePreview =
        builderResult
            .command(
                paramsResult
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage("An error occurred")
            .build();

    ImmutableTaxonomyChangePreview.Builder builderResult3 =
        ImmutableTaxonomyChangePreview.builder();

    Builder builderResult4 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult2 =
        builderResult4
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult2 = lastUpdatedByResult2.params(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        immutableTaxonomyChangePreview,
        builderResult3
            .command(
                paramsResult2
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage("An error occurred")
            .build());
  }

  /**
   * Test {@link ImmutableTaxonomyChangePreview#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangePreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangePreview.equals(Object)",
    "int ImmutableTaxonomyChangePreview.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangePreview immutableTaxonomyChangePreview =
        builderResult
            .command(
                paramsResult
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage("Jan 1, 2020 8:00am GMT+0100")
            .build();

    ImmutableTaxonomyChangePreview.Builder builderResult3 =
        ImmutableTaxonomyChangePreview.builder();

    Builder builderResult4 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult2 =
        builderResult4
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult2 = lastUpdatedByResult2.params(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        immutableTaxonomyChangePreview,
        builderResult3
            .command(
                paramsResult2
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage("An error occurred")
            .build());
  }

  /**
   * Test {@link ImmutableTaxonomyChangePreview#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangePreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangePreview.equals(Object)",
    "int ImmutableTaxonomyChangePreview.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        builderResult
            .command(
                paramsResult
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage("An error occurred")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableTaxonomyChangePreview#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangePreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangePreview.equals(Object)",
    "int ImmutableTaxonomyChangePreview.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        builderResult
            .command(
                paramsResult
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage("An error occurred")
            .build(),
        "Different type to ImmutableTaxonomyChangePreview");
  }

  /**
   * Test {@link ImmutableTaxonomyChangePreview#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableTaxonomyChangeImpact.Json}
   *       (default constructor).
   *   <li>Then return impacts size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangePreview#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then return impacts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview ImmutableTaxonomyChangePreview.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddJson_thenReturnImpactsSizeIsOne() {
    // Arrange
    ArrayList<TaxonomyChangeImpact> impacts = new ArrayList<>();
    ImmutableTaxonomyChangeImpact.Json json = new ImmutableTaxonomyChangeImpact.Json();
    impacts.add(json);

    Json json2 = new Json();
    json2.setCommand(new ImmutableTaxonomyChangeCommand.Json());
    json2.setImpacts(impacts);
    json2.setErrorMessage(null);

    // Act
    ImmutableTaxonomyChangePreview actualFromJsonResult =
        ImmutableTaxonomyChangePreview.fromJson(json2);

    // Assert
    List<TaxonomyChangeImpact> impactsResult = actualFromJsonResult.impacts();
    assertEquals(1, impactsResult.size());
    assertSame(json, impactsResult.get(0));
  }

  /**
   * Test {@link ImmutableTaxonomyChangePreview#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return errorMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangePreview#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList(); then return errorMessage is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview ImmutableTaxonomyChangePreview.fromJson(Json)"
  })
  void testFromJson_givenArrayList_thenReturnErrorMessageIsNull() {
    // Arrange
    Json json = new Json();
    ImmutableTaxonomyChangeCommand.Json command = new ImmutableTaxonomyChangeCommand.Json();
    json.setCommand(command);
    json.setImpacts(new ArrayList<>());
    json.setErrorMessage(null);

    // Act
    ImmutableTaxonomyChangePreview actualFromJsonResult =
        ImmutableTaxonomyChangePreview.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.errorMessage());
    assertTrue(actualFromJsonResult.impacts().isEmpty());
    assertSame(command, actualFromJsonResult.command());
  }

  /**
   * Test {@link ImmutableTaxonomyChangePreview#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) ErrorMessage is {@code Json}.
   *   <li>Then return errorMessage is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangePreview#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) ErrorMessage is 'Json'; then return errorMessage is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview ImmutableTaxonomyChangePreview.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonErrorMessageIsJson_thenReturnErrorMessageIsJson() {
    // Arrange
    Json json = new Json();
    ImmutableTaxonomyChangeCommand.Json command = new ImmutableTaxonomyChangeCommand.Json();
    json.setCommand(command);
    json.setImpacts(null);
    json.setErrorMessage("Json");

    // Act
    ImmutableTaxonomyChangePreview actualFromJsonResult =
        ImmutableTaxonomyChangePreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.errorMessage());
    assertTrue(actualFromJsonResult.impacts().isEmpty());
    assertSame(command, actualFromJsonResult.command());
  }

  /**
   * Test {@link ImmutableTaxonomyChangePreview#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ImmutableTaxonomyChangeCommand.Json} (default constructor).
   *   <li>When {@link Json} (default constructor) Impacts is {@code null}.
   *   <li>Then return errorMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangePreview#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given Json (default constructor); when Json (default constructor) Impacts is 'null'; then return errorMessage is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview ImmutableTaxonomyChangePreview.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonImpactsIsNull_thenReturnErrorMessageIsNull() {
    // Arrange
    Json json = new Json();
    ImmutableTaxonomyChangeCommand.Json command = new ImmutableTaxonomyChangeCommand.Json();
    json.setCommand(command);
    json.setImpacts(null);
    json.setErrorMessage(null);

    // Act
    ImmutableTaxonomyChangePreview actualFromJsonResult =
        ImmutableTaxonomyChangePreview.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.errorMessage());
    assertTrue(actualFromJsonResult.impacts().isEmpty());
    assertSame(command, actualFromJsonResult.command());
  }

  /**
   * Test {@link ImmutableTaxonomyChangePreview#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return impacts size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangePreview#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return impacts size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview ImmutableTaxonomyChangePreview.fromJson(Json)"
  })
  void testFromJson_thenReturnImpactsSizeIsTwo() {
    // Arrange
    ArrayList<TaxonomyChangeImpact> impacts = new ArrayList<>();
    impacts.add(
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build());
    ImmutableTaxonomyChangeImpact.Json json = new ImmutableTaxonomyChangeImpact.Json();
    impacts.add(json);

    Json json2 = new Json();
    json2.setCommand(new ImmutableTaxonomyChangeCommand.Json());
    json2.setImpacts(impacts);
    json2.setErrorMessage(null);

    // Act
    ImmutableTaxonomyChangePreview actualFromJsonResult =
        ImmutableTaxonomyChangePreview.fromJson(json2);

    // Assert
    List<TaxonomyChangeImpact> impactsResult = actualFromJsonResult.impacts();
    assertEquals(2, impactsResult.size());
    TaxonomyChangeImpact getResult = impactsResult.get(0);
    assertTrue(getResult instanceof ImmutableTaxonomyChangeImpact);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(3, getResult.impactCount());
    assertEquals(Severity.INFORMATION, getResult.severity());
    assertSame(json, impactsResult.get(1));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTaxonomyChangePreview#toString()}
   *   <li>{@link ImmutableTaxonomyChangePreview#command()}
   *   <li>{@link ImmutableTaxonomyChangePreview#errorMessage()}
   *   <li>{@link ImmutableTaxonomyChangePreview#impacts()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TaxonomyChangeCommand ImmutableTaxonomyChangePreview.command()",
    "String ImmutableTaxonomyChangePreview.errorMessage()",
    "List ImmutableTaxonomyChangePreview.impacts()",
    "String ImmutableTaxonomyChangePreview.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangePreview immutableTaxonomyChangePreview =
        builderResult
            .command(
                paramsResult
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage("An error occurred")
            .build();

    // Act
    String actualToStringResult = immutableTaxonomyChangePreview.toString();
    TaxonomyChangeCommand actualCommandResult = immutableTaxonomyChangePreview.command();
    String actualErrorMessageResult = immutableTaxonomyChangePreview.errorMessage();

    // Assert
    assertTrue(actualCommandResult instanceof ImmutableTaxonomyChangeCommand);
    assertEquals("An error occurred", actualErrorMessageResult);
    assertEquals(
        "TaxonomyChangePreview{command=TaxonomyChangeCommand{id=1, createdAt=1970-01-01T00:00, createdBy=Jan"
            + " 1, 2020 8:00am GMT+0100, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, changeType=ADD_PEER,"
            + " status=DRAFT, changeDomain=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, primaryReference"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, params={}}, impacts=[], errorMessage=An"
            + " error occurred}",
        actualToStringResult);
    assertTrue(immutableTaxonomyChangePreview.impacts().isEmpty());
  }

  /**
   * Test Json {@link Json#command()}.
   *
   * <p>Method under test: {@link Json#command()}
   */
  @Test
  @DisplayName("Test Json command()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxonomyChangeCommand Json.command()"})
  void testJsonCommand() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().command());
  }

  /**
   * Test Json {@link Json#errorMessage()}.
   *
   * <p>Method under test: {@link Json#errorMessage()}
   */
  @Test
  @DisplayName("Test Json errorMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.errorMessage()"})
  void testJsonErrorMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().errorMessage());
  }

  /**
   * Test Json {@link Json#impacts()}.
   *
   * <p>Method under test: {@link Json#impacts()}
   */
  @Test
  @DisplayName("Test Json impacts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.impacts()"})
  void testJsonImpacts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().impacts());
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
    assertNull(actualJson.errorMessage);
    assertNull(actualJson.command);
    assertTrue(actualJson.impacts.isEmpty());
  }

  /**
   * Test {@link ImmutableTaxonomyChangePreview#withCommand(TaxonomyChangeCommand)}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangePreview#withCommand(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test withCommand(TaxonomyChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview ImmutableTaxonomyChangePreview.withCommand(TaxonomyChangeCommand)"
  })
  void testWithCommand() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangePreview immutableTaxonomyChangePreview =
        builderResult
            .command(
                paramsResult
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage("An error occurred")
            .build();

    Builder builderResult3 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult2 =
        builderResult3
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult2 = lastUpdatedByResult2.params(new HashMap<>());

    // Act
    ImmutableTaxonomyChangePreview actualWithCommandResult =
        immutableTaxonomyChangePreview.withCommand(
            paramsResult2
                .primaryReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .status(TaxonomyChangeLifecycleStatus.DRAFT)
                .build());

    // Assert
    assertEquals(immutableTaxonomyChangePreview, actualWithCommandResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangePreview#withErrorMessage(String)}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangePreview#withErrorMessage(String)}
   */
  @Test
  @DisplayName("Test withErrorMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview ImmutableTaxonomyChangePreview.withErrorMessage(String)"
  })
  void testWithErrorMessage() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangePreview immutableTaxonomyChangePreview =
        builderResult
            .command(
                paramsResult
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage("42")
            .build();

    // Act
    ImmutableTaxonomyChangePreview actualWithErrorMessageResult =
        immutableTaxonomyChangePreview.withErrorMessage("42");

    // Assert
    assertSame(immutableTaxonomyChangePreview, actualWithErrorMessageResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangePreview#withErrorMessage(String)}.
   *
   * <ul>
   *   <li>Then command changeDomain return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangePreview#withErrorMessage(String)}
   */
  @Test
  @DisplayName(
      "Test withErrorMessage(String); then command changeDomain return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview ImmutableTaxonomyChangePreview.withErrorMessage(String)"
  })
  void testWithErrorMessage_thenCommandChangeDomainReturnImmutableEntityReference() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act
    ImmutableTaxonomyChangePreview actualWithErrorMessageResult =
        builderResult
            .command(
                paramsResult
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage("An error occurred")
            .build()
            .withErrorMessage("42");

    // Assert
    TaxonomyChangeCommand commandResult = actualWithErrorMessageResult.command();
    EntityReference changeDomainResult = commandResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = commandResult.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertTrue(commandResult instanceof ImmutableTaxonomyChangeCommand);
    assertEquals("2020-03-01", commandResult.lastUpdatedBy());
    assertEquals("42", actualWithErrorMessageResult.errorMessage());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", commandResult.createdBy());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, commandResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, commandResult.changeType());
    assertTrue(actualWithErrorMessageResult.impacts().isEmpty());
    assertTrue(commandResult.params().isEmpty());
    assertEquals(changeDomainResult, primaryReferenceResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangePreview#withImpacts(TaxonomyChangeImpact[])} with {@code
   * TaxonomyChangeImpact[]}.
   *
   * <p>Method under test: {@link
   * ImmutableTaxonomyChangePreview#withImpacts(TaxonomyChangeImpact[])}
   */
  @Test
  @DisplayName("Test withImpacts(TaxonomyChangeImpact[]) with 'TaxonomyChangeImpact[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangePreview ImmutableTaxonomyChangePreview.withImpacts(TaxonomyChangeImpact[])"
  })
  void testWithImpactsWithTaxonomyChangeImpact() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangePreview immutableTaxonomyChangePreview =
        builderResult
            .command(
                paramsResult
                    .primaryReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .status(TaxonomyChangeLifecycleStatus.DRAFT)
                    .build())
            .errorMessage("An error occurred")
            .build();

    // Act
    ImmutableTaxonomyChangePreview actualWithImpactsResult =
        immutableTaxonomyChangePreview.withImpacts(
            ImmutableTaxonomyChangeImpact.builder()
                .description("The characteristics of someone or something")
                .impactCount(3)
                .severity(Severity.INFORMATION)
                .build());

    // Assert
    TaxonomyChangeCommand commandResult = actualWithImpactsResult.command();
    EntityReference changeDomainResult = commandResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = commandResult.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertTrue(commandResult instanceof ImmutableTaxonomyChangeCommand);
    List<TaxonomyChangeImpact> impactsResult = actualWithImpactsResult.impacts();
    assertEquals(1, impactsResult.size());
    assertTrue(impactsResult.get(0) instanceof ImmutableTaxonomyChangeImpact);
    assertEquals("2020-03-01", commandResult.lastUpdatedBy());
    assertEquals("An error occurred", actualWithImpactsResult.errorMessage());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", commandResult.createdBy());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, commandResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, commandResult.changeType());
    assertTrue(commandResult.params().isEmpty());
    assertEquals(changeDomainResult, primaryReferenceResult);
  }
}
