package org.finos.waltz.model.entity_field_reference;

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
import org.finos.waltz.model.entity_field_reference.ImmutableEntityFieldReference.Builder;
import org.finos.waltz.model.entity_field_reference.ImmutableEntityFieldReference.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityFieldReferenceDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#kind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityFieldReference Builder.build()",
    "Builder Builder.kind(EntityKind)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableEntityFieldReference actualImmutableEntityFieldReference =
        actualIdResult.id(id).kind(EntityKind.ALL).build();

    // Assert
    assertEquals("Display Name", actualImmutableEntityFieldReference.displayName());
    assertEquals("Field Name", actualImmutableEntityFieldReference.fieldName());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableEntityFieldReference.description());
    assertEquals(EntityKind.ALL, actualImmutableEntityFieldReference.entityKind());
    assertEquals(EntityKind.ALL, actualImmutableEntityFieldReference.kind());
  }

  /**
   * Test Builder {@link Builder#description(String)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#description(String)}
   */
  @Test
  @DisplayName("Test Builder description(String); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.description(String)"})
  void testBuilderDescription_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityFieldReference.builder();

    // Act
    Builder actualDescriptionResult =
        builderResult.description("The characteristics of someone or something");

    // Assert
    assertSame(builderResult, actualDescriptionResult);
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
    Builder builderResult = ImmutableEntityFieldReference.builder();

    // Act
    Builder actualDisplayNameResult = builderResult.displayName("Display Name");

    // Assert
    assertSame(builderResult, actualDisplayNameResult);
  }

  /**
   * Test Builder {@link Builder#entityKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#entityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder entityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityKind(EntityKind)"})
  void testBuilderEntityKind() {
    // Arrange
    Builder builderResult = ImmutableEntityFieldReference.builder();

    // Act
    Builder actualEntityKindResult = builderResult.entityKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualEntityKindResult);
  }

  /**
   * Test Builder {@link Builder#fieldName(String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#fieldName(String)}
   */
  @Test
  @DisplayName("Test Builder fieldName(String); when 'Field Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.fieldName(String)"})
  void testBuilderFieldName_whenFieldName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityFieldReference.builder();

    // Act
    Builder actualFieldNameResult = builderResult.fieldName("Field Name");

    // Assert
    assertSame(builderResult, actualFieldNameResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityFieldReference)} with {@code EntityFieldReference}.
   *
   * <p>Method under test: {@link Builder#from(EntityFieldReference)}
   */
  @Test
  @DisplayName("Test Builder from(EntityFieldReference) with 'EntityFieldReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityFieldReference)"})
  void testBuilderFromWithEntityFieldReference() {
    // Arrange
    Builder builderResult = ImmutableEntityFieldReference.builder();
    ImmutableEntityFieldReference instance =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityFieldReference actualImmutableEntityFieldReference = builderResult.build();
    assertEquals(instance, actualImmutableEntityFieldReference);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableEntityFieldReference.builder();
    ImmutableEntityFieldReference instance =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableEntityFieldReference actualImmutableEntityFieldReference = builderResult.build();
    assertEquals(instance, actualImmutableEntityFieldReference);
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
    Builder builderResult = ImmutableEntityFieldReference.builder();

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
    Builder builderResult = ImmutableEntityFieldReference.builder();
    ImmutableEntityFieldReference instance =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableEntityFieldReference actualImmutableEntityFieldReference = builderResult.build();
    assertEquals(instance, actualImmutableEntityFieldReference);
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
    Builder builderResult = ImmutableEntityFieldReference.builder();

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
    Builder builderResult = ImmutableEntityFieldReference.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
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
    Builder builderResult = ImmutableEntityFieldReference.builder();

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
    Builder builderResult = ImmutableEntityFieldReference.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test {@link ImmutableEntityFieldReference#copyOf(EntityFieldReference)}.
   *
   * <ul>
   *   <li>Then return {@code Display Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#copyOf(EntityFieldReference)}
   */
  @Test
  @DisplayName("Test copyOf(EntityFieldReference); then return 'Display Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityFieldReference ImmutableEntityFieldReference.copyOf(EntityFieldReference)"
  })
  void testCopyOf_thenReturnDisplayName() {
    // Arrange
    ImmutableEntityFieldReference instance =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();

    // Act
    ImmutableEntityFieldReference actualCopyOfResult =
        ImmutableEntityFieldReference.copyOf(instance);

    // Assert
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertEquals("Field Name", actualCopyOfResult.fieldName());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#equals(Object)}, and {@link
   * ImmutableEntityFieldReference#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityFieldReference#equals(Object)}
   *   <li>{@link ImmutableEntityFieldReference#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityFieldReference.equals(Object)",
    "int ImmutableEntityFieldReference.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableEntityFieldReference immutableEntityFieldReference =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();
    ImmutableEntityFieldReference immutableEntityFieldReference2 =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableEntityFieldReference, immutableEntityFieldReference2);
    assertEquals(
        immutableEntityFieldReference.hashCode(), immutableEntityFieldReference2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#equals(Object)}, and {@link
   * ImmutableEntityFieldReference#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityFieldReference#equals(Object)}
   *   <li>{@link ImmutableEntityFieldReference#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityFieldReference.equals(Object)",
    "int ImmutableEntityFieldReference.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableEntityFieldReference immutableEntityFieldReference =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableEntityFieldReference, immutableEntityFieldReference);
    int expectedHashCodeResult = immutableEntityFieldReference.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityFieldReference.hashCode());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityFieldReference.equals(Object)",
    "int ImmutableEntityFieldReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableEntityFieldReference immutableEntityFieldReference =
        ImmutableEntityFieldReference.builder()
            .description("Field Name")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityFieldReference,
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityFieldReference.equals(Object)",
    "int ImmutableEntityFieldReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableEntityFieldReference immutableEntityFieldReference =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Field Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityFieldReference,
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityFieldReference.equals(Object)",
    "int ImmutableEntityFieldReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableEntityFieldReference immutableEntityFieldReference =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ACTOR)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityFieldReference,
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityFieldReference.equals(Object)",
    "int ImmutableEntityFieldReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableEntityFieldReference immutableEntityFieldReference =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Display Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityFieldReference,
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityFieldReference.equals(Object)",
    "int ImmutableEntityFieldReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableEntityFieldReference immutableEntityFieldReference =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(2L)
            .kind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityFieldReference,
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityFieldReference.equals(Object)",
    "int ImmutableEntityFieldReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableEntityFieldReference immutableEntityFieldReference =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityFieldReference,
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityFieldReference.equals(Object)",
    "int ImmutableEntityFieldReference.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEntityFieldReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityFieldReference.equals(Object)",
    "int ImmutableEntityFieldReference.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build(),
        "Different type to ImmutableEntityFieldReference");
  }

  /**
   * Test {@link ImmutableEntityFieldReference#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link Json} (default constructor) Kind is {@code ALL}.
   *   <li>Then return kind is {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ALL'; when Json (default constructor) Kind is 'ALL'; then return kind is 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityFieldReference ImmutableEntityFieldReference.fromJson(Json)"})
  void testFromJson_givenAll_whenJsonKindIsAll_thenReturnKindIsAll() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setEntityKind(EntityKind.ALL);
    json.setFieldName("Json");
    json.setDisplayName("Json");
    json.setDescription("Json");
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableEntityFieldReference actualFromJsonResult =
        ImmutableEntityFieldReference.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.displayName());
    assertEquals("Json", actualFromJsonResult.fieldName());
    assertEquals(EntityKind.ALL, actualFromJsonResult.entityKind());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of fifteen.
   *   <li>When {@link Json} (default constructor) Id is of fifteen.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of fifteen; when Json (default constructor) Id is of fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityFieldReference ImmutableEntityFieldReference.fromJson(Json)"})
  void testFromJson_givenOfFifteen_whenJsonIdIsOfFifteen() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(15L);
    json.setId(id);
    json.setEntityKind(EntityKind.ALL);
    json.setFieldName("Json");
    json.setDisplayName("Json");
    json.setDescription("Json");
    json.setKind(null);

    // Act
    ImmutableEntityFieldReference actualFromJsonResult =
        ImmutableEntityFieldReference.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.displayName());
    assertEquals("Json", actualFromJsonResult.fieldName());
    assertEquals(EntityKind.ALL, actualFromJsonResult.entityKind());
    assertEquals(EntityKind.ENTITY_FIELD_REFERENCE, actualFromJsonResult.kind());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) EntityKind is {@code ALL}.
   *   <li>Then return kind is {@code ENTITY_FIELD_REFERENCE}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) EntityKind is 'ALL'; then return kind is 'ENTITY_FIELD_REFERENCE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityFieldReference ImmutableEntityFieldReference.fromJson(Json)"})
  void testFromJson_whenJsonEntityKindIsAll_thenReturnKindIsEntityFieldReference() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setEntityKind(EntityKind.ALL);
    json.setFieldName("Json");
    json.setDisplayName("Json");
    json.setDescription("Json");
    json.setKind(null);

    // Act
    ImmutableEntityFieldReference actualFromJsonResult =
        ImmutableEntityFieldReference.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.displayName());
    assertEquals("Json", actualFromJsonResult.fieldName());
    assertEquals(EntityKind.ALL, actualFromJsonResult.entityKind());
    assertEquals(EntityKind.ENTITY_FIELD_REFERENCE, actualFromJsonResult.kind());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityFieldReference#description()}
   *   <li>{@link ImmutableEntityFieldReference#displayName()}
   *   <li>{@link ImmutableEntityFieldReference#entityKind()}
   *   <li>{@link ImmutableEntityFieldReference#fieldName()}
   *   <li>{@link ImmutableEntityFieldReference#kind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableEntityFieldReference.description()",
    "String ImmutableEntityFieldReference.displayName()",
    "EntityKind ImmutableEntityFieldReference.entityKind()",
    "String ImmutableEntityFieldReference.fieldName()",
    "EntityKind ImmutableEntityFieldReference.kind()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableEntityFieldReference immutableEntityFieldReference =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();

    // Act
    String actualDescriptionResult = immutableEntityFieldReference.description();
    String actualDisplayNameResult = immutableEntityFieldReference.displayName();
    EntityKind actualEntityKindResult = immutableEntityFieldReference.entityKind();
    String actualFieldNameResult = immutableEntityFieldReference.fieldName();

    // Assert
    assertEquals("Display Name", actualDisplayNameResult);
    assertEquals("Field Name", actualFieldNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(EntityKind.ALL, actualEntityKindResult);
    assertEquals(EntityKind.ALL, immutableEntityFieldReference.kind());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#id()}.
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntityFieldReference.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
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
   * Test Json {@link Json#entityKind()}.
   *
   * <p>Method under test: {@link Json#entityKind()}
   */
  @Test
  @DisplayName("Test Json entityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.entityKind()"})
  void testJsonEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityKind());
  }

  /**
   * Test Json {@link Json#fieldName()}.
   *
   * <p>Method under test: {@link Json#fieldName()}
   */
  @Test
  @DisplayName("Test Json fieldName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.fieldName()"})
  void testJsonFieldName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().fieldName());
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
    assertNull(actualJson.description);
    assertNull(actualJson.displayName);
    assertNull(actualJson.fieldName);
    assertNull(actualJson.entityKind);
    assertNull(actualJson.kind);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#toString()}.
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableEntityFieldReference.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "EntityFieldReference{id=1, entityKind=ALL, fieldName=Field Name, displayName=Display Name, description=The"
            + " characteristics of someone or something, kind=ALL}",
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityFieldReference ImmutableEntityFieldReference.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableEntityFieldReference immutableEntityFieldReference =
        ImmutableEntityFieldReference.builder()
            .description("42")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();

    // Act
    ImmutableEntityFieldReference actualWithDescriptionResult =
        immutableEntityFieldReference.withDescription("42");

    // Assert
    assertSame(immutableEntityFieldReference, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntityFieldReference#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return description is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then return description is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityFieldReference ImmutableEntityFieldReference.withDescription(String)"
  })
  void testWithDescription_thenReturnDescriptionIs42() {
    // Arrange and Act
    ImmutableEntityFieldReference actualWithDescriptionResult =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build()
            .withDescription("42");

    // Assert
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals("Display Name", actualWithDescriptionResult.displayName());
    assertEquals("Field Name", actualWithDescriptionResult.fieldName());
    assertEquals(EntityKind.ALL, actualWithDescriptionResult.entityKind());
    assertEquals(EntityKind.ALL, actualWithDescriptionResult.kind());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#withDisplayName(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#withDisplayName(String)}
   */
  @Test
  @DisplayName("Test withDisplayName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityFieldReference ImmutableEntityFieldReference.withDisplayName(String)"
  })
  void testWithDisplayName() {
    // Arrange
    ImmutableEntityFieldReference immutableEntityFieldReference =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("42")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();

    // Act
    ImmutableEntityFieldReference actualWithDisplayNameResult =
        immutableEntityFieldReference.withDisplayName("42");

    // Assert
    assertSame(immutableEntityFieldReference, actualWithDisplayNameResult);
  }

  /**
   * Test {@link ImmutableEntityFieldReference#withDisplayName(String)}.
   *
   * <ul>
   *   <li>Then return displayName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#withDisplayName(String)}
   */
  @Test
  @DisplayName("Test withDisplayName(String); then return displayName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityFieldReference ImmutableEntityFieldReference.withDisplayName(String)"
  })
  void testWithDisplayName_thenReturnDisplayNameIs42() {
    // Arrange and Act
    ImmutableEntityFieldReference actualWithDisplayNameResult =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build()
            .withDisplayName("42");

    // Assert
    assertEquals("42", actualWithDisplayNameResult.displayName());
    assertEquals("Field Name", actualWithDisplayNameResult.fieldName());
    assertEquals(
        "The characteristics of someone or something", actualWithDisplayNameResult.description());
    assertEquals(EntityKind.ALL, actualWithDisplayNameResult.entityKind());
    assertEquals(EntityKind.ALL, actualWithDisplayNameResult.kind());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#withEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#withEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityFieldReference ImmutableEntityFieldReference.withEntityKind(EntityKind)"
  })
  void testWithEntityKind() {
    // Arrange
    ImmutableEntityFieldReference immutableEntityFieldReference =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();

    // Act
    ImmutableEntityFieldReference actualWithEntityKindResult =
        immutableEntityFieldReference.withEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableEntityFieldReference, actualWithEntityKindResult);
  }

  /**
   * Test {@link ImmutableEntityFieldReference#withEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Display Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#withEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withEntityKind(EntityKind); then return 'Display Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityFieldReference ImmutableEntityFieldReference.withEntityKind(EntityKind)"
  })
  void testWithEntityKind_thenReturnDisplayName() {
    // Arrange and Act
    ImmutableEntityFieldReference actualWithEntityKindResult =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ACTOR)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build()
            .withEntityKind(EntityKind.ALL);

    // Assert
    assertEquals("Display Name", actualWithEntityKindResult.displayName());
    assertEquals("Field Name", actualWithEntityKindResult.fieldName());
    assertEquals(
        "The characteristics of someone or something", actualWithEntityKindResult.description());
    assertEquals(EntityKind.ALL, actualWithEntityKindResult.entityKind());
    assertEquals(EntityKind.ALL, actualWithEntityKindResult.kind());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#withFieldName(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#withFieldName(String)}
   */
  @Test
  @DisplayName("Test withFieldName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityFieldReference ImmutableEntityFieldReference.withFieldName(String)"
  })
  void testWithFieldName() {
    // Arrange
    ImmutableEntityFieldReference immutableEntityFieldReference =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();

    // Act
    ImmutableEntityFieldReference actualWithFieldNameResult =
        immutableEntityFieldReference.withFieldName("42");

    // Assert
    assertSame(immutableEntityFieldReference, actualWithFieldNameResult);
  }

  /**
   * Test {@link ImmutableEntityFieldReference#withFieldName(String)}.
   *
   * <ul>
   *   <li>Then return fieldName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#withFieldName(String)}
   */
  @Test
  @DisplayName("Test withFieldName(String); then return fieldName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityFieldReference ImmutableEntityFieldReference.withFieldName(String)"
  })
  void testWithFieldName_thenReturnFieldNameIs42() {
    // Arrange and Act
    ImmutableEntityFieldReference actualWithFieldNameResult =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build()
            .withFieldName("42");

    // Assert
    assertEquals("42", actualWithFieldNameResult.fieldName());
    assertEquals("Display Name", actualWithFieldNameResult.displayName());
    assertEquals(
        "The characteristics of someone or something", actualWithFieldNameResult.description());
    assertEquals(EntityKind.ALL, actualWithFieldNameResult.entityKind());
    assertEquals(EntityKind.ALL, actualWithFieldNameResult.kind());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityFieldReference ImmutableEntityFieldReference.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutableEntityFieldReference immutableEntityFieldReference =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEntityFieldReference actualWithIdResult =
        immutableEntityFieldReference.withId(optional);

    // Assert
    assertSame(immutableEntityFieldReference, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEntityFieldReference#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Display Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Display Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityFieldReference ImmutableEntityFieldReference.withId(Optional)"
  })
  void testWithIdWithOptional_thenReturnDisplayName() {
    // Arrange
    ImmutableEntityFieldReference immutableEntityFieldReference =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(2L)
            .kind(EntityKind.ALL)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEntityFieldReference actualWithIdResult =
        immutableEntityFieldReference.withId(optional);

    // Assert
    assertEquals("Display Name", actualWithIdResult.displayName());
    assertEquals("Field Name", actualWithIdResult.fieldName());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.entityKind());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityFieldReference ImmutableEntityFieldReference.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableEntityFieldReference immutableEntityFieldReference =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();

    // Act
    ImmutableEntityFieldReference actualWithIdResult = immutableEntityFieldReference.withId(1L);

    // Assert
    assertSame(immutableEntityFieldReference, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEntityFieldReference#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Display Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Display Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityFieldReference ImmutableEntityFieldReference.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnDisplayName() {
    // Arrange and Act
    ImmutableEntityFieldReference actualWithIdResult =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build()
            .withId(42L);

    // Assert
    assertEquals("Display Name", actualWithIdResult.displayName());
    assertEquals("Field Name", actualWithIdResult.fieldName());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.entityKind());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
  }

  /**
   * Test {@link ImmutableEntityFieldReference#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityFieldReference ImmutableEntityFieldReference.withKind(EntityKind)"
  })
  void testWithKind() {
    // Arrange
    ImmutableEntityFieldReference immutableEntityFieldReference =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();

    // Act
    ImmutableEntityFieldReference actualWithKindResult =
        immutableEntityFieldReference.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableEntityFieldReference, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableEntityFieldReference#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Display Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityFieldReference#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return 'Display Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityFieldReference ImmutableEntityFieldReference.withKind(EntityKind)"
  })
  void testWithKind_thenReturnDisplayName() {
    // Arrange and Act
    ImmutableEntityFieldReference actualWithKindResult =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("Display Name", actualWithKindResult.displayName());
    assertEquals("Field Name", actualWithKindResult.fieldName());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(EntityKind.ALL, actualWithKindResult.entityKind());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
  }
}
