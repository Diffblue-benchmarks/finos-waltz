package org.finos.waltz.model.app_group;

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
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.IsRemovedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.app_group.ImmutableAppGroup.Builder;
import org.finos.waltz.model.app_group.ImmutableAppGroup.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppGroupDiffblueTest {
  /**
   * Test {@link ImmutableAppGroup#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAppGroup#builder()}
   *   <li>{@link ImmutableAppGroup#description(String)}
   *   <li>{@link ImmutableAppGroup#externalId(String)}
   *   <li>{@link ImmutableAppGroup#kind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAppGroup Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.externalId(String)", "Builder Builder.kind(EntityKind)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualExternalIdResult = ImmutableAppGroup.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualIdResult2 = actualIdResult.id(id);

    // Assert
    assertSame(actualIdResult2, actualIdResult2.kind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#appGroupKind(AppGroupKind)}.
   * <p>
   * Method under test: {@link Builder#appGroupKind(AppGroupKind)}
   */
  @Test
  @DisplayName("Test Builder appGroupKind(AppGroupKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.appGroupKind(AppGroupKind)"})
  void testBuilderAppGroupKind() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appGroupKind(AppGroupKind.PUBLIC));
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Test Builder {@link Builder#from(AppGroup)} with {@code AppGroup}.
   * <p>
   * Method under test: {@link Builder#from(AppGroup)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroup) with 'AppGroup'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppGroup)"})
  void testBuilderFromWithAppGroup() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();
    AppGroup instance = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isFavouriteGroup()).thenReturn(true);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.appGroupKind()).thenReturn(AppGroupKind.PUBLIC);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).appGroupKind();
    verify(instance).isFavouriteGroup();
    verify(instance).kind();
    ImmutableAppGroup buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(AppGroupKind.PUBLIC, buildResult.appGroupKind());
    assertTrue(buildResult.isFavouriteGroup());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AppGroup)} with {@code AppGroup}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link AppGroup} {@link ExternalIdProvider#externalId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppGroup)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroup) with 'AppGroup'; given empty; when AppGroup externalId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppGroup)"})
  void testBuilderFromWithAppGroup_givenEmpty_whenAppGroupExternalIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();
    AppGroup instance = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isFavouriteGroup()).thenReturn(true);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.appGroupKind()).thenReturn(AppGroupKind.PUBLIC);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).appGroupKind();
    verify(instance).isFavouriteGroup();
    verify(instance).kind();
    ImmutableAppGroup buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(AppGroupKind.PUBLIC, buildResult.appGroupKind());
    assertTrue(buildResult.isFavouriteGroup());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AppGroup)} with {@code AppGroup}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link AppGroup} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppGroup)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroup) with 'AppGroup'; given empty; when AppGroup id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppGroup)"})
  void testBuilderFromWithAppGroup_givenEmpty_whenAppGroupIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();
    AppGroup instance = mock(AppGroup.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.isFavouriteGroup()).thenReturn(true);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.appGroupKind()).thenReturn(AppGroupKind.PUBLIC);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).appGroupKind();
    verify(instance).isFavouriteGroup();
    verify(instance).kind();
    ImmutableAppGroup buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(AppGroupKind.PUBLIC, buildResult.appGroupKind());
    assertTrue(buildResult.isFavouriteGroup());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AppGroup)} with {@code AppGroup}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppGroup)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroup) with 'AppGroup'; then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppGroup)"})
  void testBuilderFromWithAppGroup_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();
    AppGroup instance = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isFavouriteGroup()).thenReturn(true);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.appGroupKind()).thenReturn(AppGroupKind.PUBLIC);
    when(instance.description()).thenReturn(null);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).appGroupKind();
    verify(instance).isFavouriteGroup();
    verify(instance).kind();
    ImmutableAppGroup buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(AppGroupKind.PUBLIC, buildResult.appGroupKind());
    assertTrue(buildResult.isFavouriteGroup());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableAppGroup.builder();
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
    Builder builderResult = ImmutableAppGroup.builder();
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
    Builder builderResult = ImmutableAppGroup.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
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
    Builder builderResult = ImmutableAppGroup.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOptionalWithFoo() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
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
    Builder builderResult = ImmutableAppGroup.builder();
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
    Builder builderResult = ImmutableAppGroup.builder();
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
    Builder builderResult = ImmutableAppGroup.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'; given 'true'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider_givenTrue_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();
    IsRemovedProvider instance = mock(IsRemovedProvider.class);
    when(instance.isRemoved()).thenReturn(true);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).isRemoved();
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableAppGroup.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
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
    Builder builderResult = ImmutableAppGroup.builder();

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
    Builder builderResult = ImmutableAppGroup.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#isFavouriteGroup(boolean)}.
   * <p>
   * Method under test: {@link Builder#isFavouriteGroup(boolean)}
   */
  @Test
  @DisplayName("Test Builder isFavouriteGroup(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isFavouriteGroup(boolean)"})
  void testBuilderIsFavouriteGroup() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isFavouriteGroup(true));
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
    Builder builderResult = ImmutableAppGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRemoved(true));
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
    Builder builderResult = ImmutableAppGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Json {@link Json#appGroupKind()}.
   * <p>
   * Method under test: {@link Json#appGroupKind()}
   */
  @Test
  @DisplayName("Test Json appGroupKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AppGroupKind Json.appGroupKind()"})
  void testJsonAppGroupKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).appGroupKind());
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
   * Test Json {@link Json#externalId()}.
   * <p>
   * Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).externalId());
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
   * Test Json {@link Json#isFavouriteGroup()}.
   * <p>
   * Method under test: {@link Json#isFavouriteGroup()}
   */
  @Test
  @DisplayName("Test Json isFavouriteGroup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isFavouriteGroup()"})
  void testJsonIsFavouriteGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isFavouriteGroup());
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
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.kind);
    assertNull(actualJson.appGroupKind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isFavouriteGroup);
    assertFalse(actualJson.isFavouriteGroupIsSet);
    assertFalse(actualJson.isRemoved);
    assertFalse(actualJson.isRemovedIsSet);
  }

  /**
   * Test Json {@link Json#setIsFavouriteGroup(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsFavouriteGroup(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsFavouriteGroup(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsFavouriteGroup(boolean)"})
  void testJsonSetIsFavouriteGroup() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsFavouriteGroup(true);

    // Assert
    assertTrue(json.isFavouriteGroup);
    assertTrue(json.isFavouriteGroupIsSet);
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
}
