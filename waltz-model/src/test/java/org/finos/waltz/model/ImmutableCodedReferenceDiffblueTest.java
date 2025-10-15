package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableCodedReference.Builder;
import org.finos.waltz.model.ImmutableCodedReference.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCodedReferenceDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCodedReference Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableCodedReference actualImmutableCodedReference =
        ImmutableCodedReference.builder().code("Code").name("Name").build();

    // Assert
    assertEquals("Code", actualImmutableCodedReference.code());
    assertEquals("Name", actualImmutableCodedReference.name());
  }

  /**
   * Test Builder {@link Builder#code(String)}.
   *
   * <ul>
   *   <li>When {@code Code}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#code(String)}
   */
  @Test
  @DisplayName("Test Builder code(String); when 'Code'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.code(String)"})
  void testBuilderCode_whenCode_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCodedReference.builder();

    // Act
    Builder actualCodeResult = builderResult.code("Code");

    // Assert
    assertSame(builderResult, actualCodeResult);
  }

  /**
   * Test Builder {@link Builder#from(CodeProvider)} with {@code CodeProvider}.
   *
   * <ul>
   *   <li>Given {@code Code}.
   *   <li>When {@link CodeProvider} {@link CodeProvider#code()} return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CodeProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CodeProvider) with 'CodeProvider'; given 'Code'; when CodeProvider code() return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CodeProvider)"})
  void testBuilderFromWithCodeProvider_givenCode_whenCodeProviderCodeReturnCode() {
    // Arrange
    Builder builderResult = ImmutableCodedReference.builder();

    CodeProvider instance = mock(CodeProvider.class);
    when(instance.code()).thenReturn("Code");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).code();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CodeProvider)} with {@code CodeProvider}.
   *
   * <ul>
   *   <li>Then builder build is builder code {@code Code} name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CodeProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CodeProvider) with 'CodeProvider'; then builder build is builder code 'Code' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CodeProvider)"})
  void testBuilderFromWithCodeProvider_thenBuilderBuildIsBuilderCodeCodeNameNameBuild() {
    // Arrange
    Builder builderResult = ImmutableCodedReference.builder();
    ImmutableCodedReference instance =
        ImmutableCodedReference.builder().code("Code").name("Name").build();

    // Act
    Builder actualFromResult = builderResult.from((CodeProvider) instance);

    // Assert
    ImmutableCodedReference actualImmutableCodedReference = builderResult.build();
    assertEquals(instance, actualImmutableCodedReference);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CodeProvider)} with {@code CodeProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CodeProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CodeProvider) with 'CodeProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CodeProvider)"})
  void testBuilderFromWithCodeProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCodedReference.builder();

    CodeProvider instance = mock(CodeProvider.class);
    when(instance.code()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).code();
  }

  /**
   * Test Builder {@link Builder#from(CodedReference)} with {@code CodedReference}.
   *
   * <ul>
   *   <li>Then builder build is builder code {@code Code} name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CodedReference)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CodedReference) with 'CodedReference'; then builder build is builder code 'Code' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CodedReference)"})
  void testBuilderFromWithCodedReference_thenBuilderBuildIsBuilderCodeCodeNameNameBuild() {
    // Arrange
    Builder builderResult = ImmutableCodedReference.builder();
    ImmutableCodedReference instance =
        ImmutableCodedReference.builder().code("Code").name("Name").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCodedReference actualImmutableCodedReference = builderResult.build();
    assertEquals(instance, actualImmutableCodedReference);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then calls {@link NameProvider#name()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then calls name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenCallsName() {
    // Arrange
    Builder builderResult = ImmutableCodedReference.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Then builder build is builder code {@code Code} name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; then builder build is builder code 'Code' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_thenBuilderBuildIsBuilderCodeCodeNameNameBuild() {
    // Arrange
    Builder builderResult = ImmutableCodedReference.builder();
    ImmutableCodedReference instance =
        ImmutableCodedReference.builder().code("Code").name("Name").build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableCodedReference actualImmutableCodedReference = builderResult.build();
    assertEquals(instance, actualImmutableCodedReference);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCodedReference.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableCodedReference#copyOf(CodedReference)}.
   *
   * <ul>
   *   <li>When builder code {@code Code} name {@code Name} build.
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCodedReference#copyOf(CodedReference)}
   */
  @Test
  @DisplayName(
      "Test copyOf(CodedReference); when builder code 'Code' name 'Name' build; then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCodedReference ImmutableCodedReference.copyOf(CodedReference)"})
  void testCopyOf_whenBuilderCodeCodeNameNameBuild_thenReturnCode() {
    // Arrange
    ImmutableCodedReference instance =
        ImmutableCodedReference.builder().code("Code").name("Name").build();

    // Act
    ImmutableCodedReference actualCopyOfResult = ImmutableCodedReference.copyOf(instance);

    // Assert
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Name", actualCopyOfResult.name());
  }

  /**
   * Test {@link ImmutableCodedReference#equals(Object)}, and {@link
   * ImmutableCodedReference#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCodedReference#equals(Object)}
   *   <li>{@link ImmutableCodedReference#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCodedReference.equals(Object)",
    "int ImmutableCodedReference.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableCodedReference immutableCodedReference =
        ImmutableCodedReference.builder().code("Code").name("Name").build();
    ImmutableCodedReference immutableCodedReference2 =
        ImmutableCodedReference.builder().code("Code").name("Name").build();

    // Act and Assert
    assertEquals(immutableCodedReference, immutableCodedReference2);
    assertEquals(immutableCodedReference.hashCode(), immutableCodedReference2.hashCode());
  }

  /**
   * Test {@link ImmutableCodedReference#equals(Object)}, and {@link
   * ImmutableCodedReference#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCodedReference#equals(Object)}
   *   <li>{@link ImmutableCodedReference#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCodedReference.equals(Object)",
    "int ImmutableCodedReference.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableCodedReference immutableCodedReference =
        ImmutableCodedReference.builder().code("Code").name("Name").build();

    // Act and Assert
    assertEquals(immutableCodedReference, immutableCodedReference);
    int expectedHashCodeResult = immutableCodedReference.hashCode();
    assertEquals(expectedHashCodeResult, immutableCodedReference.hashCode());
  }

  /**
   * Test {@link ImmutableCodedReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCodedReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCodedReference.equals(Object)",
    "int ImmutableCodedReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableCodedReference immutableCodedReference =
        ImmutableCodedReference.builder().code("Name").name("Name").build();

    // Act and Assert
    assertNotEquals(
        immutableCodedReference,
        ImmutableCodedReference.builder().code("Code").name("Name").build());
  }

  /**
   * Test {@link ImmutableCodedReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCodedReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCodedReference.equals(Object)",
    "int ImmutableCodedReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableCodedReference immutableCodedReference =
        ImmutableCodedReference.builder().code("Code").name("Code").build();

    // Act and Assert
    assertNotEquals(
        immutableCodedReference,
        ImmutableCodedReference.builder().code("Code").name("Name").build());
  }

  /**
   * Test {@link ImmutableCodedReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCodedReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCodedReference.equals(Object)",
    "int ImmutableCodedReference.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableCodedReference.builder().code("Code").name("Name").build(), null);
  }

  /**
   * Test {@link ImmutableCodedReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCodedReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCodedReference.equals(Object)",
    "int ImmutableCodedReference.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCodedReference.builder().code("Code").name("Name").build(),
        "Different type to ImmutableCodedReference");
  }

  /**
   * Test {@link ImmutableCodedReference#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Code is {@code Json}.
   *   <li>Then return code is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCodedReference#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Code is 'Json'; then return code is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCodedReference ImmutableCodedReference.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonCodeIsJson_thenReturnCodeIsJson() {
    // Arrange
    Json json = new Json();
    json.setCode("Json");
    json.setName("Json");

    // Act
    ImmutableCodedReference actualFromJsonResult = ImmutableCodedReference.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.code());
    assertEquals("Json", actualFromJsonResult.name());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCodedReference#toString()}
   *   <li>{@link ImmutableCodedReference#code()}
   *   <li>{@link ImmutableCodedReference#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableCodedReference.code()",
    "String ImmutableCodedReference.name()",
    "String ImmutableCodedReference.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableCodedReference immutableCodedReference =
        ImmutableCodedReference.builder().code("Code").name("Name").build();

    // Act
    String actualToStringResult = immutableCodedReference.toString();
    String actualCodeResult = immutableCodedReference.code();

    // Assert
    assertEquals("Code", actualCodeResult);
    assertEquals("CodedReference{code=Code, name=Name}", actualToStringResult);
    assertEquals("Name", immutableCodedReference.name());
  }

  /**
   * Test Json {@link Json#code()}.
   *
   * <p>Method under test: {@link Json#code()}
   */
  @Test
  @DisplayName("Test Json code()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.code()"})
  void testJsonCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().code());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCode(String)}
   *   <li>{@link Json#setName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setCode(String)",
    "void Json.setName(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCode("Code");
    actualJson.setName("Name");

    // Assert
    assertEquals("Code", actualJson.code);
    assertEquals("Name", actualJson.name);
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
   * Test {@link ImmutableCodedReference#withCode(String)}.
   *
   * <ul>
   *   <li>Given builder code {@code Code} name {@code Name} build.
   *   <li>Then return code is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCodedReference#withCode(String)}
   */
  @Test
  @DisplayName(
      "Test withCode(String); given builder code 'Code' name 'Name' build; then return code is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCodedReference ImmutableCodedReference.withCode(String)"})
  void testWithCode_givenBuilderCodeCodeNameNameBuild_thenReturnCodeIs42() {
    // Arrange and Act
    ImmutableCodedReference actualWithCodeResult =
        ImmutableCodedReference.builder().code("Code").name("Name").build().withCode("42");

    // Assert
    assertEquals("42", actualWithCodeResult.code());
    assertEquals("Name", actualWithCodeResult.name());
  }

  /**
   * Test {@link ImmutableCodedReference#withCode(String)}.
   *
   * <ul>
   *   <li>Then return builder code {@code 42} name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCodedReference#withCode(String)}
   */
  @Test
  @DisplayName("Test withCode(String); then return builder code '42' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCodedReference ImmutableCodedReference.withCode(String)"})
  void testWithCode_thenReturnBuilderCode42NameNameBuild() {
    // Arrange
    ImmutableCodedReference immutableCodedReference =
        ImmutableCodedReference.builder().code("42").name("Name").build();

    // Act
    ImmutableCodedReference actualWithCodeResult = immutableCodedReference.withCode("42");

    // Assert
    assertSame(immutableCodedReference, actualWithCodeResult);
  }

  /**
   * Test {@link ImmutableCodedReference#withName(String)}.
   *
   * <ul>
   *   <li>Given builder code {@code Code} name {@code Name} build.
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCodedReference#withName(String)}
   */
  @Test
  @DisplayName(
      "Test withName(String); given builder code 'Code' name 'Name' build; then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCodedReference ImmutableCodedReference.withName(String)"})
  void testWithName_givenBuilderCodeCodeNameNameBuild_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableCodedReference actualWithNameResult =
        ImmutableCodedReference.builder().code("Code").name("Name").build().withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Code", actualWithNameResult.code());
  }

  /**
   * Test {@link ImmutableCodedReference#withName(String)}.
   *
   * <ul>
   *   <li>Then return builder code {@code Code} name {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCodedReference#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return builder code 'Code' name '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCodedReference ImmutableCodedReference.withName(String)"})
  void testWithName_thenReturnBuilderCodeCodeName42Build() {
    // Arrange
    ImmutableCodedReference immutableCodedReference =
        ImmutableCodedReference.builder().code("Code").name("42").build();

    // Act
    ImmutableCodedReference actualWithNameResult = immutableCodedReference.withName("42");

    // Assert
    assertSame(immutableCodedReference, actualWithNameResult);
  }
}
