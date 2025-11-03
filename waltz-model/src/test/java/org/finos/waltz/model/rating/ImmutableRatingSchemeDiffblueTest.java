package org.finos.waltz.model.rating;

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
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.rating.ImmutableRatingScheme.Builder;
import org.finos.waltz.model.rating.ImmutableRatingScheme.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRatingSchemeDiffblueTest {
  /**
   * Test {@link ImmutableRatingScheme#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableRatingScheme#builder()}
   *   <li>{@link ImmutableRatingScheme#description(String)}
   *   <li>{@link ImmutableRatingScheme#externalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableRatingScheme Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.externalId(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualExternalIdResult = ImmutableRatingScheme.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Test Builder {@link Builder#addAllRatings(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRatings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatings(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRatings(Iterable)"})
  void testBuilderAddAllRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatings(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addRatings(RatingSchemeItem)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableRatingSchemeItem.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRatings(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder addRatings(RatingSchemeItem) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatings(RatingSchemeItem)"})
  void testBuilderAddRatingsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatings(new ImmutableRatingSchemeItem.Json()));
  }

  /**
   * Test Builder {@link Builder#addRatings(RatingSchemeItem[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableRatingSchemeItem.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRatings(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test Builder addRatings(RatingSchemeItem[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatings(RatingSchemeItem[])"})
  void testBuilderAddRatingsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatings(new ImmutableRatingSchemeItem.Json()));
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
    Builder builderResult = ImmutableRatingScheme.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
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
    Builder builderResult = ImmutableRatingScheme.builder();
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
    Builder builderResult = ImmutableRatingScheme.builder();
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
    Builder builderResult = ImmutableRatingScheme.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
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
    Builder builderResult = ImmutableRatingScheme.builder();
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
    Builder builderResult = ImmutableRatingScheme.builder();
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
    Builder builderResult = ImmutableRatingScheme.builder();
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
    Builder builderResult = ImmutableRatingScheme.builder();
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
    Builder builderResult = ImmutableRatingScheme.builder();
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
    Builder builderResult = ImmutableRatingScheme.builder();
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
   *   <li>Then builder build name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then builder build name is 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    ImmutableRatingScheme buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(6, buildResult.ratings().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingScheme)} with {@code RatingScheme}.
   * <p>
   * Method under test: {@link Builder#from(RatingScheme)}
   */
  @Test
  @DisplayName("Test Builder from(RatingScheme) with 'RatingScheme'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RatingScheme)"})
  void testBuilderFromWithRatingScheme() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();
    RatingScheme instance = mock(RatingScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.ratings()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).ratings();
    ImmutableRatingScheme buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingScheme)} with {@code RatingScheme}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link RatingScheme} {@link ExternalIdProvider#externalId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RatingScheme)}
   */
  @Test
  @DisplayName("Test Builder from(RatingScheme) with 'RatingScheme'; given empty; when RatingScheme externalId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RatingScheme)"})
  void testBuilderFromWithRatingScheme_givenEmpty_whenRatingSchemeExternalIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();
    RatingScheme instance = mock(RatingScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.ratings()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).ratings();
    ImmutableRatingScheme buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingScheme)} with {@code RatingScheme}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link RatingScheme} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RatingScheme)}
   */
  @Test
  @DisplayName("Test Builder from(RatingScheme) with 'RatingScheme'; given empty; when RatingScheme id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RatingScheme)"})
  void testBuilderFromWithRatingScheme_givenEmpty_whenRatingSchemeIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();
    RatingScheme instance = mock(RatingScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.ratings()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).ratings();
    ImmutableRatingScheme buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingScheme)} with {@code RatingScheme}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RatingScheme)}
   */
  @Test
  @DisplayName("Test Builder from(RatingScheme) with 'RatingScheme'; then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RatingScheme)"})
  void testBuilderFromWithRatingScheme_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();
    RatingScheme instance = mock(RatingScheme.class);
    when(instance.description()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.ratings()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).ratings();
    ImmutableRatingScheme buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingScheme)} with {@code RatingScheme}.
   * <ul>
   *   <li>Then builder build ratings size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RatingScheme)}
   */
  @Test
  @DisplayName("Test Builder from(RatingScheme) with 'RatingScheme'; then builder build ratings size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RatingScheme)"})
  void testBuilderFromWithRatingScheme_thenBuilderBuildRatingsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ImmutableRatingSchemeItem.Json json = new ImmutableRatingSchemeItem.Json();
    ratingSchemeItemList.add(json);
    RatingScheme instance = mock(RatingScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.ratings()).thenReturn(ratingSchemeItemList);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).ratings();
    List<RatingSchemeItem> ratingsResult = builderResult.build().ratings();
    assertEquals(1, ratingsResult.size());
    assertEquals(ratingSchemeItemList, actualFromResult.build().ratings());
    assertSame(json, ratingsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(RatingScheme)} with {@code RatingScheme}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RatingScheme)}
   */
  @Test
  @DisplayName("Test Builder from(RatingScheme) with 'RatingScheme'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RatingScheme)"})
  void testBuilderFromWithRatingScheme_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();
    RatingScheme instance = mock(RatingScheme.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
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
    Builder builderResult = ImmutableRatingScheme.builder();

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
    Builder builderResult = ImmutableRatingScheme.builder();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableRatingScheme buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(6, buildResult.ratings().size());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#ratings(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratings(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratings(Iterable)"})
  void testBuilderRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratings(new ArrayList<>()));
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
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.ratingsIsSet);
    assertTrue(actualJson.ratings.isEmpty());
  }

  /**
   * Test Json {@link Json#ratings()}.
   * <p>
   * Method under test: {@link Json#ratings()}
   */
  @Test
  @DisplayName("Test Json ratings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.ratings()"})
  void testJsonRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratings());
  }

  /**
   * Test Json {@link Json#setRatings(List)}.
   * <ul>
   *   <li>Given {@link ImmutableRatingSchemeItem.Json} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ImmutableRatingSchemeItem.Json} (default constructor).</li>
   *   <li>Then {@link Json} (default constructor) {@link Json#ratings} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setRatings(List)}
   */
  @Test
  @DisplayName("Test Json setRatings(List); given Json (default constructor); when ArrayList() add Json (default constructor); then Json (default constructor) ratings size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRatings(List)"})
  void testJsonSetRatings_givenJson_whenArrayListAddJson_thenJsonRatingsSizeIsOne() {
    // Arrange
    Json json = new Json();

    ArrayList<RatingSchemeItem> ratings = new ArrayList<>();
    ImmutableRatingSchemeItem.Json json2 = new ImmutableRatingSchemeItem.Json();
    ratings.add(json2);

    // Act
    json.setRatings(ratings);

    // Assert
    List<RatingSchemeItem> ratingSchemeItemList = json.ratings;
    assertEquals(1, ratingSchemeItemList.size());
    assertTrue(json.ratingsIsSet);
    assertSame(json2, ratingSchemeItemList.get(0));
  }

  /**
   * Test Json {@link Json#setRatings(List)}.
   * <ul>
   *   <li>Given {@link ImmutableRatingSchemeItem.Json} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ImmutableRatingSchemeItem.Json} (default constructor).</li>
   *   <li>Then {@link Json} (default constructor) {@link Json#ratings} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setRatings(List)}
   */
  @Test
  @DisplayName("Test Json setRatings(List); given Json (default constructor); when ArrayList() add Json (default constructor); then Json (default constructor) ratings size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRatings(List)"})
  void testJsonSetRatings_givenJson_whenArrayListAddJson_thenJsonRatingsSizeIsTwo() {
    // Arrange
    Json json = new Json();

    ArrayList<RatingSchemeItem> ratings = new ArrayList<>();
    ImmutableRatingSchemeItem.Json json2 = new ImmutableRatingSchemeItem.Json();
    ratings.add(json2);
    ImmutableRatingSchemeItem.Json json3 = new ImmutableRatingSchemeItem.Json();
    ratings.add(json3);

    // Act
    json.setRatings(ratings);

    // Assert
    List<RatingSchemeItem> ratingSchemeItemList = json.ratings;
    assertEquals(2, ratingSchemeItemList.size());
    assertSame(json2, ratingSchemeItemList.get(0));
    assertSame(json3, ratingSchemeItemList.get(1));
  }

  /**
   * Test Json {@link Json#setRatings(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link Json} (default constructor) {@link Json#ratings} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setRatings(List)}
   */
  @Test
  @DisplayName("Test Json setRatings(List); when ArrayList(); then Json (default constructor) ratings Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRatings(List)"})
  void testJsonSetRatings_whenArrayList_thenJsonRatingsEmpty() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRatings(new ArrayList<>());

    // Assert
    assertTrue(json.ratings.isEmpty());
    assertTrue(json.ratingsIsSet);
  }

  /**
   * Test Json {@link Json#setRatings(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link Json} (default constructor) {@link Json#ratings} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setRatings(List)}
   */
  @Test
  @DisplayName("Test Json setRatings(List); when 'null'; then Json (default constructor) ratings is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRatings(List)"})
  void testJsonSetRatings_whenNull_thenJsonRatingsIsNull() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRatings(null);

    // Assert
    assertNull(json.ratings);
    assertFalse(json.ratingsIsSet);
  }
}
