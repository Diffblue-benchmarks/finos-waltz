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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.tag.ImmutableTag.Builder;
import org.finos.waltz.model.tag.ImmutableTag.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ImmutableTagDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllTagUsages(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllTagUsages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllTagUsages(Iterable); when ArrayList(); then return builder")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllTagUsages(Iterable)"})
  void testBuilderAddAllTagUsages_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllTagUsages(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addTagUsages(TagUsage)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableTagUsage.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addTagUsages(TagUsage)}
   */
  @Test
  @DisplayName("Test Builder addTagUsages(TagUsage) with 'element'; when Json (default constructor); then return builder")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addTagUsages(TagUsage)"})
  void testBuilderAddTagUsagesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTagUsages(new ImmutableTagUsage.Json()));
  }

  /**
   * Test Builder {@link Builder#addTagUsages(TagUsage[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableTagUsage.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addTagUsages(TagUsage[])}
   */
  @Test
  @DisplayName("Test Builder addTagUsages(TagUsage[]) with 'elements'; when Json (default constructor); then return builder")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addTagUsages(TagUsage[])"})
  void testBuilderAddTagUsagesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTagUsages(new ImmutableTagUsage.Json()));
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
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();
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
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();
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
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();
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
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Tag)} with {@code Tag}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Tag} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Tag)}
   */
  @Test
  @DisplayName("Test Builder from(Tag) with 'Tag'; given empty; when Tag id() return empty")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Tag)"})
  void testBuilderFromWithTag_givenEmpty_whenTagIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();
    Tag instance = mock(Tag.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.tagUsages()).thenReturn(new HashSet<>());
    when(instance.targetKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(Tag)} with {@code Tag}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableTagUsage.Json} (default constructor).</li>
   *   <li>Then builder build tagUsages size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Tag)}
   */
  @Test
  @DisplayName("Test Builder from(Tag) with 'Tag'; given HashSet() add Json (default constructor); then builder build tagUsages size is one")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Tag)"})
  void testBuilderFromWithTag_givenHashSetAddJson_thenBuilderBuildTagUsagesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

    HashSet<TagUsage> tagUsageSet = new HashSet<>();
    tagUsageSet.add(new ImmutableTagUsage.Json());
    Tag instance = mock(Tag.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.tagUsages()).thenReturn(tagUsageSet);
    when(instance.targetKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(Tag)} with {@code Tag}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   *   <li>Then builder build name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Tag)}
   */
  @Test
  @DisplayName("Test Builder from(Tag) with 'Tag'; given Optional with one; then builder build name is 'Name'")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Tag)"})
  void testBuilderFromWithTag_givenOptionalWithOne_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();
    Tag instance = mock(Tag.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.tagUsages()).thenReturn(new HashSet<>());
    when(instance.targetKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(Tag)} with {@code Tag}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Tag)}
   */
  @Test
  @DisplayName("Test Builder from(Tag) with 'Tag'; then throw IllegalStateException")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Tag)"})
  void testBuilderFromWithTag_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();
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
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

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
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#tagUsages(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#tagUsages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder tagUsages(Iterable); when ArrayList(); then return builder")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.tagUsages(Iterable)"})
  void testBuilderTagUsages_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.tagUsages(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#targetKind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#targetKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder targetKind(EntityKind)")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targetKind(EntityKind)"})
  void testBuilderTargetKind() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetKind(EntityKind.ALL));
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
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
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.name);
    assertNull(actualJson.targetKind);
    assertFalse(actualJson.id.isPresent());
    assertTrue(actualJson.tagUsages.isEmpty());
  }

  /**
   * Test Json {@link Json#tagUsages()}.
   * <p>
   * Method under test: {@link Json#tagUsages()}
   */
  @Test
  @DisplayName("Test Json tagUsages()")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.tagUsages()"})
  void testJsonTagUsages() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).tagUsages());
  }

  /**
   * Test Json {@link Json#targetKind()}.
   * <p>
   * Method under test: {@link Json#targetKind()}
   */
  @Test
  @DisplayName("Test Json targetKind()")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.targetKind()"})
  void testJsonTargetKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).targetKind());
  }
}
