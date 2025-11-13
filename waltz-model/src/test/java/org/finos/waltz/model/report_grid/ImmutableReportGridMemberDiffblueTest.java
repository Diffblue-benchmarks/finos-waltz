package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.model.report_grid.ImmutableReportGridMember.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridMember.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridMemberDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#role(ReportGridMemberRole)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMember Builder.build()",
    "Builder Builder.role(ReportGridMemberRole)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualRoleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);
    ImmutablePerson user =
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
    ImmutableReportGridMember actualImmutableReportGridMember = actualRoleResult.user(user).build();

    // Assert
    assertEquals(1L, actualImmutableReportGridMember.gridId().longValue());
    assertEquals(ReportGridMemberRole.VIEWER, actualImmutableReportGridMember.role());
    assertSame(user, actualImmutableReportGridMember.user());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridMember)}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridMember)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridMember)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridMember)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableReportGridMember.builder();

    Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);
    ImmutableReportGridMember instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridMember actualImmutableReportGridMember = builderResult.build();
    assertEquals(instance, actualImmutableReportGridMember);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#gridId(Long)}.
   *
   * <p>Method under test: {@link Builder#gridId(Long)}
   */
  @Test
  @DisplayName("Test Builder gridId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.gridId(Long)"})
  void testBuilderGridId() {
    // Arrange
    Builder builderResult = ImmutableReportGridMember.builder();

    // Act
    Builder actualGridIdResult = builderResult.gridId(1L);

    // Assert
    assertSame(builderResult, actualGridIdResult);
  }

  /**
   * Test Builder {@link Builder#user(Person)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#user(Person)}
   */
  @Test
  @DisplayName("Test Builder user(Person); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.user(Person)"})
  void testBuilderUser_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridMember.builder();

    // Act
    Builder actualUserResult =
        builderResult.user(
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
    assertSame(builderResult, actualUserResult);
  }

  /**
   * Test {@link ImmutableReportGridMember#copyOf(ReportGridMember)}.
   *
   * <ul>
   *   <li>Then user return {@link ImmutablePerson}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMember#copyOf(ReportGridMember)}
   */
  @Test
  @DisplayName("Test copyOf(ReportGridMember); then user return ImmutablePerson")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMember ImmutableReportGridMember.copyOf(ReportGridMember)"
  })
  void testCopyOf_thenUserReturnImmutablePerson() {
    // Arrange
    Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);
    ImmutableReportGridMember instance =
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
            .build();

    // Act
    ImmutableReportGridMember actualCopyOfResult = ImmutableReportGridMember.copyOf(instance);

    // Assert
    Person userResult = actualCopyOfResult.user();
    assertTrue(userResult instanceof ImmutablePerson);
    assertEquals("42", userResult.employeeId());
    assertEquals("42", userResult.userId());
    assertEquals("Display Name", userResult.displayName());
    assertEquals("Display Name", userResult.name());
    assertEquals("jane.doe@example.org", userResult.email());
    assertEquals(1L, actualCopyOfResult.gridId().longValue());
    assertEquals(EntityKind.ALL, userResult.kind());
    assertEquals(PersonKind.EMPLOYEE, userResult.personKind());
    assertEquals(ReportGridMemberRole.VIEWER, actualCopyOfResult.role());
    assertTrue(userResult.isRemoved());
  }

  /**
   * Test {@link ImmutableReportGridMember#equals(Object)}, and {@link
   * ImmutableReportGridMember#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridMember#equals(Object)}
   *   <li>{@link ImmutableReportGridMember#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMember.equals(Object)",
    "int ImmutableReportGridMember.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);
    ImmutableReportGridMember immutableReportGridMember =
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
            .build();

    Builder roleResult2 =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);
    ImmutableReportGridMember immutableReportGridMember2 =
        roleResult2
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
            .build();

    // Act and Assert
    assertEquals(immutableReportGridMember, immutableReportGridMember2);
    assertEquals(immutableReportGridMember.hashCode(), immutableReportGridMember2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridMember#equals(Object)}, and {@link
   * ImmutableReportGridMember#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridMember#equals(Object)}
   *   <li>{@link ImmutableReportGridMember#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMember.equals(Object)",
    "int ImmutableReportGridMember.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);
    ImmutableReportGridMember immutableReportGridMember =
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
            .build();

    // Act and Assert
    assertEquals(immutableReportGridMember, immutableReportGridMember);
    int expectedHashCodeResult = immutableReportGridMember.hashCode();
    assertEquals(expectedHashCodeResult, immutableReportGridMember.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridMember#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMember#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMember.equals(Object)",
    "int ImmutableReportGridMember.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder roleResult =
        ImmutableReportGridMember.builder().gridId(2L).role(ReportGridMemberRole.VIEWER);
    ImmutableReportGridMember immutableReportGridMember =
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
            .build();

    Builder roleResult2 =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);

    // Act and Assert
    assertNotEquals(
        immutableReportGridMember,
        roleResult2
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
  }

  /**
   * Test {@link ImmutableReportGridMember#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMember#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMember.equals(Object)",
    "int ImmutableReportGridMember.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.OWNER);
    ImmutableReportGridMember immutableReportGridMember =
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
            .build();

    Builder roleResult2 =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);

    // Act and Assert
    assertNotEquals(
        immutableReportGridMember,
        roleResult2
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
  }

  /**
   * Test {@link ImmutableReportGridMember#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMember#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMember.equals(Object)",
    "int ImmutableReportGridMember.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);
    ImmutableReportGridMember immutableReportGridMember =
        roleResult
            .user(
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

    Builder roleResult2 =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);

    // Act and Assert
    assertNotEquals(
        immutableReportGridMember,
        roleResult2
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
  }

  /**
   * Test {@link ImmutableReportGridMember#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMember#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMember.equals(Object)",
    "int ImmutableReportGridMember.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);

    // Act and Assert
    assertNotEquals(
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
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableReportGridMember#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMember#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMember.equals(Object)",
    "int ImmutableReportGridMember.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);

    // Act and Assert
    assertNotEquals(
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
            .build(),
        "Different type to ImmutableReportGridMember");
  }

  /**
   * Test {@link ImmutableReportGridMember#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Json} (default constructor) GridId is one.
   *   <li>Then return gridId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMember#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given one; when Json (default constructor) GridId is one; then return gridId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridMember ImmutableReportGridMember.fromJson(Json)"})
  void testFromJson_givenOne_whenJsonGridIdIsOne_thenReturnGridIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setGridId(1L);
    json.setUser(
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
    json.setRole(ReportGridMemberRole.VIEWER);

    // Act
    ImmutableReportGridMember actualFromJsonResult = ImmutableReportGridMember.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.gridId().longValue());
    assertEquals(ReportGridMemberRole.VIEWER, actualFromJsonResult.role());
    Person expectedUserResult = json.user;
    assertSame(expectedUserResult, actualFromJsonResult.user());
  }

  /**
   * Test {@link ImmutableReportGridMember#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Json} (default constructor) Role is {@code null}.
   *   <li>Then return gridId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMember#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given one; when Json (default constructor) Role is 'null'; then return gridId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridMember ImmutableReportGridMember.fromJson(Json)"})
  void testFromJson_givenOne_whenJsonRoleIsNull_thenReturnGridIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setGridId(1L);
    json.setUser(
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
    json.setRole(null);

    // Act
    ImmutableReportGridMember actualFromJsonResult = ImmutableReportGridMember.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.gridId().longValue());
    assertEquals(ReportGridMemberRole.VIEWER, actualFromJsonResult.role());
    Person expectedUserResult = json.user;
    assertSame(expectedUserResult, actualFromJsonResult.user());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridMember#toString()}
   *   <li>{@link ImmutableReportGridMember#gridId()}
   *   <li>{@link ImmutableReportGridMember#role()}
   *   <li>{@link ImmutableReportGridMember#user()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableReportGridMember.gridId()",
    "ReportGridMemberRole ImmutableReportGridMember.role()",
    "String ImmutableReportGridMember.toString()",
    "Person ImmutableReportGridMember.user()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);
    ImmutableReportGridMember immutableReportGridMember =
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
            .build();

    // Act
    String actualToStringResult = immutableReportGridMember.toString();
    Long actualGridIdResult = immutableReportGridMember.gridId();
    ReportGridMemberRole actualRoleResult = immutableReportGridMember.role();

    // Assert
    assertTrue(immutableReportGridMember.user() instanceof ImmutablePerson);
    assertEquals(
        "ReportGridMember{gridId=1, user=Person{id=1, employeeId=42, displayName=Display Name, email=jane.doe"
            + "@example.org, isRemoved=true, personKind=EMPLOYEE, title=Dr, mobilePhone=6625550144, officePhone=6625550144,"
            + " userPrincipalName=User Principal Name, managerEmployeeId=42, departmentName=Department Name,"
            + " organisationalUnitId=1, name=Display Name, userId=42, kind=ALL}, role=VIEWER}",
        actualToStringResult);
    assertEquals(1L, actualGridIdResult.longValue());
    assertEquals(ReportGridMemberRole.VIEWER, actualRoleResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setGridId(Long)}
   *   <li>{@link Json#setRole(ReportGridMemberRole)}
   *   <li>{@link Json#setUser(Person)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setGridId(Long)",
    "void Json.setRole(ReportGridMemberRole)",
    "void Json.setUser(Person)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setGridId(1L);
    actualJson.setRole(ReportGridMemberRole.VIEWER);
    actualJson.setUser(
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
    assertEquals(1L, actualJson.gridId.longValue());
  }

  /**
   * Test Json {@link Json#gridId()}.
   *
   * <p>Method under test: {@link Json#gridId()}
   */
  @Test
  @DisplayName("Test Json gridId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.gridId()"})
  void testJsonGridId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().gridId());
  }

  /**
   * Test Json {@link Json#role()}.
   *
   * <p>Method under test: {@link Json#role()}
   */
  @Test
  @DisplayName("Test Json role()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridMemberRole Json.role()"})
  void testJsonRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().role());
  }

  /**
   * Test Json {@link Json#user()}.
   *
   * <p>Method under test: {@link Json#user()}
   */
  @Test
  @DisplayName("Test Json user()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person Json.user()"})
  void testJsonUser() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().user());
  }

  /**
   * Test {@link ImmutableReportGridMember#withGridId(Long)}.
   *
   * <p>Method under test: {@link ImmutableReportGridMember#withGridId(Long)}
   */
  @Test
  @DisplayName("Test withGridId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridMember ImmutableReportGridMember.withGridId(Long)"})
  void testWithGridId() {
    // Arrange
    Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);
    ImmutableReportGridMember immutableReportGridMember =
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
            .build();

    // Act
    ImmutableReportGridMember actualWithGridIdResult = immutableReportGridMember.withGridId(1L);

    // Assert
    assertSame(immutableReportGridMember, actualWithGridIdResult);
  }

  /**
   * Test {@link ImmutableReportGridMember#withGridId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then user return {@link ImmutablePerson}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMember#withGridId(Long)}
   */
  @Test
  @DisplayName("Test withGridId(Long); when forty-two; then user return ImmutablePerson")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridMember ImmutableReportGridMember.withGridId(Long)"})
  void testWithGridId_whenFortyTwo_thenUserReturnImmutablePerson() {
    // Arrange
    Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);

    // Act
    ImmutableReportGridMember actualWithGridIdResult =
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
            .build()
            .withGridId(42L);

    // Assert
    Person userResult = actualWithGridIdResult.user();
    assertTrue(userResult instanceof ImmutablePerson);
    assertEquals("42", userResult.employeeId());
    assertEquals("42", userResult.userId());
    assertEquals("Display Name", userResult.displayName());
    assertEquals("Display Name", userResult.name());
    assertEquals("jane.doe@example.org", userResult.email());
    assertEquals(42L, actualWithGridIdResult.gridId().longValue());
    assertEquals(EntityKind.ALL, userResult.kind());
    assertEquals(PersonKind.EMPLOYEE, userResult.personKind());
    assertEquals(ReportGridMemberRole.VIEWER, actualWithGridIdResult.role());
    assertTrue(userResult.isRemoved());
  }

  /**
   * Test {@link ImmutableReportGridMember#withRole(ReportGridMemberRole)}.
   *
   * <p>Method under test: {@link ImmutableReportGridMember#withRole(ReportGridMemberRole)}
   */
  @Test
  @DisplayName("Test withRole(ReportGridMemberRole)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMember ImmutableReportGridMember.withRole(ReportGridMemberRole)"
  })
  void testWithRole() {
    // Arrange
    Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);
    ImmutableReportGridMember immutableReportGridMember =
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
            .build();

    // Act
    ImmutableReportGridMember actualWithRoleResult =
        immutableReportGridMember.withRole(ReportGridMemberRole.VIEWER);

    // Assert
    assertSame(immutableReportGridMember, actualWithRoleResult);
  }

  /**
   * Test {@link ImmutableReportGridMember#withRole(ReportGridMemberRole)}.
   *
   * <ul>
   *   <li>Then user return {@link ImmutablePerson}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMember#withRole(ReportGridMemberRole)}
   */
  @Test
  @DisplayName("Test withRole(ReportGridMemberRole); then user return ImmutablePerson")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMember ImmutableReportGridMember.withRole(ReportGridMemberRole)"
  })
  void testWithRole_thenUserReturnImmutablePerson() {
    // Arrange
    Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.OWNER);

    // Act
    ImmutableReportGridMember actualWithRoleResult =
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
            .build()
            .withRole(ReportGridMemberRole.VIEWER);

    // Assert
    Person userResult = actualWithRoleResult.user();
    assertTrue(userResult instanceof ImmutablePerson);
    assertEquals("42", userResult.employeeId());
    assertEquals("42", userResult.userId());
    assertEquals("Display Name", userResult.displayName());
    assertEquals("Display Name", userResult.name());
    assertEquals("jane.doe@example.org", userResult.email());
    assertEquals(1L, actualWithRoleResult.gridId().longValue());
    assertEquals(EntityKind.ALL, userResult.kind());
    assertEquals(PersonKind.EMPLOYEE, userResult.personKind());
    assertEquals(ReportGridMemberRole.VIEWER, actualWithRoleResult.role());
    assertTrue(userResult.isRemoved());
  }

  /**
   * Test {@link ImmutableReportGridMember#withUser(Person)}.
   *
   * <p>Method under test: {@link ImmutableReportGridMember#withUser(Person)}
   */
  @Test
  @DisplayName("Test withUser(Person)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridMember ImmutableReportGridMember.withUser(Person)"})
  void testWithUser() {
    // Arrange
    Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);
    ImmutableReportGridMember immutableReportGridMember =
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
            .build();

    // Act
    ImmutableReportGridMember actualWithUserResult =
        immutableReportGridMember.withUser(
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
    assertEquals(immutableReportGridMember, actualWithUserResult);
  }
}
