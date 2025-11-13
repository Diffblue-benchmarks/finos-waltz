package org.finos.waltz.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.person.ImmutablePerson.Builder;
import org.finos.waltz.model.person.ImmutablePerson.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePersonDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#departmentName(String)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#managerEmployeeId(String)}
   *   <li>{@link Builder#mobilePhone(String)}
   *   <li>{@link Builder#officePhone(String)}
   *   <li>{@link Builder#title(String)}
   *   <li>{@link Builder#userId(String)}
   *   <li>{@link Builder#userPrincipalName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePerson Builder.build()",
    "Builder Builder.departmentName(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.managerEmployeeId(String)",
    "Builder Builder.mobilePhone(String)",
    "Builder Builder.officePhone(String)",
    "Builder Builder.title(String)",
    "Builder Builder.userId(String)",
    "Builder Builder.userPrincipalName(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDepartmentNameResult =
        ImmutablePerson.builder().departmentName("Department Name");
    Optional<String> departmentName = Optional.of("42");
    Builder actualIdResult =
        actualDepartmentNameResult
            .departmentName(departmentName)
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("42")
            .id(1L);
    Optional<Long> id = Optional.of(42L);
    Builder actualManagerEmployeeIdResult =
        actualIdResult.id(id).isRemoved(true).kind(EntityKind.ALL).managerEmployeeId("42");
    Optional<String> managerEmployeeId = Optional.of("42");
    Builder actualMobilePhoneResult =
        actualManagerEmployeeIdResult
            .managerEmployeeId(managerEmployeeId)
            .mobilePhone("6625550144");
    Optional<String> mobilePhone = Optional.of("42");
    Builder actualOfficePhoneResult =
        actualMobilePhoneResult.mobilePhone(mobilePhone).officePhone("6625550144");
    Optional<String> officePhone = Optional.of("42");
    Builder actualOrganisationalUnitIdResult =
        actualOfficePhoneResult.officePhone(officePhone).organisationalUnitId(1L);
    Optional<Long> organisationalUnitId = Optional.of(42L);
    Builder actualTitleResult =
        actualOrganisationalUnitIdResult
            .organisationalUnitId(organisationalUnitId)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr");
    Optional<String> title = Optional.of("42");
    Builder actualUserPrincipalNameResult =
        actualTitleResult.title(title).userId("42").userPrincipalName("User Principal Name");
    Optional<String> userPrincipalName = Optional.of("42");
    ImmutablePerson actualImmutablePerson =
        actualUserPrincipalNameResult.userPrincipalName(userPrincipalName).build();

    // Assert
    assertEquals("42", actualImmutablePerson.employeeId());
    assertEquals("42", actualImmutablePerson.userId());
    assertEquals("Display Name", actualImmutablePerson.displayName());
    assertEquals("Display Name", actualImmutablePerson.name());
    assertEquals("jane.doe@example.org", actualImmutablePerson.email());
    assertEquals(EntityKind.ALL, actualImmutablePerson.kind());
    assertEquals(PersonKind.EMPLOYEE, actualImmutablePerson.personKind());
    assertTrue(actualImmutablePerson.isRemoved());
  }

  /**
   * Test Builder {@link Builder#departmentName(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#departmentName(Optional)}
   */
  @Test
  @DisplayName("Test Builder departmentName(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.departmentName(Optional)"})
  void testBuilderDepartmentNameWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    Optional<String> departmentName = Optional.of("42");

    // Act
    Builder actualDepartmentNameResult = builderResult.departmentName(departmentName);

    // Assert
    assertSame(builderResult, actualDepartmentNameResult);
  }

  /**
   * Test Builder {@link Builder#displayName(String)}.
   *
   * <ul>
   *   <li>When {@code Display Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#displayName(String)}
   */
  @Test
  @DisplayName("Test Builder displayName(String); when 'Display Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.displayName(String)"})
  void testBuilderDisplayName_whenDisplayName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();

    // Act
    Builder actualDisplayNameResult = builderResult.displayName("Display Name");

    // Assert
    assertSame(builderResult, actualDisplayNameResult);
  }

  /**
   * Test Builder {@link Builder#email(String)}.
   *
   * <ul>
   *   <li>When {@code jane.doe@example.org}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#email(String)}
   */
  @Test
  @DisplayName("Test Builder email(String); when 'jane.doe@example.org'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.email(String)"})
  void testBuilderEmail_whenJaneDoeExampleOrg_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();

    // Act
    Builder actualEmailResult = builderResult.email("jane.doe@example.org");

    // Assert
    assertSame(builderResult, actualEmailResult);
  }

  /**
   * Test Builder {@link Builder#employeeId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#employeeId(String)}
   */
  @Test
  @DisplayName("Test Builder employeeId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.employeeId(String)"})
  void testBuilderEmployeeId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();

    // Act
    Builder actualEmployeeIdResult = builderResult.employeeId("42");

    // Assert
    assertSame(builderResult, actualEmployeeIdResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    ImmutablePerson instance =
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

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutablePerson actualImmutablePerson = builderResult.build();
    assertEquals(instance, actualImmutablePerson);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>Then calls {@link EntityKindProvider#kind()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'; then calls kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll_thenCallsKind() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    ImmutablePerson instance =
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

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutablePerson actualImmutablePerson = builderResult.build();
    assertEquals(instance, actualImmutablePerson);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of forty-two; when IdProvider id() return of forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfFortyTwo_whenIdProviderIdReturnOfFortyTwo() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(42L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(Person)} with {@code Person}.
   *
   * <p>Method under test: {@link Builder#from(Person)}
   */
  @Test
  @DisplayName("Test Builder from(Person) with 'Person'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Person)"})
  void testBuilderFromWithPerson() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    ImmutablePerson instance =
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

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePerson actualImmutablePerson = builderResult.build();
    assertEquals(instance, actualImmutablePerson);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Person)} with {@code Person}.
   *
   * <p>Method under test: {@link Builder#from(Person)}
   */
  @Test
  @DisplayName("Test Builder from(Person) with 'Person'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Person)"})
  void testBuilderFromWithPerson2() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    ImmutablePerson instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePerson actualImmutablePerson = builderResult.build();
    assertEquals(instance, actualImmutablePerson);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isRemoved(boolean)}.
   *
   * <p>Method under test: {@link Builder#isRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Builder isRemoved(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isRemoved(boolean)"})
  void testBuilderIsRemoved() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();

    // Act
    Builder actualIsRemovedResult = builderResult.isRemoved(true);

    // Assert
    assertSame(builderResult, actualIsRemovedResult);
  }

  /**
   * Test Builder {@link Builder#managerEmployeeId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#managerEmployeeId(Optional)}
   */
  @Test
  @DisplayName("Test Builder managerEmployeeId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.managerEmployeeId(Optional)"})
  void testBuilderManagerEmployeeIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    Optional<String> managerEmployeeId = Optional.of("42");

    // Act
    Builder actualManagerEmployeeIdResult = builderResult.managerEmployeeId(managerEmployeeId);

    // Assert
    assertSame(builderResult, actualManagerEmployeeIdResult);
  }

  /**
   * Test Builder {@link Builder#mobilePhone(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#mobilePhone(Optional)}
   */
  @Test
  @DisplayName("Test Builder mobilePhone(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.mobilePhone(Optional)"})
  void testBuilderMobilePhoneWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    Optional<String> mobilePhone = Optional.of("42");

    // Act
    Builder actualMobilePhoneResult = builderResult.mobilePhone(mobilePhone);

    // Assert
    assertSame(builderResult, actualMobilePhoneResult);
  }

  /**
   * Test Builder {@link Builder#officePhone(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#officePhone(Optional)}
   */
  @Test
  @DisplayName("Test Builder officePhone(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.officePhone(Optional)"})
  void testBuilderOfficePhoneWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    Optional<String> officePhone = Optional.of("42");

    // Act
    Builder actualOfficePhoneResult = builderResult.officePhone(officePhone);

    // Assert
    assertSame(builderResult, actualOfficePhoneResult);
  }

  /**
   * Test Builder {@link Builder#organisationalUnitId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#organisationalUnitId(long)}
   */
  @Test
  @DisplayName("Test Builder organisationalUnitId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.organisationalUnitId(long)"})
  void testBuilderOrganisationalUnitIdWithLong() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();

    // Act
    Builder actualOrganisationalUnitIdResult = builderResult.organisationalUnitId(1L);

    // Assert
    assertSame(builderResult, actualOrganisationalUnitIdResult);
  }

  /**
   * Test Builder {@link Builder#organisationalUnitId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#organisationalUnitId(Optional)}
   */
  @Test
  @DisplayName("Test Builder organisationalUnitId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.organisationalUnitId(Optional)"})
  void testBuilderOrganisationalUnitIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    Optional<Long> organisationalUnitId = Optional.of(42L);

    // Act
    Builder actualOrganisationalUnitIdResult =
        builderResult.organisationalUnitId(organisationalUnitId);

    // Assert
    assertSame(builderResult, actualOrganisationalUnitIdResult);
  }

  /**
   * Test Builder {@link Builder#personKind(PersonKind)}.
   *
   * <p>Method under test: {@link Builder#personKind(PersonKind)}
   */
  @Test
  @DisplayName("Test Builder personKind(PersonKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.personKind(PersonKind)"})
  void testBuilderPersonKind() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();

    // Act
    Builder actualPersonKindResult = builderResult.personKind(PersonKind.EMPLOYEE);

    // Assert
    assertSame(builderResult, actualPersonKindResult);
  }

  /**
   * Test Builder {@link Builder#title(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#title(Optional)}
   */
  @Test
  @DisplayName("Test Builder title(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.title(Optional)"})
  void testBuilderTitleWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    Optional<String> title = Optional.of("42");

    // Act
    Builder actualTitleResult = builderResult.title(title);

    // Assert
    assertSame(builderResult, actualTitleResult);
  }

  /**
   * Test Builder {@link Builder#userPrincipalName(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#userPrincipalName(Optional)}
   */
  @Test
  @DisplayName("Test Builder userPrincipalName(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.userPrincipalName(Optional)"})
  void testBuilderUserPrincipalNameWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    Optional<String> userPrincipalName = Optional.of("42");

    // Act
    Builder actualUserPrincipalNameResult = builderResult.userPrincipalName(userPrincipalName);

    // Assert
    assertSame(builderResult, actualUserPrincipalNameResult);
  }

  /**
   * Test {@link ImmutablePerson#copyOf(Person)}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#copyOf(Person)}
   */
  @Test
  @DisplayName("Test copyOf(Person); then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.copyOf(Person)"})
  void testCopyOf_thenReturnEmployeeIdIs42() {
    // Arrange
    ImmutablePerson instance =
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

    // Act
    ImmutablePerson actualCopyOfResult = ImmutablePerson.copyOf(instance);

    // Assert
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
   * Test {@link ImmutablePerson#departmentName()}.
   *
   * <p>Method under test: {@link ImmutablePerson#departmentName()}
   */
  @Test
  @DisplayName("Test departmentName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePerson.departmentName()"})
  void testDepartmentName() {
    // Arrange and Act
    Optional<String> actualDepartmentNameResult =
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
            .departmentName();

    // Assert
    assertEquals("Department Name", actualDepartmentNameResult.get());
    assertTrue(actualDepartmentNameResult.isPresent());
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}, and {@link ImmutablePerson#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePerson#equals(Object)}
   *   <li>{@link ImmutablePerson#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutablePerson immutablePerson =
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
    ImmutablePerson immutablePerson2 =
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

    // Act and Assert
    assertEquals(immutablePerson, immutablePerson2);
    assertEquals(immutablePerson.hashCode(), immutablePerson2.hashCode());
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}, and {@link ImmutablePerson#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePerson#equals(Object)}
   *   <li>{@link ImmutablePerson#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutablePerson immutablePerson =
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

    // Act and Assert
    assertEquals(immutablePerson, immutablePerson);
    int expectedHashCodeResult = immutablePerson.hashCode();
    assertEquals(expectedHashCodeResult, immutablePerson.hashCode());
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutablePerson immutablePerson =
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
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePerson,
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
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutablePerson immutablePerson =
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("42")
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

    // Act and Assert
    assertNotEquals(
        immutablePerson,
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
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutablePerson immutablePerson =
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("john.smith@example.org")
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

    // Act and Assert
    assertNotEquals(
        immutablePerson,
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
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutablePerson immutablePerson =
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("Display Name")
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

    // Act and Assert
    assertNotEquals(
        immutablePerson,
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
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutablePerson immutablePerson =
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
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePerson,
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
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutablePerson immutablePerson =
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
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePerson,
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
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutablePerson immutablePerson =
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("42")
            .id(1L)
            .isRemoved(true)
            .kind(EntityKind.ACTOR)
            .managerEmployeeId("42")
            .mobilePhone("6625550144")
            .officePhone("6625550144")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePerson,
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
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutablePerson immutablePerson =
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("42")
            .id(1L)
            .isRemoved(true)
            .kind(EntityKind.ALL)
            .managerEmployeeId("Display Name")
            .mobilePhone("6625550144")
            .officePhone("6625550144")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePerson,
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
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutablePerson immutablePerson =
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("42")
            .id(1L)
            .isRemoved(true)
            .kind(EntityKind.ALL)
            .managerEmployeeId("42")
            .mobilePhone("8605550118")
            .officePhone("6625550144")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePerson,
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
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ImmutablePerson immutablePerson =
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
            .officePhone("8605550118")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePerson,
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
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ImmutablePerson immutablePerson =
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
            .organisationalUnitId(2L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePerson,
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
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ImmutablePerson immutablePerson =
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
            .personKind(PersonKind.CONTRACTOR)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePerson,
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
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ImmutablePerson immutablePerson =
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
            .title("Mr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePerson,
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
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    ImmutablePerson immutablePerson =
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
            .userId("Display Name")
            .userPrincipalName("User Principal Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePerson,
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
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    ImmutablePerson immutablePerson =
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
            .userPrincipalName("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePerson,
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
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
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
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePerson#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePerson.equals(Object)", "int ImmutablePerson.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
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
            .build(),
        "Different type to ImmutablePerson");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePerson#displayName()}
   *   <li>{@link ImmutablePerson#email()}
   *   <li>{@link ImmutablePerson#employeeId()}
   *   <li>{@link ImmutablePerson#isRemoved()}
   *   <li>{@link ImmutablePerson#personKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutablePerson.displayName()",
    "String ImmutablePerson.email()",
    "String ImmutablePerson.employeeId()",
    "boolean ImmutablePerson.isRemoved()",
    "PersonKind ImmutablePerson.personKind()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutablePerson immutablePerson =
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

    // Act
    String actualDisplayNameResult = immutablePerson.displayName();
    String actualEmailResult = immutablePerson.email();
    String actualEmployeeIdResult = immutablePerson.employeeId();
    boolean actualIsRemovedResult = immutablePerson.isRemoved();

    // Assert
    assertEquals("42", actualEmployeeIdResult);
    assertEquals("Display Name", actualDisplayNameResult);
    assertEquals("jane.doe@example.org", actualEmailResult);
    assertEquals(PersonKind.EMPLOYEE, immutablePerson.personKind());
    assertTrue(actualIsRemovedResult);
  }

  /**
   * Test {@link ImmutablePerson#id()}.
   *
   * <p>Method under test: {@link ImmutablePerson#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePerson.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
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
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#departmentName()}.
   *
   * <p>Method under test: {@link Json#departmentName()}
   */
  @Test
  @DisplayName("Test Json departmentName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.departmentName()"})
  void testJsonDepartmentName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().departmentName());
  }

  /**
   * Test Json {@link Json#displayName()}.
   *
   * <p>Method under test: {@link Json#displayName()}
   */
  @Test
  @DisplayName("Test Json displayName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.displayName()"})
  void testJsonDisplayName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().displayName());
  }

  /**
   * Test Json {@link Json#email()}.
   *
   * <p>Method under test: {@link Json#email()}
   */
  @Test
  @DisplayName("Test Json email()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.email()"})
  void testJsonEmail() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().email());
  }

  /**
   * Test Json {@link Json#employeeId()}.
   *
   * <p>Method under test: {@link Json#employeeId()}
   */
  @Test
  @DisplayName("Test Json employeeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.employeeId()"})
  void testJsonEmployeeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().employeeId());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#isRemoved()}.
   *
   * <p>Method under test: {@link Json#isRemoved()}
   */
  @Test
  @DisplayName("Test Json isRemoved()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isRemoved()"})
  void testJsonIsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isRemoved());
  }

  /**
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
  }

  /**
   * Test Json {@link Json#managerEmployeeId()}.
   *
   * <p>Method under test: {@link Json#managerEmployeeId()}
   */
  @Test
  @DisplayName("Test Json managerEmployeeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.managerEmployeeId()"})
  void testJsonManagerEmployeeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().managerEmployeeId());
  }

  /**
   * Test Json {@link Json#mobilePhone()}.
   *
   * <p>Method under test: {@link Json#mobilePhone()}
   */
  @Test
  @DisplayName("Test Json mobilePhone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.mobilePhone()"})
  void testJsonMobilePhone() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().mobilePhone());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
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
   * Test Json {@link Json#officePhone()}.
   *
   * <p>Method under test: {@link Json#officePhone()}
   */
  @Test
  @DisplayName("Test Json officePhone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.officePhone()"})
  void testJsonOfficePhone() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().officePhone());
  }

  /**
   * Test Json {@link Json#organisationalUnitId()}.
   *
   * <p>Method under test: {@link Json#organisationalUnitId()}
   */
  @Test
  @DisplayName("Test Json organisationalUnitId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.organisationalUnitId()"})
  void testJsonOrganisationalUnitId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().organisationalUnitId());
  }

  /**
   * Test Json {@link Json#personKind()}.
   *
   * <p>Method under test: {@link Json#personKind()}
   */
  @Test
  @DisplayName("Test Json personKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PersonKind Json.personKind()"})
  void testJsonPersonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().personKind());
  }

  /**
   * Test Json {@link Json#setIsRemoved(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsRemoved(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsRemoved(boolean)"})
  void testJsonSetIsRemoved() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsRemoved(true);

    // Assert
    assertTrue(json.isRemoved);
    assertTrue(json.isRemovedIsSet);
  }

  /**
   * Test Json {@link Json#title()}.
   *
   * <p>Method under test: {@link Json#title()}
   */
  @Test
  @DisplayName("Test Json title()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.title()"})
  void testJsonTitle() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().title());
  }

  /**
   * Test Json {@link Json#userId()}.
   *
   * <p>Method under test: {@link Json#userId()}
   */
  @Test
  @DisplayName("Test Json userId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.userId()"})
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().userId());
  }

  /**
   * Test Json {@link Json#userPrincipalName()}.
   *
   * <p>Method under test: {@link Json#userPrincipalName()}
   */
  @Test
  @DisplayName("Test Json userPrincipalName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.userPrincipalName()"})
  void testJsonUserPrincipalName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().userPrincipalName());
  }

  /**
   * Test {@link ImmutablePerson#kind()}.
   *
   * <p>Method under test: {@link ImmutablePerson#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutablePerson.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
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
            .kind());
  }

  /**
   * Test {@link ImmutablePerson#managerEmployeeId()}.
   *
   * <p>Method under test: {@link ImmutablePerson#managerEmployeeId()}
   */
  @Test
  @DisplayName("Test managerEmployeeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePerson.managerEmployeeId()"})
  void testManagerEmployeeId() {
    // Arrange and Act
    Optional<String> actualManagerEmployeeIdResult =
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
            .managerEmployeeId();

    // Assert
    assertEquals("42", actualManagerEmployeeIdResult.get());
    assertTrue(actualManagerEmployeeIdResult.isPresent());
  }

  /**
   * Test {@link ImmutablePerson#mobilePhone()}.
   *
   * <p>Method under test: {@link ImmutablePerson#mobilePhone()}
   */
  @Test
  @DisplayName("Test mobilePhone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePerson.mobilePhone()"})
  void testMobilePhone() {
    // Arrange and Act
    Optional<String> actualMobilePhoneResult =
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
            .mobilePhone();

    // Assert
    assertEquals("6625550144", actualMobilePhoneResult.get());
    assertTrue(actualMobilePhoneResult.isPresent());
  }

  /**
   * Test {@link ImmutablePerson#name()}.
   *
   * <p>Method under test: {@link ImmutablePerson#name()}
   */
  @Test
  @DisplayName("Test name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePerson.name()"})
  void testName() {
    // Arrange, Act and Assert
    assertEquals(
        "Display Name",
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
            .name());
  }

  /**
   * Test {@link ImmutablePerson#officePhone()}.
   *
   * <p>Method under test: {@link ImmutablePerson#officePhone()}
   */
  @Test
  @DisplayName("Test officePhone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePerson.officePhone()"})
  void testOfficePhone() {
    // Arrange and Act
    Optional<String> actualOfficePhoneResult =
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
            .officePhone();

    // Assert
    assertEquals("6625550144", actualOfficePhoneResult.get());
    assertTrue(actualOfficePhoneResult.isPresent());
  }

  /**
   * Test {@link ImmutablePerson#organisationalUnitId()}.
   *
   * <p>Method under test: {@link ImmutablePerson#organisationalUnitId()}
   */
  @Test
  @DisplayName("Test organisationalUnitId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePerson.organisationalUnitId()"})
  void testOrganisationalUnitId() {
    // Arrange and Act
    Optional<Long> actualOrganisationalUnitIdResult =
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
            .organisationalUnitId();

    // Assert
    assertEquals(1L, actualOrganisationalUnitIdResult.get().longValue());
    assertTrue(actualOrganisationalUnitIdResult.isPresent());
  }

  /**
   * Test {@link ImmutablePerson#title()}.
   *
   * <p>Method under test: {@link ImmutablePerson#title()}
   */
  @Test
  @DisplayName("Test title()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePerson.title()"})
  void testTitle() {
    // Arrange and Act
    Optional<String> actualTitleResult =
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
            .title();

    // Assert
    assertEquals("Dr", actualTitleResult.get());
    assertTrue(actualTitleResult.isPresent());
  }

  /**
   * Test {@link ImmutablePerson#toString()}.
   *
   * <p>Method under test: {@link ImmutablePerson#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePerson.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "Person{id=1, employeeId=42, displayName=Display Name, email=jane.doe@example.org, isRemoved=true,"
            + " personKind=EMPLOYEE, title=Dr, mobilePhone=6625550144, officePhone=6625550144, userPrincipalName=User"
            + " Principal Name, managerEmployeeId=42, departmentName=Department Name, organisationalUnitId=1,"
            + " name=Display Name, userId=42, kind=ALL}",
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
            .toString());
  }

  /**
   * Test {@link ImmutablePerson#userId()}.
   *
   * <p>Method under test: {@link ImmutablePerson#userId()}
   */
  @Test
  @DisplayName("Test userId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePerson.userId()"})
  void testUserId() {
    // Arrange, Act and Assert
    assertEquals(
        "42",
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
            .userId());
  }

  /**
   * Test {@link ImmutablePerson#userPrincipalName()}.
   *
   * <p>Method under test: {@link ImmutablePerson#userPrincipalName()}
   */
  @Test
  @DisplayName("Test userPrincipalName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePerson.userPrincipalName()"})
  void testUserPrincipalName() {
    // Arrange and Act
    Optional<String> actualUserPrincipalNameResult =
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
            .userPrincipalName();

    // Assert
    assertEquals("User Principal Name", actualUserPrincipalNameResult.get());
    assertTrue(actualUserPrincipalNameResult.isPresent());
  }

  /**
   * Test {@link ImmutablePerson#withDepartmentName(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePerson#withDepartmentName(Optional)}
   */
  @Test
  @DisplayName("Test withDepartmentName(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withDepartmentName(Optional)"})
  void testWithDepartmentNameWithOptional() {
    // Arrange
    ImmutablePerson immutablePerson =
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
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePerson actualWithDepartmentNameResult = immutablePerson.withDepartmentName(optional);

    // Assert
    assertSame(immutablePerson, actualWithDepartmentNameResult);
  }

  /**
   * Test {@link ImmutablePerson#withDepartmentName(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withDepartmentName(Optional)}
   */
  @Test
  @DisplayName("Test withDepartmentName(Optional) with 'optional'; then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withDepartmentName(Optional)"})
  void testWithDepartmentNameWithOptional_thenReturnEmployeeIdIs42() {
    // Arrange
    ImmutablePerson immutablePerson =
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
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePerson actualWithDepartmentNameResult = immutablePerson.withDepartmentName(optional);

    // Assert
    assertEquals("42", actualWithDepartmentNameResult.employeeId());
    assertEquals("42", actualWithDepartmentNameResult.userId());
    assertEquals("Display Name", actualWithDepartmentNameResult.displayName());
    assertEquals("Display Name", actualWithDepartmentNameResult.name());
    assertEquals("jane.doe@example.org", actualWithDepartmentNameResult.email());
    assertEquals(EntityKind.ALL, actualWithDepartmentNameResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithDepartmentNameResult.personKind());
    assertTrue(actualWithDepartmentNameResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withDepartmentName(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePerson#withDepartmentName(String)}
   */
  @Test
  @DisplayName("Test withDepartmentName(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withDepartmentName(String)"})
  void testWithDepartmentNameWithValue() {
    // Arrange
    ImmutablePerson immutablePerson =
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
            .build();

    // Act
    ImmutablePerson actualWithDepartmentNameResult = immutablePerson.withDepartmentName("42");

    // Assert
    assertSame(immutablePerson, actualWithDepartmentNameResult);
  }

  /**
   * Test {@link ImmutablePerson#withDepartmentName(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withDepartmentName(String)}
   */
  @Test
  @DisplayName("Test withDepartmentName(String) with 'value'; then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withDepartmentName(String)"})
  void testWithDepartmentNameWithValue_thenReturnEmployeeIdIs42() {
    // Arrange and Act
    ImmutablePerson actualWithDepartmentNameResult =
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
            .withDepartmentName("42");

    // Assert
    assertEquals("42", actualWithDepartmentNameResult.employeeId());
    assertEquals("42", actualWithDepartmentNameResult.userId());
    assertEquals("Display Name", actualWithDepartmentNameResult.displayName());
    assertEquals("Display Name", actualWithDepartmentNameResult.name());
    assertEquals("jane.doe@example.org", actualWithDepartmentNameResult.email());
    assertEquals(EntityKind.ALL, actualWithDepartmentNameResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithDepartmentNameResult.personKind());
    assertTrue(actualWithDepartmentNameResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withDisplayName(String)}.
   *
   * <p>Method under test: {@link ImmutablePerson#withDisplayName(String)}
   */
  @Test
  @DisplayName("Test withDisplayName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withDisplayName(String)"})
  void testWithDisplayName() {
    // Arrange
    ImmutablePerson immutablePerson =
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("42")
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

    // Act
    ImmutablePerson actualWithDisplayNameResult = immutablePerson.withDisplayName("42");

    // Assert
    assertSame(immutablePerson, actualWithDisplayNameResult);
  }

  /**
   * Test {@link ImmutablePerson#withDisplayName(String)}.
   *
   * <ul>
   *   <li>Then return displayName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withDisplayName(String)}
   */
  @Test
  @DisplayName("Test withDisplayName(String); then return displayName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withDisplayName(String)"})
  void testWithDisplayName_thenReturnDisplayNameIs42() {
    // Arrange and Act
    ImmutablePerson actualWithDisplayNameResult =
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
            .withDisplayName("42");

    // Assert
    assertEquals("42", actualWithDisplayNameResult.displayName());
    assertEquals("42", actualWithDisplayNameResult.employeeId());
    assertEquals("42", actualWithDisplayNameResult.name());
    assertEquals("42", actualWithDisplayNameResult.userId());
    assertEquals("jane.doe@example.org", actualWithDisplayNameResult.email());
    assertEquals(EntityKind.ALL, actualWithDisplayNameResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithDisplayNameResult.personKind());
    assertTrue(actualWithDisplayNameResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withEmail(String)}.
   *
   * <p>Method under test: {@link ImmutablePerson#withEmail(String)}
   */
  @Test
  @DisplayName("Test withEmail(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withEmail(String)"})
  void testWithEmail() {
    // Arrange
    ImmutablePerson immutablePerson =
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("42")
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

    // Act
    ImmutablePerson actualWithEmailResult = immutablePerson.withEmail("42");

    // Assert
    assertSame(immutablePerson, actualWithEmailResult);
  }

  /**
   * Test {@link ImmutablePerson#withEmail(String)}.
   *
   * <ul>
   *   <li>Then return email is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withEmail(String)}
   */
  @Test
  @DisplayName("Test withEmail(String); then return email is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withEmail(String)"})
  void testWithEmail_thenReturnEmailIs42() {
    // Arrange and Act
    ImmutablePerson actualWithEmailResult =
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
            .withEmail("42");

    // Assert
    assertEquals("42", actualWithEmailResult.email());
    assertEquals("42", actualWithEmailResult.employeeId());
    assertEquals("42", actualWithEmailResult.userId());
    assertEquals("Display Name", actualWithEmailResult.displayName());
    assertEquals("Display Name", actualWithEmailResult.name());
    assertEquals(EntityKind.ALL, actualWithEmailResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithEmailResult.personKind());
    assertTrue(actualWithEmailResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withEmployeeId(String)}.
   *
   * <p>Method under test: {@link ImmutablePerson#withEmployeeId(String)}
   */
  @Test
  @DisplayName("Test withEmployeeId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withEmployeeId(String)"})
  void testWithEmployeeId() {
    // Arrange
    ImmutablePerson immutablePerson =
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

    // Act
    ImmutablePerson actualWithEmployeeIdResult = immutablePerson.withEmployeeId("42");

    // Assert
    assertSame(immutablePerson, actualWithEmployeeIdResult);
  }

  /**
   * Test {@link ImmutablePerson#withEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withEmployeeId(String)}
   */
  @Test
  @DisplayName("Test withEmployeeId(String); then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withEmployeeId(String)"})
  void testWithEmployeeId_thenReturnEmployeeIdIs42() {
    // Arrange and Act
    ImmutablePerson actualWithEmployeeIdResult =
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("employeeId")
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
            .withEmployeeId("42");

    // Assert
    assertEquals("42", actualWithEmployeeIdResult.employeeId());
    assertEquals("42", actualWithEmployeeIdResult.userId());
    assertEquals("Display Name", actualWithEmployeeIdResult.displayName());
    assertEquals("Display Name", actualWithEmployeeIdResult.name());
    assertEquals("jane.doe@example.org", actualWithEmployeeIdResult.email());
    assertEquals(EntityKind.ALL, actualWithEmployeeIdResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithEmployeeIdResult.personKind());
    assertTrue(actualWithEmployeeIdResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePerson#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutablePerson immutablePerson =
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
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutablePerson actualWithIdResult = immutablePerson.withId(optional);

    // Assert
    assertSame(immutablePerson, actualWithIdResult);
  }

  /**
   * Test {@link ImmutablePerson#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; when of forty-two; then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withId(Optional)"})
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnEmployeeIdIs42() {
    // Arrange
    ImmutablePerson immutablePerson =
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
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutablePerson actualWithIdResult = immutablePerson.withId(optional);

    // Assert
    assertEquals("42", actualWithIdResult.employeeId());
    assertEquals("42", actualWithIdResult.userId());
    assertEquals("Display Name", actualWithIdResult.displayName());
    assertEquals("Display Name", actualWithIdResult.name());
    assertEquals("jane.doe@example.org", actualWithIdResult.email());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithIdResult.personKind());
    assertTrue(actualWithIdResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePerson#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutablePerson immutablePerson =
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

    // Act
    ImmutablePerson actualWithIdResult = immutablePerson.withId(1L);

    // Assert
    assertSame(immutablePerson, actualWithIdResult);
  }

  /**
   * Test {@link ImmutablePerson#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnEmployeeIdIs42() {
    // Arrange and Act
    ImmutablePerson actualWithIdResult =
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
            .withId(42L);

    // Assert
    assertEquals("42", actualWithIdResult.employeeId());
    assertEquals("42", actualWithIdResult.userId());
    assertEquals("Display Name", actualWithIdResult.displayName());
    assertEquals("Display Name", actualWithIdResult.name());
    assertEquals("jane.doe@example.org", actualWithIdResult.email());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithIdResult.personKind());
    assertTrue(actualWithIdResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withIsRemoved(boolean)}.
   *
   * <p>Method under test: {@link ImmutablePerson#withIsRemoved(boolean)}
   */
  @Test
  @DisplayName("Test withIsRemoved(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withIsRemoved(boolean)"})
  void testWithIsRemoved() {
    // Arrange
    ImmutablePerson immutablePerson =
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

    // Act
    ImmutablePerson actualWithIsRemovedResult = immutablePerson.withIsRemoved(true);

    // Assert
    assertSame(immutablePerson, actualWithIsRemovedResult);
  }

  /**
   * Test {@link ImmutablePerson#withIsRemoved(boolean)}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withIsRemoved(boolean)}
   */
  @Test
  @DisplayName("Test withIsRemoved(boolean); then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withIsRemoved(boolean)"})
  void testWithIsRemoved_thenReturnEmployeeIdIs42() {
    // Arrange and Act
    ImmutablePerson actualWithIsRemovedResult =
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
            .withIsRemoved(true);

    // Assert
    assertEquals("42", actualWithIsRemovedResult.employeeId());
    assertEquals("42", actualWithIsRemovedResult.userId());
    assertEquals("Display Name", actualWithIsRemovedResult.displayName());
    assertEquals("Display Name", actualWithIsRemovedResult.name());
    assertEquals("jane.doe@example.org", actualWithIsRemovedResult.email());
    assertEquals(EntityKind.ALL, actualWithIsRemovedResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithIsRemovedResult.personKind());
    assertTrue(actualWithIsRemovedResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutablePerson#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    ImmutablePerson immutablePerson =
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

    // Act
    ImmutablePerson actualWithKindResult = immutablePerson.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutablePerson, actualWithKindResult);
  }

  /**
   * Test {@link ImmutablePerson#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withKind(EntityKind)"})
  void testWithKind_thenReturnEmployeeIdIs42() {
    // Arrange and Act
    ImmutablePerson actualWithKindResult =
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("42")
            .id(1L)
            .isRemoved(true)
            .kind(EntityKind.ACTOR)
            .managerEmployeeId("42")
            .mobilePhone("6625550144")
            .officePhone("6625550144")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("42", actualWithKindResult.employeeId());
    assertEquals("42", actualWithKindResult.userId());
    assertEquals("Display Name", actualWithKindResult.displayName());
    assertEquals("Display Name", actualWithKindResult.name());
    assertEquals("jane.doe@example.org", actualWithKindResult.email());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithKindResult.personKind());
    assertTrue(actualWithKindResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withManagerEmployeeId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePerson#withManagerEmployeeId(Optional)}
   */
  @Test
  @DisplayName("Test withManagerEmployeeId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withManagerEmployeeId(Optional)"})
  void testWithManagerEmployeeIdWithOptional() {
    // Arrange
    ImmutablePerson immutablePerson =
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
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePerson actualWithManagerEmployeeIdResult =
        immutablePerson.withManagerEmployeeId(optional);

    // Assert
    assertSame(immutablePerson, actualWithManagerEmployeeIdResult);
  }

  /**
   * Test {@link ImmutablePerson#withManagerEmployeeId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withManagerEmployeeId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withManagerEmployeeId(Optional) with 'optional'; then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withManagerEmployeeId(Optional)"})
  void testWithManagerEmployeeIdWithOptional_thenReturnEmployeeIdIs42() {
    // Arrange
    ImmutablePerson immutablePerson =
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("42")
            .id(1L)
            .isRemoved(true)
            .kind(EntityKind.ALL)
            .managerEmployeeId("Manager Employee Id")
            .mobilePhone("6625550144")
            .officePhone("6625550144")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePerson actualWithManagerEmployeeIdResult =
        immutablePerson.withManagerEmployeeId(optional);

    // Assert
    assertEquals("42", actualWithManagerEmployeeIdResult.employeeId());
    assertEquals("42", actualWithManagerEmployeeIdResult.userId());
    assertEquals("Display Name", actualWithManagerEmployeeIdResult.displayName());
    assertEquals("Display Name", actualWithManagerEmployeeIdResult.name());
    assertEquals("jane.doe@example.org", actualWithManagerEmployeeIdResult.email());
    assertEquals(EntityKind.ALL, actualWithManagerEmployeeIdResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithManagerEmployeeIdResult.personKind());
    assertTrue(actualWithManagerEmployeeIdResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withManagerEmployeeId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePerson#withManagerEmployeeId(String)}
   */
  @Test
  @DisplayName("Test withManagerEmployeeId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withManagerEmployeeId(String)"})
  void testWithManagerEmployeeIdWithValue() {
    // Arrange
    ImmutablePerson immutablePerson =
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

    // Act
    ImmutablePerson actualWithManagerEmployeeIdResult = immutablePerson.withManagerEmployeeId("42");

    // Assert
    assertSame(immutablePerson, actualWithManagerEmployeeIdResult);
  }

  /**
   * Test {@link ImmutablePerson#withManagerEmployeeId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withManagerEmployeeId(String)}
   */
  @Test
  @DisplayName("Test withManagerEmployeeId(String) with 'value'; then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withManagerEmployeeId(String)"})
  void testWithManagerEmployeeIdWithValue_thenReturnEmployeeIdIs42() {
    // Arrange and Act
    ImmutablePerson actualWithManagerEmployeeIdResult =
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("42")
            .id(1L)
            .isRemoved(true)
            .kind(EntityKind.ALL)
            .managerEmployeeId("managerEmployeeId")
            .mobilePhone("6625550144")
            .officePhone("6625550144")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build()
            .withManagerEmployeeId("42");

    // Assert
    assertEquals("42", actualWithManagerEmployeeIdResult.employeeId());
    assertEquals("42", actualWithManagerEmployeeIdResult.userId());
    assertEquals("Display Name", actualWithManagerEmployeeIdResult.displayName());
    assertEquals("Display Name", actualWithManagerEmployeeIdResult.name());
    assertEquals("jane.doe@example.org", actualWithManagerEmployeeIdResult.email());
    assertEquals(EntityKind.ALL, actualWithManagerEmployeeIdResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithManagerEmployeeIdResult.personKind());
    assertTrue(actualWithManagerEmployeeIdResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withMobilePhone(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePerson#withMobilePhone(Optional)}
   */
  @Test
  @DisplayName("Test withMobilePhone(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withMobilePhone(Optional)"})
  void testWithMobilePhoneWithOptional() {
    // Arrange
    ImmutablePerson immutablePerson =
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("42")
            .id(1L)
            .isRemoved(true)
            .kind(EntityKind.ALL)
            .managerEmployeeId("42")
            .mobilePhone("42")
            .officePhone("6625550144")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePerson actualWithMobilePhoneResult = immutablePerson.withMobilePhone(optional);

    // Assert
    assertSame(immutablePerson, actualWithMobilePhoneResult);
  }

  /**
   * Test {@link ImmutablePerson#withMobilePhone(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withMobilePhone(Optional)}
   */
  @Test
  @DisplayName("Test withMobilePhone(Optional) with 'optional'; then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withMobilePhone(Optional)"})
  void testWithMobilePhoneWithOptional_thenReturnEmployeeIdIs42() {
    // Arrange
    ImmutablePerson immutablePerson =
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
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePerson actualWithMobilePhoneResult = immutablePerson.withMobilePhone(optional);

    // Assert
    assertEquals("42", actualWithMobilePhoneResult.employeeId());
    assertEquals("42", actualWithMobilePhoneResult.userId());
    assertEquals("Display Name", actualWithMobilePhoneResult.displayName());
    assertEquals("Display Name", actualWithMobilePhoneResult.name());
    assertEquals("jane.doe@example.org", actualWithMobilePhoneResult.email());
    assertEquals(EntityKind.ALL, actualWithMobilePhoneResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithMobilePhoneResult.personKind());
    assertTrue(actualWithMobilePhoneResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withMobilePhone(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePerson#withMobilePhone(String)}
   */
  @Test
  @DisplayName("Test withMobilePhone(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withMobilePhone(String)"})
  void testWithMobilePhoneWithValue() {
    // Arrange
    ImmutablePerson immutablePerson =
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("42")
            .id(1L)
            .isRemoved(true)
            .kind(EntityKind.ALL)
            .managerEmployeeId("42")
            .mobilePhone("42")
            .officePhone("6625550144")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build();

    // Act
    ImmutablePerson actualWithMobilePhoneResult = immutablePerson.withMobilePhone("42");

    // Assert
    assertSame(immutablePerson, actualWithMobilePhoneResult);
  }

  /**
   * Test {@link ImmutablePerson#withMobilePhone(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withMobilePhone(String)}
   */
  @Test
  @DisplayName("Test withMobilePhone(String) with 'value'; then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withMobilePhone(String)"})
  void testWithMobilePhoneWithValue_thenReturnEmployeeIdIs42() {
    // Arrange and Act
    ImmutablePerson actualWithMobilePhoneResult =
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
            .withMobilePhone("42");

    // Assert
    assertEquals("42", actualWithMobilePhoneResult.employeeId());
    assertEquals("42", actualWithMobilePhoneResult.userId());
    assertEquals("Display Name", actualWithMobilePhoneResult.displayName());
    assertEquals("Display Name", actualWithMobilePhoneResult.name());
    assertEquals("jane.doe@example.org", actualWithMobilePhoneResult.email());
    assertEquals(EntityKind.ALL, actualWithMobilePhoneResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithMobilePhoneResult.personKind());
    assertTrue(actualWithMobilePhoneResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withOfficePhone(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePerson#withOfficePhone(Optional)}
   */
  @Test
  @DisplayName("Test withOfficePhone(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withOfficePhone(Optional)"})
  void testWithOfficePhoneWithOptional() {
    // Arrange
    ImmutablePerson immutablePerson =
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
            .officePhone("42")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePerson actualWithOfficePhoneResult = immutablePerson.withOfficePhone(optional);

    // Assert
    assertSame(immutablePerson, actualWithOfficePhoneResult);
  }

  /**
   * Test {@link ImmutablePerson#withOfficePhone(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withOfficePhone(Optional)}
   */
  @Test
  @DisplayName("Test withOfficePhone(Optional) with 'optional'; then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withOfficePhone(Optional)"})
  void testWithOfficePhoneWithOptional_thenReturnEmployeeIdIs42() {
    // Arrange
    ImmutablePerson immutablePerson =
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
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePerson actualWithOfficePhoneResult = immutablePerson.withOfficePhone(optional);

    // Assert
    assertEquals("42", actualWithOfficePhoneResult.employeeId());
    assertEquals("42", actualWithOfficePhoneResult.userId());
    assertEquals("Display Name", actualWithOfficePhoneResult.displayName());
    assertEquals("Display Name", actualWithOfficePhoneResult.name());
    assertEquals("jane.doe@example.org", actualWithOfficePhoneResult.email());
    assertEquals(EntityKind.ALL, actualWithOfficePhoneResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithOfficePhoneResult.personKind());
    assertTrue(actualWithOfficePhoneResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withOfficePhone(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePerson#withOfficePhone(String)}
   */
  @Test
  @DisplayName("Test withOfficePhone(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withOfficePhone(String)"})
  void testWithOfficePhoneWithValue() {
    // Arrange
    ImmutablePerson immutablePerson =
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
            .officePhone("42")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build();

    // Act
    ImmutablePerson actualWithOfficePhoneResult = immutablePerson.withOfficePhone("42");

    // Assert
    assertSame(immutablePerson, actualWithOfficePhoneResult);
  }

  /**
   * Test {@link ImmutablePerson#withOfficePhone(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withOfficePhone(String)}
   */
  @Test
  @DisplayName("Test withOfficePhone(String) with 'value'; then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withOfficePhone(String)"})
  void testWithOfficePhoneWithValue_thenReturnEmployeeIdIs42() {
    // Arrange and Act
    ImmutablePerson actualWithOfficePhoneResult =
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
            .withOfficePhone("42");

    // Assert
    assertEquals("42", actualWithOfficePhoneResult.employeeId());
    assertEquals("42", actualWithOfficePhoneResult.userId());
    assertEquals("Display Name", actualWithOfficePhoneResult.displayName());
    assertEquals("Display Name", actualWithOfficePhoneResult.name());
    assertEquals("jane.doe@example.org", actualWithOfficePhoneResult.email());
    assertEquals(EntityKind.ALL, actualWithOfficePhoneResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithOfficePhoneResult.personKind());
    assertTrue(actualWithOfficePhoneResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withOrganisationalUnitId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePerson#withOrganisationalUnitId(Optional)}
   */
  @Test
  @DisplayName("Test withOrganisationalUnitId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withOrganisationalUnitId(Optional)"})
  void testWithOrganisationalUnitIdWithOptional() {
    // Arrange
    ImmutablePerson immutablePerson =
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
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutablePerson actualWithOrganisationalUnitIdResult =
        immutablePerson.withOrganisationalUnitId(optional);

    // Assert
    assertSame(immutablePerson, actualWithOrganisationalUnitIdResult);
  }

  /**
   * Test {@link ImmutablePerson#withOrganisationalUnitId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withOrganisationalUnitId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withOrganisationalUnitId(Optional) with 'optional'; when of forty-two; then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withOrganisationalUnitId(Optional)"})
  void testWithOrganisationalUnitIdWithOptional_whenOfFortyTwo_thenReturnEmployeeIdIs42() {
    // Arrange
    ImmutablePerson immutablePerson =
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
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutablePerson actualWithOrganisationalUnitIdResult =
        immutablePerson.withOrganisationalUnitId(optional);

    // Assert
    assertEquals("42", actualWithOrganisationalUnitIdResult.employeeId());
    assertEquals("42", actualWithOrganisationalUnitIdResult.userId());
    assertEquals("Display Name", actualWithOrganisationalUnitIdResult.displayName());
    assertEquals("Display Name", actualWithOrganisationalUnitIdResult.name());
    assertEquals("jane.doe@example.org", actualWithOrganisationalUnitIdResult.email());
    assertEquals(EntityKind.ALL, actualWithOrganisationalUnitIdResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithOrganisationalUnitIdResult.personKind());
    assertTrue(actualWithOrganisationalUnitIdResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withOrganisationalUnitId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePerson#withOrganisationalUnitId(long)}
   */
  @Test
  @DisplayName("Test withOrganisationalUnitId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withOrganisationalUnitId(long)"})
  void testWithOrganisationalUnitIdWithValue() {
    // Arrange
    ImmutablePerson immutablePerson =
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

    // Act
    ImmutablePerson actualWithOrganisationalUnitIdResult =
        immutablePerson.withOrganisationalUnitId(1L);

    // Assert
    assertSame(immutablePerson, actualWithOrganisationalUnitIdResult);
  }

  /**
   * Test {@link ImmutablePerson#withOrganisationalUnitId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withOrganisationalUnitId(long)}
   */
  @Test
  @DisplayName(
      "Test withOrganisationalUnitId(long) with 'value'; when forty-two; then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withOrganisationalUnitId(long)"})
  void testWithOrganisationalUnitIdWithValue_whenFortyTwo_thenReturnEmployeeIdIs42() {
    // Arrange and Act
    ImmutablePerson actualWithOrganisationalUnitIdResult =
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
            .withOrganisationalUnitId(42L);

    // Assert
    assertEquals("42", actualWithOrganisationalUnitIdResult.employeeId());
    assertEquals("42", actualWithOrganisationalUnitIdResult.userId());
    assertEquals("Display Name", actualWithOrganisationalUnitIdResult.displayName());
    assertEquals("Display Name", actualWithOrganisationalUnitIdResult.name());
    assertEquals("jane.doe@example.org", actualWithOrganisationalUnitIdResult.email());
    assertEquals(EntityKind.ALL, actualWithOrganisationalUnitIdResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithOrganisationalUnitIdResult.personKind());
    assertTrue(actualWithOrganisationalUnitIdResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withPersonKind(PersonKind)}.
   *
   * <p>Method under test: {@link ImmutablePerson#withPersonKind(PersonKind)}
   */
  @Test
  @DisplayName("Test withPersonKind(PersonKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withPersonKind(PersonKind)"})
  void testWithPersonKind() {
    // Arrange
    ImmutablePerson immutablePerson =
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

    // Act
    ImmutablePerson actualWithPersonKindResult =
        immutablePerson.withPersonKind(PersonKind.EMPLOYEE);

    // Assert
    assertSame(immutablePerson, actualWithPersonKindResult);
  }

  /**
   * Test {@link ImmutablePerson#withPersonKind(PersonKind)}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withPersonKind(PersonKind)}
   */
  @Test
  @DisplayName("Test withPersonKind(PersonKind); then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withPersonKind(PersonKind)"})
  void testWithPersonKind_thenReturnEmployeeIdIs42() {
    // Arrange and Act
    ImmutablePerson actualWithPersonKindResult =
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
            .personKind(PersonKind.CONTRACTOR)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build()
            .withPersonKind(PersonKind.EMPLOYEE);

    // Assert
    assertEquals("42", actualWithPersonKindResult.employeeId());
    assertEquals("42", actualWithPersonKindResult.userId());
    assertEquals("Display Name", actualWithPersonKindResult.displayName());
    assertEquals("Display Name", actualWithPersonKindResult.name());
    assertEquals("jane.doe@example.org", actualWithPersonKindResult.email());
    assertEquals(EntityKind.ALL, actualWithPersonKindResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithPersonKindResult.personKind());
    assertTrue(actualWithPersonKindResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withTitle(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePerson#withTitle(Optional)}
   */
  @Test
  @DisplayName("Test withTitle(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withTitle(Optional)"})
  void testWithTitleWithOptional() {
    // Arrange
    ImmutablePerson immutablePerson =
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
            .title("42")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePerson actualWithTitleResult = immutablePerson.withTitle(optional);

    // Assert
    assertSame(immutablePerson, actualWithTitleResult);
  }

  /**
   * Test {@link ImmutablePerson#withTitle(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withTitle(Optional)}
   */
  @Test
  @DisplayName("Test withTitle(Optional) with 'optional'; then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withTitle(Optional)"})
  void testWithTitleWithOptional_thenReturnEmployeeIdIs42() {
    // Arrange
    ImmutablePerson immutablePerson =
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
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePerson actualWithTitleResult = immutablePerson.withTitle(optional);

    // Assert
    assertEquals("42", actualWithTitleResult.employeeId());
    assertEquals("42", actualWithTitleResult.userId());
    assertEquals("Display Name", actualWithTitleResult.displayName());
    assertEquals("Display Name", actualWithTitleResult.name());
    assertEquals("jane.doe@example.org", actualWithTitleResult.email());
    assertEquals(EntityKind.ALL, actualWithTitleResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithTitleResult.personKind());
    assertTrue(actualWithTitleResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withTitle(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePerson#withTitle(String)}
   */
  @Test
  @DisplayName("Test withTitle(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withTitle(String)"})
  void testWithTitleWithValue() {
    // Arrange
    ImmutablePerson immutablePerson =
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
            .title("42")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build();

    // Act
    ImmutablePerson actualWithTitleResult = immutablePerson.withTitle("42");

    // Assert
    assertSame(immutablePerson, actualWithTitleResult);
  }

  /**
   * Test {@link ImmutablePerson#withTitle(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withTitle(String)}
   */
  @Test
  @DisplayName("Test withTitle(String) with 'value'; then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withTitle(String)"})
  void testWithTitleWithValue_thenReturnEmployeeIdIs42() {
    // Arrange and Act
    ImmutablePerson actualWithTitleResult =
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
            .withTitle("42");

    // Assert
    assertEquals("42", actualWithTitleResult.employeeId());
    assertEquals("42", actualWithTitleResult.userId());
    assertEquals("Display Name", actualWithTitleResult.displayName());
    assertEquals("Display Name", actualWithTitleResult.name());
    assertEquals("jane.doe@example.org", actualWithTitleResult.email());
    assertEquals(EntityKind.ALL, actualWithTitleResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithTitleResult.personKind());
    assertTrue(actualWithTitleResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withUserId(String)}.
   *
   * <p>Method under test: {@link ImmutablePerson#withUserId(String)}
   */
  @Test
  @DisplayName("Test withUserId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withUserId(String)"})
  void testWithUserId() {
    // Arrange
    ImmutablePerson immutablePerson =
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

    // Act
    ImmutablePerson actualWithUserIdResult = immutablePerson.withUserId("42");

    // Assert
    assertSame(immutablePerson, actualWithUserIdResult);
  }

  /**
   * Test {@link ImmutablePerson#withUserId(String)}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withUserId(String)}
   */
  @Test
  @DisplayName("Test withUserId(String); then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withUserId(String)"})
  void testWithUserId_thenReturnEmployeeIdIs42() {
    // Arrange and Act
    ImmutablePerson actualWithUserIdResult =
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
            .userId("userId")
            .userPrincipalName("User Principal Name")
            .build()
            .withUserId("42");

    // Assert
    assertEquals("42", actualWithUserIdResult.employeeId());
    assertEquals("42", actualWithUserIdResult.userId());
    assertEquals("Display Name", actualWithUserIdResult.displayName());
    assertEquals("Display Name", actualWithUserIdResult.name());
    assertEquals("jane.doe@example.org", actualWithUserIdResult.email());
    assertEquals(EntityKind.ALL, actualWithUserIdResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithUserIdResult.personKind());
    assertTrue(actualWithUserIdResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withUserPrincipalName(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePerson#withUserPrincipalName(Optional)}
   */
  @Test
  @DisplayName("Test withUserPrincipalName(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withUserPrincipalName(Optional)"})
  void testWithUserPrincipalNameWithOptional() {
    // Arrange
    ImmutablePerson immutablePerson =
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
            .userPrincipalName("42")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePerson actualWithUserPrincipalNameResult =
        immutablePerson.withUserPrincipalName(optional);

    // Assert
    assertSame(immutablePerson, actualWithUserPrincipalNameResult);
  }

  /**
   * Test {@link ImmutablePerson#withUserPrincipalName(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withUserPrincipalName(Optional)}
   */
  @Test
  @DisplayName(
      "Test withUserPrincipalName(Optional) with 'optional'; then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withUserPrincipalName(Optional)"})
  void testWithUserPrincipalNameWithOptional_thenReturnEmployeeIdIs42() {
    // Arrange
    ImmutablePerson immutablePerson =
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
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePerson actualWithUserPrincipalNameResult =
        immutablePerson.withUserPrincipalName(optional);

    // Assert
    assertEquals("42", actualWithUserPrincipalNameResult.employeeId());
    assertEquals("42", actualWithUserPrincipalNameResult.userId());
    assertEquals("Display Name", actualWithUserPrincipalNameResult.displayName());
    assertEquals("Display Name", actualWithUserPrincipalNameResult.name());
    assertEquals("jane.doe@example.org", actualWithUserPrincipalNameResult.email());
    assertEquals(EntityKind.ALL, actualWithUserPrincipalNameResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithUserPrincipalNameResult.personKind());
    assertTrue(actualWithUserPrincipalNameResult.isRemoved());
  }

  /**
   * Test {@link ImmutablePerson#withUserPrincipalName(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePerson#withUserPrincipalName(String)}
   */
  @Test
  @DisplayName("Test withUserPrincipalName(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withUserPrincipalName(String)"})
  void testWithUserPrincipalNameWithValue() {
    // Arrange
    ImmutablePerson immutablePerson =
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
            .userPrincipalName("42")
            .build();

    // Act
    ImmutablePerson actualWithUserPrincipalNameResult = immutablePerson.withUserPrincipalName("42");

    // Assert
    assertSame(immutablePerson, actualWithUserPrincipalNameResult);
  }

  /**
   * Test {@link ImmutablePerson#withUserPrincipalName(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerson#withUserPrincipalName(String)}
   */
  @Test
  @DisplayName("Test withUserPrincipalName(String) with 'value'; then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePerson ImmutablePerson.withUserPrincipalName(String)"})
  void testWithUserPrincipalNameWithValue_thenReturnEmployeeIdIs42() {
    // Arrange and Act
    ImmutablePerson actualWithUserPrincipalNameResult =
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
            .withUserPrincipalName("42");

    // Assert
    assertEquals("42", actualWithUserPrincipalNameResult.employeeId());
    assertEquals("42", actualWithUserPrincipalNameResult.userId());
    assertEquals("Display Name", actualWithUserPrincipalNameResult.displayName());
    assertEquals("Display Name", actualWithUserPrincipalNameResult.name());
    assertEquals("jane.doe@example.org", actualWithUserPrincipalNameResult.email());
    assertEquals(EntityKind.ALL, actualWithUserPrincipalNameResult.kind());
    assertEquals(PersonKind.EMPLOYEE, actualWithUserPrincipalNameResult.personKind());
    assertTrue(actualWithUserPrincipalNameResult.isRemoved());
  }
}
