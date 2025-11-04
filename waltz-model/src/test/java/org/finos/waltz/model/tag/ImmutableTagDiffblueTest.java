package org.finos.waltz.model.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableTagDiffblueTest {
  /**
   * Method under test: {@link ImmutableTag.Builder#addAllTagUsages(Iterable)}
   */
  @Test
  void testBuilderAddAllTagUsages() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllTagUsages(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#addTagUsages(TagUsage)}
   */
  @Test
  void testBuilderAddTagUsages() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTagUsages(new ImmutableTagUsage.Json()));
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#addTagUsages(TagUsage)}
   */
  @Test
  void testBuilderAddTagUsages2() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();

    ImmutableTagUsage.Json element = new ImmutableTagUsage.Json();
    element.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addTagUsages(element));
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#addTagUsages(TagUsage[])}
   */
  @Test
  void testBuilderAddTagUsages3() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTagUsages(new ImmutableTagUsage.Json()));
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#addTagUsages(TagUsage[])}
   */
  @Test
  void testBuilderAddTagUsages4() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();

    ImmutableTagUsage.Json json = new ImmutableTagUsage.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addTagUsages(json));
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableTag.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableTag.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableTag.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#from(Tag)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();
    Tag instance = mock(Tag.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.tagUsages()).thenReturn(new HashSet<>());
    when(instance.targetKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableTag.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    verify(instance).tagUsages();
    verify(instance).targetKind();
    ImmutableTag buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals(EntityKind.ALL, buildResult.targetKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#from(Tag)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();
    Tag instance = mock(Tag.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.tagUsages()).thenReturn(new HashSet<>());
    when(instance.targetKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).name();
    verify(instance).tagUsages();
    verify(instance).targetKind();
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#from(Tag)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();
    Tag instance = mock(Tag.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.tagUsages()).thenReturn(new HashSet<>());
    when(instance.targetKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableTag.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    verify(instance).tagUsages();
    verify(instance).targetKind();
    ImmutableTag buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals(EntityKind.ALL, buildResult.targetKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#from(Tag)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();

    HashSet<TagUsage> tagUsageSet = new HashSet<>();
    tagUsageSet.add(new ImmutableTagUsage.Json());
    Tag instance = mock(Tag.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.tagUsages()).thenReturn(tagUsageSet);
    when(instance.targetKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableTag.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    verify(instance).tagUsages();
    verify(instance).targetKind();
    ImmutableTag buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals(1, buildResult.tagUsages().size());
    assertEquals(EntityKind.ALL, buildResult.targetKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableTagUsage.Json element = new ImmutableTagUsage.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableTag.Builder builderResult = ImmutableTag.builder();
    builderResult.addTagUsages(element);

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutableTagUsage.Json element = new ImmutableTagUsage.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableTag.Builder builderResult = ImmutableTag.builder();
    builderResult.addTagUsages(element);
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#name(String)}
   */
  @Test
  void testBuilderName2() {
    // Arrange
    ImmutableTagUsage.Json element = new ImmutableTagUsage.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableTag.Builder builderResult = ImmutableTag.builder();
    builderResult.addTagUsages(element);

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#tagUsages(Iterable)}
   */
  @Test
  void testBuilderTagUsages() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.tagUsages(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#targetKind(EntityKind)}
   */
  @Test
  void testBuilderTargetKind() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetKind(EntityKind.ALL));
  }

  /**
   * Method under test: {@link ImmutableTag.Builder#targetKind(EntityKind)}
   */
  @Test
  void testBuilderTargetKind2() {
    // Arrange
    ImmutableTagUsage.Json element = new ImmutableTagUsage.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableTag.Builder builderResult = ImmutableTag.builder();
    builderResult.addTagUsages(element);

    // Act and Assert
    assertSame(builderResult, builderResult.targetKind(EntityKind.ALL));
  }

  /**
   * Method under test: {@link ImmutableTag#copyOf(Tag)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Tag instance = mock(Tag.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.tagUsages()).thenReturn(new HashSet<>());
    when(instance.targetKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableTag actualCopyOfResult = ImmutableTag.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    verify(instance).tagUsages();
    verify(instance).targetKind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetKind());
    assertTrue(actualCopyOfResult.tagUsages().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableTag#copyOf(Tag)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    Tag instance = mock(Tag.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.tagUsages()).thenReturn(new HashSet<>());
    when(instance.targetKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableTag actualCopyOfResult = ImmutableTag.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    verify(instance).tagUsages();
    verify(instance).targetKind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetKind());
    assertTrue(actualCopyOfResult.tagUsages().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableTag#copyOf(Tag)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<TagUsage> tagUsageSet = new HashSet<>();
    tagUsageSet.add(new ImmutableTagUsage.Json());
    Tag instance = mock(Tag.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.tagUsages()).thenReturn(tagUsageSet);
    when(instance.targetKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableTag actualCopyOfResult = ImmutableTag.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    verify(instance).tagUsages();
    verify(instance).targetKind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals(1, actualCopyOfResult.tagUsages().size());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetKind());
  }

  /**
   * Method under test: {@link ImmutableTag#copyOf(Tag)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<TagUsage> tagUsageSet = new HashSet<>();
    tagUsageSet.add(new ImmutableTagUsage.Json());
    tagUsageSet.add(new ImmutableTagUsage.Json());
    Tag instance = mock(Tag.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.tagUsages()).thenReturn(tagUsageSet);
    when(instance.targetKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableTag actualCopyOfResult = ImmutableTag.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    verify(instance).tagUsages();
    verify(instance).targetKind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetKind());
    assertEquals(tagUsageSet, actualCopyOfResult.tagUsages());
  }

  /**
   * Method under test: {@link ImmutableTag#fromJson(ImmutableTag.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableTag.Json json = new ImmutableTag.Json();
    json.setId(null);
    json.setName("Json");
    json.setTargetKind(EntityKind.ALL);
    json.setTagUsages(null);

    // Act
    ImmutableTag actualFromJsonResult = ImmutableTag.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetKind());
    assertTrue(actualFromJsonResult.tagUsages().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableTag#fromJson(ImmutableTag.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<TagUsage> tagUsages = new LinkedHashSet<>();
    tagUsages.add(new ImmutableTagUsage.Json());

    ImmutableTag.Json json = new ImmutableTag.Json();
    json.setId(null);
    json.setName("Json");
    json.setTargetKind(EntityKind.ALL);
    json.setTagUsages(tagUsages);

    // Act
    ImmutableTag actualFromJsonResult = ImmutableTag.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals(1, actualFromJsonResult.tagUsages().size());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetKind());
  }

  /**
   * Method under test: {@link ImmutableTag#fromJson(ImmutableTag.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<TagUsage> tagUsages = new LinkedHashSet<>();
    tagUsages.add(new ImmutableTagUsage.Json());
    tagUsages.add(new ImmutableTagUsage.Json());

    ImmutableTag.Json json = new ImmutableTag.Json();
    json.setId(null);
    json.setName("Json");
    json.setTargetKind(EntityKind.ALL);
    json.setTagUsages(tagUsages);

    // Act
    ImmutableTag actualFromJsonResult = ImmutableTag.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetKind());
    assertEquals(tagUsages, actualFromJsonResult.tagUsages());
  }

  /**
   * Method under test: {@link ImmutableTag.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTag.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableTag.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTag.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableTag.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableTag.Json actualJson = new ImmutableTag.Json();

    // Assert
    assertNull(actualJson.name);
    assertNull(actualJson.targetKind);
    assertFalse(actualJson.id.isPresent());
    assertTrue(actualJson.tagUsages.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableTag.Json#tagUsages()}
   */
  @Test
  void testJsonTagUsages() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTag.Json()).tagUsages());
  }

  /**
   * Method under test: {@link ImmutableTag.Json#targetKind()}
   */
  @Test
  void testJsonTargetKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTag.Json()).targetKind());
  }
}
