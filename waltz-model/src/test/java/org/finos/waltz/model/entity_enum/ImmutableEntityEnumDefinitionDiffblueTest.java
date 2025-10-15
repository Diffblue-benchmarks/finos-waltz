package org.finos.waltz.model.entity_enum;

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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.IconProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.entity_enum.ImmutableEntityEnumDefinition.Builder;
import org.finos.waltz.model.entity_enum.ImmutableEntityEnumDefinition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityEnumDefinitionDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityEnumDefinition Builder.build()",
    "Builder Builder.description(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableEntityEnumDefinition actualImmutableEntityEnumDefinition =
        actualIdResult.id(id).isEditable(true).name("Name").position(1).build();

    // Assert
    assertEquals("42", actualImmutableEntityEnumDefinition.enumValueType());
    assertEquals("Icon", actualImmutableEntityEnumDefinition.icon());
    assertEquals("Name", actualImmutableEntityEnumDefinition.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableEntityEnumDefinition.description());
    assertEquals(1, actualImmutableEntityEnumDefinition.position());
    assertEquals(EntityKind.ALL, actualImmutableEntityEnumDefinition.entityKind());
    assertTrue(actualImmutableEntityEnumDefinition.isEditable());
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
    Builder builderResult = ImmutableEntityEnumDefinition.builder();

    // Act
    Builder actualEntityKindResult = builderResult.entityKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualEntityKindResult);
  }

  /**
   * Test Builder {@link Builder#enumValueType(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#enumValueType(String)}
   */
  @Test
  @DisplayName("Test Builder enumValueType(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.enumValueType(String)"})
  void testBuilderEnumValueType_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityEnumDefinition.builder();

    // Act
    Builder actualEnumValueTypeResult = builderResult.enumValueType("42");

    // Assert
    assertSame(builderResult, actualEnumValueTypeResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableEntityEnumDefinition.builder();
    ImmutableEntityEnumDefinition instance =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableEntityEnumDefinition actualImmutableEntityEnumDefinition = builderResult.build();
    assertEquals(instance, actualImmutableEntityEnumDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableEntityEnumDefinition.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityEnumDefinition.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityEnumDefinition)} with {@code EntityEnumDefinition}.
   *
   * <p>Method under test: {@link Builder#from(EntityEnumDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityEnumDefinition) with 'EntityEnumDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityEnumDefinition)"})
  void testBuilderFromWithEntityEnumDefinition() {
    // Arrange
    Builder builderResult = ImmutableEntityEnumDefinition.builder();
    ImmutableEntityEnumDefinition instance =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityEnumDefinition actualImmutableEntityEnumDefinition = builderResult.build();
    assertEquals(instance, actualImmutableEntityEnumDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityEnumDefinition)} with {@code EntityEnumDefinition}.
   *
   * <p>Method under test: {@link Builder#from(EntityEnumDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityEnumDefinition) with 'EntityEnumDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityEnumDefinition)"})
  void testBuilderFromWithEntityEnumDefinition2() {
    // Arrange
    Builder builderResult = ImmutableEntityEnumDefinition.builder();
    ImmutableEntityEnumDefinition instance =
        ImmutableEntityEnumDefinition.builder()
            .description(null)
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityEnumDefinition actualImmutableEntityEnumDefinition = builderResult.build();
    assertEquals(instance, actualImmutableEntityEnumDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IconProvider)} with {@code IconProvider}.
   *
   * <p>Method under test: {@link Builder#from(IconProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IconProvider) with 'IconProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IconProvider)"})
  void testBuilderFromWithIconProvider() {
    // Arrange
    Builder builderResult = ImmutableEntityEnumDefinition.builder();
    ImmutableEntityEnumDefinition instance =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IconProvider) instance);

    // Assert
    ImmutableEntityEnumDefinition actualImmutableEntityEnumDefinition = builderResult.build();
    assertEquals(instance, actualImmutableEntityEnumDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IconProvider)} with {@code IconProvider}.
   *
   * <p>Method under test: {@link Builder#from(IconProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IconProvider) with 'IconProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IconProvider)"})
  void testBuilderFromWithIconProvider2() {
    // Arrange
    Builder builderResult = ImmutableEntityEnumDefinition.builder();
    ImmutableEntityEnumDefinition instance =
        ImmutableEntityEnumDefinition.builder()
            .description(null)
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IconProvider) instance);

    // Assert
    ImmutableEntityEnumDefinition actualImmutableEntityEnumDefinition = builderResult.build();
    assertEquals(instance, actualImmutableEntityEnumDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IconProvider)} with {@code IconProvider}.
   *
   * <ul>
   *   <li>Given {@code Icon}.
   *   <li>When {@link IconProvider} {@link IconProvider#icon()} return {@code Icon}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IconProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IconProvider) with 'IconProvider'; given 'Icon'; when IconProvider icon() return 'Icon'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IconProvider)"})
  void testBuilderFromWithIconProvider_givenIcon_whenIconProviderIconReturnIcon() {
    // Arrange
    Builder builderResult = ImmutableEntityEnumDefinition.builder();

    IconProvider instance = mock(IconProvider.class);
    when(instance.icon()).thenReturn("Icon");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).icon();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IconProvider)} with {@code IconProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IconProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IconProvider) with 'IconProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IconProvider)"})
  void testBuilderFromWithIconProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityEnumDefinition.builder();

    IconProvider instance = mock(IconProvider.class);
    when(instance.icon()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).icon();
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
    Builder builderResult = ImmutableEntityEnumDefinition.builder();
    ImmutableEntityEnumDefinition instance =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableEntityEnumDefinition actualImmutableEntityEnumDefinition = builderResult.build();
    assertEquals(instance, actualImmutableEntityEnumDefinition);
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
    Builder builderResult = ImmutableEntityEnumDefinition.builder();

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
   *   <li>Given of one.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne() {
    // Arrange
    Builder builderResult = ImmutableEntityEnumDefinition.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
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
    Builder builderResult = ImmutableEntityEnumDefinition.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableEntityEnumDefinition.builder();
    ImmutableEntityEnumDefinition instance =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableEntityEnumDefinition actualImmutableEntityEnumDefinition = builderResult.build();
    assertEquals(instance, actualImmutableEntityEnumDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider2() {
    // Arrange
    Builder builderResult = ImmutableEntityEnumDefinition.builder();
    ImmutableEntityEnumDefinition instance =
        ImmutableEntityEnumDefinition.builder()
            .description(null)
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableEntityEnumDefinition actualImmutableEntityEnumDefinition = builderResult.build();
    assertEquals(instance, actualImmutableEntityEnumDefinition);
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
    Builder builderResult = ImmutableEntityEnumDefinition.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#icon(String)}.
   *
   * <ul>
   *   <li>When {@code Icon}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#icon(String)}
   */
  @Test
  @DisplayName("Test Builder icon(String); when 'Icon'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.icon(String)"})
  void testBuilderIcon_whenIcon_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityEnumDefinition.builder();

    // Act
    Builder actualIconResult = builderResult.icon("Icon");

    // Assert
    assertSame(builderResult, actualIconResult);
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
    Builder builderResult = ImmutableEntityEnumDefinition.builder();

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
    Builder builderResult = ImmutableEntityEnumDefinition.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isEditable(boolean)}.
   *
   * <p>Method under test: {@link Builder#isEditable(boolean)}
   */
  @Test
  @DisplayName("Test Builder isEditable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isEditable(boolean)"})
  void testBuilderIsEditable() {
    // Arrange
    Builder builderResult = ImmutableEntityEnumDefinition.builder();

    // Act
    Builder actualIsEditableResult = builderResult.isEditable(true);

    // Assert
    assertSame(builderResult, actualIsEditableResult);
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
    Builder builderResult = ImmutableEntityEnumDefinition.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   *
   * <p>Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableEntityEnumDefinition.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#copyOf(EntityEnumDefinition)}.
   *
   * <ul>
   *   <li>Then return enumValueType is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#copyOf(EntityEnumDefinition)}
   */
  @Test
  @DisplayName("Test copyOf(EntityEnumDefinition); then return enumValueType is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.copyOf(EntityEnumDefinition)"
  })
  void testCopyOf_thenReturnEnumValueTypeIs42() {
    // Arrange
    ImmutableEntityEnumDefinition instance =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    ImmutableEntityEnumDefinition actualCopyOfResult =
        ImmutableEntityEnumDefinition.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.enumValueType());
    assertEquals("Icon", actualCopyOfResult.icon());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertTrue(actualCopyOfResult.isEditable());
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#equals(Object)}, and {@link
   * ImmutableEntityEnumDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityEnumDefinition#equals(Object)}
   *   <li>{@link ImmutableEntityEnumDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityEnumDefinition.equals(Object)",
    "int ImmutableEntityEnumDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition2 =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act and Assert
    assertEquals(immutableEntityEnumDefinition, immutableEntityEnumDefinition2);
    assertEquals(
        immutableEntityEnumDefinition.hashCode(), immutableEntityEnumDefinition2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#equals(Object)}, and {@link
   * ImmutableEntityEnumDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityEnumDefinition#equals(Object)}
   *   <li>{@link ImmutableEntityEnumDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityEnumDefinition.equals(Object)",
    "int ImmutableEntityEnumDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act and Assert
    assertEquals(immutableEntityEnumDefinition, immutableEntityEnumDefinition);
    int expectedHashCodeResult = immutableEntityEnumDefinition.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityEnumDefinition.hashCode());
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityEnumDefinition.equals(Object)",
    "int ImmutableEntityEnumDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ACTOR)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityEnumDefinition,
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityEnumDefinition.equals(Object)",
    "int ImmutableEntityEnumDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("Name")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityEnumDefinition,
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityEnumDefinition.equals(Object)",
    "int ImmutableEntityEnumDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Name")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityEnumDefinition,
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityEnumDefinition.equals(Object)",
    "int ImmutableEntityEnumDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(2L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityEnumDefinition,
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityEnumDefinition.equals(Object)",
    "int ImmutableEntityEnumDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(false)
            .name("Name")
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityEnumDefinition,
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityEnumDefinition.equals(Object)",
    "int ImmutableEntityEnumDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Icon")
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityEnumDefinition,
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityEnumDefinition.equals(Object)",
    "int ImmutableEntityEnumDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(0)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityEnumDefinition,
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityEnumDefinition.equals(Object)",
    "int ImmutableEntityEnumDefinition.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityEnumDefinition.equals(Object)",
    "int ImmutableEntityEnumDefinition.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build(),
        "Different type to ImmutableEntityEnumDefinition");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityEnumDefinition#description()}
   *   <li>{@link ImmutableEntityEnumDefinition#entityKind()}
   *   <li>{@link ImmutableEntityEnumDefinition#enumValueType()}
   *   <li>{@link ImmutableEntityEnumDefinition#icon()}
   *   <li>{@link ImmutableEntityEnumDefinition#isEditable()}
   *   <li>{@link ImmutableEntityEnumDefinition#name()}
   *   <li>{@link ImmutableEntityEnumDefinition#position()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableEntityEnumDefinition.description()",
    "EntityKind ImmutableEntityEnumDefinition.entityKind()",
    "String ImmutableEntityEnumDefinition.enumValueType()",
    "String ImmutableEntityEnumDefinition.icon()",
    "boolean ImmutableEntityEnumDefinition.isEditable()",
    "String ImmutableEntityEnumDefinition.name()",
    "int ImmutableEntityEnumDefinition.position()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    String actualDescriptionResult = immutableEntityEnumDefinition.description();
    EntityKind actualEntityKindResult = immutableEntityEnumDefinition.entityKind();
    String actualEnumValueTypeResult = immutableEntityEnumDefinition.enumValueType();
    String actualIconResult = immutableEntityEnumDefinition.icon();
    boolean actualIsEditableResult = immutableEntityEnumDefinition.isEditable();
    String actualNameResult = immutableEntityEnumDefinition.name();

    // Assert
    assertEquals("42", actualEnumValueTypeResult);
    assertEquals("Icon", actualIconResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1, immutableEntityEnumDefinition.position());
    assertEquals(EntityKind.ALL, actualEntityKindResult);
    assertTrue(actualIsEditableResult);
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#id()}.
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntityEnumDefinition.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
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
   * Test Json {@link Json#enumValueType()}.
   *
   * <p>Method under test: {@link Json#enumValueType()}
   */
  @Test
  @DisplayName("Test Json enumValueType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.enumValueType()"})
  void testJsonEnumValueType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().enumValueType());
  }

  /**
   * Test Json {@link Json#icon()}.
   *
   * <p>Method under test: {@link Json#icon()}
   */
  @Test
  @DisplayName("Test Json icon()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.icon()"})
  void testJsonIcon() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().icon());
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
   * Test Json {@link Json#isEditable()}.
   *
   * <p>Method under test: {@link Json#isEditable()}
   */
  @Test
  @DisplayName("Test Json isEditable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isEditable()"})
  void testJsonIsEditable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isEditable());
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
    assertNull(actualJson.description);
    assertNull(actualJson.enumValueType);
    assertNull(actualJson.icon);
    assertNull(actualJson.name);
    assertNull(actualJson.entityKind);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isEditable);
    assertFalse(actualJson.isEditableIsSet);
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Test Json {@link Json#position()}.
   *
   * <p>Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().position());
  }

  /**
   * Test Json {@link Json#setIsEditable(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsEditable(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsEditable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsEditable(boolean)"})
  void testJsonSetIsEditable() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsEditable(true);

    // Assert
    assertTrue(json.isEditable);
    assertTrue(json.isEditableIsSet);
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   *
   * <p>Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPosition(int)"})
  void testJsonSetPosition() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableEntityEnumDefinition.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "EntityEnumDefinition{id=1, name=Name, icon=Icon, entityKind=ALL, enumValueType=42, position=1,"
            + " isEditable=true}",
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    ImmutableEntityEnumDefinition actualWithDescriptionResult =
        immutableEntityEnumDefinition.withDescription("42");

    // Assert
    assertEquals(immutableEntityEnumDefinition, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("42")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    ImmutableEntityEnumDefinition actualWithDescriptionResult =
        immutableEntityEnumDefinition.withDescription("42");

    // Assert
    assertSame(immutableEntityEnumDefinition, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#withEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#withEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.withEntityKind(EntityKind)"
  })
  void testWithEntityKind() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    ImmutableEntityEnumDefinition actualWithEntityKindResult =
        immutableEntityEnumDefinition.withEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableEntityEnumDefinition, actualWithEntityKindResult);
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#withEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return enumValueType is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#withEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withEntityKind(EntityKind); then return enumValueType is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.withEntityKind(EntityKind)"
  })
  void testWithEntityKind_thenReturnEnumValueTypeIs42() {
    // Arrange and Act
    ImmutableEntityEnumDefinition actualWithEntityKindResult =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ACTOR)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build()
            .withEntityKind(EntityKind.ALL);

    // Assert
    assertEquals("42", actualWithEntityKindResult.enumValueType());
    assertEquals("Icon", actualWithEntityKindResult.icon());
    assertEquals("Name", actualWithEntityKindResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithEntityKindResult.description());
    assertEquals(1, actualWithEntityKindResult.position());
    assertEquals(EntityKind.ALL, actualWithEntityKindResult.entityKind());
    assertTrue(actualWithEntityKindResult.isEditable());
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#withEnumValueType(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#withEnumValueType(String)}
   */
  @Test
  @DisplayName("Test withEnumValueType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.withEnumValueType(String)"
  })
  void testWithEnumValueType() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    ImmutableEntityEnumDefinition actualWithEnumValueTypeResult =
        immutableEntityEnumDefinition.withEnumValueType("42");

    // Assert
    assertSame(immutableEntityEnumDefinition, actualWithEnumValueTypeResult);
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#withEnumValueType(String)}.
   *
   * <ul>
   *   <li>Then return enumValueType is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#withEnumValueType(String)}
   */
  @Test
  @DisplayName("Test withEnumValueType(String); then return enumValueType is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.withEnumValueType(String)"
  })
  void testWithEnumValueType_thenReturnEnumValueTypeIs42() {
    // Arrange and Act
    ImmutableEntityEnumDefinition actualWithEnumValueTypeResult =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("enumValueType")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build()
            .withEnumValueType("42");

    // Assert
    assertEquals("42", actualWithEnumValueTypeResult.enumValueType());
    assertEquals("Icon", actualWithEnumValueTypeResult.icon());
    assertEquals("Name", actualWithEnumValueTypeResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithEnumValueTypeResult.description());
    assertEquals(1, actualWithEnumValueTypeResult.position());
    assertEquals(EntityKind.ALL, actualWithEnumValueTypeResult.entityKind());
    assertTrue(actualWithEnumValueTypeResult.isEditable());
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#withIcon(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#withIcon(String)}
   */
  @Test
  @DisplayName("Test withIcon(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.withIcon(String)"
  })
  void testWithIcon() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("42")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    ImmutableEntityEnumDefinition actualWithIconResult =
        immutableEntityEnumDefinition.withIcon("42");

    // Assert
    assertSame(immutableEntityEnumDefinition, actualWithIconResult);
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#withIcon(String)}.
   *
   * <ul>
   *   <li>Then return enumValueType is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#withIcon(String)}
   */
  @Test
  @DisplayName("Test withIcon(String); then return enumValueType is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.withIcon(String)"
  })
  void testWithIcon_thenReturnEnumValueTypeIs42() {
    // Arrange and Act
    ImmutableEntityEnumDefinition actualWithIconResult =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build()
            .withIcon("42");

    // Assert
    assertEquals("42", actualWithIconResult.enumValueType());
    assertEquals("42", actualWithIconResult.icon());
    assertEquals("Name", actualWithIconResult.name());
    assertEquals("The characteristics of someone or something", actualWithIconResult.description());
    assertEquals(1, actualWithIconResult.position());
    assertEquals(EntityKind.ALL, actualWithIconResult.entityKind());
    assertTrue(actualWithIconResult.isEditable());
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEntityEnumDefinition actualWithIdResult =
        immutableEntityEnumDefinition.withId(optional);

    // Assert
    assertSame(immutableEntityEnumDefinition, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return enumValueType is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return enumValueType is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.withId(Optional)"
  })
  void testWithIdWithOptional_thenReturnEnumValueTypeIs42() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(2L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEntityEnumDefinition actualWithIdResult =
        immutableEntityEnumDefinition.withId(optional);

    // Assert
    assertEquals("42", actualWithIdResult.enumValueType());
    assertEquals("Icon", actualWithIdResult.icon());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.position());
    assertEquals(EntityKind.ALL, actualWithIdResult.entityKind());
    assertTrue(actualWithIdResult.isEditable());
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    ImmutableEntityEnumDefinition actualWithIdResult = immutableEntityEnumDefinition.withId(1L);

    // Assert
    assertSame(immutableEntityEnumDefinition, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return enumValueType is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return enumValueType is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnEnumValueTypeIs42() {
    // Arrange and Act
    ImmutableEntityEnumDefinition actualWithIdResult =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build()
            .withId(42L);

    // Assert
    assertEquals("42", actualWithIdResult.enumValueType());
    assertEquals("Icon", actualWithIdResult.icon());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.position());
    assertEquals(EntityKind.ALL, actualWithIdResult.entityKind());
    assertTrue(actualWithIdResult.isEditable());
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#withIsEditable(boolean)}.
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#withIsEditable(boolean)}
   */
  @Test
  @DisplayName("Test withIsEditable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.withIsEditable(boolean)"
  })
  void testWithIsEditable() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    ImmutableEntityEnumDefinition actualWithIsEditableResult =
        immutableEntityEnumDefinition.withIsEditable(true);

    // Assert
    assertSame(immutableEntityEnumDefinition, actualWithIsEditableResult);
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#withIsEditable(boolean)}.
   *
   * <ul>
   *   <li>Then return enumValueType is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#withIsEditable(boolean)}
   */
  @Test
  @DisplayName("Test withIsEditable(boolean); then return enumValueType is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.withIsEditable(boolean)"
  })
  void testWithIsEditable_thenReturnEnumValueTypeIs42() {
    // Arrange and Act
    ImmutableEntityEnumDefinition actualWithIsEditableResult =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(false)
            .name("Name")
            .position(1)
            .build()
            .withIsEditable(true);

    // Assert
    assertEquals("42", actualWithIsEditableResult.enumValueType());
    assertEquals("Icon", actualWithIsEditableResult.icon());
    assertEquals("Name", actualWithIsEditableResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithIsEditableResult.description());
    assertEquals(1, actualWithIsEditableResult.position());
    assertEquals(EntityKind.ALL, actualWithIsEditableResult.entityKind());
    assertTrue(actualWithIsEditableResult.isEditable());
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("42")
            .position(1)
            .build();

    // Act
    ImmutableEntityEnumDefinition actualWithNameResult =
        immutableEntityEnumDefinition.withName("42");

    // Assert
    assertSame(immutableEntityEnumDefinition, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#withName(String)}.
   *
   * <ul>
   *   <li>Then return enumValueType is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return enumValueType is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.withName(String)"
  })
  void testWithName_thenReturnEnumValueTypeIs42() {
    // Arrange and Act
    ImmutableEntityEnumDefinition actualWithNameResult =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.enumValueType());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Icon", actualWithNameResult.icon());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1, actualWithNameResult.position());
    assertEquals(EntityKind.ALL, actualWithNameResult.entityKind());
    assertTrue(actualWithNameResult.isEditable());
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#withPosition(int)}.
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.withPosition(int)"
  })
  void testWithPosition() {
    // Arrange
    ImmutableEntityEnumDefinition immutableEntityEnumDefinition =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(42)
            .build();

    // Act
    ImmutableEntityEnumDefinition actualWithPositionResult =
        immutableEntityEnumDefinition.withPosition(42);

    // Assert
    assertSame(immutableEntityEnumDefinition, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableEntityEnumDefinition#withPosition(int)}.
   *
   * <ul>
   *   <li>Then return enumValueType is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityEnumDefinition#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int); then return enumValueType is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityEnumDefinition ImmutableEntityEnumDefinition.withPosition(int)"
  })
  void testWithPosition_thenReturnEnumValueTypeIs42() {
    // Arrange and Act
    ImmutableEntityEnumDefinition actualWithPositionResult =
        ImmutableEntityEnumDefinition.builder()
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .enumValueType("42")
            .icon("Icon")
            .id(1L)
            .isEditable(true)
            .name("Name")
            .position(1)
            .build()
            .withPosition(42);

    // Assert
    assertEquals("42", actualWithPositionResult.enumValueType());
    assertEquals("Icon", actualWithPositionResult.icon());
    assertEquals("Name", actualWithPositionResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithPositionResult.description());
    assertEquals(42, actualWithPositionResult.position());
    assertEquals(EntityKind.ALL, actualWithPositionResult.entityKind());
    assertTrue(actualWithPositionResult.isEditable());
  }
}
