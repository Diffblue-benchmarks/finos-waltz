package org.finos.waltz.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PersonDiffblueTest {
  /**
   * Test {@link Person#entityReference()}.
   *
   * <p>Method under test: {@link Person#entityReference()}
   */
  @Test
  @DisplayName("Test entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Person.entityReference()"})
  void testEntityReference() {
    // Arrange and Act
    EntityReference actualEntityReferenceResult =
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
            .build()
            .entityReference();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertNull(actualEntityReferenceResult.description());
    assertEquals(1L, actualEntityReferenceResult.id());
    assertEquals(EntityKind.PERSON, actualEntityReferenceResult.kind());
    assertEquals(
        EntityLifecycleStatus.REMOVED, actualEntityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link Person#entityReference()}.
   *
   * <ul>
   *   <li>Then return entityLifecycleStatus is {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link Person#entityReference()}
   */
  @Test
  @DisplayName("Test entityReference(); then return entityLifecycleStatus is 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Person.entityReference()"})
  void testEntityReference_thenReturnEntityLifecycleStatusIsActive() {
    // Arrange and Act
    EntityReference actualEntityReferenceResult =
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("42")
            .id(1L)
            .isRemoved(false)
            .kind(EntityKind.ALL)
            .managerEmployeeId("42")
            .mobilePhone("6625550144")
            .officePhone("6625550144")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build()
            .entityReference();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertNull(actualEntityReferenceResult.description());
    assertEquals(1L, actualEntityReferenceResult.id());
    assertEquals(EntityKind.PERSON, actualEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualEntityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link Person#entityReference()}.
   *
   * <ul>
   *   <li>Then return id is two.
   * </ul>
   *
   * <p>Method under test: {@link Person#entityReference()}
   */
  @Test
  @DisplayName("Test entityReference(); then return id is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Person.entityReference()"})
  void testEntityReference_thenReturnIdIsTwo() {
    // Arrange and Act
    EntityReference actualEntityReferenceResult =
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("42")
            .id(2L)
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
            .build()
            .entityReference();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertNull(actualEntityReferenceResult.description());
    assertEquals(2L, actualEntityReferenceResult.id());
    assertEquals(EntityKind.PERSON, actualEntityReferenceResult.kind());
    assertEquals(
        EntityLifecycleStatus.REMOVED, actualEntityReferenceResult.entityLifecycleStatus());
  }
}
