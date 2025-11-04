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
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.IsRemovedProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableAppGroupDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAppGroup#builder()}
   *   <li>{@link ImmutableAppGroup#description(String)}
   *   <li>{@link ImmutableAppGroup#externalId(String)}
   *   <li>{@link ImmutableAppGroup#kind(EntityKind)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAppGroup.Builder actualExternalIdResult = ImmutableAppGroup.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableAppGroup.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableAppGroup.Builder actualIdResult2 = actualIdResult.id(id);

    // Assert
    assertSame(actualIdResult2, actualIdResult2.kind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroup.Builder#appGroupKind(AppGroupKind)}
   */
  @Test
  void testBuilderAppGroupKind() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appGroupKind(AppGroupKind.PUBLIC));
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroup.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableAppGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroup.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableAppGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroup.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableAppGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableAppGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableAppGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableAppGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableAppGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Builder#from(IsRemovedProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
    IsRemovedProvider instance = mock(IsRemovedProvider.class);
    when(instance.isRemoved()).thenReturn(true);

    // Act
    ImmutableAppGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).isRemoved();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAppGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Builder#from(AppGroup)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
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
    ImmutableAppGroup.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableAppGroup.Builder#from(AppGroup)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
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
    ImmutableAppGroup.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableAppGroup.Builder#from(AppGroup)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
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
    ImmutableAppGroup.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableAppGroup.Builder#from(AppGroup)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
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
    ImmutableAppGroup.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableAppGroup.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroup.Builder#isFavouriteGroup(boolean)}
   */
  @Test
  void testBuilderIsFavouriteGroup() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isFavouriteGroup(true));
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Builder#isRemoved(boolean)}
   */
  @Test
  void testBuilderIsRemoved() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRemoved(true));
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableAppGroup.Builder builderResult = ImmutableAppGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableAppGroup#copyOf(AppGroup)}
   */
  @Test
  void testCopyOf() {
    // Arrange
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
    ImmutableAppGroup actualCopyOfResult = ImmutableAppGroup.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).appGroupKind();
    verify(instance).isFavouriteGroup();
    verify(instance).kind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualCopyOfResult.appGroupKind());
    assertTrue(actualCopyOfResult.isFavouriteGroup());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutableAppGroup#copyOf(AppGroup)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
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
    ImmutableAppGroup actualCopyOfResult = ImmutableAppGroup.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).appGroupKind();
    verify(instance).isFavouriteGroup();
    verify(instance).kind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualCopyOfResult.appGroupKind());
    assertTrue(actualCopyOfResult.isFavouriteGroup());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutableAppGroup#copyOf(AppGroup)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    AppGroup instance = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isFavouriteGroup()).thenReturn(false);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.appGroupKind()).thenReturn(AppGroupKind.PUBLIC);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAppGroup actualCopyOfResult = ImmutableAppGroup.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).appGroupKind();
    verify(instance).isFavouriteGroup();
    verify(instance).kind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualCopyOfResult.appGroupKind());
    assertFalse(actualCopyOfResult.isFavouriteGroup());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutableAppGroup#copyOf(AppGroup)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
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
    ImmutableAppGroup actualCopyOfResult = ImmutableAppGroup.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).appGroupKind();
    verify(instance).isFavouriteGroup();
    verify(instance).kind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualCopyOfResult.appGroupKind());
    assertTrue(actualCopyOfResult.isFavouriteGroup());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutableAppGroup#copyOf(AppGroup)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
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
    ImmutableAppGroup actualCopyOfResult = ImmutableAppGroup.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).appGroupKind();
    verify(instance).isFavouriteGroup();
    verify(instance).kind();
    assertEquals("Name", actualCopyOfResult.name());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualCopyOfResult.appGroupKind());
    assertTrue(actualCopyOfResult.isFavouriteGroup());
    assertTrue(actualCopyOfResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutableAppGroup#fromJson(ImmutableAppGroup.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAppGroup.Json json = new ImmutableAppGroup.Json();
    json.setAppGroupKind(AppGroupKind.PUBLIC);
    json.setName("name");

    // Act
    ImmutableAppGroup actualFromJsonResult = ImmutableAppGroup.fromJson(json);

    // Assert
    assertEquals("name", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.APP_GROUP, actualFromJsonResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualFromJsonResult.appGroupKind());
    assertFalse(actualFromJsonResult.isFavouriteGroup());
    assertFalse(actualFromJsonResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutableAppGroup#fromJson(ImmutableAppGroup.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableAppGroup.Json json = new ImmutableAppGroup.Json();
    json.setKind(EntityKind.ALL);
    json.setAppGroupKind(AppGroupKind.PUBLIC);
    json.setName("name");

    // Act
    ImmutableAppGroup actualFromJsonResult = ImmutableAppGroup.fromJson(json);

    // Assert
    assertEquals("name", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualFromJsonResult.appGroupKind());
    assertFalse(actualFromJsonResult.isFavouriteGroup());
    assertFalse(actualFromJsonResult.isRemoved());
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Json#appGroupKind()}
   */
  @Test
  void testJsonAppGroupKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroup.Json()).appGroupKind());
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroup.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroup.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroup.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Json#isFavouriteGroup()}
   */
  @Test
  void testJsonIsFavouriteGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroup.Json()).isFavouriteGroup());
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Json#isRemoved()}
   */
  @Test
  void testJsonIsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroup.Json()).isRemoved());
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroup.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroup.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAppGroup.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAppGroup.Json actualJson = new ImmutableAppGroup.Json();

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
   * Method under test:
   * {@link ImmutableAppGroup.Json#setIsFavouriteGroup(boolean)}
   */
  @Test
  void testJsonSetIsFavouriteGroup() {
    // Arrange
    ImmutableAppGroup.Json json = new ImmutableAppGroup.Json();

    // Act
    json.setIsFavouriteGroup(true);

    // Assert
    assertTrue(json.isFavouriteGroup);
    assertTrue(json.isFavouriteGroupIsSet);
  }

  /**
   * Method under test: {@link ImmutableAppGroup.Json#setIsRemoved(boolean)}
   */
  @Test
  void testJsonSetIsRemoved() {
    // Arrange
    ImmutableAppGroup.Json json = new ImmutableAppGroup.Json();

    // Act
    json.setIsRemoved(true);

    // Assert
    assertTrue(json.isRemoved);
    assertTrue(json.isRemovedIsSet);
  }
}
