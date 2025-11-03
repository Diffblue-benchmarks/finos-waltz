package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

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
import org.finos.waltz.model.bulk_upload.ResolutionStatus;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentCellRating.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentCellRating.Json;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentCellRatingDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllErrors(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllErrors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllErrors(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllErrors(Iterable)"})
  void testBuilderAddAllErrors_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllErrors(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addErrors(RatingResolutionError)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableRatingResolutionError.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addErrors(RatingResolutionError)}
   */
  @Test
  @DisplayName("Test Builder addErrors(RatingResolutionError) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addErrors(RatingResolutionError)"})
  void testBuilderAddErrorsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(new ImmutableRatingResolutionError.Json()));
  }

  /**
   * Test Builder {@link Builder#addErrors(RatingResolutionError[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableRatingResolutionError.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addErrors(RatingResolutionError[])}
   */
  @Test
  @DisplayName("Test Builder addErrors(RatingResolutionError[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addErrors(RatingResolutionError[])"})
  void testBuilderAddErrorsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(new ImmutableRatingResolutionError.Json()));
  }

  /**
   * Test Builder {@link Builder#comment(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#comment(Optional)}
   */
  @Test
  @DisplayName("Test Builder comment(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.comment(Optional)"})
  void testBuilderCommentWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();
    Optional<String> comment = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.comment(comment));
  }

  /**
   * Test Builder {@link Builder#errors(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#errors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder errors(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.errors(Iterable)"})
  void testBuilderErrors_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.errors(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(AssessmentCellRating)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link AssessmentCellRating} {@link AssessmentCellRating#comment()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentCellRating)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentCellRating); given empty; when AssessmentCellRating comment() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentCellRating)"})
  void testBuilderFrom_givenEmpty_whenAssessmentCellRatingCommentReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();
    AssessmentCellRating instance = mock(AssessmentCellRating.class);
    when(instance.errors()).thenReturn(new HashSet<>());
    Optional<String> emptyResult = Optional.empty();
    when(instance.comment()).thenReturn(emptyResult);
    Optional<RatingSchemeItem> ofResult = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).resolvedRating();
    verify(instance).status();
    assertEquals(ResolutionStatus.NEW, builderResult.build().status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentCellRating)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link AssessmentCellRating} {@link AssessmentCellRating#resolvedRating()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentCellRating)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentCellRating); given empty; when AssessmentCellRating resolvedRating() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentCellRating)"})
  void testBuilderFrom_givenEmpty_whenAssessmentCellRatingResolvedRatingReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();
    AssessmentCellRating instance = mock(AssessmentCellRating.class);
    when(instance.errors()).thenReturn(new HashSet<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    Optional<RatingSchemeItem> emptyResult = Optional.empty();
    when(instance.resolvedRating()).thenReturn(emptyResult);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).resolvedRating();
    verify(instance).status();
    assertEquals(ResolutionStatus.NEW, builderResult.build().status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentCellRating)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableRatingResolutionError.Json} (default constructor).</li>
   *   <li>Then builder build errors size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentCellRating)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentCellRating); given HashSet() add Json (default constructor); then builder build errors size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentCellRating)"})
  void testBuilderFrom_givenHashSetAddJson_thenBuilderBuildErrorsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();

    HashSet<RatingResolutionError> ratingResolutionErrorSet = new HashSet<>();
    ratingResolutionErrorSet.add(new ImmutableRatingResolutionError.Json());
    AssessmentCellRating instance = mock(AssessmentCellRating.class);
    when(instance.errors()).thenReturn(ratingResolutionErrorSet);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    Optional<RatingSchemeItem> ofResult2 = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult2);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).resolvedRating();
    verify(instance).status();
    ImmutableAssessmentCellRating buildResult = builderResult.build();
    assertEquals(1, buildResult.errors().size());
    assertEquals(ResolutionStatus.NEW, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentCellRating)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then builder build status is {@code NEW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentCellRating)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentCellRating); given HashSet(); then builder build status is 'NEW'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentCellRating)"})
  void testBuilderFrom_givenHashSet_thenBuilderBuildStatusIsNew() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();
    AssessmentCellRating instance = mock(AssessmentCellRating.class);
    when(instance.errors()).thenReturn(new HashSet<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    Optional<RatingSchemeItem> ofResult2 = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult2);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).resolvedRating();
    verify(instance).status();
    assertEquals(ResolutionStatus.NEW, builderResult.build().status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentCellRating)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentCellRating)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentCellRating); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentCellRating)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();
    AssessmentCellRating instance = mock(AssessmentCellRating.class);
    when(instance.errors()).thenThrow(new IllegalStateException("instance"));
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    Optional<RatingSchemeItem> ofResult2 = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult2);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).resolvedRating();
    verify(instance).status();
  }

  /**
   * Test Builder {@link Builder#resolvedRating(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#resolvedRating(Optional)}
   */
  @Test
  @DisplayName("Test Builder resolvedRating(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.resolvedRating(Optional)"})
  void testBuilderResolvedRatingWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.resolvedRating(resolvedRating));
  }

  /**
   * Test Builder {@link Builder#status(ResolutionStatus)}.
   * <p>
   * Method under test: {@link Builder#status(ResolutionStatus)}
   */
  @Test
  @DisplayName("Test Builder status(ResolutionStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.status(ResolutionStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();

    // Act
    Builder actualStatusResult = builderResult.status(ResolutionStatus.NEW);

    // Assert
    assertEquals(ResolutionStatus.NEW, builderResult.build().status());
    assertSame(builderResult, actualStatusResult);
  }

  /**
   * Test Json {@link Json#comment()}.
   * <p>
   * Method under test: {@link Json#comment()}
   */
  @Test
  @DisplayName("Test Json comment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.comment()"})
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).comment());
  }

  /**
   * Test Json {@link Json#errors()}.
   * <p>
   * Method under test: {@link Json#errors()}
   */
  @Test
  @DisplayName("Test Json errors()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.errors()"})
  void testJsonErrors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).errors());
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
    assertNull(actualJson.status);
    assertFalse(actualJson.comment.isPresent());
    assertFalse(actualJson.resolvedRating.isPresent());
    assertTrue(actualJson.errors.isEmpty());
  }

  /**
   * Test Json {@link Json#resolvedRating()}.
   * <p>
   * Method under test: {@link Json#resolvedRating()}
   */
  @Test
  @DisplayName("Test Json resolvedRating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.resolvedRating()"})
  void testJsonResolvedRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).resolvedRating());
  }

  /**
   * Test Json {@link Json#status()}.
   * <p>
   * Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResolutionStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).status());
  }
}
