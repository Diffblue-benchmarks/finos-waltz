package org.finos.waltz.model.entity_workflow;

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
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.entity_workflow.ImmutableEntityWorkflowDefinition.Builder;
import org.finos.waltz.model.entity_workflow.ImmutableEntityWorkflowDefinition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityWorkflowDefinitionDiffblueTest {
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
    "ImmutableEntityWorkflowDefinition Builder.build()",
    "Builder Builder.description(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableEntityWorkflowDefinition actualImmutableEntityWorkflowDefinition =
        actualIdResult.id(id).name("Name").build();

    // Assert
    assertEquals("Name", actualImmutableEntityWorkflowDefinition.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableEntityWorkflowDefinition.description());
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
    Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    ImmutableEntityWorkflowDefinition instance =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableEntityWorkflowDefinition actualImmutableEntityWorkflowDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowDefinition);
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
    Builder builderResult = ImmutableEntityWorkflowDefinition.builder();

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
    Builder builderResult = ImmutableEntityWorkflowDefinition.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityWorkflowDefinition)} with {@code
   * EntityWorkflowDefinition}.
   *
   * <p>Method under test: {@link Builder#from(EntityWorkflowDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityWorkflowDefinition) with 'EntityWorkflowDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityWorkflowDefinition)"})
  void testBuilderFromWithEntityWorkflowDefinition() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    ImmutableEntityWorkflowDefinition instance =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityWorkflowDefinition actualImmutableEntityWorkflowDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityWorkflowDefinition)} with {@code
   * EntityWorkflowDefinition}.
   *
   * <p>Method under test: {@link Builder#from(EntityWorkflowDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityWorkflowDefinition) with 'EntityWorkflowDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityWorkflowDefinition)"})
  void testBuilderFromWithEntityWorkflowDefinition2() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    ImmutableEntityWorkflowDefinition instance =
        ImmutableEntityWorkflowDefinition.builder().description(null).id(1L).name("Name").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityWorkflowDefinition actualImmutableEntityWorkflowDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowDefinition);
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
    Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    ImmutableEntityWorkflowDefinition instance =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableEntityWorkflowDefinition actualImmutableEntityWorkflowDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowDefinition);
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
  void testBuilderFromWithIdProvider2() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    ImmutableEntityWorkflowDefinition instance =
        ImmutableEntityWorkflowDefinition.builder().description(null).id(1L).name("Name").build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableEntityWorkflowDefinition actualImmutableEntityWorkflowDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   *   <li>Then calls {@link IdProvider#id()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty; then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty_thenCallsId() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowDefinition.builder();

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
   *   <li>Then calls {@link IdProvider#id()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one; then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne_thenCallsId() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowDefinition.builder();

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
    Builder builderResult = ImmutableEntityWorkflowDefinition.builder();

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
    Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    ImmutableEntityWorkflowDefinition instance =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableEntityWorkflowDefinition actualImmutableEntityWorkflowDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowDefinition);
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
    Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    ImmutableEntityWorkflowDefinition instance =
        ImmutableEntityWorkflowDefinition.builder().description(null).id(1L).name("Name").build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableEntityWorkflowDefinition actualImmutableEntityWorkflowDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then builder build name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then builder build name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowDefinition.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    ImmutableEntityWorkflowDefinition immutableEntityWorkflowDefinition = builderResult.build();
    assertEquals("Name", immutableEntityWorkflowDefinition.name());
    assertNull(immutableEntityWorkflowDefinition.description());
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
    Builder builderResult = ImmutableEntityWorkflowDefinition.builder();

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
    Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then builder build name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then builder build name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowDefinition.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableEntityWorkflowDefinition immutableEntityWorkflowDefinition = builderResult.build();
    assertEquals("Name", immutableEntityWorkflowDefinition.name());
    assertNull(immutableEntityWorkflowDefinition.description());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#copyOf(EntityWorkflowDefinition)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityWorkflowDefinition#copyOf(EntityWorkflowDefinition)}
   */
  @Test
  @DisplayName("Test copyOf(EntityWorkflowDefinition); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowDefinition ImmutableEntityWorkflowDefinition.copyOf(EntityWorkflowDefinition)"
  })
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableEntityWorkflowDefinition instance =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableEntityWorkflowDefinition actualCopyOfResult =
        ImmutableEntityWorkflowDefinition.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#equals(Object)}, and {@link
   * ImmutableEntityWorkflowDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityWorkflowDefinition#equals(Object)}
   *   <li>{@link ImmutableEntityWorkflowDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowDefinition.equals(Object)",
    "int ImmutableEntityWorkflowDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableEntityWorkflowDefinition immutableEntityWorkflowDefinition =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();
    ImmutableEntityWorkflowDefinition immutableEntityWorkflowDefinition2 =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableEntityWorkflowDefinition, immutableEntityWorkflowDefinition2);
    assertEquals(
        immutableEntityWorkflowDefinition.hashCode(),
        immutableEntityWorkflowDefinition2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#equals(Object)}, and {@link
   * ImmutableEntityWorkflowDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityWorkflowDefinition#equals(Object)}
   *   <li>{@link ImmutableEntityWorkflowDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowDefinition.equals(Object)",
    "int ImmutableEntityWorkflowDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableEntityWorkflowDefinition immutableEntityWorkflowDefinition =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableEntityWorkflowDefinition, immutableEntityWorkflowDefinition);
    int expectedHashCodeResult = immutableEntityWorkflowDefinition.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityWorkflowDefinition.hashCode());
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowDefinition.equals(Object)",
    "int ImmutableEntityWorkflowDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableEntityWorkflowDefinition immutableEntityWorkflowDefinition =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(2L)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityWorkflowDefinition,
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowDefinition.equals(Object)",
    "int ImmutableEntityWorkflowDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableEntityWorkflowDefinition immutableEntityWorkflowDefinition =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("java.lang.Long")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityWorkflowDefinition,
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowDefinition.equals(Object)",
    "int ImmutableEntityWorkflowDefinition.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowDefinition.equals(Object)",
    "int ImmutableEntityWorkflowDefinition.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build(),
        "Different type to ImmutableEntityWorkflowDefinition");
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Description is {@code Json}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowDefinition#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Description is 'Json'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowDefinition ImmutableEntityWorkflowDefinition.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonDescriptionIsJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription("Json");

    // Act
    ImmutableEntityWorkflowDefinition actualFromJsonResult =
        ImmutableEntityWorkflowDefinition.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Name is {@code Json}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowDefinition#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Name is 'Json'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowDefinition ImmutableEntityWorkflowDefinition.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonNameIsJson_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription(null);

    // Act
    ImmutableEntityWorkflowDefinition actualFromJsonResult =
        ImmutableEntityWorkflowDefinition.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link Json} (default constructor) Id is of one.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowDefinition#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of one; when Json (default constructor) Id is of one; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowDefinition ImmutableEntityWorkflowDefinition.fromJson(Json)"
  })
  void testFromJson_givenOfOne_whenJsonIdIsOfOne_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(1L);
    json.setId(id);
    json.setName("Json");
    json.setDescription(null);

    // Act
    ImmutableEntityWorkflowDefinition actualFromJsonResult =
        ImmutableEntityWorkflowDefinition.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityWorkflowDefinition#description()}
   *   <li>{@link ImmutableEntityWorkflowDefinition#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableEntityWorkflowDefinition.description()",
    "String ImmutableEntityWorkflowDefinition.name()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableEntityWorkflowDefinition immutableEntityWorkflowDefinition =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    String actualDescriptionResult = immutableEntityWorkflowDefinition.description();

    // Assert
    assertEquals("Name", immutableEntityWorkflowDefinition.name());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#id()}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowDefinition#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntityWorkflowDefinition.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
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
    assertNull(actualJson.name);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableEntityWorkflowDefinition.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "EntityWorkflowDefinition{id=1, name=Name}",
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowDefinition#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowDefinition ImmutableEntityWorkflowDefinition.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableEntityWorkflowDefinition immutableEntityWorkflowDefinition =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableEntityWorkflowDefinition actualWithDescriptionResult =
        immutableEntityWorkflowDefinition.withDescription("42");

    // Assert
    assertEquals(immutableEntityWorkflowDefinition, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return builder description {@code 42} id one name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowDefinition#withDescription(String)}
   */
  @Test
  @DisplayName(
      "Test withDescription(String); then return builder description '42' id one name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowDefinition ImmutableEntityWorkflowDefinition.withDescription(String)"
  })
  void testWithDescription_thenReturnBuilderDescription42IdOneNameNameBuild() {
    // Arrange
    ImmutableEntityWorkflowDefinition immutableEntityWorkflowDefinition =
        ImmutableEntityWorkflowDefinition.builder().description("42").id(1L).name("Name").build();

    // Act
    ImmutableEntityWorkflowDefinition actualWithDescriptionResult =
        immutableEntityWorkflowDefinition.withDescription("42");

    // Assert
    assertSame(immutableEntityWorkflowDefinition, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowDefinition#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowDefinition ImmutableEntityWorkflowDefinition.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutableEntityWorkflowDefinition immutableEntityWorkflowDefinition =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEntityWorkflowDefinition actualWithIdResult =
        immutableEntityWorkflowDefinition.withId(optional);

    // Assert
    assertSame(immutableEntityWorkflowDefinition, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowDefinition#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowDefinition ImmutableEntityWorkflowDefinition.withId(Optional)"
  })
  void testWithIdWithOptional_thenReturnName() {
    // Arrange
    ImmutableEntityWorkflowDefinition immutableEntityWorkflowDefinition =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(2L)
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEntityWorkflowDefinition actualWithIdResult =
        immutableEntityWorkflowDefinition.withId(optional);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowDefinition#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowDefinition ImmutableEntityWorkflowDefinition.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    ImmutableEntityWorkflowDefinition immutableEntityWorkflowDefinition =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableEntityWorkflowDefinition actualWithIdResult =
        immutableEntityWorkflowDefinition.withId(1L);

    // Assert
    assertSame(immutableEntityWorkflowDefinition, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowDefinition#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowDefinition ImmutableEntityWorkflowDefinition.withId(long)"
  })
  void testWithIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange and Act
    ImmutableEntityWorkflowDefinition actualWithIdResult =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build()
            .withId(42L);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowDefinition#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowDefinition ImmutableEntityWorkflowDefinition.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableEntityWorkflowDefinition immutableEntityWorkflowDefinition =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("42")
            .build();

    // Act
    ImmutableEntityWorkflowDefinition actualWithNameResult =
        immutableEntityWorkflowDefinition.withName("42");

    // Assert
    assertSame(immutableEntityWorkflowDefinition, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowDefinition#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowDefinition#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowDefinition ImmutableEntityWorkflowDefinition.withName(String)"
  })
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableEntityWorkflowDefinition actualWithNameResult =
        ImmutableEntityWorkflowDefinition.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
  }
}
