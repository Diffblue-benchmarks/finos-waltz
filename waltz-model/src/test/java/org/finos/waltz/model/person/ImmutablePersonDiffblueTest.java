package org.finos.waltz.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.IdProvider;
import org.junit.jupiter.api.Test;

class ImmutablePersonDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePerson#builder()}
   *   <li>{@link ImmutablePerson#departmentName(String)}
   *   <li>{@link ImmutablePerson#kind(EntityKind)}
   *   <li>{@link ImmutablePerson#managerEmployeeId(String)}
   *   <li>{@link ImmutablePerson#mobilePhone(String)}
   *   <li>{@link ImmutablePerson#officePhone(String)}
   *   <li>{@link ImmutablePerson#title(String)}
   *   <li>{@link ImmutablePerson#userId(String)}
   *   <li>{@link ImmutablePerson#userPrincipalName(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutablePerson.Builder actualDepartmentNameResult = ImmutablePerson.builder().departmentName("Department Name");
    Optional<String> departmentName = Optional.of("foo");
    ImmutablePerson.Builder actualIdResult = actualDepartmentNameResult.departmentName(departmentName).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutablePerson.Builder actualManagerEmployeeIdResult = actualIdResult.id(id)
        .kind(EntityKind.ALL)
        .managerEmployeeId("42");
    Optional<String> managerEmployeeId = Optional.of("foo");
    ImmutablePerson.Builder actualMobilePhoneResult = actualManagerEmployeeIdResult.managerEmployeeId(managerEmployeeId)
        .mobilePhone("6625550144");
    Optional<String> mobilePhone = Optional.of("foo");
    ImmutablePerson.Builder actualOfficePhoneResult = actualMobilePhoneResult.mobilePhone(mobilePhone)
        .officePhone("6625550144");
    Optional<String> officePhone = Optional.of("foo");
    ImmutablePerson.Builder actualOrganisationalUnitIdResult = actualOfficePhoneResult.officePhone(officePhone)
        .organisationalUnitId(1L);
    Optional<Long> organisationalUnitId = Optional.<Long>of(1L);
    ImmutablePerson.Builder actualTitleResult = actualOrganisationalUnitIdResult
        .organisationalUnitId(organisationalUnitId)
        .title("Dr");
    Optional<String> title = Optional.of("foo");
    ImmutablePerson.Builder actualUserPrincipalNameResult = actualTitleResult.title(title)
        .userId("42")
        .userPrincipalName("User Principal Name");
    Optional<String> userPrincipalName = Optional.of("foo");

    // Assert
    assertSame(actualUserPrincipalNameResult, actualUserPrincipalNameResult.userPrincipalName(userPrincipalName));
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#departmentName(Optional)}
   */
  @Test
  void testBuilderDepartmentName() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    Optional<String> departmentName = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.departmentName(departmentName));
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#displayName(String)}
   */
  @Test
  void testBuilderDisplayName() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.displayName("Display Name"));
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#email(String)}
   */
  @Test
  void testBuilderEmail() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.email("jane.doe@example.org"));
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#employeeId(String)}
   */
  @Test
  void testBuilderEmployeeId() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.employeeId("42"));
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutablePerson.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutablePerson.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#from(Person)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    Person instance = mock(Person.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.userPrincipalName()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.managerEmployeeId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.mobilePhone()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.officePhone()).thenReturn(ofResult5);
    Optional<Long> ofResult6 = Optional.<Long>of(1L);
    when(instance.organisationalUnitId()).thenReturn(ofResult6);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult7);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult8 = Optional.of("foo");
    when(instance.departmentName()).thenReturn(ofResult8);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    ImmutablePerson buildResult = builderResult.build();
    assertEquals("42", buildResult.employeeId());
    assertEquals("42", buildResult.userId());
    assertEquals("Display Name", buildResult.displayName());
    assertEquals("Display Name", buildResult.name());
    assertEquals("jane.doe@example.org", buildResult.email());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(PersonKind.EMPLOYEE, buildResult.personKind());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#from(Person)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    Person instance = mock(Person.class);
    when(instance.userPrincipalName()).thenThrow(new IllegalStateException("instance"));
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.managerEmployeeId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.mobilePhone()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.officePhone()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.organisationalUnitId()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult6);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.departmentName()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#from(Person)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    Person instance = mock(Person.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.userPrincipalName()).thenReturn(emptyResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.managerEmployeeId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.mobilePhone()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.officePhone()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.organisationalUnitId()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult6);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.departmentName()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    ImmutablePerson buildResult = builderResult.build();
    assertEquals("42", buildResult.employeeId());
    assertEquals("42", buildResult.userId());
    assertEquals("Display Name", buildResult.displayName());
    assertEquals("Display Name", buildResult.name());
    assertEquals("jane.doe@example.org", buildResult.email());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(PersonKind.EMPLOYEE, buildResult.personKind());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#from(Person)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    Person instance = mock(Person.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.userPrincipalName()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.managerEmployeeId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.mobilePhone()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.officePhone()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.organisationalUnitId()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult6);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.departmentName()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    ImmutablePerson buildResult = builderResult.build();
    assertEquals("42", buildResult.employeeId());
    assertEquals("42", buildResult.userId());
    assertEquals("Display Name", buildResult.displayName());
    assertEquals("Display Name", buildResult.name());
    assertEquals("jane.doe@example.org", buildResult.email());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(PersonKind.EMPLOYEE, buildResult.personKind());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#from(Person)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    Person instance = mock(Person.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.userPrincipalName()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<String> emptyResult = Optional.empty();
    when(instance.managerEmployeeId()).thenReturn(emptyResult);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.mobilePhone()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.officePhone()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.organisationalUnitId()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult6);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.departmentName()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    ImmutablePerson buildResult = builderResult.build();
    assertEquals("42", buildResult.employeeId());
    assertEquals("42", buildResult.userId());
    assertEquals("Display Name", buildResult.displayName());
    assertEquals("Display Name", buildResult.name());
    assertEquals("jane.doe@example.org", buildResult.email());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(PersonKind.EMPLOYEE, buildResult.personKind());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#from(Person)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    Person instance = mock(Person.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.userPrincipalName()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.managerEmployeeId()).thenReturn(ofResult3);
    Optional<String> emptyResult = Optional.empty();
    when(instance.mobilePhone()).thenReturn(emptyResult);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.officePhone()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.organisationalUnitId()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult6);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.departmentName()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    ImmutablePerson buildResult = builderResult.build();
    assertEquals("42", buildResult.employeeId());
    assertEquals("42", buildResult.userId());
    assertEquals("Display Name", buildResult.displayName());
    assertEquals("Display Name", buildResult.name());
    assertEquals("jane.doe@example.org", buildResult.email());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(PersonKind.EMPLOYEE, buildResult.personKind());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#from(Person)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    Person instance = mock(Person.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.userPrincipalName()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.managerEmployeeId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.mobilePhone()).thenReturn(ofResult4);
    Optional<String> emptyResult = Optional.empty();
    when(instance.officePhone()).thenReturn(emptyResult);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.organisationalUnitId()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult6);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.departmentName()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    ImmutablePerson buildResult = builderResult.build();
    assertEquals("42", buildResult.employeeId());
    assertEquals("42", buildResult.userId());
    assertEquals("Display Name", buildResult.displayName());
    assertEquals("Display Name", buildResult.name());
    assertEquals("jane.doe@example.org", buildResult.email());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(PersonKind.EMPLOYEE, buildResult.personKind());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#from(Person)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    Person instance = mock(Person.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.userPrincipalName()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.managerEmployeeId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.mobilePhone()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.officePhone()).thenReturn(ofResult5);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.organisationalUnitId()).thenReturn(emptyResult);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult6);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.departmentName()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    ImmutablePerson buildResult = builderResult.build();
    assertEquals("42", buildResult.employeeId());
    assertEquals("42", buildResult.userId());
    assertEquals("Display Name", buildResult.displayName());
    assertEquals("Display Name", buildResult.name());
    assertEquals("jane.doe@example.org", buildResult.email());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(PersonKind.EMPLOYEE, buildResult.personKind());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#from(Person)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    Person instance = mock(Person.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.userPrincipalName()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.managerEmployeeId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.mobilePhone()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.officePhone()).thenReturn(ofResult5);
    Optional<Long> ofResult6 = Optional.<Long>of(1L);
    when(instance.organisationalUnitId()).thenReturn(ofResult6);
    Optional<String> emptyResult = Optional.empty();
    when(instance.title()).thenReturn(emptyResult);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.departmentName()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    ImmutablePerson buildResult = builderResult.build();
    assertEquals("42", buildResult.employeeId());
    assertEquals("42", buildResult.userId());
    assertEquals("Display Name", buildResult.displayName());
    assertEquals("Display Name", buildResult.name());
    assertEquals("jane.doe@example.org", buildResult.email());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(PersonKind.EMPLOYEE, buildResult.personKind());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#from(Person)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    Person instance = mock(Person.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.userPrincipalName()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.managerEmployeeId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.mobilePhone()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.officePhone()).thenReturn(ofResult5);
    Optional<Long> ofResult6 = Optional.<Long>of(1L);
    when(instance.organisationalUnitId()).thenReturn(ofResult6);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult7);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> emptyResult = Optional.empty();
    when(instance.departmentName()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    ImmutablePerson buildResult = builderResult.build();
    assertEquals("42", buildResult.employeeId());
    assertEquals("42", buildResult.userId());
    assertEquals("Display Name", buildResult.displayName());
    assertEquals("Display Name", buildResult.name());
    assertEquals("jane.doe@example.org", buildResult.email());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(PersonKind.EMPLOYEE, buildResult.personKind());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#isRemoved(boolean)}
   */
  @Test
  void testBuilderIsRemoved() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRemoved(true));
  }

  /**
   * Method under test:
   * {@link ImmutablePerson.Builder#managerEmployeeId(Optional)}
   */
  @Test
  void testBuilderManagerEmployeeId() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    Optional<String> managerEmployeeId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.managerEmployeeId(managerEmployeeId));
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#mobilePhone(Optional)}
   */
  @Test
  void testBuilderMobilePhone() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    Optional<String> mobilePhone = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.mobilePhone(mobilePhone));
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#officePhone(Optional)}
   */
  @Test
  void testBuilderOfficePhone() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    Optional<String> officePhone = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.officePhone(officePhone));
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#organisationalUnitId(long)}
   */
  @Test
  void testBuilderOrganisationalUnitId() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.organisationalUnitId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePerson.Builder#organisationalUnitId(Optional)}
   */
  @Test
  void testBuilderOrganisationalUnitId2() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    Optional<Long> organisationalUnitId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.organisationalUnitId(organisationalUnitId));
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#personKind(PersonKind)}
   */
  @Test
  void testBuilderPersonKind() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.personKind(PersonKind.EMPLOYEE));
  }

  /**
   * Method under test: {@link ImmutablePerson.Builder#title(Optional)}
   */
  @Test
  void testBuilderTitle() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    Optional<String> title = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.title(title));
  }

  /**
   * Method under test:
   * {@link ImmutablePerson.Builder#userPrincipalName(Optional)}
   */
  @Test
  void testBuilderUserPrincipalName() {
    // Arrange
    ImmutablePerson.Builder builderResult = ImmutablePerson.builder();
    Optional<String> userPrincipalName = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.userPrincipalName(userPrincipalName));
  }

  /**
   * Method under test: {@link ImmutablePerson#copyOf(Person)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Person instance = mock(Person.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.userPrincipalName()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.managerEmployeeId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.mobilePhone()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.officePhone()).thenReturn(ofResult5);
    Optional<Long> ofResult6 = Optional.<Long>of(1L);
    when(instance.organisationalUnitId()).thenReturn(ofResult6);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult7);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult8 = Optional.of("foo");
    when(instance.departmentName()).thenReturn(ofResult8);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson actualCopyOfResult = ImmutablePerson.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    assertEquals("42", actualCopyOfResult.employeeId());
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertEquals("Display Name", actualCopyOfResult.name());
    assertEquals("jane.doe@example.org", actualCopyOfResult.email());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualCopyOfResult.personKind());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutablePerson#copyOf(Person)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    Person instance = mock(Person.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.userPrincipalName()).thenReturn(emptyResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.managerEmployeeId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.mobilePhone()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.officePhone()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.organisationalUnitId()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult6);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.departmentName()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson actualCopyOfResult = ImmutablePerson.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    assertEquals("42", actualCopyOfResult.employeeId());
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertEquals("Display Name", actualCopyOfResult.name());
    assertEquals("jane.doe@example.org", actualCopyOfResult.email());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualCopyOfResult.personKind());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutablePerson#copyOf(Person)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    Person instance = mock(Person.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.userPrincipalName()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(false);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.managerEmployeeId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.mobilePhone()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.officePhone()).thenReturn(ofResult5);
    Optional<Long> ofResult6 = Optional.<Long>of(1L);
    when(instance.organisationalUnitId()).thenReturn(ofResult6);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult7);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult8 = Optional.of("foo");
    when(instance.departmentName()).thenReturn(ofResult8);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson actualCopyOfResult = ImmutablePerson.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    assertEquals("42", actualCopyOfResult.employeeId());
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertEquals("Display Name", actualCopyOfResult.name());
    assertEquals("jane.doe@example.org", actualCopyOfResult.email());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualCopyOfResult.personKind());
    assertFalse(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutablePerson#copyOf(Person)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    Person instance = mock(Person.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.userPrincipalName()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.managerEmployeeId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.mobilePhone()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.officePhone()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.organisationalUnitId()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult6);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.departmentName()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson actualCopyOfResult = ImmutablePerson.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    assertEquals("42", actualCopyOfResult.employeeId());
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertEquals("Display Name", actualCopyOfResult.name());
    assertEquals("jane.doe@example.org", actualCopyOfResult.email());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualCopyOfResult.personKind());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutablePerson#copyOf(Person)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    Person instance = mock(Person.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.userPrincipalName()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<String> emptyResult = Optional.empty();
    when(instance.managerEmployeeId()).thenReturn(emptyResult);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.mobilePhone()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.officePhone()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.organisationalUnitId()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult6);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.departmentName()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson actualCopyOfResult = ImmutablePerson.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    assertEquals("42", actualCopyOfResult.employeeId());
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertEquals("Display Name", actualCopyOfResult.name());
    assertEquals("jane.doe@example.org", actualCopyOfResult.email());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualCopyOfResult.personKind());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutablePerson#copyOf(Person)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    Person instance = mock(Person.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.userPrincipalName()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.managerEmployeeId()).thenReturn(ofResult3);
    Optional<String> emptyResult = Optional.empty();
    when(instance.mobilePhone()).thenReturn(emptyResult);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.officePhone()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.organisationalUnitId()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult6);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.departmentName()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson actualCopyOfResult = ImmutablePerson.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    assertEquals("42", actualCopyOfResult.employeeId());
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertEquals("Display Name", actualCopyOfResult.name());
    assertEquals("jane.doe@example.org", actualCopyOfResult.email());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualCopyOfResult.personKind());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutablePerson#copyOf(Person)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    Person instance = mock(Person.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.userPrincipalName()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.managerEmployeeId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.mobilePhone()).thenReturn(ofResult4);
    Optional<String> emptyResult = Optional.empty();
    when(instance.officePhone()).thenReturn(emptyResult);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.organisationalUnitId()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult6);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.departmentName()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson actualCopyOfResult = ImmutablePerson.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    assertEquals("42", actualCopyOfResult.employeeId());
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertEquals("Display Name", actualCopyOfResult.name());
    assertEquals("jane.doe@example.org", actualCopyOfResult.email());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualCopyOfResult.personKind());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutablePerson#copyOf(Person)}
   */
  @Test
  void testCopyOf8() {
    // Arrange
    Person instance = mock(Person.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.userPrincipalName()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.managerEmployeeId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.mobilePhone()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.officePhone()).thenReturn(ofResult5);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.organisationalUnitId()).thenReturn(emptyResult);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult6);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.departmentName()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson actualCopyOfResult = ImmutablePerson.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    assertEquals("42", actualCopyOfResult.employeeId());
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertEquals("Display Name", actualCopyOfResult.name());
    assertEquals("jane.doe@example.org", actualCopyOfResult.email());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualCopyOfResult.personKind());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutablePerson#copyOf(Person)}
   */
  @Test
  void testCopyOf9() {
    // Arrange
    Person instance = mock(Person.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.userPrincipalName()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.managerEmployeeId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.mobilePhone()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.officePhone()).thenReturn(ofResult5);
    Optional<Long> ofResult6 = Optional.<Long>of(1L);
    when(instance.organisationalUnitId()).thenReturn(ofResult6);
    Optional<String> emptyResult = Optional.empty();
    when(instance.title()).thenReturn(emptyResult);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.departmentName()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson actualCopyOfResult = ImmutablePerson.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    assertEquals("42", actualCopyOfResult.employeeId());
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertEquals("Display Name", actualCopyOfResult.name());
    assertEquals("jane.doe@example.org", actualCopyOfResult.email());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualCopyOfResult.personKind());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutablePerson#copyOf(Person)}
   */
  @Test
  void testCopyOf10() {
    // Arrange
    Person instance = mock(Person.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.userPrincipalName()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.email()).thenReturn("jane.doe@example.org");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.managerEmployeeId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.mobilePhone()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.officePhone()).thenReturn(ofResult5);
    Optional<Long> ofResult6 = Optional.<Long>of(1L);
    when(instance.organisationalUnitId()).thenReturn(ofResult6);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult7);
    when(instance.userId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");
    when(instance.personKind()).thenReturn(PersonKind.EMPLOYEE);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> emptyResult = Optional.empty();
    when(instance.departmentName()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePerson actualCopyOfResult = ImmutablePerson.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).departmentName();
    verify(instance).displayName();
    verify(instance).email();
    verify(instance).employeeId();
    verify(instance).isRemoved();
    verify(instance).kind();
    verify(instance).managerEmployeeId();
    verify(instance).mobilePhone();
    verify(instance).officePhone();
    verify(instance).organisationalUnitId();
    verify(instance).personKind();
    verify(instance).title();
    verify(instance).userId();
    verify(instance).userPrincipalName();
    assertEquals("42", actualCopyOfResult.employeeId());
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertEquals("Display Name", actualCopyOfResult.name());
    assertEquals("jane.doe@example.org", actualCopyOfResult.email());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualCopyOfResult.personKind());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutablePerson.Json#departmentName()}
   */
  @Test
  void testJsonDepartmentName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePerson.Json()).departmentName());
  }

  /**
   * Method under test: {@link ImmutablePerson.Json#displayName()}
   */
  @Test
  void testJsonDisplayName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePerson.Json()).displayName());
  }

  /**
   * Method under test: {@link ImmutablePerson.Json#email()}
   */
  @Test
  void testJsonEmail() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePerson.Json()).email());
  }

  /**
   * Method under test: {@link ImmutablePerson.Json#employeeId()}
   */
  @Test
  void testJsonEmployeeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePerson.Json()).employeeId());
  }

  /**
   * Method under test: {@link ImmutablePerson.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePerson.Json()).id());
  }

  /**
   * Method under test: {@link ImmutablePerson.Json#isRemoved()}
   */
  @Test
  void testJsonIsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePerson.Json()).isRemoved());
  }

  /**
   * Method under test: {@link ImmutablePerson.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePerson.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutablePerson.Json#managerEmployeeId()}
   */
  @Test
  void testJsonManagerEmployeeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePerson.Json()).managerEmployeeId());
  }

  /**
   * Method under test: {@link ImmutablePerson.Json#mobilePhone()}
   */
  @Test
  void testJsonMobilePhone() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePerson.Json()).mobilePhone());
  }

  /**
   * Method under test: {@link ImmutablePerson.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePerson.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePerson.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePerson.Json actualJson = new ImmutablePerson.Json();

    // Assert
    assertNull(actualJson.displayName);
    assertNull(actualJson.email);
    assertNull(actualJson.employeeId);
    assertNull(actualJson.userId);
    assertNull(actualJson.kind);
    assertNull(actualJson.personKind);
    assertFalse(actualJson.departmentName.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.managerEmployeeId.isPresent());
    assertFalse(actualJson.mobilePhone.isPresent());
    assertFalse(actualJson.officePhone.isPresent());
    assertFalse(actualJson.organisationalUnitId.isPresent());
    assertFalse(actualJson.title.isPresent());
    assertFalse(actualJson.userPrincipalName.isPresent());
    assertFalse(actualJson.isRemoved);
    assertFalse(actualJson.isRemovedIsSet);
  }

  /**
   * Method under test: {@link ImmutablePerson.Json#officePhone()}
   */
  @Test
  void testJsonOfficePhone() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePerson.Json()).officePhone());
  }

  /**
   * Method under test: {@link ImmutablePerson.Json#organisationalUnitId()}
   */
  @Test
  void testJsonOrganisationalUnitId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePerson.Json()).organisationalUnitId());
  }

  /**
   * Method under test: {@link ImmutablePerson.Json#personKind()}
   */
  @Test
  void testJsonPersonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePerson.Json()).personKind());
  }

  /**
   * Method under test: {@link ImmutablePerson.Json#setIsRemoved(boolean)}
   */
  @Test
  void testJsonSetIsRemoved() {
    // Arrange
    ImmutablePerson.Json json = new ImmutablePerson.Json();

    // Act
    json.setIsRemoved(true);

    // Assert
    assertTrue(json.isRemoved);
    assertTrue(json.isRemovedIsSet);
  }

  /**
   * Method under test: {@link ImmutablePerson.Json#title()}
   */
  @Test
  void testJsonTitle() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePerson.Json()).title());
  }

  /**
   * Method under test: {@link ImmutablePerson.Json#userId()}
   */
  @Test
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePerson.Json()).userId());
  }

  /**
   * Method under test: {@link ImmutablePerson.Json#userPrincipalName()}
   */
  @Test
  void testJsonUserPrincipalName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePerson.Json()).userPrincipalName());
  }
}
