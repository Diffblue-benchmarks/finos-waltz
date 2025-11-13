package org.finos.waltz.model.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.app_group.ImmutableAppGroupDetail.Builder;
import org.finos.waltz.model.app_group.ImmutableAppGroupDetail.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppGroupDetailDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllApplications(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllApplications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllApplications(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllApplications(Iterable)"})
  void testBuilderAddAllApplications_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act
    Builder actualAddAllApplicationsResult = builderResult.addAllApplications(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllApplicationsResult);
  }

  /**
   * Test Builder {@link Builder#addAllChangeInitiatives(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllChangeInitiatives(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChangeInitiatives(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllChangeInitiatives(Iterable)"})
  void testBuilderAddAllChangeInitiatives_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act
    Builder actualAddAllChangeInitiativesResult =
        builderResult.addAllChangeInitiatives(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllChangeInitiativesResult);
  }

  /**
   * Test Builder {@link Builder#addAllMembers(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllMembers(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllMembers(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllMembers(Iterable)"})
  void testBuilderAddAllMembers_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act
    Builder actualAddAllMembersResult = builderResult.addAllMembers(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllMembersResult);
  }

  /**
   * Test Builder {@link Builder#addAllOrganisationalUnits(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllOrganisationalUnits(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllOrganisationalUnits(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllOrganisationalUnits(Iterable)"})
  void testBuilderAddAllOrganisationalUnits_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act
    Builder actualAddAllOrganisationalUnitsResult =
        builderResult.addAllOrganisationalUnits(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllOrganisationalUnitsResult);
  }

  /**
   * Test Builder {@link Builder#addApplications(AppGroupEntry)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableAppGroupEntry.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addApplications(AppGroupEntry)}
   */
  @Test
  @DisplayName(
      "Test Builder addApplications(AppGroupEntry) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addApplications(AppGroupEntry)"})
  void testBuilderAddApplicationsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act
    Builder actualAddApplicationsResult =
        builderResult.addApplications(new ImmutableAppGroupEntry.Json());

    // Assert
    assertSame(builderResult, actualAddApplicationsResult);
  }

  /**
   * Test Builder {@link Builder#addApplications(AppGroupEntry[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableAppGroupEntry.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addApplications(AppGroupEntry[])}
   */
  @Test
  @DisplayName(
      "Test Builder addApplications(AppGroupEntry[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addApplications(AppGroupEntry[])"})
  void testBuilderAddApplicationsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act
    Builder actualAddApplicationsResult =
        builderResult.addApplications(new ImmutableAppGroupEntry.Json());

    // Assert
    assertSame(builderResult, actualAddApplicationsResult);
  }

  /**
   * Test Builder {@link Builder#addChangeInitiatives(AppGroupEntry)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableAppGroupEntry.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addChangeInitiatives(AppGroupEntry)}
   */
  @Test
  @DisplayName(
      "Test Builder addChangeInitiatives(AppGroupEntry) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addChangeInitiatives(AppGroupEntry)"})
  void testBuilderAddChangeInitiativesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act
    Builder actualAddChangeInitiativesResult =
        builderResult.addChangeInitiatives(new ImmutableAppGroupEntry.Json());

    // Assert
    assertSame(builderResult, actualAddChangeInitiativesResult);
  }

  /**
   * Test Builder {@link Builder#addChangeInitiatives(AppGroupEntry[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableAppGroupEntry.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addChangeInitiatives(AppGroupEntry[])}
   */
  @Test
  @DisplayName(
      "Test Builder addChangeInitiatives(AppGroupEntry[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addChangeInitiatives(AppGroupEntry[])"})
  void testBuilderAddChangeInitiativesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act
    Builder actualAddChangeInitiativesResult =
        builderResult.addChangeInitiatives(new ImmutableAppGroupEntry.Json());

    // Assert
    assertSame(builderResult, actualAddChangeInitiativesResult);
  }

  /**
   * Test Builder {@link Builder#addMembers(AppGroupMember)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableAppGroupMember.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addMembers(AppGroupMember)}
   */
  @Test
  @DisplayName(
      "Test Builder addMembers(AppGroupMember) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMembers(AppGroupMember)"})
  void testBuilderAddMembersWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act
    Builder actualAddMembersResult = builderResult.addMembers(new ImmutableAppGroupMember.Json());

    // Assert
    assertSame(builderResult, actualAddMembersResult);
  }

  /**
   * Test Builder {@link Builder#addMembers(AppGroupMember[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableAppGroupMember.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addMembers(AppGroupMember[])}
   */
  @Test
  @DisplayName(
      "Test Builder addMembers(AppGroupMember[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMembers(AppGroupMember[])"})
  void testBuilderAddMembersWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act
    Builder actualAddMembersResult = builderResult.addMembers(new ImmutableAppGroupMember.Json());

    // Assert
    assertSame(builderResult, actualAddMembersResult);
  }

  /**
   * Test Builder {@link Builder#addOrganisationalUnits(AppGroupEntry)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableAppGroupEntry.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addOrganisationalUnits(AppGroupEntry)}
   */
  @Test
  @DisplayName(
      "Test Builder addOrganisationalUnits(AppGroupEntry) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOrganisationalUnits(AppGroupEntry)"})
  void testBuilderAddOrganisationalUnitsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act
    Builder actualAddOrganisationalUnitsResult =
        builderResult.addOrganisationalUnits(new ImmutableAppGroupEntry.Json());

    // Assert
    assertSame(builderResult, actualAddOrganisationalUnitsResult);
  }

  /**
   * Test Builder {@link Builder#addOrganisationalUnits(AppGroupEntry[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableAppGroupEntry.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addOrganisationalUnits(AppGroupEntry[])}
   */
  @Test
  @DisplayName(
      "Test Builder addOrganisationalUnits(AppGroupEntry[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOrganisationalUnits(AppGroupEntry[])"})
  void testBuilderAddOrganisationalUnitsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act
    Builder actualAddOrganisationalUnitsResult =
        builderResult.addOrganisationalUnits(new ImmutableAppGroupEntry.Json());

    // Assert
    assertSame(builderResult, actualAddOrganisationalUnitsResult);
  }

  /**
   * Test Builder {@link Builder#appGroup(AppGroup)}.
   *
   * <ul>
   *   <li>When {@link ImmutableAppGroup.Json} (default constructor).
   *   <li>Then builder build appGroup is {@link ImmutableAppGroup.Json} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#appGroup(AppGroup)}
   */
  @Test
  @DisplayName(
      "Test Builder appGroup(AppGroup); when Json (default constructor); then builder build appGroup is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.appGroup(AppGroup)"})
  void testBuilderAppGroup_whenJson_thenBuilderBuildAppGroupIsJson() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();
    ImmutableAppGroup.Json appGroup = new ImmutableAppGroup.Json();

    // Act
    Builder actualAppGroupResult = builderResult.appGroup(appGroup);

    // Assert
    assertSame(appGroup, builderResult.build().appGroup());
    assertSame(builderResult, actualAppGroupResult);
  }

  /**
   * Test Builder {@link Builder#applications(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applications(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applications(Iterable)"})
  void testBuilderApplications_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act
    Builder actualApplicationsResult = builderResult.applications(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualApplicationsResult);
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
  @MethodsUnderTest({"ImmutableAppGroupDetail Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAppGroupDetail.builder();
    ImmutableAppGroup appGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableAppGroupDetail actualImmutableAppGroupDetail =
        actualBuilderResult.appGroup(appGroup).build();

    // Assert
    assertTrue(actualImmutableAppGroupDetail.applications().isEmpty());
    assertSame(appGroup, actualImmutableAppGroupDetail.appGroup());
  }

  /**
   * Test Builder {@link Builder#changeInitiatives(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#changeInitiatives(Iterable)}
   */
  @Test
  @DisplayName("Test Builder changeInitiatives(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changeInitiatives(Iterable)"})
  void testBuilderChangeInitiatives_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act
    Builder actualChangeInitiativesResult = builderResult.changeInitiatives(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualChangeInitiativesResult);
  }

  /**
   * Test Builder {@link Builder#from(AppGroupDetail)}.
   *
   * <p>Method under test: {@link Builder#from(AppGroupDetail)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroupDetail)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppGroupDetail)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    Builder builderResult2 = ImmutableAppGroupDetail.builder();
    ImmutableAppGroupDetail instance =
        builderResult2
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAppGroupDetail actualImmutableAppGroupDetail = builderResult.build();
    assertEquals(instance, actualImmutableAppGroupDetail);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#members(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#members(Iterable)}
   */
  @Test
  @DisplayName("Test Builder members(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.members(Iterable)"})
  void testBuilderMembers_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act
    Builder actualMembersResult = builderResult.members(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualMembersResult);
  }

  /**
   * Test Builder {@link Builder#organisationalUnits(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#organisationalUnits(Iterable)}
   */
  @Test
  @DisplayName("Test Builder organisationalUnits(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.organisationalUnits(Iterable)"})
  void testBuilderOrganisationalUnits_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act
    Builder actualOrganisationalUnitsResult = builderResult.organisationalUnits(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualOrganisationalUnitsResult);
  }

  /**
   * Test {@link ImmutableAppGroupDetail#copyOf(AppGroupDetail)}.
   *
   * <ul>
   *   <li>Then appGroup return {@link ImmutableAppGroup}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupDetail#copyOf(AppGroupDetail)}
   */
  @Test
  @DisplayName("Test copyOf(AppGroupDetail); then appGroup return ImmutableAppGroup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupDetail ImmutableAppGroupDetail.copyOf(AppGroupDetail)"})
  void testCopyOf_thenAppGroupReturnImmutableAppGroup() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();
    ImmutableAppGroupDetail instance =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableAppGroupDetail actualCopyOfResult = ImmutableAppGroupDetail.copyOf(instance);

    // Assert
    AppGroup appGroupResult = actualCopyOfResult.appGroup();
    assertTrue(appGroupResult instanceof ImmutableAppGroup);
    assertEquals("Name", appGroupResult.name());
    assertEquals("The characteristics of someone or something", appGroupResult.description());
    assertEquals(EntityKind.ALL, appGroupResult.kind());
    assertEquals(AppGroupKind.PUBLIC, appGroupResult.appGroupKind());
    assertFalse(appGroupResult.isRemoved());
    assertFalse(appGroupResult.isFavouriteGroup());
    List<AppGroupEntry> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualCopyOfResult.changeInitiatives());
    assertSame(applicationsResult, actualCopyOfResult.members());
    assertSame(applicationsResult, actualCopyOfResult.organisationalUnits());
  }

  /**
   * Test {@link ImmutableAppGroupDetail#equals(Object)}, and {@link
   * ImmutableAppGroupDetail#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppGroupDetail#equals(Object)}
   *   <li>{@link ImmutableAppGroupDetail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupDetail.equals(Object)",
    "int ImmutableAppGroupDetail.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();
    ImmutableAppGroupDetail immutableAppGroupDetail =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableAppGroupDetail.builder();
    ImmutableAppGroupDetail immutableAppGroupDetail2 =
        builderResult2
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableAppGroupDetail, immutableAppGroupDetail2);
    assertEquals(immutableAppGroupDetail.hashCode(), immutableAppGroupDetail2.hashCode());
  }

  /**
   * Test {@link ImmutableAppGroupDetail#equals(Object)}, and {@link
   * ImmutableAppGroupDetail#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppGroupDetail#equals(Object)}
   *   <li>{@link ImmutableAppGroupDetail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupDetail.equals(Object)",
    "int ImmutableAppGroupDetail.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();
    ImmutableAppGroupDetail immutableAppGroupDetail =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableAppGroupDetail, immutableAppGroupDetail);
    int expectedHashCodeResult = immutableAppGroupDetail.hashCode();
    assertEquals(expectedHashCodeResult, immutableAppGroupDetail.hashCode());
  }

  /**
   * Test {@link ImmutableAppGroupDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupDetail.equals(Object)",
    "int ImmutableAppGroupDetail.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();
    builderResult.addMembers(
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build());
    ImmutableAppGroupDetail immutableAppGroupDetail =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertNotEquals(
        immutableAppGroupDetail,
        builderResult2
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAppGroupDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupDetail.equals(Object)",
    "int ImmutableAppGroupDetail.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();
    builderResult.addApplications(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());
    ImmutableAppGroupDetail immutableAppGroupDetail =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertNotEquals(
        immutableAppGroupDetail,
        builderResult2
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAppGroupDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupDetail.equals(Object)",
    "int ImmutableAppGroupDetail.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();
    builderResult.addOrganisationalUnits(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());
    ImmutableAppGroupDetail immutableAppGroupDetail =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertNotEquals(
        immutableAppGroupDetail,
        builderResult2
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAppGroupDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupDetail.equals(Object)",
    "int ImmutableAppGroupDetail.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();
    builderResult.addChangeInitiatives(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());
    ImmutableAppGroupDetail immutableAppGroupDetail =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertNotEquals(
        immutableAppGroupDetail,
        builderResult2
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAppGroupDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupDetail.equals(Object)",
    "int ImmutableAppGroupDetail.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAppGroupDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupDetail.equals(Object)",
    "int ImmutableAppGroupDetail.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableAppGroupDetail");
  }

  /**
   * Test {@link ImmutableAppGroupDetail#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableAppGroupMember.Json} (default
   *       constructor).
   *   <li>Then return changeInitiatives is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupDetail#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then return changeInitiatives is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupDetail ImmutableAppGroupDetail.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnChangeInitiativesIsArrayList() {
    // Arrange
    ArrayList<AppGroupMember> members = new ArrayList<>();
    members.add(new ImmutableAppGroupMember.Json());

    ArrayList<AppGroupEntry> applications = new ArrayList<>();
    applications.add(new ImmutableAppGroupEntry.Json());

    ArrayList<AppGroupEntry> organisationalUnits = new ArrayList<>();
    organisationalUnits.add(new ImmutableAppGroupEntry.Json());

    ArrayList<AppGroupEntry> changeInitiatives = new ArrayList<>();
    changeInitiatives.add(new ImmutableAppGroupEntry.Json());

    Json json = new Json();
    json.setAppGroup(new ImmutableAppGroup.Json());
    json.setMembers(members);
    json.setApplications(applications);
    json.setOrganisationalUnits(organisationalUnits);
    json.setChangeInitiatives(changeInitiatives);

    // Act
    ImmutableAppGroupDetail actualFromJsonResult = ImmutableAppGroupDetail.fromJson(json);

    // Assert
    assertEquals(changeInitiatives, actualFromJsonResult.changeInitiatives());
  }

  /**
   * Test {@link ImmutableAppGroupDetail#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return members size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupDetail#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList(); then return members size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupDetail ImmutableAppGroupDetail.fromJson(Json)"})
  void testFromJson_givenArrayList_thenReturnMembersSizeIsOne() {
    // Arrange
    ArrayList<AppGroupMember> members = new ArrayList<>();
    ImmutableAppGroupMember.Json json = new ImmutableAppGroupMember.Json();
    members.add(json);

    ArrayList<AppGroupEntry> applications = new ArrayList<>();
    applications.add(new ImmutableAppGroupEntry.Json());

    ArrayList<AppGroupEntry> organisationalUnits = new ArrayList<>();
    organisationalUnits.add(new ImmutableAppGroupEntry.Json());

    Json json2 = new Json();
    json2.setAppGroup(new ImmutableAppGroup.Json());
    json2.setMembers(members);
    json2.setApplications(applications);
    json2.setOrganisationalUnits(organisationalUnits);
    json2.setChangeInitiatives(new ArrayList<>());

    // Act
    ImmutableAppGroupDetail actualFromJsonResult = ImmutableAppGroupDetail.fromJson(json2);

    // Assert
    List<AppGroupMember> membersResult = actualFromJsonResult.members();
    assertEquals(1, membersResult.size());
    AppGroupMember getResult = membersResult.get(0);
    assertTrue(getResult instanceof ImmutableAppGroupMember.Json);
    assertTrue(actualFromJsonResult.changeInitiatives().isEmpty());
    assertEquals(applications, actualFromJsonResult.applications());
    assertEquals(organisationalUnits, actualFromJsonResult.organisationalUnits());
    assertSame(json, getResult);
  }

  /**
   * Test {@link ImmutableAppGroupDetail#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Applications is {@code null}.
   *   <li>Then return applications Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupDetail#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Applications is 'null'; then return applications Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupDetail ImmutableAppGroupDetail.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonApplicationsIsNull_thenReturnApplicationsEmpty() {
    // Arrange
    ArrayList<AppGroupMember> members = new ArrayList<>();
    members.add(new ImmutableAppGroupMember.Json());

    ArrayList<AppGroupEntry> organisationalUnits = new ArrayList<>();
    organisationalUnits.add(new ImmutableAppGroupEntry.Json());

    ArrayList<AppGroupEntry> changeInitiatives = new ArrayList<>();
    changeInitiatives.add(new ImmutableAppGroupEntry.Json());

    Json json = new Json();
    json.setAppGroup(new ImmutableAppGroup.Json());
    json.setMembers(members);
    json.setApplications(null);
    json.setOrganisationalUnits(organisationalUnits);
    json.setChangeInitiatives(changeInitiatives);

    // Act
    ImmutableAppGroupDetail actualFromJsonResult = ImmutableAppGroupDetail.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.applications().isEmpty());
    assertEquals(changeInitiatives, actualFromJsonResult.changeInitiatives());
  }

  /**
   * Test {@link ImmutableAppGroupDetail#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return members size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupDetail#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return members size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupDetail ImmutableAppGroupDetail.fromJson(Json)"})
  void testFromJson_thenReturnMembersSizeIsTwo() {
    // Arrange
    ArrayList<AppGroupMember> members = new ArrayList<>();
    members.add(
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build());
    ImmutableAppGroupMember.Json json = new ImmutableAppGroupMember.Json();
    members.add(json);

    ArrayList<AppGroupEntry> applications = new ArrayList<>();
    applications.add(new ImmutableAppGroupEntry.Json());

    ArrayList<AppGroupEntry> organisationalUnits = new ArrayList<>();
    organisationalUnits.add(new ImmutableAppGroupEntry.Json());

    ArrayList<AppGroupEntry> changeInitiatives = new ArrayList<>();
    changeInitiatives.add(new ImmutableAppGroupEntry.Json());

    Json json2 = new Json();
    json2.setAppGroup(new ImmutableAppGroup.Json());
    json2.setMembers(members);
    json2.setApplications(applications);
    json2.setOrganisationalUnits(organisationalUnits);
    json2.setChangeInitiatives(changeInitiatives);

    // Act
    ImmutableAppGroupDetail actualFromJsonResult = ImmutableAppGroupDetail.fromJson(json2);

    // Assert
    List<AppGroupMember> membersResult = actualFromJsonResult.members();
    assertEquals(2, membersResult.size());
    AppGroupMember getResult = membersResult.get(0);
    assertTrue(getResult instanceof ImmutableAppGroupMember);
    assertEquals("42", getResult.userId());
    assertEquals(1L, getResult.groupId());
    assertEquals(AppGroupMemberRole.VIEWER, getResult.role());
    assertSame(json, membersResult.get(1));
  }

  /**
   * Test {@link ImmutableAppGroupDetail#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return organisationalUnits Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupDetail#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return organisationalUnits Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupDetail ImmutableAppGroupDetail.fromJson(Json)"})
  void testFromJson_thenReturnOrganisationalUnitsEmpty() {
    // Arrange
    ArrayList<AppGroupMember> members = new ArrayList<>();
    members.add(new ImmutableAppGroupMember.Json());

    ArrayList<AppGroupEntry> applications = new ArrayList<>();
    applications.add(new ImmutableAppGroupEntry.Json());

    ArrayList<AppGroupEntry> changeInitiatives = new ArrayList<>();
    changeInitiatives.add(new ImmutableAppGroupEntry.Json());

    Json json = new Json();
    json.setAppGroup(new ImmutableAppGroup.Json());
    json.setMembers(members);
    json.setApplications(applications);
    json.setOrganisationalUnits(null);
    json.setChangeInitiatives(changeInitiatives);

    // Act
    ImmutableAppGroupDetail actualFromJsonResult = ImmutableAppGroupDetail.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.organisationalUnits().isEmpty());
    assertEquals(changeInitiatives, actualFromJsonResult.changeInitiatives());
  }

  /**
   * Test {@link ImmutableAppGroupDetail#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) ChangeInitiatives is {@code null}.
   *   <li>Then return members size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupDetail#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) ChangeInitiatives is 'null'; then return members size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupDetail ImmutableAppGroupDetail.fromJson(Json)"})
  void testFromJson_whenJsonChangeInitiativesIsNull_thenReturnMembersSizeIsOne() {
    // Arrange
    ArrayList<AppGroupMember> members = new ArrayList<>();
    ImmutableAppGroupMember.Json json = new ImmutableAppGroupMember.Json();
    members.add(json);

    ArrayList<AppGroupEntry> applications = new ArrayList<>();
    applications.add(new ImmutableAppGroupEntry.Json());

    ArrayList<AppGroupEntry> organisationalUnits = new ArrayList<>();
    organisationalUnits.add(new ImmutableAppGroupEntry.Json());

    Json json2 = new Json();
    json2.setAppGroup(new ImmutableAppGroup.Json());
    json2.setMembers(members);
    json2.setApplications(applications);
    json2.setOrganisationalUnits(organisationalUnits);
    json2.setChangeInitiatives(null);

    // Act
    ImmutableAppGroupDetail actualFromJsonResult = ImmutableAppGroupDetail.fromJson(json2);

    // Assert
    List<AppGroupMember> membersResult = actualFromJsonResult.members();
    assertEquals(1, membersResult.size());
    AppGroupMember getResult = membersResult.get(0);
    assertTrue(getResult instanceof ImmutableAppGroupMember.Json);
    assertTrue(actualFromJsonResult.changeInitiatives().isEmpty());
    assertEquals(applications, actualFromJsonResult.applications());
    assertEquals(organisationalUnits, actualFromJsonResult.organisationalUnits());
    assertSame(json, getResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppGroupDetail#toString()}
   *   <li>{@link ImmutableAppGroupDetail#appGroup()}
   *   <li>{@link ImmutableAppGroupDetail#applications()}
   *   <li>{@link ImmutableAppGroupDetail#changeInitiatives()}
   *   <li>{@link ImmutableAppGroupDetail#members()}
   *   <li>{@link ImmutableAppGroupDetail#organisationalUnits()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AppGroup ImmutableAppGroupDetail.appGroup()",
    "List ImmutableAppGroupDetail.applications()",
    "List ImmutableAppGroupDetail.changeInitiatives()",
    "List ImmutableAppGroupDetail.members()",
    "List ImmutableAppGroupDetail.organisationalUnits()",
    "String ImmutableAppGroupDetail.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();
    ImmutableAppGroupDetail immutableAppGroupDetail =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableAppGroupDetail.toString();
    AppGroup actualAppGroupResult = immutableAppGroupDetail.appGroup();
    List<AppGroupEntry> actualApplicationsResult = immutableAppGroupDetail.applications();
    List<AppGroupEntry> actualChangeInitiativesResult = immutableAppGroupDetail.changeInitiatives();
    List<AppGroupMember> actualMembersResult = immutableAppGroupDetail.members();
    List<AppGroupEntry> actualOrganisationalUnitsResult =
        immutableAppGroupDetail.organisationalUnits();

    // Assert
    assertTrue(actualAppGroupResult instanceof ImmutableAppGroup);
    assertEquals(
        "AppGroupDetail{appGroup=AppGroup{id=1, name=Name, externalId=42, isRemoved=false, appGroupKind=PUBLIC,"
            + " kind=ALL, isFavouriteGroup=false}, members=[], applications=[], organisationalUnits=[], changeInitiatives"
            + "=[]}",
        actualToStringResult);
    assertTrue(actualApplicationsResult.isEmpty());
    assertSame(actualApplicationsResult, actualChangeInitiativesResult);
    assertSame(actualApplicationsResult, actualMembersResult);
    assertSame(actualApplicationsResult, actualOrganisationalUnitsResult);
  }

  /**
   * Test Json {@link Json#appGroup()}.
   *
   * <p>Method under test: {@link Json#appGroup()}
   */
  @Test
  @DisplayName("Test Json appGroup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroup Json.appGroup()"})
  void testJsonAppGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().appGroup());
  }

  /**
   * Test Json {@link Json#applications()}.
   *
   * <p>Method under test: {@link Json#applications()}
   */
  @Test
  @DisplayName("Test Json applications()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.applications()"})
  void testJsonApplications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().applications());
  }

  /**
   * Test Json {@link Json#changeInitiatives()}.
   *
   * <p>Method under test: {@link Json#changeInitiatives()}
   */
  @Test
  @DisplayName("Test Json changeInitiatives()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.changeInitiatives()"})
  void testJsonChangeInitiatives() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().changeInitiatives());
  }

  /**
   * Test Json {@link Json#members()}.
   *
   * <p>Method under test: {@link Json#members()}
   */
  @Test
  @DisplayName("Test Json members()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.members()"})
  void testJsonMembers() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().members());
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
    assertNull(actualJson.appGroup);
    assertTrue(actualJson.applications.isEmpty());
    assertTrue(actualJson.changeInitiatives.isEmpty());
    assertTrue(actualJson.members.isEmpty());
    assertTrue(actualJson.organisationalUnits.isEmpty());
  }

  /**
   * Test Json {@link Json#organisationalUnits()}.
   *
   * <p>Method under test: {@link Json#organisationalUnits()}
   */
  @Test
  @DisplayName("Test Json organisationalUnits()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.organisationalUnits()"})
  void testJsonOrganisationalUnits() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().organisationalUnits());
  }

  /**
   * Test {@link ImmutableAppGroupDetail#withAppGroup(AppGroup)}.
   *
   * <p>Method under test: {@link ImmutableAppGroupDetail#withAppGroup(AppGroup)}
   */
  @Test
  @DisplayName("Test withAppGroup(AppGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupDetail ImmutableAppGroupDetail.withAppGroup(AppGroup)"})
  void testWithAppGroup() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();
    ImmutableAppGroupDetail immutableAppGroupDetail =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableAppGroupDetail actualWithAppGroupResult =
        immutableAppGroupDetail.withAppGroup(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableAppGroupDetail, actualWithAppGroupResult);
  }

  /**
   * Test {@link ImmutableAppGroupDetail#withApplications(AppGroupEntry[])} with {@code
   * AppGroupEntry[]}.
   *
   * <p>Method under test: {@link ImmutableAppGroupDetail#withApplications(AppGroupEntry[])}
   */
  @Test
  @DisplayName("Test withApplications(AppGroupEntry[]) with 'AppGroupEntry[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupDetail ImmutableAppGroupDetail.withApplications(AppGroupEntry[])"
  })
  void testWithApplicationsWithAppGroupEntry() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();
    ImmutableAppGroupDetail immutableAppGroupDetail =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableAppGroupDetail actualWithApplicationsResult =
        immutableAppGroupDetail.withApplications(
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
    AppGroup appGroupResult = actualWithApplicationsResult.appGroup();
    assertTrue(appGroupResult instanceof ImmutableAppGroup);
    List<AppGroupEntry> applicationsResult = actualWithApplicationsResult.applications();
    assertEquals(1, applicationsResult.size());
    assertTrue(applicationsResult.get(0) instanceof ImmutableAppGroupEntry);
    assertEquals("Name", appGroupResult.name());
    assertEquals("The characteristics of someone or something", appGroupResult.description());
    assertEquals(EntityKind.ALL, appGroupResult.kind());
    assertEquals(AppGroupKind.PUBLIC, appGroupResult.appGroupKind());
    assertFalse(appGroupResult.isRemoved());
    assertFalse(appGroupResult.isFavouriteGroup());
    List<AppGroupEntry> changeInitiativesResult = actualWithApplicationsResult.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertSame(changeInitiativesResult, actualWithApplicationsResult.members());
    assertSame(changeInitiativesResult, actualWithApplicationsResult.organisationalUnits());
  }

  /**
   * Test {@link ImmutableAppGroupDetail#withChangeInitiatives(AppGroupEntry[])} with {@code
   * AppGroupEntry[]}.
   *
   * <p>Method under test: {@link ImmutableAppGroupDetail#withChangeInitiatives(AppGroupEntry[])}
   */
  @Test
  @DisplayName("Test withChangeInitiatives(AppGroupEntry[]) with 'AppGroupEntry[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupDetail ImmutableAppGroupDetail.withChangeInitiatives(AppGroupEntry[])"
  })
  void testWithChangeInitiativesWithAppGroupEntry() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();
    ImmutableAppGroupDetail immutableAppGroupDetail =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableAppGroupDetail actualWithChangeInitiativesResult =
        immutableAppGroupDetail.withChangeInitiatives(
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
    AppGroup appGroupResult = actualWithChangeInitiativesResult.appGroup();
    assertTrue(appGroupResult instanceof ImmutableAppGroup);
    List<AppGroupEntry> changeInitiativesResult =
        actualWithChangeInitiativesResult.changeInitiatives();
    assertEquals(1, changeInitiativesResult.size());
    assertTrue(changeInitiativesResult.get(0) instanceof ImmutableAppGroupEntry);
    assertEquals("Name", appGroupResult.name());
    assertEquals("The characteristics of someone or something", appGroupResult.description());
    assertEquals(EntityKind.ALL, appGroupResult.kind());
    assertEquals(AppGroupKind.PUBLIC, appGroupResult.appGroupKind());
    assertFalse(appGroupResult.isRemoved());
    assertFalse(appGroupResult.isFavouriteGroup());
    List<AppGroupEntry> applicationsResult = actualWithChangeInitiativesResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualWithChangeInitiativesResult.members());
    assertSame(applicationsResult, actualWithChangeInitiativesResult.organisationalUnits());
  }

  /**
   * Test {@link ImmutableAppGroupDetail#withMembers(AppGroupMember[])} with {@code
   * AppGroupMember[]}.
   *
   * <p>Method under test: {@link ImmutableAppGroupDetail#withMembers(AppGroupMember[])}
   */
  @Test
  @DisplayName("Test withMembers(AppGroupMember[]) with 'AppGroupMember[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupDetail ImmutableAppGroupDetail.withMembers(AppGroupMember[])"
  })
  void testWithMembersWithAppGroupMember() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();
    ImmutableAppGroupDetail immutableAppGroupDetail =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableAppGroupDetail actualWithMembersResult =
        immutableAppGroupDetail.withMembers(
            ImmutableAppGroupMember.builder()
                .groupId(1L)
                .role(AppGroupMemberRole.VIEWER)
                .userId("42")
                .build());

    // Assert
    AppGroup appGroupResult = actualWithMembersResult.appGroup();
    assertTrue(appGroupResult instanceof ImmutableAppGroup);
    List<AppGroupMember> membersResult = actualWithMembersResult.members();
    assertEquals(1, membersResult.size());
    assertTrue(membersResult.get(0) instanceof ImmutableAppGroupMember);
    assertEquals("Name", appGroupResult.name());
    assertEquals("The characteristics of someone or something", appGroupResult.description());
    assertEquals(EntityKind.ALL, appGroupResult.kind());
    assertEquals(AppGroupKind.PUBLIC, appGroupResult.appGroupKind());
    assertFalse(appGroupResult.isRemoved());
    assertFalse(appGroupResult.isFavouriteGroup());
    List<AppGroupEntry> applicationsResult = actualWithMembersResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualWithMembersResult.changeInitiatives());
    assertSame(applicationsResult, actualWithMembersResult.organisationalUnits());
  }

  /**
   * Test {@link ImmutableAppGroupDetail#withOrganisationalUnits(AppGroupEntry[])} with {@code
   * AppGroupEntry[]}.
   *
   * <p>Method under test: {@link ImmutableAppGroupDetail#withOrganisationalUnits(AppGroupEntry[])}
   */
  @Test
  @DisplayName("Test withOrganisationalUnits(AppGroupEntry[]) with 'AppGroupEntry[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupDetail ImmutableAppGroupDetail.withOrganisationalUnits(AppGroupEntry[])"
  })
  void testWithOrganisationalUnitsWithAppGroupEntry() {
    // Arrange
    Builder builderResult = ImmutableAppGroupDetail.builder();
    ImmutableAppGroupDetail immutableAppGroupDetail =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableAppGroupDetail actualWithOrganisationalUnitsResult =
        immutableAppGroupDetail.withOrganisationalUnits(
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
    AppGroup appGroupResult = actualWithOrganisationalUnitsResult.appGroup();
    assertTrue(appGroupResult instanceof ImmutableAppGroup);
    List<AppGroupEntry> organisationalUnitsResult =
        actualWithOrganisationalUnitsResult.organisationalUnits();
    assertEquals(1, organisationalUnitsResult.size());
    assertTrue(organisationalUnitsResult.get(0) instanceof ImmutableAppGroupEntry);
    assertEquals("Name", appGroupResult.name());
    assertEquals("The characteristics of someone or something", appGroupResult.description());
    assertEquals(EntityKind.ALL, appGroupResult.kind());
    assertEquals(AppGroupKind.PUBLIC, appGroupResult.appGroupKind());
    assertFalse(appGroupResult.isRemoved());
    assertFalse(appGroupResult.isFavouriteGroup());
    List<AppGroupEntry> applicationsResult = actualWithOrganisationalUnitsResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualWithOrganisationalUnitsResult.changeInitiatives());
    assertSame(applicationsResult, actualWithOrganisationalUnitsResult.members());
  }
}
