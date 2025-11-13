package org.finos.waltz.model.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.involvement.ImmutableInvolvementDetailByDirectionResults.Builder;
import org.finos.waltz.model.involvement.ImmutableInvolvementDetailByDirectionResults.Json;
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKind;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.PersonKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementDetailByDirectionResultsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAncestors(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAncestors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAncestors(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAncestors(Iterable)"})
  void testBuilderAddAllAncestors_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualAddAllAncestorsResult = builderResult.addAllAncestors(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAncestorsResult);
  }

  /**
   * Test Builder {@link Builder#addAllDescendents(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllDescendents(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDescendents(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllDescendents(Iterable)"})
  void testBuilderAddAllDescendents_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualAddAllDescendentsResult = builderResult.addAllDescendents(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllDescendentsResult);
  }

  /**
   * Test Builder {@link Builder#addAllExact(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllExact(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllExact(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllExact(Iterable)"})
  void testBuilderAddAllExact_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualAddAllExactResult = builderResult.addAllExact(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllExactResult);
  }

  /**
   * Test Builder {@link Builder#addAncestors(InvolvementDetail)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addAncestors(InvolvementDetail)}
   */
  @Test
  @DisplayName("Test Builder addAncestors(InvolvementDetail) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAncestors(InvolvementDetail)"})
  void testBuilderAddAncestorsWithElement() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualAddAncestorsResult =
        builderResult.addAncestors(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().ancestors().size());
    assertSame(builderResult, actualAddAncestorsResult);
  }

  /**
   * Test Builder {@link Builder#addAncestors(InvolvementDetail[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addAncestors(InvolvementDetail[])}
   */
  @Test
  @DisplayName("Test Builder addAncestors(InvolvementDetail[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAncestors(InvolvementDetail[])"})
  void testBuilderAddAncestorsWithElements() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualAddAncestorsResult =
        builderResult.addAncestors(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().ancestors().size());
    assertSame(builderResult, actualAddAncestorsResult);
  }

  /**
   * Test Builder {@link Builder#addDescendents(InvolvementDetail)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addDescendents(InvolvementDetail)}
   */
  @Test
  @DisplayName("Test Builder addDescendents(InvolvementDetail) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDescendents(InvolvementDetail)"})
  void testBuilderAddDescendentsWithElement() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualAddDescendentsResult =
        builderResult.addDescendents(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().descendents().size());
    assertSame(builderResult, actualAddDescendentsResult);
  }

  /**
   * Test Builder {@link Builder#addDescendents(InvolvementDetail[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addDescendents(InvolvementDetail[])}
   */
  @Test
  @DisplayName("Test Builder addDescendents(InvolvementDetail[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDescendents(InvolvementDetail[])"})
  void testBuilderAddDescendentsWithElements() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualAddDescendentsResult =
        builderResult.addDescendents(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().descendents().size());
    assertSame(builderResult, actualAddDescendentsResult);
  }

  /**
   * Test Builder {@link Builder#addExact(InvolvementDetail)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addExact(InvolvementDetail)}
   */
  @Test
  @DisplayName("Test Builder addExact(InvolvementDetail) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addExact(InvolvementDetail)"})
  void testBuilderAddExactWithElement() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualAddExactResult = builderResult.addExact(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().exact().size());
    assertSame(builderResult, actualAddExactResult);
  }

  /**
   * Test Builder {@link Builder#addExact(InvolvementDetail[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addExact(InvolvementDetail[])}
   */
  @Test
  @DisplayName("Test Builder addExact(InvolvementDetail[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addExact(InvolvementDetail[])"})
  void testBuilderAddExactWithElements() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualAddExactResult = builderResult.addExact(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().exact().size());
    assertSame(builderResult, actualAddExactResult);
  }

  /**
   * Test Builder {@link Builder#ancestors(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ancestors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ancestors(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ancestors(Iterable)"})
  void testBuilderAncestors_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualAncestorsResult = builderResult.ancestors(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAncestorsResult);
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
  @MethodsUnderTest({"ImmutableInvolvementDetailByDirectionResults Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableInvolvementDetailByDirectionResults.builder().build().ancestors().isEmpty());
  }

  /**
   * Test Builder {@link Builder#descendents(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#descendents(Iterable)}
   */
  @Test
  @DisplayName("Test Builder descendents(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.descendents(Iterable)"})
  void testBuilderDescendents_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualDescendentsResult = builderResult.descendents(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualDescendentsResult);
  }

  /**
   * Test Builder {@link Builder#exact(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#exact(Iterable)}
   */
  @Test
  @DisplayName("Test Builder exact(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.exact(Iterable)"})
  void testBuilderExact_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualExactResult = builderResult.exact(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualExactResult);
  }

  /**
   * Test Builder {@link Builder#from(InvolvementDetailByDirectionResults)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(InvolvementDetailByDirectionResults)}
   */
  @Test
  @DisplayName(
      "Test Builder from(InvolvementDetailByDirectionResults); when builder build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(InvolvementDetailByDirectionResults)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(ImmutableInvolvementDetailByDirectionResults.builder().build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link
   * ImmutableInvolvementDetailByDirectionResults#copyOf(InvolvementDetailByDirectionResults)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return ancestors Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableInvolvementDetailByDirectionResults#copyOf(InvolvementDetailByDirectionResults)}
   */
  @Test
  @DisplayName(
      "Test copyOf(InvolvementDetailByDirectionResults); when builder build; then return ancestors Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.copyOf(InvolvementDetailByDirectionResults)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnAncestorsEmpty() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults instance =
        ImmutableInvolvementDetailByDirectionResults.builder().build();

    // Act
    ImmutableInvolvementDetailByDirectionResults actualCopyOfResult =
        ImmutableInvolvementDetailByDirectionResults.copyOf(instance);

    // Assert
    Set<InvolvementDetail> ancestorsResult = actualCopyOfResult.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualCopyOfResult.descendents());
    assertSame(ancestorsResult, actualCopyOfResult.exact());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}, and {@link
   * ImmutableInvolvementDetailByDirectionResults#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}
   *   <li>{@link ImmutableInvolvementDetailByDirectionResults#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementDetailByDirectionResults.equals(Object)",
    "int ImmutableInvolvementDetailByDirectionResults.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults immutableInvolvementDetailByDirectionResults =
        ImmutableInvolvementDetailByDirectionResults.builder().build();
    ImmutableInvolvementDetailByDirectionResults immutableInvolvementDetailByDirectionResults2 =
        ImmutableInvolvementDetailByDirectionResults.builder().build();

    // Act and Assert
    assertEquals(
        immutableInvolvementDetailByDirectionResults,
        immutableInvolvementDetailByDirectionResults2);
    assertEquals(
        immutableInvolvementDetailByDirectionResults.hashCode(),
        immutableInvolvementDetailByDirectionResults2.hashCode());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}, and {@link
   * ImmutableInvolvementDetailByDirectionResults#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}
   *   <li>{@link ImmutableInvolvementDetailByDirectionResults#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementDetailByDirectionResults.equals(Object)",
    "int ImmutableInvolvementDetailByDirectionResults.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults immutableInvolvementDetailByDirectionResults =
        ImmutableInvolvementDetailByDirectionResults.builder().build();

    // Act and Assert
    assertEquals(
        immutableInvolvementDetailByDirectionResults, immutableInvolvementDetailByDirectionResults);
    int expectedHashCodeResult = immutableInvolvementDetailByDirectionResults.hashCode();
    assertEquals(expectedHashCodeResult, immutableInvolvementDetailByDirectionResults.hashCode());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementDetailByDirectionResults.equals(Object)",
    "int ImmutableInvolvementDetailByDirectionResults.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    ImmutableInvolvementDetail.Builder builderResult2 = ImmutableInvolvementDetail.builder();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    ImmutableInvolvementDetail.Builder involvementResult =
        builderResult2.involvement(
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

    ImmutableInvolvementDetail.Builder involvementKindResult =
        involvementResult.involvementKind(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());
    builderResult.addAncestors(
        involvementKindResult
            .person(
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

    // Act and Assert
    assertNotEquals(
        builderResult.build(), ImmutableInvolvementDetailByDirectionResults.builder().build());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementDetailByDirectionResults.equals(Object)",
    "int ImmutableInvolvementDetailByDirectionResults.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    ImmutableInvolvementDetail.Builder builderResult2 = ImmutableInvolvementDetail.builder();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    ImmutableInvolvementDetail.Builder involvementResult =
        builderResult2.involvement(
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

    ImmutableInvolvementDetail.Builder involvementKindResult =
        involvementResult.involvementKind(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());
    builderResult.addDescendents(
        involvementKindResult
            .person(
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

    // Act and Assert
    assertNotEquals(
        builderResult.build(), ImmutableInvolvementDetailByDirectionResults.builder().build());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementDetailByDirectionResults.equals(Object)",
    "int ImmutableInvolvementDetailByDirectionResults.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    ImmutableInvolvementDetail.Builder builderResult2 = ImmutableInvolvementDetail.builder();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    ImmutableInvolvementDetail.Builder involvementResult =
        builderResult2.involvement(
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

    ImmutableInvolvementDetail.Builder involvementKindResult =
        involvementResult.involvementKind(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());
    builderResult.addExact(
        involvementKindResult
            .person(
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

    // Act and Assert
    assertNotEquals(
        builderResult.build(), ImmutableInvolvementDetailByDirectionResults.builder().build());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementDetailByDirectionResults.equals(Object)",
    "int ImmutableInvolvementDetailByDirectionResults.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableInvolvementDetailByDirectionResults.builder().build(), null);
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementDetailByDirectionResults.equals(Object)",
    "int ImmutableInvolvementDetailByDirectionResults.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableInvolvementDetailByDirectionResults.builder().build(),
        "Different type to ImmutableInvolvementDetailByDirectionResults");
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Ancestors is {@code null}.
   *   <li>Then return ancestors Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Ancestors is 'null'; then return ancestors Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonAncestorsIsNull_thenReturnAncestorsEmpty() {
    // Arrange
    LinkedHashSet<InvolvementDetail> descendents = new LinkedHashSet<>();
    descendents.add(new ImmutableInvolvementDetail.Json());

    LinkedHashSet<InvolvementDetail> exact = new LinkedHashSet<>();
    exact.add(new ImmutableInvolvementDetail.Json());

    Json json = new Json();
    json.setAncestors(null);
    json.setDescendents(descendents);
    json.setExact(exact);

    // Act
    ImmutableInvolvementDetailByDirectionResults actualFromJsonResult =
        ImmutableInvolvementDetailByDirectionResults.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.descendents().size());
    assertEquals(1, actualFromJsonResult.exact().size());
    assertTrue(actualFromJsonResult.ancestors().isEmpty());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Descendents is {@code null}.
   *   <li>Then return descendents Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Descendents is 'null'; then return descendents Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonDescendentsIsNull_thenReturnDescendentsEmpty() {
    // Arrange
    LinkedHashSet<InvolvementDetail> ancestors = new LinkedHashSet<>();
    ancestors.add(new ImmutableInvolvementDetail.Json());

    LinkedHashSet<InvolvementDetail> exact = new LinkedHashSet<>();
    exact.add(new ImmutableInvolvementDetail.Json());

    Json json = new Json();
    json.setAncestors(ancestors);
    json.setDescendents(null);
    json.setExact(exact);

    // Act
    ImmutableInvolvementDetailByDirectionResults actualFromJsonResult =
        ImmutableInvolvementDetailByDirectionResults.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.ancestors().size());
    assertEquals(1, actualFromJsonResult.exact().size());
    assertTrue(actualFromJsonResult.descendents().isEmpty());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Exact is {@code null}.
   *   <li>Then return exact Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Exact is 'null'; then return exact Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonExactIsNull_thenReturnExactEmpty() {
    // Arrange
    LinkedHashSet<InvolvementDetail> ancestors = new LinkedHashSet<>();
    ancestors.add(new ImmutableInvolvementDetail.Json());

    LinkedHashSet<InvolvementDetail> descendents = new LinkedHashSet<>();
    descendents.add(new ImmutableInvolvementDetail.Json());

    Json json = new Json();
    json.setAncestors(ancestors);
    json.setDescendents(descendents);
    json.setExact(null);

    // Act
    ImmutableInvolvementDetailByDirectionResults actualFromJsonResult =
        ImmutableInvolvementDetailByDirectionResults.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.ancestors().size());
    assertEquals(1, actualFromJsonResult.descendents().size());
    assertTrue(actualFromJsonResult.exact().isEmpty());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return ancestors is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return ancestors is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.fromJson(Json)"
  })
  void testFromJson_thenReturnAncestorsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<InvolvementDetail> ancestors = new LinkedHashSet<>();

    ImmutableInvolvementDetail.Builder builderResult = ImmutableInvolvementDetail.builder();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    ImmutableInvolvementDetail.Builder involvementResult =
        builderResult.involvement(
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

    ImmutableInvolvementDetail.Builder involvementKindResult =
        involvementResult.involvementKind(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());
    ancestors.add(
        involvementKindResult
            .person(
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
    ancestors.add(new ImmutableInvolvementDetail.Json());

    LinkedHashSet<InvolvementDetail> descendents = new LinkedHashSet<>();
    descendents.add(new ImmutableInvolvementDetail.Json());

    LinkedHashSet<InvolvementDetail> exact = new LinkedHashSet<>();
    exact.add(new ImmutableInvolvementDetail.Json());

    Json json = new Json();
    json.setAncestors(ancestors);
    json.setDescendents(descendents);
    json.setExact(exact);

    // Act
    ImmutableInvolvementDetailByDirectionResults actualFromJsonResult =
        ImmutableInvolvementDetailByDirectionResults.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.descendents().size());
    assertEquals(1, actualFromJsonResult.exact().size());
    assertEquals(ancestors, actualFromJsonResult.ancestors());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Ancestors is {@link
   *       LinkedHashSet#LinkedHashSet()}.
   *   <li>Then return ancestors size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Ancestors is LinkedHashSet(); then return ancestors size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.fromJson(Json)"
  })
  void testFromJson_whenJsonAncestorsIsLinkedHashSet_thenReturnAncestorsSizeIsOne() {
    // Arrange
    LinkedHashSet<InvolvementDetail> ancestors = new LinkedHashSet<>();
    ancestors.add(new ImmutableInvolvementDetail.Json());

    LinkedHashSet<InvolvementDetail> descendents = new LinkedHashSet<>();
    descendents.add(new ImmutableInvolvementDetail.Json());

    LinkedHashSet<InvolvementDetail> exact = new LinkedHashSet<>();
    exact.add(new ImmutableInvolvementDetail.Json());

    Json json = new Json();
    json.setAncestors(ancestors);
    json.setDescendents(descendents);
    json.setExact(exact);

    // Act
    ImmutableInvolvementDetailByDirectionResults actualFromJsonResult =
        ImmutableInvolvementDetailByDirectionResults.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.ancestors().size());
    assertEquals(1, actualFromJsonResult.descendents().size());
    assertEquals(1, actualFromJsonResult.exact().size());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return descendents is {@link Json} (default constructor) {@link Json#exact}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return descendents is Json (default constructor) exact")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnDescendentsIsJsonExact() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableInvolvementDetailByDirectionResults actualFromJsonResult =
        ImmutableInvolvementDetailByDirectionResults.fromJson(json);

    // Assert
    Set<InvolvementDetail> involvementDetailSet = json.exact;
    assertSame(involvementDetailSet, actualFromJsonResult.descendents());
    assertSame(involvementDetailSet, actualFromJsonResult.exact());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementDetailByDirectionResults#toString()}
   *   <li>{@link ImmutableInvolvementDetailByDirectionResults#ancestors()}
   *   <li>{@link ImmutableInvolvementDetailByDirectionResults#descendents()}
   *   <li>{@link ImmutableInvolvementDetailByDirectionResults#exact()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableInvolvementDetailByDirectionResults.ancestors()",
    "Set ImmutableInvolvementDetailByDirectionResults.descendents()",
    "Set ImmutableInvolvementDetailByDirectionResults.exact()",
    "String ImmutableInvolvementDetailByDirectionResults.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults immutableInvolvementDetailByDirectionResults =
        ImmutableInvolvementDetailByDirectionResults.builder().build();

    // Act
    String actualToStringResult = immutableInvolvementDetailByDirectionResults.toString();
    Set<InvolvementDetail> actualAncestorsResult =
        immutableInvolvementDetailByDirectionResults.ancestors();
    Set<InvolvementDetail> actualDescendentsResult =
        immutableInvolvementDetailByDirectionResults.descendents();
    Set<InvolvementDetail> actualExactResult = immutableInvolvementDetailByDirectionResults.exact();

    // Assert
    assertEquals(
        "InvolvementDetailByDirectionResults{ancestors=[], descendents=[], exact=[]}",
        actualToStringResult);
    assertTrue(actualAncestorsResult.isEmpty());
    assertSame(actualAncestorsResult, actualDescendentsResult);
    assertSame(actualAncestorsResult, actualExactResult);
  }

  /**
   * Test Json {@link Json#ancestors()}.
   *
   * <p>Method under test: {@link Json#ancestors()}
   */
  @Test
  @DisplayName("Test Json ancestors()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.ancestors()"})
  void testJsonAncestors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ancestors());
  }

  /**
   * Test Json {@link Json#descendents()}.
   *
   * <p>Method under test: {@link Json#descendents()}
   */
  @Test
  @DisplayName("Test Json descendents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.descendents()"})
  void testJsonDescendents() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().descendents());
  }

  /**
   * Test Json {@link Json#exact()}.
   *
   * <p>Method under test: {@link Json#exact()}
   */
  @Test
  @DisplayName("Test Json exact()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.exact()"})
  void testJsonExact() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().exact());
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
    assertTrue(actualJson.ancestors.isEmpty());
    assertTrue(actualJson.descendents.isEmpty());
    assertTrue(actualJson.exact.isEmpty());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#withAncestors(InvolvementDetail[])}
   * with {@code InvolvementDetail[]}.
   *
   * <p>Method under test: {@link
   * ImmutableInvolvementDetailByDirectionResults#withAncestors(InvolvementDetail[])}
   */
  @Test
  @DisplayName("Test withAncestors(InvolvementDetail[]) with 'InvolvementDetail[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.withAncestors(InvolvementDetail[])"
  })
  void testWithAncestorsWithInvolvementDetail() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults immutableInvolvementDetailByDirectionResults =
        ImmutableInvolvementDetailByDirectionResults.builder().build();

    ImmutableInvolvementDetail.Builder builderResult = ImmutableInvolvementDetail.builder();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    ImmutableInvolvementDetail.Builder involvementResult =
        builderResult.involvement(
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

    ImmutableInvolvementDetail.Builder involvementKindResult =
        involvementResult.involvementKind(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    // Act
    ImmutableInvolvementDetailByDirectionResults actualWithAncestorsResult =
        immutableInvolvementDetailByDirectionResults.withAncestors(
            involvementKindResult
                .person(
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
    assertEquals(1, actualWithAncestorsResult.ancestors().size());
    Set<InvolvementDetail> descendentsResult = actualWithAncestorsResult.descendents();
    assertTrue(descendentsResult.isEmpty());
    assertSame(descendentsResult, actualWithAncestorsResult.exact());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#withDescendents(InvolvementDetail[])}
   * with {@code InvolvementDetail[]}.
   *
   * <p>Method under test: {@link
   * ImmutableInvolvementDetailByDirectionResults#withDescendents(InvolvementDetail[])}
   */
  @Test
  @DisplayName("Test withDescendents(InvolvementDetail[]) with 'InvolvementDetail[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.withDescendents(InvolvementDetail[])"
  })
  void testWithDescendentsWithInvolvementDetail() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults immutableInvolvementDetailByDirectionResults =
        ImmutableInvolvementDetailByDirectionResults.builder().build();

    ImmutableInvolvementDetail.Builder builderResult = ImmutableInvolvementDetail.builder();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    ImmutableInvolvementDetail.Builder involvementResult =
        builderResult.involvement(
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

    ImmutableInvolvementDetail.Builder involvementKindResult =
        involvementResult.involvementKind(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    // Act
    ImmutableInvolvementDetailByDirectionResults actualWithDescendentsResult =
        immutableInvolvementDetailByDirectionResults.withDescendents(
            involvementKindResult
                .person(
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
    assertEquals(1, actualWithDescendentsResult.descendents().size());
    Set<InvolvementDetail> ancestorsResult = actualWithDescendentsResult.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualWithDescendentsResult.exact());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#withExact(InvolvementDetail[])} with
   * {@code InvolvementDetail[]}.
   *
   * <p>Method under test: {@link
   * ImmutableInvolvementDetailByDirectionResults#withExact(InvolvementDetail[])}
   */
  @Test
  @DisplayName("Test withExact(InvolvementDetail[]) with 'InvolvementDetail[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.withExact(InvolvementDetail[])"
  })
  void testWithExactWithInvolvementDetail() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults immutableInvolvementDetailByDirectionResults =
        ImmutableInvolvementDetailByDirectionResults.builder().build();

    ImmutableInvolvementDetail.Builder builderResult = ImmutableInvolvementDetail.builder();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    ImmutableInvolvementDetail.Builder involvementResult =
        builderResult.involvement(
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

    ImmutableInvolvementDetail.Builder involvementKindResult =
        involvementResult.involvementKind(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    // Act
    ImmutableInvolvementDetailByDirectionResults actualWithExactResult =
        immutableInvolvementDetailByDirectionResults.withExact(
            involvementKindResult
                .person(
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
    assertEquals(1, actualWithExactResult.exact().size());
    Set<InvolvementDetail> ancestorsResult = actualWithExactResult.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualWithExactResult.descendents());
  }
}
