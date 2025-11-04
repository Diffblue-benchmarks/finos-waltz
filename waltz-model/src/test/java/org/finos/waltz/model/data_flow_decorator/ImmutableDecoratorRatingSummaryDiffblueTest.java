package org.finos.waltz.model.data_flow_decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.junit.jupiter.api.Test;

class ImmutableDecoratorRatingSummaryDiffblueTest {
  /**
   * Method under test: {@link ImmutableDecoratorRatingSummary.Builder#count(int)}
   */
  @Test
  void testBuilderCount() {
    // Arrange
    ImmutableDecoratorRatingSummary.Builder builderResult = ImmutableDecoratorRatingSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3));
  }

  /**
   * Method under test:
   * {@link ImmutableDecoratorRatingSummary.Builder#decoratorEntityReference(EntityReference)}
   */
  @Test
  void testBuilderDecoratorEntityReference() {
    // Arrange
    ImmutableDecoratorRatingSummary.Builder builderResult = ImmutableDecoratorRatingSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.decoratorEntityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableDecoratorRatingSummary.Builder#from(DecoratorRatingSummary)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDecoratorRatingSummary.Builder builderResult = ImmutableDecoratorRatingSummary.builder();
    DecoratorRatingSummary instance = mock(DecoratorRatingSummary.class);
    when(instance.count()).thenReturn(3);
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");
    when(instance.rating()).thenReturn(ofResult);
    when(instance.decoratorEntityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableDecoratorRatingSummary.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).decoratorEntityReference();
    verify(instance).rating();
    ImmutableDecoratorRatingSummary buildResult = builderResult.build();
    assertEquals(3, buildResult.count());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult, buildResult.rating());
  }

  /**
   * Method under test:
   * {@link ImmutableDecoratorRatingSummary.Builder#from(DecoratorRatingSummary)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDecoratorRatingSummary.Builder builderResult = ImmutableDecoratorRatingSummary.builder();
    DecoratorRatingSummary instance = mock(DecoratorRatingSummary.class);
    when(instance.count()).thenThrow(new IllegalStateException("instance"));
    when(instance.rating()).thenReturn(AuthoritativenessRatingValue.of("42"));
    when(instance.decoratorEntityReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).count();
    verify(instance).decoratorEntityReference();
    verify(instance).rating();
  }

  /**
   * Method under test:
   * {@link ImmutableDecoratorRatingSummary.Builder#rating(AuthoritativenessRatingValue)}
   */
  @Test
  void testBuilderRating() {
    // Arrange
    ImmutableDecoratorRatingSummary.Builder builderResult = ImmutableDecoratorRatingSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rating(AuthoritativenessRatingValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutableDecoratorRatingSummary#copyOf(DecoratorRatingSummary)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    DecoratorRatingSummary instance = mock(DecoratorRatingSummary.class);
    when(instance.count()).thenReturn(3);
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");
    when(instance.rating()).thenReturn(ofResult);
    when(instance.decoratorEntityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableDecoratorRatingSummary actualCopyOfResult = ImmutableDecoratorRatingSummary.copyOf(instance);

    // Assert
    verify(instance).count();
    verify(instance).decoratorEntityReference();
    verify(instance).rating();
    AuthoritativenessRatingValue ratingResult = actualCopyOfResult.rating();
    assertEquals("42", ratingResult.value());
    assertEquals(3, actualCopyOfResult.count());
    assertSame(ofResult, ratingResult);
  }

  /**
   * Method under test: {@link ImmutableDecoratorRatingSummary.Json#count()}
   */
  @Test
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDecoratorRatingSummary.Json()).count());
  }

  /**
   * Method under test:
   * {@link ImmutableDecoratorRatingSummary.Json#decoratorEntityReference()}
   */
  @Test
  void testJsonDecoratorEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDecoratorRatingSummary.Json()).decoratorEntityReference());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableDecoratorRatingSummary.Json}
   *   <li>
   * {@link ImmutableDecoratorRatingSummary.Json#setDecoratorEntityReference(EntityReference)}
   *   <li>
   * {@link ImmutableDecoratorRatingSummary.Json#setRating(AuthoritativenessRatingValue)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableDecoratorRatingSummary.Json actualJson = new ImmutableDecoratorRatingSummary.Json();
    actualJson.setDecoratorEntityReference(null);
    actualJson.setRating(AuthoritativenessRatingValue.of("42"));

    // Assert
    assertEquals("42", actualJson.rating.value());
  }

  /**
   * Method under test: {@link ImmutableDecoratorRatingSummary.Json#rating()}
   */
  @Test
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDecoratorRatingSummary.Json()).rating());
  }

  /**
   * Method under test: {@link ImmutableDecoratorRatingSummary.Json#setCount(int)}
   */
  @Test
  void testJsonSetCount() {
    // Arrange
    ImmutableDecoratorRatingSummary.Json json = new ImmutableDecoratorRatingSummary.Json();

    // Act
    json.setCount(3);

    // Assert
    assertEquals(3, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Method under test: {@link ImmutableDecoratorRatingSummary.Json#setCount(int)}
   */
  @Test
  void testJsonSetCount2() {
    // Arrange
    ImmutableDecoratorRatingSummary.Json json = new ImmutableDecoratorRatingSummary.Json();
    json.setDecoratorEntityReference(mock(EntityReference.class));

    // Act
    json.setCount(3);

    // Assert
    assertEquals(3, json.count);
    assertTrue(json.countIsSet);
  }
}
