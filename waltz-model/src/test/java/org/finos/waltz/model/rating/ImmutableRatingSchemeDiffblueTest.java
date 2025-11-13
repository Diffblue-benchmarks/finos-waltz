package org.finos.waltz.model.rating;

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
   * Test Builder {@link Builder#addAllRatings(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRatings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatings(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRatings(Iterable)"})
  void testBuilderAddAllRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();

    // Act
    Builder actualAddAllRatingsResult = builderResult.addAllRatings(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addRatings(RatingSchemeItem)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableRatingSchemeItem.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRatings(RatingSchemeItem)}
   */
  @Test
  @DisplayName(
      "Test Builder addRatings(RatingSchemeItem) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatings(RatingSchemeItem)"})
  void testBuilderAddRatingsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();

    // Act
    Builder actualAddRatingsResult = builderResult.addRatings(new ImmutableRatingSchemeItem.Json());

    // Assert
    assertSame(builderResult, actualAddRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addRatings(RatingSchemeItem[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableRatingSchemeItem.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRatings(RatingSchemeItem[])}
   */
  @Test
  @DisplayName(
      "Test Builder addRatings(RatingSchemeItem[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatings(RatingSchemeItem[])"})
  void testBuilderAddRatingsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();

    // Act
    Builder actualAddRatingsResult = builderResult.addRatings(new ImmutableRatingSchemeItem.Json());

    // Assert
    assertSame(builderResult, actualAddRatingsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingScheme Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableRatingScheme.builder();
    Builder actualAddAllRatingsResult = actualBuilderResult.addAllRatings(new ArrayList<>());
    ImmutableRatingSchemeItem element =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Builder actualAddRatingsResult = actualAddAllRatingsResult.addRatings(element);
    Builder actualExternalIdResult =
        actualAddRatingsResult
            .addRatings(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("42");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutableRatingScheme actualImmutableRatingScheme = actualIdResult.id(id).name("Name").build();

    // Assert
    List<RatingSchemeItem> ratingsResult = actualImmutableRatingScheme.ratings();
    assertEquals(2, ratingsResult.size());
    RatingSchemeItem getResult = ratingsResult.get(1);
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    assertEquals("Name", actualImmutableRatingScheme.name());
    assertEquals(
        "The characteristics of someone or something", actualImmutableRatingScheme.description());
    assertEquals(element, getResult);
    assertSame(element, ratingsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();
    Optional<String> externalId = Optional.of("42");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
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
    Builder builderResult = ImmutableRatingScheme.builder();

    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme instance = nameResult.addAllRatings(new ArrayList<>()).build();

    // Act and Assert
    ImmutableRatingScheme actualImmutableRatingScheme =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableRatingScheme);
    ImmutableRatingScheme actualImmutableRatingScheme2 = builderResult.build();
    assertEquals(instance, actualImmutableRatingScheme2);
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
    Builder builderResult = ImmutableRatingScheme.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();

    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme instance = nameResult.addAllRatings(new ArrayList<>()).build();

    // Act and Assert
    ImmutableRatingScheme actualImmutableRatingScheme =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableRatingScheme);
    ImmutableRatingScheme actualImmutableRatingScheme2 = builderResult.build();
    assertEquals(instance, actualImmutableRatingScheme2);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given of {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given of '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOf42() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("42");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
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
    Builder builderResult = ImmutableRatingScheme.builder();

    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme instance = nameResult.addAllRatings(new ArrayList<>()).build();

    // Act and Assert
    ImmutableRatingScheme actualImmutableRatingScheme =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableRatingScheme);
    ImmutableRatingScheme actualImmutableRatingScheme2 = builderResult.build();
    assertEquals(instance, actualImmutableRatingScheme2);
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
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of forty-two; when IdProvider id() return of forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfFortyTwo_whenIdProviderIdReturnOfFortyTwo() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(42L);
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
    Builder builderResult = ImmutableRatingScheme.builder();

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
    Builder builderResult = ImmutableRatingScheme.builder();

    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme instance = nameResult.addAllRatings(new ArrayList<>()).build();

    // Act and Assert
    ImmutableRatingScheme actualImmutableRatingScheme =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableRatingScheme);
    ImmutableRatingScheme actualImmutableRatingScheme2 = builderResult.build();
    assertEquals(instance, actualImmutableRatingScheme2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return build ratings size is six.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return build ratings size is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuildRatingsSizeIsSix() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    ImmutableRatingScheme immutableRatingScheme = actualFromResult.build();
    List<RatingSchemeItem> ratingsResult = immutableRatingScheme.ratings();
    assertEquals(6, ratingsResult.size());
    assertTrue(ratingsResult.get(0) instanceof ImmutableRatingSchemeItem);
    assertTrue(ratingsResult.get(1) instanceof ImmutableRatingSchemeItem);
    assertTrue(ratingsResult.get(4) instanceof ImmutableRatingSchemeItem);
    assertTrue(ratingsResult.get(5) instanceof ImmutableRatingSchemeItem);
    ImmutableRatingScheme immutableRatingScheme2 = builderResult.build();
    assertEquals("Name", immutableRatingScheme2.name());
    assertNull(immutableRatingScheme.description());
    assertNull(immutableRatingScheme2.description());
    assertEquals(6, immutableRatingScheme2.ratings().size());
  }

  /**
   * Test Builder {@link Builder#from(RatingScheme)} with {@code RatingScheme}.
   *
   * <p>Method under test: {@link Builder#from(RatingScheme)}
   */
  @Test
  @DisplayName("Test Builder from(RatingScheme) with 'RatingScheme'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RatingScheme)"})
  void testBuilderFromWithRatingScheme() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();

    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme instance = nameResult.addAllRatings(new ArrayList<>()).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRatingScheme actualImmutableRatingScheme = builderResult.build();
    assertEquals(instance, actualImmutableRatingScheme);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingScheme)} with {@code RatingScheme}.
   *
   * <ul>
   *   <li>Then return build ratings size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(RatingScheme)}
   */
  @Test
  @DisplayName(
      "Test Builder from(RatingScheme) with 'RatingScheme'; then return build ratings size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RatingScheme)"})
  void testBuilderFromWithRatingScheme_thenReturnBuildRatingsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();

    Builder builderResult2 = ImmutableRatingScheme.builder();
    builderResult2.addRatings(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    Builder nameResult =
        builderResult2
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");

    // Act and Assert
    List<RatingSchemeItem> ratingsResult =
        builderResult.from(nameResult.addAllRatings(new ArrayList<>()).build()).build().ratings();
    assertEquals(1, ratingsResult.size());
    RatingSchemeItem getResult = ratingsResult.get(0);
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", getResult.color());
    assertEquals("Name", getResult.name());
    assertEquals("Rating Group", getResult.ratingGroup());
    assertEquals("Rating", getResult.rating());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(0, getResult.position());
    assertEquals(1L, getResult.ratingSchemeId());
    assertFalse(getResult.isRestricted());
    assertFalse(getResult.requiresComment());
    assertTrue(getResult.userSelectable());
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
    Builder builderResult = ImmutableRatingScheme.builder();

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
    Builder builderResult = ImmutableRatingScheme.builder();
    Optional<Long> id = Optional.of(42L);

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
    Builder builderResult = ImmutableRatingScheme.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableRatingScheme immutableRatingScheme = builderResult.build();
    assertEquals("Name", immutableRatingScheme.name());
    assertNull(immutableRatingScheme.description());
    assertEquals(6, immutableRatingScheme.ratings().size());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#ratings(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratings(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratings(Iterable)"})
  void testBuilderRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();

    // Act
    Builder actualRatingsResult = builderResult.ratings(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRatingsResult);
  }

  /**
   * Test {@link ImmutableRatingScheme#copyOf(RatingScheme)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingScheme#copyOf(RatingScheme)}
   */
  @Test
  @DisplayName("Test copyOf(RatingScheme); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingScheme ImmutableRatingScheme.copyOf(RatingScheme)"})
  void testCopyOf_thenReturnName() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme instance = nameResult.addAllRatings(new ArrayList<>()).build();

    // Act
    ImmutableRatingScheme actualCopyOfResult = ImmutableRatingScheme.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertTrue(actualCopyOfResult.ratings().isEmpty());
  }

  /**
   * Test {@link ImmutableRatingScheme#equals(Object)}, and {@link
   * ImmutableRatingScheme#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRatingScheme#equals(Object)}
   *   <li>{@link ImmutableRatingScheme#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingScheme.equals(Object)",
    "int ImmutableRatingScheme.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme immutableRatingScheme =
        nameResult.addAllRatings(new ArrayList<>()).build();

    Builder nameResult2 =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme immutableRatingScheme2 =
        nameResult2.addAllRatings(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(immutableRatingScheme, immutableRatingScheme2);
    assertEquals(immutableRatingScheme.hashCode(), immutableRatingScheme2.hashCode());
  }

  /**
   * Test {@link ImmutableRatingScheme#equals(Object)}, and {@link
   * ImmutableRatingScheme#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRatingScheme#equals(Object)}
   *   <li>{@link ImmutableRatingScheme#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingScheme.equals(Object)",
    "int ImmutableRatingScheme.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme immutableRatingScheme =
        nameResult.addAllRatings(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(immutableRatingScheme, immutableRatingScheme);
    int expectedHashCodeResult = immutableRatingScheme.hashCode();
    assertEquals(expectedHashCodeResult, immutableRatingScheme.hashCode());
  }

  /**
   * Test {@link ImmutableRatingScheme#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingScheme#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingScheme.equals(Object)",
    "int ImmutableRatingScheme.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableRatingScheme.builder();
    builderResult.addRatings(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    Builder nameResult =
        builderResult
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme immutableRatingScheme =
        nameResult.addAllRatings(new ArrayList<>()).build();

    Builder nameResult2 =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(immutableRatingScheme, nameResult2.addAllRatings(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutableRatingScheme#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingScheme#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingScheme.equals(Object)",
    "int ImmutableRatingScheme.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("Name")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme immutableRatingScheme =
        nameResult.addAllRatings(new ArrayList<>()).build();

    Builder nameResult2 =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(immutableRatingScheme, nameResult2.addAllRatings(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutableRatingScheme#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingScheme#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingScheme.equals(Object)",
    "int ImmutableRatingScheme.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .name("Name");
    ImmutableRatingScheme immutableRatingScheme =
        nameResult.addAllRatings(new ArrayList<>()).build();

    Builder nameResult2 =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(immutableRatingScheme, nameResult2.addAllRatings(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutableRatingScheme#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingScheme#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingScheme.equals(Object)",
    "int ImmutableRatingScheme.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("externalId");
    ImmutableRatingScheme immutableRatingScheme =
        nameResult.addAllRatings(new ArrayList<>()).build();

    Builder nameResult2 =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(immutableRatingScheme, nameResult2.addAllRatings(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutableRatingScheme#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingScheme#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingScheme.equals(Object)",
    "int ImmutableRatingScheme.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(nameResult.addAllRatings(new ArrayList<>()).build(), null);
  }

  /**
   * Test {@link ImmutableRatingScheme#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingScheme#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingScheme.equals(Object)",
    "int ImmutableRatingScheme.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(
        nameResult.addAllRatings(new ArrayList<>()).build(),
        "Different type to ImmutableRatingScheme");
  }

  /**
   * Test {@link ImmutableRatingScheme#externalId()}.
   *
   * <p>Method under test: {@link ImmutableRatingScheme#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableRatingScheme.externalId()"})
  void testExternalId() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");

    // Act
    Optional<String> actualExternalIdResult =
        nameResult.addAllRatings(new ArrayList<>()).build().externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableRatingScheme#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code name}.
   *   <li>When {@link Json} (default constructor) Name is {@code name}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingScheme#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'name'; when Json (default constructor) Name is 'name'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingScheme ImmutableRatingScheme.fromJson(Json)"})
  void testFromJson_givenName_whenJsonNameIsName_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setName("name");

    // Act
    ImmutableRatingScheme actualFromJsonResult = ImmutableRatingScheme.fromJson(json);

    // Assert
    List<RatingSchemeItem> ratingsResult = actualFromJsonResult.ratings();
    assertEquals(6, ratingsResult.size());
    assertTrue(ratingsResult.get(0) instanceof ImmutableRatingSchemeItem);
    assertTrue(ratingsResult.get(1) instanceof ImmutableRatingSchemeItem);
    assertTrue(ratingsResult.get(2) instanceof ImmutableRatingSchemeItem);
    assertTrue(ratingsResult.get(3) instanceof ImmutableRatingSchemeItem);
    assertTrue(ratingsResult.get(4) instanceof ImmutableRatingSchemeItem);
    assertTrue(ratingsResult.get(5) instanceof ImmutableRatingSchemeItem);
    assertEquals("name", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Test {@link ImmutableRatingScheme#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingScheme#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Id is 'null'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingScheme ImmutableRatingScheme.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonIdIsNull_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setName("name");
    json.setId(null);

    // Act
    ImmutableRatingScheme actualFromJsonResult = ImmutableRatingScheme.fromJson(json);

    // Assert
    List<RatingSchemeItem> ratingsResult = actualFromJsonResult.ratings();
    assertEquals(6, ratingsResult.size());
    assertTrue(ratingsResult.get(0) instanceof ImmutableRatingSchemeItem);
    assertTrue(ratingsResult.get(1) instanceof ImmutableRatingSchemeItem);
    assertTrue(ratingsResult.get(2) instanceof ImmutableRatingSchemeItem);
    assertTrue(ratingsResult.get(3) instanceof ImmutableRatingSchemeItem);
    assertTrue(ratingsResult.get(4) instanceof ImmutableRatingSchemeItem);
    assertTrue(ratingsResult.get(5) instanceof ImmutableRatingSchemeItem);
    assertEquals("name", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Test {@link ImmutableRatingScheme#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingScheme#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingScheme ImmutableRatingScheme.fromJson(Json)"})
  void testFromJson_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    Json json = new Json();
    json.setDescription("The characteristics of someone or something");
    json.setName("name");

    // Act
    ImmutableRatingScheme actualFromJsonResult = ImmutableRatingScheme.fromJson(json);

    // Assert
    List<RatingSchemeItem> ratingsResult = actualFromJsonResult.ratings();
    assertEquals(6, ratingsResult.size());
    assertTrue(ratingsResult.get(0) instanceof ImmutableRatingSchemeItem);
    assertTrue(ratingsResult.get(1) instanceof ImmutableRatingSchemeItem);
    assertTrue(ratingsResult.get(2) instanceof ImmutableRatingSchemeItem);
    assertTrue(ratingsResult.get(3) instanceof ImmutableRatingSchemeItem);
    assertTrue(ratingsResult.get(4) instanceof ImmutableRatingSchemeItem);
    assertTrue(ratingsResult.get(5) instanceof ImmutableRatingSchemeItem);
    assertEquals("The characteristics of someone or something", actualFromJsonResult.description());
    assertEquals("name", actualFromJsonResult.name());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRatingScheme#description()}
   *   <li>{@link ImmutableRatingScheme#name()}
   *   <li>{@link ImmutableRatingScheme#ratings()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableRatingScheme.description()",
    "String ImmutableRatingScheme.name()",
    "List ImmutableRatingScheme.ratings()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme immutableRatingScheme =
        nameResult.addAllRatings(new ArrayList<>()).build();

    // Act
    String actualDescriptionResult = immutableRatingScheme.description();
    String actualNameResult = immutableRatingScheme.name();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertTrue(immutableRatingScheme.ratings().isEmpty());
  }

  /**
   * Test {@link ImmutableRatingScheme#id()}.
   *
   * <p>Method under test: {@link ImmutableRatingScheme#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableRatingScheme.id()"})
  void testId() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");

    // Act
    Optional<Long> actualIdResult = nameResult.addAllRatings(new ArrayList<>()).build().id();

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
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
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
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.ratingsIsSet);
    assertTrue(actualJson.ratings.isEmpty());
  }

  /**
   * Test Json {@link Json#ratings()}.
   *
   * <p>Method under test: {@link Json#ratings()}
   */
  @Test
  @DisplayName("Test Json ratings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.ratings()"})
  void testJsonRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratings());
  }

  /**
   * Test Json {@link Json#setRatings(List)}.
   *
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#ratings} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Json#setRatings(List)}
   */
  @Test
  @DisplayName("Test Json setRatings(List); then Json (default constructor) ratings size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRatings(List)"})
  void testJsonSetRatings_thenJsonRatingsSizeIsOne() {
    // Arrange
    Json json = new Json();

    ArrayList<RatingSchemeItem> ratings = new ArrayList<>();
    ratings.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    // Act
    json.setRatings(ratings);

    // Assert
    assertEquals(1, json.ratings.size());
    assertTrue(json.ratingsIsSet);
  }

  /**
   * Test Json {@link Json#setRatings(List)}.
   *
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#ratings} size is two.
   * </ul>
   *
   * <p>Method under test: {@link Json#setRatings(List)}
   */
  @Test
  @DisplayName("Test Json setRatings(List); then Json (default constructor) ratings size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRatings(List)"})
  void testJsonSetRatings_thenJsonRatingsSizeIsTwo() {
    // Arrange
    Json json = new Json();

    ArrayList<RatingSchemeItem> ratings = new ArrayList<>();
    ratings.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    ratings.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    // Act
    json.setRatings(ratings);

    // Assert
    assertEquals(2, json.ratings.size());
    assertTrue(json.ratingsIsSet);
  }

  /**
   * Test Json {@link Json#setRatings(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link Json} (default constructor) {@link Json#ratings} Empty.
   * </ul>
   *
   * <p>Method under test: {@link Json#setRatings(List)}
   */
  @Test
  @DisplayName(
      "Test Json setRatings(List); when ArrayList(); then Json (default constructor) ratings Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link Json} (default constructor) {@link Json#ratings} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Json#setRatings(List)}
   */
  @Test
  @DisplayName(
      "Test Json setRatings(List); when 'null'; then Json (default constructor) ratings is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

  /**
   * Test {@link ImmutableRatingScheme#toString()}.
   *
   * <p>Method under test: {@link ImmutableRatingScheme#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableRatingScheme.toString()"})
  void testToString() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");

    // Act and Assert
    assertEquals(
        "RatingScheme{id=1, name=Name, externalId=42, ratings=[]}",
        nameResult.addAllRatings(new ArrayList<>()).build().toString());
  }

  /**
   * Test {@link ImmutableRatingScheme#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableRatingScheme#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingScheme ImmutableRatingScheme.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme immutableRatingScheme =
        nameResult.addAllRatings(new ArrayList<>()).build();

    // Act
    ImmutableRatingScheme actualWithDescriptionResult = immutableRatingScheme.withDescription("42");

    // Assert
    assertEquals(immutableRatingScheme, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableRatingScheme#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableRatingScheme#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingScheme ImmutableRatingScheme.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder().description("42").externalId("42").id(1L).name("Name");
    ImmutableRatingScheme immutableRatingScheme =
        nameResult.addAllRatings(new ArrayList<>()).build();

    // Act
    ImmutableRatingScheme actualWithDescriptionResult = immutableRatingScheme.withDescription("42");

    // Assert
    assertSame(immutableRatingScheme, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableRatingScheme#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableRatingScheme#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingScheme ImmutableRatingScheme.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme immutableRatingScheme =
        nameResult.addAllRatings(new ArrayList<>()).build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableRatingScheme actualWithExternalIdResult =
        immutableRatingScheme.withExternalId(optional);

    // Assert
    assertSame(immutableRatingScheme, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableRatingScheme#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingScheme#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingScheme ImmutableRatingScheme.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_thenReturnName() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("External Id")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme immutableRatingScheme =
        nameResult.addAllRatings(new ArrayList<>()).build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableRatingScheme actualWithExternalIdResult =
        immutableRatingScheme.withExternalId(optional);

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertTrue(actualWithExternalIdResult.ratings().isEmpty());
  }

  /**
   * Test {@link ImmutableRatingScheme#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableRatingScheme#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingScheme ImmutableRatingScheme.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme immutableRatingScheme =
        nameResult.addAllRatings(new ArrayList<>()).build();

    // Act
    ImmutableRatingScheme actualWithExternalIdResult = immutableRatingScheme.withExternalId("42");

    // Assert
    assertSame(immutableRatingScheme, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableRatingScheme#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingScheme#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingScheme ImmutableRatingScheme.withExternalId(String)"})
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnName() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");

    // Act
    ImmutableRatingScheme actualWithExternalIdResult =
        nameResult.addAllRatings(new ArrayList<>()).build().withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertTrue(actualWithExternalIdResult.ratings().isEmpty());
  }

  /**
   * Test {@link ImmutableRatingScheme#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableRatingScheme#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingScheme ImmutableRatingScheme.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme immutableRatingScheme =
        nameResult.addAllRatings(new ArrayList<>()).build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableRatingScheme actualWithIdResult = immutableRatingScheme.withId(optional);

    // Assert
    assertSame(immutableRatingScheme, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableRatingScheme#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingScheme#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; when of forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingScheme ImmutableRatingScheme.withId(Optional)"})
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnName() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme immutableRatingScheme =
        nameResult.addAllRatings(new ArrayList<>()).build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableRatingScheme actualWithIdResult = immutableRatingScheme.withId(optional);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertTrue(actualWithIdResult.ratings().isEmpty());
  }

  /**
   * Test {@link ImmutableRatingScheme#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableRatingScheme#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingScheme ImmutableRatingScheme.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme immutableRatingScheme =
        nameResult.addAllRatings(new ArrayList<>()).build();

    // Act
    ImmutableRatingScheme actualWithIdResult = immutableRatingScheme.withId(1L);

    // Assert
    assertSame(immutableRatingScheme, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableRatingScheme#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingScheme#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingScheme ImmutableRatingScheme.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");

    // Act
    ImmutableRatingScheme actualWithIdResult =
        nameResult.addAllRatings(new ArrayList<>()).build().withId(42L);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertTrue(actualWithIdResult.ratings().isEmpty());
  }

  /**
   * Test {@link ImmutableRatingScheme#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableRatingScheme#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingScheme ImmutableRatingScheme.withName(String)"})
  void testWithName() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("42");
    ImmutableRatingScheme immutableRatingScheme =
        nameResult.addAllRatings(new ArrayList<>()).build();

    // Act
    ImmutableRatingScheme actualWithNameResult = immutableRatingScheme.withName("42");

    // Assert
    assertSame(immutableRatingScheme, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableRatingScheme#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingScheme#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingScheme ImmutableRatingScheme.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");

    // Act
    ImmutableRatingScheme actualWithNameResult =
        nameResult.addAllRatings(new ArrayList<>()).build().withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertTrue(actualWithNameResult.ratings().isEmpty());
  }

  /**
   * Test {@link ImmutableRatingScheme#withRatings(RatingSchemeItem[])} with {@code
   * RatingSchemeItem[]}.
   *
   * <p>Method under test: {@link ImmutableRatingScheme#withRatings(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test withRatings(RatingSchemeItem[]) with 'RatingSchemeItem[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingScheme ImmutableRatingScheme.withRatings(RatingSchemeItem[])"})
  void testWithRatingsWithRatingSchemeItem() {
    // Arrange
    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    ImmutableRatingScheme immutableRatingScheme =
        nameResult.addAllRatings(new ArrayList<>()).build();

    // Act
    ImmutableRatingScheme actualWithRatingsResult =
        immutableRatingScheme.withRatings(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    // Assert
    List<RatingSchemeItem> ratingsResult = actualWithRatingsResult.ratings();
    assertEquals(1, ratingsResult.size());
    RatingSchemeItem getResult = ratingsResult.get(0);
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", getResult.color());
    assertEquals("Name", getResult.name());
    assertEquals("Name", actualWithRatingsResult.name());
    assertEquals("Rating Group", getResult.ratingGroup());
    assertEquals("Rating", getResult.rating());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithRatingsResult.description());
    assertEquals(0, getResult.position());
    assertEquals(1L, getResult.ratingSchemeId());
    assertFalse(getResult.isRestricted());
    assertFalse(getResult.requiresComment());
    assertTrue(getResult.userSelectable());
  }
}
