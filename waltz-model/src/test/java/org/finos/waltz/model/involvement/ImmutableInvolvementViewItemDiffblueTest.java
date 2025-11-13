package org.finos.waltz.model.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.involvement.ImmutableInvolvementViewItem.Builder;
import org.finos.waltz.model.involvement.ImmutableInvolvementViewItem.Json;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.person.PersonKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementViewItemDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementViewItem Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableInvolvementViewItem.builder();
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
    Builder actualInvolvementResult = actualBuilderResult.involvement(involvement);
    ImmutablePerson person =
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
            .build();
    ImmutableInvolvementViewItem actualImmutableInvolvementViewItem =
        actualInvolvementResult.person(person).build();

    // Assert
    assertSame(involvement, actualImmutableInvolvementViewItem.involvement());
    assertSame(person, actualImmutableInvolvementViewItem.person());
  }

  /**
   * Test Builder {@link Builder#from(InvolvementViewItem)}.
   *
   * <p>Method under test: {@link Builder#from(InvolvementViewItem)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementViewItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(InvolvementViewItem)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableInvolvementViewItem.builder();

    Builder builderResult2 = ImmutableInvolvementViewItem.builder();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    Builder involvementResult =
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
    ImmutableInvolvementViewItem instance =
        involvementResult
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableInvolvementViewItem actualImmutableInvolvementViewItem = builderResult.build();
    assertEquals(instance, actualImmutableInvolvementViewItem);
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
    Builder builderResult = ImmutableInvolvementViewItem.builder();

    // Act
    Builder actualInvolvementResult = builderResult.involvement(new ImmutableInvolvement.Json());

    // Assert
    assertSame(builderResult, actualInvolvementResult);
  }

  /**
   * Test Builder {@link Builder#person(Person)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#person(Person)}
   */
  @Test
  @DisplayName("Test Builder person(Person); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.person(Person)"})
  void testBuilderPerson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementViewItem.builder();

    // Act
    Builder actualPersonResult =
        builderResult.person(
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
                .build());

    // Assert
    assertSame(builderResult, actualPersonResult);
  }

  /**
   * Test {@link ImmutableInvolvementViewItem#copyOf(InvolvementViewItem)}.
   *
   * <ul>
   *   <li>Then involvement entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementViewItem#copyOf(InvolvementViewItem)}
   */
  @Test
  @DisplayName(
      "Test copyOf(InvolvementViewItem); then involvement entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementViewItem ImmutableInvolvementViewItem.copyOf(InvolvementViewItem)"
  })
  void testCopyOf_thenInvolvementEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableInvolvementViewItem.builder();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    Builder involvementResult =
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
    ImmutableInvolvementViewItem instance =
        involvementResult
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
            .build();

    // Act
    ImmutableInvolvementViewItem actualCopyOfResult = ImmutableInvolvementViewItem.copyOf(instance);

    // Assert
    Involvement involvementResult2 = actualCopyOfResult.involvement();
    assertTrue(involvementResult2.entityReference() instanceof ImmutableEntityReference);
    assertTrue(involvementResult2 instanceof ImmutableInvolvement);
    Person personResult = actualCopyOfResult.person();
    assertTrue(personResult instanceof ImmutablePerson);
    assertEquals("42", involvementResult2.employeeId());
    assertEquals("42", personResult.employeeId());
    assertEquals("42", personResult.userId());
    assertEquals("Display Name", personResult.displayName());
    assertEquals("Display Name", personResult.name());
    assertEquals("Provenance", involvementResult2.provenance());
    assertEquals("jane.doe@example.org", personResult.email());
    assertEquals(1L, involvementResult2.kindId());
    assertEquals(EntityKind.ALL, personResult.kind());
    assertEquals(PersonKind.EMPLOYEE, personResult.personKind());
    assertTrue(involvementResult2.isReadOnly());
    assertTrue(personResult.isRemoved());
  }

  /**
   * Test {@link ImmutableInvolvementViewItem#equals(Object)}, and {@link
   * ImmutableInvolvementViewItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementViewItem#equals(Object)}
   *   <li>{@link ImmutableInvolvementViewItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementViewItem.equals(Object)",
    "int ImmutableInvolvementViewItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableInvolvementViewItem.builder();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    Builder involvementResult =
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
    ImmutableInvolvementViewItem immutableInvolvementViewItem =
        involvementResult
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
            .build();

    Builder builderResult2 = ImmutableInvolvementViewItem.builder();

    ImmutableInvolvement.Builder employeeIdResult2 =
        ImmutableInvolvement.builder().employeeId("42");

    Builder involvementResult2 =
        builderResult2.involvement(
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
    ImmutableInvolvementViewItem immutableInvolvementViewItem2 =
        involvementResult2
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
            .build();

    // Act and Assert
    assertEquals(immutableInvolvementViewItem, immutableInvolvementViewItem2);
    assertEquals(immutableInvolvementViewItem.hashCode(), immutableInvolvementViewItem2.hashCode());
  }

  /**
   * Test {@link ImmutableInvolvementViewItem#equals(Object)}, and {@link
   * ImmutableInvolvementViewItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementViewItem#equals(Object)}
   *   <li>{@link ImmutableInvolvementViewItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementViewItem.equals(Object)",
    "int ImmutableInvolvementViewItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableInvolvementViewItem.builder();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    Builder involvementResult =
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
    ImmutableInvolvementViewItem immutableInvolvementViewItem =
        involvementResult
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
            .build();

    // Act and Assert
    assertEquals(immutableInvolvementViewItem, immutableInvolvementViewItem);
    int expectedHashCodeResult = immutableInvolvementViewItem.hashCode();
    assertEquals(expectedHashCodeResult, immutableInvolvementViewItem.hashCode());
  }

  /**
   * Test {@link ImmutableInvolvementViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementViewItem.equals(Object)",
    "int ImmutableInvolvementViewItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableInvolvementViewItem.builder();

    ImmutableInvolvement.Builder employeeIdResult =
        ImmutableInvolvement.builder().employeeId("Provenance");

    Builder involvementResult =
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
    ImmutableInvolvementViewItem immutableInvolvementViewItem =
        involvementResult
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
            .build();

    Builder builderResult2 = ImmutableInvolvementViewItem.builder();

    ImmutableInvolvement.Builder employeeIdResult2 =
        ImmutableInvolvement.builder().employeeId("42");

    Builder involvementResult2 =
        builderResult2.involvement(
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

    // Act and Assert
    assertNotEquals(
        immutableInvolvementViewItem,
        involvementResult2
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
  }

  /**
   * Test {@link ImmutableInvolvementViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementViewItem.equals(Object)",
    "int ImmutableInvolvementViewItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableInvolvementViewItem.builder();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    Builder involvementResult =
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
    ImmutableInvolvementViewItem immutableInvolvementViewItem =
        involvementResult
            .person(
                ImmutablePerson.builder()
                    .departmentName("42")
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
            .build();

    Builder builderResult2 = ImmutableInvolvementViewItem.builder();

    ImmutableInvolvement.Builder employeeIdResult2 =
        ImmutableInvolvement.builder().employeeId("42");

    Builder involvementResult2 =
        builderResult2.involvement(
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

    // Act and Assert
    assertNotEquals(
        immutableInvolvementViewItem,
        involvementResult2
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
  }

  /**
   * Test {@link ImmutableInvolvementViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementViewItem.equals(Object)",
    "int ImmutableInvolvementViewItem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableInvolvementViewItem.builder();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    Builder involvementResult =
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

    // Act and Assert
    assertNotEquals(
        involvementResult
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
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableInvolvementViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementViewItem.equals(Object)",
    "int ImmutableInvolvementViewItem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableInvolvementViewItem.builder();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    Builder involvementResult =
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

    // Act and Assert
    assertNotEquals(
        involvementResult
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
            .build(),
        "Different type to ImmutableInvolvementViewItem");
  }

  /**
   * Test {@link ImmutableInvolvementViewItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return involvement is {@link Json} (default constructor) {@link Json#involvement}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementViewItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return involvement is Json (default constructor) involvement")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementViewItem ImmutableInvolvementViewItem.fromJson(Json)"})
  void testFromJson_thenReturnInvolvementIsJsonInvolvement() {
    // Arrange
    Json json = new Json();

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
    json.setPerson(
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
            .build());

    // Act
    ImmutableInvolvementViewItem actualFromJsonResult = ImmutableInvolvementViewItem.fromJson(json);

    // Assert
    Involvement expectedInvolvementResult = json.involvement;
    assertSame(expectedInvolvementResult, actualFromJsonResult.involvement());
    Person expectedPersonResult = json.person;
    assertSame(expectedPersonResult, actualFromJsonResult.person());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementViewItem#toString()}
   *   <li>{@link ImmutableInvolvementViewItem#involvement()}
   *   <li>{@link ImmutableInvolvementViewItem#person()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Involvement ImmutableInvolvementViewItem.involvement()",
    "Person ImmutableInvolvementViewItem.person()",
    "String ImmutableInvolvementViewItem.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableInvolvementViewItem.builder();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    Builder involvementResult =
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
    ImmutableInvolvementViewItem immutableInvolvementViewItem =
        involvementResult
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
            .build();

    // Act
    String actualToStringResult = immutableInvolvementViewItem.toString();
    Involvement actualInvolvementResult = immutableInvolvementViewItem.involvement();

    // Assert
    assertTrue(actualInvolvementResult instanceof ImmutableInvolvement);
    assertTrue(immutableInvolvementViewItem.person() instanceof ImmutablePerson);
    assertEquals(
        "InvolvementViewItem{involvement=Involvement{kindId=1, entityReference=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, employeeId=42, isReadOnly=true, provenance=Provenance}, person=Person{id=1,"
            + " employeeId=42, displayName=Display Name, email=jane.doe@example.org, isRemoved=true, personKind=EMPLOYEE,"
            + " title=Dr, mobilePhone=6625550144, officePhone=6625550144, userPrincipalName=User Principal Name,"
            + " managerEmployeeId=42, departmentName=Department Name, organisationalUnitId=1, name=Display Name,"
            + " userId=42, kind=ALL}}",
        actualToStringResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setInvolvement(Involvement)}
   *   <li>{@link Json#setPerson(Person)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setInvolvement(Involvement)",
    "void Json.setPerson(Person)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
    actualJson.setPerson(
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
            .build());

    // Assert
    Involvement involvement = actualJson.involvement;
    EntityReference entityReferenceResult = involvement.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(involvement instanceof ImmutableInvolvement);
    Person person = actualJson.person;
    assertTrue(person instanceof ImmutablePerson);
    assertEquals("42", involvement.employeeId());
    assertEquals("42", person.employeeId());
    assertEquals("42", person.userId());
    assertEquals("Display Name", person.displayName());
    assertEquals("Display Name", person.name());
    assertEquals("Provenance", involvement.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("jane.doe@example.org", person.email());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, involvement.kindId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityKind.ALL, person.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(PersonKind.EMPLOYEE, person.personKind());
    assertTrue(involvement.isReadOnly());
    assertTrue(person.isRemoved());
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
   * Test Json {@link Json#person()}.
   *
   * <p>Method under test: {@link Json#person()}
   */
  @Test
  @DisplayName("Test Json person()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person Json.person()"})
  void testJsonPerson() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().person());
  }

  /**
   * Test {@link ImmutableInvolvementViewItem#withInvolvement(Involvement)}.
   *
   * <p>Method under test: {@link ImmutableInvolvementViewItem#withInvolvement(Involvement)}
   */
  @Test
  @DisplayName("Test withInvolvement(Involvement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementViewItem ImmutableInvolvementViewItem.withInvolvement(Involvement)"
  })
  void testWithInvolvement() {
    // Arrange
    Builder builderResult = ImmutableInvolvementViewItem.builder();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    Builder involvementResult =
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
    ImmutableInvolvementViewItem immutableInvolvementViewItem =
        involvementResult
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
            .build();

    ImmutableInvolvement.Builder employeeIdResult2 =
        ImmutableInvolvement.builder().employeeId("42");

    // Act
    ImmutableInvolvementViewItem actualWithInvolvementResult =
        immutableInvolvementViewItem.withInvolvement(
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
    assertEquals(immutableInvolvementViewItem, actualWithInvolvementResult);
  }

  /**
   * Test {@link ImmutableInvolvementViewItem#withPerson(Person)}.
   *
   * <p>Method under test: {@link ImmutableInvolvementViewItem#withPerson(Person)}
   */
  @Test
  @DisplayName("Test withPerson(Person)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementViewItem ImmutableInvolvementViewItem.withPerson(Person)"
  })
  void testWithPerson() {
    // Arrange
    Builder builderResult = ImmutableInvolvementViewItem.builder();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    Builder involvementResult =
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
    ImmutableInvolvementViewItem immutableInvolvementViewItem =
        involvementResult
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
            .build();

    // Act
    ImmutableInvolvementViewItem actualWithPersonResult =
        immutableInvolvementViewItem.withPerson(
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
                .build());

    // Assert
    assertEquals(immutableInvolvementViewItem, actualWithPersonResult);
  }
}
