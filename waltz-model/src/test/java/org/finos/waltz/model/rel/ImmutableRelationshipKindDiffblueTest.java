package org.finos.waltz.model.rel;

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
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.rel.ImmutableRelationshipKind.Builder;
import org.finos.waltz.model.rel.ImmutableRelationshipKind.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRelationshipKindDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#categoryA(Long)}
   *   <li>{@link Builder#categoryB(Long)}
   *   <li>{@link Builder#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRelationshipKind Builder.build()",
    "Builder Builder.categoryA(Long)",
    "Builder Builder.categoryB(Long)",
    "Builder Builder.description(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableRelationshipKind actualImmutableRelationshipKind =
        actualIdResult
            .id(id)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Assert
    assertEquals("Code", actualImmutableRelationshipKind.code());
    assertEquals("Name", actualImmutableRelationshipKind.name());
    assertEquals("Reverse Name", actualImmutableRelationshipKind.reverseName());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableRelationshipKind.description());
    assertEquals(1, actualImmutableRelationshipKind.position());
    assertEquals(1L, actualImmutableRelationshipKind.categoryA().longValue());
    assertEquals(1L, actualImmutableRelationshipKind.categoryB().longValue());
    assertEquals(EntityKind.ALL, actualImmutableRelationshipKind.kindA());
    assertEquals(EntityKind.ALL, actualImmutableRelationshipKind.kindB());
    assertFalse(actualImmutableRelationshipKind.isReadonly());
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
    Builder builderResult = ImmutableRelationshipKind.builder();

    // Act
    Builder actualCodeResult = builderResult.code("Code");

    // Assert
    assertSame(builderResult, actualCodeResult);
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
    Builder builderResult = ImmutableRelationshipKind.builder();
    ImmutableRelationshipKind instance =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableRelationshipKind actualImmutableRelationshipKind = builderResult.build();
    assertEquals(instance, actualImmutableRelationshipKind);
    assertSame(builderResult, actualFromResult);
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
  void testBuilderFromWithDescriptionProvider2() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();
    ImmutableRelationshipKind instance =
        ImmutableRelationshipKind.builder()
            .categoryA(null)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableRelationshipKind actualImmutableRelationshipKind = builderResult.build();
    assertEquals(instance, actualImmutableRelationshipKind);
    assertSame(builderResult, actualFromResult);
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
  void testBuilderFromWithDescriptionProvider3() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();
    ImmutableRelationshipKind instance =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(null)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableRelationshipKind actualImmutableRelationshipKind = builderResult.build();
    assertEquals(instance, actualImmutableRelationshipKind);
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
    Builder builderResult = ImmutableRelationshipKind.builder();

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
    Builder builderResult = ImmutableRelationshipKind.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
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
    Builder builderResult = ImmutableRelationshipKind.builder();
    ImmutableRelationshipKind instance =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableRelationshipKind actualImmutableRelationshipKind = builderResult.build();
    assertEquals(instance, actualImmutableRelationshipKind);
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
    Builder builderResult = ImmutableRelationshipKind.builder();
    ImmutableRelationshipKind instance =
        ImmutableRelationshipKind.builder()
            .categoryA(null)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableRelationshipKind actualImmutableRelationshipKind = builderResult.build();
    assertEquals(instance, actualImmutableRelationshipKind);
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
  void testBuilderFromWithIdProvider3() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();
    ImmutableRelationshipKind instance =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(null)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableRelationshipKind actualImmutableRelationshipKind = builderResult.build();
    assertEquals(instance, actualImmutableRelationshipKind);
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
  void testBuilderFromWithIdProvider4() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();
    ImmutableRelationshipKind instance =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description(null)
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableRelationshipKind actualImmutableRelationshipKind = builderResult.build();
    assertEquals(instance, actualImmutableRelationshipKind);
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
    Builder builderResult = ImmutableRelationshipKind.builder();

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
    Builder builderResult = ImmutableRelationshipKind.builder();

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
    Builder builderResult = ImmutableRelationshipKind.builder();

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
    Builder builderResult = ImmutableRelationshipKind.builder();
    ImmutableRelationshipKind instance =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableRelationshipKind actualImmutableRelationshipKind = builderResult.build();
    assertEquals(instance, actualImmutableRelationshipKind);
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
    Builder builderResult = ImmutableRelationshipKind.builder();
    ImmutableRelationshipKind instance =
        ImmutableRelationshipKind.builder()
            .categoryA(null)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableRelationshipKind actualImmutableRelationshipKind = builderResult.build();
    assertEquals(instance, actualImmutableRelationshipKind);
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
  void testBuilderFromWithNameProvider3() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();
    ImmutableRelationshipKind instance =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(null)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableRelationshipKind actualImmutableRelationshipKind = builderResult.build();
    assertEquals(instance, actualImmutableRelationshipKind);
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
  void testBuilderFromWithNameProvider4() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();
    ImmutableRelationshipKind instance =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description(null)
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableRelationshipKind actualImmutableRelationshipKind = builderResult.build();
    assertEquals(instance, actualImmutableRelationshipKind);
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
    Builder builderResult = ImmutableRelationshipKind.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RelationshipKind)} with {@code RelationshipKind}.
   *
   * <p>Method under test: {@link Builder#from(RelationshipKind)}
   */
  @Test
  @DisplayName("Test Builder from(RelationshipKind) with 'RelationshipKind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RelationshipKind)"})
  void testBuilderFromWithRelationshipKind() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();
    ImmutableRelationshipKind instance =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRelationshipKind actualImmutableRelationshipKind = builderResult.build();
    assertEquals(instance, actualImmutableRelationshipKind);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RelationshipKind)} with {@code RelationshipKind}.
   *
   * <p>Method under test: {@link Builder#from(RelationshipKind)}
   */
  @Test
  @DisplayName("Test Builder from(RelationshipKind) with 'RelationshipKind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RelationshipKind)"})
  void testBuilderFromWithRelationshipKind2() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();
    ImmutableRelationshipKind instance =
        ImmutableRelationshipKind.builder()
            .categoryA(null)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRelationshipKind actualImmutableRelationshipKind = builderResult.build();
    assertEquals(instance, actualImmutableRelationshipKind);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RelationshipKind)} with {@code RelationshipKind}.
   *
   * <p>Method under test: {@link Builder#from(RelationshipKind)}
   */
  @Test
  @DisplayName("Test Builder from(RelationshipKind) with 'RelationshipKind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RelationshipKind)"})
  void testBuilderFromWithRelationshipKind3() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();
    ImmutableRelationshipKind instance =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(null)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRelationshipKind actualImmutableRelationshipKind = builderResult.build();
    assertEquals(instance, actualImmutableRelationshipKind);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RelationshipKind)} with {@code RelationshipKind}.
   *
   * <p>Method under test: {@link Builder#from(RelationshipKind)}
   */
  @Test
  @DisplayName("Test Builder from(RelationshipKind) with 'RelationshipKind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RelationshipKind)"})
  void testBuilderFromWithRelationshipKind4() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();
    ImmutableRelationshipKind instance =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description(null)
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRelationshipKind actualImmutableRelationshipKind = builderResult.build();
    assertEquals(instance, actualImmutableRelationshipKind);
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
    Builder builderResult = ImmutableRelationshipKind.builder();

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
    Builder builderResult = ImmutableRelationshipKind.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isReadonly(boolean)}.
   *
   * <p>Method under test: {@link Builder#isReadonly(boolean)}
   */
  @Test
  @DisplayName("Test Builder isReadonly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isReadonly(boolean)"})
  void testBuilderIsReadonly() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();

    // Act
    Builder actualIsReadonlyResult = builderResult.isReadonly(true);

    // Assert
    assertSame(builderResult, actualIsReadonlyResult);
  }

  /**
   * Test Builder {@link Builder#kindA(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#kindA(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kindA(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.kindA(EntityKind)"})
  void testBuilderKindA() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();

    // Act
    Builder actualKindAResult = builderResult.kindA(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualKindAResult);
  }

  /**
   * Test Builder {@link Builder#kindB(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#kindB(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kindB(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.kindB(EntityKind)"})
  void testBuilderKindB() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();

    // Act
    Builder actualKindBResult = builderResult.kindB(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualKindBResult);
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
    Builder builderResult = ImmutableRelationshipKind.builder();

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
    Builder builderResult = ImmutableRelationshipKind.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test Builder {@link Builder#reverseName(String)}.
   *
   * <ul>
   *   <li>When {@code Reverse Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#reverseName(String)}
   */
  @Test
  @DisplayName("Test Builder reverseName(String); when 'Reverse Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.reverseName(String)"})
  void testBuilderReverseName_whenReverseName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();

    // Act
    Builder actualReverseNameResult = builderResult.reverseName("Reverse Name");

    // Assert
    assertSame(builderResult, actualReverseNameResult);
  }

  /**
   * Test {@link ImmutableRelationshipKind#copyOf(RelationshipKind)}.
   *
   * <ul>
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#copyOf(RelationshipKind)}
   */
  @Test
  @DisplayName("Test copyOf(RelationshipKind); then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRelationshipKind ImmutableRelationshipKind.copyOf(RelationshipKind)"
  })
  void testCopyOf_thenReturnCode() {
    // Arrange
    ImmutableRelationshipKind instance =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    ImmutableRelationshipKind actualCopyOfResult = ImmutableRelationshipKind.copyOf(instance);

    // Assert
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Reverse Name", actualCopyOfResult.reverseName());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.categoryA().longValue());
    assertEquals(1L, actualCopyOfResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kindA());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kindB());
    assertFalse(actualCopyOfResult.isReadonly());
  }

  /**
   * Test {@link ImmutableRelationshipKind#equals(Object)}, and {@link
   * ImmutableRelationshipKind#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRelationshipKind#equals(Object)}
   *   <li>{@link ImmutableRelationshipKind#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRelationshipKind.equals(Object)",
    "int ImmutableRelationshipKind.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();
    ImmutableRelationshipKind immutableRelationshipKind2 =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act and Assert
    assertEquals(immutableRelationshipKind, immutableRelationshipKind2);
    assertEquals(immutableRelationshipKind.hashCode(), immutableRelationshipKind2.hashCode());
  }

  /**
   * Test {@link ImmutableRelationshipKind#equals(Object)}, and {@link
   * ImmutableRelationshipKind#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRelationshipKind#equals(Object)}
   *   <li>{@link ImmutableRelationshipKind#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRelationshipKind.equals(Object)",
    "int ImmutableRelationshipKind.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act and Assert
    assertEquals(immutableRelationshipKind, immutableRelationshipKind);
    int expectedHashCodeResult = immutableRelationshipKind.hashCode();
    assertEquals(expectedHashCodeResult, immutableRelationshipKind.hashCode());
  }

  /**
   * Test {@link ImmutableRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRelationshipKind.equals(Object)",
    "int ImmutableRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(0L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRelationshipKind,
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build());
  }

  /**
   * Test {@link ImmutableRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRelationshipKind.equals(Object)",
    "int ImmutableRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(0L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRelationshipKind,
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build());
  }

  /**
   * Test {@link ImmutableRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRelationshipKind.equals(Object)",
    "int ImmutableRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRelationshipKind,
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build());
  }

  /**
   * Test {@link ImmutableRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRelationshipKind.equals(Object)",
    "int ImmutableRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(2L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRelationshipKind,
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build());
  }

  /**
   * Test {@link ImmutableRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRelationshipKind.equals(Object)",
    "int ImmutableRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ACTOR)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRelationshipKind,
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build());
  }

  /**
   * Test {@link ImmutableRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRelationshipKind.equals(Object)",
    "int ImmutableRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ACTOR)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRelationshipKind,
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build());
  }

  /**
   * Test {@link ImmutableRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRelationshipKind.equals(Object)",
    "int ImmutableRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Code")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRelationshipKind,
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build());
  }

  /**
   * Test {@link ImmutableRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRelationshipKind.equals(Object)",
    "int ImmutableRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(0)
            .reverseName("Reverse Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRelationshipKind,
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build());
  }

  /**
   * Test {@link ImmutableRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRelationshipKind.equals(Object)",
    "int ImmutableRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRelationshipKind,
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build());
  }

  /**
   * Test {@link ImmutableRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRelationshipKind.equals(Object)",
    "int ImmutableRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRelationshipKind.equals(Object)",
    "int ImmutableRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build(),
        "Different type to ImmutableRelationshipKind");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRelationshipKind#categoryA()}
   *   <li>{@link ImmutableRelationshipKind#categoryB()}
   *   <li>{@link ImmutableRelationshipKind#code()}
   *   <li>{@link ImmutableRelationshipKind#description()}
   *   <li>{@link ImmutableRelationshipKind#isReadonly()}
   *   <li>{@link ImmutableRelationshipKind#kindA()}
   *   <li>{@link ImmutableRelationshipKind#kindB()}
   *   <li>{@link ImmutableRelationshipKind#name()}
   *   <li>{@link ImmutableRelationshipKind#position()}
   *   <li>{@link ImmutableRelationshipKind#reverseName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableRelationshipKind.categoryA()",
    "Long ImmutableRelationshipKind.categoryB()",
    "String ImmutableRelationshipKind.code()",
    "String ImmutableRelationshipKind.description()",
    "boolean ImmutableRelationshipKind.isReadonly()",
    "EntityKind ImmutableRelationshipKind.kindA()",
    "EntityKind ImmutableRelationshipKind.kindB()",
    "String ImmutableRelationshipKind.name()",
    "int ImmutableRelationshipKind.position()",
    "String ImmutableRelationshipKind.reverseName()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Long actualCategoryAResult = immutableRelationshipKind.categoryA();
    Long actualCategoryBResult = immutableRelationshipKind.categoryB();
    String actualCodeResult = immutableRelationshipKind.code();
    String actualDescriptionResult = immutableRelationshipKind.description();
    boolean actualIsReadonlyResult = immutableRelationshipKind.isReadonly();
    EntityKind actualKindAResult = immutableRelationshipKind.kindA();
    EntityKind actualKindBResult = immutableRelationshipKind.kindB();
    String actualNameResult = immutableRelationshipKind.name();
    int actualPositionResult = immutableRelationshipKind.position();

    // Assert
    assertEquals("Code", actualCodeResult);
    assertEquals("Name", actualNameResult);
    assertEquals("Reverse Name", immutableRelationshipKind.reverseName());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1, actualPositionResult);
    assertEquals(1L, actualCategoryAResult.longValue());
    assertEquals(1L, actualCategoryBResult.longValue());
    assertEquals(EntityKind.ALL, actualKindAResult);
    assertEquals(EntityKind.ALL, actualKindBResult);
    assertFalse(actualIsReadonlyResult);
  }

  /**
   * Test {@link ImmutableRelationshipKind#id()}.
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableRelationshipKind.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#categoryA()}.
   *
   * <p>Method under test: {@link Json#categoryA()}
   */
  @Test
  @DisplayName("Test Json categoryA()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.categoryA()"})
  void testJsonCategoryA() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().categoryA());
  }

  /**
   * Test Json {@link Json#categoryB()}.
   *
   * <p>Method under test: {@link Json#categoryB()}
   */
  @Test
  @DisplayName("Test Json categoryB()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.categoryB()"})
  void testJsonCategoryB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().categoryB());
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
   * Test Json {@link Json#isReadonly()}.
   *
   * <p>Method under test: {@link Json#isReadonly()}
   */
  @Test
  @DisplayName("Test Json isReadonly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isReadonly()"})
  void testJsonIsReadonly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isReadonly());
  }

  /**
   * Test Json {@link Json#kindA()}.
   *
   * <p>Method under test: {@link Json#kindA()}
   */
  @Test
  @DisplayName("Test Json kindA()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kindA()"})
  void testJsonKindA() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kindA());
  }

  /**
   * Test Json {@link Json#kindB()}.
   *
   * <p>Method under test: {@link Json#kindB()}
   */
  @Test
  @DisplayName("Test Json kindB()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kindB()"})
  void testJsonKindB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kindB());
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
    assertNull(actualJson.categoryA);
    assertNull(actualJson.categoryB);
    assertNull(actualJson.code);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.reverseName);
    assertNull(actualJson.kindA);
    assertNull(actualJson.kindB);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isReadonly);
    assertFalse(actualJson.isReadonlyIsSet);
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
   * Test Json {@link Json#reverseName()}.
   *
   * <p>Method under test: {@link Json#reverseName()}
   */
  @Test
  @DisplayName("Test Json reverseName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.reverseName()"})
  void testJsonReverseName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().reverseName());
  }

  /**
   * Test Json {@link Json#setIsReadonly(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsReadonly(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsReadonly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsReadonly(boolean)"})
  void testJsonSetIsReadonly() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsReadonly(true);

    // Assert
    assertTrue(json.isReadonly);
    assertTrue(json.isReadonlyIsSet);
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
   * Test {@link ImmutableRelationshipKind#toString()}.
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableRelationshipKind.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "RelationshipKind{id=1, name=Name, kindA=ALL, kindB=ALL, code=Code, reverseName=Reverse Name, position=1,"
            + " categoryA=1, categoryB=1, isReadonly=false}",
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableRelationshipKind#toString()}.
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableRelationshipKind.toString()"})
  void testToString2() {
    // Arrange, Act and Assert
    assertEquals(
        "RelationshipKind{id=1, name=Name, kindA=ALL, kindB=ALL, code=Code, reverseName=Reverse Name, position=1,"
            + " categoryB=1, isReadonly=false}",
        ImmutableRelationshipKind.builder()
            .categoryA(null)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableRelationshipKind#toString()}.
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableRelationshipKind.toString()"})
  void testToString3() {
    // Arrange, Act and Assert
    assertEquals(
        "RelationshipKind{id=1, name=Name, kindA=ALL, kindB=ALL, code=Code, reverseName=Reverse Name, position=1,"
            + " categoryA=1, isReadonly=false}",
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(null)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableRelationshipKind#withCategoryA(Long)}.
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withCategoryA(Long)}
   */
  @Test
  @DisplayName("Test withCategoryA(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withCategoryA(Long)"})
  void testWithCategoryA() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    ImmutableRelationshipKind actualWithCategoryAResult =
        immutableRelationshipKind.withCategoryA(1L);

    // Assert
    assertSame(immutableRelationshipKind, actualWithCategoryAResult);
  }

  /**
   * Test {@link ImmutableRelationshipKind#withCategoryA(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withCategoryA(Long)}
   */
  @Test
  @DisplayName("Test withCategoryA(Long); when forty-two; then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withCategoryA(Long)"})
  void testWithCategoryA_whenFortyTwo_thenReturnCode() {
    // Arrange and Act
    ImmutableRelationshipKind actualWithCategoryAResult =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build()
            .withCategoryA(42L);

    // Assert
    assertEquals("Code", actualWithCategoryAResult.code());
    assertEquals("Name", actualWithCategoryAResult.name());
    assertEquals("Reverse Name", actualWithCategoryAResult.reverseName());
    assertEquals(
        "The characteristics of someone or something", actualWithCategoryAResult.description());
    assertEquals(1, actualWithCategoryAResult.position());
    assertEquals(1L, actualWithCategoryAResult.categoryB().longValue());
    assertEquals(42L, actualWithCategoryAResult.categoryA().longValue());
    assertEquals(EntityKind.ALL, actualWithCategoryAResult.kindA());
    assertEquals(EntityKind.ALL, actualWithCategoryAResult.kindB());
    assertFalse(actualWithCategoryAResult.isReadonly());
  }

  /**
   * Test {@link ImmutableRelationshipKind#withCategoryB(Long)}.
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withCategoryB(Long)}
   */
  @Test
  @DisplayName("Test withCategoryB(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withCategoryB(Long)"})
  void testWithCategoryB() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    ImmutableRelationshipKind actualWithCategoryBResult =
        immutableRelationshipKind.withCategoryB(1L);

    // Assert
    assertSame(immutableRelationshipKind, actualWithCategoryBResult);
  }

  /**
   * Test {@link ImmutableRelationshipKind#withCategoryB(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withCategoryB(Long)}
   */
  @Test
  @DisplayName("Test withCategoryB(Long); when forty-two; then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withCategoryB(Long)"})
  void testWithCategoryB_whenFortyTwo_thenReturnCode() {
    // Arrange and Act
    ImmutableRelationshipKind actualWithCategoryBResult =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build()
            .withCategoryB(42L);

    // Assert
    assertEquals("Code", actualWithCategoryBResult.code());
    assertEquals("Name", actualWithCategoryBResult.name());
    assertEquals("Reverse Name", actualWithCategoryBResult.reverseName());
    assertEquals(
        "The characteristics of someone or something", actualWithCategoryBResult.description());
    assertEquals(1, actualWithCategoryBResult.position());
    assertEquals(1L, actualWithCategoryBResult.categoryA().longValue());
    assertEquals(42L, actualWithCategoryBResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, actualWithCategoryBResult.kindA());
    assertEquals(EntityKind.ALL, actualWithCategoryBResult.kindB());
    assertFalse(actualWithCategoryBResult.isReadonly());
  }

  /**
   * Test {@link ImmutableRelationshipKind#withCode(String)}.
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withCode(String)}
   */
  @Test
  @DisplayName("Test withCode(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withCode(String)"})
  void testWithCode() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("42")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    ImmutableRelationshipKind actualWithCodeResult = immutableRelationshipKind.withCode("42");

    // Assert
    assertSame(immutableRelationshipKind, actualWithCodeResult);
  }

  /**
   * Test {@link ImmutableRelationshipKind#withCode(String)}.
   *
   * <ul>
   *   <li>Then return code is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withCode(String)}
   */
  @Test
  @DisplayName("Test withCode(String); then return code is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withCode(String)"})
  void testWithCode_thenReturnCodeIs42() {
    // Arrange and Act
    ImmutableRelationshipKind actualWithCodeResult =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build()
            .withCode("42");

    // Assert
    assertEquals("42", actualWithCodeResult.code());
    assertEquals("Name", actualWithCodeResult.name());
    assertEquals("Reverse Name", actualWithCodeResult.reverseName());
    assertEquals("The characteristics of someone or something", actualWithCodeResult.description());
    assertEquals(1, actualWithCodeResult.position());
    assertEquals(1L, actualWithCodeResult.categoryA().longValue());
    assertEquals(1L, actualWithCodeResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, actualWithCodeResult.kindA());
    assertEquals(EntityKind.ALL, actualWithCodeResult.kindB());
    assertFalse(actualWithCodeResult.isReadonly());
  }

  /**
   * Test {@link ImmutableRelationshipKind#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    ImmutableRelationshipKind actualWithDescriptionResult =
        immutableRelationshipKind.withDescription("42");

    // Assert
    assertEquals(immutableRelationshipKind, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableRelationshipKind#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("42")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    ImmutableRelationshipKind actualWithDescriptionResult =
        immutableRelationshipKind.withDescription("42");

    // Assert
    assertSame(immutableRelationshipKind, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableRelationshipKind#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableRelationshipKind actualWithIdResult = immutableRelationshipKind.withId(optional);

    // Assert
    assertSame(immutableRelationshipKind, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableRelationshipKind#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withId(Optional)"})
  void testWithIdWithOptional_thenReturnCode() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(2L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableRelationshipKind actualWithIdResult = immutableRelationshipKind.withId(optional);

    // Assert
    assertEquals("Code", actualWithIdResult.code());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Reverse Name", actualWithIdResult.reverseName());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.position());
    assertEquals(1L, actualWithIdResult.categoryA().longValue());
    assertEquals(1L, actualWithIdResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, actualWithIdResult.kindA());
    assertEquals(EntityKind.ALL, actualWithIdResult.kindB());
    assertFalse(actualWithIdResult.isReadonly());
  }

  /**
   * Test {@link ImmutableRelationshipKind#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    ImmutableRelationshipKind actualWithIdResult = immutableRelationshipKind.withId(1L);

    // Assert
    assertSame(immutableRelationshipKind, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableRelationshipKind#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnCode() {
    // Arrange and Act
    ImmutableRelationshipKind actualWithIdResult =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build()
            .withId(42L);

    // Assert
    assertEquals("Code", actualWithIdResult.code());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Reverse Name", actualWithIdResult.reverseName());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.position());
    assertEquals(1L, actualWithIdResult.categoryA().longValue());
    assertEquals(1L, actualWithIdResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, actualWithIdResult.kindA());
    assertEquals(EntityKind.ALL, actualWithIdResult.kindB());
    assertFalse(actualWithIdResult.isReadonly());
  }

  /**
   * Test {@link ImmutableRelationshipKind#withIsReadonly(boolean)}.
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withIsReadonly(boolean)}
   */
  @Test
  @DisplayName("Test withIsReadonly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withIsReadonly(boolean)"})
  void testWithIsReadonly() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    ImmutableRelationshipKind actualWithIsReadonlyResult =
        immutableRelationshipKind.withIsReadonly(false);

    // Assert
    assertSame(immutableRelationshipKind, actualWithIsReadonlyResult);
  }

  /**
   * Test {@link ImmutableRelationshipKind#withIsReadonly(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withIsReadonly(boolean)}
   */
  @Test
  @DisplayName("Test withIsReadonly(boolean); when 'true'; then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withIsReadonly(boolean)"})
  void testWithIsReadonly_whenTrue_thenReturnCode() {
    // Arrange and Act
    ImmutableRelationshipKind actualWithIsReadonlyResult =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build()
            .withIsReadonly(true);

    // Assert
    assertEquals("Code", actualWithIsReadonlyResult.code());
    assertEquals("Name", actualWithIsReadonlyResult.name());
    assertEquals("Reverse Name", actualWithIsReadonlyResult.reverseName());
    assertEquals(
        "The characteristics of someone or something", actualWithIsReadonlyResult.description());
    assertEquals(1, actualWithIsReadonlyResult.position());
    assertEquals(1L, actualWithIsReadonlyResult.categoryA().longValue());
    assertEquals(1L, actualWithIsReadonlyResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, actualWithIsReadonlyResult.kindA());
    assertEquals(EntityKind.ALL, actualWithIsReadonlyResult.kindB());
    assertTrue(actualWithIsReadonlyResult.isReadonly());
  }

  /**
   * Test {@link ImmutableRelationshipKind#withKindA(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withKindA(EntityKind)}
   */
  @Test
  @DisplayName("Test withKindA(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withKindA(EntityKind)"})
  void testWithKindA() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    ImmutableRelationshipKind actualWithKindAResult =
        immutableRelationshipKind.withKindA(EntityKind.ALL);

    // Assert
    assertSame(immutableRelationshipKind, actualWithKindAResult);
  }

  /**
   * Test {@link ImmutableRelationshipKind#withKindA(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withKindA(EntityKind)}
   */
  @Test
  @DisplayName("Test withKindA(EntityKind); then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withKindA(EntityKind)"})
  void testWithKindA_thenReturnCode() {
    // Arrange and Act
    ImmutableRelationshipKind actualWithKindAResult =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ACTOR)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build()
            .withKindA(EntityKind.ALL);

    // Assert
    assertEquals("Code", actualWithKindAResult.code());
    assertEquals("Name", actualWithKindAResult.name());
    assertEquals("Reverse Name", actualWithKindAResult.reverseName());
    assertEquals(
        "The characteristics of someone or something", actualWithKindAResult.description());
    assertEquals(1, actualWithKindAResult.position());
    assertEquals(1L, actualWithKindAResult.categoryA().longValue());
    assertEquals(1L, actualWithKindAResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, actualWithKindAResult.kindA());
    assertEquals(EntityKind.ALL, actualWithKindAResult.kindB());
    assertFalse(actualWithKindAResult.isReadonly());
  }

  /**
   * Test {@link ImmutableRelationshipKind#withKindB(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withKindB(EntityKind)}
   */
  @Test
  @DisplayName("Test withKindB(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withKindB(EntityKind)"})
  void testWithKindB() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    ImmutableRelationshipKind actualWithKindBResult =
        immutableRelationshipKind.withKindB(EntityKind.ALL);

    // Assert
    assertSame(immutableRelationshipKind, actualWithKindBResult);
  }

  /**
   * Test {@link ImmutableRelationshipKind#withKindB(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withKindB(EntityKind)}
   */
  @Test
  @DisplayName("Test withKindB(EntityKind); then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withKindB(EntityKind)"})
  void testWithKindB_thenReturnCode() {
    // Arrange and Act
    ImmutableRelationshipKind actualWithKindBResult =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ACTOR)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build()
            .withKindB(EntityKind.ALL);

    // Assert
    assertEquals("Code", actualWithKindBResult.code());
    assertEquals("Name", actualWithKindBResult.name());
    assertEquals("Reverse Name", actualWithKindBResult.reverseName());
    assertEquals(
        "The characteristics of someone or something", actualWithKindBResult.description());
    assertEquals(1, actualWithKindBResult.position());
    assertEquals(1L, actualWithKindBResult.categoryA().longValue());
    assertEquals(1L, actualWithKindBResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, actualWithKindBResult.kindA());
    assertEquals(EntityKind.ALL, actualWithKindBResult.kindB());
    assertFalse(actualWithKindBResult.isReadonly());
  }

  /**
   * Test {@link ImmutableRelationshipKind#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("42")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    ImmutableRelationshipKind actualWithNameResult = immutableRelationshipKind.withName("42");

    // Assert
    assertSame(immutableRelationshipKind, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableRelationshipKind#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableRelationshipKind actualWithNameResult =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Code", actualWithNameResult.code());
    assertEquals("Reverse Name", actualWithNameResult.reverseName());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1, actualWithNameResult.position());
    assertEquals(1L, actualWithNameResult.categoryA().longValue());
    assertEquals(1L, actualWithNameResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, actualWithNameResult.kindA());
    assertEquals(EntityKind.ALL, actualWithNameResult.kindB());
    assertFalse(actualWithNameResult.isReadonly());
  }

  /**
   * Test {@link ImmutableRelationshipKind#withPosition(int)}.
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withPosition(int)"})
  void testWithPosition() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(42)
            .reverseName("Reverse Name")
            .build();

    // Act
    ImmutableRelationshipKind actualWithPositionResult = immutableRelationshipKind.withPosition(42);

    // Assert
    assertSame(immutableRelationshipKind, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableRelationshipKind#withPosition(int)}.
   *
   * <ul>
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int); then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withPosition(int)"})
  void testWithPosition_thenReturnCode() {
    // Arrange and Act
    ImmutableRelationshipKind actualWithPositionResult =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build()
            .withPosition(42);

    // Assert
    assertEquals("Code", actualWithPositionResult.code());
    assertEquals("Name", actualWithPositionResult.name());
    assertEquals("Reverse Name", actualWithPositionResult.reverseName());
    assertEquals(
        "The characteristics of someone or something", actualWithPositionResult.description());
    assertEquals(1L, actualWithPositionResult.categoryA().longValue());
    assertEquals(1L, actualWithPositionResult.categoryB().longValue());
    assertEquals(42, actualWithPositionResult.position());
    assertEquals(EntityKind.ALL, actualWithPositionResult.kindA());
    assertEquals(EntityKind.ALL, actualWithPositionResult.kindB());
    assertFalse(actualWithPositionResult.isReadonly());
  }

  /**
   * Test {@link ImmutableRelationshipKind#withReverseName(String)}.
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withReverseName(String)}
   */
  @Test
  @DisplayName("Test withReverseName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withReverseName(String)"})
  void testWithReverseName() {
    // Arrange
    ImmutableRelationshipKind immutableRelationshipKind =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("42")
            .build();

    // Act
    ImmutableRelationshipKind actualWithReverseNameResult =
        immutableRelationshipKind.withReverseName("42");

    // Assert
    assertSame(immutableRelationshipKind, actualWithReverseNameResult);
  }

  /**
   * Test {@link ImmutableRelationshipKind#withReverseName(String)}.
   *
   * <ul>
   *   <li>Then return reverseName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRelationshipKind#withReverseName(String)}
   */
  @Test
  @DisplayName("Test withReverseName(String); then return reverseName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRelationshipKind ImmutableRelationshipKind.withReverseName(String)"})
  void testWithReverseName_thenReturnReverseNameIs42() {
    // Arrange and Act
    ImmutableRelationshipKind actualWithReverseNameResult =
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build()
            .withReverseName("42");

    // Assert
    assertEquals("42", actualWithReverseNameResult.reverseName());
    assertEquals("Code", actualWithReverseNameResult.code());
    assertEquals("Name", actualWithReverseNameResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithReverseNameResult.description());
    assertEquals(1, actualWithReverseNameResult.position());
    assertEquals(1L, actualWithReverseNameResult.categoryA().longValue());
    assertEquals(1L, actualWithReverseNameResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, actualWithReverseNameResult.kindA());
    assertEquals(EntityKind.ALL, actualWithReverseNameResult.kindB());
    assertFalse(actualWithReverseNameResult.isReadonly());
  }
}
