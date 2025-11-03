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
   * Test {@link ImmutablePerson#builder()}.
   * <p>
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
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutablePerson Builder.build()", "Builder Builder.departmentName(String)",
      "Builder Builder.kind(EntityKind)", "Builder Builder.managerEmployeeId(String)",
      "Builder Builder.mobilePhone(String)", "Builder Builder.officePhone(String)", "Builder Builder.title(String)",
      "Builder Builder.userId(String)", "Builder Builder.userPrincipalName(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualDepartmentNameResult = ImmutablePerson.builder().departmentName("Department Name");
    Optional<String> departmentName = Optional.of("foo");
    Builder actualIdResult = actualDepartmentNameResult.departmentName(departmentName).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualManagerEmployeeIdResult = actualIdResult.id(id).kind(EntityKind.ALL).managerEmployeeId("42");
    Optional<String> managerEmployeeId = Optional.of("foo");
    Builder actualMobilePhoneResult = actualManagerEmployeeIdResult.managerEmployeeId(managerEmployeeId)
        .mobilePhone("6625550144");
    Optional<String> mobilePhone = Optional.of("foo");
    Builder actualOfficePhoneResult = actualMobilePhoneResult.mobilePhone(mobilePhone).officePhone("6625550144");
    Optional<String> officePhone = Optional.of("foo");
    Builder actualOrganisationalUnitIdResult = actualOfficePhoneResult.officePhone(officePhone)
        .organisationalUnitId(1L);
    Optional<Long> organisationalUnitId = Optional.<Long>of(1L);
    Builder actualTitleResult = actualOrganisationalUnitIdResult.organisationalUnitId(organisationalUnitId).title("Dr");
    Optional<String> title = Optional.of("foo");
    Builder actualUserPrincipalNameResult = actualTitleResult.title(title)
        .userId("42")
        .userPrincipalName("User Principal Name");
    Optional<String> userPrincipalName = Optional.of("foo");

    // Assert
    assertSame(actualUserPrincipalNameResult, actualUserPrincipalNameResult.userPrincipalName(userPrincipalName));
  }

  /**
   * Test Builder {@link Builder#departmentName(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#departmentName(Optional)}
   */
  @Test
  @DisplayName("Test Builder departmentName(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.departmentName(Optional)"})
  void testBuilderDepartmentNameWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    Optional<String> departmentName = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.departmentName(departmentName));
  }

  /**
   * Test Builder {@link Builder#displayName(String)}.
   * <p>
   * Method under test: {@link Builder#displayName(String)}
   */
  @Test
  @DisplayName("Test Builder displayName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.displayName(String)"})
  void testBuilderDisplayName() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.displayName("Display Name"));
  }

  /**
   * Test Builder {@link Builder#email(String)}.
   * <p>
   * Method under test: {@link Builder#email(String)}
   */
  @Test
  @DisplayName("Test Builder email(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.email(String)"})
  void testBuilderEmail() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.email("jane.doe@example.org"));
  }

  /**
   * Test Builder {@link Builder#employeeId(String)}.
   * <p>
   * Method under test: {@link Builder#employeeId(String)}
   */
  @Test
  @DisplayName("Test Builder employeeId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.employeeId(String)"})
  void testBuilderEmployeeId() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.employeeId("42"));
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   * <ul>
   *   <li>Given {@code ALL}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll_thenReturnBuilder() {
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
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(Person)} with {@code Person}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Person} {@link Person#departmentName()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Person)}
   */
  @Test
  @DisplayName("Test Builder from(Person) with 'Person'; given empty; when Person departmentName() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Person)"})
  void testBuilderFromWithPerson_givenEmpty_whenPersonDepartmentNameReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(Person)} with {@code Person}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Person} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Person)}
   */
  @Test
  @DisplayName("Test Builder from(Person) with 'Person'; given empty; when Person id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Person)"})
  void testBuilderFromWithPerson_givenEmpty_whenPersonIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(Person)} with {@code Person}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Person} {@link Person#managerEmployeeId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Person)}
   */
  @Test
  @DisplayName("Test Builder from(Person) with 'Person'; given empty; when Person managerEmployeeId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Person)"})
  void testBuilderFromWithPerson_givenEmpty_whenPersonManagerEmployeeIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(Person)} with {@code Person}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Person} {@link Person#mobilePhone()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Person)}
   */
  @Test
  @DisplayName("Test Builder from(Person) with 'Person'; given empty; when Person mobilePhone() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Person)"})
  void testBuilderFromWithPerson_givenEmpty_whenPersonMobilePhoneReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(Person)} with {@code Person}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Person} {@link Person#officePhone()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Person)}
   */
  @Test
  @DisplayName("Test Builder from(Person) with 'Person'; given empty; when Person officePhone() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Person)"})
  void testBuilderFromWithPerson_givenEmpty_whenPersonOfficePhoneReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(Person)} with {@code Person}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Person} {@link Person#organisationalUnitId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Person)}
   */
  @Test
  @DisplayName("Test Builder from(Person) with 'Person'; given empty; when Person organisationalUnitId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Person)"})
  void testBuilderFromWithPerson_givenEmpty_whenPersonOrganisationalUnitIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(Person)} with {@code Person}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Person} {@link Person#title()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Person)}
   */
  @Test
  @DisplayName("Test Builder from(Person) with 'Person'; given empty; when Person title() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Person)"})
  void testBuilderFromWithPerson_givenEmpty_whenPersonTitleReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(Person)} with {@code Person}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Person} {@link Person#userPrincipalName()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Person)}
   */
  @Test
  @DisplayName("Test Builder from(Person) with 'Person'; given empty; when Person userPrincipalName() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Person)"})
  void testBuilderFromWithPerson_givenEmpty_whenPersonUserPrincipalNameReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(Person)} with {@code Person}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Person)}
   */
  @Test
  @DisplayName("Test Builder from(Person) with 'Person'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Person)"})
  void testBuilderFromWithPerson_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
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
   * Test Builder {@link Builder#from(Person)} with {@code Person}.
   * <ul>
   *   <li>When {@link Person} {@link Person#userPrincipalName()} return {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Person)}
   */
  @Test
  @DisplayName("Test Builder from(Person) with 'Person'; when Person userPrincipalName() return Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Person)"})
  void testBuilderFromWithPerson_whenPersonUserPrincipalNameReturnOptionalWithFoo() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#isRemoved(boolean)}.
   * <p>
   * Method under test: {@link Builder#isRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Builder isRemoved(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isRemoved(boolean)"})
  void testBuilderIsRemoved() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRemoved(true));
  }

  /**
   * Test Builder {@link Builder#managerEmployeeId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#managerEmployeeId(Optional)}
   */
  @Test
  @DisplayName("Test Builder managerEmployeeId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.managerEmployeeId(Optional)"})
  void testBuilderManagerEmployeeIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    Optional<String> managerEmployeeId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.managerEmployeeId(managerEmployeeId));
  }

  /**
   * Test Builder {@link Builder#mobilePhone(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#mobilePhone(Optional)}
   */
  @Test
  @DisplayName("Test Builder mobilePhone(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.mobilePhone(Optional)"})
  void testBuilderMobilePhoneWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    Optional<String> mobilePhone = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.mobilePhone(mobilePhone));
  }

  /**
   * Test Builder {@link Builder#officePhone(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#officePhone(Optional)}
   */
  @Test
  @DisplayName("Test Builder officePhone(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.officePhone(Optional)"})
  void testBuilderOfficePhoneWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    Optional<String> officePhone = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.officePhone(officePhone));
  }

  /**
   * Test Builder {@link Builder#organisationalUnitId(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#organisationalUnitId(long)}
   */
  @Test
  @DisplayName("Test Builder organisationalUnitId(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.organisationalUnitId(long)"})
  void testBuilderOrganisationalUnitIdWithLong() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.organisationalUnitId(1L));
  }

  /**
   * Test Builder {@link Builder#organisationalUnitId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#organisationalUnitId(Optional)}
   */
  @Test
  @DisplayName("Test Builder organisationalUnitId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.organisationalUnitId(Optional)"})
  void testBuilderOrganisationalUnitIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    Optional<Long> organisationalUnitId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.organisationalUnitId(organisationalUnitId));
  }

  /**
   * Test Builder {@link Builder#personKind(PersonKind)}.
   * <p>
   * Method under test: {@link Builder#personKind(PersonKind)}
   */
  @Test
  @DisplayName("Test Builder personKind(PersonKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.personKind(PersonKind)"})
  void testBuilderPersonKind() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.personKind(PersonKind.EMPLOYEE));
  }

  /**
   * Test Builder {@link Builder#title(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#title(Optional)}
   */
  @Test
  @DisplayName("Test Builder title(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.title(Optional)"})
  void testBuilderTitleWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    Optional<String> title = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.title(title));
  }

  /**
   * Test Builder {@link Builder#userPrincipalName(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#userPrincipalName(Optional)}
   */
  @Test
  @DisplayName("Test Builder userPrincipalName(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.userPrincipalName(Optional)"})
  void testBuilderUserPrincipalNameWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePerson.builder();
    Optional<String> userPrincipalName = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.userPrincipalName(userPrincipalName));
  }

  /**
   * Test Json {@link Json#departmentName()}.
   * <p>
   * Method under test: {@link Json#departmentName()}
   */
  @Test
  @DisplayName("Test Json departmentName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.departmentName()"})
  void testJsonDepartmentName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).departmentName());
  }

  /**
   * Test Json {@link Json#displayName()}.
   * <p>
   * Method under test: {@link Json#displayName()}
   */
  @Test
  @DisplayName("Test Json displayName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.displayName()"})
  void testJsonDisplayName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).displayName());
  }

  /**
   * Test Json {@link Json#email()}.
   * <p>
   * Method under test: {@link Json#email()}
   */
  @Test
  @DisplayName("Test Json email()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.email()"})
  void testJsonEmail() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).email());
  }

  /**
   * Test Json {@link Json#employeeId()}.
   * <p>
   * Method under test: {@link Json#employeeId()}
   */
  @Test
  @DisplayName("Test Json employeeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.employeeId()"})
  void testJsonEmployeeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).employeeId());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#isRemoved()}.
   * <p>
   * Method under test: {@link Json#isRemoved()}
   */
  @Test
  @DisplayName("Test Json isRemoved()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isRemoved()"})
  void testJsonIsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isRemoved());
  }

  /**
   * Test Json {@link Json#kind()}.
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
  }

  /**
   * Test Json {@link Json#managerEmployeeId()}.
   * <p>
   * Method under test: {@link Json#managerEmployeeId()}
   */
  @Test
  @DisplayName("Test Json managerEmployeeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.managerEmployeeId()"})
  void testJsonManagerEmployeeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).managerEmployeeId());
  }

  /**
   * Test Json {@link Json#mobilePhone()}.
   * <p>
   * Method under test: {@link Json#mobilePhone()}
   */
  @Test
  @DisplayName("Test Json mobilePhone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.mobilePhone()"})
  void testJsonMobilePhone() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).mobilePhone());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#officePhone()}
   */
  @Test
  @DisplayName("Test Json officePhone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.officePhone()"})
  void testJsonOfficePhone() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).officePhone());
  }

  /**
   * Test Json {@link Json#organisationalUnitId()}.
   * <p>
   * Method under test: {@link Json#organisationalUnitId()}
   */
  @Test
  @DisplayName("Test Json organisationalUnitId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.organisationalUnitId()"})
  void testJsonOrganisationalUnitId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).organisationalUnitId());
  }

  /**
   * Test Json {@link Json#personKind()}.
   * <p>
   * Method under test: {@link Json#personKind()}
   */
  @Test
  @DisplayName("Test Json personKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PersonKind Json.personKind()"})
  void testJsonPersonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).personKind());
  }

  /**
   * Test Json {@link Json#setIsRemoved(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsRemoved(boolean)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#title()}
   */
  @Test
  @DisplayName("Test Json title()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.title()"})
  void testJsonTitle() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).title());
  }

  /**
   * Test Json {@link Json#userId()}.
   * <p>
   * Method under test: {@link Json#userId()}
   */
  @Test
  @DisplayName("Test Json userId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.userId()"})
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).userId());
  }

  /**
   * Test Json {@link Json#userPrincipalName()}.
   * <p>
   * Method under test: {@link Json#userPrincipalName()}
   */
  @Test
  @DisplayName("Test Json userPrincipalName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.userPrincipalName()"})
  void testJsonUserPrincipalName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).userPrincipalName());
  }
}
