package org.finos.waltz.model.rel;

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
   * Test {@link ImmutableRelationshipKind#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableRelationshipKind#builder()}
   *   <li>{@link ImmutableRelationshipKind#categoryA(Long)}
   *   <li>{@link ImmutableRelationshipKind#categoryB(Long)}
   *   <li>{@link ImmutableRelationshipKind#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableRelationshipKind Builder.build()", "Builder Builder.categoryA(Long)",
      "Builder Builder.categoryB(Long)", "Builder Builder.description(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualIdResult = ImmutableRelationshipKind.builder()
        .categoryA(1L)
        .categoryB(1L)
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Test Builder {@link Builder#code(String)}.
   * <p>
   * Method under test: {@link Builder#code(String)}
   */
  @Test
  @DisplayName("Test Builder code(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.code(String)"})
  void testBuilderCode() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.code("Code"));
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
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
    Builder builderResult = ImmutableRelationshipKind.builder();
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
    Builder builderResult = ImmutableRelationshipKind.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
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
   * <p>
   * Method under test: {@link Builder#from(RelationshipKind)}
   */
  @Test
  @DisplayName("Test Builder from(RelationshipKind) with 'RelationshipKind'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RelationshipKind)"})
  void testBuilderFromWithRelationshipKind() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();
    RelationshipKind instance = mock(RelationshipKind.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kindB()).thenReturn(EntityKind.ALL);
    when(instance.categoryA()).thenReturn(1L);
    when(instance.kindA()).thenReturn(EntityKind.ALL);
    when(instance.reverseName()).thenReturn("Reverse Name");
    when(instance.categoryB()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.isReadonly()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryA();
    verify(instance).categoryB();
    verify(instance).code();
    verify(instance).isReadonly();
    verify(instance).kindA();
    verify(instance).kindB();
    verify(instance).position();
    verify(instance).reverseName();
    ImmutableRelationshipKind buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Name", buildResult.name());
    assertEquals("Reverse Name", buildResult.reverseName());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.categoryA().longValue());
    assertEquals(1L, buildResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, buildResult.kindA());
    assertEquals(EntityKind.ALL, buildResult.kindB());
    assertTrue(buildResult.isReadonly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RelationshipKind)} with {@code RelationshipKind}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link RelationshipKind} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RelationshipKind)}
   */
  @Test
  @DisplayName("Test Builder from(RelationshipKind) with 'RelationshipKind'; given empty; when RelationshipKind id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RelationshipKind)"})
  void testBuilderFromWithRelationshipKind_givenEmpty_whenRelationshipKindIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();
    RelationshipKind instance = mock(RelationshipKind.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.kindB()).thenReturn(EntityKind.ALL);
    when(instance.categoryA()).thenReturn(1L);
    when(instance.kindA()).thenReturn(EntityKind.ALL);
    when(instance.reverseName()).thenReturn("Reverse Name");
    when(instance.categoryB()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.isReadonly()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryA();
    verify(instance).categoryB();
    verify(instance).code();
    verify(instance).isReadonly();
    verify(instance).kindA();
    verify(instance).kindB();
    verify(instance).position();
    verify(instance).reverseName();
    ImmutableRelationshipKind buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Name", buildResult.name());
    assertEquals("Reverse Name", buildResult.reverseName());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.categoryA().longValue());
    assertEquals(1L, buildResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, buildResult.kindA());
    assertEquals(EntityKind.ALL, buildResult.kindB());
    assertTrue(buildResult.isReadonly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RelationshipKind)} with {@code RelationshipKind}.
   * <ul>
   *   <li>Then builder build categoryA is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RelationshipKind)}
   */
  @Test
  @DisplayName("Test Builder from(RelationshipKind) with 'RelationshipKind'; then builder build categoryA is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RelationshipKind)"})
  void testBuilderFromWithRelationshipKind_thenBuilderBuildCategoryAIsNull() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();
    RelationshipKind instance = mock(RelationshipKind.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kindB()).thenReturn(EntityKind.ALL);
    when(instance.categoryA()).thenReturn(null);
    when(instance.kindA()).thenReturn(EntityKind.ALL);
    when(instance.reverseName()).thenReturn("Reverse Name");
    when(instance.categoryB()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.isReadonly()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryA();
    verify(instance).categoryB();
    verify(instance).code();
    verify(instance).isReadonly();
    verify(instance).kindA();
    verify(instance).kindB();
    verify(instance).position();
    verify(instance).reverseName();
    ImmutableRelationshipKind buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Name", buildResult.name());
    assertEquals("Reverse Name", buildResult.reverseName());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.categoryA());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, buildResult.kindA());
    assertEquals(EntityKind.ALL, buildResult.kindB());
    assertTrue(buildResult.isReadonly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RelationshipKind)} with {@code RelationshipKind}.
   * <ul>
   *   <li>Then builder build categoryB is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RelationshipKind)}
   */
  @Test
  @DisplayName("Test Builder from(RelationshipKind) with 'RelationshipKind'; then builder build categoryB is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RelationshipKind)"})
  void testBuilderFromWithRelationshipKind_thenBuilderBuildCategoryBIsNull() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();
    RelationshipKind instance = mock(RelationshipKind.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kindB()).thenReturn(EntityKind.ALL);
    when(instance.categoryA()).thenReturn(1L);
    when(instance.kindA()).thenReturn(EntityKind.ALL);
    when(instance.reverseName()).thenReturn("Reverse Name");
    when(instance.categoryB()).thenReturn(null);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.isReadonly()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryA();
    verify(instance).categoryB();
    verify(instance).code();
    verify(instance).isReadonly();
    verify(instance).kindA();
    verify(instance).kindB();
    verify(instance).position();
    verify(instance).reverseName();
    ImmutableRelationshipKind buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Name", buildResult.name());
    assertEquals("Reverse Name", buildResult.reverseName());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.categoryB());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.categoryA().longValue());
    assertEquals(EntityKind.ALL, buildResult.kindA());
    assertEquals(EntityKind.ALL, buildResult.kindB());
    assertTrue(buildResult.isReadonly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RelationshipKind)} with {@code RelationshipKind}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RelationshipKind)}
   */
  @Test
  @DisplayName("Test Builder from(RelationshipKind) with 'RelationshipKind'; then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RelationshipKind)"})
  void testBuilderFromWithRelationshipKind_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();
    RelationshipKind instance = mock(RelationshipKind.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kindB()).thenReturn(EntityKind.ALL);
    when(instance.categoryA()).thenReturn(1L);
    when(instance.kindA()).thenReturn(EntityKind.ALL);
    when(instance.reverseName()).thenReturn("Reverse Name");
    when(instance.categoryB()).thenReturn(1L);
    when(instance.description()).thenReturn(null);
    when(instance.code()).thenReturn("Code");
    when(instance.isReadonly()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryA();
    verify(instance).categoryB();
    verify(instance).code();
    verify(instance).isReadonly();
    verify(instance).kindA();
    verify(instance).kindB();
    verify(instance).position();
    verify(instance).reverseName();
    ImmutableRelationshipKind buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Name", buildResult.name());
    assertEquals("Reverse Name", buildResult.reverseName());
    assertNull(buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.categoryA().longValue());
    assertEquals(1L, buildResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, buildResult.kindA());
    assertEquals(EntityKind.ALL, buildResult.kindB());
    assertTrue(buildResult.isReadonly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RelationshipKind)} with {@code RelationshipKind}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RelationshipKind)}
   */
  @Test
  @DisplayName("Test Builder from(RelationshipKind) with 'RelationshipKind'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RelationshipKind)"})
  void testBuilderFromWithRelationshipKind_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();
    RelationshipKind instance = mock(RelationshipKind.class);
    when(instance.position()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kindB()).thenReturn(EntityKind.ALL);
    when(instance.categoryA()).thenReturn(1L);
    when(instance.kindA()).thenReturn(EntityKind.ALL);
    when(instance.reverseName()).thenReturn("Reverse Name");
    when(instance.categoryB()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.isReadonly()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryA();
    verify(instance).categoryB();
    verify(instance).code();
    verify(instance).isReadonly();
    verify(instance).kindA();
    verify(instance).kindB();
    verify(instance).position();
    verify(instance).reverseName();
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
    Builder builderResult = ImmutableRelationshipKind.builder();

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
    Builder builderResult = ImmutableRelationshipKind.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#isReadonly(boolean)}.
   * <p>
   * Method under test: {@link Builder#isReadonly(boolean)}
   */
  @Test
  @DisplayName("Test Builder isReadonly(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isReadonly(boolean)"})
  void testBuilderIsReadonly() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadonly(true));
  }

  /**
   * Test Builder {@link Builder#kindA(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#kindA(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kindA(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.kindA(EntityKind)"})
  void testBuilderKindA() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kindA(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#kindB(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#kindB(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kindB(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.kindB(EntityKind)"})
  void testBuilderKindB() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kindB(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   * <p>
   * Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Test Builder {@link Builder#reverseName(String)}.
   * <p>
   * Method under test: {@link Builder#reverseName(String)}
   */
  @Test
  @DisplayName("Test Builder reverseName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.reverseName(String)"})
  void testBuilderReverseName() {
    // Arrange
    Builder builderResult = ImmutableRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.reverseName("Reverse Name"));
  }

  /**
   * Test Json {@link Json#categoryA()}.
   * <p>
   * Method under test: {@link Json#categoryA()}
   */
  @Test
  @DisplayName("Test Json categoryA()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.categoryA()"})
  void testJsonCategoryA() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).categoryA());
  }

  /**
   * Test Json {@link Json#categoryB()}.
   * <p>
   * Method under test: {@link Json#categoryB()}
   */
  @Test
  @DisplayName("Test Json categoryB()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.categoryB()"})
  void testJsonCategoryB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).categoryB());
  }

  /**
   * Test Json {@link Json#code()}.
   * <p>
   * Method under test: {@link Json#code()}
   */
  @Test
  @DisplayName("Test Json code()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.code()"})
  void testJsonCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).code());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
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
   * Test Json {@link Json#isReadonly()}.
   * <p>
   * Method under test: {@link Json#isReadonly()}
   */
  @Test
  @DisplayName("Test Json isReadonly()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isReadonly()"})
  void testJsonIsReadonly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isReadonly());
  }

  /**
   * Test Json {@link Json#kindA()}.
   * <p>
   * Method under test: {@link Json#kindA()}
   */
  @Test
  @DisplayName("Test Json kindA()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.kindA()"})
  void testJsonKindA() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kindA());
  }

  /**
   * Test Json {@link Json#kindB()}.
   * <p>
   * Method under test: {@link Json#kindB()}
   */
  @Test
  @DisplayName("Test Json kindB()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.kindB()"})
  void testJsonKindB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kindB());
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
   * <p>
   * Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).position());
  }

  /**
   * Test Json {@link Json#reverseName()}.
   * <p>
   * Method under test: {@link Json#reverseName()}
   */
  @Test
  @DisplayName("Test Json reverseName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.reverseName()"})
  void testJsonReverseName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).reverseName());
  }

  /**
   * Test Json {@link Json#setIsReadonly(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsReadonly(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsReadonly(boolean)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("MaintainedByDiffblue")
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
}
