package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableResolvedReference.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableResolvedReference.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableResolvedReferenceDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#resolvedEntityReference(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedReference Builder.build()",
    "Builder Builder.resolvedEntityReference(EntityReference)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualInputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);
    Builder actualResolvedEntityReferenceResult =
        actualInputStringResult.resolvedEntityReference(resolvedEntityReference);

    // Assert
    assertEquals(
        "Input String",
        actualResolvedEntityReferenceResult
            .resolvedEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .inputString());
  }

  /**
   * Test Builder {@link Builder#from(ResolvedReference)}.
   *
   * <p>Method under test: {@link Builder#from(ResolvedReference)}
   */
  @Test
  @DisplayName("Test Builder from(ResolvedReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ResolvedReference)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableResolvedReference.builder();

    Builder inputStringResult = ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);
    ImmutableResolvedReference instance =
        inputStringResult.resolvedEntityReference(resolvedEntityReference).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableResolvedReference actualImmutableResolvedReference = builderResult.build();
    assertEquals(instance, actualImmutableResolvedReference);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ResolvedReference)}.
   *
   * <p>Method under test: {@link Builder#from(ResolvedReference)}
   */
  @Test
  @DisplayName("Test Builder from(ResolvedReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ResolvedReference)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableResolvedReference.builder();

    Builder inputStringResult = ImmutableResolvedReference.builder().inputString("Input String");
    Optional<? extends EntityReference> resolvedEntityReference = Optional.empty();
    ImmutableResolvedReference instance =
        inputStringResult.resolvedEntityReference(resolvedEntityReference).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableResolvedReference actualImmutableResolvedReference = builderResult.build();
    assertEquals(instance, actualImmutableResolvedReference);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#inputString(String)}.
   *
   * <ul>
   *   <li>When {@code Input String}.
   *   <li>Then builder build inputString is {@code Input String}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#inputString(String)}
   */
  @Test
  @DisplayName(
      "Test Builder inputString(String); when 'Input String'; then builder build inputString is 'Input String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.inputString(String)"})
  void testBuilderInputString_whenInputString_thenBuilderBuildInputStringIsInputString() {
    // Arrange
    Builder builderResult = ImmutableResolvedReference.builder();

    // Act
    Builder actualInputStringResult = builderResult.inputString("Input String");

    // Assert
    assertEquals("Input String", builderResult.build().inputString());
    assertSame(builderResult, actualInputStringResult);
  }

  /**
   * Test Builder {@link Builder#resolvedEntityReference(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#resolvedEntityReference(Optional)}
   */
  @Test
  @DisplayName("Test Builder resolvedEntityReference(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.resolvedEntityReference(Optional)"})
  void testBuilderResolvedEntityReferenceWithOptional() {
    // Arrange
    Builder builderResult = ImmutableResolvedReference.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);

    // Act
    Builder actualResolvedEntityReferenceResult =
        builderResult.resolvedEntityReference(resolvedEntityReference);

    // Assert
    assertSame(builderResult, actualResolvedEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableResolvedReference#copyOf(ResolvedReference)}.
   *
   * <ul>
   *   <li>Then return {@code Input String}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedReference#copyOf(ResolvedReference)}
   */
  @Test
  @DisplayName("Test copyOf(ResolvedReference); then return 'Input String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedReference ImmutableResolvedReference.copyOf(ResolvedReference)"
  })
  void testCopyOf_thenReturnInputString() {
    // Arrange
    Builder inputStringResult = ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);
    ImmutableResolvedReference instance =
        inputStringResult.resolvedEntityReference(resolvedEntityReference).build();

    // Act and Assert
    assertEquals("Input String", ImmutableResolvedReference.copyOf(instance).inputString());
  }

  /**
   * Test {@link ImmutableResolvedReference#equals(Object)}, and {@link
   * ImmutableResolvedReference#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableResolvedReference#equals(Object)}
   *   <li>{@link ImmutableResolvedReference#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedReference.equals(Object)",
    "int ImmutableResolvedReference.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder inputStringResult = ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);
    ImmutableResolvedReference immutableResolvedReference =
        inputStringResult.resolvedEntityReference(resolvedEntityReference).build();

    Builder inputStringResult2 = ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference2);
    ImmutableResolvedReference immutableResolvedReference2 =
        inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build();

    // Act and Assert
    assertEquals(immutableResolvedReference, immutableResolvedReference2);
    assertEquals(immutableResolvedReference.hashCode(), immutableResolvedReference2.hashCode());
  }

  /**
   * Test {@link ImmutableResolvedReference#equals(Object)}, and {@link
   * ImmutableResolvedReference#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableResolvedReference#equals(Object)}
   *   <li>{@link ImmutableResolvedReference#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedReference.equals(Object)",
    "int ImmutableResolvedReference.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder inputStringResult = ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);
    ImmutableResolvedReference immutableResolvedReference =
        inputStringResult.resolvedEntityReference(resolvedEntityReference).build();

    // Act and Assert
    assertEquals(immutableResolvedReference, immutableResolvedReference);
    int expectedHashCodeResult = immutableResolvedReference.hashCode();
    assertEquals(expectedHashCodeResult, immutableResolvedReference.hashCode());
  }

  /**
   * Test {@link ImmutableResolvedReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedReference.equals(Object)",
    "int ImmutableResolvedReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder inputStringResult = ImmutableResolvedReference.builder().inputString("inputString");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);
    ImmutableResolvedReference immutableResolvedReference =
        inputStringResult.resolvedEntityReference(resolvedEntityReference).build();

    Builder inputStringResult2 = ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableResolvedReference,
        inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build());
  }

  /**
   * Test {@link ImmutableResolvedReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedReference.equals(Object)",
    "int ImmutableResolvedReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder inputStringResult = ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);
    ImmutableResolvedReference immutableResolvedReference =
        inputStringResult.resolvedEntityReference(resolvedEntityReference).build();

    Builder inputStringResult2 = ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableResolvedReference,
        inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build());
  }

  /**
   * Test {@link ImmutableResolvedReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedReference.equals(Object)",
    "int ImmutableResolvedReference.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder inputStringResult = ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);

    // Act and Assert
    assertNotEquals(
        inputStringResult.resolvedEntityReference(resolvedEntityReference).build(), null);
  }

  /**
   * Test {@link ImmutableResolvedReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedReference.equals(Object)",
    "int ImmutableResolvedReference.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder inputStringResult = ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);

    // Act and Assert
    assertNotEquals(
        inputStringResult.resolvedEntityReference(resolvedEntityReference).build(),
        "Different type to ImmutableResolvedReference");
  }

  /**
   * Test {@link ImmutableResolvedReference#fromJson(Json)}.
   *
   * <p>Method under test: {@link ImmutableResolvedReference#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableResolvedReference ImmutableResolvedReference.fromJson(Json)"})
  void testFromJson() {
    // Arrange
    Json json = new Json();
    json.setInputString("Json");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> resolvedEntityReference = Optional.of(immutableEntityReference);
    json.setResolvedEntityReference(resolvedEntityReference);

    // Act
    ImmutableResolvedReference actualFromJsonResult = ImmutableResolvedReference.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.inputString());
  }

  /**
   * Test {@link ImmutableResolvedReference#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) InputString is {@code Json}.
   *   <li>Then return inputString is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedReference#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) InputString is 'Json'; then return inputString is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableResolvedReference ImmutableResolvedReference.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonInputStringIsJson_thenReturnInputStringIsJson() {
    // Arrange
    Json json = new Json();
    json.setInputString("Json");
    json.setResolvedEntityReference(null);

    // Act
    ImmutableResolvedReference actualFromJsonResult = ImmutableResolvedReference.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.inputString());
  }

  /**
   * Test {@link ImmutableResolvedReference#inputString()}.
   *
   * <p>Method under test: {@link ImmutableResolvedReference#inputString()}
   */
  @Test
  @DisplayName("Test inputString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableResolvedReference.inputString()"})
  void testInputString() {
    // Arrange
    Builder inputStringResult = ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);

    // Act and Assert
    assertEquals(
        "Input String",
        inputStringResult.resolvedEntityReference(resolvedEntityReference).build().inputString());
  }

  /**
   * Test Json {@link Json#inputString()}.
   *
   * <p>Method under test: {@link Json#inputString()}
   */
  @Test
  @DisplayName("Test Json inputString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.inputString()"})
  void testJsonInputString() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().inputString());
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
    assertNull(actualJson.inputString);
    assertFalse(actualJson.resolvedEntityReference.isPresent());
  }

  /**
   * Test Json {@link Json#resolvedEntityReference()}.
   *
   * <p>Method under test: {@link Json#resolvedEntityReference()}
   */
  @Test
  @DisplayName("Test Json resolvedEntityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.resolvedEntityReference()"})
  void testJsonResolvedEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().resolvedEntityReference());
  }

  /**
   * Test {@link ImmutableResolvedReference#resolvedEntityReference()}.
   *
   * <p>Method under test: {@link ImmutableResolvedReference#resolvedEntityReference()}
   */
  @Test
  @DisplayName("Test resolvedEntityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableResolvedReference.resolvedEntityReference()"})
  void testResolvedEntityReference() {
    // Arrange
    Builder inputStringResult = ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);

    // Act and Assert
    assertEquals(
        resolvedEntityReference,
        inputStringResult
            .resolvedEntityReference(resolvedEntityReference)
            .build()
            .resolvedEntityReference());
  }

  /**
   * Test {@link ImmutableResolvedReference#toString()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedReference#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableResolvedReference.toString()"})
  void testToString_thenReturnAString() {
    // Arrange
    Builder inputStringResult = ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);

    // Act and Assert
    assertEquals(
        "ResolvedReference{inputString=Input String, resolvedEntityReference=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}}",
        inputStringResult.resolvedEntityReference(resolvedEntityReference).build().toString());
  }

  /**
   * Test {@link ImmutableResolvedReference#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ResolvedReference{inputString=Input String}}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedReference#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ResolvedReference{inputString=Input String}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableResolvedReference.toString()"})
  void testToString_thenReturnResolvedReferenceInputStringInputString() {
    // Arrange
    Builder inputStringResult = ImmutableResolvedReference.builder().inputString("Input String");
    Optional<? extends EntityReference> resolvedEntityReference = Optional.empty();

    // Act and Assert
    assertEquals(
        "ResolvedReference{inputString=Input String}",
        inputStringResult.resolvedEntityReference(resolvedEntityReference).build().toString());
  }

  /**
   * Test {@link ImmutableResolvedReference#withInputString(String)}.
   *
   * <p>Method under test: {@link ImmutableResolvedReference#withInputString(String)}
   */
  @Test
  @DisplayName("Test withInputString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedReference ImmutableResolvedReference.withInputString(String)"
  })
  void testWithInputString() {
    // Arrange
    Builder inputStringResult = ImmutableResolvedReference.builder().inputString("42");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);
    ImmutableResolvedReference immutableResolvedReference =
        inputStringResult.resolvedEntityReference(resolvedEntityReference).build();

    // Act
    ImmutableResolvedReference actualWithInputStringResult =
        immutableResolvedReference.withInputString("42");

    // Assert
    assertSame(immutableResolvedReference, actualWithInputStringResult);
  }

  /**
   * Test {@link ImmutableResolvedReference#withInputString(String)}.
   *
   * <ul>
   *   <li>Then return inputString is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedReference#withInputString(String)}
   */
  @Test
  @DisplayName("Test withInputString(String); then return inputString is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedReference ImmutableResolvedReference.withInputString(String)"
  })
  void testWithInputString_thenReturnInputStringIs42() {
    // Arrange
    Builder inputStringResult = ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);

    // Act and Assert
    assertEquals(
        "42",
        inputStringResult
            .resolvedEntityReference(resolvedEntityReference)
            .build()
            .withInputString("42")
            .inputString());
  }

  /**
   * Test {@link ImmutableResolvedReference#withResolvedEntityReference(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableResolvedReference#withResolvedEntityReference(Optional)}
   */
  @Test
  @DisplayName("Test withResolvedEntityReference(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedReference ImmutableResolvedReference.withResolvedEntityReference(Optional)"
  })
  void testWithResolvedEntityReferenceWithOptional() {
    // Arrange
    Builder inputStringResult = ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);
    ImmutableResolvedReference immutableResolvedReference =
        inputStringResult.resolvedEntityReference(resolvedEntityReference).build();
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> optional = Optional.of(immutableEntityReference2);

    // Act
    ImmutableResolvedReference actualWithResolvedEntityReferenceResult =
        immutableResolvedReference.withResolvedEntityReference(optional);

    // Assert
    assertEquals(immutableResolvedReference, actualWithResolvedEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableResolvedReference#withResolvedEntityReference(EntityReference)} with
   * {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableResolvedReference#withResolvedEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withResolvedEntityReference(EntityReference) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedReference ImmutableResolvedReference.withResolvedEntityReference(EntityReference)"
  })
  void testWithResolvedEntityReferenceWithValue() {
    // Arrange
    Builder inputStringResult = ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);
    ImmutableResolvedReference immutableResolvedReference =
        inputStringResult.resolvedEntityReference(resolvedEntityReference).build();

    // Act
    ImmutableResolvedReference actualWithResolvedEntityReferenceResult =
        immutableResolvedReference.withResolvedEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableResolvedReference, actualWithResolvedEntityReferenceResult);
  }
}
