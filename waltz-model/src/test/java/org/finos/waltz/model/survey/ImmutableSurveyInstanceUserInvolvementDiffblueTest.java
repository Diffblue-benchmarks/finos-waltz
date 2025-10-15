package org.finos.waltz.model.survey;

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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceUserInvolvement.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceUserInvolvement.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceUserInvolvementDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllSurveyInstances(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllSurveyInstances(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllSurveyInstances(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllSurveyInstances(Iterable)"})
  void testBuilderAddAllSurveyInstances_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    // Act
    Builder actualAddAllSurveyInstancesResult =
        builderResult.addAllSurveyInstances(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllSurveyInstancesResult);
  }

  /**
   * Test Builder {@link Builder#addSurveyInstances(SurveyInstanceInfo)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addSurveyInstances(SurveyInstanceInfo)}
   */
  @Test
  @DisplayName("Test Builder addSurveyInstances(SurveyInstanceInfo) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addSurveyInstances(SurveyInstanceInfo)"})
  void testBuilderAddSurveyInstancesWithElement() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    // Act
    Builder actualAddSurveyInstancesResult =
        builderResult.addSurveyInstances(new ImmutableSurveyInstanceInfo.Json());

    // Assert
    assertSame(builderResult, actualAddSurveyInstancesResult);
  }

  /**
   * Test Builder {@link Builder#addSurveyInstances(SurveyInstanceInfo[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addSurveyInstances(SurveyInstanceInfo[])}
   */
  @Test
  @DisplayName("Test Builder addSurveyInstances(SurveyInstanceInfo[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addSurveyInstances(SurveyInstanceInfo[])"})
  void testBuilderAddSurveyInstancesWithElements() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    // Act
    Builder actualAddSurveyInstancesResult =
        builderResult.addSurveyInstances(new ImmutableSurveyInstanceInfo.Json());

    // Assert
    assertSame(builderResult, actualAddSurveyInstancesResult);
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
  @MethodsUnderTest({"ImmutableSurveyInstanceUserInvolvement Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSurveyInstanceUserInvolvement actualImmutableSurveyInstanceUserInvolvement =
        ImmutableSurveyInstanceUserInvolvement.builder()
            .surveyInvolvementKind(SurveyInvolvementKind.OWNER)
            .build();

    // Assert
    assertEquals(
        SurveyInvolvementKind.OWNER,
        actualImmutableSurveyInstanceUserInvolvement.surveyInvolvementKind());
    assertTrue(actualImmutableSurveyInstanceUserInvolvement.surveyInstances().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceUserInvolvement)}.
   *
   * <ul>
   *   <li>Then builder build is builder surveyInvolvementKind {@code OWNER} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceUserInvolvement)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyInstanceUserInvolvement); then builder build is builder surveyInvolvementKind 'OWNER' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceUserInvolvement)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderSurveyInvolvementKindOwnerBuild() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();
    ImmutableSurveyInstanceUserInvolvement instance =
        ImmutableSurveyInstanceUserInvolvement.builder()
            .surveyInvolvementKind(SurveyInvolvementKind.OWNER)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyInstanceUserInvolvement actualImmutableSurveyInstanceUserInvolvement =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceUserInvolvement);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#surveyInstances(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#surveyInstances(Iterable)}
   */
  @Test
  @DisplayName("Test Builder surveyInstances(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.surveyInstances(Iterable)"})
  void testBuilderSurveyInstances_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    // Act
    Builder actualSurveyInstancesResult = builderResult.surveyInstances(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualSurveyInstancesResult);
  }

  /**
   * Test Builder {@link Builder#surveyInvolvementKind(SurveyInvolvementKind)}.
   *
   * <p>Method under test: {@link Builder#surveyInvolvementKind(SurveyInvolvementKind)}
   */
  @Test
  @DisplayName("Test Builder surveyInvolvementKind(SurveyInvolvementKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.surveyInvolvementKind(SurveyInvolvementKind)"})
  void testBuilderSurveyInvolvementKind() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    // Act
    Builder actualSurveyInvolvementKindResult =
        builderResult.surveyInvolvementKind(SurveyInvolvementKind.OWNER);

    // Assert
    assertEquals(SurveyInvolvementKind.OWNER, builderResult.build().surveyInvolvementKind());
    assertSame(builderResult, actualSurveyInvolvementKindResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceUserInvolvement#copyOf(SurveyInstanceUserInvolvement)}.
   *
   * <ul>
   *   <li>Then return surveyInvolvementKind is {@code OWNER}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceUserInvolvement#copyOf(SurveyInstanceUserInvolvement)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyInstanceUserInvolvement); then return surveyInvolvementKind is 'OWNER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceUserInvolvement ImmutableSurveyInstanceUserInvolvement.copyOf(SurveyInstanceUserInvolvement)"
  })
  void testCopyOf_thenReturnSurveyInvolvementKindIsOwner() {
    // Arrange
    ImmutableSurveyInstanceUserInvolvement instance =
        ImmutableSurveyInstanceUserInvolvement.builder()
            .surveyInvolvementKind(SurveyInvolvementKind.OWNER)
            .build();

    // Act
    ImmutableSurveyInstanceUserInvolvement actualCopyOfResult =
        ImmutableSurveyInstanceUserInvolvement.copyOf(instance);

    // Assert
    assertEquals(SurveyInvolvementKind.OWNER, actualCopyOfResult.surveyInvolvementKind());
    assertTrue(actualCopyOfResult.surveyInstances().isEmpty());
  }

  /**
   * Test {@link ImmutableSurveyInstanceUserInvolvement#equals(Object)}, and {@link
   * ImmutableSurveyInstanceUserInvolvement#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceUserInvolvement#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceUserInvolvement#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceUserInvolvement.equals(Object)",
    "int ImmutableSurveyInstanceUserInvolvement.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceUserInvolvement immutableSurveyInstanceUserInvolvement =
        ImmutableSurveyInstanceUserInvolvement.builder()
            .surveyInvolvementKind(SurveyInvolvementKind.OWNER)
            .build();
    ImmutableSurveyInstanceUserInvolvement immutableSurveyInstanceUserInvolvement2 =
        ImmutableSurveyInstanceUserInvolvement.builder()
            .surveyInvolvementKind(SurveyInvolvementKind.OWNER)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyInstanceUserInvolvement, immutableSurveyInstanceUserInvolvement2);
    assertEquals(
        immutableSurveyInstanceUserInvolvement.hashCode(),
        immutableSurveyInstanceUserInvolvement2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceUserInvolvement#equals(Object)}, and {@link
   * ImmutableSurveyInstanceUserInvolvement#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceUserInvolvement#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceUserInvolvement#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceUserInvolvement.equals(Object)",
    "int ImmutableSurveyInstanceUserInvolvement.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceUserInvolvement immutableSurveyInstanceUserInvolvement =
        ImmutableSurveyInstanceUserInvolvement.builder()
            .surveyInvolvementKind(SurveyInvolvementKind.OWNER)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyInstanceUserInvolvement, immutableSurveyInstanceUserInvolvement);
    int expectedHashCodeResult = immutableSurveyInstanceUserInvolvement.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyInstanceUserInvolvement.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceUserInvolvement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceUserInvolvement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceUserInvolvement.equals(Object)",
    "int ImmutableSurveyInstanceUserInvolvement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    ImmutableSurveyInstanceInfo.Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

    ImmutableSurveyInstance.Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(1L)
            .owningRole("Owning Role");

    ImmutableSurveyInstance.Builder submittedByResult =
        owningRoleResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(SurveyInstanceStatus.NOT_STARTED)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By");

    ImmutableSurveyInstanceInfo.Builder surveyInstanceResult =
        historicalVersionsCountResult.surveyInstance(
            submittedByResult
                .surveyEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .surveyEntityExternalId("42")
                .surveyRunId(1L)
                .build());

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    ImmutableSurveyInstanceInfo.Builder surveyRunResult =
        surveyInstanceResult.surveyRun(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    builderResult.addSurveyInstances(
        surveyRunResult
            .surveyTemplateRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    ImmutableSurveyInstanceUserInvolvement immutableSurveyInstanceUserInvolvement =
        builderResult.surveyInvolvementKind(SurveyInvolvementKind.OWNER).build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceUserInvolvement,
        ImmutableSurveyInstanceUserInvolvement.builder()
            .surveyInvolvementKind(SurveyInvolvementKind.OWNER)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceUserInvolvement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceUserInvolvement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceUserInvolvement.equals(Object)",
    "int ImmutableSurveyInstanceUserInvolvement.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyInstanceUserInvolvement.builder()
            .surveyInvolvementKind(SurveyInvolvementKind.OWNER)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyInstanceUserInvolvement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceUserInvolvement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceUserInvolvement.equals(Object)",
    "int ImmutableSurveyInstanceUserInvolvement.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyInstanceUserInvolvement.builder()
            .surveyInvolvementKind(SurveyInvolvementKind.OWNER)
            .build(),
        "Different type to ImmutableSurveyInstanceUserInvolvement");
  }

  /**
   * Test {@link ImmutableSurveyInstanceUserInvolvement#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) SurveyInstances is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceUserInvolvement#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) SurveyInstances is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceUserInvolvement ImmutableSurveyInstanceUserInvolvement.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonSurveyInstancesIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setSurveyInvolvementKind(SurveyInvolvementKind.OWNER);
    json.setSurveyInstances(new HashSet<>());

    // Act
    ImmutableSurveyInstanceUserInvolvement actualFromJsonResult =
        ImmutableSurveyInstanceUserInvolvement.fromJson(json);

    // Assert
    assertEquals(SurveyInvolvementKind.OWNER, actualFromJsonResult.surveyInvolvementKind());
    assertTrue(actualFromJsonResult.surveyInstances().isEmpty());
  }

  /**
   * Test {@link ImmutableSurveyInstanceUserInvolvement#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableSurveyInstanceInfo.Json}
   *       (default constructor).
   *   <li>Then return surveyInstances size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceUserInvolvement#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return surveyInstances size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceUserInvolvement ImmutableSurveyInstanceUserInvolvement.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnSurveyInstancesSizeIsOne() {
    // Arrange
    LinkedHashSet<SurveyInstanceInfo> surveyInstances = new LinkedHashSet<>();
    surveyInstances.add(new ImmutableSurveyInstanceInfo.Json());

    Json json = new Json();
    json.setSurveyInvolvementKind(SurveyInvolvementKind.OWNER);
    json.setSurveyInstances(surveyInstances);

    // Act
    ImmutableSurveyInstanceUserInvolvement actualFromJsonResult =
        ImmutableSurveyInstanceUserInvolvement.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.surveyInstances().size());
    assertEquals(SurveyInvolvementKind.OWNER, actualFromJsonResult.surveyInvolvementKind());
  }

  /**
   * Test {@link ImmutableSurveyInstanceUserInvolvement#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return surveyInstances is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceUserInvolvement#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return surveyInstances is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceUserInvolvement ImmutableSurveyInstanceUserInvolvement.fromJson(Json)"
  })
  void testFromJson_thenReturnSurveyInstancesIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<SurveyInstanceInfo> surveyInstances = new LinkedHashSet<>();

    ImmutableSurveyInstanceInfo.Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

    ImmutableSurveyInstance.Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(1L)
            .owningRole("Owning Role");

    ImmutableSurveyInstance.Builder submittedByResult =
        owningRoleResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(SurveyInstanceStatus.NOT_STARTED)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By");

    ImmutableSurveyInstanceInfo.Builder surveyInstanceResult =
        historicalVersionsCountResult.surveyInstance(
            submittedByResult
                .surveyEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .surveyEntityExternalId("42")
                .surveyRunId(1L)
                .build());

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    ImmutableSurveyInstanceInfo.Builder surveyRunResult =
        surveyInstanceResult.surveyRun(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    surveyInstances.add(
        surveyRunResult
            .surveyTemplateRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    surveyInstances.add(new ImmutableSurveyInstanceInfo.Json());

    Json json = new Json();
    json.setSurveyInvolvementKind(SurveyInvolvementKind.OWNER);
    json.setSurveyInstances(surveyInstances);

    // Act
    ImmutableSurveyInstanceUserInvolvement actualFromJsonResult =
        ImmutableSurveyInstanceUserInvolvement.fromJson(json);

    // Assert
    assertEquals(SurveyInvolvementKind.OWNER, actualFromJsonResult.surveyInvolvementKind());
    assertEquals(surveyInstances, actualFromJsonResult.surveyInstances());
  }

  /**
   * Test {@link ImmutableSurveyInstanceUserInvolvement#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) SurveyInstances is {@code null}.
   *   <li>Then return surveyInstances Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceUserInvolvement#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) SurveyInstances is 'null'; then return surveyInstances Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceUserInvolvement ImmutableSurveyInstanceUserInvolvement.fromJson(Json)"
  })
  void testFromJson_whenJsonSurveyInstancesIsNull_thenReturnSurveyInstancesEmpty() {
    // Arrange
    Json json = new Json();
    json.setSurveyInvolvementKind(SurveyInvolvementKind.OWNER);
    json.setSurveyInstances(null);

    // Act
    ImmutableSurveyInstanceUserInvolvement actualFromJsonResult =
        ImmutableSurveyInstanceUserInvolvement.fromJson(json);

    // Assert
    assertEquals(SurveyInvolvementKind.OWNER, actualFromJsonResult.surveyInvolvementKind());
    assertTrue(actualFromJsonResult.surveyInstances().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceUserInvolvement#toString()}
   *   <li>{@link ImmutableSurveyInstanceUserInvolvement#surveyInstances()}
   *   <li>{@link ImmutableSurveyInstanceUserInvolvement#surveyInvolvementKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableSurveyInstanceUserInvolvement.surveyInstances()",
    "SurveyInvolvementKind ImmutableSurveyInstanceUserInvolvement.surveyInvolvementKind()",
    "String ImmutableSurveyInstanceUserInvolvement.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSurveyInstanceUserInvolvement immutableSurveyInstanceUserInvolvement =
        ImmutableSurveyInstanceUserInvolvement.builder()
            .surveyInvolvementKind(SurveyInvolvementKind.OWNER)
            .build();

    // Act
    String actualToStringResult = immutableSurveyInstanceUserInvolvement.toString();
    Set<SurveyInstanceInfo> actualSurveyInstancesResult =
        immutableSurveyInstanceUserInvolvement.surveyInstances();

    // Assert
    assertEquals(
        "SurveyInstanceUserInvolvement{surveyInvolvementKind=OWNER, surveyInstances=[]}",
        actualToStringResult);
    assertEquals(
        SurveyInvolvementKind.OWNER,
        immutableSurveyInstanceUserInvolvement.surveyInvolvementKind());
    assertTrue(actualSurveyInstancesResult.isEmpty());
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
    assertNull(actualJson.surveyInvolvementKind);
    assertTrue(actualJson.surveyInstances.isEmpty());
  }

  /**
   * Test Json {@link Json#surveyInstances()}.
   *
   * <p>Method under test: {@link Json#surveyInstances()}
   */
  @Test
  @DisplayName("Test Json surveyInstances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.surveyInstances()"})
  void testJsonSurveyInstances() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().surveyInstances());
  }

  /**
   * Test Json {@link Json#surveyInvolvementKind()}.
   *
   * <p>Method under test: {@link Json#surveyInvolvementKind()}
   */
  @Test
  @DisplayName("Test Json surveyInvolvementKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyInvolvementKind Json.surveyInvolvementKind()"})
  void testJsonSurveyInvolvementKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().surveyInvolvementKind());
  }

  /**
   * Test {@link
   * ImmutableSurveyInstanceUserInvolvement#withSurveyInvolvementKind(SurveyInvolvementKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceUserInvolvement#withSurveyInvolvementKind(SurveyInvolvementKind)}
   */
  @Test
  @DisplayName("Test withSurveyInvolvementKind(SurveyInvolvementKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceUserInvolvement ImmutableSurveyInstanceUserInvolvement.withSurveyInvolvementKind(SurveyInvolvementKind)"
  })
  void testWithSurveyInvolvementKind() {
    // Arrange
    ImmutableSurveyInstanceUserInvolvement immutableSurveyInstanceUserInvolvement =
        ImmutableSurveyInstanceUserInvolvement.builder()
            .surveyInvolvementKind(SurveyInvolvementKind.OWNER)
            .build();

    // Act
    ImmutableSurveyInstanceUserInvolvement actualWithSurveyInvolvementKindResult =
        immutableSurveyInstanceUserInvolvement.withSurveyInvolvementKind(
            SurveyInvolvementKind.OWNER);

    // Assert
    assertSame(immutableSurveyInstanceUserInvolvement, actualWithSurveyInvolvementKindResult);
  }
}
