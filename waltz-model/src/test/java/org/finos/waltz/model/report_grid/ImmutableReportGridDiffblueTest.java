package org.finos.waltz.model.report_grid;

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
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.model.report_grid.ImmutableReportGrid.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGrid.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridDiffblueTest {
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
    Builder builderResult = ImmutableReportGrid.builder();

    // Act
    Builder actualAddAllMembersResult = builderResult.addAllMembers(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllMembersResult);
  }

  /**
   * Test Builder {@link Builder#addMembers(ReportGridMember)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableReportGridMember.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addMembers(ReportGridMember)}
   */
  @Test
  @DisplayName(
      "Test Builder addMembers(ReportGridMember) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMembers(ReportGridMember)"})
  void testBuilderAddMembersWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();

    // Act
    Builder actualAddMembersResult = builderResult.addMembers(new ImmutableReportGridMember.Json());

    // Assert
    assertSame(builderResult, actualAddMembersResult);
  }

  /**
   * Test Builder {@link Builder#addMembers(ReportGridMember[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableReportGridMember.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addMembers(ReportGridMember[])}
   */
  @Test
  @DisplayName(
      "Test Builder addMembers(ReportGridMember[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMembers(ReportGridMember[])"})
  void testBuilderAddMembersWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();

    // Act
    Builder actualAddMembersResult = builderResult.addMembers(new ImmutableReportGridMember.Json());

    // Assert
    assertSame(builderResult, actualAddMembersResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#userRole(ReportGridMemberRole)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGrid Builder.build()",
    "Builder Builder.userRole(ReportGridMemberRole)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableReportGrid.builder();
    ImmutableReportGridDefinition definition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();
    ImmutableReportGridInstance instance = ImmutableReportGridInstance.builder().build();
    ImmutableReportGrid actualImmutableReportGrid =
        actualBuilderResult
            .definition(definition)
            .instance(instance)
            .userRole(ReportGridMemberRole.VIEWER)
            .build();

    // Assert
    assertEquals(ReportGridMemberRole.VIEWER, actualImmutableReportGrid.userRole());
    assertTrue(actualImmutableReportGrid.members().isEmpty());
    assertSame(definition, actualImmutableReportGrid.definition());
    assertSame(instance, actualImmutableReportGrid.instance());
  }

  /**
   * Test Builder {@link Builder#definition(ReportGridDefinition)}.
   *
   * <ul>
   *   <li>When {@link ImmutableReportGridDefinition.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#definition(ReportGridDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder definition(ReportGridDefinition); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.definition(ReportGridDefinition)"})
  void testBuilderDefinition_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();

    // Act
    Builder actualDefinitionResult =
        builderResult.definition(new ImmutableReportGridDefinition.Json());

    // Assert
    assertSame(builderResult, actualDefinitionResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGrid)}.
   *
   * <p>Method under test: {@link Builder#from(ReportGrid)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGrid)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGrid)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();

    Builder builderResult2 = ImmutableReportGrid.builder();
    ImmutableReportGrid instance =
        builderResult2
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGrid actualImmutableReportGrid = builderResult.build();
    assertEquals(instance, actualImmutableReportGrid);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#instance(ReportGridInstance)}.
   *
   * <ul>
   *   <li>When {@link ImmutableReportGridInstance.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#instance(ReportGridInstance)}
   */
  @Test
  @DisplayName(
      "Test Builder instance(ReportGridInstance); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.instance(ReportGridInstance)"})
  void testBuilderInstance_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();

    // Act
    Builder actualInstanceResult = builderResult.instance(new ImmutableReportGridInstance.Json());

    // Assert
    assertSame(builderResult, actualInstanceResult);
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
    Builder builderResult = ImmutableReportGrid.builder();

    // Act
    Builder actualMembersResult = builderResult.members(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualMembersResult);
  }

  /**
   * Test {@link ImmutableReportGrid#copyOf(ReportGrid)}.
   *
   * <ul>
   *   <li>Then definition return {@link ImmutableReportGridDefinition}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGrid#copyOf(ReportGrid)}
   */
  @Test
  @DisplayName("Test copyOf(ReportGrid); then definition return ImmutableReportGridDefinition")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGrid ImmutableReportGrid.copyOf(ReportGrid)"})
  void testCopyOf_thenDefinitionReturnImmutableReportGridDefinition() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();
    ImmutableReportGrid instance =
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();

    // Act
    ImmutableReportGrid actualCopyOfResult = ImmutableReportGrid.copyOf(instance);

    // Assert
    ReportGridDefinition definitionResult = actualCopyOfResult.definition();
    assertTrue(definitionResult instanceof ImmutableReportGridDefinition);
    ReportGridInstance instanceResult = actualCopyOfResult.instance();
    assertTrue(instanceResult instanceof ImmutableReportGridInstance);
    assertEquals("2020-03-01", definitionResult.lastUpdatedBy());
    assertEquals("Name", definitionResult.name());
    assertEquals("Provenance", definitionResult.provenance());
    assertEquals("The characteristics of someone or something", definitionResult.description());
    assertEquals(EntityKind.ALL, definitionResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, definitionResult.kind());
    assertEquals(ReportGridMemberRole.VIEWER, actualCopyOfResult.userRole());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        definitionResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    Set<ReportGridMember> membersResult = actualCopyOfResult.members();
    assertTrue(membersResult.isEmpty());
    assertSame(membersResult, instanceResult.cellData());
    assertSame(membersResult, instanceResult.ratingSchemeItems());
    assertSame(membersResult, instanceResult.subjects());
    assertSame(derivedColumnDefinitionsResult, definitionResult.fixedColumnDefinitions());
  }

  /**
   * Test {@link ImmutableReportGrid#equals(Object)}, and {@link ImmutableReportGrid#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGrid#equals(Object)}
   *   <li>{@link ImmutableReportGrid#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGrid.equals(Object)",
    "int ImmutableReportGrid.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();
    ImmutableReportGrid immutableReportGrid =
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();

    Builder builderResult2 = ImmutableReportGrid.builder();
    ImmutableReportGrid immutableReportGrid2 =
        builderResult2
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();

    // Act and Assert
    assertEquals(immutableReportGrid, immutableReportGrid2);
    assertEquals(immutableReportGrid.hashCode(), immutableReportGrid2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGrid#equals(Object)}, and {@link ImmutableReportGrid#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGrid#equals(Object)}
   *   <li>{@link ImmutableReportGrid#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGrid.equals(Object)",
    "int ImmutableReportGrid.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();
    ImmutableReportGrid immutableReportGrid =
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();

    // Act and Assert
    assertEquals(immutableReportGrid, immutableReportGrid);
    int expectedHashCodeResult = immutableReportGrid.hashCode();
    assertEquals(expectedHashCodeResult, immutableReportGrid.hashCode());
  }

  /**
   * Test {@link ImmutableReportGrid#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGrid#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGrid.equals(Object)",
    "int ImmutableReportGrid.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();

    ImmutableReportGridMember.Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);
    builderResult.addMembers(
        roleResult
            .user(
                ImmutablePerson.builder()
                    .departmentName("Department Name")
                    .displayName("Display Name")
                    .email("jane.doe@example.org")
                    .employeeId("42")
                    .id(1L)
                    .isRemoved(true)
                    .kind(EntityKind.ALL)
                    .managerEmployeeId("42")
                    .mobilePhone("6625550144")
                    .officePhone("6625550144")
                    .organisationalUnitId(1L)
                    .personKind(PersonKind.EMPLOYEE)
                    .title("Dr")
                    .userId("42")
                    .userPrincipalName("User Principal Name")
                    .build())
            .build());
    ImmutableReportGrid immutableReportGrid =
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();

    Builder builderResult2 = ImmutableReportGrid.builder();

    // Act and Assert
    assertNotEquals(
        immutableReportGrid,
        builderResult2
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build());
  }

  /**
   * Test {@link ImmutableReportGrid#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGrid#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGrid.equals(Object)",
    "int ImmutableReportGrid.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableReportGrid#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGrid#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGrid.equals(Object)",
    "int ImmutableReportGrid.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build(),
        "Different type to ImmutableReportGrid");
  }

  /**
   * Test {@link ImmutableReportGrid#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Members is {@link HashSet#HashSet()}.
   *   <li>Then return members Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGrid#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) Members is HashSet(); then return members Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGrid ImmutableReportGrid.fromJson(Json)"})
  void testFromJson_givenHashSet_whenJsonMembersIsHashSet_thenReturnMembersEmpty() {
    // Arrange
    Json json = new Json();
    json.setDefinition(new ImmutableReportGridDefinition.Json());
    ImmutableReportGridInstance.Json instance = new ImmutableReportGridInstance.Json();
    json.setInstance(instance);
    json.setMembers(new HashSet<>());
    json.setUserRole(ReportGridMemberRole.VIEWER);

    // Act
    ImmutableReportGrid actualFromJsonResult = ImmutableReportGrid.fromJson(json);

    // Assert
    ReportGridInstance instanceResult = actualFromJsonResult.instance();
    assertTrue(instanceResult instanceof ImmutableReportGridInstance.Json);
    Set<ReportGridMember> membersResult = actualFromJsonResult.members();
    assertTrue(membersResult.isEmpty());
    assertSame(
        membersResult, ((ImmutableReportGridInstance.Json) instanceResult).ratingSchemeItems);
    assertSame(membersResult, ((ImmutableReportGridInstance.Json) instanceResult).subjects);
    assertSame(instance.subjects, ((ImmutableReportGridInstance.Json) instanceResult).cellData);
  }

  /**
   * Test {@link ImmutableReportGrid#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableReportGridMember.Json}
   *       (default constructor).
   *   <li>Then return members size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGrid#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return members size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGrid ImmutableReportGrid.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnMembersSizeIsOne() {
    // Arrange
    LinkedHashSet<ReportGridMember> members = new LinkedHashSet<>();
    members.add(new ImmutableReportGridMember.Json());

    Json json = new Json();
    json.setDefinition(new ImmutableReportGridDefinition.Json());
    json.setInstance(new ImmutableReportGridInstance.Json());
    json.setMembers(members);
    json.setUserRole(ReportGridMemberRole.VIEWER);

    // Act
    ImmutableReportGrid actualFromJsonResult = ImmutableReportGrid.fromJson(json);

    // Assert
    ReportGridInstance instanceResult = actualFromJsonResult.instance();
    assertTrue(instanceResult instanceof ImmutableReportGridInstance.Json);
    assertEquals(1, actualFromJsonResult.members().size());
    Set<ReportGridCell> reportGridCellSet =
        ((ImmutableReportGridInstance.Json) instanceResult).cellData;
    assertTrue(reportGridCellSet.isEmpty());
    assertSame(
        reportGridCellSet, ((ImmutableReportGridInstance.Json) instanceResult).ratingSchemeItems);
    assertSame(reportGridCellSet, ((ImmutableReportGridInstance.Json) instanceResult).subjects);
  }

  /**
   * Test {@link ImmutableReportGrid#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Members is {@code null}.
   *   <li>Then return members Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGrid#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Members is 'null'; then return members Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGrid ImmutableReportGrid.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonMembersIsNull_thenReturnMembersEmpty() {
    // Arrange
    Json json = new Json();
    json.setDefinition(new ImmutableReportGridDefinition.Json());
    ImmutableReportGridInstance.Json instance = new ImmutableReportGridInstance.Json();
    json.setInstance(instance);
    json.setMembers(null);
    json.setUserRole(ReportGridMemberRole.VIEWER);

    // Act
    ImmutableReportGrid actualFromJsonResult = ImmutableReportGrid.fromJson(json);

    // Assert
    ReportGridInstance instanceResult = actualFromJsonResult.instance();
    assertTrue(instanceResult instanceof ImmutableReportGridInstance.Json);
    Set<ReportGridMember> membersResult = actualFromJsonResult.members();
    assertTrue(membersResult.isEmpty());
    assertSame(
        membersResult, ((ImmutableReportGridInstance.Json) instanceResult).ratingSchemeItems);
    assertSame(membersResult, ((ImmutableReportGridInstance.Json) instanceResult).subjects);
    assertSame(instance.subjects, ((ImmutableReportGridInstance.Json) instanceResult).cellData);
  }

  /**
   * Test {@link ImmutableReportGrid#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return members is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGrid#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return members is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGrid ImmutableReportGrid.fromJson(Json)"})
  void testFromJson_thenReturnMembersIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<ReportGridMember> members = new LinkedHashSet<>();

    ImmutableReportGridMember.Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);
    members.add(
        roleResult
            .user(
                ImmutablePerson.builder()
                    .departmentName("Department Name")
                    .displayName("Display Name")
                    .email("jane.doe@example.org")
                    .employeeId("42")
                    .id(1L)
                    .isRemoved(true)
                    .kind(EntityKind.ALL)
                    .managerEmployeeId("42")
                    .mobilePhone("6625550144")
                    .officePhone("6625550144")
                    .organisationalUnitId(1L)
                    .personKind(PersonKind.EMPLOYEE)
                    .title("Dr")
                    .userId("42")
                    .userPrincipalName("User Principal Name")
                    .build())
            .build());
    members.add(new ImmutableReportGridMember.Json());

    Json json = new Json();
    json.setDefinition(new ImmutableReportGridDefinition.Json());
    json.setInstance(new ImmutableReportGridInstance.Json());
    json.setMembers(members);
    json.setUserRole(ReportGridMemberRole.VIEWER);

    // Act
    ImmutableReportGrid actualFromJsonResult = ImmutableReportGrid.fromJson(json);

    // Assert
    ReportGridInstance instanceResult = actualFromJsonResult.instance();
    assertTrue(instanceResult instanceof ImmutableReportGridInstance.Json);
    Set<ReportGridCell> reportGridCellSet =
        ((ImmutableReportGridInstance.Json) instanceResult).cellData;
    assertTrue(reportGridCellSet.isEmpty());
    assertEquals(members, actualFromJsonResult.members());
    assertSame(
        reportGridCellSet, ((ImmutableReportGridInstance.Json) instanceResult).ratingSchemeItems);
    assertSame(reportGridCellSet, ((ImmutableReportGridInstance.Json) instanceResult).subjects);
  }

  /**
   * Test {@link ImmutableReportGrid#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) UserRole is {@code null}.
   *   <li>Then return members size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGrid#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) UserRole is 'null'; then return members size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGrid ImmutableReportGrid.fromJson(Json)"})
  void testFromJson_whenJsonUserRoleIsNull_thenReturnMembersSizeIsOne() {
    // Arrange
    LinkedHashSet<ReportGridMember> members = new LinkedHashSet<>();
    members.add(new ImmutableReportGridMember.Json());

    Json json = new Json();
    json.setDefinition(new ImmutableReportGridDefinition.Json());
    json.setInstance(new ImmutableReportGridInstance.Json());
    json.setMembers(members);
    json.setUserRole(null);

    // Act
    ImmutableReportGrid actualFromJsonResult = ImmutableReportGrid.fromJson(json);

    // Assert
    ReportGridInstance instanceResult = actualFromJsonResult.instance();
    assertTrue(instanceResult instanceof ImmutableReportGridInstance.Json);
    assertEquals(1, actualFromJsonResult.members().size());
    Set<ReportGridCell> reportGridCellSet =
        ((ImmutableReportGridInstance.Json) instanceResult).cellData;
    assertTrue(reportGridCellSet.isEmpty());
    assertSame(
        reportGridCellSet, ((ImmutableReportGridInstance.Json) instanceResult).ratingSchemeItems);
    assertSame(reportGridCellSet, ((ImmutableReportGridInstance.Json) instanceResult).subjects);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGrid#toString()}
   *   <li>{@link ImmutableReportGrid#definition()}
   *   <li>{@link ImmutableReportGrid#instance()}
   *   <li>{@link ImmutableReportGrid#members()}
   *   <li>{@link ImmutableReportGrid#userRole()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridDefinition ImmutableReportGrid.definition()",
    "ReportGridInstance ImmutableReportGrid.instance()",
    "Set ImmutableReportGrid.members()",
    "String ImmutableReportGrid.toString()",
    "ReportGridMemberRole ImmutableReportGrid.userRole()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();
    ImmutableReportGrid immutableReportGrid =
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();

    // Act
    String actualToStringResult = immutableReportGrid.toString();
    ReportGridDefinition actualDefinitionResult = immutableReportGrid.definition();
    ReportGridInstance actualInstanceResult = immutableReportGrid.instance();
    Set<ReportGridMember> actualMembersResult = immutableReportGrid.members();

    // Assert
    assertTrue(actualDefinitionResult instanceof ImmutableReportGridDefinition);
    assertTrue(actualInstanceResult instanceof ImmutableReportGridInstance);
    assertEquals(
        "ReportGrid{definition=ReportGridDefinition{id=1, name=Name, lastUpdatedAt=1970-01-01T00:00,"
            + " lastUpdatedBy=2020-03-01, provenance=Provenance, externalId=42, fixedColumnDefinitions=[],"
            + " derivedColumnDefinitions=[], subjectKind=ALL, kind=PUBLIC}, instance=ReportGridInstance{subjects=[],"
            + " ratingSchemeItems=[], cellData=[]}, members=[], userRole=VIEWER}",
        actualToStringResult);
    assertEquals(ReportGridMemberRole.VIEWER, immutableReportGrid.userRole());
    assertSame(actualInstanceResult.cellData(), actualMembersResult);
  }

  /**
   * Test Json {@link Json#definition()}.
   *
   * <p>Method under test: {@link Json#definition()}
   */
  @Test
  @DisplayName("Test Json definition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridDefinition Json.definition()"})
  void testJsonDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().definition());
  }

  /**
   * Test Json {@link Json#instance()}.
   *
   * <p>Method under test: {@link Json#instance()}
   */
  @Test
  @DisplayName("Test Json instance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridInstance Json.instance()"})
  void testJsonInstance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().instance());
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
  @MethodsUnderTest({"Set Json.members()"})
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
    assertNull(actualJson.definition);
    assertNull(actualJson.instance);
    assertNull(actualJson.userRole);
    assertTrue(actualJson.members.isEmpty());
  }

  /**
   * Test Json {@link Json#userRole()}.
   *
   * <p>Method under test: {@link Json#userRole()}
   */
  @Test
  @DisplayName("Test Json userRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridMemberRole Json.userRole()"})
  void testJsonUserRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().userRole());
  }

  /**
   * Test {@link ImmutableReportGrid#withDefinition(ReportGridDefinition)}.
   *
   * <p>Method under test: {@link ImmutableReportGrid#withDefinition(ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test withDefinition(ReportGridDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGrid ImmutableReportGrid.withDefinition(ReportGridDefinition)"
  })
  void testWithDefinition() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();
    ImmutableReportGrid immutableReportGrid =
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();

    // Act
    ImmutableReportGrid actualWithDefinitionResult =
        immutableReportGrid.withDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    // Assert
    assertEquals(immutableReportGrid, actualWithDefinitionResult);
  }

  /**
   * Test {@link ImmutableReportGrid#withInstance(ReportGridInstance)}.
   *
   * <p>Method under test: {@link ImmutableReportGrid#withInstance(ReportGridInstance)}
   */
  @Test
  @DisplayName("Test withInstance(ReportGridInstance)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGrid ImmutableReportGrid.withInstance(ReportGridInstance)"})
  void testWithInstance() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();
    ImmutableReportGrid immutableReportGrid =
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();

    // Act
    ImmutableReportGrid actualWithInstanceResult =
        immutableReportGrid.withInstance(ImmutableReportGridInstance.builder().build());

    // Assert
    assertEquals(immutableReportGrid, actualWithInstanceResult);
  }

  /**
   * Test {@link ImmutableReportGrid#withMembers(ReportGridMember[])} with {@code
   * ReportGridMember[]}.
   *
   * <p>Method under test: {@link ImmutableReportGrid#withMembers(ReportGridMember[])}
   */
  @Test
  @DisplayName("Test withMembers(ReportGridMember[]) with 'ReportGridMember[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGrid ImmutableReportGrid.withMembers(ReportGridMember[])"})
  void testWithMembersWithReportGridMember() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();
    ImmutableReportGrid immutableReportGrid =
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();

    ImmutableReportGridMember.Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);

    // Act
    ImmutableReportGrid actualWithMembersResult =
        immutableReportGrid.withMembers(
            roleResult
                .user(
                    ImmutablePerson.builder()
                        .departmentName("Department Name")
                        .displayName("Display Name")
                        .email("jane.doe@example.org")
                        .employeeId("42")
                        .id(1L)
                        .isRemoved(true)
                        .kind(EntityKind.ALL)
                        .managerEmployeeId("42")
                        .mobilePhone("6625550144")
                        .officePhone("6625550144")
                        .organisationalUnitId(1L)
                        .personKind(PersonKind.EMPLOYEE)
                        .title("Dr")
                        .userId("42")
                        .userPrincipalName("User Principal Name")
                        .build())
                .build());

    // Assert
    ReportGridDefinition definitionResult = actualWithMembersResult.definition();
    assertTrue(definitionResult instanceof ImmutableReportGridDefinition);
    ReportGridInstance instanceResult = actualWithMembersResult.instance();
    assertTrue(instanceResult instanceof ImmutableReportGridInstance);
    assertEquals("2020-03-01", definitionResult.lastUpdatedBy());
    assertEquals("Name", definitionResult.name());
    assertEquals("Provenance", definitionResult.provenance());
    assertEquals("The characteristics of someone or something", definitionResult.description());
    assertEquals(1, actualWithMembersResult.members().size());
    assertEquals(EntityKind.ALL, definitionResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, definitionResult.kind());
    assertEquals(ReportGridMemberRole.VIEWER, actualWithMembersResult.userRole());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        definitionResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    Set<ReportGridCell> cellDataResult = instanceResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, definitionResult.fixedColumnDefinitions());
    assertSame(cellDataResult, instanceResult.ratingSchemeItems());
    assertSame(cellDataResult, instanceResult.subjects());
  }

  /**
   * Test {@link ImmutableReportGrid#withUserRole(ReportGridMemberRole)}.
   *
   * <p>Method under test: {@link ImmutableReportGrid#withUserRole(ReportGridMemberRole)}
   */
  @Test
  @DisplayName("Test withUserRole(ReportGridMemberRole)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGrid ImmutableReportGrid.withUserRole(ReportGridMemberRole)"})
  void testWithUserRole() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();
    ImmutableReportGrid immutableReportGrid =
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();

    // Act
    ImmutableReportGrid actualWithUserRoleResult =
        immutableReportGrid.withUserRole(ReportGridMemberRole.VIEWER);

    // Assert
    assertSame(immutableReportGrid, actualWithUserRoleResult);
  }
}
