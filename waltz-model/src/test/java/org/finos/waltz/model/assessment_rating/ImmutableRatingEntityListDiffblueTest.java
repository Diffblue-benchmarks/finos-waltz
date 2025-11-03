package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.assessment_rating.ImmutableRatingEntityList.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableRatingEntityList.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRatingEntityListDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllEntityReferences(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllEntityReferences(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllEntityReferences(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllEntityReferences(Iterable)"})
  void testBuilderAddAllEntityReferences_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingEntityList.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEntityReferences(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addEntityReferences(EntityReference)} with {@code element}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addEntityReferences(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder addEntityReferences(EntityReference) with 'element'; when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addEntityReferences(EntityReference)"})
  void testBuilderAddEntityReferencesWithElement_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingEntityList.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntityReferences(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#addEntityReferences(EntityReference[])} with {@code elements}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addEntityReferences(EntityReference[])}
   */
  @Test
  @DisplayName("Test Builder addEntityReferences(EntityReference[]) with 'elements'; when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addEntityReferences(EntityReference[])"})
  void testBuilderAddEntityReferencesWithElements_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingEntityList.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntityReferences(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#entityReferences(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReferences(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entityReferences(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReferences(Iterable)"})
  void testBuilderEntityReferences_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingEntityList.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReferences(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(RatingEntityList)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then builder build rating is {@code Rating}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RatingEntityList)}
   */
  @Test
  @DisplayName("Test Builder from(RatingEntityList); given HashSet(); then builder build rating is 'Rating'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RatingEntityList)"})
  void testBuilderFrom_givenHashSet_thenBuilderBuildRatingIsRating() {
    // Arrange
    Builder builderResult = ImmutableRatingEntityList.builder();
    RatingEntityList instance = mock(RatingEntityList.class);
    when(instance.entityReferences()).thenReturn(new HashSet<>());
    when(instance.rating()).thenReturn("Rating");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReferences();
    verify(instance).rating();
    assertEquals("Rating", builderResult.build().rating());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingEntityList)}.
   * <ul>
   *   <li>Then builder build entityReferences size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RatingEntityList)}
   */
  @Test
  @DisplayName("Test Builder from(RatingEntityList); then builder build entityReferences size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RatingEntityList)"})
  void testBuilderFrom_thenBuilderBuildEntityReferencesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableRatingEntityList.builder();

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    RatingEntityList instance = mock(RatingEntityList.class);
    when(instance.entityReferences()).thenReturn(entityReferenceSet);
    when(instance.rating()).thenReturn("Rating");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReferences();
    verify(instance).rating();
    ImmutableRatingEntityList buildResult = builderResult.build();
    assertEquals("Rating", buildResult.rating());
    assertEquals(1, buildResult.entityReferences().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingEntityList)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RatingEntityList)}
   */
  @Test
  @DisplayName("Test Builder from(RatingEntityList); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RatingEntityList)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRatingEntityList.builder();
    RatingEntityList instance = mock(RatingEntityList.class);
    when(instance.entityReferences()).thenThrow(new IllegalStateException("instance"));
    when(instance.rating()).thenReturn("Rating");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReferences();
    verify(instance).rating();
  }

  /**
   * Test Builder {@link Builder#rating(String)}.
   * <p>
   * Method under test: {@link Builder#rating(String)}
   */
  @Test
  @DisplayName("Test Builder rating(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rating(String)"})
  void testBuilderRating() {
    // Arrange
    Builder builderResult = ImmutableRatingEntityList.builder();

    // Act
    Builder actualRatingResult = builderResult.rating("Rating");

    // Assert
    assertEquals("Rating", builderResult.build().rating());
    assertSame(builderResult, actualRatingResult);
  }

  /**
   * Test Json {@link Json#entityReferences()}.
   * <p>
   * Method under test: {@link Json#entityReferences()}
   */
  @Test
  @DisplayName("Test Json entityReferences()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.entityReferences()"})
  void testJsonEntityReferences() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReferences());
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
    assertNull(actualJson.rating);
    assertTrue(actualJson.entityReferences.isEmpty());
  }

  /**
   * Test Json {@link Json#rating()}.
   * <p>
   * Method under test: {@link Json#rating()}
   */
  @Test
  @DisplayName("Test Json rating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rating());
  }
}
