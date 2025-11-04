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
import java.util.Optional;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.MandatoryDescriptionProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.PositionProvider;
import org.junit.jupiter.api.Test;

class ImmutableRatingSchemeItemDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableRatingSchemeItem#builder()}
   *   <li>{@link ImmutableRatingSchemeItem#externalId(String)}
   *   <li>{@link ImmutableRatingSchemeItem#ratingGroup(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableRatingSchemeItem.Builder actualExternalIdResult = ImmutableRatingSchemeItem.builder().externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableRatingSchemeItem.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableRatingSchemeItem.Builder actualIdResult2 = actualIdResult.id(id);

    // Assert
    assertSame(actualIdResult2, actualIdResult2.ratingGroup("Rating Group"));
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Builder#color(String)}
   */
  @Test
  void testBuilderColor() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.color("Color"));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#description(String)}
   */
  @Test
  void testBuilderDescription() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableRatingSchemeItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableRatingSchemeItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableRatingSchemeItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableRatingSchemeItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#from(MandatoryDescriptionProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();
    MandatoryDescriptionProvider instance = mock(MandatoryDescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableRatingSchemeItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#from(MandatoryDescriptionProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();
    MandatoryDescriptionProvider instance = mock(MandatoryDescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingSchemeItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#from(PositionProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();
    PositionProvider instance = mock(PositionProvider.class);
    when(instance.position()).thenReturn(1);

    // Act
    ImmutableRatingSchemeItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).position();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#from(PositionProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();
    PositionProvider instance = mock(PositionProvider.class);
    when(instance.position()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).position();
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#from(RatingSchemeItem)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();
    RatingSchemeItem instance = mock(RatingSchemeItem.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.isRestricted()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.rating()).thenReturn("Rating");
    when(instance.ratingGroup()).thenReturn("Rating Group");
    when(instance.color()).thenReturn("Color");
    when(instance.requiresComment()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.position()).thenReturn(1);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingSchemeItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).description();
    verify(instance).name();
    verify(instance).position();
    verify(instance).color();
    verify(instance).isRestricted();
    verify(instance).rating();
    verify(instance).ratingGroup();
    verify(instance).ratingSchemeId();
    verify(instance).requiresComment();
    verify(instance).userSelectable();
    ImmutableRatingSchemeItem buildResult = builderResult.build();
    assertEquals("Color", buildResult.color());
    assertEquals("Name", buildResult.name());
    assertEquals("Rating Group", buildResult.ratingGroup());
    assertEquals("Rating", buildResult.rating());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertTrue(buildResult.isRestricted());
    assertTrue(buildResult.requiresComment());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#from(RatingSchemeItem)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();
    RatingSchemeItem instance = mock(RatingSchemeItem.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.rating()).thenReturn("Rating");
    when(instance.ratingGroup()).thenReturn("Rating Group");
    when(instance.color()).thenReturn("Color");
    when(instance.requiresComment()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.position()).thenReturn(1);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).description();
    verify(instance).name();
    verify(instance).position();
    verify(instance).color();
    verify(instance).rating();
    verify(instance).ratingGroup();
    verify(instance).requiresComment();
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#from(RatingSchemeItem)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();
    RatingSchemeItem instance = mock(RatingSchemeItem.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.isRestricted()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.rating()).thenReturn("Rating");
    when(instance.ratingGroup()).thenReturn("Rating Group");
    when(instance.color()).thenReturn("Color");
    when(instance.requiresComment()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.position()).thenReturn(1);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingSchemeItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).description();
    verify(instance).name();
    verify(instance).position();
    verify(instance).color();
    verify(instance).isRestricted();
    verify(instance).rating();
    verify(instance).ratingGroup();
    verify(instance).ratingSchemeId();
    verify(instance).requiresComment();
    verify(instance).userSelectable();
    ImmutableRatingSchemeItem buildResult = builderResult.build();
    assertEquals("Color", buildResult.color());
    assertEquals("Name", buildResult.name());
    assertEquals("Rating Group", buildResult.ratingGroup());
    assertEquals("Rating", buildResult.rating());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertTrue(buildResult.isRestricted());
    assertTrue(buildResult.requiresComment());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#from(RatingSchemeItem)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();
    RatingSchemeItem instance = mock(RatingSchemeItem.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.isRestricted()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.rating()).thenReturn("Rating");
    when(instance.ratingGroup()).thenReturn("Rating Group");
    when(instance.color()).thenReturn("Color");
    when(instance.requiresComment()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.position()).thenReturn(1);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingSchemeItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).description();
    verify(instance).name();
    verify(instance).position();
    verify(instance).color();
    verify(instance).isRestricted();
    verify(instance).rating();
    verify(instance).ratingGroup();
    verify(instance).ratingSchemeId();
    verify(instance).requiresComment();
    verify(instance).userSelectable();
    ImmutableRatingSchemeItem buildResult = builderResult.build();
    assertEquals("Color", buildResult.color());
    assertEquals("Name", buildResult.name());
    assertEquals("Rating Group", buildResult.ratingGroup());
    assertEquals("Rating", buildResult.rating());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertTrue(buildResult.isRestricted());
    assertTrue(buildResult.requiresComment());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#from(RatingSchemeItem)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();
    RatingSchemeItem instance = mock(RatingSchemeItem.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.isRestricted()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.rating()).thenReturn("Rating");
    when(instance.ratingGroup()).thenReturn(null);
    when(instance.color()).thenReturn("Color");
    when(instance.requiresComment()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.position()).thenReturn(1);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingSchemeItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).description();
    verify(instance).name();
    verify(instance).position();
    verify(instance).color();
    verify(instance).isRestricted();
    verify(instance).rating();
    verify(instance).ratingGroup();
    verify(instance).ratingSchemeId();
    verify(instance).requiresComment();
    verify(instance).userSelectable();
    ImmutableRatingSchemeItem buildResult = builderResult.build();
    assertEquals("Color", buildResult.color());
    assertEquals("Name", buildResult.name());
    assertEquals("Rating", buildResult.rating());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.ratingGroup());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertTrue(buildResult.isRestricted());
    assertTrue(buildResult.requiresComment());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#isRestricted(boolean)}
   */
  @Test
  void testBuilderIsRestricted() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRestricted(true));
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Builder#rating(String)}
   */
  @Test
  void testBuilderRating() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rating("Rating"));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#ratingSchemeId(long)}
   */
  @Test
  void testBuilderRatingSchemeId() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#requiresComment(boolean)}
   */
  @Test
  void testBuilderRequiresComment() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.requiresComment(true));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Builder#userSelectable(boolean)}
   */
  @Test
  void testBuilderUserSelectable() {
    // Arrange
    ImmutableRatingSchemeItem.Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userSelectable(true));
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem#copyOf(RatingSchemeItem)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    RatingSchemeItem instance = mock(RatingSchemeItem.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.isRestricted()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.rating()).thenReturn("Rating");
    when(instance.ratingGroup()).thenReturn("Rating Group");
    when(instance.color()).thenReturn("Color");
    when(instance.requiresComment()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.position()).thenReturn(1);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingSchemeItem actualCopyOfResult = ImmutableRatingSchemeItem.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).description();
    verify(instance).name();
    verify(instance).position();
    verify(instance).color();
    verify(instance).isRestricted();
    verify(instance).rating();
    verify(instance).ratingGroup();
    verify(instance).ratingSchemeId();
    verify(instance).requiresComment();
    verify(instance).userSelectable();
    assertEquals("Color", actualCopyOfResult.color());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Rating Group", actualCopyOfResult.ratingGroup());
    assertEquals("Rating", actualCopyOfResult.rating());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertTrue(actualCopyOfResult.isRestricted());
    assertTrue(actualCopyOfResult.requiresComment());
    assertTrue(actualCopyOfResult.userSelectable());
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem#copyOf(RatingSchemeItem)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    RatingSchemeItem instance = mock(RatingSchemeItem.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.isRestricted()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.rating()).thenReturn("Rating");
    when(instance.ratingGroup()).thenReturn("Rating Group");
    when(instance.color()).thenReturn("Color");
    when(instance.requiresComment()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.position()).thenReturn(1);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingSchemeItem actualCopyOfResult = ImmutableRatingSchemeItem.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).description();
    verify(instance).name();
    verify(instance).position();
    verify(instance).color();
    verify(instance).isRestricted();
    verify(instance).rating();
    verify(instance).ratingGroup();
    verify(instance).ratingSchemeId();
    verify(instance).requiresComment();
    verify(instance).userSelectable();
    assertEquals("Color", actualCopyOfResult.color());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Rating Group", actualCopyOfResult.ratingGroup());
    assertEquals("Rating", actualCopyOfResult.rating());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertTrue(actualCopyOfResult.isRestricted());
    assertTrue(actualCopyOfResult.requiresComment());
    assertTrue(actualCopyOfResult.userSelectable());
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem#copyOf(RatingSchemeItem)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    RatingSchemeItem instance = mock(RatingSchemeItem.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.isRestricted()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.rating()).thenReturn("Rating");
    when(instance.ratingGroup()).thenReturn("Rating Group");
    when(instance.color()).thenReturn("Color");
    when(instance.requiresComment()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.position()).thenReturn(1);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingSchemeItem actualCopyOfResult = ImmutableRatingSchemeItem.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).description();
    verify(instance).name();
    verify(instance).position();
    verify(instance).color();
    verify(instance).isRestricted();
    verify(instance).rating();
    verify(instance).ratingGroup();
    verify(instance).ratingSchemeId();
    verify(instance).requiresComment();
    verify(instance).userSelectable();
    assertEquals("Color", actualCopyOfResult.color());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Rating Group", actualCopyOfResult.ratingGroup());
    assertEquals("Rating", actualCopyOfResult.rating());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertTrue(actualCopyOfResult.isRestricted());
    assertTrue(actualCopyOfResult.requiresComment());
    assertTrue(actualCopyOfResult.userSelectable());
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem#copyOf(RatingSchemeItem)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    RatingSchemeItem instance = mock(RatingSchemeItem.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.isRestricted()).thenReturn(false);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.rating()).thenReturn("Rating");
    when(instance.ratingGroup()).thenReturn("Rating Group");
    when(instance.color()).thenReturn("Color");
    when(instance.requiresComment()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.position()).thenReturn(1);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingSchemeItem actualCopyOfResult = ImmutableRatingSchemeItem.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).description();
    verify(instance).name();
    verify(instance).position();
    verify(instance).color();
    verify(instance).isRestricted();
    verify(instance).rating();
    verify(instance).ratingGroup();
    verify(instance).ratingSchemeId();
    verify(instance).requiresComment();
    verify(instance).userSelectable();
    assertEquals("Color", actualCopyOfResult.color());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Rating Group", actualCopyOfResult.ratingGroup());
    assertEquals("Rating", actualCopyOfResult.rating());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertFalse(actualCopyOfResult.isRestricted());
    assertTrue(actualCopyOfResult.requiresComment());
    assertTrue(actualCopyOfResult.userSelectable());
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Json#color()}
   */
  @Test
  void testJsonColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingSchemeItem.Json()).color());
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingSchemeItem.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingSchemeItem.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingSchemeItem.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Json#isRestricted()}
   */
  @Test
  void testJsonIsRestricted() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingSchemeItem.Json()).isRestricted());
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingSchemeItem.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableRatingSchemeItem.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableRatingSchemeItem.Json actualJson = new ImmutableRatingSchemeItem.Json();

    // Assert
    assertNull(actualJson.color);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.rating);
    assertNull(actualJson.ratingGroup);
    assertEquals(0, actualJson.position);
    assertEquals(0L, actualJson.ratingSchemeId);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isRestricted);
    assertFalse(actualJson.isRestrictedIsSet);
    assertFalse(actualJson.positionIsSet);
    assertFalse(actualJson.ratingSchemeIdIsSet);
    assertFalse(actualJson.requiresComment);
    assertFalse(actualJson.requiresCommentIsSet);
    assertFalse(actualJson.userSelectable);
    assertFalse(actualJson.userSelectableIsSet);
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingSchemeItem.Json()).position());
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Json#rating()}
   */
  @Test
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingSchemeItem.Json()).rating());
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Json#ratingGroup()}
   */
  @Test
  void testJsonRatingGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingSchemeItem.Json()).ratingGroup());
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Json#ratingSchemeId()}
   */
  @Test
  void testJsonRatingSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingSchemeItem.Json()).ratingSchemeId());
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Json#requiresComment()}
   */
  @Test
  void testJsonRequiresComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingSchemeItem.Json()).requiresComment());
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Json#setIsRestricted(boolean)}
   */
  @Test
  void testJsonSetIsRestricted() {
    // Arrange
    ImmutableRatingSchemeItem.Json json = new ImmutableRatingSchemeItem.Json();

    // Act
    json.setIsRestricted(true);

    // Assert
    assertTrue(json.isRestricted);
    assertTrue(json.isRestrictedIsSet);
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutableRatingSchemeItem.Json json = new ImmutableRatingSchemeItem.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Json#setRatingSchemeId(long)}
   */
  @Test
  void testJsonSetRatingSchemeId() {
    // Arrange
    ImmutableRatingSchemeItem.Json json = new ImmutableRatingSchemeItem.Json();

    // Act
    json.setRatingSchemeId(1L);

    // Assert
    assertEquals(1L, json.ratingSchemeId);
    assertTrue(json.ratingSchemeIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Json#setRequiresComment(boolean)}
   */
  @Test
  void testJsonSetRequiresComment() {
    // Arrange
    ImmutableRatingSchemeItem.Json json = new ImmutableRatingSchemeItem.Json();

    // Act
    json.setRequiresComment(true);

    // Assert
    assertTrue(json.requiresComment);
    assertTrue(json.requiresCommentIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItem.Json#setUserSelectable(boolean)}
   */
  @Test
  void testJsonSetUserSelectable() {
    // Arrange
    ImmutableRatingSchemeItem.Json json = new ImmutableRatingSchemeItem.Json();

    // Act
    json.setUserSelectable(true);

    // Assert
    assertTrue(json.userSelectable);
    assertTrue(json.userSelectableIsSet);
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItem.Json#userSelectable()}
   */
  @Test
  void testJsonUserSelectable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingSchemeItem.Json()).userSelectable());
  }
}
